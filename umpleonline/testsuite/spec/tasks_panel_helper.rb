module TaskHelper 
    def load_umple_and_switch_to_tasks_panel
        load_page
        switch_to_tasks_panel
    end

    def load_umple_and_switch_to_tasks_panel_and_creates_new_task
       
            load_umple_and_switch_to_tasks_panel
            find("#buttonCreateTask").click if page.has_no_selector?("#taskArea", visible: true)
            expect(page).to have_selector("#taskArea", visible: true)

            i=rand(100000000000)
            while true
           
                taskName = "task"+i.to_s 
                find("#taskName").native.clear
                find("#taskName").send_keys(taskName)
                find("textarea#instructions").native.clear
                find("textarea#instructions").send_keys("lorem ipsum")

                #Submits the new task
                find(:xpath, "//*[@id=\"taskArea\"]/div[2]/a[1]").click
                sleep 1

                alert=nil
                exist=false

                begin
                    alert= page.driver.browser.switch_to.alert
                    exist=true
                rescue Selenium::WebDriver::Error::NoSuchAlertError 
                   
                rescue Selenium::WebDriver::Error::UnexpectedAlertOpenError
                    alert= page.driver.browser.switch_to.alert
                    exist=true
                end  
                
                if exist==false
                    return taskName
                else
                    alert.accept
                    i=rand(100000000000)
                end
            end 
    end


end