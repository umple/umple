package cruise.associations;

import org.junit.*;

import cruise.associations.specializations.*;


public class TestHarnessAssociationSpecializationsTest
{

  @Test
  public void SpecializationsTest()
  {
  	BigElephant bigElephant = new BigElephant();
  	Assert.assertTrue(bigElephant instanceof Elephant);

  	Snapple snapple = new Snapple();
  	Assert.assertTrue(snapple instanceof Apple);

  	Sun2 sun2 = new Sun2();
  	Assert.assertTrue(sun2 instanceof Sun);

  	Moon2 moon2 = new Moon2();
  	Assert.assertTrue(moon2 instanceof Moon);

  	Rhino rhino = new Rhino();
  	Assert.assertTrue(rhino instanceof Animal);

  	Pine pine = new Pine();
  	Assert.assertTrue(pine instanceof Dilleniidae);

  	Blubber blubber = new Blubber();
  	Assert.assertTrue(blubber instanceof Fat);

  	Whale whale = new Whale();
  	Assert.assertTrue(whale instanceof BigCreature);
  }

}