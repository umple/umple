require 'spec_helper.rb'

describe "Version history of models saved on the server",
    :feature => :versionHistory, :helper => :versionHistory do
  before(:all) {
    Capybara.current_session.current_window.resize_to(1024, 768)
  }

  describe "Restore Earlier Version menu item" do
    it "is in the SAVE & LOAD menu" do
      load_umple_with_option("")
      switch_to_saveandreset_panel

      expect(page).to have_selector("#buttonRestoreEarlierVersion", text: "Restore Earlier Version")
    end

    it "is not offered when the model is read-only" do
      load_umple_with_option("readOnly")

      expect(page).to have_no_selector("#buttonRestoreEarlierVersion", visible: :all)
    end
  end

  describe "Restore Earlier Version dialog" do
    it "explains when no versions have been saved yet" do
      load_umple_with_option("")
      open_restore_dialog

      expect(find("#versionHistoryStatus")).to have_text("No earlier versions have been saved yet")
      expect(page).to have_no_selector("#versionHistoryList .version-history-item")

      find("#buttonCloseVersionHistory").click
      expect(page).to have_no_selector("#versionHistoryModal", visible: true)
    end

    it "shows what a saved version contains" do
      load_model_with_text("class Student { name; }")
      type_at_start("class Course { title; }\n")
      open_restore_dialog
      select_version_described_as("The earliest saved version")

      preview = find("#versionHistoryPreview")
      expect(preview).to have_text("class Student { name; }")
      expect(preview).to have_no_text("class Course")
      expect(find("#versionHistoryStatus")).to have_text("You can use Undo to go back")
    end

    it "restores a version in the editor and saves it" do
      load_model_with_text("class Student { name; }")
      type_at_start("class Course { title; }\n")
      id = model_id
      restore_version_described_as("The earliest saved version")

      expect(find("#versionHistoryMessage")).to have_text("Restored version 0.")
      expect(model_text).to include("class Student { name; }")
      expect(model_text).not_to include("class Course")

      load_model_by_id(id)
      expect(model_text).to include("class Student { name; }")
      expect(model_text).not_to include("class Course")
    end

    it "lets Undo go back to the text from before the restore" do
      load_model_with_text("class Student { name; }")
      type_at_start("class Course { title; }\n")
      restore_version_described_as("The earliest saved version")

      switch_to_tools_panel
      find("#buttonUndo").click
      wait_until("the restore to be undone") { model_text.include?("class Course") }
    end

    it "can undo a restore using the link in the message" do
      load_model_with_text("class Student { name; }")
      type_at_start("class Course { title; }\n")
      restore_version_described_as("The earliest saved version")

      find("#versionHistoryMessage .version-history-undo").click
      wait_until("the restore to be undone") { model_text.include?("class Course") }
      expect(find("#versionHistoryMessage")).to have_text("Restored version")

      open_restore_dialog
      expect(page).to have_selector("#versionHistoryList .version-history-item",
        text: "Your work just before version 0 was restored")
    end
  end

  describe "Browser tabs showing the same model" do
    it "do not ask about a tab's own changes, or when the model is loaded again" do
      load_model_with_text("class Student { name; }")
      type_at_start("class Course { title; }\n")
      return_to_tab
      expect(page).to have_no_selector("#versionConflictModal", visible: true)

      version = known_version
      load_model_by_id(model_id)
      expect(version_on_page_load).to eq(version)
      expect(known_version).to eq(version)
    end

    it "ask whether to load the newer version saved in another tab, and load it" do
      load_model_with_text("class Student { name; }")
      other_window = open_model_in_new_window(model_id)
      within_window(other_window) { type_at_start("class Room { number; }\n") }

      return_to_tab
      expect(page).to have_selector("#versionConflictModal", visible: true)
      expect(find("#versionConflictMessage")).to have_text("changed in another browser tab or window")

      find("#buttonLoadLatestVersion", text: "Load latest version").click
      wait_until("the newer version to be loaded") do
        page.has_no_selector?("#versionConflictModal", visible: true, wait: 0) && model_text.include?("class Room")
      end
      wait_for_loading
      wait_for_typing_to_be_processed
      expect(model_text).to include("class Student { name; }")

      return_to_tab
      expect(page).to have_no_selector("#versionConflictModal", visible: true)
      other_window.close
    end

    it "can keep this tab's version, saving the newer one so that it can be restored" do
      load_model_with_text("class Student { name; }")
      other_window = open_model_in_new_window(model_id)
      within_window(other_window) { type_at_start("class Room { number; }\n") }

      return_to_tab
      find("#buttonKeepThisVersion").click
      expect(page).to have_no_selector("#versionConflictModal", visible: true)
      expect(find("#feedbackMessage")).to have_text("Keeping this tab's version")
      expect(model_text).not_to include("class Room")

      type_at_start("class Course { title; }\n")
      return_to_tab
      expect(page).to have_no_selector("#versionConflictModal", visible: true)

      open_restore_dialog
      select_version_described_as("Saved before a browser tab showing an older version replaced it")
      expect(find("#versionHistoryPreview")).to have_text("class Room { number; }")
      other_window.close
    end

    it "tell a tab that saved over changes made in another tab, and can switch to them" do
      load_model_with_text("class Student { name; }")
      other_window = open_model_in_new_window(model_id)
      within_window(other_window) { type_at_start("class Room { number; }\n") }

      type_at_start("class Course { title; }\n")
      expect(page).to have_selector("#versionConflictModal", visible: true)
      expect(find("#versionConflictTitle")).to have_text("This tab saved over newer changes")

      find("#buttonLoadLatestVersion", text: "Use the other tab's version").click
      wait_until("the other tab's version to be restored") { model_text.include?("class Room") }
      expect(model_text).not_to include("class Course")
      expect(find("#versionHistoryMessage")).to have_text("Restored version")
      other_window.close
    end
  end
end
