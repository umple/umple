module DiagramEditingPositionHelper

  EXAMPLE_SUBDIRECTORY = "graphical_editing_examples/"
  ANCHOR_SIZE = 5.0 # Size of the association anchors on the ends of associations.

  #setup and loading functions
  def load_umple_with_file_and_layout(filename)
    require 'cgi'
    file_contents = IO.read("#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}#{filename}")
    url_encoded_file_contents = URI::encode(file_contents)
    visit("umple.php?showlayout&text=#{url_encoded_file_contents}")
    wait_for_loading
  end

  def load_umple_with_file_and_layout_ignore_position(filename)
    require 'cgi'
    file_contents = IO.read("#{TestUtils::TEST_EXAMPLE_DIRECTORY}#{EXAMPLE_SUBDIRECTORY}#{filename}")
    file_contents = file_contents.split('//$?[End_of_model]$?')[0]
    url_encoded_file_contents = URI::encode(file_contents)
    visit("umple.php?showlayout&text=#{url_encoded_file_contents}")
    wait_for_loading
  end

  #Element manipulation functions
  def click_and_drag_element_in_canvas_to(element_selector, xLoc, yLoc)
    wait_for_loading
    pos = get_absolute_position("#umpleCanvas")
    xLoc += pos[0] 
    yLoc += pos[1] 
    element = find(:css, "##{element_selector}")

    adjusted = adjust_draggable_to_center(element_selector, xLoc, yLoc)

    click_and_drag_to_position(element, adjusted[0], adjusted[1])
  end

  def click_and_drag_element_by(element_selector, xAmount, yAmount)
    wait_for_loading
    pos = get_absolute_position("##{element_selector}")
    xLoc = pos[0] + xAmount
    yLoc = pos[1] + yAmount
    element = find(:css, "##{element_selector}")

    adjusted = adjust_draggable_to_center(element_selector, xLoc, yLoc)

    click_and_drag_to_position(element, adjusted[0], adjusted[1])
  end

  def adjust_draggable_to_center(element_selector, xLoc, yLoc)
    element_size = screen_size_of(element_selector)
    xLoc += (element_size[:size][0]/2.0).ceil
    yLoc += (element_size[:size][1]/2.0).ceil

    return [xLoc, yLoc]
  end

  # Makes the anchors for an association visible and movable.
  def activate_association(class_one, class_two, role_one = nil, role_two = nil)
    class_one_end = class_one
    class_one_end += ":" + role_one unless role_one.nil?

    class_two_end = class_two
    class_two_end += ":" + role_two unless role_two.nil?

    association_class_name = class_one_end + "__" + class_two_end

    evaluate_script("jQuery('.#{association_class_name}').click();")
    association_id = evaluate_script("jQuery('.#{association_class_name}').prop('id')")

    if association_id.nil?
      association_class_name = class_two_end + "__" + class_one_end

      evaluate_script("jQuery('.#{association_class_name}').click();")
      association_id = evaluate_script("jQuery('.#{association_class_name}').prop('id')")
    end

    return association_id
  end

  #Element data extraction functions - positional code extraction
  def get_class_position_code_block(class_name)
    code = evaluate_script("Page.getUmpleCode()")
    code = code.split("//$?[End_of_model]$?")[1]
    code = code[/class #{Regexp.quote(class_name)}\s+\{.*?\}/m]
    return code.gsub(/class #{class_name}\s+/, "") unless code.nil?
  end

  def class_code_position_of(class_name)
    code = get_class_position_code_block(class_name)
    data = {}
    code = code[/position \d+ \d+ \d+ \d+/].split
    data[:position] = [code[1].to_i, code[2].to_i]
    data[:size] = [code[3].to_i, code[4].to_i]
    return data
  end

  def association_code_position_of(class_one, class_two, 
                                   role_one = nil, role_two = nil)
    class_one_end = class_one
    class_one_end += ":" + role_one unless role_one.nil?

    class_two_end = class_two
    class_two_end += ":" + role_two unless role_two.nil?

    code = retreive_association_code(class_one, class_one_end, class_two_end)

    if code
      classes = [class_one, class_two]
    else
      code = retreive_association_code(class_two, class_one_end, class_two_end)
      classes = [class_two, class_one]
    end

    return nil unless code

    code = code.split()
    positions = [code[2], code[3]]
    data = {}
    data[:end_one] = {end_class: classes[0], 
      position: [positions[0].split(",")[0].to_i, positions[0].split(",")[1].to_i]}
    data[:end_two] = {end_class: classes[1], 
      position: [positions[1].split(",")[0].to_i, positions[1].split(",")[1].to_i]}

    return data
  end

  def retreive_association_code(search_class, id_one, id_two)
    code = get_class_position_code_block(search_class)
    return false if code.nil?

    result = false
    forward_string = id_one + "__" + id_two
    backward_string = id_two + "__" + id_one
    associations = []

    code.split(/\n/).each do |line|
      associations.push(line) if line["position.association"]
    end

    associations.each do |association|
      result = association[2..-2] if association.split()[1] == forward_string
      result = association[2..-2] if association.split()[1] == backward_string
    end

    return result
  end

  #Element data extraction functions - actual diagram position

  def class_diagram_position_of(class_name)
    wait_for_loading #ensure the diagram has loaded
    raw = evaluate_script("jQuery('##{class_name}').css(['left', 'top'])")

    return {position: [raw['left'].to_i, raw['top'].to_i]}
  end

  def screen_size_of(element_name)
    wait_for_loading #ensure the diagram has loaded
    raw = evaluate_script("jQuery('##{element_name}').css(['width', 'height'])")

    return {size: [raw['width'].to_i, raw['height'].to_i]}
  end

  def association_diagram_position_of(class_one, class_two, 
                                      role_one = nil, role_two = nil)
    class_one_end = class_one
    class_one_end += "\\\\:" + role_one unless role_one.nil?

    class_two_end = class_two
    class_two_end += "\\\\:" + role_two unless role_two.nil?

    wait_for_loading #ensure the diagram has loaded

    association_name = class_one_end + "__" + class_two_end
    anchor_one = evaluate_script( 
      "jQuery('.#{association_name}').find('div[id$=\"_anchor0\"]')" +
      ".css(['top', 'left']);"
    )

    unless anchor_one.nil?
      anchor_two = evaluate_script( 
        "jQuery('.#{association_name}').find('div[id$=\"_anchor1\"]')" +
        ".css(['top', 'left']);"
      )
    else
      association_name = class_two_end + "__" + class_one_end

      anchor_one = evaluate_script( 
        "jQuery('.#{association_name}').find('div[id$=\"_anchor0\"]')" +
        ".css(['top', 'left']);"
      )
      anchor_two = evaluate_script( 
        "jQuery('.#{association_name}').find('div[id$=\"_anchor1\"]')" +
        ".css(['top', 'left']);"
      )
    end

    return nil if anchor_one.nil? || anchor_two.nil?

    data = {}
    data[:end_one] = {end_class: class_one, 
      position: [anchor_one['left'].to_i, anchor_one['top'].to_i]}
    data[:end_two] = {end_class: class_two, 
      position: [anchor_two['left'].to_i, anchor_two['top'].to_i]}

    return data
  end
  
  def get_absolute_position(element_id)
    raw = evaluate_script("jQuery('#{element_id}').offset()")
    return [raw["left"], raw["top"]]
  end

  def transform_association_position_relative_to_canvas(data)

    end_one = data[:end_one]
    end_two = data[:end_two]

    c1_pos = class_diagram_position_of(end_one[:end_class])
    c2_pos = class_diagram_position_of(end_two[:end_class])

    end_one[:position] = [c1_pos[:position][0] + end_one[:position][0],
                          c1_pos[:position][1] + end_one[:position][1]]
    end_two[:position] = [c2_pos[:position][0] + end_two[:position][0],
                          c2_pos[:position][1] + end_two[:position][1]]

    data[:end_one] = end_one
    data[:end_two] = end_two

    return data
  end

  def transform_association_position_relative_to_document(data)
    data = transform_association_position_relative_to_canvas(data)

    end_one = data[:end_one]
    end_two = data[:end_two]

    canvas_pos = get_absolute_position("#umpleCanvas")

    end_one[:position] = [canvas_pos[0] + end_one[:position][0],
                          canvas_pos[1] + end_one[:position][1]]
    end_two[:position] = [canvas_pos[0] + end_two[:position][0],
                          canvas_pos[1] + end_two[:position][1]]

    data[:end_one] = end_one
    data[:end_two] = end_two

    return data    
  end

  # Custom matcher definitions

  # Allows association end positions to be matched within have the width of
  # the end anchor sizes.
  RSpec::Matchers.define :be_within_anchor_size do |expected|
    end_one_range_x = [expected[:end_one][:position][0] - (ANCHOR_SIZE/2.0).ceil,
                       expected[:end_one][:position][0] + (ANCHOR_SIZE/2.0).ceil]
    end_one_range_y = [expected[:end_one][:position][1] - (ANCHOR_SIZE/2.0).ceil,
                       expected[:end_one][:position][1] + (ANCHOR_SIZE/2.0).ceil]
    end_two_range_x = [expected[:end_two][:position][0] - (ANCHOR_SIZE/2.0).ceil,
                       expected[:end_two][:position][0] + (ANCHOR_SIZE/2.0).ceil]
    end_two_range_y = [expected[:end_two][:position][1] - (ANCHOR_SIZE/2.0).ceil,
                       expected[:end_two][:position][1] + (ANCHOR_SIZE/2.0).ceil]

    match do |actual|
      actual[:end_one][:position][0] >= end_one_range_x[0] &&
      actual[:end_one][:position][0] <= end_one_range_x[1] &&
      actual[:end_one][:position][1] >= end_one_range_y[0] &&
      actual[:end_one][:position][1] <= end_one_range_y[1] &&
      actual[:end_two][:position][0] >= end_two_range_x[0] &&
      actual[:end_two][:position][0] <= end_two_range_x[1] &&
      actual[:end_two][:position][1] >= end_two_range_y[0] &&
      actual[:end_two][:position][1] <= end_two_range_y[1] 
    end

    failure_message do |actual|
      "expected #{expected.inspect} " +
      "\n     got #{actual.inspect} " +
      "\n     with a delta of #{(ANCHOR_SIZE/2.0).ceil}"
    end
    failure_message_when_negated do |actual|
      "expected the two positions would not match, but they are" +
      " matching within limits of #{(ANCHOR_SIZE/2.0).ceil}"
    end
  end

  # Allows association code positions to be matched within have the width of
  # the end anchor sizes.
  RSpec::Matchers.define :have_position_within_anchor_size do |expected|
    begin
      x_range = [expected[:position][0] - (ANCHOR_SIZE/2.0).ceil,
                 expected[:position][0] + (ANCHOR_SIZE/2.0).ceil]
      y_range = [expected[:position][1] - (ANCHOR_SIZE/2.0).ceil,
                 expected[:position][1] + (ANCHOR_SIZE/2.0).ceil]
    rescue TypeError
      x_range = [expected[0] - (ANCHOR_SIZE/2.0).ceil,
                 expected[0] + (ANCHOR_SIZE/2.0).ceil]
      y_range = [expected[1] - (ANCHOR_SIZE/2.0).ceil,
                 expected[1] + (ANCHOR_SIZE/2.0).ceil]
    end
    match do |actual|
      begin
        actual[:position][0] >= x_range[0] &&
        actual[:position][0] <= x_range[1] &&
        actual[:position][1] >= y_range[0] &&
        actual[:position][1] <= y_range[1] 
      rescue TypeError
        actual[0] >= x_range[0] &&
        actual[0] <= x_range[1] &&
        actual[1] >= y_range[0] &&
        actual[1] <= y_range[1] 
      end
    end

    failure_message do |actual|
      begin
        actual_out = "[#{actual[:position][0]}, #{actual[:position][1]}]"
      rescue TypeError
        actual_out = "[#{actual[0]}, #{actual[1]}]"
      end

      begin
        expected_out = "[#{expected[:position][0]}, #{expected[:position][1]}]"
      rescue TypeError
        expected_out = "[#{expected[0]}, #{expected[1]}]"
      end

      "expected anchor position to be #{expected_out}\n" +
      "but was #{actual_out}\n" +
      "with delta #{(ANCHOR_SIZE/2.0).ceil}"
    end
  end

  # Allows matching one below the actual position to deal with float truncation
  RSpec::Matchers.define :have_position do |expected|
    begin
      x_range = [expected[:position][0] - 1, expected[:position][0]]
      y_range = [expected[:position][1] - 1, expected[:position][1]]
    rescue TypeError
      x_range = [expected[0] - 1, expected[0]]
      y_range = [expected[1] - 1, expected[1]]
    end
    match do |actual|
      actual[:position][0] >= x_range[0] &&
      actual[:position][0] <= x_range[1] &&
      actual[:position][1] >= y_range[0] &&
      actual[:position][1] <= y_range[1]
    end

    failure_message do |actual|
      "expected position within diagram to be #{expected}\nbut actual position" +
      " was #{[actual[:position][0], actual[:position][1]]}"
    end
  end

  RSpec::Matchers.define :have_code_position do |expected|
    match do |actual|
      begin
        actual[:position][0] == expected[:position][0] &&
        actual[:position][1] == expected[:position][1]
      rescue TypeError
        actual[:position][0] == expected[0] &&
        actual[:position][1] == expected[1]
      end
    end

    failure_message do |actual|
      "expected code position to be #{expected}\nbut actual code position" +
      " was #{actual}"
    end
  end
end