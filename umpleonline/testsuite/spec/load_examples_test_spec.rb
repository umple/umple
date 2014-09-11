require 'spec_helper.rb'

# These tests load each umpleonline example and ensure that the code in the 
# text editor matches the source code, and that the diagram has the expected 
# features. Also tests that the example type switching functionality works
# correctly.

describe "Example loading", 
  :helper => :exampleLoading, 
  :feature => :exampleLoading do

  before :all do
    page.driver.resize(1024, 768)
    load_page
  end

  describe "Switching example types" do
    it "cycles through the example type menu" do
      expect(page).to have_selector('#inputExample', visible: true)
      expect(page).to have_selector('#inputExample2', visible: false)
      expect(page).to have_selector('#inputExample3', visible: false)
      switch_to_state_examples
      expect(page).to have_selector('#inputExample2', visible: true)
      expect(page).to have_selector('#inputExample', visible: false)
      expect(page).to have_selector('#inputExample3', visible: false)
      switch_to_compound_structure_examples
      expect(page).to have_selector('#inputExample3', visible: true)
      expect(page).to have_selector('#inputExample', visible: false)
      expect(page).to have_selector('#inputExample2', visible: false)
      switch_to_class_examples
      expect(page).to have_selector('#inputExample', visible: true)
      expect(page).to have_selector('#inputExample2', visible: false)
      expect(page).to have_selector('#inputExample3', visible: false)
    end
  end

  describe "Loading class diagrams" do
    ExampleLoaderHelper::CLASS_EXAMPLES.each_key do |example|
      it "loads #{example}" do
        check_class_example(example)
      end
    end
  end  

  describe "Loading state diagrams" do
    ExampleLoaderHelper::STATE_EXAMPLES.each_key do |example|
      it "loads #{example}" do
        check_state_example(example)
      end
    end  
  end
  
  describe "Loading composite structure diagrams" do
    ExampleLoaderHelper::COMPOSITE_STRUCTURES_EXAMPLES.each_key do |example|
      it "loads #{example}" do
        check_comp_structure_example(example)
        pending("distinct elements to check against in the diagram")
        fail
      end
    end  
  end
  
end