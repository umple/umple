package cruise.associations.compositions;
import org.junit.*;

public class ReflexiveOneTest {
    
    @Test(expected=RuntimeException.class)
    public void constructorNotSettingNull(){
        Z_1_1 z1=new Z_1_1(12, (YR_1_1)null);
    }

    @Test(expected=RuntimeException.class)
    public void constructionNotSettingXWithNonNullY(){
        Z_1_1 z1=new Z_1_1(12);
        YR_1_1 y1=new YR_1_1(z1);
    }

    @Test
    public void oneToOneSetAndDelete(){
        Z_1_1 z1=new Z_1_1(12);
        YR_1_1 y1= z1.getY_1_1();

        Assert.assertEquals(z1, y1.getZVar());
        Assert.assertEquals(y1, z1.getY_1_1());

        y1.delete();

        Assert.assertNull(y1.getZVar());
        Assert.assertNull(z1.getY_1_1());
    }

    @Test 
    public void oneToStarSetAndDelete(){
        YR_1_star y1=new YR_1_star();
        Z_1_star z1=new Z_1_star(1, y1);

        Assert.assertEquals(y1, z1.getY_1_star());
        Assert.assertEquals(z1, y1.getZVar(0));

        y1.delete();

        Assert.assertNull(z1.getY_1_star());
        Assert.assertEquals(0, y1.numberOfZVar());
    }

    @Test 
    public void manyToOneSetAndDelete(){
        Z_M_1 z1=new Z_M_1(1);
        YR_M_1 y1=new YR_M_1(z1);

        Assert.assertEquals(z1, y1.getZVar());
        Assert.assertEquals(y1, z1.getY_m_1(0));

        y1.delete();

        Assert.assertNull(y1.getZVar());
        Assert.assertEquals(0, z1.numberOfY_m_1());
    }
}
