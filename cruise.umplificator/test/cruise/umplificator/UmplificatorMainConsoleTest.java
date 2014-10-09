package cruise.umplificator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import cruise.umplificator.UmplificatorMain;

public class UmplificatorMainConsoleTest {

	@Test
	public void MainOneUmpleFileAsInput() {
	String[] args = new String[] {"testclass.ump"};
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
		    out.write("class Testclass {}");
		    out.close();
		    
		    UmplificatorMain.main(args);
		    
		    new File("testclass.ump").delete();
		} catch (IOException e) {
			Assert.fail();
		}
	}
	

	@Test
	public void MainOneUmpleFileAsInputTwoAsOutput() {
	String[] args = new String[] {"-splitModel testclass.ump"};
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
		    out.write("class Testclass {}");
		    out.close();
		    
		    UmplificatorMain.main(args);
		    
		    new File("testclass.ump").delete();
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
