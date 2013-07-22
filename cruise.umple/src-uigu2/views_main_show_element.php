<h2><?php echo "$element_kind $name"?></h2>
<form id="new_instance" method="post" action="<?php echo WEB_FOLDER.'main/new_instance' ?>">
  <table>
    <tr>
      <th>Attribute Name</th>
      <th>Type</th>
      <th>Value</th>
    </tr>
    <?php foreach($attributes as $a){
      echo "<tr><td>{$a['name']}</td>".
               "<td>{$a['type']}</td>".
               "<td><input type='text' name='value' value='{$a['value']}'/></td></tr>";
    }
    ?>
    <tr>
      <td><input type="submit" value="Create new instance"/></td>
    </tr>
  </table>
  <p>//Here: Instructions for this page</p>
  <p>//right column: table with created instances</p>
</form>
