package cruise.associations.specializations;

import org.junit.Test;
import static org.junit.Assert.*;

public class DefaultRolesTest {
  @Test(timeout = 2000)
  public void assignReplaceMoveAndClearWheel() {
    DefaultUnicycle first = new DefaultUnicycle();
    DefaultUnicycle second = new DefaultUnicycle();
    DefaultWheel wheel = new DefaultWheel();
    DefaultWheel replacement = new DefaultWheel();
    assertNull(first.getDefaultWheel_OneDefaultWheel());
    assertTrue(wheel.setDefaultVehicle_DefaultUnicycle(first));
    assertSame(wheel, first.getDefaultWheel_OneDefaultWheel());
    assertTrue(wheel.setDefaultVehicle_DefaultUnicycle(first));
    assertEquals(1, first.numberOfDefaultWheels());
    assertTrue(replacement.setDefaultVehicle_DefaultUnicycle(first));
    assertNull(wheel.getDefaultVehicle());
    assertSame(replacement, first.getDefaultWheel_OneDefaultWheel());
    assertTrue(replacement.setDefaultVehicle_DefaultUnicycle(second));
    assertFalse(first.hasDefaultWheels());
    assertSame(replacement, second.getDefaultWheel_OneDefaultWheel());
    assertTrue(replacement.setDefaultVehicle_DefaultUnicycle(null));
    assertNull(replacement.getDefaultVehicle());
    assertFalse(second.hasDefaultWheels());
  }

  @Test(timeout = 2000)
  public void explicitlyNamedRolesUseTheSameInheritedStorage() {
    Unicycle unicycle = new Unicycle();
    Wheel first = new Wheel();
    Wheel second = new Wheel();
    assertTrue(first.setVehicle_Unicycle(unicycle));
    assertTrue(second.setVehicle_Unicycle(unicycle));
    assertNull(first.getVehicle());
    assertSame(second, unicycle.getWheel_OneWheel());
    assertTrue(second.setVehicle_Unicycle(null));
    assertNull(unicycle.getWheel_OneWheel());
  }

  @Test(timeout = 2000)
  public void moveFromSiblingAndDeleteVehicles() {
    DefaultBicycle bicycle = new DefaultBicycle();
    DefaultUnicycle unicycle = new DefaultUnicycle();
    DefaultWheel wheel = new DefaultWheel();
    assertTrue(bicycle.addDefaultWheel(wheel));
    assertTrue(wheel.setDefaultVehicle_DefaultUnicycle(unicycle));
    assertFalse(bicycle.hasDefaultWheels());
    unicycle.delete();
    assertFalse(unicycle.hasDefaultWheels());
    assertNull(wheel.getDefaultVehicle());
    unicycle.delete();
    assertTrue(bicycle.addDefaultWheel(wheel));
    bicycle.delete();
    assertFalse(bicycle.hasDefaultWheels());
    assertNull(wheel.getDefaultVehicle());
  }
}
