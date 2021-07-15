package cruise.associations.compositions;
import org.junit.*;

public class OptionalNToOptionalNTest {
    
    @Test
    public void setAndDelete(){
        X0_n__0_n x1=new X0_n__0_n(1);
        Y0_n__0_n y1=new Y0_n__0_n();

        y1.addXVar(x1);
        y1.addXVar(new X0_n__0_n(1));
        x1.addY0_n__0_n(new Y0_n__0_n());

        x1.delete();
        Assert.assertEquals(0, x1.numberOfY0_n__0_n());
        Assert.assertEquals(0, y1.numberOfXVar());
    }
}
