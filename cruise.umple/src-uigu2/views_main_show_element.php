<h2><?php echo "$element_kind $name"?></h2>
<form id="new_instance" method="post" action="<?php echo WEB_FOLDER.'main/new_instance'?>">
  <table>
    <tr>
      <th>Attribute Name</th>
      <th>Type</th>
      <th>Value</th>
    </tr>
    <?php 
      echo "<input type='hidden' name='element_name' value='$name' />";
      //TODO move this logic to the controller 
      foreach($constructor_params as $p){
        if(isset($attributes[$p])){
          $att = $attributes[$p];
        }else{
          $att = $associations[$p];
        }
        $value = isset($att['value']) ? $att['value'] : ''; 
        echo "<tr><td>{$att['name']}</td>".
               "<td>{$att['type']}</td>".
               "<td><input type='text' name='constructor_values[]' value='$value'/></td></tr>";
      }
    ?>
    <tr>
      <td><input type="submit" value="Create new instance"/></td>
    </tr>
  </table>
</form>

  <p>//Here: Instructions for this page</p>
  <p>//right column: table with created instances</p>
  <pre> <?php echo print_r($_SESSION); ?></pre>
  

