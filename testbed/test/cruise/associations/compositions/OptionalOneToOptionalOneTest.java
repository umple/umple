package cruise.associations.compositions;
import org.junit.*;

public class OptionalOneToOptionalOneTest{

    @Test 
    public void setAndDelete(){
        X0_1__0_1 x1=new X0_1__0_1(1);
        Y0_1__0_1 y1=new Y0_1__0_1();

        Assert.assertTrue(x1.setY0_1__0_1(y1));
        Assert.assertEquals(x1, y1.getXVar());
        x1.delete();
        Assert.assertNull(y1.getXVar());
        Assert.assertNull(x1.getY0_1__0_1());
    }

    
}