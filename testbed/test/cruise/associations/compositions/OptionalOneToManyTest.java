package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToManyTest {
    
    @Test
    public void setAndDelete(){

        X0_1__m x1=new X0_1__m(1);
        X0_1__m x2=new X0_1__m(1);
        X0_1__m x3=new X0_1__m(1);
        Y0_1__m y1=new Y0_1__m(new X0_1__m[]{x1, x2, x3});

        Assert.assertEquals(y1, x1.getY0_1__m());
        Assert.assertEquals(y1, x2.getY0_1__m());
        Assert.assertEquals(y1, x3.getY0_1__m());

        y1.delete();

        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertNull(x1.getY0_1__m());
        Assert.assertNull(x2.getY0_1__m());
        Assert.assertNull(x3.getY0_1__m());
    }
}
