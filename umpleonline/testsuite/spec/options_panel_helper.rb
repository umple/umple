module OptionsPanelTestHelper
  
  EXAMPLE_SUBDIRECTORY = "options_examples/"

  def get_checkbox_state(checkbox_id)
    return find(:css, checkbox_id).checked?
  end

  def reset_page_to_options
    load_page
    switch_to_options_panel
  end

  def reset_page_to_options_with_option(option_text)
    load_umple_with_option(option_text)
    switch_to_options_panel
  end

  def reset_page_to_options_with_model(model_file)
    load_umple_with_file(model_file, "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}")
    switch_to_options_panel
  end

  def reset_page_to_options_with_model_and_option(model_file, option_text)
    load_umple_with_file_and_option(model_file, 
      "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}",
      option_text)
    switch_to_options_panel
  end

  # TODO the manualsync tests require a reliable method of inputting text into
  # the codemirror editor that will trigger all the normal events caused by a 
  # user inputting text. Currently any tests that call this helper function
  # will result in a pending test.
  def input_model_text(new_text)
    pending("proper input text method that triggers all normal events")
    fail
  end
end