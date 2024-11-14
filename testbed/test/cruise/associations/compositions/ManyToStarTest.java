package cruise.associations.compositions;
import org.junit.*;

public class ManyToStarTest {

    @Test 
    public void setAndDelete(){
        YM_star y1=new YM_star();
        YM_star y2=new YM_star();
        YM_star y3=new YM_star();
        XM_star x1=new XM_star(3, new YM_star[]{y1, y2, y3});
       
        x1.delete();
        
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
        Assert.assertEquals(0, y3.numberOfXVar());
        Assert.assertEquals(0, x1.numberOfYm_star());
    }
}
