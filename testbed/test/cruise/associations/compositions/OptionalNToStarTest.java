package cruise.associations.compositions;
import org.junit.*;

public class OptionalNToStarTest {

    @Test 
    public void setAndDelete(){
        X0_n__star x1=new X0_n__star(1);
        Y0_n__star y1=new Y0_n__star();
        Y0_n__star y2=new Y0_n__star();

        x1.addY0_n__star(y1);
        x1.addY0_n__star(y2);

        x1.delete();

        Assert.assertEquals(0, x1.numberOfY0_n__star());
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
    }
}
