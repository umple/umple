package cruise.associations.compositions;
import org.junit.*;

public class OneToOneTest {
    
    @Test(expected=RuntimeException.class)
    public void constructorNotSettingNull(){
        X1_1 x1=new X1_1(12, (Y1_1)null);
    }

    @Test(expected=RuntimeException.class)
    public void constructionNotSettingXWithNonNullY(){
        X1_1 x1=new X1_1(1);
        Y1_1 y1=new Y1_1(x1);
    }

    @Test
    public void settingAndDeleting(){
        X1_1 x1=new X1_1(1);
        Y1_1 y1= x1.getY1_1();

        Assert.assertEquals(x1, y1.getXVar());
        Assert.assertEquals(y1, x1.getY1_1());

        y1.delete();

        Assert.assertNull(y1.getXVar());
        Assert.assertNull(x1.getY1_1());
    }
}
