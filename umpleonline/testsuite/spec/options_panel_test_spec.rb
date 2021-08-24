require 'spec_helper.rb'

# These tests check that every button in the "Options" accordion panel of the 
# palette can be accessed with the label, button, and keyboard shortcuts 
# (in the options that implement a keyboard shortcut). They also ensure the 
# options have the expected effect.

describe "Option panel functionality", :helper => :optionsMenu, :feature => :optionsMenu  do
  describe "Show views inputability" do
    
    before(:all) do
      Capybara.current_session.current_window.resize_to(1024, 768)
      reset_page_to_options
    end

    describe "Clicking the show/hide diagram option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")

        page.execute_script("document.querySelector('#buttonShowHideCanvas').click()")
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        page.execute_script("document.querySelector('#buttonShowHideCanvas').click()")
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")

        page.execute_script("document.querySelector('#labelShowHideCanvas').click()")
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        page.execute_script("document.querySelector('#labelShowHideCanvas').click()")
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideCanvas")
        
        find(:css, "#textEditorColumn").send_keys(:control, 'd')
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(false)
        find(:css, "#textEditorColumn").send_keys(:control, 'd')
        expect(get_checkbox_state("#buttonShowHideCanvas")).to eq(true)
      end
    end

    describe "Clicking the show/hide text editor option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")

        page.execute_script("document.querySelector('#buttonShowHideTextEditor').click()")
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        page.execute_script("document.querySelector('#buttonShowHideTextEditor').click()")
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")

        page.execute_script("document.querySelector('#labelShowHideTextEditor').click()")
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        page.execute_script("document.querySelector('#labelShowHideTextEditor').click()")
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonShowHideTextEditor")
        
        find(:css, "#umpleCanvas").send_keys(:control, 't')
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(false)
        find(:css, "#umpleCanvas").send_keys(:control, 't')
        expect(get_checkbox_state("#buttonShowHideTextEditor")).to eq(true)
      end
    end

    describe "Clicking the show/hide layout editor option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonShowHideLayoutEditor")

        page.execute_script("document.querySelector('#buttonShowHideLayoutEditor').click()")
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(true)
        page.execute_script("document.querySelector('#buttonShowHideLayoutEditor').click()")
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonShowHideLayoutEditor")

        page.execute_script("document.querySelector('#labelShowHideLayoutEditor').click()")
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(true)
        page.execute_script("document.querySelector('#labelShowHideLayoutEditor').click()")
        expect(get_checkbox_state("#buttonShowHideLayoutEditor")).to eq(false)
      end
    end

    describe "Clicking the show/hide attributes option" do
      it "clicks the input box" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")

        page.execute_script("document.querySelector('#buttonToggleAttributes').click()")
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        page.execute_script("document.querySelector('#buttonToggleAttributes').click()")
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")

        page.execute_script("document.querySelector('#labelToggleAttributes').click()")

        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        page.execute_script("document.querySelector('#labelToggleAttributes').click()")
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options unless get_checkbox_state("#buttonToggleAttributes")
       
        find(:css, "#textEditorColumn").send_keys(:shift, :control, 'a')
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(false)
        find(:css, "#textEditorColumn").send_keys(:shift, :control, 'a')
        expect(get_checkbox_state("#buttonToggleAttributes")).to eq(true)
      end
    end

    describe "Clicking the show/hide methods option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")

        page.execute_script("document.querySelector('#buttonToggleMethods').click()")
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        page.execute_script("document.querySelector('#buttonToggleMethods').click()")
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")

        page.execute_script("document.querySelector('#labelToggleMethods').click()")
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        page.execute_script("document.querySelector('#labelToggleMethods').click()")
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end

      it "uses the keyboard shortcut" do
        reset_page_to_options if get_checkbox_state("#buttonToggleMethods")
        
        find(:css, "#textEditorColumn").send_keys(:control, 'm')
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(true)
        find(:css, "#textEditorColumn").send_keys(:control, 'm')
        expect(get_checkbox_state("#buttonToggleMethods")).to eq(false)
      end
    end

    describe "Clicking the show/hide actions option" do
      it "clicks the input box" do
        reset_page_to_options_with_stateMachine 

        page.execute_script("document.querySelector('#buttonToggleActions').click()")
        expect(get_checkbox_state("#buttonToggleActions")).to eq(false)
        page.execute_script("document.querySelector('#buttonToggleActions').click()")
        expect(get_checkbox_state("#buttonToggleActions")).to eq(true)
      end

      it "clicks the label text" do
        reset_page_to_options_with_stateMachine 
        page.execute_script("document.querySelector('#labelToggleActions').click()")
        
        expect(get_checkbox_state("#buttonToggleActions")).to eq(false)
        page.execute_script("document.querySelector('#labelToggleActions').click()")
       
        expect(get_checkbox_state("#buttonToggleActions")).to eq(true)
      end
    end
  end
  
  describe "Clicking the show/hide transition label option" do
      it "clicks the input box" do
        reset_page_to_options_with_stateMachine

        page.execute_script("document.querySelector('#buttonToggleTransitionLabels').click()")
        expect(get_checkbox_state("#buttonToggleTransitionLabels")).to eq(true)
        page.execute_script("document.querySelector('#buttonToggleTransitionLabels').click()") 
        expect(get_checkbox_state("#buttonToggleTransitionLabels")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options_with_stateMachine

        page.execute_script("document.querySelector('#labelToggleTransitionLabels').click()")
        expect(get_checkbox_state("#buttonToggleTransitionLabels")).to eq(true)
        page.execute_script("document.querySelector('#labelToggleTransitionLabels').click()")
        expect(get_checkbox_state("#buttonToggleTransitionLabels")).to eq(false)
      end
    end
  
  
  describe "Clicking the show/hide guard label option" do
      it "clicks the input box" do
        reset_page_to_options_with_stateMachine

        page.execute_script("document.querySelector('#buttonToggleGuardLabels').click()")
        expect(get_checkbox_state("#buttonToggleGuardLabels")).to eq(true)
        page.execute_script("document.querySelector('#buttonToggleGuardLabels').click()")
        expect(get_checkbox_state("#buttonToggleGuardLabels")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options_with_stateMachine
      

        page.execute_script("document.querySelector('#labelToggleGuardLabels').click()")
        expect(get_checkbox_state("#buttonToggleGuardLabels")).to eq(true)
        page.execute_script("document.querySelector('#labelToggleGuardLabels').click()")
        expect(get_checkbox_state("#buttonToggleGuardLabels")).to eq(false)
      end
    end
  

  describe "Show views functionality" do
    describe "Diagram show/hide option" do
      it "hides the diagram canvas" do
        reset_page_to_options

        expect(page).to have_selector("#umpleCanvasColumn")
        page.execute_script("document.querySelector('#buttonShowHideCanvas').click()")
        expect(page).to have_no_selector("#umpleCanvasColumn")
      end

      it "shows the diagram canvas" do
        reset_page_to_options_with_option("nodiagram")
        expect(page).to have_no_selector("#umpleCanvasColumn")

        page.execute_script("document.querySelector('#buttonShowHideCanvas').click()")
        expect(page).to have_selector("#umpleCanvasColumn")
      end
    end

    describe "Text editor show/hide option" do
      context "with menu button" do
        it "hides the text editor canvas" do
          reset_page_to_options

          expect(page).to have_selector("#textEditorColumn")
          page.execute_script("document.querySelector('#buttonShowHideTextEditor').click()")        
          expect(page).to have_no_selector("#textEditorColumn")
        end

        it "shows the text editor canvas" do
          reset_page_to_options_with_option("notext")
          expect(page).to have_no_selector("#textEditorColumn")
          page.execute_script("document.querySelector('#buttonShowHideTextEditor').click()")
          wait_for_loading
          expect(page).to have_selector("#textEditorColumn")
        end

        it "hides the text editor and layout editor"  do
          reset_page_to_options_with_option("showlayout")
          expect(page).to have_selector("#topTextEditor")
          expect(page).to have_selector("#bottomTextEditor")
          page.execute_script("document.querySelector('#buttonShowHideTextEditor').click()")
          wait_for_loading
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
          #find(:css, "#buttonShowHideLayoutEditor").click
          page.execute_script("document.querySelector('#buttonShowHideLayoutEditor').click()")
          expect(page).to have_selector("#bottomTextEditor")
        end

        it "hides the layout editor" do
          reset_page_to_options_with_option("showlayout")
          expect(page).to have_selector("#bottomTextEditor")
          page.execute_script("document.querySelector('#buttonShowHideLayoutEditor').click()")     
          expect(page).to have_no_selector("#bottomTextEditor")
        end
      end

      context "without the text editor visible" do
        it "has no effect" do
          reset_page_to_options_with_option("notext")
          expect(page).to have_no_selector("#textEditorColumn")
          page.execute_script("document.querySelector('#buttonShowHideLayoutEditor').click()")
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
        page.execute_script("document.querySelector('#buttonToggleAttributes').click()")
        wait_for_loading

        within(find(:css, "#Student")) do
          fail_message = "attributes not hidden after unchecking the attributes checkbox"
          expect(page).to have_no_selector("tr.attributeArea"), fail_message
        end
        page.execute_script("document.querySelector('#buttonToggleAttributes').click()")
        wait_for_loading

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
        page.execute_script("document.querySelector('#buttonToggleMethods').click()")
        wait_for_loading
        
        within(find(:css, "#Student")) do
          fail_message = "methods not showing after checking the methods checkbox"
          expect(page).to have_selector("tr.methodArea"), fail_message
        end
        page.execute_script("document.querySelector('#buttonToggleMethods').click()")
        wait_for_loading
       
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
          expect(find(:css, "#graph0").native.text).to include("doAction()"), fail_message
        end
        page.execute_script("document.querySelector('#buttonToggleActions').click()")
        wait_for_loading

        within(find(:css, "#umpleCanvas")) do
          fail_message = "actions still found after unchecking the methods checkbox"
          expect(find(:css, "#graph0").native.text).not_to include("doAction()"), fail_message
        end
        page.execute_script("document.querySelector('#buttonToggleActions').click()")
        wait_for_loading

        within(find(:css, "#umpleCanvas")) do
          fail_message = "actions not found after checking the methods checkbox"
          expect(find(:css, "#graph0").native.text).to include("doAction()"), fail_message
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

      find(:css, "#textEditorColumn").send_keys(:control, 'g')
      expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)
      find(:css, "#textEditorColumn").send_keys(:control, 's')
      expect(get_checkbox_state("#buttonShowGvStateDiagram")).to eq(true)
      find(:css, "#textEditorColumn").send_keys(:control, 'l')
      expect(get_checkbox_state("#buttonShowStructureDiagram")).to eq(true)
      find(:css, "#textEditorColumn").send_keys(:control, 'e')
      expect(get_checkbox_state("#buttonShowEditableClassDiagram")).to eq(true)
      find(:css, "#textEditorColumn").send_keys(:control, 'j')
      expect(get_checkbox_state("#buttonShowJointJSClassDiagram")).to eq(true)
    end

    it "cycles through the diagram types by clicking on the text labels" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options
      end

      page.execute_script("document.querySelector('#labelShowGvClassDiagram').click()")
      expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)
      page.execute_script("document.querySelector('#labelShowGvStateDiagram').click()")
      expect(get_checkbox_state("#buttonShowGvStateDiagram")).to eq(true)
      page.execute_script("document.querySelector('#labelShowStructureDiagram').click()")
      expect(get_checkbox_state("#buttonShowStructureDiagram")).to eq(true)
      page.execute_script("document.querySelector('#labelShowEditableClassDiagram').click()")
      expect(get_checkbox_state("#buttonShowEditableClassDiagram")).to eq(true)
      page.execute_script("document.querySelector('#labelShowJointJSClassDiagram').click()")
      expect(get_checkbox_state("#buttonShowJointJSClassDiagram")).to eq(true)
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
      
      page.execute_script("document.querySelector('#buttonShowGvClassDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("Student") 
      end
      
      page.execute_script("document.querySelector('#buttonShowEditableClassDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from editable class diagram to graphviz state diagram and back" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end
      
      page.execute_script("document.querySelector('#buttonShowGvStateDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("start_Student_study") 
      end
      
      page.execute_script("document.querySelector('#buttonShowEditableClassDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from editable class diagram to jointjs class diagram and back" do
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end

      page.execute_script("document.querySelector('#buttonShowJointJSClassDiagram').click()")
      wait_for_loading

      within(find(:css, ".joint-viewport")) do
        expect(find(:css, ".joint-element")["model-id"]).to eq("Student")
      end

      page.execute_script("document.querySelector('#buttonShowEditableClassDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from editable class diagram to compound structure diagram and back" do
  
      unless get_checkbox_state("#buttonShowEditableClassDiagram")
        reset_page_to_options_with_model(example_file)
      end
      
      page.execute_script("document.querySelector('#buttonShowStructureDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      page.execute_script("document.querySelector('#buttonShowEditableClassDiagram').click()")
      wait_for_loading 
      expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
    end

    it "switches from graphviz class diagram to graphviz state diagram and back" do
      unless get_checkbox_state("#buttonShowGvClassDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvClass")
      end
      
      page.execute_script("document.querySelector('#buttonShowGvStateDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("start_Student_study") 
      end
      
      page.execute_script("document.querySelector('#buttonShowGvClassDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("Student") 
      end
    end

    it "switches from graphviz class diagram to composite structure diagram and back" do
      unless get_checkbox_state("#buttonShowGvClassDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvClass")
      end
      
      page.execute_script("document.querySelector('#buttonShowStructureDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      page.execute_script("document.querySelector('#buttonShowGvClassDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("Student") 
      end
    end

    it "switches from graphviz class diagram to jointjs class diagram and back" do
      unless get_checkbox_state("#buttonShowGvClassDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvClass")
      end

      page.execute_script("document.querySelector('#buttonShowJointJSClassDiagram').click()")
      wait_for_loading

      within(find(:css, ".joint-viewport")) do
        expect(find(:css, ".joint-element")["model-id"]).to eq("Student")
      end

      page.execute_script("document.querySelector('#buttonShowGvClassDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("Student") 
      end

    end 

    it "switches from graphviz state diagram to composite structure diagram and back" do
      unless get_checkbox_state("#buttonShowGvStateDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvState")
      end
      
      page.execute_script("document.querySelector('#buttonShowGvClassDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
      
      page.execute_script("document.querySelector('#buttonShowGvStateDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("start_Student_study") 
      end
    end

    it "switches from graphviz state diagram to jointjs class diagram back" do
      unless get_checkbox_state("#buttonShowGvStateDiagram")
        reset_page_to_options_with_model_and_option(example_file, 
                                                    "diagramtype=GvState")
      end

      page.execute_script("document.querySelector('#buttonShowJointJSClassDiagram').click()")
      wait_for_loading

      within(find(:css, ".joint-viewport")) do
        expect(find(:css, ".joint-element")["model-id"]).to eq("Student")
      end
      
      page.execute_script("document.querySelector('#buttonShowGvStateDiagram').click()")
      wait_for_loading
      within(find(:css, "#node1")) do
        expect(page.evaluate_script("jQuery(\"#node1 title\").text()")).to eq("start_Student_study") 
      end
    end

    it "switches from jointjs class diagram to composite structure diagram and back" do
        unless get_checkbox_state("#buttonShowStructureDiagram")
          reset_page_to_options_with_model_and_option(example_file, 
                                                      "diagramtype=structureDiagram")
        end

        page.execute_script("document.querySelector('#buttonShowJointJSClassDiagram').click()")
        wait_for_loading

        within(find(:css, ".joint-viewport")) do
          expect(find(:css, ".joint-element")["model-id"]).to eq("Student")
        end

        page.execute_script("document.querySelector('#buttonShowStructureDiagram').click()")
        wait_for_loading
        expect(find(:css, "#umpleCanvas")).to have_selector("#svgCanvas")
    end

  end

  describe "Checking for no diagram code found message" do
    before(:all) {reset_page_to_options}

    it "checks for no state diagram code found message" do
      expected_message = "No state machine found in the input Umple file"
      page.execute_script("document.querySelector('#buttonShowGvStateDiagram').click()")
      wait_for_loading
      expect(find(:css, "#umpleCanvas").native.text).to include(expected_message)
    end

    it "checks for no compound structure diagram code found message" do
      expected_message = "No composite structure found in the input Umple model"
      page.execute_script("document.querySelector('#buttonShowStructureDiagram').click()")
      wait_for_loading
      expect(find(:css, "#svgCanvas").native.text).to include(expected_message)
    end
  end

  describe "Preferences inputability" do

    before(:all) {reset_page_to_options} 

    describe "Clicking the photoready option" do

      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonPhotoReady") 
        page.execute_script("document.querySelector('#buttonPhotoReady').click()")
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(true)
        page.execute_script("document.querySelector('#buttonPhotoReady').click()")
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonPhotoReady") 
        page.execute_script("document.querySelector('#labelPhotoReady').click()")
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(true)
        page.execute_script("document.querySelector('#labelPhotoReady').click()")
        expect(get_checkbox_state("#buttonPhotoReady")).to eq(false)
      end
    end

    describe "Clicking the manual sync option" do
      it "clicks the input box" do
        reset_page_to_options if get_checkbox_state("#buttonManualSync") 
        page.execute_script("document.querySelector('#buttonManualSync').click()")
        expect(get_checkbox_state("#buttonManualSync")).to eq(true)
        page.execute_script("document.querySelector('#buttonManualSync').click()")
        expect(get_checkbox_state("#buttonManualSync")).to eq(false)
      end

      it "clicks the label text" do
        reset_page_to_options if get_checkbox_state("#buttonManualSync") 
        page.execute_script("document.querySelector('#labelManualSync').click()")
        expect(get_checkbox_state("#buttonManualSync")).to eq(true)
        page.execute_script("document.querySelector('#labelManualSync').click()")
        expect(get_checkbox_state("#buttonManualSync")).to eq(false)
      end
    end

    describe "Clicking the Pinch to Zoom Option" do
      #loads umple with the Graphviz Class Diagram option selected
      before(:all) {reset_page_to_options_with_model_and_option("simple_class.ump", 
        "diagramtype=GvClass")}
      it "clicks the input box" do
        if get_checkbox_state("#buttonShowGvClassDiagram")
          reset_page_to_options_with_model_and_option("simple_class.ump", 
            "diagramtype=GvClass") 
        end

        expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)

        expect(get_checkbox_state("#buttonAllowPinch")).to eq(false)

        find("#buttonAllowPinch").click
        expect(get_checkbox_state("#buttonAllowPinch")).to eq(true)
      end

      it "clicks the label text" do
        if get_checkbox_state("#buttonShowGvClassDiagram")
          reset_page_to_options_with_model_and_option("simple_class.ump", 
            "diagramtype=GvClass") 
        end

        expect(get_checkbox_state("#buttonShowGvClassDiagram")).to eq(true)

        expect(get_checkbox_state("#buttonAllowPinch")).to eq(false)

        find("#labelAllowPinch").click
        expect(get_checkbox_state("#buttonAllowPinch")).to eq(true)

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
        page.execute_script("document.querySelector('#buttonPhotoReady').click()")
        wait_for_loading

        expect(find(:css, "#umpleCanvasColumn")).to have_css("div.photoReady")
        within(find(:css, "#Student")) do
          expect(find(:css, "#Student_newAttribute").native.text.chomp).to eq(" ")
        end 

        page.execute_script("document.querySelector('#buttonPhotoReady').click()")
        wait_for_loading

        expect(find(:css, "#umpleCanvasColumn")).to_not have_css("div.photoReady")
        within(find(:css, "#Student")) do
          expect(find(:css, "#Student_newAttribute").native.text.chomp).to eq("-- Add More --")
        end
      end
    end

    describe "Manual Sync option" do
      before(:all) {reset_page_to_options}
      it "turns manual sync on then off again" do
        if get_checkbox_state("#buttonManualSync")
          reset_page_to_options
        end

        page.execute_script("document.querySelector('#buttonManualSync').click()")

        input_model_text("class Student {}")
        switch_to_tools_panel

        expect(find("#umpleCanvas")).to have_selector("div#syncNeededMessage")
        expect(find(:css, "#umpleCanvas")).to have_no_selector("#Student")
        expect(page).to have_no_css("li#buttonSyncDiagram.disabled")

        switch_to_options_panel
 
        page.execute_script("document.querySelector('#buttonManualSync').click()")
  
        switch_to_tools_panel
        sleep 2      
        
        expect(find("#umpleCanvas")).to have_no_selector("div#syncNeededMessage")
        expect(find(:css, "#umpleCanvas")).to have_selector("#Student")
        expect(page).to have_css("li#buttonSyncDiagram.disabled")
      end
    end
  end
end
