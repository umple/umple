(function () {
  const STORAGE_KEY = "umple-theme";
  const select = document.getElementById("themeModeSelect");
  const darkStylesheet = document.getElementById("theme-dark-css");
  if (!select || !darkStylesheet) {
    return;
  }

  const validModes = new Set(["light", "dark", "system"]);
  const prefersDark = window.matchMedia("(prefers-color-scheme: dark)");
  const themeColorMeta = document.querySelector('meta[name="theme-color"]');

  function setMedia(mode) {
    if (mode === "dark") {
      darkStylesheet.media = "all";
    } else if (mode === "light") {
      darkStylesheet.media = "not all";
    } else {
      darkStylesheet.media = "(prefers-color-scheme: dark)";
    }
  }

  function setSyntaxHighlighterTheme(mode) {
    const shThemeDefault = document.getElementById("shThemeDefault");
    const shThemeMidnight = document.getElementById("shThemeMidnight");
    if (!shThemeDefault || !shThemeMidnight) return;

    const isDark = mode === "dark" || (mode === "system" && prefersDark.matches);

    shThemeDefault.disabled = isDark;
    shThemeMidnight.disabled = !isDark;

    // Re-highlight any existing SyntaxHighlighter code blocks to apply new theme
    if (typeof SyntaxHighlighter !== "undefined" && typeof SyntaxHighlighter.highlight === "function") {
      try {
        SyntaxHighlighter.highlight();
      } catch (err) {
        console.warn("Unable to re-highlight code", err);
      }
    }
  }

  function applyTheme(mode, persist = true) {
    if (!validModes.has(mode)) {
      mode = "system";
    }

    setMedia(mode);
    setSyntaxHighlighterTheme(mode);

    if (mode === "dark") {
      document.body.dataset.theme = "dark";
    } else if (mode === "light") {
      document.body.dataset.theme = "light";
    } else {
      delete document.body.dataset.theme;
    }

    if (typeof cm6 !== "undefined" && typeof cm6.setDarkModePreference === "function") {
      try {
        cm6.setDarkModePreference(mode);
      } catch (err) {
        console.warn("Unable to update editor theme", err);
      }
    }

    if (themeColorMeta) {
      if (mode === "dark") {
        themeColorMeta.setAttribute("content", "#222222");
      } else if (mode === "light") {
        themeColorMeta.setAttribute("content", "#8f001a");
      } else {
        themeColorMeta.setAttribute("content", prefersDark.matches ? "#222222" : "#8f001a");
      }
    }

    if (persist) {
      try {
        localStorage.setItem(STORAGE_KEY, mode);
      } catch (err) {
        console.warn("Unable to persist theme preference", err);
      }
    }
  }

  function loadInitialTheme() {
    let saved = null;
    try {
      saved = localStorage.getItem(STORAGE_KEY);
    } catch (err) {
      console.warn("Unable to read theme preference", err);
    }

    if (!validModes.has(saved)) {
      saved = "system";
    }

    select.value = saved;
    applyTheme(saved, false);
  }

  select.addEventListener("change", function () {
    applyTheme(select.value);

    // Refresh in-canvas Graphviz diagram
    try {
      if (window.Page && window.Action) {
        if (Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram) {
          setTimeout(function(){ Action.redrawDiagram(); }, 0);
        }
      }
    } catch (e) { /* ignore */ }
  });

  function handleSystemChange() {
    let stored = "system";
    try {
      stored = localStorage.getItem(STORAGE_KEY) || "system";
    } catch (err) {
      console.warn("Unable to read theme preference", err);
    }
    if (stored === "system") {
      applyTheme("system", false);
    }
  }

  if (typeof prefersDark.addEventListener === "function") {
    prefersDark.addEventListener("change", handleSystemChange);
  } else if (typeof prefersDark.addListener === "function") {
    prefersDark.addListener(handleSystemChange);
  }

  loadInitialTheme();
})();
