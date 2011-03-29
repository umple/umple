package cruise.umple.compiler;

import org.junit.*;
import java.util.*;

public class GeneratorHelperTest
{
  @Test
  public void toCode_none()
  {
    Assert.assertEquals(null,GeneratorHelper.toCode(null));
    Assert.assertEquals(null,GeneratorHelper.toCode(new ArrayList<CodeInjection>()));
  }
  
  @Test
  public void toCode_one()
  {
    List<CodeInjection> all = new ArrayList<CodeInjection>();
    CodeInjection code = new CodeInjection("before","myOpp","//code");
    all.add(code);
    Assert.assertEquals("//code",GeneratorHelper.toCode(all));
  }

  @Test
  public void toCode_many()
  {
    List<CodeInjection> all = new ArrayList<CodeInjection>();
    all.add(new CodeInjection("before","myOpp","//code"));
    all.add(new CodeInjection("before","myOpp","//code2"));

    Assert.assertEquals("//code\n    //code2",GeneratorHelper.toCode(all));
  }


}
