<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>User Interface Generation for Umple</title>
    <link rel="stylesheet" type="text/css" href="/uigu2/css/layout.css" />
  </head>
  <body>
    <div id="heading_title" class="center">
      <h1>User Interface Generation for Umple</h1>
    </div>
    <div id="heading_bar">
      <table id="menu">
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
    <div id="body">
      <?php
      if (isset($body) && is_array($body))
        foreach ($body as $html)
          echo "$html\n";
      ?>
    </div>
    <div id="bottom"><hr/>//Here: link, contacts, license information</div>
  </body>
</html>
