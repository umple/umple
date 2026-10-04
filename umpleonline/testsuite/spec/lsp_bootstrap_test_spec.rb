require 'spec_helper.rb'

describe "LSP bootstrap", :helper => :lsp, :feature => :lsp do
  before(:all) do
    Capybara.current_session.current_window.resize_to(1280, 900)
  end

  it "initializes LSP when the page is editable and LSP is configured" do
    load_page
    skip_unless_lsp_configured!

    expect(wait_for_lsp_ready).to eq(true)
    expect(lsp_active?).to eq(true)
  end

  it "does not initialize LSP in readOnly mode" do
    load_umple_with_option("readOnly")
    skip_unless_lsp_configured!

    expect(wait_for_lsp_state(expected_active: false)).to eq(false)
    expect(lsp_active?).to eq(false)
  end
end
