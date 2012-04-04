/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.util.StringFormatter;

public class CodeCompiler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeCompiler()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static String console;

    public static boolean compile(UmpleModel model) {
      for (UmpleElement currentElement : model.getUmpleElements())
      {
        if ("external".equals(currentElement.getModifier()))
        {
          continue;
        }
        compileJava(currentElement, model);
      }
      return true;
    }

    private static void compileJava(UmpleElement aClass, UmpleModel model) {
        String path = StringFormatter.addPathOrAbsolute( 
                model.getUmpleFile().getPath(), 
                "") + 
            aClass.getPackageName().replace(".", File.separator);
        String filename = path + File.separator + aClass.getName() + ".java";
        try {
            Process p = Runtime.getRuntime().exec("javac "+filename);
            BufferedReader reader=new BufferedReader(new InputStreamReader(p.getErrorStream())); 
            String line=reader.readLine(); 
            while (line!=null) {
				get_original_line(line, reader, model, aClass);
				line = reader.readLine();
            }
        } catch (IOException e) {
            println(e.getMessage());
        }
    }

	private static void get_original_line(String file, BufferedReader reader, UmpleModel model, UmpleElement aClass) {
		StringTokenizer st = new StringTokenizer(file, ":"); 
		if (st.countTokens()<3) {
			return;
		}
		String code_file = st.nextToken(); //NOT USED
		st.nextToken(); // Line number in java file NOT USED
		String error_type = st.nextToken(); // Error type
		String umpFile_name = aClass.getUmpFile();

		int line_num;

		// Here to find the actually java code to match with
		try {
			// Find the ^ symbol in error message to know where the current error message end
			String error_msg="";
			String java_code = reader.readLine();
			String pos_locator;
			while(true) {
				pos_locator = reader.readLine();
				if (pos_locator.trim().equals("^")) {
					break;
				}
				error_msg = error_msg + java_code + "\n";
				java_code = pos_locator;
			}

			BufferedReader umpFile = new BufferedReader(new FileReader(model.getUmpleFile().getFileName()));
			String line;
			line_num=0;
			while(true) {
				line = umpFile.readLine();
				if (line == null) {
					break;
				}
				line_num++;
				if (line.equals(java_code)) {
					break;
				}
			}

			println(getSimpleFileName(umpFile_name)+":"+line_num+":"+error_type);
			println(error_msg+java_code+"\n"+pos_locator);

			umpFile.close();
		} catch (IOException e) {
		}
	}
	
	private static void println(String output)
    {
        console += output + "\n";
        System.out.println(output);
    }

  public static String getSimpleFileName(String fileName)
  {

    int lastIndex = fileName.lastIndexOf("/");
    if (lastIndex == -1)
    {
      return fileName;
    }
    else
    {
      return fileName.substring(lastIndex+1, fileName.length());
    }
  }
}