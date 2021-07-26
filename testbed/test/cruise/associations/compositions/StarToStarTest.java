package cruise.associations.compositions;
import org.junit.*;

public class StarToStarTest {

    @Test 
    public void setAndDelete(){
        Ystar_star y1=new Ystar_star();
        Ystar_star y2=new Ystar_star();
        Xstar_star x1=new Xstar_star(1);
        x1.addYstar_star(y1);
        x1.addYstar_star(y2);

        x1.delete();
        Assert.assertEquals(0, x1.numberOfYstar_star());
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
    }
}
