require 'spec_helper.rb'

# These test that editing the diagram using the graphical tools leaves the 
# model in a correct state.

describe "Graphical editing of diagram: model consistency", 
  :helper => :diagramEditing, 
  :feature => :diagramEditing do

  before(:all) {page.driver.resize(1024, 768)}

  describe "Adding an umpleClass" do
    before(:each) {load_page}

    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "adds an umpleClass" do
        find(:css, '#umpleCanvas').native.send_key('c')
        find(:css, '#umpleCanvas').click
        wait_for_loading
        verify_diagram_contains("#NewClass")

        verify_text_ignore_position("after_adding_class.ump")
      end
    end

    context "with menu button" do
      it "adds an umpleClass" do
        find(:css, '#buttonAddClass').click
        find(:css, '#umpleCanvas').click
        wait_for_loading
        verify_diagram_contains("#NewClass")

        verify_text_ignore_position("after_adding_class.ump")
      end
    end
  end

  describe "Deleting an umpleClass" do
    before(:each) do
      load_umple_with_file_model_helper("single_class.ump")
      within("div#umpleCanvas") {find(:css, "#Student")}
    end
    
    context "with keyboard shortcut" do
      context "with the delete key" do
        before(:each) {get_canvas_focus}
        it "deletes an umpleClass" do
          within("div#umpleCanvas") {find(:css, '#Student').native.send_key(:Delete)}

          wait_for_loading
          verify_diagram_does_not_contain("#Student")

          verify_text_ignore_position("empty_file.ump")
        end
      end

      context "with the backspace key" do
        before(:each) {get_canvas_focus}
        it "deletes an umpleClass" do
          within("div#umpleCanvas") {find(:css, '#Student').native.send_key(:Backspace)}

          wait_for_loading
          verify_diagram_does_not_contain("#Student")

          verify_text_ignore_position("empty_file.ump")
        end
      end
    end

    context "with menu button" do
      it "deletes an umpleClass" do
        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#Student').click}
        wait_for_loading
        verify_diagram_does_not_contain("#Student")

        verify_text_ignore_position("empty_file.ump")
      end
    end
  end

  describe "Adding a reflexive association" do
    before(:each) {load_umple_with_file_model_helper("single_class.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "adds a reflexive association" do
        find(:css, '#umpleCanvas').native.send_keys("a")
        within("div#umpleCanvas") do
          find(:css, "#Student").click
          find(:css, "#Student").click
        end

        wait_for_loading
        expect(find(:css, "#umpleCanvas")).to have_selector("#umpleAssociation_0")
        verify_text_ignore_position("after_adding_reflexive_association.ump")
      end
    end

    context "with menu button" do
      it "adds a reflexive association" do
        find(:css, '#buttonAddAssociation').click
        within("div#umpleCanvas") do
          find(:css, "#Student").click
          find(:css, "#Student").click
        end

        wait_for_loading
        expect(find(:css, "#umpleCanvas")).to have_selector("#umpleAssociation_0")
        verify_text_ignore_position("after_adding_reflexive_association.ump")
      end
    end
  end

  describe "Deleting a reflexive association" do 
    before(:each) {load_umple_with_file_model_helper("single_class_with_reflexive_association.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes a reflexive association" do
        within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_one').native.send_keys(:Delete)}
        
        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_reflexive_association.ump")
      end
    end

    context "with menu button" do
      it "deletes a reflexive association" do
        find(:css, '#buttonDeleteEntity').click
        element = within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_one').click}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_reflexive_association.ump")
      end
    end
  end

  describe "Deleting an umpleClass with a reflexive association" do 
    before(:each) {load_umple_with_file_model_helper("single_class_with_reflexive_association.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes an umpleClass with a reflexive association" do
        within("div#umpleCanvas") do
          #Ensure the association existed before attempting to delete it
          find(:css, "#umpleAssociation_0")

          find(:css, "#Student").native.send_keys(:Delete)
        end

        wait_for_loading
        verify_diagram_does_not_contain("#Student")
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("empty_file.ump")
      end
    end

    context "with menu button" do
      it "deletes an umpleClass with a reflexive association" do
        #Ensure the association existed before attempting to delete it
        within("div#umpleCanvas") {find(:css, "#umpleAssociation_0")}

        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#Student').click}

        wait_for_loading
        verify_diagram_does_not_contain("#Student")
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("empty_file.ump")
      end
    end
  end

  describe "Deleting an umpleClass with two reflexive associations" do
    before(:each) {load_umple_with_file_model_helper("single_class_with_two_reflexive_associations.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes an umpleClass with two reflexive associations" do
        within("div#umpleCanvas") do
          #Ensure the associations existed before attempting to delete them
          find(:css, "#umpleAssociation_0")
          find(:css, "#umpleAssociation_1")

          find(:css, '#Student').native.send_keys(:Delete)
        end

        wait_for_loading
        verify_diagram_does_not_contain("#Student")
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_diagram_does_not_contain("#umpleAssociation_1")
        verify_text_ignore_position("empty_file.ump")
      end
    end

    context "with menu button" do
      it "deletes an umpleClass with two reflexive associations" do
        within("div#umpleCanvas") do
          #Ensure the associations existed before attempting to delete them
          find(:css, "#umpleAssociation_0")
          find(:css, "#umpleAssociation_1")
        end
        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#Student').click}

        wait_for_loading
        verify_diagram_does_not_contain("#Student")
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_diagram_does_not_contain("#umpleAssociation_1")
        verify_text_ignore_position("empty_file.ump")
      end
    end
  end

  describe "Adding an association" do
    before(:each) {load_umple_with_file_model_helper("two_classes.ump")}
    
    context "with keyboard shortcut" do
      context "first direction (Student to Mentor)" do
        before(:each) {get_canvas_focus}
        it "creates an association" do
          find(:css, '#umpleCanvas').native.send_keys("a")
          within("div#umpleCanvas") do
            find(:css, "#Student").click
            sleep(1)
            find(:css, "#Mentor").click
          end

          wait_for_loading
          verify_diagram_contains("#umpleAssociation_0")
          verify_text_ignore_position("after_adding_association.ump")
        end
      end

      context "second direction (Mentor to Student)" do
        before(:each) {get_canvas_focus}
        it "creates an association" do
          find(:css, '#umpleCanvas').native.send_keys("a")
          within("div#umpleCanvas") do
            find(:css, "#Mentor").click
            sleep(1)
            find(:css, "#Student").click
          end

          wait_for_loading
          verify_diagram_contains("#umpleAssociation_0")
          verify_text_ignore_position("after_adding_association.ump")
        end
      end
    end

    context "with menu button" do
      context "first direction (Student to Mentor)" do
        it "creates an association" do
          find(:css, "#buttonAddAssociation").click
          within("div#umpleCanvas") do
            find(:css, "#Student").click
            find(:css, "#Mentor").click
          end

          wait_for_loading
          verify_diagram_contains("#umpleAssociation_0")
          verify_text_ignore_position("after_adding_association.ump")
        end
      end

      context "second direction (Mentor to Student)" do
        it "creates an association" do
          find(:css, "#buttonAddAssociation").click
          within("div#umpleCanvas") do
            find(:css, "#Mentor").click
            find(:css, "#Student").click
          end

          wait_for_loading
          verify_diagram_contains("#umpleAssociation_0")
          verify_text_ignore_position("after_adding_association.ump")
        end
      end
    end
  end

  describe "Adding a generalization" do
    before(:each) {load_umple_with_file_model_helper("two_classes.ump")}
    
    context "with keyboard shortcut" do
      context "first direction (Student to Mentor)" do
        before(:each) {get_canvas_focus}
        it "creates a generalization" do
          find(:css, '#umpleCanvas').native.send_keys("g")
          within("div#umpleCanvas") do
            find(:css, "#Student").click
            find(:css, "#Mentor").click
          end

          wait_for_loading
          verify_diagram_contains("#Student_generalization")
          verify_text_ignore_position("after_adding_generalization_S_M.ump")
        end
      end

      context "second direction (Mentor to Student)" do
        before(:each) {get_canvas_focus}
        it "creates a generalization" do
          find(:css, '#umpleCanvas').native.send_keys("g")
          within("div#umpleCanvas") do
            find(:css, "#Mentor").click
            find(:css, "#Student").click
          end

          wait_for_loading
          verify_diagram_contains("#Mentor_generalization")
          verify_text_ignore_position("after_adding_generalization_M_S.ump")
        end
      end
    end

    context "with menu button" do
      context "first direction (Student to Mentor)" do
        it "creates a generalization" do
          find(:css, "#buttonAddGeneralization").click
           within("div#umpleCanvas") do
            find(:css, "#Student").click
            find(:css, "#Mentor").click
          end

          wait_for_loading
          verify_diagram_contains("#Student_generalization")
          verify_text_ignore_position("after_adding_generalization_S_M.ump")
        end
      end

      context "second direction (Mentor to Student)" do
        it "creates a generalization" do
          find(:css, "#buttonAddGeneralization").click
           within("div#umpleCanvas") do
            find(:css, "#Mentor").click
            find(:css, "#Student").click
          end

          wait_for_loading
          verify_diagram_contains("#Mentor_generalization")
          verify_text_ignore_position("after_adding_generalization_M_S.ump")
        end
      end
    end
  end

  describe "Deleting an association" do
    before(:each) {load_umple_with_file_model_helper("two_classes_with_association.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes an association" do
        within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_one').native.send_keys(:Delete)}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_generalization_or_association.ump")
      end
    end

    context "with menu button" do
      it "deletes an association" do
        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_one').click}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_generalization_or_association.ump")
      end
    end
  end

  describe "Deleting an umpleClass with an association" do
    before(:each) {load_umple_with_file_model_helper("two_classes_with_association.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes an umpleClass with an association" do
        within("div#umpleCanvas") do
          #Ensure the association existed before attempting to delete it
          find(:css, "#umpleAssociation_0")

          find(:css, '#Student').native.send_keys(:Delete)
        end

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_diagram_does_not_contain("#Student")
        verify_text_ignore_position("after_removing_association_or_generalization_via_class.ump")
      end
    end

    context "with menu button" do
      it "deletes an umpleClass with an association" do
        #Ensure the association existed before attempting to delete it
        within("div#umpleCanvas") {find(:css, "#umpleAssociation_0")}

        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#Student').click}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_diagram_does_not_contain("#Student")
        verify_text_ignore_position("after_removing_association_or_generalization_via_class.ump")
      end
    end
  end

  describe "Deleting a generalization" do 
    before(:each) {load_umple_with_file_model_helper("two_classes_with_generalization.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes a generalization" do
        within('#Mentor_generalization') {all(:css, 'div.umpleAssociationSelector')[1].native.send_keys(:Delete)}

        wait_for_loading
        verify_diagram_does_not_contain("#Mentor_generalization")
        verify_text_ignore_position("after_removing_generalization_or_association.ump")
      end
    end

    context "with menu button" do
      it "deletes a generalization" do
        find(:css, '#buttonDeleteEntity').click
        within('#Mentor_generalization') {all(:css, 'div.umpleAssociationSelector')[1].click}

        wait_for_loading
        verify_diagram_does_not_contain("#Mentor_generalization")
        verify_text_ignore_position("after_removing_generalization_or_association.ump")
      end
    end
  end

  describe "Deleting a superclass" do
    context "with a single subclass" do
      before(:each) {load_umple_with_file_model_helper("two_classes_with_generalization.ump")}
      
      context "with keyboard shortcut" do
        before(:each) {get_canvas_focus}
        it "deletes a superclass" do
          within("div#umpleCanvas") do
            #Ensure the generalization existed before attempting to delete it
            find(:css, "#Mentor_generalization")

            find(:css, '#Student').native.send_keys(:Delete)
          end

          wait_for_loading
          verify_diagram_does_not_contain("#Mentor_generalization")
          verify_diagram_does_not_contain("#Student")
          verify_text_ignore_position("after_removing_association_or_generalization_via_class.ump")
        end
      end

      context "with menu button" do
        it "deletes a superclass" do
          #Ensure the generalization existed before attempting to delete it
          within("div#umpleCanvas") {find(:css, "#Mentor_generalization")}

          find(:css, '#buttonDeleteEntity').click
          within("div#umpleCanvas") {find(:css, '#Student').click}

          wait_for_loading
          verify_diagram_does_not_contain("#Mentor_generalization")
          verify_diagram_does_not_contain("#Student")
          verify_text_ignore_position("after_removing_association_or_generalization_via_class.ump")
        end
      end
    end

    context "with multiple subclasses" do 
      before(:each) {load_umple_with_file_model_helper("three_classes_with_two_generalizations.ump")}
      
      context "with keyboard shortcut" do
        before(:each) {get_canvas_focus}
        it "deletes a superclass" do
          within("div#umpleCanvas") do
            #Ensure the generalizations existed before attempting to delete them
            find(:css, "#Mentor_generalization")
            find(:css, "#TeachingAssistant_generalization")

            find(:css, '#Student').native.send_keys(:Delete)
          end

          wait_for_loading
          verify_diagram_does_not_contain("#Mentor_generalization")
          verify_diagram_does_not_contain("#TeachingAssistant_generalization")
          verify_diagram_does_not_contain("#Student")
          verify_text_ignore_position("after_removing_superclass.ump")
        end
      end

      context "with menu button" do
        it "deletes a superclass" do
          within("div#umpleCanvas") do
            #Ensure the generalizations existed before attempting to delete them
            find(:css, "#Mentor_generalization")
            find(:css, "#TeachingAssistant_generalization")
          end
          find(:css, '#buttonDeleteEntity').click
          within("div#umpleCanvas") {find(:css, '#Student').click}

          wait_for_loading
          verify_diagram_does_not_contain("#Mentor_generalization")
          verify_diagram_does_not_contain("#TeachingAssistant_generalization")
          verify_diagram_does_not_contain("#Student")
          verify_text_ignore_position("after_removing_superclass.ump")
        end
      end
    end
  end

  describe "Deleting a subclass" do
    before(:each) {load_umple_with_file_model_helper("two_classes_with_generalization.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes a subclass" do
        within("div#umpleCanvas") do
          #Ensure the generalization existed before attempting to delete it
          find(:css, "#Mentor_generalization")

          find(:css, '#Mentor').native.send_keys(:Delete)
        end

        wait_for_loading
        verify_diagram_does_not_contain("#Mentor_generalization")
        verify_diagram_does_not_contain("#Mentor")
        verify_text_ignore_position("after_removing_subclass.ump")
      end
    end

    context "with menu button" do
      it "deletes a subclass" do
        #Ensure the generalization existed before attempting to delete it
        within("div#umpleCanvas") {find(:css, "#Mentor_generalization")}

        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#Mentor').click}

        wait_for_loading
        verify_diagram_does_not_contain("#Mentor_generalization")
        verify_diagram_does_not_contain("#Mentor")
        verify_text_ignore_position("after_removing_subclass.ump")
      end
    end
  end

  describe "Deleting a symmetric reflexive association" do
    before(:each) {load_umple_with_file_model_helper("single_class_with_symmetric_reflexive_association.ump")}
    
    context "with keyboard shortcut" do
      before(:each) {get_canvas_focus}
      it "deletes a symmetric reflexive association" do
        within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_center').native.send_keys(:Delete)}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_reflexive_association.ump")
      end
    end

    context "with menu button" do
      it "deletes a symmetric reflexive association" do
        find(:css, '#buttonDeleteEntity').click
        within("div#umpleCanvas") {find(:css, '#umpleAssociation_0_center').click}

        wait_for_loading
        verify_diagram_does_not_contain("#umpleAssociation_0")
        verify_text_ignore_position("after_removing_reflexive_association.ump")
      end
    end
  end

  # TODO this fails on a non-local server. Probably needs longer than the 10 second
  # capybara timeout when fetching from a non-local server.
  describe "Deleting many elements" do
    before(:each) {load_umple_with_file_model_helper("complex_diagram.ump")}
    
    it "deletes many elements" do
      #delete NewClass2
      within("div#umpleCanvas") {find(:css, '#NewClass2').native.send_keys(:Delete)}

      #delete umpleAssociation_4
      within("div#umpleCanvas") {find(:css, '#umpleAssociation_4_one').native.send_keys(:Delete)}

      #delete NewClass
      within("div#umpleCanvas") {find(:css, '#NewClass').native.send_keys(:Delete)}

      wait_for_loading_for 10
      verify_diagram_contains "#NewClass1"
      verify_diagram_contains "#NewClass3"
      verify_diagram_contains "#NewClass4"
      verify_diagram_contains "#NewClass5"

      verify_diagram_does_not_contain "#NewClass"
      verify_diagram_does_not_contain "#NewClass2"

      verify_diagram_does_not_contain "#umpleAssociation_0"
      verify_diagram_does_not_contain "#umpleAssociation_1"
      verify_diagram_does_not_contain "#umpleAssociation_2"
      verify_diagram_does_not_contain "#umpleAssociation_3"
      verify_diagram_does_not_contain "#umpleAssociation_4"

      verify_diagram_does_not_contain "#NewClass3_generalization"
      verify_diagram_does_not_contain "#NewClass4_generalization"
      verify_diagram_does_not_contain "#NewClass5_generalization"

      verify_text_ignore_position "after_deletion_complex_diagram.ump"
    end
  end
end
