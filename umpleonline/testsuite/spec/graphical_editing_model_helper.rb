module DiagramEditingModelHelper

  EXAMPLE_SUBDIRECTORY = "graphical_editing_examples/"

  #setup and loading functions
  def get_canvas_focus
    find(:css, '#umpleCanvas').click
    wait_for_loading
  end

  def load_umple_with_file_model_helper(filename)
    load_umple_with_file(filename, "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}")
  end

  def undo_and_redo_the_addition(id, id_2=nil, id_3=nil)
    #undoing this action
    find("#buttonUndo").click
    wait_for_loading

    verify_diagram_does_not_contain("#{id}")
    verify_diagram_does_not_contain("#{id}")
    verify_diagram_does_not_contain("#{id}")

    #Redoing this actions
    find("#buttonRedo").click
    wait_for_loading

    verify_diagram_contains("#{id}")
    verify_diagram_contains("#{id_2}") unless id_2.nil?
    verify_diagram_contains("#{id_3}") unless id_3.nil?
  end

  def undo_and_redo_the_deletion(id, id_2=nil, id_3=nil)
    find("#buttonUndo").click
    wait_for_loading

    verify_diagram_contains("#{id}")
    verify_diagram_contains("#{id_2}") unless id_2.nil?
    verify_diagram_contains("#{id_3}") unless id_3.nil?

    find("#buttonRedo").click
    
    wait_for_loading

    verify_diagram_does_not_contain("#{id}")
    verify_diagram_does_not_contain("#{id_2}") unless id_2.nil?
    verify_diagram_does_not_contain("#{id_3}") unless id_3.nil?
  end

  #verification functions
  def verify_diagram_contains(element)
    expect(find(:css, "div#umpleCanvas")).to have_selector(element)
  end

  def verify_diagram_does_not_contain(element)
    expect(find(:css, "div#umpleCanvas")).to have_no_selector(element)
  end

  def verify_text_ignore_position(filename)
    contents = IO.read("#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}#{filename}")
      .encode(:universal_newline => true)

    loop until page.evaluate_script("Ajax.queue.length").zero?
    
    begin
      actual = evaluate_script("Page.getUmpleCode()")
    end while evaluate_script("Ajax.queue.length")!=0
    actual = actual[0..actual.index("//$?[End_of_model]$?") - 1]
    actual = strip_whitespace(actual) == "//$?[End_of_model]$?namespace-;" ? "//$?[End_of_model]$?":actual
    expect(strip_whitespace(actual)).to eq(strip_whitespace(contents))
  end

  #helper functions
  def strip_whitespace(input)
    return input.gsub(/\s/, "")
  end
end