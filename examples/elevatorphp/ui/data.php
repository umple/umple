<?php


function createBuilding()
{
	$building = new Building("Elevator Towers");
	
	$floor1 = $building->addFloorVia();
	$floor2 = $building->addFloorVia();
	$floor3 = $building->addFloorVia();
	$floor4 = $building->addFloorVia();
	
	$up1 = new UpRequest(false,$floor1);
	$up2 = new UpRequest(false,$floor2);
	$up3 = new UpRequest(false,$floor3);

  $down2 = new DownRequest(false,$floor2);
  $down3 = new DownRequest(false,$floor3);
  $down4 = new DownRequest(false,$floor4);
  
	$elevator1 = $building->addElevatorVia("up", true);
	$elevator1->setFloor($floor2);

	$floor3->addWaitingPerson(new Person("Dru"));
	$floor3->addWaitingPerson(new Person("Tim"));
	$floor3->addWaitingPerson(new Person("Omar"));
	return $building;
}

function storeBuilding($building)
{
	?><input id="inputBuilding" name="inputBuilding" type="hidden" value="<?php echo base64_encode(serialize($building)) ?>" /><?php
}

function retrieveBuilding()
{
	return unserialize(base64_decode($_POST["inputBuilding"]));
}

function handleActions($building, $actions)
{
	$allActions = explode(",",$actions);
	foreach ($allActions as $action)
	{
		$building->buttonPressed($action);
	}
}

function pressRandomButton($building)
{
	
	$upOrDown = rand(0,1) == 0 ? "up" : "down";
	$floorIndex = rand(0,$building->numberOfFloors() - 1);
	$floor = $building->getFloor($floorIndex);
	
	$request = rand(0,1) == 0 ? $floor->getUpRequest() : $floor->getDownRequest();
	
	if ($request != null)
	{
		$request->setIsCalled(true);
	}
}

function assignRandomFloor($building)
{
	$maxFloorIndex = $building->numberOfFloors() - 1;
	foreach ($building->getFloors() as $floor)
	{
		foreach ($floor->getWaitingPersons() as $person)
		{
			if ($person->getDesiredFloor() == null)
			{
				if (rand(0,10) >= 3)
				{
					continue;
				}
				$nextFloor = rand(0,$maxFloorIndex);
				$person->pressButton($building->getFloor($nextFloor));
			}
		}
	}
}

?>
