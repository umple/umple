package cruise.associations.compositions;
import org.junit.*;

public class ManyToManyTest {

    @Test 
    public void setAndDelete(){
        XM_M x1=new XM_M(2);
        XM_M x2=new XM_M(2);
        YM_M y1=new YM_M();
        YM_M y2=new YM_M();
        x1.addYm_m(y1);
        x1.addYm_m(y2);
        y1.addXVar(x2);

        x1.delete();

        Assert.assertEquals(0, x1.numberOfYm_m());
        Assert.assertEquals(0, x2.numberOfYm_m());
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
    }
}
