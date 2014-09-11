require 'spec_helper.rb'

# These tests check that every button in the "Options" accordion panel of the 
# palette can be accessed with the label, button, and keyboard shortcuts 
# (in the options that implement a keyboard shortcut). They also ensure the 
# options have the expected effect.

describe "Option panel functionality", :helper => :optionsMenu, :feature => :optionsMenu  do
  describe "Show views inputability" do
    
    before(:all) do
      reset_page_to_options
      page.driver.resize(1024, 768)
    end

    describe "Clicking the show/hide diagram option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")
        find(:css, "#buttonShowHideCanvas").click
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        find(:css, "#buttonShowHideCanvas").click
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")
        find(:css, "#labelShowHideCanvas").click
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        find(:css, "#labelShowHideCanvas").click
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")
        find(:css, "#textEditorColumn").click #gives focus
        send_modified_key("#textEditorColumn", 'd', :control)
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        send_modified_key("#textEditorColumn", 'd', :control)
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end
    end

    describe "Clicking the show/hide text editor option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")
        find(:css, "#buttonShowHideTextEditor").click
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        find(:css, "#buttonShowHideTextEditor").click
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")
        find(:css, "#labelShowHideTextEditor").click
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        find(:css, "#labelShowHideTextEditor").click
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")
        find(:css, "#umpleCanvasColumn").click #gives focus
        send_modified_key("#umpleCanvasColumn", 't', :control)
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        send_modified_key("#umpleCanvasColumn", 't', :control)
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end
    end

    describe "Clicking the show/hide layout editor option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonShowHideLayoutEditor")
        find(:css, "#buttonShowHideLayoutEditor").click
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(true)
        find(:css, "#buttonShowHideLayoutEditor").click
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonShowHideLayoutEditor")
        find(:css, "#labelShowHideLayoutEditor").click
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(true)
        find(:css, "#labelShowHideLayoutEditor").click
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(false)
      end
    end

    describe "Clicking the show/hide attributes option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")
        find(:css, "#buttonToggleAttributes").click
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        find(:css, "#buttonToggleAttributes").click
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")
        find(:css, "#labelToggleAttributes").click
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        find(:css, "#labelToggleAttributes").click
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")
        find(:css, "#textEditorColumn").click #gives focus
        send_modified_key("#textEditorColumn", 'a', :control)
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        send_modified_key("#textEditorColumn", 'a', :control)
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end
    end

    describe "Clicking the show/hide methods option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")
        find(:css, "#buttonToggleMethods").click
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        find(:css, "#buttonToggleMethods").click
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")
        find(:css, "#labelToggleMethods").click
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        find(:css, "#labelToggleMethods").click
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")
        find(:css, "#textEditorColumn").click #gives focus
        send_modified_key("#textEditorColumn", 'm', :control)
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        send_modified_key("#textEditorColumn", 'm', :control)
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end
    end

    describe "Clicking the show/hide actions option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleActions")
        find(:css, "#buttonToggleActions").click
        expect(get_checkbox_state("#buttonToggleActions")).to eq(false)
        find(:css, "#buttonToggleActions").click
        expect(get_checkbox_state("#buttonToggleActions")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleActions")
        find(:css, "#labelToggleActions").click
        expect(get_checkbox_state("#buttonToggleActions")).to eq(false)
        find(:css, "#labelToggleActions").click
        expect(get_checkbox_state("#buttonToggleActions")).to eq(true)
      end
    end
  end

  describe "Show views functionality" do
    describe "Diagram show/hide option" do
      it "hides the diagram canvas" do
        reset_page_to_options
        expect(page).to have_selector("#umpleCanvasColumn")
        find(:css, "#buttonShowHideCanvas").click
        expect(page).to have_no_selector("#umpleCanvasColumn")
      end

      it "shows the diagram canvas" do
        reset_page_to_options_with_option("nodiagram")
        expect(page).to have_no_selector("#umpleCanvasColumn")
        find(:css, "#buttonShowHideCanvas").click
        expect(page).to have_selector("#umpleCanvasColumn")
      end
    end

    describe "Text editor show/hide option" do
      context "with menu button" do
        it "hides the text editor canvas" do
          reset_page_to_options
          expect(page).to have_selector("#textEditorColumn")
          find(:css, "#buttonShowHideTextEditor").click
          expect(page).to have_no_selector("#textEditorColumn")
        end

        it "shows the text editor canvas" do
          reset_page_to_options_with_option("notext")
          expect(page).to have_no_selector("#textEditorColumn")
          find(:css, "#buttonShowHideTextEditor").click
          expect(page).to have_selector("#textEditorColumn")
        end

        it "hides the text editor and layout editor"  do
          reset_page_to_options_with_option("showlayout")
          expect(page).to have_selector("#topTextEditor")
          expect(page).to have_selector("#bottomTextEditor")
          find(:css, "#buttonShowHideTextEditor").click
          expect(page).to have_no_selector("#topTextEditor")
          expect(page).to have_no_selector("#bottomTextEditor")
        end
      end
    end

    describe "Layout editor show/hide option" do
      context "With text editor visible"  do
        it "shows the layout editor" do
          reset_page_to_options
          expect(page).to have_no_selector("#bottomTextEditor")
          find(:css, "#buttonShowHideLayoutEditor").click
          expect(page).to have_selector("#bottomTextEditor")
        end

        it "hides the layout editor" do
          reset_page_to_options_with_option("showlayout")
          expect(page).to have_selector("#bottomTextEditor")
          find(:css, "#buttonShowHideLayoutEditor").click
          expect(page).to have_no_selector("#bottomTextEditor")
        end
      end

      context "without the text editor visible" do
        it "has no effect" do
          reset_page_to_options_with_option("notext")
          expect(page).to have_no_selector("#textEditorColumn")
          find(:css, "#buttonShowHideLayoutEditor").click
          expect(page).to have_no_selector("#bottomTextEditor")
        end
      end
    end

    describe "Attributes show/hide option" do
      it "hides the attributes and shows them again"  do
        reset_page_to_options_with_model("single_class_single_attribute.ump")
        within(find(:css, "#Student")) do
          fail_message = "page loaded without attributes showing"
          expect(page).to have_selector("tr.attributeArea"), fail_message
        end
        find(:css, "#buttonToggleAttributes").click
        within(find(:css, "#Student")) do
          fail_message = "attributes not hidden after unchecking the attributes checkbox"
          expect(page).to have_no_selector("tr.attributeArea"), fail_message
        end
        find(:css, "#buttonToggleAttributes").click
        within(find(:css, "#Student")) do
          fail_message = "attributes not showing after checking the attributes checkbox"
          expect(page).to have_selector("tr.attributeArea"), fail_message
        end
      end
    end

    describe "Methods show/hide option" do
      it "shows the methods and hides them again"  do
        reset_page_to_options_with_model("single_class_single_method.ump")
        within(find(:css, "#Student")) do
          fail_message = "page loaded with methods showing"
          expect(page).to have_no_selector("tr.methodArea"), fail_message
        end
        find(:css, "#buttonToggleMethods").click
        within(find(:css, "#Student")) do
          fail_message = "methods not showing after checking the methods checkbox"
          expect(page).to have_selector("tr.methodArea"), fail_message
        end
        find(:css, "#buttonToggleMethods").click
        within(find(:css, "#Student")) do
          fail_message = "methods not hidden after unchecking the methods checkbox"
          expect(page).to have_no_selector("tr.methodArea"), fail_message
        end
      end
    end

    describe "Actions show/hide option" do
      it "hides the actions then shows them again"  do
        reset_page_to_options_with_model_and_option("state_machine_with_action.ump", "diagramtype=state")
        within(find(:css, "#umpleCanvas")) do
          fail_message = "actions not found when state machine loaded"
          expect(find(:css, "#graph0").native.all_text).to include("doAction()"), fail_message
        end
        find(:css, "#buttonToggleActions").click
        wait_for_loading
        within(find(:css, "#umpleCanvas")) do
          fail_message = "actions still found after unchecking the methods checkbox"
          expect(find(:css, "#graph0").native.all_text).not_to include("doAction()"), fail_message
        end
        find(:css, "#buttonToggleActions").click
        wait_for_loading
        within(find(:css, "#umpleCanvas")) do
          fail_message = "actions not found after checking the methods checkbox"
          expect(find(:css, "#graph0").native.all_text).to include("doAction()"), fail_message
        end
      end
    end
  end

  describe "Diagram type inputability" do
    before(:all) {reset_page_to_options}

    it "cycles through the diagram types using keyboard shortcuts" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options
      end

      find(:css, "#textEditorColumn").click
      send_modified_key("#textEditorColumn", 'g', :control)
      expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)
      send_modified_key("#textEditorColumn", 's', :control)
      expect(get_checkbox_state("#buttonShowGvStateDiagram")).to eq(true)
      send_modified_key("#textEditorColumn", 'l', :control)
      expect(get_checkbox_state("#buttonShowStructureDiagram")).to eq(true)
      send_modified_key("#textEditorColumn", 'e', :control)
      expect(get_checkbox_state("#buttonShowEditableClassDiagram")).to eq(true)
    end

    it "cycles through the diagram types by clicking on the text labels" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options
      end

      find(:css, "#labelShowGvClassDiagram").click
      expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)
      find(:css, "#labelShowGvStateDiagram").click
      expect(get_checkbox_state("#buttonShowGvStateDiagram")).to eq(true)
      find(:css, "#labelShowStructureDiagram").click
      expect(get_checkbox_state("#buttonShowStructureDiagram")).to eq(true)
      find(:css, "#labelShowEditableClassDiagram").click
      expect(get_checkbox_state("#buttonShowEditableClassDiagram")).to eq(true)
    end
  end

  describe "Diagram type functionality" do
    example_file = "all_diagram_types.ump"

    before(:all) do
      reset_page_to_options_with_model(example_file)
    end

    it "switches from editable class diagram to graphviz class diagram and back" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end
      
      find(:css, "#buttonShowGvClassDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("Student") 
      end
      
      find(:css, "#buttonShowEditableClassDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from editable class diagram to graphviz state diagram and back" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end
      
      find(:css, "#buttonShowGvStateDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("start_Student_study") 
      end
      
      find(:css, "#buttonShowEditableClassDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from editable class diagram to compound structure diagram and back" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end
      
      find(:css, "#buttonShowStructureDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      find(:css, "#buttonShowEditableClassDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from graphviz class diagram to graphviz state diagram and back" do
      unless get_checkbox_state("#buttonShowGvClassDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvClass")
      end
      
      find(:css, "#buttonShowGvStateDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("start_Student_study") 
      end
      
      find(:css, "#buttonShowGvClassDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("Student") 
      end
    end

    it "switches from graphviz class diagram to composite structure diagram and back" do
      unless get_checkbox_state("#buttonShowGvClassDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvClass")
      end
      
      find(:css, "#buttonShowStructureDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      find(:css, "#buttonShowGvClassDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("Student") 
      end
    end

    it "switches from graphviz state diagram to compound structure diagram and back" do
      unless get_checkbox_state("#buttonShowGvStateDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvState")
      end
      
      find(:css, "#buttonShowStructureDiagram").click
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      find(:css, "#buttonShowGvStateDiagram").click
      within(find(:css, "#node1")) do
        expect(find(:css, "title").native.all_text.chomp).to eq("start_Student_study") 
      end
    end
  end

  describe "Checking for no diagram code found message" do
    before(:all) {reset_page_to_options}

    it "checks for no state diagram code found message" do
      expected_message = "No state machine found in the input Umple file"
      find(:css, "#buttonShowGvStateDiagram").click
      wait_for_loading
      expect(find(:css, "#umpleCanvas").native.all_text).to include(expected_message)
    end

    it "checks for no compound structure diagram code found message" do
      expected_message = "No composite structure found in the input Umple model"
      find(:css, "#buttonShowStructureDiagram").click
      wait_for_loading
      expect(find(:css, "#svgCanvas").native.all_text).to include(expected_message)
    end
  end

  describe "Preferences inputability" do

    before(:all) {reset_page_to_options} 

    describe "Clicking the photoready option" do

      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonPhotoReady") 
        find(:css, "#buttonPhotoReady").click
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(true)
        find(:css, "#buttonPhotoReady").click
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonPhotoReady") 
        find(:css, "#labelPhotoReady").click
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(true)
        find(:css, "#labelPhotoReady").click
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(false)
      end
    end

    describe "Clicking the manual sync option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonManualSync") 
        find(:css, "#buttonManualSync").click
        expect(get_checkbox_state("#buttonManualSync")).to eq(true)
        find(:css, "#buttonManualSync").click
        expect(get_checkbox_state("#buttonManualSync")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonManualSync") 
        find(:css, "#labelManualSync").click
        expect(get_checkbox_state("#buttonManualSync")).to eq(true)
        find(:css, "#labelManualSync").click
        expect(get_checkbox_state("#buttonManualSync")).to eq(false)
      end
    end
  end

  describe "Preferences functionality" do
    describe "Photoready option" do
      before(:all) {reset_page_to_options_with_model("simple_class.ump")}
      it "turns photoready on then off again"  do
        if get_checkbox_state("#buttonPhotoReady")
          reset_page_to_options_with_model("simple_class.ump") 
        end
        find(:css, "#buttonPhotoReady").click
        expect(find(:css, "#umpleCanvasColumn")).to have_css("div.photoReady")
        within(find(:css, "#Student")) do
          expect(find(:css, "#Student_newAttribute").native.all_text.chomp).to eq("")
        end 

        find(:css, "#buttonPhotoReady").click
        expect(find(:css, "#umpleCanvasColumn")).to_not have_css("div.photoReady")
        within(find(:css, "#Student")) do
          expect(find(:css, "#Student_newAttribute").native.all_text.chomp).to eq("-- Add More --")
        end
      end
    end

    describe "Manual Sync option" do
      before(:all) {reset_page_to_options}
      it "turns manual sync on then off again" do
        if get_checkbox_state("#buttonManualSync")
          reset_page_to_options
        end

        find(:css, "#buttonManualSync").click
        input_model_text("class Student {}")
        switch_to_tools_panel
        wait_for_loading
        expect(page).to have_selector("div#syncNeededMessage")
        expect(find(:css, "#umpleCanvas")).to have_no_selector("#Student")
        expect(page).to have_no_css("li#buttonSyncDiagram.disabled")

        switch_to_options_panel
        find(:css, "#buttonManualSync").click
        switch_to_tools_panel
        wait_for_loading
        expect(page).to have_no_selector("div#syncNeededMessage")
        expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
        expect(page).to have_css("li#buttonSyncDiagram.disabled")
      end
    end
  end

  describe "Other views functionality" do
    describe "Yuml view generation" do
      it "clicks the image button" do
        reset_page_to_options_with_model("simple_class.ump")
        find(:css, "#buttonYumlImage").click
        within_window("yumlClassDiagram") do
          expect(page).to have_selector("#diagram")
        end
      end

      it "clicks the label text" do
        reset_page_to_options_with_model("simple_class.ump")
        find(:css, "#labelYumlImage").click
        within_window("yumlClassDiagram") do
          expect(page).to have_selector("#diagram")
        end
      end
    end
  end
end