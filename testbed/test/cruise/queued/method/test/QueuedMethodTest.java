package cruise.queued.method.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class QueuedMethodTest
{
  QueuedAndNonQueuedMethods instance;
  
  @Before
  public void setUp() 
  {
    instance = new QueuedAndNonQueuedMethods();
  }

  @After
  public void tearDown() 
  {
    instance.delete();
  }
  
  @Test
  public void processQueuedAndNonQueuedMethods() throws InterruptedException
  {
    instance.queuedMethod();
    instance.nonqueuedMethod();
  
    Thread.sleep(1000); //Allows time for both methods to finish excecution
    
    boolean queuedMethodExecuted = false;
    boolean nonqueuedMethodExecuted = false;
    
    for( String log : instance.getLog() )
    {
      if(queuedMethodExecuted && !nonqueuedMethodExecuted)
      {
        Assert.fail();
        break;
      }
      
      switch (log)
      {
        case "queuedMethod executed":
          queuedMethodExecuted = true;
        case "nonQueuedMethod executed":
          nonqueuedMethodExecuted = true;
      }
      
      if(log.contains("interrupted"))
      {
        Assert.fail();
      }
    }
    
  }
}