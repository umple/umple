require 'spec_helper.rb'

describe "Tasks Panel", :feature => :taskEdit, :helper => :taskEdit  do
    
    before(:all) {load_umple_and_switch_to_tasks_panel}
    context "Simple task manipulations:" do
        
        it "begins task creation and ends it" do
            
            page.execute_script("document.querySelector('#buttonCreateTask').click()") if page.has_no_selector?("#taskArea", visible: true)
            wait_for_loading
            expect(page).to have_selector("#taskArea", visible: true)

            find(:xpath, "//*[@id=\"buttonCancelTask\"]").click
            expect(page).to have_no_selector("#taskArea", visible: true)
        end

        it "creates a task with an invalid name" do
            load_umple_and_switch_to_tasks_panel
            page.execute_script("document.querySelector('#buttonCreateTask').click()") if page.has_no_selector?("#taskArea", visible: true)
            wait_for_loading
            expect(page).to have_selector("#taskArea", visible: true)

            find("#taskName").send_keys("///")
            find("textarea#instructions").send_keys("lorem ipsum")
            find(:xpath, "//*[@id=\"taskArea\"]/div[2]/a[1]").click

            alert = page.driver.browser.switch_to.alert
            text = alert.text
            expect(text).to eq("Task Name can only contain letters(case insensitive), underscores, dots, and digits!")
            alert.accept
        end
    end

    context "Creates a new task with valid name"  do
        taskName=""
        before(:all) {taskName= load_umple_and_switch_to_tasks_panel_and_creates_new_task
        }
        it  "and changes instructions" do
            find("textarea#instructions").native.clear
            find("textarea#instructions").send_keys("some text")
            
            #saves changes made to the instructions
            find(:xpath, "//*[@id=\"taskArea\"]/div[2]/a[1]").click
            sleep 1

            #closes the task area
            find(:xpath, "//*[@id=\"taskArea\"]/div[2]/a[4]").click
            page.driver.browser.switch_to.alert.accept
        end

        it "and reloads the task" do
            #loads the task
            load_umple_and_switch_to_tasks_panel

            find("#buttonLoadTask").click
            wait_for_loading
            find("#inputLoadTaskName").send_keys("#{taskName}")
            find(:xpath, "//*[@id=\"buttonSubmitLoadTask\"]/a").click
            wait_for_loading

            #ensures the task area has appeared
            expect(page).to have_selector("#taskArea", visible: true)
            expect(find("#instructionsHTML p")["innerHTML"]).to eq("some text")
                
            #hide instructions
            find("#buttonHideInstructions").click
            wait_for_loading

            expect(find("#taskArea")).to have_no_selector("#instructionsHTML", visible: true)

            #ReShow Instructions 
            find("#buttonReshowInstructions").native.click
            wait_for_loading
            expect(find("#instructionsHTML p")["innerHTML"]).to eq("some text")

            input_model_text("class Student{}")

            #Discard the task submission edits
            find(:xpath, "//*[@id=\"taskArea\"]/div[2]/a[5]").click

            alert = page.driver.browser.switch_to.alert
            text = alert.text
            expect(text).to eq("Are you sure to cancel this task response?")
            alert.accept

            expect(page).to have_no_selector("#taskArea", visible: true)
            expect(evaluate_script("Page.getUmpleCode()")).to eq("//$?[End_of_model]$?")
        end           
    end       
end
   