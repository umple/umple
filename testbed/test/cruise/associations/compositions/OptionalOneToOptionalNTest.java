package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToOptionalNTest {

    @Test
    public void setAndDelete(){
        Y0_1__0_n y1=new Y0_1__0_n();
        X0_1__0_n x1=new X0_1__0_n(1);

        y1.addXVar(x1);
        y1.addXVar(new X0_1__0_n(1));
        
        Assert.assertEquals(2, y1.numberOfXVar());
        Assert.assertEquals(y1, x1.getY0_1__0_n());
        y1.delete();
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertNull(x1.getY0_1__0_n());
    }
}
