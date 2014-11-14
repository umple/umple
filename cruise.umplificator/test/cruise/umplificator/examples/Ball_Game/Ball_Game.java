/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 7 "Ball_Game.ump"
public class Ball_Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ball_Game Attributes
  private String ballPosition;
  private String wallPosition;
  private String brickPosition;
  private String paddlePosition;

  //Ball_Game State Machines
  enum Ball_Status { NoBall, Initialized, BehindPaddle, Moving, HitsBrick, HitsWall, HitsPaddle, End }
  private Ball_Status ball_Status;

  //Ball_Game Do Activity Threads
  Thread doActivityBall_StatusMovingThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ball_Game(String aBallPosition, String aWallPosition, String aBrickPosition, String aPaddlePosition)
  {
    ballPosition = aBallPosition;
    wallPosition = aWallPosition;
    brickPosition = aBrickPosition;
    paddlePosition = aPaddlePosition;
    setBall_Status(Ball_Status.NoBall);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBallPosition(String aBallPosition)
  {
    boolean wasSet = false;
    ballPosition = aBallPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setWallPosition(String aWallPosition)
  {
    boolean wasSet = false;
    wallPosition = aWallPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setBrickPosition(String aBrickPosition)
  {
    boolean wasSet = false;
    brickPosition = aBrickPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaddlePosition(String aPaddlePosition)
  {
    boolean wasSet = false;
    paddlePosition = aPaddlePosition;
    wasSet = true;
    return wasSet;
  }

  public String getBallPosition()
  {
    return ballPosition;
  }

  public String getWallPosition()
  {
    return wallPosition;
  }

  public String getBrickPosition()
  {
    return brickPosition;
  }

  public String getPaddlePosition()
  {
    return paddlePosition;
  }

  public String getBall_StatusFullName()
  {
    String answer = ball_Status.toString();
    return answer;
  }

  public Ball_Status getBall_Status()
  {
    return ball_Status;
  }

  public boolean startGame()
  {
    boolean wasEventProcessed = false;
    
    Ball_Status aBall_Status = ball_Status;
    switch (aBall_Status)
    {
      case NoBall:
        setBall_Status(Ball_Status.Initialized);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean mouseClick()
  {
    boolean wasEventProcessed = false;
    
    Ball_Status aBall_Status = ball_Status;
    switch (aBall_Status)
    {
      case Initialized:
        setBall_Status(Ball_Status.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean noMoreBalls()
  {
    boolean wasEventProcessed = false;
    
    Ball_Status aBall_Status = ball_Status;
    switch (aBall_Status)
    {
      case BehindPaddle:
        setBall_Status(Ball_Status.End);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean directionUpdated()
  {
    boolean wasEventProcessed = false;
    
    Ball_Status aBall_Status = ball_Status;
    switch (aBall_Status)
    {
      case HitsBrick:
        exitBall_Status();
        setBall_Status(Ball_Status.Moving);
        wasEventProcessed = true;
        break;
      case HitsWall:
        setBall_Status(Ball_Status.Moving);
        wasEventProcessed = true;
        break;
      case HitsPaddle:
        setBall_Status(Ball_Status.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitBall_Status()
  {
    switch(ball_Status)
    {
      case Moving:
        if (doActivityBall_StatusMovingThread != null) { doActivityBall_StatusMovingThread.interrupt(); }
        break;
      case HitsBrick:
        // line 41 "Ball_Game.ump"
        calculateNewDirection();
        break;
    }
  }

  private void setBall_Status(Ball_Status aBall_Status)
  {
    ball_Status = aBall_Status;

    // entry actions and do activities
    switch(ball_Status)
    {
      case BehindPaddle:
        // line 25 "Ball_Game.ump"
        PlayTune();
        // line 26 "Ball_Game.ump"
        decrementBalls(1,bar);
        break;
      case Moving:
        doActivityBall_StatusMovingThread = new DoActivityThread(this,"doActivityBall_StatusMoving");
        break;
      case HitsBrick:
        // line 39 "Ball_Game.ump"
        playHitSound();
        // line 40 "Ball_Game.ump"
        increaseScore(1);
        break;
      case HitsWall:
        // line 46 "Ball_Game.ump"
        calculateNewDirection();
        break;
      case HitsPaddle:
        // line 52 "Ball_Game.ump"
        calculateNewDirection();
        break;
      case End:
        // line 57 "Ball_Game.ump"
        displayGameOver();
        break;
    }
  }

  private void doActivityBall_StatusMoving()
  {
    try
    {
      moving();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Ball_Game controller;
    String doActivityMethodName;
    
    public DoActivityThread(Ball_Game aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityBall_StatusMoving".equals(doActivityMethodName))
      {
        controller.doActivityBall_StatusMoving();
      }
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ballPosition" + ":" + getBallPosition()+ "," +
            "wallPosition" + ":" + getWallPosition()+ "," +
            "brickPosition" + ":" + getBrickPosition()+ "," +
            "paddlePosition" + ":" + getPaddlePosition()+ "]"
     + outputString;
  }
}