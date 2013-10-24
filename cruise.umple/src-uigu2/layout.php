<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>User Interface Generation for Umple</title>
    <style type="text/css">
      table#table_menu form{display: inline;}
      .center{
        margin-left: auto;
        margin-right: auto;
      }
      .message_error{color: red;}
      .message_ok{color: green;}
      .subtle{font-style: italic;}
    </style>
  </head>
  <body>
    <div id="div_heading_title" class="center">
      <h1>User Interface Generation for Umple</h1>
    </div>
    <div id="div_heading_bar">
      <table id="table_menu">
        <tr>
          <td>
            <a href="<?php echo WEB_FOLDER ?>">Main Page</a> 
          </td>
          <td> | Show element:
            <form action="<?php echo WEB_FOLDER.'main/show_element'?>" method="POST">
              <select name="element_name">
                <option selected>---</option>
                <?php 
                if (isset($element_names) && is_array($element_names)){
                  foreach($element_names as $e){
                    echo "<option value='$e'>$e</option>";
                  }
                }
                ?>
              </select>
              <input type="submit" value="Go"/>
            </form>
          </td>
          <td> | <a href="<?php echo WEB_FOLDER.'main/clear' ?>">Clear Session Data</a> </td>
        </tr>
      </table>
    </div>
    <hr />
    <div id="div_body">
      <?php
      if (isset($messages) && is_array($messages)){
        foreach ($messages as $msg){
          echo "$msg\n";
        }
      }
      if (isset($body) && is_array($body)){
        foreach ($body as $html){
          echo "$html\n";
        }
      }
      ?>
    </div>
    <div id="div_bottom">
      <hr/>//Here: link, contacts, license information
    </div>
  </body>
</html>
