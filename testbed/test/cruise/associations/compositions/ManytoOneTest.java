package cruise.associations.compositions;
import org.junit.*;

public class ManytoOneTest {
    
    @Test 
    public void setAndDelete(){
        XM_1 x1=new XM_1(1);
        YM_1 y1=new YM_1(x1);
        YM_1 y2=new YM_1(x1);
        YM_1 y3=new YM_1(x1);
        
        x1.delete();

        Assert.assertNull(y1.getXVar());
        Assert.assertNull(y2.getXVar());
        Assert.assertNull(y3.getXVar());
        Assert.assertEquals(0, x1.numberOfYm_1());
    }
}
