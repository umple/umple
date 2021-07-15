package cruise.associations.compositions;
import org.junit.*;

public class MNToOneTest {
    
    @Test 
    public void setAndDelete(){
        Xm_n__1 x1=new Xm_n__1(1);
        Ym_n__1 y1=new Ym_n__1(x1);
        Ym_n__1 y2=new Ym_n__1(x1);

        x1.delete();
        Assert.assertEquals(0, x1.numberOfYm_n__1());
        Assert.assertNull(y1.getXVar());
        Assert.assertNull(y2.getXVar());
    }
}
