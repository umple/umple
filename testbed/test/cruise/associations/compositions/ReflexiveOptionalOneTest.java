package cruise.associations.compositions;
import org.junit.*;

public class ReflexiveOptionalOneTest {

    @Test 
    public void optionalOneToOptionalOneSetAndDelete(){
        Z_0_1__0_1 z1=new Z_0_1__0_1(1);
        YR_0_1__0_1 y1=new YR_0_1__0_1();

        z1.setY_0_1__0_1(y1);

        z1.delete();

        Assert.assertNull(z1.getY_0_1__0_1());
        Assert.assertNull(y1.getZVar());
    }

    @Test 
    public void optionalOneToOptionalNSetAndDelete(){
        YR_0_1__0_n y1=new YR_0_1__0_n();
        Z_0_1__0_n z1=new Z_0_1__0_n(1);

        z1.setY_0_1__0_n(y1);
        y1.delete();

        Assert.assertNull(z1.getY_0_1__0_n());
        Assert.assertEquals(0, y1.numberOfZVar());
        
    }

    @Test 
    public void optionalOneToOneSetAndDelete(){
        Z_0_1__1 z1=new Z_0_1__1(1);
        YR_0_1__1 y1=new YR_0_1__1(z1);

        Assert.assertEquals(y1, z1.getY_0_1__1());
        Assert.assertEquals(z1, y1.getZVar());

        y1.delete();

        Assert.assertNull(z1.getY_0_1__1());
        Assert.assertNull(y1.getZVar());
    }

    @Test 
    public void optionalOneToManySetAndDelete(){
        Z_0_1__m z1=new Z_0_1__m(1);
        Z_0_1__m z2=new Z_0_1__m(1);
        Z_0_1__m z3=new Z_0_1__m(1);
        YR_0_1__m y1=new YR_0_1__m(new Z_0_1__m[]{z1, z2, z3});

        Assert.assertEquals(y1, z1.getY_0_1__m());
        Assert.assertEquals(y1, z2.getY_0_1__m());
        Assert.assertEquals(y1, z3.getY_0_1__m());
        Assert.assertTrue(y1.getZVar().contains(z1));
        Assert.assertTrue(y1.getZVar().contains(z2));
        Assert.assertTrue(y1.getZVar().contains(z3));

        y1.delete();

        Assert.assertNull(z1.getY_0_1__m());
        Assert.assertNull(z2.getY_0_1__m());
        Assert.assertNull(z3.getY_0_1__m());
        Assert.assertEquals(0, y1.numberOfZVar());
    }

    @Test 
    public void optionalOneToMNSetAndDelete(){
        Z_0_1__m_n z1=new Z_0_1__m_n(1);
        Z_0_1__m_n z2=new Z_0_1__m_n(1);
        YR_0_1__m_n y1=new YR_0_1__m_n(new Z_0_1__m_n[]{z1, z2});

        Assert.assertEquals(y1, z1.getY_0_1__m_n());
        Assert.assertEquals(y1, z2.getY_0_1__m_n());
        Assert.assertTrue(y1.getZVar().contains(z1));
        Assert.assertTrue(y1.getZVar().contains(z2));

        y1.delete();

        Assert.assertNull(z1.getY_0_1__m_n());
        Assert.assertNull(z2.getY_0_1__m_n());
        Assert.assertEquals(0, y1.numberOfZVar());
    }

    @Test 
    public void optionalOneToStarSetAndDelete(){
        Z_0_1__star z1=new Z_0_1__star(1);
        YR_0_1__star y1=new YR_0_1__star();
        z1.setY_0_1__star(y1);

        Assert.assertEquals(y1, z1.getY_0_1__star());
        Assert.assertEquals(z1, y1.getZVar(0));

        z1.delete();

        Assert.assertNull(z1.getY_0_1__star());
        Assert.assertEquals(0, y1.numberOfZVar());
    }
}
