package cruise.associations.compositions;
import org.junit.*;

public class OptionalNToMTest {
    
    @Test 
    public void setAndDelete(){
        X0_n__m x1=new X0_n__m(1);
        X0_n__m x2=new X0_n__m(1);
        X0_n__m x3=new X0_n__m(1);
        Y0_n__m y1=new Y0_n__m();
        y1.addXVar(x1);
        y1.addXVar(x2);
        y1.addXVar(x3);

        y1.delete();

        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, x1.numberOfY0_n__m());
        Assert.assertEquals(0, x2.numberOfY0_n__m());
        Assert.assertEquals(0, x3.numberOfY0_n__m());
    }
}
