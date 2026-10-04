require 'timeout'

module VersionHistoryTestHelper
  def load_model_with_text(text)
    visit("umple.php?text=#{encode_to_url(text)}")
    wait_for_loading
    wait_for_typing_to_be_processed
  end

  def load_model_by_id(id)
    visit("umple.php?model=#{id}")
    wait_for_loading
    wait_for_typing_to_be_processed
  end

  # Changes to the editor's text, including loading it, are compiled and saved
  # once there has been no typing for Action.waiting_time milliseconds
  def wait_for_typing_to_be_processed
    sleep(evaluate_script("Action.waiting_time") / 1000.0 + 0.5)
    wait_for_saves
  end

  def open_model_in_new_window(id)
    window = open_new_window
    within_window(window) do
      load_model_by_id(id)
    end
    window
  end

  def model_id
    evaluate_script("Page.getModel()")
  end

  def model_text
    evaluate_script("Page.codeMirrorEditor6.state.doc.toString()")
  end

  def known_version
    evaluate_script("VersionHistory.knownVersion")
  end

  def version_on_page_load
    evaluate_script("parseInt(document.getElementById('modelVersion').value, 10)")
  end

  # Requests to version_control.php use fetch, which wait_for_loading does not
  # know about, so the tests wait for what these requests change instead
  def wait_for_saves
    wait_until("this tab's changes to be saved") do
      evaluate_script("TabControl.requestQueue.length == 0 && Ajax.queue.length == 0 && jQuery.active == 0")
    end
  end

  # Adds text at the start of the editor as if it was typed, and waits for the
  # server to record the change as a new version
  def type_at_start(text)
    version = known_version
    execute_script(<<~JS, text)
      Page.codeMirrorEditor6.dispatch({
        changes: {from: 0, insert: arguments[0]},
        userEvent: "input.type"
      });
    JS
    wait_until("the change to be saved") { known_version > version }
    wait_for_typing_to_be_processed
  end

  # Does what happens when the user comes back to this tab from another one,
  # and waits for the check for a newer version that this starts
  def return_to_tab
    execute_script("window.dispatchEvent(new Event('focus'));")
    wait_until("the check for a newer version") do
      evaluate_script("!VersionHistory.checkInProgress && VersionHistory.checkTimer == null")
    end
  end

  def open_restore_dialog
    unless page.has_selector?("#buttonRestoreEarlierVersion", visible: true, wait: 0)
      switch_to_saveandreset_panel
    end
    find("#buttonRestoreEarlierVersion").click
    expect(page).to have_selector("#versionHistoryModal", visible: true)
    wait_until("the saved versions to be listed") do
      !find("#versionHistoryStatus").text.start_with?("Loading")
    end
  end

  def select_version_described_as(description)
    find("#versionHistoryList .version-history-item", text: description).click
    expect(page).to have_selector("#buttonRestoreSelectedVersion:not(.disabled)")
  end

  def restore_version_described_as(description)
    open_restore_dialog
    select_version_described_as(description)
    find("#buttonRestoreSelectedVersion").click
    expect(page).to have_no_selector("#versionHistoryModal", visible: true)
    expect(page).to have_selector("#versionHistoryMessage", visible: true)
    wait_for_saves
  end

  def wait_until(description, timeout: 15)
    Timeout.timeout(timeout) do
      loop do
        begin
          return if yield
        rescue Selenium::WebDriver::Error::JavascriptError,
          Selenium::WebDriver::Error::StaleElementReferenceError
          # The page is still loading
        end
        sleep 0.1
      end
    end
  rescue Timeout::Error
    raise "Timed out waiting for #{description}"
  end
end
