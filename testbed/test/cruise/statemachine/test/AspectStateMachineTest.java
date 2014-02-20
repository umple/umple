package cruise.statemachine.test;

import java.util.Observable;
import java.util.Observer;

import org.junit.*;

public class AspectStateMachineTest implements Observer
{
  int testingState = 0;
  @Test
  public void hasBeforeAndAfter()
  {
    ObservableCourse course = new ObservableCourse();
    course.addObserver(this);
    course.anEvent();
    ++testingState;
    course.anEvent();
    Assert.assertEquals(testingState,5);
  }

  @Override
  public void update(Observable arg0, Object arg1) {
	  ObservableCourse course = (ObservableCourse)arg0;
	  String state = arg1.toString();
	switch(testingState)
	{
	case 0:{
		Assert.assertEquals("Open",state);
		Assert.assertEquals("before",course.getLog());
		break;
	}
	case 1:{
		Assert.assertEquals("Closed",state);
		Assert.assertEquals("after",course.getLog());
		break;
	}
	case 3:{
		Assert.assertEquals("Closed",state);
		Assert.assertEquals("before",course.getLog());
		break;
	}
	case 4:{
		Assert.assertEquals("Open",state);
		Assert.assertEquals("after",course.getLog());
		break;
	}
	}
	++testingState;
  }
}
