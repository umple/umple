package cruise.associations.compositions;
import org.junit.*;


public class OptionalNtoOneTest {
    
    @Test 
    public void setAndDelete(){
        X0_n__1 x1=new X0_n__1(1);
        X0_n__1 x2=new X0_n__1(1); 
        Y0_n__1 y1=new Y0_n__1(x1);
        x1.addY0_n__1(new Y0_n__1(x2));

        x1.delete();

        Assert.assertNull(y1.getXVar());
        Assert.assertEquals(0, x1.numberOfY0_n__1());

    }
}
