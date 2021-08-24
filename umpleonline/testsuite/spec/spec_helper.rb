require 'rspec'
require 'capybara'
require 'capybara/dsl'
require 'selenium-webdriver'
require 'test_utils.rb'
require 'load_examples_helper.rb'
require 'graphical_editing_model_helper.rb'
require 'graphical_editing_position_helper.rb'
require 'page_load_helper.rb'
require 'options_panel_helper.rb'
require 'dynamic_layout_helper.rb'
require 'save_and_load_helper.rb'
require 'tasks_panel_helper.rb'

# DO NOT RUN THESE TESTS USING THE 'NO-HEADLESS' OPTION 
# UNLESS FOR DEBUGGING PURPOSES 

Capybara.register_driver :selenium_chrome do |app|
  options= Selenium::WebDriver::Chrome::Options.new
  options.add_argument('--headless') unless TestUtils::ENV=='no-headless'
  options.add_argument('--no-sandbox')
  options.add_argument('--disable-dev-shm-usage')
  options.add_argument('--start-maximized')

  Capybara::Selenium::Driver.new(app, browser: :chrome, options: options)
end
Capybara.default_driver= :selenium_chrome
Capybara.javascript_driver= :selenium_chrome
Capybara.app_host = TestUtils::HOST

RSpec.configure do |config|
  config.include Capybara::DSL
  config.include TestUtils
  config.include ExampleLoaderHelper, :helper => :exampleLoading
  config.include DiagramEditingModelHelper, :helper => :diagramEditing
  config.include DiagramEditingPositionHelper, :helper => :diagramEditing
  config.include PageLoadHelper, :helper => :pageLoad
  config.include OptionsPanelTestHelper, :helper => :optionsMenu
  config.include DynamicResizingHelper, :helper => :dynamicResizing
  config.include SaveAndLoadTestHelper, :helper => :saveAndLoad
  config.include TaskHelper, :helper => :taskEdit 
end
