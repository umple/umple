/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple;
import cruise.umple.sync.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.util.*;
import java.io.*;

/**
 * Main program for umplesync.jar which is used by umpleonline
 * when it wants to send changes to the diagram and have them applied to
 * the text and vice versa
 * 
 * TODO: Code smell - rename?
 * @umplesource Main_Code.ump 297
 */
// line 297 "../../../src/Main_Code.ump"
public class PlaygroundMain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlaygroundMain()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 305 ../../../src/Main_Code.ump
  public static String console = "";

    public static void main(String[] args)
    {
        console = "";
        String answer = "";

        if (args.length == 0)
        {
            print("Invalid format, please try again specifying:\n");
            print("-classList <filename>\n");
            print("-interfaceList <filename>\n");
            print("-source <filename>\n");
            print("-generate <Ecore|Papyrus|TextUml|GvStateDiagram|GvClassDiagram|Violet|Umlet> <filename>\n");
            print("<action> <deltaCode> <filename>\n");
            return;
        }

        if (args.length >= 3 && !"-generate".equals(args[0]))
        {
            String actionType = args[0];
            String deltaCode = args[1];
            String filename = args[2];
            String umpleCode = SampleFileWriter.readContent(new File(filename));

            SynchronizationAction action = action(actionType,deltaCode,umpleCode);
            if (action != null)
            {
                action.go();
                print(action.getUmpleCode());
                return;
            }
        }

        UmpleFile umpleFile = null;
        UmpleModel model = null;

        // Valid values include Json, Yuml, Xmi, Ecore, Papyrus, TextUml,
        // GvStateDiagram, GvClassDiagram
        if ("-generate".equals(args[0]) && args.length >= 2)
        {
            String filename = args[2];
            GenerateTarget target = new GenerateTarget(args[1], ""); // output path goes here
            umpleFile = new UmpleFile(filename);
            model = new UmpleModel(umpleFile);
            target.setOverrideAll(true);
            model.addGenerate(target);
        }
        else
        {
            String filename = args[1];
            umpleFile = new UmpleFile(filename);
            model = new UmpleModel(umpleFile);
        }

        try
        {
            model.run();
        }
        catch(UmpleCompilerException e)
        {
            System.err.print(model.getLastResult().toJSON());
        }

        if ("-classList".equals(args[0]))
        {
            for (UmpleClass aClass : model.getUmpleClasses())
            {
                if (answer.length() > 0)
                {
                    answer += ",";
                }
                answer += aClass.getName();
            }
        }
        if ("-interfaceList".equals(args[0]))
        {
            for (UmpleInterface aInterface : model.getUmpleInterfaces())
            {
                if (answer.length() > 0)
                {
                    answer += ",";
                }
                answer += aInterface.getName();
            }
        }
        else if ("-source".equals(args[0]))
        {
            for (String generatedCode : model.getGeneratedCode().values())
            {
                if (answer.length() > 0)
                {
                    answer += "\n\n\n\n";
                }
                answer += generatedCode;
            }
        }
        else if ("-generate".equals(args[0]))
        {
            answer = model.getCode();
        }

        print(answer);
    }

    private static void print(String output)
    {
        console += output;
        System.out.print(output);
    }

    private static SynchronizationAction action(String type, String deltaCode, String umpleCode)
    {
        if ("-addClass".equals(type))
        {
            return new NewAction(deltaCode,umpleCode);
        }
        else if ("-addInterface".equals(type))
        {
            return new NewAction(deltaCode,umpleCode);
        }
        else if ("-removeClass".equals(type))
        {
            return new DeleteAction(deltaCode,umpleCode);
        }
        else if ("-editClass".equals(type))
        {
            return new EditAction(deltaCode,umpleCode);
        }
        else if ("-removeInterface".equals(type))
        {
            return new DeleteAction(deltaCode,umpleCode);
        }
        else if ("-editInterface".equals(type))
        {
            return new EditAction(deltaCode,umpleCode);
        }
        else if ("-addAssociation".equals(type))
        {
            return new NewAssociationAction(deltaCode,umpleCode);
        }
        else if ("-editAssociation".equals(type))
        {
            return new EditAssociationAction(deltaCode,umpleCode);
        }
        else if ("-removeAssociation".equals(type))
        {
            return new DeleteAssociationAction(deltaCode,umpleCode);
        }
        else if ("-addGeneralization".equals(type))
        {
            return new NewGeneralizationAction(deltaCode,umpleCode);
        }
        else if ("-removeGeneralization".equals(type))
        {
            return new DeleteGeneralizationAction(deltaCode,umpleCode);
        }
        else if ("-addPositioning".equals(type))
        {
            return new UpdatePositioningAction(deltaCode,umpleCode);
        }
        else
        {
            return null;
        }
    }
}