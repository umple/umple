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
  public void bareJsonValuesOfOtherKeysAreSkipped()
  {
    JsonPlayer restored = JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"a\" : null, \"name\" : \"p1\", \"b\" : true,"
      + " \"c\" : false, \"status\" : \"On\", \"d\" : -1.2e3, \"statusOn\" : \"Playing\", \"e\" : 42}}");

    Assert.assertEquals("p1", restored.getName());
    Assert.assertEquals("On.Playing", restored.getStatusFullName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void unknownStateAfterBareJsonValuesIsRejected()
  {
    JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"a\" : null, \"name\" : \"p1\", \"b\" : 42, \"status\" : \"Broken\"}}");
  }

  @Test
  public void keyWithEscapedQuoteIsSkipped()
  {
    JsonPlayer restored = JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"a\\\"b\" : \"x\", \"name\" : \"p1\", \"status\" : \"On\"}}");

    Assert.assertEquals("p1", restored.getName());
    Assert.assertEquals(JsonPlayer.Status.On, restored.getStatus());
  }

  @Test
  public void keyWithoutColonEndsTheObjectsFields()
  {
    String start = "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\", \"name\" : \"p1\", \"status\", ";

    JsonPlayer known = JsonPlayer.fromJson(start + "\"On\"}}");
    JsonPlayer unknown = JsonPlayer.fromJson(start + "\"Broken\"}}");

    Assert.assertEquals("p1", known.getName());
    Assert.assertEquals(JsonPlayer.Status.Off, known.getStatus());
    Assert.assertEquals("p1", unknown.getName());
    Assert.assertEquals(JsonPlayer.Status.Off, unknown.getStatus());
  }

  @Test
  public void tabsAndLineBreaksBetweenFieldsAreSkipped()
  {
    JsonPlayer restored = JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\",\t\"name\" : \"p1\",\r\n\"status\" : \"On\",\r\n\t\"statusOn\" : \"Playing\"}}");

    Assert.assertEquals("p1", restored.getName());
    Assert.assertEquals("On.Playing", restored.getStatusFullName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void unknownStateAfterTabsAndLineBreaksIsRejected()
  {
    JsonPlayer.fromJson(
      "{\"JsonPlayer\" : {\"umpleObjectID\" : \"1\",\t\"name\" : \"p1\",\r\n\"status\" : \"Broken\"}}");
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
    JsonQueued original = new JsonQueued();
    JsonQueued restored = null;
    try
    {
      restored = JsonQueued.fromJson(original.toJson());
      restored.go();
      for (int i = 0; i < 100 && restored.getStatus() != JsonQueued.Status.Done; i++)
      {
        Thread.sleep(10);
      }
      Assert.assertEquals(JsonQueued.Status.Done, restored.getStatus());
    }
    finally
    {
      original.delete();
      if (restored != null)
      {
        restored.delete();
      }
    }
  }

  @Test
  public void restoredPooledMachineTakesEvents() throws InterruptedException
  {
    JsonPooled original = new JsonPooled();
    JsonPooled restored = null;
    try
    {
      restored = JsonPooled.fromJson(original.toJson());
      restored.go();
      for (int i = 0; i < 100 && restored.getStatus() != JsonPooled.Status.Done; i++)
      {
        Thread.sleep(10);
      }
      Assert.assertEquals(JsonPooled.Status.Done, restored.getStatus());
    }
    finally
    {
      original.delete();
      if (restored != null)
      {
        restored.delete();
      }
    }
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
  public void membersOfAnAssociationOnlyTeamKeepTheirStates()
  {
    JsonTeam team = new JsonTeam();
    JsonMember playing = new JsonMember(team);
    playing.turnOn();
    playing.play();
    new JsonMember(team);

    JsonTeam restored = JsonTeam.fromJson(team.toJson());

    Assert.assertEquals("On.Playing", restored.getMember(0).getStatusFullName());
    Assert.assertEquals("Off", restored.getMember(1).getStatusFullName());
  }

  @Test
  public void bareJsonValueBetweenAssociatedObjectsIsSkipped()
  {
    assertBothMembersRestoredWithBetweenThem("null,");
  }

  @Test
  public void tabsAndLineBreaksBetweenAssociatedObjectsAreSkipped()
  {
    assertBothMembersRestoredWithBetweenThem("\r\n\t");
  }

  private static void assertBothMembersRestoredWithBetweenThem(String text)
  {
    JsonTeam team = new JsonTeam();
    JsonMember playing = new JsonMember(team);
    playing.turnOn();
    playing.play();
    new JsonMember(team);
    // the text goes after the comma that separates the two members, in json compacted as fromJson reads it
    String json = team.toJson().replace("\n", "").replace(" ", "");
    String edited = json.replace("}},{\"JsonMember\"", "}}," + text + "{\"JsonMember\"");
    Assert.assertNotEquals(json, edited);

    JsonTeam restored = JsonTeam.fromJson(edited);

    Assert.assertEquals(2, restored.numberOfMembers());
    Assert.assertEquals("On.Playing", restored.getMember(0).getStatusFullName());
    Assert.assertEquals("Off", restored.getMember(1).getStatusFullName());
    Assert.assertSame(restored, restored.getMember(1).getJsonTeam());
  }

  @Test
  public void eachLevelOfAGraphKeepsItsOwnFields()
  {
    JsonTeam team = new JsonTeam();
    JsonMember member = new JsonMember(team);
    member.turnOn();
    new JsonTask("t1", member).close();
    new JsonTask("t2", member);

    JsonMember restored = JsonTeam.fromJson(team.toJson()).getMember(0);

    Assert.assertEquals(JsonMember.Status.On, restored.getStatus());
    Assert.assertEquals("t1", restored.getTask(0).getName());
    Assert.assertEquals(JsonTask.Status.Closed, restored.getTask(0).getStatus());
    Assert.assertEquals("t2", restored.getTask(1).getName());
    Assert.assertEquals(JsonTask.Status.Open, restored.getTask(1).getStatus());
  }

  @Test
  public void valuesWithJsonSyntaxRoundTrip()
  {
    String teamName = "{\"a\":[{\"b\":\"}]\"}]}\\";
    String taskName = "\\\"[{x}]";
    JsonNamedTeam team = new JsonNamedTeam(teamName);
    JsonTask task = new JsonTask(taskName, new JsonMember(team));

    JsonNamedTeam restoredTeam = JsonNamedTeam.fromJson(team.toJson());
    // The task's json holds its member, and the member its team, as single associations
    JsonTask restoredTask = JsonTask.fromJson(task.toJson());

    Assert.assertEquals(teamName, restoredTeam.getName());
    Assert.assertEquals(taskName, restoredTeam.getMember(0).getTask(0).getName());
    Assert.assertEquals(taskName, restoredTask.getName());
    Assert.assertEquals(teamName, ((JsonNamedTeam) restoredTask.getJsonMember().getJsonTeam()).getName());
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
    JsonWorkerGroup group = new JsonWorkerGroup();
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
    JsonWorkerGroup group = new JsonWorkerGroup();
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
