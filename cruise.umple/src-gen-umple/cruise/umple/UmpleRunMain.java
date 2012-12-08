/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.builder.*;
import cruise.umple.util.*;
import java.net.*;
import java.io.*;

// line 162 "../../../src/Main_Code.ump"
public class UmpleRunMain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleRunMain()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 172 ../../../src/Main_Code.ump
  public static String console;
    public static boolean displayOutput = true;

    public static void main(String[] args) 
    {
        console = "";

        if (args.length < 2)
        {
            println("Usage: java -jar umplerun.jar <umple_file> <cmd_file>\nExample: java -jar umple.jar airline.ump airline.cmd");
            return;
        }

        String filename = args[0];
        String cmdFilename = args[1];
        UmpleFile umpleFile = new UmpleFile(filename);
        UmpleModel model = new UmpleModel(umpleFile);
        boolean shouldDebug = args.length >= 3 && args[2].equals("--debug");
        boolean shouldCompile = !shouldDebug;

        try
        {
            if (shouldCompile)
            {
                print("Compiling "+ filename +"... ");
                model.run();
                println("success.");
            }
            else
            {
                print("Skipping compilation, entering debug mode");
            }

            print("Building model... ");
            Builder b = new Builder();
            URL jarfile = b.compile(".",umpleFile.getSimpleFileName() + ".jar",umpleFile.getSimpleFileName(),"1.6");

            if (jarfile == null)
            {
                println("failed");
                return;
            }
            println("success.");

            print("Loading model into memory... ");
            URL urls [] = { jarfile };
            URLClassLoader cl = new URLClassLoader(urls);
            println("success.");

            Command cmd = new Command(cl);

            println("Running commands:");
            boolean isFirst = true;
            for (String input : SampleFileWriter.readContent(new File(cmdFilename)).split("\n")) 
            {
                if (isFirst)
                {
                    cmd.addAttributes(input);
                    isFirst = false;
                    continue;
                }
                cmd.exec(input);
                for(String message : cmd.popMessages())
                {
                    println("  " + message);
                }
            }

            println("Done.");
        }
        catch(Exception e)
        {
            println("failed.");
            printerr(e.getMessage());
        }
    }

    private static void print(String output)
    {
        console += output;
        if (displayOutput)
        {
            System.out.print(output);  
        }

    }

    private static void println(String output)
    {
        print(output + "\n");
    }

    private static void printerr(String err)
    {
        console += err;
        if (displayOutput)
        {
            System.err.print(err);
        }
    }
}