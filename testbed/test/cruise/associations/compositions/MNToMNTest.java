package cruise.associations.compositions;
import org.junit.*;

public class MNToMNTest {
    
    @Test 
    public void setAndDelete(){
        Xm_n__m_n x1=new Xm_n__m_n(1);
        Xm_n__m_n x2=new Xm_n__m_n(1);
        Xm_n__m_n x3=new Xm_n__m_n(1);
        Ym_n__m_n y1=new Ym_n__m_n();
        Ym_n__m_n y2=new Ym_n__m_n();
        Ym_n__m_n y3=new Ym_n__m_n();

        x1.addYm_n__m_n(y1);
        x1.addYm_n__m_n(y2);
        x1.addYm_n__m_n(y3);
        y1.addXVar(x2);
        y1.addXVar(x3);

        x1.delete();
        y1.delete();

        Assert.assertEquals(0, x1.numberOfYm_n__m_n());
        Assert.assertEquals(0, x2.numberOfYm_n__m_n());
        Assert.assertEquals(0, x3.numberOfYm_n__m_n());
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
        Assert.assertEquals(0, y3.numberOfXVar());
    }
}
