# UmpleOnline

The web-based editor and compiler for the [Umple](https://umple.org) modeling language.

**Live:** https://try.umple.org
**Docker:** https://hub.docker.com/r/umple/umpleonline

## LSP Editor Features

UmpleOnline includes Language Server Protocol support, providing:
- Real-time diagnostics (error underlines as you type)
- Go-to-definition (`F12`)
- Find references (`Shift-F12`)
- Rename symbol (`F2`)
- Hover information
- Completion
- Right-click context menu with keybinding hints

### Configuration

All repo-owned LSP settings live in one file: `umpleonline/config/lsp.ini`. If missing, create it from `lsp.ini.template`.

| Setting | Description |
|---------|-------------|
| `standaloneUmpBaseDir` | Path to session files. Relative paths resolved from repo root. |
| `standaloneHostPort` | Host port for the standalone LSP container. |
| `standaloneContainerName` | Docker container and image name for standalone mode. |
| `maxProcesses` | Maximum concurrent LSP server processes per proxy. |
| `localBrowserHost` | Loopback address for local dev (e.g., `127.0.0.1`). |
| `useLinkedLsp` | Set `true` to build with a locally npm-linked `umple-lsp-server`. |

Deployment-only settings are env vars, not in `lsp.ini`:

| Env var | Set by | Description |
|---------|--------|-------------|
| `UMPLE_LSP_WS_URL` | Docker / nginx | Browser WebSocket path. Docker sets `/lsp`. For nginx, set via `fastcgi_param`. |
| `LSP_AUTH_SECRET` | Docker / nginx | HMAC key for token auth. Empty = dev mode (when `LSP_DEV_AUTH=1`). |
| `LSP_DEV_AUTH` | Docker | Skip auth when `1`. Set `0` with a real `LSP_AUTH_SECRET` for production. |

Config precedence: **env var > lsp.ini > disabled (fail closed)**.

### Deployment modes

#### A. Local development (pumple + php -S)

The standard local workflow. LSP runs in a standalone Docker container.

```bash
dev-tools/pumple
cd umpleonline
php -S localhost:8001
# Open http://localhost:8001/umple.php
```

Config source: `umpleonline/config/lsp.ini` (read by both `setup.sh` and `umple.php`).
Browser connects to: `ws://127.0.0.1:<standaloneHostPort>` (built from `lsp.ini`).

**Verify:**
- Browser console: `window.UMPLE_LSP_WS_URL` shows `ws://<localBrowserHost>:<standaloneHostPort>`
- `docker ps` shows `my<standaloneContainerName>` running
- Hover over a class name — tooltip appears

#### B. Multi-clone local development

Each clone on the same machine must have unique values in its `umpleonline/config/lsp.ini`:
- `standaloneHostPort` (e.g., `9999` and `4455`)
- `standaloneContainerName` (e.g., `umple_lsp` and `umple_lsp2`)

After editing `lsp.ini` in each clone, start the LSP containers and PHP servers:
```bash
# Clone 1
UMPLEROOT=~/clone1 dev-tools/pumple
cd ~/clone1/umpleonline && php -S localhost:8001

# Clone 2
UMPLEROOT=~/clone2 dev-tools/pumple
cd ~/clone2/umpleonline && php -S localhost:8002
```

If ports or names collide, the second clone's `setup.sh` kills the first clone's container, and `umple.php` sends the browser to the wrong LSP container — resulting in `4002 Model directory not found`.

**Verify:** Each clone's `window.UMPLE_LSP_WS_URL` shows a different port.

#### C. Remote server (nginx + standalone LSP container)

For servers where PHP runs under nginx (not the all-in-one Docker).

**Files to edit**
- `umpleonline/config/lsp.ini` in the repo
- your host nginx site config (for example `/etc/nginx/sites-available/umple.conf` or `/etc/nginx/conf.d/umple.conf`)

Do not edit `umpleonline/docker_config/nginx.conf` for this deployment mode unless you are rebuilding the all-in-one Docker image. For a host-nginx deployment, edit the host nginx config instead.

**1.** Create the live LSP config if needed, then edit it:
```bash
cd /path/to/umple
cp umpleonline/config/lsp.ini.template umpleonline/config/lsp.ini
```

Typical values:
```ini
standaloneUmpBaseDir=/path/to/umple/umpleonline/ump
standaloneHostPort=9999
standaloneContainerName=umple_lsp
maxProcesses=200
localBrowserHost=127.0.0.1
useLinkedLsp=false
```

Use an absolute `standaloneUmpBaseDir` on the server.

**2.** Build/package UmpleOnline and start the standalone LSP container:
```bash
cd /path/to/umple
./dev-tools/pumple
```

If you only changed `lsp.ini` and just need to restart the LSP container:
```bash
cd /path/to/umple
./UmpleLsp/setup.sh bg
```

**3.** Add to your host nginx server block:
```nginx
location /lsp {
    proxy_pass http://127.0.0.1:9999;  # must match standaloneHostPort in lsp.ini
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";
    proxy_read_timeout 86400s;
    proxy_send_timeout 86400s;
}
```

**4.** Pass the WebSocket URL to PHP (in the `location ~ \.php$` block):
```nginx
fastcgi_param UMPLE_LSP_WS_URL /lsp;
```

If your PHP is running through php-fpm, the PHP block typically looks like:
```nginx
location ~ \.php$ {
    include fastcgi_params;
    include fastcgi.conf;
    fastcgi_pass unix:/run/php/php8.2-fpm.sock;  # use your real php-fpm socket or host:port
    fastcgi_index index.php;

    fastcgi_param UMPLE_LSP_WS_URL /lsp;
}
```

**5.** Start or reload the host services:
```bash
sudo nginx -t
sudo systemctl reload nginx
sudo systemctl restart php8.2-fpm   # use your actual php-fpm service name
```

If nginx or php-fpm are not already running:
```bash
sudo systemctl enable --now nginx
sudo systemctl enable --now php8.2-fpm
```

**6.** Verify the remote-server setup:
```bash
docker ps | grep myumple_lsp
```

In the browser:
- open `/umple.php`
- browser console: `window.UMPLE_LSP_WS_URL` should show `/lsp`
- network tab: WebSocket request to `/lsp` should return `101 Switching Protocols`

**Multi-instance example (3 clones on one server):**

Each web instance emits its own WebSocket path, each nginx path proxies to its own LSP port, and each LSP port belongs to one clone's `ump` directory.

| Instance | Repo path | `standaloneHostPort` | `standaloneContainerName` | Browser path |
|----------|-----------|---------------------|--------------------------|-------------|
| Main | `~/umple` | `9999` | `umple_lsp` | `/lsp` |
| Test 1 | `~/test1` | `4455` | `umple_lsp_test1` | `/lsp-test1` |
| Test 2 | `~/test2` | `4466` | `umple_lsp_test2` | `/lsp-test2` |

The simplest setup is to keep each instance explicit. Give each site config its own hardcoded WebSocket path instead of routing through nginx variables.

**Main instance**
```nginx
location /lsp {
    proxy_pass http://127.0.0.1:9999;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";
}

location ~ \.php$ {
    ...
    fastcgi_param UMPLE_LSP_WS_URL /lsp;
}
```

**Test 1**
```nginx
location /lsp-test1 {
    proxy_pass http://127.0.0.1:4455;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";
}

location ~ \.php$ {
    ...
    fastcgi_param UMPLE_LSP_WS_URL /lsp-test1;
}
```

**Test 2**
```nginx
location /lsp-test2 {
    proxy_pass http://127.0.0.1:4466;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";
}

location ~ \.php$ {
    ...
    fastcgi_param UMPLE_LSP_WS_URL /lsp-test2;
}
```

**Verify:**
- Browser console on each instance: `window.UMPLE_LSP_WS_URL` shows `/lsp`, `/lsp-test1`, or `/lsp-test2`
- WebSocket connects via `wss://yourserver.com/<path>`
- `docker ps` shows three containers with distinct names and ports

#### D. All-in-one Docker

The `umpleonline/Dockerfile` bundles nginx, PHP, lsp-proxy, and umple-lsp-server in one container. LSP is enabled by default.

```bash
dev-tools/bdock
docker run --rm -ti -p 8000:8000 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v /tmp/umpleonline-tmp:/var/www/ump \
  umple/umpleonline:recentbuild
```

Config source: `UMPLE_LSP_WS_URL="/lsp"` set in Dockerfile. `maxProcesses` read from `config/lsp.ini` inside the image.

To disable LSP: `docker run -e UMPLE_LSP_WS_URL="" ...`

To enable auth: `docker run -e LSP_AUTH_SECRET="$(openssl rand -hex 32)" -e LSP_DEV_AUTH=0 ...`

**Verify:**
- Browser console: `window.UMPLE_LSP_WS_URL` shows `/lsp`
- Diagnostics appear as you type

### Disabling LSP

To disable LSP explicitly, make `UMPLE_LSP_WS_URL` empty for that instance.

**Docker**
```bash
docker run -e UMPLE_LSP_WS_URL="" ...
```

**nginx + php-fpm**
```nginx
fastcgi_param UMPLE_LSP_WS_URL "";
```

**Local `php -S`**
```bash
UMPLE_LSP_WS_URL="" php -S localhost:8001
```

**Verify:**
- Browser console: `window.UMPLE_LSP_WS_URL` shows `""`
- LSP features such as diagnostics, hover, and go-to-definition are inactive

Note: disabling LSP in the page does not stop the standalone LSP container. If you want it fully off, also stop or remove the `my<standaloneContainerName>` container.

### Fail-closed behavior

LSP is intentionally disabled when configuration is missing:
- **`umple.php`**: If `UMPLE_LSP_WS_URL` env is not set and `config/lsp.ini` is missing or incomplete, `window.UMPLE_LSP_WS_URL` is empty and LSP is disabled. A warning is logged via `error_log`.
- **`UmpleLsp/setup.sh`**: Auto-creates `lsp.ini` from `lsp.ini.template` if missing. Fails with an error if neither exists or required values (`standaloneHostPort`, `standaloneContainerName`, `standaloneUmpBaseDir`, `maxProcesses`) are absent.
- **`server.js`**: Exits with an error if `LSP_HOST`, `LSP_PORT`, or `UMP_BASE_DIR` env vars are missing. Exits if `maxProcesses` is not available from env or `config/lsp.ini`.

## Code Execution

To enable the "Execute" button (runs generated code in a sandbox):

```bash
cd UmpleCodeExecution
cp config.cfg.template config.cfg
# edit config.cfg: set umplePath to your umpleonline/ump directory
./setup.sh
```

See [UmpleCodeExecution/README.md](../UmpleCodeExecution/README.md) for details.

## Building the Docker Image

For developers who need to test changes inside Docker:

```bash
dev-tools/bdock
# then run with:
docker run --rm -ti --name umpleonline_local \
  -p 8000:8000 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v /tmp/umpleonline-tmp:/var/www/ump \
  umple/umpleonline:recentbuild
```

## Directory Structure

| Path | Description |
|------|-------------|
| `config/lsp.ini.template` | LSP configuration template (checked in) |
| `config/lsp.ini` | LSP runtime configuration (gitignored, created from template) |
| `umple.php` | Main entry point |
| `scripts/compiler.php` | Backend compilation endpoint |
| `scripts/compiler_config.php` | Compiler configuration and execution |
| `scripts/umple_action.js` | Frontend action handler |
| `scripts/umple_page.js` | Page initialization |
| `scripts/umple_tab_control.js` | Multi-tab management |
| `scripts/codemirror6/` | CodeMirror 6 editor, LSP client integration |
| `scripts/codemirror6/editor.mjs` | Editor source (UmpleWorkspace, LSP lifecycle) |
| `scripts/codemirror6/editor.bundle.js` | Built editor bundle (generated by rollup) |
| `scripts/lsp-proxy/` | WebSocket proxy (browser to LSP server) |
| `scripts/umplesync.jar` | Umple compiler (built by `ant packageJars`) |
| `scripts/umple.jar` | CLI compiler (downloadable) |
| `ump/` | Runtime session storage |
| `ump/tmp*/` | Per-session directories (auto-deleted after 1 month) |
| `ump/yymmdd*/` | Long-term user storage (auto-deleted after 1 year) |
| `ump/tasks/` | Experiment/course tasks |
| `umplibrary/` | Example `.ump` files and cached SVGs |
| `docker_config/` | nginx, php-fpm, supervisord configuration |
| `Dockerfile` | Main Docker image (built on every branch push/PR/merge) |
| `Dockerfile-base` | Base image (rebuilt on tagged releases) |
| `testsuite/` | Browser tests (Ruby/Capybara/Selenium) |

## Architecture

```
Browser
  |
  |-- HTTP ---------> nginx (:8000) --> php-fpm --> umple.php / compiler.php
  |                                                      |
  |                                              java -jar umplesync.jar
  |                                                      |
  |-- WebSocket ----> nginx /lsp --> lsp-proxy (:9999) --> umple-lsp-server (stdio)
                                     (per-session process management)
```

- **nginx** serves PHP pages and proxies `/lsp` WebSocket connections
- **php-fpm** runs the Umple compiler via `umplesync.jar` for diagrams and code generation
- **lsp-proxy** bridges WebSocket to stdio, manages one LSP server process per session
- **umple-lsp-server** provides LSP features using tree-sitter for parsing
