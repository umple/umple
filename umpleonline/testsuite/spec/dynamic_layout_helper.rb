module DynamicResizingHelper

  def setup_large
    self.class.send :include, LargeScreenHelper
  end

  def setup_small
    self.class.send :include, SmallScreenHelper
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
end

module LargeScreenHelper
  def resize_left(element, amount)
    capybara_element = nil

    case element
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-w")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-w")
    when :editor
      find(:css, "#textEditorColumn").hover
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
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_right(element, amount)
    capybara_element = nil

    case element
    when :canvas
      find(:css, "#umpleCanvasColumn").hover
      within(find(:css, "#umpleCanvasColumn")) do
        capybara_element = find(:css, ".ui-resizable-w")
      end
      draggable_center = center_position_of_element_within("#umpleCanvasColumn",
                                                           ".ui-resizable-w")
    when :editor
      find(:css, "#textEditorColumn").hover
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
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_up(element, amount)
    capybara_element = nil

    case element
    when :app
      find(:css, "#mainApplication").hover
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
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_down(element, amount)
    capybara_element = nil

    case element
    when :app
      find(:css, "#mainApplication").hover
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
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end

  def resize_down(element, amount)
    capybara_element = nil

    case element
    when :editor
      find(:css, "#textEditorColumn").hover
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
    click_and_drag_to_position(capybara_element, xLoc, yLoc)
  end
end