require 'spec_helper.rb'

describe "LSP Phase 3", :helper => :lsp, :feature => :lsp do
  before(:all) do
    Capybara.current_session.current_window.resize_to(1280, 900)
  end

  # -----------------------------------------------------------------------
  # Cross-file references
  # -----------------------------------------------------------------------

  describe "cross-file references" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready(timeout: 20)
      install_error_trap
    end

    it "shows references from inactive tabs" do
      create_tab_with_content("Other", "class A {\n  name;\n}")
      select_tab_by_name("Untitled")
      set_editor_text("use Other.ump;\n\nclass B {\n  isA A;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil

      set_cursor_at("isA A", offset: 4)
      trigger_find_references

      found = false
      15.times do
        if reference_panel_visible?
          found = true
          break
        end
        sleep 0.3
      end

      expect(found).to eq(true), "Cross-file reference panel did not open"
      entries = reference_panel_entries
      expect(entries.length).to be >= 1

      errors = trapped_errors_matching("TypeError", "RangeError")
      expect(errors).to be_empty
    end
  end

  # -----------------------------------------------------------------------
  # Cross-file rename
  # -----------------------------------------------------------------------

  describe "cross-file rename" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready(timeout: 20)
      install_error_trap
    end

    it "renames a symbol across active and inactive tabs" do
      create_tab_with_content("Person", "class Person {\n  name;\n}")
      select_tab_by_name("Untitled")
      set_editor_text("use Person.ump;\n\nclass Student {\n  isA Person;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil

      set_cursor_at("isA Person", offset: 4)
      clear_trapped_errors

      send_key_to_editor(:f2)

      # Wait for rename dialog
      rename_visible = false
      10.times do
        rename_visible = evaluate_script("!!document.querySelector('.cm-lsp-rename-panel input, .cm-panel input[name=name]')")
        break if rename_visible
        sleep 0.3
      end

      expect(rename_visible).to eq(true), "Rename dialog did not appear"

      input = find(:css, '.cm-lsp-rename-panel input, .cm-panel input[name=name]')
      input.set("Human")
      input.send_keys(:enter)

      # Wait for rename to apply in active tab
      applied = false
      10.times do
        text = editor_text
        if text.include?("isA Human") && !text.include?("isA Person")
          applied = true
          break
        end
        sleep 0.3
      end

      expect(applied).to eq(true), "Rename did not apply in active tab"

      # Step 1: STAY on active tab — check diagnostics don't complain about "Human"
      # Wait for diagnostics to settle (server re-validates after rename)
      sleep 3

      # If diagnostics exist, they should NOT say "Human" is undefined
      diag_msgs = diagnostic_messages
      stale_diags = diag_msgs.select { |m|
        m.include?("Human") && (m.include?("does not exist") || m.include?("undefined") || m.include?("not found"))
      }
      expect(stale_diags).to be_empty,
        "Diagnostics complain about 'Human' after rename (stale server state): #{stale_diags.inspect}"

      # Step 2: Verify passive tab content WITHOUT selecting it
      passive_content = evaluate_script(<<~JS)
        (function() {
          var filename = TabControl.getTabFilename("Person");
          return localStorage[filename] || null;
        })();
      JS
      expect(passive_content).not_to be_nil, "Passive tab content not found in localStorage"
      expect(passive_content).to include("class Human")
      expect(passive_content).not_to include("class Person")

      # Step 3: Only now click the tab as secondary verification
      select_tab_by_name("Person")
      inactive_text = editor_text
      expect(inactive_text).to include("class Human")
      expect(inactive_text).not_to include("class Person")

      errors = trapped_errors_matching("TypeError", "RangeError", "is not a function")
      expect(errors).to be_empty
    end

    # Regression: layout tail contains duplicate symbol (e.g. "class Person"
    # in the position block), causing mapPosition to throw for that edit.
    # Old code: file-level try/catch skipped the ENTIRE file including valid
    # model-text edits. Fix: per-change try/catch keeps valid edits.
    it "renames definition in passive file whose disk copy has layout tail" do
      # Create Person tab, switch away FIRST, then inject combined content.
      # selectTab saves the active editor state, so injection must happen
      # AFTER Person is already passive to avoid being overwritten.
      create_tab_with_content("Person", "class Person {\n  name;\n}")
      select_tab_by_name("Untitled")

      # Now Person is passive. Inject layout tail into localStorage AND disk.
      execute_script(<<~JS)
        (function() {
          var fn = TabControl.getTabFilename("Person");
          var model = "class Person {\\n  name;\\n}";
          var tail = "//$?[End_of_model]$?\\n\\nnamespace -;\\n\\n\\nclass Person\\n{\\n  position 50 30 109 45;\\n}";
          var full = model + tail;
          localStorage[fn] = full;
          var xhr = new XMLHttpRequest();
          xhr.open("POST", "scripts/compiler.php", false);
          xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
          xhr.send("save=1&lock=1&model=" + encodeURIComponent(Page.getModel()) +
            "&umpleCode=" + encodeURIComponent(full) +
            "&filename=" + encodeURIComponent(fn));
        })();
      JS

      # Verify precondition
      precondition = evaluate_script(<<~JS)
        (function() {
          var fn = TabControl.getTabFilename("Person");
          var c = localStorage[fn] || "";
          var delim = c.indexOf("//$?[End_of_model]$?");
          if (delim === -1) return {layout: false, person: false};
          return {layout: true, person: c.substring(delim).indexOf("class Person") !== -1};
        })();
      JS
      expect(precondition["layout"]).to eq(true),
        "Layout tail injection failed"
      expect(precondition["person"]).to eq(true),
        "Layout tail does not contain 'class Person'"

      # Set up Student content on the already-active Untitled tab
      set_editor_text("use Person.ump;\n\nclass Student {\n  isA Person;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil

      # Trigger rename
      set_cursor_at("isA Person", offset: 4)
      clear_trapped_errors
      send_key_to_editor(:f2)

      rename_visible = false
      10.times do
        rename_visible = evaluate_script("!!document.querySelector('.cm-lsp-rename-panel input, .cm-panel input[name=name]')")
        break if rename_visible
        sleep 0.3
      end
      expect(rename_visible).to eq(true), "Rename dialog did not appear"

      input = find(:css, '.cm-lsp-rename-panel input, .cm-panel input[name=name]')
      input.set("Human")
      input.send_keys(:enter)

      # Wait for rename to apply in active tab
      applied = false
      10.times do
        text = editor_text
        if text.include?("isA Human") && !text.include?("isA Person")
          applied = true
          break
        end
        sleep 0.3
      end
      expect(applied).to eq(true), "Rename did not apply in active tab"

      # Wait for passive file save to complete (TabControl.saveTab queues the POST)
      sleep 3

      # 1. localStorage model portion renamed
      ls_result = evaluate_script(<<~JS)
        (function() {
          var fn = TabControl.getTabFilename("Person");
          var c = localStorage[fn] || "";
          var delim = c.indexOf("//$?[End_of_model]$?");
          var model = delim !== -1 ? c.substring(0, delim) : c;
          var layout = delim !== -1 ? c.substring(delim) : "";
          return {
            modelHasHuman: model.indexOf("class Human") !== -1,
            modelHasPerson: model.indexOf("class Person") !== -1,
            layoutHasHuman: layout.indexOf("class Human") !== -1,
            layoutHasPerson: layout.indexOf("class Person") !== -1
          };
        })();
      JS
      expect(ls_result["modelHasHuman"]).to eq(true),
        "localStorage model portion not renamed to Human"
      expect(ls_result["modelHasPerson"]).to eq(false),
        "localStorage model portion still contains Person"

      # 2. localStorage layout declaration also renamed
      expect(ls_result["layoutHasHuman"]).to eq(true),
        "localStorage layout declaration not renamed to Human"
      expect(ls_result["layoutHasPerson"]).to eq(false),
        "localStorage layout declaration still contains Person"

      # 3. Disk file renamed — read back via app load path
      disk_content = evaluate_script(<<~JS)
        (function() {
          var model = Page.getModel();
          var xhr = new XMLHttpRequest();
          xhr.open("GET", "scripts/compiler.php?load=1&filename=" +
            encodeURIComponent(model + "/Person.ump"), false);
          xhr.send();
          return xhr.status === 200 ? xhr.responseText : null;
        })();
      JS
      expect(disk_content).not_to be_nil, "Could not read Person.ump from disk via load endpoint"

      disk_delim = disk_content.index("//$?[End_of_model]$?")
      if disk_delim
        disk_model = disk_content[0...disk_delim]
        disk_layout = disk_content[disk_delim..]
      else
        disk_model = disk_content
        disk_layout = ""
      end

      expect(disk_model).to include("class Human"),
        "Disk file model portion not renamed"
      expect(disk_model).not_to include("class Person"),
        "Disk file model portion still has old name"
      expect(disk_layout).to include("class Human"),
        "Disk file layout declaration not renamed"
      expect(disk_layout).not_to include("class Person"),
        "Disk file layout declaration still has old name"

      errors = trapped_errors_matching("TypeError", "RangeError", "is not a function")
      expect(errors).to be_empty
    end
  end

  # -----------------------------------------------------------------------
  # Encoded tab names
  # -----------------------------------------------------------------------

  describe "encoded tab names" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready(timeout: 20)
      install_error_trap
    end

    it "supports LSP operations on tabs with spaces in names" do
      create_tab_with_content("My Class", "class MyClass {\n  name;\n}")
      select_tab_by_name("My Class")

      # Verify LSP is active and diagnostics work on encoded tab
      set_editor_text("class MyClass { invalid_stuff }")
      count = wait_for_diagnostics(timeout: 15)
      expect(count).to be > 0

      errors = trapped_errors_matching("TypeError", "RangeError", "URIError")
      expect(errors).to be_empty
    end
  end

  # -----------------------------------------------------------------------
  # Editor resilience
  # -----------------------------------------------------------------------

  describe "editor resilience" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready(timeout: 20)
      install_error_trap
    end

    it "typing and diagram updates work while LSP is active" do
      expect(lsp_active?).to eq(true)

      set_editor_text("class Test {\n  name;\n}")
      text = editor_text
      expect(text).to include("class Test")

      errors = trapped_errors_matching("TypeError", "RangeError")
      expect(errors).to be_empty
    end
  end
end
