require 'rspec'
require 'capybara'
require 'capybara/dsl'
require 'spec_helper.rb'

# These tests ensure that the editing the diagram with the graphical tools leave
# the model elements in the right places on screen.

describe "Graphical editing of diagram: positional consistency", 
  :helper => :diagramEditing, 
  :feature => :positionalDiagramEditing do 

  before(:all) {page.driver.resize(1024, 768)}
    
  describe "Loading umple models" do
    context "with positional data" do

      it "loads a model with a class" do
        load_umple_with_file_and_layout("single_class.ump")

        find(:css, "#Student")
        
        position = class_diagram_position_of("Student")
        code_position = class_code_position_of("Student")

        expect(position).to have_position(code_position)
      end

      it "loads a model with a reflexive association" do

        load_umple_with_file_and_layout("single_class_with_reflexive_association.ump")

        find(:css, '#Student')

        association_position = 
          association_diagram_position_of("Student", "Student", "peer")
        association_code_position = 
          association_code_position_of("Student", "Student", "peer")
        association_code_position = 
          transform_association_position_relative_to_canvas(
            association_code_position)

        expect(association_code_position).to be_within_anchor_size(
          association_position)
      end

      #with a class+symmreflexive #TODO make positional data for this always show (it doesn't at all)
      it "loads a model with a symmetric reflexive association" do
        pending("implementation of positional data for symmetric reflexive associations")
        fail
      end

      it "loads a model with a two classes and an association" do
        load_umple_with_file_and_layout("two_classes_with_association.ump")

        find(:css, "#Student")

        association_position = 
          association_diagram_position_of("Student", "Mentor")
        association_code_position = 
          association_code_position_of("Student", "Mentor")
        association_code_position = 
          transform_association_position_relative_to_canvas(
            association_code_position)

        expect(association_code_position).to be_within_anchor_size(
          association_position)
      end
    end
  end

  describe "Adding an umpleClass with a particular position" do
    it "adds an umpleClass at a particular position" do
      load_page
      wait_for_loading

      find(:css, '#umpleCanvas').native.send_keys("c")
      expected_position = [55, 135]
      abs_canvas_pos = get_absolute_position("#umpleCanvas")

      page.driver.click(expected_position[0] + abs_canvas_pos[0],
                        expected_position[1] + abs_canvas_pos[1])
      wait_for_loading

      expect(class_diagram_position_of("NewClass")).to have_position(expected_position)
      expect(class_code_position_of("NewClass")).to have_code_position(expected_position)
    end
  end

  describe "Adding a reflexive association" do
    before(:each) do
      load_umple_with_file_and_layout("single_class.ump")
    end
    it "Adds a reflexive association with an anchor snapped to the left edge" do
      class_position = get_absolute_position("#Student")
      class_code = class_code_position_of "Student"
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") {find(:css, "#Student").click}
      page.driver.click(class_position[0] + 5, 
                        class_position[1] + class_code[:size][1]/2)
      wait_for_loading
      code_pos = association_code_position_of(
        "Student", "Student", "roleName")[:end_two]
      actual_pos = association_diagram_position_of(
        "Student", "Student", "roleName")[:end_two]

      expect(code_pos).to have_code_position([0, 22])
      expect(actual_pos).to have_position_within_anchor_size([99, 51])
    end

    it "Adds a reflexive association with an anchor snapped to the top edge" do
      class_position = get_absolute_position("#Student")
      class_code = class_code_position_of "Student"
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") {find(:css, "#Student").click}
      page.driver.click(class_position[0] + class_code[:size][0]/2, 
                        class_position[1] + 5)
      wait_for_loading
      code_pos = association_code_position_of(
        "Student", "Student", "roleName")[:end_two]
      actual_pos = association_diagram_position_of(
        "Student", "Student", "roleName")[:end_two]

      expect(code_pos).to have_code_position([54, 0])
      expect(actual_pos).to have_position_within_anchor_size([153, 29])
    end

    it "Adds a reflexive association with an anchor snapped to the right edge" do
      class_position = get_absolute_position("#Student")
      class_code = class_code_position_of "Student"
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") {find(:css, "#Student").click}
      page.driver.click(class_position[0] + class_code[:size][0] - 5, 
                        class_position[1] + class_code[:size][1]/2)
      wait_for_loading
      code_pos = association_code_position_of(
        "Student", "Student", "roleName")[:end_two]
      actual_pos = association_diagram_position_of(
        "Student", "Student", "roleName")[:end_two]

      expect(code_pos).to have_code_position([109, 22])
      expect(actual_pos).to have_position_within_anchor_size([209, 51])
    end

    it "Adds a reflexive association with an anchor snapped to the bottom edge" do
      class_position = get_absolute_position("#Student")
      class_code = class_code_position_of "Student"
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") {find(:css, "#Student").click}
      page.driver.click(class_position[0] + class_code[:size][0]/2, 
                        class_position[1] + class_code[:size][1] - 5)
      wait_for_loading
      code_pos = association_code_position_of(
        "Student", "Student", "roleName")[:end_two]
      actual_pos = association_diagram_position_of(
        "Student", "Student", "roleName")[:end_two]

      expect(code_pos).to have_code_position([54, 45])
      expect(actual_pos).to have_position_within_anchor_size([153, 74])
    end
  end

  describe "Adding an association between two classes" do
    before(:each) do
      load_umple_with_file_and_layout("five_classes.ump")
    end
    it "snaps the association anchor to the left edge" do
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") do
        find(:css, "#ACenter").click
        find(:css, "#Left").click
      end

      anchor_pos = association_diagram_position_of("ACenter", "Left")
      anchor_pos = anchor_pos[:end_one]

      anchor_code_pos = association_code_position_of("ACenter", "Left")
      if(anchor_code_pos[:end_one][:end_class] == "ACenter")
        anchor_code_pos = anchor_code_pos[:end_one]
      else
        anchor_code_pos = anchor_code_pos[:end_two]
      end

      expect(anchor_pos).to have_position_within_anchor_size([137, 151])
      expect(anchor_code_pos).to have_code_position([0, 23])
    end

    it "snaps the association anchor to the top edge" do
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") do
        find(:css, "#ACenter").click
        find(:css, "#Top").click
      end

      anchor_pos = association_diagram_position_of("ACenter", "Top")
      anchor_pos = anchor_pos[:end_one]

      anchor_code_pos = association_code_position_of("ACenter", "Top")
      if(anchor_code_pos[:end_one][:end_class] == "ACenter")
        anchor_code_pos = anchor_code_pos[:end_one]
      else
        anchor_code_pos = anchor_code_pos[:end_two]
      end

      expect(anchor_pos).to have_position_within_anchor_size([192, 129])
      expect(anchor_code_pos).to have_code_position([55, 0])
    end

    it "snaps the association anchor to the right edge" do
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") do
        find(:css, "#ACenter").click
        find(:css, "#Right").click
      end
      
      anchor_pos = association_diagram_position_of("ACenter", "Right")
      anchor_pos = anchor_pos[:end_one]

      anchor_code_pos = association_code_position_of("ACenter", "Right")
      if(anchor_code_pos[:end_one][:end_class] == "ACenter")
        anchor_code_pos = anchor_code_pos[:end_one]
      else
        anchor_code_pos = anchor_code_pos[:end_two]
      end

      expect(anchor_pos).to have_position_within_anchor_size([246, 151])
      expect(anchor_code_pos).to have_code_position([110, 23])
    end

    it "snaps the association anchor to the bottom edge" do
      find(:css, '#buttonAddAssociation').click
      within("div#umpleCanvas") do
        find(:css, "#ACenter").click
        find(:css, "#Bottom").click
      end
      
      anchor_pos = association_diagram_position_of("ACenter", "Bottom")
      anchor_pos = anchor_pos[:end_one]

      anchor_code_pos = association_code_position_of("ACenter", "Bottom")
      if(anchor_code_pos[:end_one][:end_class] == "ACenter")
        anchor_code_pos = anchor_code_pos[:end_one]
      else
        anchor_code_pos = anchor_code_pos[:end_two]
      end

      expect(anchor_pos).to have_position_within_anchor_size([192, 174])
      expect(anchor_code_pos).to have_code_position([55, 45])
    end
  end

  #add a generalization
  describe "Adding a generalization" do
    before(:each) do
      load_umple_with_file_and_layout("two_classes.ump")
    end
    it "adds a generalization between two classes" do
      pending("a way to test: the position is not tracked in the code " + 
        "nor do any html elements have unique ids")
      fail
    end
  end

  describe "Moving an umpleClass" do
    context "with no other features" do
      before(:each) do
        load_umple_with_file_and_layout("single_class.ump")
      end

      it "moves the umpleClass graphically in the canvas" do
        expected_position = [100, 200]
        click_and_drag_element_in_canvas_to("Student", 
                                            expected_position[0], 
                                            expected_position[1])
        wait_for_loading
        expect(class_diagram_position_of("Student")).to have_position(expected_position) 
        expect(class_code_position_of("Student")).to have_code_position(expected_position) 
      end
    end

    context "with a reflexive association" do
      before(:each) do
        load_umple_with_file_and_layout("single_class_with_reflexive_association.ump")
      end
      it "moves a class with a reflexive association" do 
        expected_pos = association_diagram_position_of("Student", "Student", "peer")

        drag_amount = [50, 50]
        expected_pos[:end_one][:position][0] += drag_amount[0]
        expected_pos[:end_one][:position][1] += drag_amount[1]
        expected_pos[:end_two][:position][0] += drag_amount[0]
        expected_pos[:end_two][:position][1] += drag_amount[1]

        click_and_drag_element_by("Student", 
                                  drag_amount[0], 
                                  drag_amount[1])

        new_anchor_pos = association_diagram_position_of("Student", "Student", "peer")

        expect(expected_pos).to be_within_anchor_size(new_anchor_pos)
      end
    end

    #TODO fix symmreflexive association position code not appearing
    context "with a symmetric reflexive association" do
      before(:each) do
        load_umple_with_file_and_layout("single_class_with_symmetric_reflexive_association.ump")
      end
      it "moves a class with a symmetric reflexive association" do 
        pending("implementation, symmetric reflexive position code")
        fail
      end
    end

    context "with a normal association" do
      before(:each) do
        load_umple_with_file_and_layout("two_classes_with_association_centered.ump")
      end
      
      #TODO these fail on a non-local server
      describe "moving a class to move association anchors to other sides" do

        it "moves association anchor from top to bottom" do
          size_of_unmoved = screen_size_of("Mentor")
          
          move_by = [0, 155]
          click_and_drag_element_by("Student", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")

          if(code_pos[:end_one][:end_class] == "Mentor")
            code_pos = code_pos[:end_one][:position][1]
          else
            code_pos = code_pos[:end_two][:position][1]
          end

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_two][:position][1]
          
          expect(code_pos).to eq(size_of_unmoved[:size][1])
          expect(real_pos).to eq(242)
        end

        it "moves association anchor from top to right" do
          size_of_unmoved = screen_size_of("Mentor")

          move_by = [150, 100]
          click_and_drag_element_by("Student", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")

          if(code_pos[:end_one][:end_class] == "Mentor")
            code_pos = code_pos[:end_one][:position][0]
          else
            code_pos = code_pos[:end_two][:position][0]
          end

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_two][:position][1]

          expect(code_pos).to eq(size_of_unmoved[:size][0])
          expect(real_pos).to eq(221)
        end

        it "moves association anchor from top to left" do
          size_of_unmoved = screen_size_of("Mentor")

          move_by = [-150, 100]
          click_and_drag_element_by("Student", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")
          code_pos = code_pos[:end_two][:position][0]

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_two][:position][1]
    

          expect(code_pos).to eq(0)
          expect(real_pos).to eq(206)
        end

        it "moves association anchor from bottom to top" do
          size_of_unmoved = screen_size_of("Student")

          move_by = [0, -155]
          click_and_drag_element_by("Mentor", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")

          if(code_pos[:end_one][:end_class] == "Student")
            code_pos = code_pos[:end_one][:position][1]
          else
            code_pos = code_pos[:end_two][:position][1]
          end

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_one][:position][1]

          expect(code_pos).to eq(0)
          expect(real_pos).to eq(97)
        end

        it "moves association anchor from bottom to right" do
          size_of_unmoved = screen_size_of("Student")

          move_by = [150, -100]
          click_and_drag_element_by("Mentor", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")

          if(code_pos[:end_one][:end_class] == "Student")
            code_pos = code_pos[:end_one][:position][0]
          else
            code_pos = code_pos[:end_two][:position][0]
          end

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_one][:position][0]

          expect(code_pos).to eq(size_of_unmoved[:size][0])
          expect(real_pos).to eq(257)
        end

        it "moves association anchor from bottom to left" do
          size_of_unmoved = screen_size_of("Student")

          move_by = [-150, -100]
          click_and_drag_element_by("Mentor", move_by[0], move_by[1])

          code_pos = association_code_position_of("Student", "Mentor")

          if(code_pos[:end_one][:end_class] == "Student")
            code_pos = code_pos[:end_one][:position][0]
          else
            code_pos = code_pos[:end_two][:position][0]
          end

          real_pos = association_diagram_position_of("Student", "Mentor")
          real_pos = real_pos[:end_one][:position][0]

          expect(code_pos).to eq(0)
          expect(real_pos).to eq(147)
        end
      end
    end

    #move a class w/generalization
        #transition from top to bottom
    context "with a generalization" do
      before(:each) do
        load_umple_with_file_and_layout("two_classes_with_generalization.ump")
      end
      context "move the subclass" do
        it "moves a subclass" do
          pending("a way to test: the position is not tracked in the code " + 
            "nor do any html elements have unique ids")
          fail
        end
      end

      context "move the superclass" do
        it "moves a superclass" do
          pending("a way to test: the position is not tracked in the code " + 
            "nor do any html elements have unique ids")
          fail
        end
      end
    end
  end

  describe "Moving association anchors" do
    describe "Moving anchor on the left edge of a class" do
      association_id = nil

      before (:each) do
        load_umple_with_file_and_layout("two_classes_with_association_left.ump")
        association_id = activate_association("Mentor", "Student")
      end

      it "Moves the anchor left" do
        move_by = [-10, 0]

        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([0, 17])
        expect(actual_pos).to have_position_within_anchor_size([224, 137])
      end

      it "Moves the anchor right" do
        move_by = [10, 0]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([0, 17])
        expect(actual_pos).to have_position_within_anchor_size([224, 137])
      end

      it "Moves the anchor up" do
        move_by = [0, -5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([0, 12])
        expect(actual_pos).to have_position_within_anchor_size([224, 132])
      end

      it "Moves the anchor down" do
        move_by = [0, 5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([0, 22])
        expect(actual_pos).to have_position_within_anchor_size([224, 142])
      end
    end

    describe "Moving anchor on the top edge of a class" do
      association_id = nil

      before (:each) do
        load_umple_with_file_and_layout("two_classes_with_association_top.ump")
        association_id = activate_association("Mentor", "Student")
      end

      it "Moves the anchor left" do
        move_by = [-10, 0]

        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([45, 0])
        expect(actual_pos).to have_position_within_anchor_size([146, 233])
      end

      it "Moves the anchor right" do
        move_by = [10, 0]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([65, 0])
        expect(actual_pos).to have_position_within_anchor_size([166, 233])
      end

      it "Moves the anchor up" do
        move_by = [0, -5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([55, 0])
        expect(actual_pos).to have_position_within_anchor_size([156, 233])
      end

      it "Moves the anchor down" do
        move_by = [0, 5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([55, 0])
        expect(actual_pos).to have_position_within_anchor_size([156, 233])
      end
    end

    describe "Moving anchor on the right edge of a class" do
      association_id = nil

      before (:each) do
        load_umple_with_file_and_layout("two_classes_with_association_right.ump")
        association_id = activate_association("Mentor", "Student")
      end

      it "Moves the anchor left" do
        move_by = [-10, 0]

        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([109, 21])
        expect(actual_pos).to have_position_within_anchor_size([126, 133])
      end

      it "Moves the anchor right" do
        move_by = [10, 0]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([109, 21])
        expect(actual_pos).to have_position_within_anchor_size([126, 133])
      end

      it "Moves the anchor up" do
        move_by = [0, -5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([109, 16])
        expect(actual_pos).to have_position_within_anchor_size([126, 128])
      end

      it "Moves the anchor down" do
        move_by = [0, 5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([109, 26])
        expect(actual_pos).to have_position_within_anchor_size([126, 138])
      end
    end

    describe "Moving anchor on the bottom edge of a class" do
      association_id = nil

      before (:each) do
        load_umple_with_file_and_layout("two_classes_with_association_bottom.ump")
        association_id = activate_association("Mentor", "Student")
      end

      it "Moves the anchor left" do
        move_by = [-10, 0]

        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([40, 45])
        expect(actual_pos).to have_position_within_anchor_size([116, 133])
      end

      it "Moves the anchor right" do
        move_by = [10, 0]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([60, 45])
        expect(actual_pos).to have_position_within_anchor_size([136, 133])
      end

      it "Moves the anchor up" do
        move_by = [0, -5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([50, 45])
        expect(actual_pos).to have_position_within_anchor_size([126, 133])
      end

      it "Moves the anchor down" do
        move_by = [0, 5]
        click_and_drag_element_by("#{association_id}_anchor0", 
          move_by[0], move_by[1])

        actual_pos = association_diagram_position_of("Student", "Mentor")
        actual_pos = actual_pos[:end_one][:position]

        code_pos = association_code_position_of("Student", "Mentor")
        if code_pos[:end_one][:end_class] == "Student"
          code_pos = code_pos[:end_one][:position]
        else
          code_pos = code_pos[:end_two][:position]
        end

        expect(code_pos).to have_position_within_anchor_size([50, 45])
        expect(actual_pos).to have_position_within_anchor_size([126, 133])
      end
    end
  end

  # Some tests to ensure the helper functions are working properly
  describe "testing the helper functions", :feature => :testdebug do
    it "tests code_block retrieval" do
      load_umple_with_file_and_layout("two_classes_with_generalization.ump")
      expect(get_class_position_code_block("Student"))
        .to eq("{\n  position 50 30 109 45;\n}")
    end

    it "tests class position data retrieval from code" do
      load_umple_with_file_and_layout("two_classes_with_generalization.ump")
      expected = {position: [50, 30], size: [109, 45]}
      expect(class_code_position_of "Student").to eq(expected)
      load_umple_with_file_and_layout("single_class_with_reflexive_association.ump")
      expect(class_code_position_of "Student").to eq(expected)
    end

    it "tests association code retreival" do
      load_umple_with_file_and_layout("two_classes_with_association.ump")
      expected = "position.association Mentor__Student 30,45 30,0"

      expect(retreive_association_code("Student", "Mentor", "Student"))
        .to eq(expected)

      expect(retreive_association_code("Student", "Student", "Mentor"))
        .to eq(expected)

      expect(retreive_association_code("Mentor", "Student", "Mentor"))
        .to eq(false)

      expect(retreive_association_code("asdf", "Student", "Mentor"))
        .to eq(false)
    end

    it "tests association positional data retrieval from code" do
      load_umple_with_file_and_layout("two_classes_with_association.ump")
      expected = {end_one: {end_class: 'Student', position: [30, 45]}, 
                  end_two: {end_class: 'Mentor', position: [30, 0]}}
      expect(association_code_position_of("Mentor", "Student"))
        .to eq(expected)
      load_umple_with_file_and_layout("single_class_with_reflexive_association.ump")
      expected = {end_one: {end_class: 'Student', position: [50, 45]}, 
                  end_two: {end_class: 'Student', position: [0, 10]}}
      expect(association_code_position_of("Student", "Student", "peer"))
        .to eq(expected)
    end

    it "tests the class position retrieval from the diagram" do
      load_umple_with_file_and_layout("single_class.ump")
      expected = {position: [99, 29]}
      expect(class_diagram_position_of("Student")).to eq(expected)
    end

    it "tests the class size retrieval from the diagram" do
      load_umple_with_file_and_layout("single_class.ump")
      expected = {size: [110, 45]}
      expect(screen_size_of("Student")).to eq(expected)
    end

    it "tests the association anchor position retrieval from the diagram" do
      load_umple_with_file_and_layout("two_classes_with_association.ump")
      expected = {end_one: {end_class: 'Student', position: [77, 72]}, 
                  end_two: {end_class: 'Mentor', position: [77, 127]}}

      expect(association_diagram_position_of("Student", "Mentor"))
        .to eq(expected)
    end

    it "tests the absolute position retrieval" do
      fail_message = "canvas not found in expected position," + 
        " was the screen size changed?"
      expect(get_absolute_position("#umpleCanvas")).to eq([595, 95]), fail_message
    end

    it "tests transforming the diagram association position to coordinates" +
      "relative to various points" do
      load_umple_with_file_and_layout("two_classes_with_association.ump")
      pos = association_code_position_of("Mentor", "Student")
    end
  end
end
