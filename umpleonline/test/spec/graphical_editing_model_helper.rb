module DiagramEditingModelHelper

  EXAMPLE_SUBDIRECTORY = "graphical_editing_examples/"

  #setup and loading functions
  def get_canvas_focus
    find(:css, '#umpleCanvas').click
  end

  def load_umple_with_file_model_helper(filename)
    load_umple_with_file(filename, "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}")
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
    wait_for_loading
    actual = evaluate_script("Page.getUmpleCode()")
    actual = actual[0..actual.index("//$?[End_of_model]$?") - 1]
    expect(strip_whitespace(actual)).to eq(strip_whitespace(contents))
  end

  #helper functions
  def strip_whitespace(input)
    return input.gsub(/\s/, "")
  end
end