package cruise.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class HistoryStatesTest
{
  @Test
  public void AutoTransitionToDeepHistory()
  {
      DeepHistoryCourse course = new DeepHistoryCourse();
      course.toSs2Sss2();
      course.toSsss1();
      course.toS2Ss2();
      Assert.assertEquals(DeepHistoryCourse.SmS1Ss2Sss2.Ssss1, course.getSmS1Ss2Sss2());
  }
  
  
  @Test
  public void ToUninitializedDeepHistory()
  {
    DeepHistoryCourse course = new DeepHistoryCourse();
    course.toS2HStar();
    Assert.assertEquals(DeepHistoryCourse.SmS2.Ss1, course.getSmS2());
  }
  
  @Test
  public void SimpleHistoryState()
  {
    HistoryCourse course = new HistoryCourse();
    course.toss2();
    Assert.assertEquals(HistoryCourse.SmS1.Ss2, course.getSmS1());
    course.tos2();
    course.toHistory();
    Assert.assertEquals(HistoryCourse.SmS1.Ss2, course.getSmS1());
  }
  
  @Test
  public void SimpleDeepHistoryState()
  {
    DeepHistoryCourse course = new DeepHistoryCourse();
    course.toSs2Sss2();
    course.toSsss2();
    course.toS2();
    course.toDeepHistory();
    Assert.assertEquals(DeepHistoryCourse.SmS1.Ss2, course.getSmS1());
    Assert.assertEquals(DeepHistoryCourse.SmS1Ss2.Sss2, course.getSmS1Ss2());
    Assert.assertEquals(DeepHistoryCourse.SmS1Ss2Sss2.Ssss2, course.getSmS1Ss2Sss2());
  }
}
