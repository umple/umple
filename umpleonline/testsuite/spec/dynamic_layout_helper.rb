module DynamicResizingHelper

  ERROR_MARGIN = 40 #This is the difference in pixels allowed between the actual and expected sizes
  def setup_large
    self.class.send :include, LargeScreenHelper
  end

  def setup_small
    self.class.send :include, SmallScreenHelper
  end
  def tabs 
    return find("#toggleTabsButton")['innerHTML']=="Show Tabs"
  end

  def canvas
    size = get_element_size("umpleCanvasColumn")
    position = get_element_position("umpleCanvasColumn")

    size = [size[:width].to_i, size[:height].to_i]
    position = [position["left"], position["top"]]

    return {size: size, 
            top_left: position}
  end

  def editor
    size = get_element_size("textEditorColumn")
    position = get_element_position("textEditorColumn")
    
    size = [size[:width].to_i, size[:height].to_i]
    position = [position["left"], position["top"]]

    return {size: size, 
            top_left: position}
  end

  def menu
    size = get_element_size("paletteColumn")
    position = get_element_position("paletteColumn")

    size = [size[:width].to_i, size[:height].to_i]
    position = [position["left"], position["top"]]

    return {size: size, 
            top_left: position}
  end

  def center_position_of_element_within(container, element)
    position = evaluate_script("jQuery('#{container}').find('#{element}').offset();")
    width = evaluate_script("jQuery('#{container}').find('#{element}').outerWidth();")
    height = evaluate_script("jQuery('#{container}').find('#{element}').outerHeight();")

    return [position["left"] + (width/2.0).round,
            position["top"] + (height/2.0).round]
  end

  def toggle_element_visibility(element)
    case element
    when :canvas
      execute_script("Page.clickShowHideCanvas()")
    when :editor
      execute_script("Page.clickShowHideText();")
    when :menu
      execute_script("Page.clickShowHideMenu();")
    else
      raise ArgumentError, "Not able to toggle element called #{element}"
    end

    wait_for_loading
  end

  RSpec::Matchers.define :have_expected_dimension do |expected|
    expected.each_key do |key|
      begin
        expected_size_range_x = [expected[key][:size][0]-ERROR_MARGIN, expected[key][:size][0]+ERROR_MARGIN]
        expected_size_range_y = [expected[key][:size][1]-ERROR_MARGIN, expected[key][:size][1]+ERROR_MARGIN]
        expected_position_range_x = [expected[key][:top_left][0]-ERROR_MARGIN, expected[key][:top_left][0]+ERROR_MARGIN]
        expected_position_range_y = [expected[key][:top_left][1]-ERROR_MARGIN, expected[key][:top_left][1]+ERROR_MARGIN]
      rescue TypeError
        expected_size_range_x = [expected[key][0]-1, expected[0]+1]
        expected_size_range_y = [expected[key][1]-1, expected[1]+1]
        expected_position_range_x = [expected[0][key]-1, expected[0]+1]
        expected_position_range_y = [expected[1][key]-1, expected[1]+1]
      end
    
      match do |actual|
        actual.each_key do |key|
          actual[key][:size][0]>=expected_size_range_x[0]&&
          actual[key][:size][0]<=expected_size_range_x[1]&&
          actual[key][:size][1]>=expected_size_range_y[0]&&
          actual[key][:size][1]<=expected_size_range_y[1]&&
          actual[key][:top_left][0]>=expected_position_range_x[0]&&
          actual[key][:top_left][0]<=expected_position_range_x[1]&&
          actual[key][:top_left][1]>=expected_position_range_y[0]&&
          actual[key][:top_left][1]<=expected_position_range_y[1]
        end
      end

      failure_message do |actual|
        "expected size to be #{[expected]}\nbut actual position" +
        " was #{actual}"
      end
    end
  end

  RSpec::Matchers.define :have_expected_element_dimension do |expected|
    expected.each_key do |key|
      begin
        expected_size_range_x = [expected[key][0]-ERROR_MARGIN, expected[key][0]+ERROR_MARGIN]
        expected_size_range_y = [expected[key][1]-ERROR_MARGIN, expected[key][1]+ERROR_MARGIN]
        expected_position_range_x = [expected[key][0]-ERROR_MARGIN, expected[key][0]+ERROR_MARGIN]
        expected_position_range_y = [expected[key][1]-ERROR_MARGIN, expected[key][1]+ERROR_MARGIN]
      rescue TypeError
        expected_size_range_x = [expected[key]-1, expected[0]+1]
        expected_size_range_y = [expected[key]-1, expected[1]+1]
        expected_position_range_x = [expected[0]-1, expected[0]+1]
        expected_position_range_y = [expected[1]-1, expected[1]+1]
      end
    
      match do |actual|
        actual.each_key do |key|
          actual[key][0]>=expected_size_range_x[0]&&
          actual[key][0]<=expected_size_range_x[1]&&
          actual[key][1]>=expected_size_range_y[0]&&
          actual[key][1]<=expected_size_range_y[1]&&
          actual[key][0]>=expected_position_range_x[0]&&
          actual[key][0]<=expected_position_range_x[1]&&
          actual[key][1]>=expected_position_range_y[0]&&
          actual[key][1]<=expected_position_range_y[1]
        end
      end

      failure_message do |actual|
        "expected size to be #{[expected]}\nbut actual position" +
        " was #{actual}"
      end
    end
  end

  RSpec::Matchers.define :have_values_within_error_margin do |expected|
    begin
      x_range = [expected[0]-ERROR_MARGIN, expected[0]+ERROR_MARGIN]
      y_range = [expected[1]-ERROR_MARGIN, expected[1]+ERROR_MARGIN]
    
    end
    
    match do |actual|
      actual[0] >= x_range[0] &&
      actual[0] <= x_range[1] &&
      actual[1] >= y_range[0] &&
      actual[1] <= y_range[1]
    end

    failure_message do |actual|
      "expected value to be #{expected}\n but was #{actual} with an error margin of #{ERROR_MARGIN.to_s} px"
    end
  end
end

module LargeScreenHelper
  def resize_left(element, amount)
    capybara_element = nil

    case element
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      wait_for_loading
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-w")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-w")
    when :editor
      find(:css, "#textEditorColumn").hover
      wait_for_loading
      within(find(:css, "#textEditorColumn")) do
        capybara_element = find(:css, ".ui-resizable-e")
      end
      draggable_center = center_position_of_element_within("#textEditorColumn",
                                                           ".ui-resizable-e")
    else
      raise ArgumentError, "This element, '#{element}', does not resize this left"
    end

    xLoc = draggable_center[0] - amount
    yLoc = draggable_center[1]
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_right(element, amount)
    capybara_element = nil

    case element
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      wait_for_loading
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-w")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-w")
    when :editor
      find(:css, "#textEditorColumn").hover
      wait_for_loading
      within(find(:css, "#textEditorColumn")) do
        capybara_element = find(:css, ".ui-resizable-e")
      end
      draggable_center = center_position_of_element_within("#textEditorColumn",
                                                           ".ui-resizable-e")
    else
      raise ArgumentError, "This element, '#{element}', does not resize right"
    end

    xLoc = draggable_center[0] + amount
    yLoc = draggable_center[1]
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_up(element, amount)
    capybara_element = nil

    case element
    when :app
      find(:css, "#mainApplication").hover
      wait_for_loading
      within(find(:css, "#mainApplication")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#mainApplication",
                                                           ".ui-resizable-s")
    else
      raise ArgumentError, "This element, '#{element}', does not resize to upwards"
    end

    xLoc = draggable_center[0]
    yLoc = draggable_center[1] - amount
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_down(element, amount)
    capybara_element = nil

    case element
    when :app
      find(:css, "#mainApplication").hover
      wait_for_loading
      within(find(:css, "#mainApplication")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#mainApplication",
                                                           ".ui-resizable-s")
    else
      raise ArgumentError, "This element, '#{element}', does not resize downwards"
    end

    xLoc = draggable_center[0]
    yLoc = draggable_center[1] + amount
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end
end

module SmallScreenHelper
  def resize_left(element, amount)
    raise ArgumentError, "No elements resize left in this (small screen) layout format" 
  end

  def resize_right(element, amount)
    raise ArgumentError, "No elements resize right in this (small screen) layout format" 
  end

  def resize_up(element, amount)
    capybara_element = nil

    case element
    when :editor
      find(:css, "#textEditorColumn").hover
      wait_for_loading
      within(find(:css, "#textEditorColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#textEditorColumn",
                                                           ".ui-resizable-s")
    when :menu
      find(:css, "#paletteColumn").hover
      within(find(:css, "#paletteColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#paletteColumn",
                                                           ".ui-resizable-s")
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-s")
    else
      raise ArgumentError, "This element, '#{element}', does not resize upwards"
    end

    xLoc = draggable_center[0]
    yLoc = draggable_center[1] - amount
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_down(element, amount)
    capybara_element = nil

    case element
    when :editor
      find(:css, "#textEditorColumn").hover
      wait_for_loading
      within(find(:css, "#textEditorColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#textEditorColumn",
                                                           ".ui-resizable-s")
    when :menu
      find(:css, "#paletteColumn").hover
      within(find(:css, "#paletteColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#paletteColumn",
                                                           ".ui-resizable-s")
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-s")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-s")
    else
      raise ArgumentError, "This element, '#{element}', does not resize downwards"
    end

    xLoc = draggable_center[0]
    yLoc = draggable_center[1] + amount
    wait_for_loading
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end
end