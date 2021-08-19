module OptionsPanelTestHelper
  
  EXAMPLE_SUBDIRECTORY = "options_examples/"

  def get_checkbox_state(checkbox_id)
    return evaluate_script("jQuery(\"#{checkbox_id}\").is(':checked')")
  end

  def reset_page_to_options
    load_page
    switch_to_options_panel
    wait_for_loading_for 15
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

  def reset_page_to_options_with_stateMachine
    load_page
    select_option_by_value("#inputExampleType", "smModels")
    select_option_by_value("#inputExample2", "Booking.ump")
    wait_for_loading
    switch_to_options_panel
  end
  
  def input_model_text(new_text)
    execute_script("Page.setUmpleCode(\"#{new_text}\")")
    wait_for_loading
  end
end