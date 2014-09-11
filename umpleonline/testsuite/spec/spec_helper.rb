require 'rspec'
require 'capybara'
require 'capybara/dsl'
require 'capybara/poltergeist'
require 'test_utils.rb'
require 'load_examples_helper.rb'
require 'graphical_editing_model_helper.rb'
require 'graphical_editing_position_helper.rb'
require 'page_load_helper.rb'
require 'options_panel_helper.rb'
require 'dynamic_layout_helper.rb'

Capybara.register_driver :poltergeist do |app|
  Capybara::Poltergeist::Driver.new(app, {:debug => false})
end

Capybara.default_driver = :poltergeist

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
