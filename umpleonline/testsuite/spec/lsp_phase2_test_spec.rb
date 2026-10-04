require 'spec_helper.rb'

describe "LSP Phase 2", :helper => :lsp, :feature => :lsp do
  before(:all) do
    Capybara.current_session.current_window.resize_to(1280, 900)
  end

  # -----------------------------------------------------------------------
  # Same-file F12 (go-to-definition)
  # -----------------------------------------------------------------------

  describe "same-file definition" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "jumps to class definition from isA reference" do
      set_editor_text("class A {\n  name;\n}\n\nclass B {\n  isA A;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil
      sleep 1 # Allow server to index

      pos_before = set_cursor_at("isA A", offset: 4) # cursor on "A" after "isA "
      trigger_go_to_definition

      outcome = wait_for_definition_outcome(original_pos: pos_before, original_tab: active_tab_name)
      # Should jump to class A definition (earlier in file)
      expect(outcome).to eq(:jumped)

      pos_after = current_cursor_position
      expect(pos_after).to be < pos_before # jumped backward to class A
    end
  end

  # -----------------------------------------------------------------------
  # Cross-file F12 (go-to-definition)
  # -----------------------------------------------------------------------

  describe "cross-file definition" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "jumps to definition in another tab" do
      # Create tab with class A
      create_tab_with_content("Other", "class A {\n  name;\n}")

      # Switch back to first tab and reference A
      select_tab_by_name("Untitled")
      set_editor_text("use Other.ump;\n\nclass B {\n  isA A;\n}")
      sleep 2 # Allow server to index both files

      pos_before = set_cursor_at("isA A", offset: 4)
      tab_before = active_tab_name

      trigger_go_to_definition

      outcome = wait_for_definition_outcome(
        original_pos: pos_before,
        original_tab: tab_before,
        timeout: 5
      )

      # Should have jumped to the Other tab
      expect(outcome).to eq(:jumped)
      expect(active_tab_name).to eq("Other")
    end

    it "does not crash when the passive target file grew before the jump" do
      create_tab_with_content("Other", "class A {\n  name;\n}")

      # Make the target file much longer while it is active, then switch away.
      select_tab_by_name("Other")
      set_editor_text("\n\n\n\n\n\nclass A {\n  name;\n}\n")

      select_tab_by_name("Untitled")
      set_editor_text("use Other.ump;\n\nclass B {\n  isA A;\n}")
      sleep 2 # Allow server to re-index the saved passive file

      pos_before = set_cursor_at("isA A", offset: 4)
      tab_before = active_tab_name
      clear_trapped_errors

      trigger_go_to_definition

      outcome = wait_for_definition_outcome(
        original_pos: pos_before,
        original_tab: tab_before,
        timeout: 5
      )

      errors = trapped_errors_matching("RangeError", "Invalid line number")
      expect(errors).to be_empty
      expect(outcome).to eq(:jumped)
      expect(active_tab_name).to eq("Other")
    end
  end

  # -----------------------------------------------------------------------
  # Same-file references (Shift-F12)
  # -----------------------------------------------------------------------

  describe "same-file references" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "opens reference panel with entries for a referenced symbol" do
      set_editor_text("class A {\n  name;\n}\n\nclass B {\n  isA A;\n}\n\nclass C {\n  isA A;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil

      set_cursor_at("class A", offset: 6) # cursor on "A"
      trigger_find_references

      # Wait for reference panel to appear
      found = false
      15.times do
        if reference_panel_visible?
          found = true
          break
        end
        sleep 0.3
      end

      expect(found).to eq(true), "Reference panel did not open"
      entries = reference_panel_entries
      expect(entries.length).to be >= 2
    end
  end

  # -----------------------------------------------------------------------
  # Same-file rename (F2)
  # -----------------------------------------------------------------------

  describe "same-file rename" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "renames a class across all occurrences in the file" do
      set_editor_text("class Foo {\n  name;\n}\n\nclass Bar {\n  isA Foo;\n}")
      wait_for_diagnostics(timeout: 15) rescue nil

      set_cursor_at("class Foo", offset: 6)
      focus_editor

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
      input.set("Baz")
      input.send_keys(:enter)

      # Wait for rename to apply
      applied = false
      10.times do
        text = editor_text
        if text.include?("class Baz") && text.include?("isA Baz")
          applied = true
          break
        end
        sleep 0.3
      end

      expect(applied).to eq(true), "Rename did not apply"
      expect(editor_text).not_to include("Foo")
    end
  end
end
