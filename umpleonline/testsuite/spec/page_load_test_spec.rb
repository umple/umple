require 'spec_helper.rb'

# These tests ensure that all implemented url options (umple.php?OPTION) work
# correctly. This is particular important to the test suite, as umpleonline is
# often loaded with options during testing.

describe "Page load options", :feature => :pageLoad, :helper => :pageLoad do 

  before(:all) {Capybara.current_session.current_window.resize_to(1024, 768)}

  it "loads UmpleOnline with the example url option" do
    load_umple_with_option("example=2DShapes")

    #check examples dropdown menus
    expect(page).to have_select("inputExampleType", selected: "Class Diagrams")
    expect(page).to have_select("inputExample", selected: "2DShapes")

    #Check diagram
    expect(find(:css, "#umpleCanvas")).to have_selector("#Shape2D")
    expect(find(:css, "#umpleCanvas")).to have_selector("#EllipticalShape")
    expect(find(:css, "#umpleCanvas")).to have_selector("#EllipticalShape_generalization")

    #Check text editor
    expect(get_file_contents("2DShapes.ump", TestUtils::EXAMPLE_DIRECTORY)).to include(evaluate_script("Page.getRawUmpleCode()"))
  end

  it "loads UmpleOnline with the text url option" do
    umple_text = "class A { * -- * A something; }"
    load_umple_with_option("text=#{encode_to_url(umple_text)}")
    
    #Check text editor
    expect(umple_text).to include(evaluate_script("Page.getRawUmpleCode()"))

    #Check diagram
    expect(find(:css, "#umpleCanvas")).to have_selector("#A")
  end

  it "loads UmpleOnline with the filename url option" do
    load_umple_with_option("filename=cruise.umple.org/umpleonline/umplibrary/2DShapes.ump")

    #Check diagram
    expect(find(:css, "#umpleCanvas")).to have_selector("#Shape2D")
    expect(find(:css, "#umpleCanvas")).to have_selector("#EllipticalShape")
    expect(find(:css, "#umpleCanvas")).to have_selector("#EllipticalShape_generalization")

    #Check text editor
    expect( get_file_contents("2DShapes.ump", TestUtils::EXAMPLE_DIRECTORY)).to(
      include(evaluate_script("Page.getRawUmpleCode()")))    
  end

  it "loads UmpleOnline with the model url option" do
    pending("a reliable test implementation")
    fail
  end

  it "loads UmpleOnline with the nochrome url option" do
    load_umple_with_option("nochrome")
    expect(page).to have_no_selector("div#header")
  end

  it "loads UmpleOnline with the notext url option" do
    load_umple_with_option("notext")
    expect(page).to have_no_selector("div#textEditorColumn")
  end

  it "loads UmpleOnline with the nodiagram url option" do
    load_umple_with_option("nodiagram")
    expect(page).to have_no_selector("div#umpleCanvasColumn")
  end

  it "loads UmpleOnline with the showlayout url option" do
    load_umple_with_option("showlayout")
    expect(page).to have_selector("div#bottomTextEditor")
  end

  it "loads UmpleOnline with the nomenu url option" do
    load_umple_with_option("nomenu")
    expect(page).to have_no_selector("div#paletteColumn")
  end

  it "loads UmpleOnline with the readOnly url option" do
    load_umple_with_option("readOnly")
    
    #Check that the palette is missing the correct options
    expect(page).to have_no_selector("ul#mainDrawMenu")
    expect(page).to have_no_selector("li#ttShowHideLayoutEditor")
    expect(page).to have_no_selector("li#ttToggleAttributes")
    expect(page).to have_no_selector("li#ttToggleMethods")
    expect(page).to have_no_selector("li#ttToggleActions")

    expect(find(:css, "#umpleCanvasColumn")).to have_css("div.photoReady")
  end

  describe "Loading UmpleOnline with each diagram type url option" do
    it "loads UmpleOnline with the diagramtype url option to editable class diagram" do
      load_umple_with_option("diagramtype=default")
      switch_to_options_panel
      expect(find(:css, "#buttonShowEditableClassDiagram").checked?).to eq(true)
    end

    it "loads UmpleOnline with the diagramtype url option to graphviz class diagram" do
      load_umple_with_option("diagramtype=GvClass")
      switch_to_options_panel
      expect(find(:css, "#buttonShowGvClassDiagram").checked?).to eq(true)
    end

    it "loads UmpleOnline with the diagramtype url option to graphviz state diagram" do
      load_umple_with_option("diagramtype=GvState")
      switch_to_options_panel
      expect(find(:css, "#buttonShowGvStateDiagram").checked?).to eq(true)
    end

    it "loads UmpleOnline with the diagramtype url option to composite structure diagram" do
      load_umple_with_option("diagramtype=structureDiagram")
      switch_to_options_panel
      expect(find(:css, "#buttonShowStructureDiagram").checked?).to eq(true)
    end
  end

  describe "Loading UmpleOnline with each code generation option for the url" do
    it "loads UmpleOnline with Java as the default code to generate" do
      load_umple_with_option("generateDefault=java")
      expect(page).to have_select('inputGenerateCode', selected: 'Java Code')
    end

    it "loads UmpleOnline with JavaDoc as the default code to generate" do
      load_umple_with_option("generateDefault=javadoc")
      expect(page).to have_select('inputGenerateCode', selected: 'Java API Doc')
    end

    it "loads UmpleOnline with PHP as the default code to generate" do
      load_umple_with_option("generateDefault=php")
      expect(page).to have_select('inputGenerateCode', selected: 'PHP Code')
    end

    it "loads UmpleOnline with C++ as the default code to generate" do
      load_umple_with_option("generateDefault=cpp")
      expect(page).to have_select('inputGenerateCode', selected: 'C++ Code')
    end

    it "loads UmpleOnline with Ruby as the default code to generate" do
      load_umple_with_option("generateDefault=ruby")
      expect(page).to have_select('inputGenerateCode', selected: 'Ruby Code')
    end

    it "loads UmpleOnline with SQL as the default code to generate" do
      load_umple_with_option("generateDefault=sql")
      expect(page).to have_select('inputGenerateCode', selected: 'Sql')
    end

    it "loads UmpleOnline with code metrics as the default code to generate" do
      load_umple_with_option("generateDefault=metrics")
      expect(page).to have_select('inputGenerateCode', selected: 'Simple Metrics')
    end
    it "loads UmpleOnline with alloy model as the default code to generate" do
      load_umple_with_option("generateDefault=alloy")
      expect(page).to have_select('inputGenerateCode', selected: 'Alloy Model')
    end
    it "loads UmpleOnline with nusmv model as the default code to generate" do
      load_umple_with_option("generateDefault=nusmv")
      expect(page).to have_select('inputGenerateCode', selected: 'NuSMV Model')
    end
    it "loads UmpleOnline with crud ui as the default code to generate" do
      load_umple_with_option("generateDefault=uigu2")
      expect(page).to have_select('inputGenerateCode', selected: 'CRUD User Interface')
    end
    it "loads UmpleOnline without any options and makes a tip of the day appears" do
      load_page
      
      find(:css, "#linenum").click
      find(:css, "#linenum").send_keys(:backspace)
      find(:css, "#linenum").send_keys("tc")
      find(:css, "#linenum").send_keys(:enter)
      
      load_page
     
      expect(page).to have_selector("#styleTip")
    end
  end
end
