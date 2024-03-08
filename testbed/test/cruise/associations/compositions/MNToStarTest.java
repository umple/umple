package cruise.associations.compositions;
import org.junit.*;

public class MNToStarTest {

    @Test 
    public void setAndDelete(){
        Ym_n__star y1=new Ym_n__star();
        Ym_n__star y2=new Ym_n__star();
        Xm_n__star x1=new Xm_n__star(2, new Ym_n__star[]{y1, y2});

        x1.delete();
        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, y2.numberOfXVar());
        Assert.assertEquals(0, x1.numberOfYm_n__star());
    }
}
