package cruise.associations.compositions;
import org.junit.*;

public class MNToMTest {

    @Test 
    public void setAndDelete(){
        Xm_n__m x1=new Xm_n__m(1);
        Ym_n__m y1=new Ym_n__m();
        y1.addXVar(x1);
        
        x1.delete();

        Assert.assertEquals(0, y1.numberOfXVar());
        Assert.assertEquals(0, x1.numberOfYm_n__m());
    }
}
