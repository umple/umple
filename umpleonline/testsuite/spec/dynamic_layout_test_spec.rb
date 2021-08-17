require 'spec_helper.rb'

# Tests the layout of umpleonline and ensures it reacts properly to all events
# that cause a change in the layout, such as user resizing, element hiding, 
# or browser window size changes.

describe "Dynamic resizing of umpleonline layout ", 
  :helper => :dynamicResizing,
  :feature => :dynamicResizing do

  original_sizes = nil

  context "using a large screen layout" do
    before(:all) do
      setup_large
      Capybara.current_window.resize_to(1600, 900) 
    end

    context "with the canvas, text editor and menu visible" do
      before(:each) do
        load_umple_with_option('')
       
        original_sizes = {canvas: canvas(),
                          menu: menu(),
                          editor: editor()}
      end

      it "just loads the page" do
        if tabs then find(:css, '#toggleTabsButton').click(x: 0, y: -1) end
        wait_for_loading
       
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {
          canvas: {size:[883, 733],
                   top_left:[707, 125.265625]},
          menu:   {size:[179, 733],
                   top_left:[523, 125.265625]},
          editor: {size:[508, 733],
                   top_left:[10, 125.265625]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "disables the canvas" do
        switch_to_options_panel
        find(:css, "#buttonShowHideCanvas").click
        error_message = "improper resize after canvas disable"
        
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([1381, 707]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([1396, 143.265625]), error_message
      end

      it "disables the text editor" do
        switch_to_options_panel
        find(:css, "#buttonShowHideTextEditor").click
        error_message = "improper resize after editor disable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([194, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([1381, 707]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
      end

      it "disables the menu" do
        error_message = "improper resize after menu disable"
        toggle_element_visibility(:menu)

        expect(canvas()[:top_left]).to have_values_within_error_margin([707, 143.265625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([868, 707]), error_message
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([692, 707]), error_message
      end

      it "increases the canvas width" do
        resize_amount = 50
        
        resize_left(:canvas, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0] + resize_amount-1,
                        original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] - resize_amount+1,
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1]],
                   top_left:[original_sizes[:menu][:top_left][0] - resize_amount+1,
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0] - resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "increases the canvas width to maximum" do
        resize_amount = 224 
        
        resize_left(:canvas, resize_amount)

        expected = {size:[284, 707], top_left:[10, 143.265625]}
      
        expect(editor()).to have_expected_element_dimension(expected)

      end

      it "decreases the canvas width" do
        resize_amount = 50

        resize_right(:canvas, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0] - resize_amount-1,
                        original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] + resize_amount+1,
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1]],
                   top_left:[original_sizes[:menu][:top_left][0] + resize_amount+1,
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0] + resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the canvas width to minimum" do
        resize_amount = 696 
       
        resize_right(:canvas, resize_amount)

        expected = {size:[420, 707], top_left:[1170, 143.265625]}
      
        expect(canvas()).to have_expected_element_dimension(expected)
      end

      it "increases the text editor width" do
        resize_amount = 50
        
        resize_right(:editor, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0] - resize_amount-1,
                        original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] + resize_amount+1,
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1]],
                   top_left:[original_sizes[:menu][:top_left][0] + resize_amount+1,
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0] + resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "increases the text editor width to maximum" do
        resize_amount = 696 
        
        resize_right(:editor, resize_amount)

        expected = {size:[420, 707], top_left:[1170, 143.265625]}
      
        expect(canvas()).to have_expected_element_dimension(expected)
      end

      it "decreases the text editor width" do
        resize_amount = 50
        
        resize_left(:editor, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0] + resize_amount-1,
                        original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] - resize_amount+1,
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1]],
                   top_left:[original_sizes[:menu][:top_left][0] - resize_amount+1,
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0] - resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the text editor width to minimum" do
        resize_amount = 224 
        
        resize_left(:editor, resize_amount)

        expected = {size:[284, 707], top_left:[10, 143.265625]}
      
        expect(editor()).to have_expected_element_dimension(expected)
      end

      it "increases the height of the app" do
        resize_amount = 50
        
        resize_down(:app, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0],
                        original_sizes[:canvas][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:canvas][:top_left][0],
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the app" do
        resize_amount = 50
        
        resize_up(:app, resize_amount)

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0],
                        original_sizes[:canvas][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:canvas][:top_left][0],
                            original_sizes[:canvas][:top_left][1]]},
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {canvas: canvas(),
                  menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end
    end

    context "with the text editor and menu visible, and the canvas hidden" do
      before(:each) do
        load_umple_with_option('nodiagram')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {menu:{size:[179, 707],
                          top_left:[1411, 143.265625]},
                    editor:{size:[1396, 707],
                            top_left:[10, 143.265625]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "enables the canvas" do
        switch_to_options_panel
        find(:css, "#buttonShowHideCanvas").click
        error_message = "improper resize after canvas enable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([1155, 143.265625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([420, 707]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([971, 143.265625]), error_message
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([956, 707]), error_message
      end

      it "disables the text editor" do
        switch_to_options_panel
        find(:css, "#buttonShowHideTextEditor").click
        error_message = "improper resize after editor disable"

        expect(menu()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
      end

       it "disables the menu" do
        error_message = "improper resize after menu disable"
        
        toggle_element_visibility(:menu)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([1565, 707]), error_message
      end

      it "attempts to resize the text editor horizontally" do
        expect{resize_left(:editor, 150)}.to raise_error(Capybara::ElementNotFound)

        original_sizes.delete(:canvas)

        actual = {menu:menu(), editor:editor()}

        expect(actual).to have_expected_dimension(original_sizes)
      end

      it "increases the height of the app" do
        resize_amount = 50
        
        resize_down(:app, resize_amount)

        expected = {
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the app" do
        resize_amount = 50
        
        resize_up(:app, resize_amount)

        expected = {
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}
      
        actual = {menu: menu(),
                  editor: editor()}

        expect(actual).to have_expected_dimension(expected)
      end
    end

    context "with the canvas and menu visible, and the text editor hidden" do
      before(:each) do
        load_umple_with_option('notext')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]}}
        
        expected = {canvas:{size:[1396, 710],
                            top_left:[194, 140.328125]},
                    menu:{size:[179, 710],
                          top_left:[10, 140.328125]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "disables the canvas" do
        switch_to_options_panel
        find(:css, "#buttonShowHideCanvas").click
        error_message = "improper resize after canvas disable"

        expect(menu()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
      end

      it "enables the text editor" do
        switch_to_options_panel
        find(:css, "#buttonShowHideTextEditor").click
        error_message = "improper resize after editor enable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([483, 143.265625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([1092, 710]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([299, 143.265625]), error_message
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([284, 710]), error_message
      end

       it "disables the menu" do
        error_message = "improper resize after menu disable"
        
        toggle_element_visibility(:menu)

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([1565, 710]), error_message
      end

      it "attempts to resize the canvas horizontally" do
        expect{resize_right(:canvas, 150)}.to raise_error(Capybara::ElementNotFound)

        original_sizes.delete(:editor)

        actual = {menu:menu(), canvas:canvas()}

        expect(actual).to have_expected_dimension(original_sizes)
      end

      it "increases the height of the app" do
        resize_amount = 50
        resize_down(:app, resize_amount)

        expected = {
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] + resize_amount+1],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {menu: menu(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the app" do
        resize_amount = 50
        resize_up(:app, resize_amount)

        expected = {
          menu:   {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] - resize_amount+1],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {menu: menu(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end
    end

    context "with the canvas and text editor visible, and the menu hidden" do
      before(:each) do
        load_umple_with_option('nomenu')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {canvas:{size:[1067, 707],
                            top_left:[523, 143.265625]},
                    editor:{size:[508, 707],
                            top_left:[10, 143.265625]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "disables the canvas" do
        error_message = "improper resize after canvas disable"

        toggle_element_visibility(:canvas)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([1565, 707]), error_message
      end

      it "disables the text editor" do
        error_message = "improper resize after editor disable"

        toggle_element_visibility(:editor)

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([1565, 707]), error_message
      end

      it "enables the menu" do
        error_message = "improper resize after menu enable"
 
        toggle_element_visibility(:menu)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([324, 707]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([339, 143.265625]), error_message
        expect(canvas()[:top_left]).to have_values_within_error_margin([523, 143.265625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([1052, 707]), error_message
      end

      it "resizes the canvas" do
        resize_amount = 50
        
        resize_left(:canvas, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0] - resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0] + resize_amount-1,
                         original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] - resize_amount+1,
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "resizes the text editor" do
        resize_amount = 50
        
        resize_right(:editor, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0] + resize_amount+1,
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0] - resize_amount-1,
                         original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0] + resize_amount+1,
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "increases the height of the app" do
        resize_amount = 50
        
        resize_down(:app, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] + resize_amount],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] + resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the app" do
        resize_amount = 50
        
        resize_up(:app, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] - resize_amount],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] - resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end
    end
  end

  context "using a small screen layout" do
    before(:all) do
      setup_small
      Capybara.current_window.resize_to(930, 935)
    end

    context "with the canvas, text editor and menu visible" do
      before(:each) do
        load_umple_with_option('')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {canvas:{size:[926, 345],
                            top_left:[10, 495]},
                    menu:{size:[179, 345],
                          top_left:[756, 145]},
                    editor:{size:[741, 345],
                            top_left:[10, 145]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "disables the canvas" do
        switch_to_options_panel
        find("#buttonShowHideCanvas").click
        error_message = "improper resize after canvas disable"

        original_sizes.delete(:canvas)

        actual = {menu:menu(), editor:editor()}

        expect(actual).to have_expected_dimension(original_sizes), error_message
      end

      it "disables the text editor" do
        switch_to_options_panel
        find("#buttonShowHideTextEditor").click
        error_message = "improper resize after editor disable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([194, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([711, 366]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
      end

      it "disables the menu" do
        error_message =  "improper resize after menu disable"
        
        toggle_element_visibility(:menu)

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 515.15625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([896, 366]), error_message
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([895, 366]), error_message
      end

      context "using the text editor's resize handle" do
        it "increases the height of the text editor and menu" do
          resize_amount = 50
          resize_down(:editor, resize_amount)

          actual = {canvas: canvas(), menu: menu(), editor: editor()}
          
          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1]],
                     top_left:[original_sizes[:canvas][:top_left][0],
                               original_sizes[:canvas][:top_left][1] + resize_amount]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] + resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the text editor and menu" do
          resize_amount = 50
          resize_up(:editor, resize_amount)

          actual = {canvas: canvas(), menu: menu(), editor: editor()}
          
          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1]],
                     top_left:[original_sizes[:canvas][:top_left][0],
                               original_sizes[:canvas][:top_left][1] - resize_amount]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] - resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end

      context "using the menu's resize handle" do
        it "increases the height of the text editor and menu" do
          resize_amount = 50
          resize_down(:menu, resize_amount + 4)

          actual = {canvas: canvas(), menu: menu(), editor: editor()}
          
          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1]],
                     top_left:[original_sizes[:canvas][:top_left][0],
                               original_sizes[:canvas][:top_left][1] + resize_amount]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] + resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the text editor and menu" do
          resize_amount = 50
          resize_up(:menu, resize_amount - 4)

          actual = {canvas: canvas(), menu: menu(), editor: editor()}
          
          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1]],
                     top_left:[original_sizes[:canvas][:top_left][0],
                               original_sizes[:canvas][:top_left][1] - resize_amount]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] - resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end

      it "increases the height of the canvas" do
        resize_amount = 50
        resize_down(:canvas, resize_amount)
        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] + resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
          menu: {size:[original_sizes[:menu][:size][0],
                       original_sizes[:menu][:size][1]],
                 top_left:[original_sizes[:menu][:top_left][0],
                           original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the canvas" do
        resize_amount = 50
        resize_up(:canvas, resize_amount)

        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] - resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
          menu: {size:[original_sizes[:menu][:size][0],
                       original_sizes[:menu][:size][1]],
                 top_left:[original_sizes[:menu][:top_left][0],
                           original_sizes[:menu][:top_left][1]]},
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
      end
    end

    context "with the text editor and menu visible, and the canvas hidden" do
      before(:each) do
        load_umple_with_option('nodiagram')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {menu:{size:[179, 345],
                          top_left:[756, 145]},
                    editor:{size:[741, 345],
                            top_left:[10, 145]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "enables the canvas" do
        switch_to_options_panel
        find(:css, "#buttonShowHideCanvas").click
        error_message = "improper resize after canvas enable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 515.15625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([896, 366]), error_message
        expect(menu()).to have_expected_element_dimension(original_sizes[:menu]), error_message
        expect(editor()).to have_expected_element_dimension(original_sizes[:editor]), error_message
      end

      it "disables the text editor" do
        switch_to_options_panel
        find(:css, "#buttonShowHideTextEditor").click
        error_message = "improper resize after canvas enable"

        expect(menu()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
      end

      it "disables the menu" do
        error_message =  "improper resize after menu disable"
        
        toggle_element_visibility(:menu)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([895, 366]), error_message
      end

      context "using the text editor's resize handle" do
        it "increases the height of the text editor and menu" do
          resize_amount = 50
          resize_down(:editor, resize_amount)

          actual = {menu: menu(), editor: editor()}
          
          expected = {
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] + resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the text editor and menu" do
          resize_amount = 50
          resize_up(:editor, resize_amount)

          actual = {menu: menu(), editor: editor()}
          
          expected = {
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] - resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end

      context "using the menu's resize handle" do
        it "increases the height of the text editor and menu" do
          resize_amount = 50
          resize_down(:menu, resize_amount + 4)

          actual = {menu: menu(), editor: editor()}
          
          expected = {
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] + resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the text editor and menu" do
          resize_amount = 50
          resize_up(:menu, resize_amount - 4)

          actual = {menu: menu(), editor: editor()}
          
          expected = {
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]},
            editor: {size:[original_sizes[:editor][:size][0],
                           original_sizes[:editor][:size][1] - resize_amount],
                     top_left:[original_sizes[:editor][:top_left][0],
                               original_sizes[:editor][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end
    end

    context "with the canvas and menu visible, and the text editor hidden" do
      before(:each) do
        load_umple_with_option('notext')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  menu:{size:original_sizes[:menu][:size],
                        top_left:original_sizes[:menu][:top_left]}}
        
        expected = {canvas:{size:[741, 345],
                            top_left:[194, 137]},
                    menu:{size:[179, 345],
                          top_left:[10, 137]}}

        expect(expected).to have_expected_dimension(actual)
      end

      it "disables the canvas" do
        switch_to_options_panel
        find(:css, "#buttonShowHideCanvas").click
        error_message = "improper resize after canvas disable"

        expect(menu()).to have_expected_element_dimension(original_sizes[:menu]), error_message
      end

      it "enables the text editor" do
        switch_to_options_panel
        find(:css, "#buttonShowHideTextEditor").click
        error_message = "improper resize after editor enable"

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 515.15625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([896, 366]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([726, 143.265625]), error_message
        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([711, 366]), error_message
      end

      it "disables the menu" do
        error_message =  "improper resize after menu disable"
        
        toggle_element_visibility(:menu)

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([895, 366]), error_message
      end

      context "using the canvas's resize handle" do
        it "increases the height of the canvas and menu" do
          resize_amount = 50
          resize_down(:canvas, resize_amount)
          
          actual = {canvas: canvas(), menu: menu()}

          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1] + resize_amount],
                     top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the canvas and menu" do
          resize_amount = 50
          resize_up(:canvas, resize_amount)

          actual = {canvas: canvas(), menu: menu()}

          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1] - resize_amount],
                     top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end

      context "using the menu's resize handle" do
        it "increases the height of the canvas and menu" do
          resize_amount = 50
          resize_down(:menu, resize_amount + 4)

          actual = {canvas: canvas(), menu: menu()}

          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1] + resize_amount],
                     top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] + resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end

        it "decreases the height of the canvas and menu" do
          resize_amount = 50
          resize_up(:menu, resize_amount - 4)

          actual = {canvas: canvas(), menu: menu()}

          expected = {
            canvas: {size:[original_sizes[:canvas][:size][0],
                           original_sizes[:canvas][:size][1] - resize_amount],
                     top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]},
            menu: {size:[original_sizes[:menu][:size][0],
                         original_sizes[:menu][:size][1] - resize_amount],
                   top_left:[original_sizes[:menu][:top_left][0],
                             original_sizes[:menu][:top_left][1]]}}

          expect(actual).to have_expected_dimension(expected)
        end
      end
    end

    context "with the canvas and text editor visible, and the menu hidden" do
      before(:each) do
        load_umple_with_option('nomenu')
        original_sizes = {canvas: canvas,
                          menu: menu,
                          editor: editor}
      end

      it "just loads the page" do
        actual = {canvas:{size:original_sizes[:canvas][:size],
                          top_left:original_sizes[:canvas][:top_left]},
                  editor:{size:original_sizes[:editor][:size],
                          top_left:original_sizes[:editor][:top_left]}}
        
        expected = {canvas:{size:[926, 345],
                            top_left:[10, 495]},
                    editor:{size:[925, 345],
                            top_left:[10, 145]}}

        expect(expected).to have_expected_dimension(actual)
      end

      it "disables the canvas" do
        error_message = "improper resize after canvas disable"

        toggle_element_visibility(:canvas)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([895, 366]), error_message
      end

      it "disables the text editor" do
        error_message = "improper resize after editor disable"

        toggle_element_visibility(:editor)

        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 140.328125]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([895, 366]), error_message
      end

      it "enables the menu" do
        error_message = "improper resize after menu enable"
        
        toggle_element_visibility(:menu)

        expect(editor()[:top_left]).to have_values_within_error_margin([10, 143.265625]), error_message
        expect(editor()[:size]).to have_values_within_error_margin([711, 366]), error_message
        expect(menu()[:top_left]).to have_values_within_error_margin([726, 143.265625]), error_message
        expect(canvas()[:top_left]).to have_values_within_error_margin([10, 515.15625]), error_message
        expect(canvas()[:size]).to have_values_within_error_margin([896, 366]), error_message
      end

      it "increases the height of the text editor" do
        resize_amount = 50;
        resize_down(:editor, resize_amount)

        expected = {
          editor:   {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] + resize_amount],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1] + resize_amount]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the text editor" do
        resize_amount = 50;
        resize_up(:editor, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1] - resize_amount],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1]],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1] - resize_amount]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "increases the height of the canvas" do
        resize_amount = 50;
        resize_down(:canvas, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] + resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the height of the canvas" do
        resize_amount = 50;
        resize_up(:canvas, resize_amount)

        expected = {
          editor: {size:[original_sizes[:editor][:size][0],
                         original_sizes[:editor][:size][1]],
                   top_left:[original_sizes[:editor][:top_left][0],
                             original_sizes[:editor][:top_left][1]]},
          canvas: {size:[original_sizes[:canvas][:size][0],
                         original_sizes[:canvas][:size][1] - resize_amount],
                   top_left:[original_sizes[:canvas][:top_left][0],
                             original_sizes[:canvas][:top_left][1]]}}
      
        actual = {editor: editor(),
                  canvas: canvas()}

        expect(actual).to have_expected_dimension(expected)
      end
    end
  end

  describe "switching between large and small screen layouts" do
    context "switching from large screen to small screen" do
      before(:each) do
        Capybara.current_window.resize_to(1600, 900) 
        load_umple_with_option("")
      end

      it "changes the window size" do
        Capybara.current_window.resize_to(930, 935)
        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[926, 345],
                   top_left:[10, 495]},
          menu:   {size:[179, 345],
                   top_left:[756, 145]},
          editor: {size:[741, 345],
                   top_left:[10, 145]}} 

        expect(actual).to have_expected_dimension(expected)
      end

      it "increases the browser zoom level to 125%" do
        page.send_keys(:control, :add)
        page.send_keys(:control, :add)
        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[868, 733],
                   top_left:[707, 110.265625]},
          menu:   {size:[179, 733],
                   top_left:[756, 145]},
          editor: {size:[508, 733],
                   top_left:[523, 110.265625]}} 

        expect(actual).to have_expected_dimension(expected)

      end
    end

    context "switching from small screen to large screen" do
      before(:each) do
        Capybara.current_window.resize_to(930, 935)
        load_umple_with_option("")
      end

      it "changes the window size" do
        Capybara.current_window.resize_to(1600, 900) 
        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[896, 733],
                   top_left:[679, 110.265625]},
          menu:   {size:[179, 733],
                   top_left:[495, 110.265625]},
          editor: {size:[480, 733],
                   top_left:[10, 110.265625]}}

        expect(actual).to have_expected_dimension(expected)
      end

      it "decreases the browser zoom level to 80%" do
        page.send_keys(:control, :subtract)
        page.send_keys(:control, :subtract)
        actual = {canvas: canvas(), menu: menu(), editor: editor()}

        expected = {
          canvas: {size:[896, 379],
                   top_left:[10, 495.15625]},
          menu:   {size:[179, 379],
                   top_left:[726, 110.265625]},
          editor: {size:[711, 379],
                   top_left:[10, 110.265625]}}

        expect(actual).to have_expected_dimension(expected)
      end
    end
  end
end