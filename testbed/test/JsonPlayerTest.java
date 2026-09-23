import org.junit.Assert;
import org.junit.Test;

// toJson and fromJson carry the current state of every state machine.
// In the default package because the genJson fixture JsonPlayer has no namespace.
public class JsonPlayerTest
{
  @Test
  public void roundTripRestoresNestedStates()
  {
    JsonPlayer player = new JsonPlayer("p1");
    player.turnOn();
    player.play();
    player.stop();

    JsonPlayer restored = JsonPlayer.fromJson(player.toJson());

    Assert.assertEquals("p1", restored.getName());
    Assert.assertEquals(JsonPlayer.Status.On, restored.getStatus());
    Assert.assertEquals(JsonPlayer.StatusOn.Playing, restored.getStatusOn());
    Assert.assertEquals(JsonPlayer.Mode.Stopped, restored.getMode());
    Assert.assertEquals(JsonPlayer.ModeActive.Null, restored.getModeActive());
  }

  @Test
  public void restoredObjectReactsToEvents()
  {
    JsonPlayer player = new JsonPlayer("p1");
    player.turnOn();

    JsonPlayer restored = JsonPlayer.fromJson(player.toJson());

    Assert.assertTrue(restored.play());
    Assert.assertEquals("On.Playing", restored.getStatusFullName());
    Assert.assertTrue(restored.turnOff());
    Assert.assertEquals(JsonPlayer.Status.Off, restored.getStatus());
    Assert.assertEquals(JsonPlayer.StatusOn.Null, restored.getStatusOn());
  }

  @Test
  public void historyStateStartsWhereTheConstructorWould()
  {
    JsonPlayer restored = JsonPlayer.fromJson(new JsonPlayer("p1").toJson());

    Assert.assertTrue(restored.resume());
    Assert.assertEquals(JsonPlayer.StatusOn.Idle, restored.getStatusOn());
  }

  @Test
  public void deepHistoryStateStartsWhereTheConstructorWould()
  {
    JsonPlayer player = new JsonPlayer("p1");
    player.stop();

    JsonPlayer restored = JsonPlayer.fromJson(player.toJson());

    Assert.assertTrue(restored.restart());
    Assert.assertEquals(JsonPlayer.ModeActive.Waiting, restored.getModeActive());
  }

  @Test(expected = IllegalArgumentException.class)
  public void unknownStateIsRejected()
  {
    JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"name\" : \"p1\", \"status\" : \"Broken\"}}");
  }

  @Test
  public void missingStatesStartWhereTheConstructorWould()
  {
    JsonPlayer restored = JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"name\" : \"p1\"}}");

    Assert.assertEquals("p1", restored.getName());
    Assert.assertEquals(JsonPlayer.Status.Off, restored.getStatus());
    Assert.assertEquals(JsonPlayer.StatusOn.Null, restored.getStatusOn());
    Assert.assertEquals(JsonPlayer.Mode.Active, restored.getMode());
    Assert.assertEquals(JsonPlayer.ModeActive.Waiting, restored.getModeActive());
    Assert.assertTrue(restored.work());
  }
}
