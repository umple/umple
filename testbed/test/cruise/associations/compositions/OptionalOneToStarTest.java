package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToStarTest {

    @Test 
    public void setAndDelete(){
        X0_1__star x1=new X0_1__star(1);
        X0_1__star x2=new X0_1__star(1);
        Y0_1__star y1=new Y0_1__star();

        x1.setY0_1__star(y1);
        x2.setY0_1__star(y1);
        Assert.assertEquals(y1, x1.getY0_1__star());
        Assert.assertEquals(y1, x2.getY0_1__star());

        y1.delete();

        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertNull(x1.getY0_1__star());
        Assert.assertNull(x2.getY0_1__star());
    }
}
