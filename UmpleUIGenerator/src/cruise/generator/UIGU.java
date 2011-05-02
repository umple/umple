package cruise.generator;

import java.io.IOException;

public class UIGU {
	
	public static void main(String args[]){
		if(args.length!=1 && args.length!=4){
			System.out.println("Usage: java    -classpath %CLASSPATH%; cruise.generator.UIGU \"xmlPath\"");
			System.out.println("Usage: java    -classpath %CLASSPATH%; cruise.generator.UIGU \"xmlpath\" \"umpleFilePath\" \"outputFolder\" \"projectName\"");
			System.out.println("Be sure that Umple, the provider and the model are in the classpath.");
			return;
		}
		Generator g=new Generator(args);
		try {
			g.generate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
