package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToMNTest {
    
    @Test 
    public void setAndDelete(){
        X0_1__m_n x1=new X0_1__m_n(1);
        X0_1__m_n x2=new X0_1__m_n(1);
        Y0_1__m_n y1=new Y0_1__m_n(new X0_1__m_n[]{x1, x2});

        Assert.assertEquals(y1, x1.getY0_1__m_n());
        Assert.assertEquals(y1, x2.getY0_1__m_n());

        y1.delete();

        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertNull(x1.getY0_1__m_n());
        Assert.assertNull(x2.getY0_1__m_n());
    }
}
