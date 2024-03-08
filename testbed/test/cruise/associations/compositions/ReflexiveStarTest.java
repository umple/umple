package cruise.associations.compositions;
import org.junit.*;


public class ReflexiveStarTest {
    
    @Test 
    public void check42(){
        Z_star_star z1=new Z_star_star(1);
        YR_star_star y1=new YR_star_star();

        y1.addZVar(z1);

        Assert.assertEquals(z1, y1.getZVar(0));
        Assert.assertEquals(y1, z1.getY_star_star(0));

        y1.delete();

        Assert.assertEquals(0, y1.numberOfZVar());
        Assert.assertEquals(0, z1.numberOfY_star_star());

    }
}
