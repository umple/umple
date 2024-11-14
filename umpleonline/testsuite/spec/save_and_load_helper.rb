module SaveAndLoadTestHelper
    EXAMPLE_SUBDIRECTORY= "options_examples/"
    
    def get_text_editor_content
        begin
            code = evaluate_script("Page.getUmpleCode()")
        end while evaluate_script("Ajax.queue.length")!=0

        return code
    end

    def load_umple_with_file_save_and_load_helper(filename)
        load_umple_with_file(filename, "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}")
    end

    def get_example_contents(filename)
        return get_file_contents(filename, "#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}")
    end

    def switch_to_new_tab
        Capybara.switch_to_window(Capybara.windows[1])
    end

    def switch_to_primary_window
        Capybara.windows[1].close
        Capybara.switch_to_window(Capybara.windows[0])
    end

end