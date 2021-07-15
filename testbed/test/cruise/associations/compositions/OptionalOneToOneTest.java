package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToOneTest {

    @Test 
    public void setAndDelete(){
        X0_1__1 x1=new X0_1__1(1);
        Y0_1__1 y1=new Y0_1__1(x1);

        Assert.assertEquals(y1, x1.getY0_1__1());
        Assert.assertEquals(x1, y1.getXVar());
        y1.delete();
        
        Assert.assertNull(x1.getY0_1__1());
        Assert.assertNull(y1.getXVar());
    }
}
