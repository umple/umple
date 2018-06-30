package cruise.umple.compiler.mixset;

import org.junit.*;
import cruise.umple.UmpleConsoleMain;
import cruise.umple.util.SampleFileWriter;

public class UmpleMixsetTest {
	
	@Test
	public void mixsetUseInCodeTest() {
		String[] args = new String[] {"mixsetUseInCodeTest.ump"};
    
		SampleFileWriter.createFile("mixsetUseInCodeTest.ump", " class Outer_Mix_1{ } mixset Mix { class Inner_Mix {name;} } class Outer_Mix_2{ }"
				+ "\n"
				+ " use Mix; "
				+ "\n");

		try 
		{
			UmpleConsoleMain.main(args);
			SampleFileWriter.assertFileExists("Inner_Mix.java");
			SampleFileWriter.assertFileExists("Outer_Mix_1.java");
			SampleFileWriter.assertFileExists("Outer_Mix_2.java");

		}	
		finally 
		{
			SampleFileWriter.destroy("mixsetUseInCodeTest.ump");
			SampleFileWriter.destroy("Inner_Mix.java");
			SampleFileWriter.destroy("Outer_Mix_1.java");
			SampleFileWriter.destroy("Outer_Mix_2.java");
		}
	}
	
	@Test
	public void mixsetUseInConsoleTest() {
		String[] args = new String[] {"mixsetUseInConsoleTest.ump", "Mx"};

		SampleFileWriter.createFile("mixsetUseInConsoleTest.ump", " class Outer_1{ } mixset Mx { class Inner_M1 {name;} } class Outer_2{ }");

		try 
		{
			UmpleConsoleMain.main(args);
			SampleFileWriter.assertFileExists("Inner_M1.java");
			SampleFileWriter.assertFileExists("Outer_1.java");
			SampleFileWriter.assertFileExists("Outer_2.java");

		}	
		finally 
		{
			SampleFileWriter.destroy("mixsetUseInConsoleTest.ump");
			SampleFileWriter.destroy("Inner_M1.java");
			SampleFileWriter.destroy("Outer_1.java");
			SampleFileWriter.destroy("Outer_2.java");
		}
	}
		
		
		@Test
		public void multipleMixsetUseInConsoleTest() {
			String[] args = new String[] {"mixset_1.ump", "M2", "mixset_2.ump", "M1"};

			SampleFileWriter.createFile("mixset_1.ump", "mixset M1 { class Inner_1 { } }" );
			SampleFileWriter.createFile("mixset_2.ump", "mixset M2 { class Inner_2 { } }");

			try 
			{
				UmpleConsoleMain.main(args);
				SampleFileWriter.assertFileExists("Inner_1.java");
				SampleFileWriter.assertFileExists("Inner_2.java");

			}	
			finally 
			{
				SampleFileWriter.destroy("mixset_1.ump");
				SampleFileWriter.destroy("mixset_2.ump");
				SampleFileWriter.destroy("Inner_1.java");
				SampleFileWriter.destroy("Inner_2.java");
			}
		}
}

