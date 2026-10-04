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
  public void missingStatesGetTheirStartState()
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

  @Test
  public void restoredTimedStateTimesOutAgain() throws InterruptedException
  {
    JsonClock restored = JsonClock.fromJson(new JsonClock().toJson());

    for (int i = 0; i < 300 && restored.getStatus() != JsonClock.Status.Done; i++)
    {
      Thread.sleep(10);
    }
    Assert.assertEquals(JsonClock.Status.Done, restored.getStatus());
  }

  @Test
  public void restoredTimedStateTakesOtherEvents()
  {
    JsonClock restored = JsonClock.fromJson(new JsonClock().toJson());

    Assert.assertTrue(restored.cancel());
    Assert.assertEquals(JsonClock.Status.Cancelled, restored.getStatus());
  }

  @Test
  public void restoredQueuedMachineTakesEvents() throws InterruptedException
  {
    JsonQueued restored = JsonQueued.fromJson(new JsonQueued().toJson());

    restored.go();
    for (int i = 0; i < 100 && restored.getStatus() != JsonQueued.Status.Done; i++)
    {
      Thread.sleep(10);
    }
    Assert.assertEquals(JsonQueued.Status.Done, restored.getStatus());
    restored.delete();
  }

  @Test
  public void restoredPooledMachineTakesEvents() throws InterruptedException
  {
    JsonPooled restored = JsonPooled.fromJson(new JsonPooled().toJson());

    restored.go();
    for (int i = 0; i < 100 && restored.getStatus() != JsonPooled.Status.Done; i++)
    {
      Thread.sleep(10);
    }
    Assert.assertEquals(JsonPooled.Status.Done, restored.getStatus());
    restored.delete();
  }

  @Test
  public void associatedObjectStatesRoundTrip()
  {
    JsonBank bank = new JsonBank();
    new JsonAccount(bank).block();
    bank.close();

    JsonBank restored = JsonBank.fromJson(bank.toJson());

    Assert.assertEquals(JsonBank.Status.Closed, restored.getStatus());
    Assert.assertEquals(JsonAccount.Status.Blocked, restored.getAccount(0).getStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void unknownStateOfAssociatedObjectIsRejected()
  {
    JsonBank bank = new JsonBank();
    new JsonAccount(bank);

    JsonBank.fromJson(bank.toJson().replace("\"Active\"", "\"Broken\""));
  }

  @Test
  public void stateMachinesNamedLikeJsonVariablesRoundTrip()
  {
    JsonNamed named = new JsonNamed();
    named.go();
    named.raise();

    JsonNamed restored = JsonNamed.fromJson(named.toJson());

    Assert.assertEquals(JsonNamed.ParsedResult.Done, restored.getParsedResult());
    Assert.assertEquals(JsonNamed.Indent.High, restored.getIndent());
  }

  @Test
  public void workersInARestoredGraphTakeEvents() throws InterruptedException
  {
    JsonWorkerGroup group = new JsonWorkerGroup("g");
    JsonWorker worker = new JsonWorker(group);

    JsonWorker restored = JsonWorkerGroup.fromJson(group.toJson()).getWorker(0);

    restored.go();
    for (int i = 0; i < 100 && restored.getStatus() != JsonWorker.Status.Done; i++)
    {
      Thread.sleep(10);
    }
    Assert.assertEquals(JsonWorker.Status.Done, restored.getStatus());
    restored.delete();
    worker.delete();
  }

  @Test
  public void failedLoadStartsNoThreads() throws InterruptedException
  {
    JsonWorkerGroup group = new JsonWorkerGroup("g");
    JsonWorker waiting = new JsonWorker(group);
    JsonWorker done = new JsonWorker(group);
    done.go();
    for (int i = 0; i < 100 && done.getStatus() != JsonWorker.Status.Done; i++)
    {
      Thread.sleep(10);
    }
    String json = group.toJson().replace("\"Done\"", "\"Broken\"");
    java.util.Set<Thread> before = Thread.getAllStackTraces().keySet();

    try
    {
      JsonWorkerGroup.fromJson(json);
      Assert.fail("an unknown state must fail the load");
    }
    catch (IllegalArgumentException e)
    {
    }

    java.util.Set<Thread> started = new java.util.HashSet<Thread>(Thread.getAllStackTraces().keySet());
    started.removeAll(before);
    Assert.assertTrue(started.toString(), started.isEmpty());
    waiting.delete();
    done.delete();
  }

  @Test
  public void emptyQueuedMachineStartsNoThread()
  {
    String json = new JsonEmptyQueued().toJson();
    java.util.Set<Thread> before = Thread.getAllStackTraces().keySet();

    JsonEmptyQueued.fromJson(json);

    java.util.Set<Thread> started = new java.util.HashSet<Thread>(Thread.getAllStackTraces().keySet());
    started.removeAll(before);
    Assert.assertTrue(started.toString(), started.isEmpty());
  }
}
