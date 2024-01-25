package cruise.associations.compositions;
import org.junit.*;

public class OneToStarTest {

    @Test 
    public void setAndDelete(){
        Y1_star y1=new Y1_star();
        X1_star x1=new X1_star(1, y1);

        y1.delete();

        Assert.assertNull(x1.getY1_star());
        Assert.assertEquals(0, y1.numberOfXVar());
    }
}
