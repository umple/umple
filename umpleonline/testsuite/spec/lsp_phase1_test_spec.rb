require 'spec_helper.rb'

describe "LSP Phase 1", :helper => :lsp, :feature => :lsp do
  before(:all) do
    Capybara.current_session.current_window.resize_to(1280, 900)
  end

  # -----------------------------------------------------------------------
  # Bootstrap
  # -----------------------------------------------------------------------

  describe "bootstrap" do
    it "initializes LSP when the page is editable and LSP is configured" do
      load_page
      skip_unless_lsp_configured!

      expect(wait_for_lsp_ready).to eq(true)
      expect(lsp_active?).to eq(true)
    end

    it "does not initialize LSP in readOnly mode" do
      load_umple_with_option("readOnly")
      skip_unless_lsp_configured!

      expect(wait_for_lsp_state(expected_active: false, timeout: 5)).to eq(false)
      expect(lsp_active?).to eq(false)
    end
  end

  # -----------------------------------------------------------------------
  # Single-file diagnostics
  # -----------------------------------------------------------------------

  describe "diagnostics" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "shows diagnostics for invalid Umple code" do
      set_editor_text("class X { invalid_stuff }")
      count = wait_for_diagnostics(timeout: 15)
      expect(count).to be > 0
    end

    it "clears diagnostics when code is fixed" do
      set_editor_text("class X { invalid_stuff }")
      wait_for_diagnostics(timeout: 15)

      set_editor_text("class X {\n  name;\n}")
      cleared = wait_for_no_diagnostics(timeout: 15)
      expect(cleared).to eq(true)
    end

    it "maps diagnostics correctly after full document replacement" do
      set_editor_text("class A {\n  name;\n}")
      wait_for_no_diagnostics(timeout: 10)

      clear_trapped_errors

      set_editor_text("class B {\n  isA NonExistent;\n  name;\n  age;\n}")

      # Diagnostics must actually arrive — proves the path exercised
      count = wait_for_diagnostics(timeout: 15)
      expect(count).to be > 0

      # No position mapping crashes
      errors = trapped_errors_matching("RangeError", "out of range", "Invalid line number")
      expect(errors).to be_empty
    end
  end

  # -----------------------------------------------------------------------
  # No-result F12 (definition)
  # -----------------------------------------------------------------------

  describe "no-result definition" do
    before(:each) do
      load_page
      skip_unless_lsp_configured!
      wait_for_lsp_ready
      install_error_trap
    end

    it "does not crash when F12 finds no definition" do
      set_editor_text("class X {\n  isA NonExistentClass;\n}")
      # Wait for diagnostics to confirm server processed the file
      wait_for_diagnostics(timeout: 15)

      pos = set_cursor_at("NonExistentClass")
      tab = active_tab_name
      clear_trapped_errors

      trigger_go_to_definition

      # Wait for concrete outcome: jumped, stable, or error
      outcome = wait_for_definition_outcome(original_pos: pos, original_tab: tab)
      if outcome == :error
        puts "TRAPPED ERRORS: #{trapped_errors.inspect}"
      end
      expect(outcome).not_to eq(:error)
    end

    it "keeps cursor and tab stable after no-result F12" do
      set_editor_text("class X {\n  isA NonExistentClass;\n}")
      wait_for_diagnostics(timeout: 15)

      pos = set_cursor_at("NonExistentClass")
      tab_before = active_tab_name
      clear_trapped_errors

      trigger_go_to_definition

      outcome = wait_for_definition_outcome(original_pos: pos, original_tab: tab_before)
      expect(outcome).to eq(:stable)

      tab_after = active_tab_name
      expect(tab_after).to eq(tab_before)
    end
  end
end
