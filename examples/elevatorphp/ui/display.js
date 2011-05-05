
function pressButton(button)
{
	inputAction = document.getElementById("inputAction");
	
	if (inputAction.value != "")
	{
	  inputAction.value += ",";
	}
	inputAction.value += button.id;
}