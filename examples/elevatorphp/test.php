<?php
require_once("ui/framework.php");
$building = createBuilding();
$serial = serialize($building);
$building = unserialize($serial);

echo "Number:" . $building->numberOfFloors();
?>
