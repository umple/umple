module TestUtils

  # A method to ensure the page is finished loading. It depends on the loading
  # indicators on the website. It is possible that if the loading overlay is 
  # broken by a change, many tests will fail.
  def wait_for_loading
    loop until page.evaluate_script('jQuery.active').zero?
    page.has_no_selector?('.loading-indicator')
  end

  # Same waiting implementation as above, but allows a temporary change to
  # capybara's timeout on page.has_no_selector?
  def wait_for_loading_for(timeout)
    original_timeout = Capybara.default_wait_time
    loop until page.evaluate_script('jQuery.active').zero?
    Capybara.default_wait_time = timeout
    page.has_no_selector?('.loading-indicator')
    Capybara.default_wait_time = original_timeout
  end

  # Some methods used throughout the test suite to load umple

  def load_page
    visit "umple.php"
  end

  def load_umple_with_option(option_text)
    visit("umple.php?#{option_text}")
    wait_for_loading
  end  

  def load_umple_with_file(filename, directory)
    require 'cgi'
    file_contents = IO.read("#{directory}#{filename}")
    url_encoded_file_contents = URI::encode(file_contents)
    visit("umple.php?text=#{url_encoded_file_contents}")
    wait_for_loading
  end

  def load_umple_with_file_and_option(filename, directory, option_text)
    file_contents = IO.read("#{directory}#{filename}")
    url_encoded_file_contents = URI::encode(file_contents)
    visit("umple.php?#{option_text}&text=#{url_encoded_file_contents}")
    wait_for_loading
  end

  def encode_to_url(plain_text)
    require 'cgi'
    return URI::encode(plain_text)
  end

  def get_file_contents(filename, directory)
    contents = IO.read("#{directory}#{filename}")
    return contents.encode(:universal_newline => true)
  end

  # A javascript/capybara implementation of a drag and drop. Uses javascript to 
  # create a temporary html element at the specified location, then uses the 
  # capybara drag_to method to move the element being dragged to the temporary 
  # html element.
  def click_and_drag_to_position(capybara_element, xLoc, yLoc)
    wait_for_loading
    execute_script("jQuery('body').append('<div id=\"tempPositionMarker\" style=\"position:absolute; left:#{xLoc}px; top:#{yLoc}px; width: 0px; height: 0px;\"></div>');")
    capybara_element.drag_to(find(:css, "#tempPositionMarker"))
    execute_script("jQuery('#tempPositionMarker').remove();")
    wait_for_loading
  end

  # A direct way to send modified keys to particular elements. This is only used
  # because the capybara/poltergeist/phantomjs stack lacks a way of sending 
  # modified keys (such as ctrl-t).

  def send_modified_key(element_selector, key, *meta)
    wait_for_loading
    
    key_string = key
    key_string = "alt+" + key_string if meta.include? :alt
    key_string = "ctrl+" + key_string if meta.include? :control
    key_string = "command+" + key_string if meta.include? :command

    page.driver.execute_script("Mousetrap.trigger('#{key_string}');")
  end

  # Simple javascript/jQuery implementations to retrieve size and positions
  # of elements.

  def get_element_position(element_id)
    return evaluate_script("jQuery('##{element_id}').offset();")
  end

  def get_element_size(element_id)
    size = {}
    size[:width] = evaluate_script("jQuery('##{element_id}').outerWidth();")
    size[:height] = evaluate_script("jQuery('##{element_id}').outerHeight();")
    return size
  end

  # These three methods allow the test suite to switch to any of the palette
  # accordion panels, and then wait for the switching animation to finish.
  def switch_to_saveandreset_panel
    find(:css, "#ui-accordion-palette-header-0").click
    loop until all(:css, "div.ui-accordion-content-active").length == 1
  end

  def switch_to_tools_panel
    find(:css, "#ui-accordion-palette-header-1").click
    loop until all(:css, "div.ui-accordion-content-active").length == 1
  end

  def switch_to_options_panel
    find(:css, "#ui-accordion-palette-header-2").click
    loop until all(:css, "div.ui-accordion-content-active").length == 1
  end

  # Methods used on configuration. They set some globally used constants.

  def self.set_host(host_name = "http://cruise.local/")
    const_set(:HOST,  host_name)
  end

  def self.set_example_directories(umpleonline_dir = "../../umpleonline/")
    const_set(:EXAMPLE_DIRECTORY, umpleonline_dir + "ump/")
    const_set(:TEST_EXAMPLE_DIRECTORY, umpleonline_dir + "test/spec/test_examples/")
  end

  def select_option_by_value(select_id, option_text)
    find(:css, select_id).find("option[value='#{option_text}']").select_option
  end
end

#Configuration script that runs on load.

# Configures some constants, such as the server name, with a file created by
# the ant build file
host_name = ""
umpleonline_dir = ""

begin
  simple_configs = open("spec/temp_config.txt", 'r').readlines()

  simple_configs.each do |line|
    config_pair = line.split(" ")
    if config_pair[0] =~ /host_name/
      host_name = config_pair[1]
    elsif config_pair[0] =~ /umpleonline_directory/
      umpleonline_dir = config_pair[1]
    end
  end
rescue Errno::ENOENT

ensure
  if host_name == "" or host_name.nil?
    TestUtils.set_host 
  else
    TestUtils.set_host host_name
  end
  if umpleonline_dir == "" or umpleonline_dir.nil?
    TestUtils.set_example_directories
  else
    TestUtils.set_example_directories(umpleonline_dir)
  end
end