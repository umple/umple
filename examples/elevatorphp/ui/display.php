<?php

function displayElevatorShaft($building)
{
	$elevator = $building->getElevator(0);
	
	?><table class="elevatorshaft"><?php
	foreach($building->getFloorsReversed() as $aFloor)
	{
		if ($elevator->getFloor() == $aFloor)
		{
			?><tr><td><div class="leftdoor" <?php echo doorWidth($elevator) ?>></div><div class="rightdoor" <?php echo doorWidth($elevator) ?>></div></td><?php displayButtons($aFloor); displayPeople($aFloor); ?></tr><?php
		}
		else
		{
			?><tr><td></td><?php displayButtons($aFloor); displayPeople($aFloor); ?></tr><?php
		}
	}
	?></table><?php
}

function displayTraces($tracer)
{
  $allTraceEntries = array_reverse($tracer->getTraces());
  ?><ul>
  <?php foreach($allTraceEntries as $entry) { ?>
      <li><?php echo $entry ?></li>
  <?php } ?>
  <ul>
  <?php
}

function displayPeople($floor)
{
	
	$numberWaiting = $floor->numberOfWaitingPersons();
	?><td class="people">
	<?php
	foreach ($floor->getWaitingPersons() as $person)
	{
		$desiredFloor = $person->getDesiredFloor();
		$personName = $person->getName();
		$floorNumber = $desiredFloor != null ? $desiredFloor->getNumber() : "?";
		echo "<span><img src=\"ui/person.jpg\" />[{$personName}/{$floorNumber}]</span>";
	}
	?>
	</td><?php
}

function displayButtons($floor)
{
	
	?><td class="buttons">
	<?php echo getButtonHtml($floor->getUpRequest()) ?>
	<?php echo getButtonHtml($floor->getDownRequest()) ?>
	</td><?php
}

function getButtonHtml($upOrDownRequest)
{
	
	if ($upOrDownRequest == null)
	{
		return "<div>&nbsp;</div>";
	}

	$pressed = $upOrDownRequest->getIsCalled() ? "_pressed" : "";
	$direction = get_class($upOrDownRequest) == "UpRequest" ? "_up" : "_down";
	$imgSrc = "ui/button{$pressed}{$direction}.jpg";
	$idName = "input{$direction}_" .$upOrDownRequest->getFloor()->getNumber();

	return "<div><img id=\"{$idName}\" name=\"{$idName}\" src=\"{$imgSrc}\" onclick=\"javascript:pressButton(this);\" class=\"button\" /></div>";
}

function doorWidth($elevator)
{
	$percentage = (1 - $elevator->getPercentageDoorOpen()) * 0.5 * 100;
	if ($percentage == 0)
	{
		$percentage = 5;
	}
	else if ($percentage == 50)
	{
		$percentage = 49;
	}
	?>style="width:<?php echo$percentage?>%;"<?php
}

?>