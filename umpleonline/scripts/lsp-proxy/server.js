"use strict";

const { WebSocketServer } = require("ws");
const http = require("http");
const { spawn } = require("child_process");
const path = require("path");
const fs = require("fs");
const crypto = require("crypto");
const url = require("url");

// ---------------------------------------------------------------------------
// Configuration (from environment variables with defaults)
// ---------------------------------------------------------------------------
const LSP_PORT = parseInt(process.env.LSP_PORT || "9999", 10);
const LSP_HOST = process.env.LSP_HOST || "127.0.0.1";
const UMP_BASE_DIR = process.env.UMP_BASE_DIR || "/var/www/ump";
const LSP_COMMAND = process.env.LSP_COMMAND || "umple-lsp-server";
const UMPLESYNC_JAR_PATH = process.env.UMPLESYNC_JAR_PATH || "";
const AUTH_SECRET = process.env.LSP_AUTH_SECRET || "";
const LSP_DEBUG = process.env.LSP_DEBUG === "1";

// Process limits
const MAX_PROCESSES_GLOBAL = parseInt(process.env.LSP_MAX_PROCESSES || "20", 10);

// Session ID validation
const SESSION_ID_RE = /^[a-zA-Z0-9_-]+$/;

// ---------------------------------------------------------------------------
// Active sessions: one WebSocket + one LSP process per model
// ---------------------------------------------------------------------------
// Key: modelId, Value: { process, framer, ws, cleanedUp }
const activeSessions = new Map();

function log(msg) {
  console.log(`[lsp-proxy] ${new Date().toISOString()} ${msg}`);
}

function warn(msg) {
  console.warn(`[lsp-proxy] ${new Date().toISOString()} WARN: ${msg}`);
}

// ---------------------------------------------------------------------------
// Auth token validation
// ---------------------------------------------------------------------------
// Token format: base64url(modelId:mode:expiry:hmac_hex)

function validateToken(token, modelId) {
  if (!AUTH_SECRET) {
    // No secret configured — reject all connections (fail closed)
    // Set LSP_AUTH_SECRET to enable LSP, or set LSP_DEV_AUTH=1 for local dev
    if (process.env.LSP_DEV_AUTH === "1") {
      return { valid: true, mode: "editable" };
    }
    warn("LSP_AUTH_SECRET not set and LSP_DEV_AUTH not enabled — rejecting connection");
    return { valid: false };
  }

  try {
    const decoded = Buffer.from(token, "base64url").toString("utf-8");
    const parts = decoded.split(":");
    if (parts.length < 4) return { valid: false };

    const [tokenModel, mode, expiryStr, sig] = [
      parts[0],
      parts[1],
      parts[2],
      parts.slice(3).join(":"),
    ];

    if (tokenModel !== modelId) return { valid: false };

    const expiry = parseInt(expiryStr, 10);
    if (Date.now() > expiry) return { valid: false };

    const payload = `${tokenModel}:${mode}:${expiryStr}`;
    const expected = crypto
      .createHmac("sha256", AUTH_SECRET)
      .update(payload)
      .digest("hex");

    if (!crypto.timingSafeEqual(Buffer.from(sig), Buffer.from(expected))) {
      return { valid: false };
    }

    return { valid: true, mode };
  } catch {
    return { valid: false };
  }
}

// ---------------------------------------------------------------------------
// Path validation
// ---------------------------------------------------------------------------

function resolveModelDir(modelId) {
  const candidate = path.join(UMP_BASE_DIR, modelId);
  if (!fs.existsSync(candidate)) return null;

  const resolved = fs.realpathSync(candidate);
  const base = fs.realpathSync(UMP_BASE_DIR);

  if (!resolved.startsWith(base + path.sep) && resolved !== base) {
    return null;
  }
  return resolved;
}

// ---------------------------------------------------------------------------
// LSP stdio framing
// ---------------------------------------------------------------------------

function createLspFramer() {
  let buffer = Buffer.alloc(0);

  return {
    feed(data) {
      buffer = Buffer.concat([buffer, data]);
      const messages = [];

      while (true) {
        const headerEnd = buffer.indexOf("\r\n\r\n");
        if (headerEnd === -1) break;

        const header = buffer.slice(0, headerEnd).toString("ascii");
        const match = header.match(/Content-Length:\s*(\d+)/i);
        if (!match) {
          buffer = buffer.slice(headerEnd + 4);
          continue;
        }

        const contentLength = parseInt(match[1], 10);
        const bodyStart = headerEnd + 4;
        const messageEnd = bodyStart + contentLength;

        if (buffer.length < messageEnd) break;

        const body = buffer.slice(bodyStart, messageEnd).toString("utf-8");
        messages.push(body);
        buffer = buffer.slice(messageEnd);
      }

      return messages;
    },

    frame(json) {
      const content = Buffer.from(json, "utf-8");
      return `Content-Length: ${content.length}\r\n\r\n${json}`;
    },
  };
}

// ---------------------------------------------------------------------------
// Session lifecycle: spawn process, wire socket, kill on disconnect
// ---------------------------------------------------------------------------

function killSession(modelId, reason) {
  const entry = activeSessions.get(modelId);
  if (!entry || entry.cleanedUp) return;
  entry.cleanedUp = true;

  log(`Killing session for model=${modelId}: ${reason}`);

  // Kill LSP process — entry stays in map until process actually exits
  try {
    entry.process.kill("SIGTERM");
  } catch {
    // Already dead — remove immediately since exit handler won't fire
    activeSessions.delete(modelId);
  }

  // Close WebSocket if still open
  if (entry.ws && entry.ws.readyState <= 1) {
    entry.ws.close(4006, reason);
  }
  // Do NOT delete from activeSessions here — the process exit handler does that
}

// ---------------------------------------------------------------------------
// WebSocket server
// ---------------------------------------------------------------------------

const server = http.createServer((req, res) => {
  if (req.url === "/healthcheck") {
    const uptime = process.uptime();
    const sessions = [];
    for (const [key, entry] of activeSessions) {
      sessions.push({ key, pid: entry.process.pid, cleanedUp: entry.cleanedUp });
    }
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify({
      status: "ok",
      uptime: Math.floor(uptime),
      activeSessions: sessions.length,
      sessions,
      umpBaseDir: UMP_BASE_DIR,
      lspCommand: LSP_COMMAND,
    }));
    return;
  }
  res.writeHead(404);
  res.end();
});

const wss = new WebSocketServer({ server });

server.listen(LSP_PORT, LSP_HOST, () => {
  log(`WebSocket server listening on ${LSP_HOST}:${LSP_PORT}`);
  log(`Health check at http://${LSP_HOST}:${LSP_PORT}/healthcheck`);
});

wss.on("connection", (ws, req) => {
  const params = new url.URL(req.url, "http://localhost").searchParams;
  const modelId = params.get("session") || "";
  const token = params.get("token") || "";

  // Validate session ID format
  if (!SESSION_ID_RE.test(modelId)) {
    warn(`Invalid session ID: ${modelId}`);
    ws.close(4001, "Invalid session ID");
    return;
  }

  // Validate auth token
  const auth = validateToken(token, modelId);
  if (!auth.valid) {
    warn(`Invalid auth token for model=${modelId}`);
    ws.close(4003, "Invalid auth token");
    return;
  }

  // Reject non-editable mode
  if (auth.mode !== "editable") {
    warn(`Read-only token rejected for model=${modelId}`);
    ws.close(4007, "LSP not available in read-only mode");
    return;
  }

  // Resolve and validate model directory
  let modelDir;
  try {
    modelDir = resolveModelDir(modelId);
  } catch {
    modelDir = null;
  }
  if (!modelDir) {
    warn(`Model directory not found or path traversal: ${modelId}`);
    ws.close(4002, "Model directory not found");
    return;
  }

  // One client per model — reject if already active
  if (activeSessions.has(modelId)) {
    warn(`Concurrent connection rejected for model=${modelId}`);
    ws.close(4004, "Model already has an active LSP connection");
    return;
  }

  // Check global process limit
  if (activeSessions.size >= MAX_PROCESSES_GLOBAL) {
    warn(`Global process limit reached (${MAX_PROCESSES_GLOBAL})`);
    ws.close(4005, "Server capacity reached");
    return;
  }

  // Spawn fresh LSP process
  const env = Object.assign({}, process.env, {
    UMPLE_SESSION_DIR: modelDir,
  });
  if (UMPLESYNC_JAR_PATH) {
    env.UMPLESYNC_JAR_PATH = UMPLESYNC_JAR_PATH;
  }

  // Split LSP_COMMAND into executable + args to support overrides like
  // "node /mnt/lsp/packages/server/out/server.js" without shell:true
  const cmdParts = LSP_COMMAND.split(/\s+/);
  const lspExe = cmdParts[0];
  const lspArgs = [...cmdParts.slice(1), "--stdio"];

  const lspProcess = spawn(lspExe, lspArgs, {
    stdio: ["pipe", "pipe", "pipe"],
    env,
  });

  const framer = createLspFramer();
  const entry = {
    process: lspProcess,
    framer,
    ws,
    cleanedUp: false,
  };

  activeSessions.set(modelId, entry);
  log(`Session started for model=${modelId} (pid=${lspProcess.pid})`);

  // LSP stdout → WebSocket
  lspProcess.stdout.on("data", (data) => {
    const messages = framer.feed(data);
    for (const msg of messages) {
      if (LSP_DEBUG) {
        try {
          const parsed = JSON.parse(msg);
          log(`[lsp→client:${modelId}] ${parsed.method || `response:${parsed.id}`}`);
        } catch { /* ignore */ }
      }
      if (entry.ws && entry.ws.readyState === entry.ws.OPEN) {
        entry.ws.send(msg);
      }
    }
  });

  // Log LSP stderr
  lspProcess.stderr.on("data", (data) => {
    const lines = data.toString().split("\n").filter(Boolean);
    for (const line of lines) {
      log(`[lsp:${modelId}] ${line}`);
    }
  });

  // LSP process death → kill session + remove from map
  lspProcess.on("exit", (code, signal) => {
    log(`LSP process exited for model=${modelId} (code=${code}, signal=${signal})`);
    killSession(modelId, "LSP process exited");
    activeSessions.delete(modelId); // Slot freed only after process is truly gone
  });

  lspProcess.on("error", (err) => {
    warn(`LSP process error for model=${modelId}: ${err.message}`);
    killSession(modelId, "LSP process error");
    activeSessions.delete(modelId); // Slot freed only after process is truly gone
  });

  // WebSocket → LSP stdin
  let socketCleanedUp = false;

  ws.on("message", (data) => {
    const json = data.toString();
    try {
      if (LSP_DEBUG) {
        const parsed = JSON.parse(json);
        log(`[client→lsp:${modelId}] ${parsed.method || `response:${parsed.id}`}`);
      } else {
        JSON.parse(json); // Validate only
      }
      const framed = entry.framer.frame(json);
      if (entry.process.stdin.writable) {
        entry.process.stdin.write(framed);
      }
    } catch (e) {
      warn(`Invalid JSON from client: ${e.message}`);
    }
  });

  function onSocketDone(reason) {
    if (socketCleanedUp) return;
    socketCleanedUp = true;
    log(`Socket closed for model=${modelId}: ${reason}`);
    killSession(modelId, "client disconnected");
  }

  ws.on("close", () => onSocketDone("close"));
  ws.on("error", (err) => {
    warn(`WebSocket error for model=${modelId}: ${err.message}`);
    onSocketDone("error");
  });
});

wss.on("error", (err) => {
  warn(`WebSocket server error: ${err.message}`);
});

// ---------------------------------------------------------------------------
// Graceful shutdown
// ---------------------------------------------------------------------------

function shutdown(signal) {
  log(`${signal} received — shutting down`);
  wss.close();
  for (const [modelId] of activeSessions) {
    killSession(modelId, signal);
  }
  process.exit(0);
}

process.on("SIGTERM", () => shutdown("SIGTERM"));
process.on("SIGINT", () => shutdown("SIGINT"));
