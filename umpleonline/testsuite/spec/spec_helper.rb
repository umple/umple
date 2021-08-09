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


Capybara.register_driver :selenium_chrome do |app|
  Capybara::Selenium::Driver.new(app, :browser => :chrome)
end

Capybara.register_driver :headless_chrome do |app|
  capabilities = Selenium::WebDriver::Remote::Capabilities.chrome(
    chromeOptions: { args: %w(no-sandbox headless disable-gpu disable-dev-shm-usage) }
  )

  Capybara::Selenium::Driver.new app,
    browser: :chrome,
    desired_capabilities: capabilities
end

# DO NOT RUN THESE TESTS USING THE 'NO-HEADLESS' OPTION 
# UNLESS FOR DEBUGGING PURPOSES 

Capybara.default_driver = TestUtils::ENV=="no-headless"? :selenium_chrome : :headless_chrome

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
end
