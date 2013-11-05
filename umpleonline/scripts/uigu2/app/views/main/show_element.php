<h2><?php echo "$element_kind $name"?></h2>
<div id="div_new_instance">
  <h3>Create New Instance</h3>
  <form method="post" action="<?php echo WEB_FOLDER.'main/new_instance'?>">
    <fieldset>
      <table>
        <?php echo $constructor_table_body; ?>
        <input type='hidden' name='element_name' value='<?php echo $name; ?>' />
        <tr>
          <td><input type="submit" value="Create" 
            <?php echo $constructor_table_enabled ? '' : "disabled = 'disabled'"; ?>/></td>
        </tr>
        <?php echo $constructor_table_enabled ? '' : 
          "<tr><span class='subtle'> The Constructor of {$name} requires a reference to another object."
            ."Create that object first </span></tr>"; ?>
      </table>
    </fieldset>
  </form>
</div>
<div id="div_all_instances">
  <h3>Existing Instances of this Class</h3>
  <table>
    <?php echo $objects_table; ?>
  </table>
</div>
<p>//Here: Instructions for this page</p>
  

