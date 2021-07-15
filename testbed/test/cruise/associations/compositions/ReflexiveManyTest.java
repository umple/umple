package cruise.associations.compositions;
import org.junit.*;

public class ReflexiveManyTest {

    @Test 
    public void manyToManySetAndDelete(){
        Z_M_M z1=new Z_M_M(1);
        YR_M_M y1=new YR_M_M();
        y1.addZVar(z1);
        y1.addZVar(new Z_M_M(1));
        y1.addZVar(new Z_M_M(1));

        Assert.assertEquals(3, y1.numberOfZVar());
        Assert.assertEquals(1, z1.numberOfY_m_m());

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_m_m());
    }

    @Test 
    public void mnToOneSetAndDelete(){
        Z_m_n__1 z1=new Z_m_n__1(1);
        YR_m_n__1 y1=new YR_m_n__1(z1);

        Assert.assertEquals(z1, y1.getZVar());
        Assert.assertEquals(y1, z1.getY_m_n__1(0));

        y1.delete();

        Assert.assertNull(y1.getZVar());
        Assert.assertEquals(0, z1.numberOfY_m_n__1());
    }

    @Test 
    public void mnToMSetAndDelete(){
        YR_m_n__m y1=new YR_m_n__m();
        Z_m_n__m z1=new Z_m_n__m(1);

        y1.addZVar(z1);
        
        Assert.assertEquals(z1, y1.getZVar(0));
        Assert.assertEquals(y1, z1.getY_m_n__m(0));

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_m_n__m());
    }

    @Test 
    public void mnToMnSetAndDelete(){
        Z_m_n__m_n z1=new Z_m_n__m_n(1);
        YR_m_n__m_n y1=new YR_m_n__m_n();
        y1.addZVar(z1);
        y1.addZVar(new Z_m_n__m_n(1));

        Assert.assertEquals(2, y1.numberOfZVar());
        Assert.assertEquals(1, z1.numberOfY_m_n__m_n());

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_m_n__m_n());

    }

    @Test 
    public void mnToStarSetAndDelete(){
        YR_m_n__star y1=new YR_m_n__star();
        YR_m_n__star y2=new YR_m_n__star();
        Z_m_n__star z1=new Z_m_n__star(1, new YR_m_n__star[]{y1, y2});

        Assert.assertEquals(2, z1.numberOfY_m_n__star());
        Assert.assertEquals(1, y1.numberOfZVar());
        Assert.assertEquals(1, y2.numberOfZVar());

        z1.delete();

        Assert.assertEquals(0, z1.numberOfY_m_n__star());
        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, y2.numberOfZVar());
    }

    @Test 
    public void manyToStarSetAndDelete(){
        YR_M_star y1=new YR_M_star();
        YR_M_star y2=new YR_M_star();
        YR_M_star y3=new YR_M_star();
        Z_M_star z1=new Z_M_star(3, new YR_M_star[]{y1, y2, y3});

        Assert.assertEquals(3, z1.numberOfY_m_star());
        Assert.assertEquals(1, y1.numberOfZVar());
        Assert.assertEquals(1, y2.numberOfZVar());
        Assert.assertEquals(1, y3.numberOfZVar());
    }
}
