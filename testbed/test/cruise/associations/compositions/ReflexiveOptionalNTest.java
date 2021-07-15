package cruise.associations.compositions;
import org.junit.*;

public class ReflexiveOptionalNTest {
    
    @Test 
    public void optionalNToOptionalNSetAndDelete(){
        Z_0_n__0_n z1=new Z_0_n__0_n(1);
        Z_0_n__0_n z2=new Z_0_n__0_n(1);
        YR_0_n__0_n y1=new YR_0_n__0_n();
        
        y1.addZVar(z1);
        y1.addZVar(z2);

        Assert.assertTrue(z1.getY_0_n__0_n().contains(y1));
        Assert.assertTrue(z2.getY_0_n__0_n().contains(y1));
        Assert.assertTrue(y1.getZVar().contains(z1));
        Assert.assertTrue(y1.getZVar().contains(z2));

        y1.delete();

        Assert.assertEquals(0, z1.numberOfY_0_n__0_n());
        Assert.assertEquals(0, z1.numberOfY_0_n__0_n());
        Assert.assertEquals(0, y1.numberOfZVar());
    }
    @Test 
    public void optionalNToOneSetAndDelete(){
        Z_0_n__1 z1=new Z_0_n__1(1);
        YR_0_n__1 y1=new YR_0_n__1(z1);

        Assert.assertEquals(z1, y1.getZVar());
        Assert.assertTrue(z1.getY_0_n__1().contains(y1));

        y1.delete();

        Assert.assertNull(y1.getZVar());
        Assert.assertEquals(0, z1.numberOfY_0_n__1());
    }
    @Test 
    public void optionalNToManySetAndDelete(){
        Z_0_n__m z1=new Z_0_n__m(1);
        Z_0_n__m z2=new Z_0_n__m(1);
        Z_0_n__m z3=new Z_0_n__m(1);
        YR_0_n__m y1=new YR_0_n__m();
        y1.addZVar(z1);
        y1.addZVar(z2);
        y1.addZVar(z3);

        Assert.assertTrue(y1.getZVar().contains(z1));
        Assert.assertTrue(y1.getZVar().contains(z2));
        Assert.assertTrue(y1.getZVar().contains(z3));
        Assert.assertEquals(y1, z1.getY_0_n__m(0));
        Assert.assertEquals(y1, z2.getY_0_n__m(0));
        Assert.assertEquals(y1, z3.getY_0_n__m(0));

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_0_n__m());
        Assert.assertEquals(0, z2.numberOfY_0_n__m());
        Assert.assertEquals(0, z3.numberOfY_0_n__m());
    }

    @Test 
    public void optionalNToMNSetAndDelete(){
        YR_0_n__m_n y1=new YR_0_n__m_n();
        Z_0_n__m_n z1=new Z_0_n__m_n(1);
        Z_0_n__m_n z2=new Z_0_n__m_n(1);

        y1.addZVar(z1);
        y1.addZVar(z2);

        Assert.assertEquals(2, y1.numberOfZVar());
        Assert.assertEquals(y1, z1.getY_0_n__m_n(0));
        Assert.assertEquals(y1, z2.getY_0_n__m_n(0));

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_0_n__m_n());
        Assert.assertEquals(0, z2.numberOfY_0_n__m_n());
    }

    @Test 
    public void optionalNToStarSetAndDelete(){
        YR_0_n__star y1=new YR_0_n__star();
        Z_0_n__star z1=new Z_0_n__star(1);

        y1.addZVar(z1);

        Assert.assertEquals(z1, y1.getZVar(0));
        Assert.assertEquals(y1, z1.getY_0_n__star(0));
        
        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_0_n__star());
    }
}
