require 'timeout'

module LspTestHelper
  def lsp_bootstrap_present?
    evaluate_script("!!window.UMPLE_LSP_WS_URL")
  end

  def lsp_active?
    evaluate_script("typeof cm6 !== 'undefined' && !!cm6.isLspActive && cm6.isLspActive()")
  end

  def skip_unless_lsp_configured!
    skip("LSP is not configured for this UmpleOnline test environment") unless lsp_bootstrap_present?
  end

  def wait_for_lsp_state(expected_active:, timeout: 10)
    Timeout.timeout(timeout) do
      loop do
        wait_for_loading_no_ajax
        active = lsp_active?
        return active if active == expected_active
        sleep 0.1
      end
    end
  rescue Timeout::Error
    raise "Timed out waiting for LSP active=#{expected_active}"
  end

  def wait_for_lsp_ready(timeout: 10)
    skip_unless_lsp_configured!
    wait_for_lsp_state(expected_active: true, timeout: timeout)
  end

  def editor_text
    evaluate_script("Page.getUmpleCode()")
  end

  def active_tab_name
    evaluate_script("TabControl.activeTab ? TabControl.activeTab.name : null")
  end

  def all_tab_names
    evaluate_script("Object.keys(TabControl.tabs).map(function(id) { return TabControl.tabs[id].name; })")
  end

  def set_editor_text(text)
    execute_script("Page.setUmpleCode(arguments[0], null, true);", text)
    wait_for_loading
  end

  def focus_editor
    execute_script("Page.codeMirrorEditor6.focus();")
  end

  def set_cursor_at(search_text, occurrence: 0, offset: 0)
    result = evaluate_script(<<~JS, search_text, occurrence, offset)
      (function(needle, occurrenceIndex, extraOffset) {
        var doc = Page.codeMirrorEditor6.state.doc.toString();
        var index = -1;
        var start = 0;
        for (var i = 0; i <= occurrenceIndex; i++) {
          index = doc.indexOf(needle, start);
          if (index === -1) {
            return {found: false};
          }
          start = index + needle.length;
        }
        var target = index + extraOffset;
        Page.codeMirrorEditor6.dispatch({
          selection: {anchor: target},
          scrollIntoView: true
        });
        Page.codeMirrorEditor6.focus();
        return {found: true, position: target};
      })(arguments[0], arguments[1], arguments[2]);
    JS
    raise "Unable to find cursor text: #{search_text.inspect}" unless result["found"]
    result["position"]
  end

  def send_key_to_editor(*keys)
    focus_editor
    find(:css, ".cm-content").send_keys(*keys)
  end

  def create_tab_with_content(name, content)
    execute_script("TabControl.createTab(arguments[0], arguments[1], true);", name, content)
    wait_for_loading
  end

  def select_tab_by_name(name)
    found = evaluate_script(<<~JS, name)
      (function(tabName) {
        for (var id in TabControl.tabs) {
          if (TabControl.tabs[id].name === tabName) {
            TabControl.selectTab(id);
            return true;
          }
        }
        return false;
      })(arguments[0]);
    JS
    raise "Unable to select tab: #{name.inspect}" unless found
    wait_for_loading
  end

  def rename_tab(old_name, new_name)
    found = evaluate_script(<<~JS, old_name, new_name)
      (function(fromName, toName) {
        for (var id in TabControl.tabs) {
          if (TabControl.tabs[id].name === fromName) {
            TabControl.renameTab(id, toName, true);
            return true;
          }
        }
        return false;
      })(arguments[0], arguments[1]);
    JS
    raise "Unable to rename tab: #{old_name.inspect}" unless found
    wait_for_loading
  end

  def reference_panel_entries
    evaluate_script(<<~JS)
      Array.from(document.querySelectorAll(".cm-lsp-reference")).map(function(node) {
        return node.textContent.trim();
      });
    JS
  end

  def reference_panel_visible?
    page.has_css?(".cm-lsp-reference-panel")
  end

  def current_cursor_position
    evaluate_script("Page.codeMirrorEditor6.state.selection.main.head")
  end

  # Diagnostics helpers

  def wait_for_diagnostics(timeout: 10)
    Timeout.timeout(timeout) do
      loop do
        count = diagnostic_count
        return count if count > 0
        sleep 0.3
      end
    end
  rescue Timeout::Error
    0
  end

  def wait_for_no_diagnostics(timeout: 10)
    Timeout.timeout(timeout) do
      loop do
        count = diagnostic_count
        return true if count == 0
        sleep 0.3
      end
    end
  rescue Timeout::Error
    false
  end

  def diagnostic_count
    evaluate_script("document.querySelectorAll('.cm-lintRange').length")
  end

  def diagnostic_messages
    evaluate_script(<<~JS)
      Array.from(document.querySelectorAll('.cm-lint-marker')).map(function(m) {
        return m.getAttribute('aria-label') || '';
      });
    JS
  end

  # F12 / go-to-definition helper

  def trigger_go_to_definition
    focus_editor
    send_key_to_editor(:f12)
    wait_for_loading_no_ajax
  end

  def trigger_find_references
    focus_editor
    send_key_to_editor([:shift, :f12])
    wait_for_loading_no_ajax
  end

  # Uncaught error/rejection trap — catches what console.error misses
  # Installs window.onerror + window.onunhandledrejection handlers

  def install_error_trap
    execute_script(<<~JS)
      window.__lspTestErrors = [];
      window.addEventListener('error', function(event) {
        window.__lspTestErrors.push(event.message || String(event));
      });
      window.addEventListener('unhandledrejection', function(event) {
        var msg = event.reason ? (event.reason.message || String(event.reason)) : 'unhandled rejection';
        window.__lspTestErrors.push(msg);
      });
    JS
  end

  def trapped_errors
    evaluate_script("(window.__lspTestErrors || []).slice()")
  end

  def trapped_errors_matching(*patterns)
    errors = trapped_errors
    errors.select { |e| patterns.any? { |p| e.include?(p) } }
  end

  def clear_trapped_errors
    execute_script("window.__lspTestErrors = [];")
  end

  # Wait for a concrete post-F12 outcome: either cursor moved (definition found)
  # or a short bounded interval passed with no errors (no result, graceful).
  # Returns :jumped if cursor/tab changed, :stable if nothing happened, :error if trapped.
  def wait_for_definition_outcome(original_pos:, original_tab:, timeout: 3)
    Timeout.timeout(timeout) do
      loop do
        # Check if cursor jumped (definition found)
        pos = current_cursor_position
        tab = active_tab_name
        if tab != original_tab || (pos - original_pos).abs > 5
          return :jumped
        end

        # Check if errors appeared (crash)
        errs = trapped_errors_matching("TypeError", "Cannot read properties", "RangeError")
        return :error unless errs.empty?

        sleep 0.15
      end
    end
  rescue Timeout::Error
    :stable # No jump, no error — definition returned empty result gracefully
  end
end
