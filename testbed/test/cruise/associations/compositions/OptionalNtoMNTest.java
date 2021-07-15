package cruise.associations.compositions;
import org.junit.*;

public class OptionalNtoMNTest {
    
    @Test 
    public void setAndDelete(){
        X0_n__m_n x1=new X0_n__m_n(1);
        X0_n__m_n x2=new X0_n__m_n(1);
        Y0_n__m_n y1=new Y0_n__m_n();

        y1.addXVar(x1);
        y1.addXVar(x2);

        y1.delete();
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, x1.numberOfY0_n__m_n());
        Assert.assertEquals(0, x2.numberOfY0_n__m_n());

    }
}
