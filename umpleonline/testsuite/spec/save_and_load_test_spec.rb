require 'spec_helper.rb'

describe "Save and Load Panel", :feature => :saveAndLoad, :helper => :saveAndLoad do
    before(:all){
        Capybara.current_session.current_window.resize_to(1024, 768)
    }
    
    describe "Saves and loads back a model"  do
        
        it "with a single class" do
            load_umple_with_file_save_and_load_helper('simple_class.ump')
    
            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("simple_class.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopyLocalBrowser").click
            expect(find(:css, "#feedbackMessage")["innerHTML"]).to eq("Model saved. Use Load From Browser later to restore.")
            wait_for_loading
    
            load_umple_with_option("")
            switch_to_saveandreset_panel
    
            find(:css, "#buttonLoadLocalBrowser").click
            loop until page.has_selector?("#Student", wait: 5)
    
            code = get_text_editor_content
    
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("simple_class.ump"))
        end

        it "with single class having single method " do
            load_umple_with_file_save_and_load_helper('single_class_single_method.ump')

            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_method.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopyLocalBrowser").click
            expect(find(:css, "#feedbackMessage")["innerHTML"]).to eq("Model saved. Use Load From Browser later to restore.")
            wait_for_loading
    
            load_umple_with_option("")
            switch_to_saveandreset_panel
    
            find(:css, "#buttonLoadLocalBrowser").click
            loop until page.has_selector?("#Student", wait: 5)
    
            code = get_text_editor_content
    
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_method.ump"))

        end

        it "with single class having single attribute " do
            load_umple_with_file_save_and_load_helper('single_class_single_attribute.ump')
            
            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_attribute.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopyLocalBrowser").click
            expect(find(:css, "#feedbackMessage")["innerHTML"]).to eq("Model saved. Use Load From Browser later to restore.")
            wait_for_loading
    
            load_umple_with_option("")
            switch_to_saveandreset_panel
    
            find(:css, "#buttonLoadLocalBrowser").click
            loop until page.has_selector?("#Student", wait: 5)
    
            code = get_text_editor_content
    
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_attribute.ump"))

        end
    end

    describe "Clears the text editor and diagram pane" do
        it "for model with single class" do
            load_umple_with_file_save_and_load_helper('simple_class.ump')
    
            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("simple_class.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonStartOver").click
            wait_for_loading
            
            code = get_text_editor_content
    
            expect(code).to eq("//$?[End_of_model]$?")
            expect(find("#umpleCanvas")).to have_no_selector("#Student")
        end

        it "for model with single class having a single method" do
            load_umple_with_file_save_and_load_helper('single_class_single_method.ump')
    
            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_method.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonStartOver").click
            wait_for_loading
            
            code = get_text_editor_content
    
            expect(code).to eq("//$?[End_of_model]$?")
            expect(find("#umpleCanvas")).to have_no_selector("#Student")
        end

        it "for model with single class having a single attribute" do
            load_umple_with_file_save_and_load_helper('single_class_single_attribute.ump')
    
            code = get_text_editor_content
            
            expect(find("#umpleCanvas")).to have_selector("#Student")
            expect(code).to include(get_example_contents("single_class_single_attribute.ump"))
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonStartOver").click
            wait_for_loading
            
            code = get_text_editor_content
    
            expect(code).to eq("//$?[End_of_model]$?")
            expect(find("#umpleCanvas")).to have_no_selector("#Student")
        end
    end
    
    describe "Opens new tab with model's source code" do

        it "single class"  do
            load_umple_with_file_save_and_load_helper('simple_class.ump')
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopy").click
            wait_for_loading
    
            switch_to_new_tab
    
            expect(find("#umpleCode")["innerHTML"]).to include(get_example_contents("simple_class.ump"))
    
            switch_to_primary_window
        end

        it "single class with single method"  do
            load_umple_with_file_save_and_load_helper('single_class_single_method.ump')
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopy").click
            wait_for_loading
    
            switch_to_new_tab
    
            expect(find("#umpleCode")["innerHTML"]).to include(get_example_contents("single_class_single_method.ump"))
    
            switch_to_primary_window
        end

        it "single class with single attribute"  do
            load_umple_with_file_save_and_load_helper('single_class_single_attribute.ump')
    
            switch_to_saveandreset_panel
    
            find(:css, "#buttonCopy").click
            wait_for_loading
    
            switch_to_new_tab
    
            expect(find("#umpleCode")["innerHTML"]).to include(get_example_contents("single_class_single_attribute.ump"))
    
            switch_to_primary_window
        end
    end

    describe "Creates an encoded URL that redirects to the current model" do
        it "with single class" do
            load_umple_with_file_save_and_load_helper('simple_class.ump')
    
            switch_to_saveandreset_panel
    
            find("#buttonCopyEncodedURL").click
            wait_for_loading
    
            switch_to_new_tab
    
            encoded_url = find("#umpleCode")["innerHTML"]
    
            visit(encoded_url)
            Capybara.current_session.current_window.resize_to(1024, 768)
    
            code = get_text_editor_content
            expect(code).to include(get_example_contents("simple_class.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
            
            switch_to_primary_window
        end

        it "with single class having a single method" do
            load_umple_with_file_save_and_load_helper('single_class_single_method.ump')
    
            switch_to_saveandreset_panel
    
            find("#buttonCopyEncodedURL").click
            wait_for_loading
    
            switch_to_new_tab
    
            encoded_url = find("#umpleCode")["innerHTML"]
    
            visit(encoded_url)
            Capybara.current_session.current_window.resize_to(1024, 768)
    
            code = get_text_editor_content
            expect(code).to include(get_example_contents("single_class_single_method.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
            
            switch_to_primary_window
        end

        it "with single class having a single attribute" do
            load_umple_with_file_save_and_load_helper('single_class_single_attribute.ump')
    
            switch_to_saveandreset_panel
    
            find("#buttonCopyEncodedURL").click
            wait_for_loading
    
            switch_to_new_tab
    
            encoded_url = find("#umpleCode")["innerHTML"]
    
            visit(encoded_url)
            Capybara.current_session.current_window.resize_to(1024, 768)
    
            code = get_text_editor_content
            expect(code).to include(get_example_contents("single_class_single_attribute.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
            
            switch_to_primary_window
        end
    end

    describe "Loads a model and restores it on a new page" do
        it "with single class" do
            load_umple_with_file_save_and_load_helper('simple_class.ump')
            load_umple_with_option('')
    
            find("#restorecode a").click
            wait_for_loading
            
            code = get_text_editor_content
            expect(code).to include(get_example_contents("simple_class.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
        end
        
        it "with single class having a single method" do
            load_umple_with_file_save_and_load_helper('single_class_single_method.ump')
            load_umple_with_option('')
    
            find("#restorecode a").click
            wait_for_loading
            
            code = get_text_editor_content
            expect(code).to include(get_example_contents("single_class_single_method.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
        end

        it "with single class having a single attribute" do
            load_umple_with_file_save_and_load_helper('single_class_single_attribute.ump')
            load_umple_with_option('')
    
            find("#restorecode a").click
            wait_for_loading
            
            code = get_text_editor_content
            expect(code).to include(get_example_contents("single_class_single_attribute.ump"))
            expect(find("#umpleCanvas")).to have_selector("#Student")
        end
    end    
end