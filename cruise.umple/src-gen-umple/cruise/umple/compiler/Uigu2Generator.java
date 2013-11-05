/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.uigu2.*;
import java.util.*;

/**
 * @umplesource Generator.ump 272
 * @umplesource Generator_CodeUigu2.ump 11
 */
// line 272 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeUigu2.ump"
public class Uigu2Generator extends PhpGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final Charset CHARSET = StandardCharsets.UTF_8;
  public static final String NL = System.getProperty("line.separator");

  /**
   * Pathname to setup.php file, relative to outputPath
   * We'll only know outputPath at execution time, so leave it as a String pathname
   */
  public static final String SETUP_RELATIVE_PATHNAME = "../../scripts/uigu2/setup.php";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Uigu2Generator Attributes
  private Uigu2ElementGenerator generator;
  private List<UmpleElement> elements;
  private Path outputPath;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Uigu2Generator()
  {
    super();
    generator = new Uigu2ElementGenerator();
    elements = new ArrayList<UmpleElement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOutputPath(Path aOutputPath)
  {
    boolean wasSet = false;
    outputPath = aOutputPath;
    wasSet = true;
    return wasSet;
  }

  /**
   * Path to where the PhpGenerator will place the domain classes
   */
  public Path getOutputPath()
  {
    return outputPath;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={127},file={"Generator_CodeUigu2.ump"},javaline={83},length={5})
   private void setOutputPath(String pathname){
    if(pathname != null){
      this.outputPath = Paths.get(pathname).toAbsolutePath();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "outputPath" + "=" + (getOutputPath() != null ? !getOutputPath().equals(this)  ? getOutputPath().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={31},file={"Generator_CodeUigu2.ump"},javaline={101},length={101})
  @Override
  @umplesourcefile(line={33},file={"Generator_CodeUigu2.ump"},javaline={103},length={18})
  public void generate () 
  {
    //use default PHP generator to create the domain classes
    super.generate();

    this.setOutputPath(super.getModel().getUmpleFile().getPath());
    this.elements = super.getModel().getUmpleElements();

    try {
      this.assertSetupFileExistent();
      this.generateInitializationFile();
      this.generateIndexFile();
      this.generateModRewriteFile();
      
    } catch (Exception e) {
      throw new UmpleCompilerException("There was a problem with Uigu2 code generation: " + e.getMessage(), e);
    }
  }

//  @umplesourcefile(line={53},file={"Generator_CodeUigu2.ump"},javaline={123},length={80})
  @umplesourcefile(line={54},file={"Generator_CodeUigu2.ump"},javaline={124},length={18})
  private void generateInitializationFile () throws IOException 
  {
    StringBuilder initFile = new StringBuilder("<?php" + NL + NL
            + "function initialize_model(){" + NL
            + "$UMPLE_MODEL = array();" + NL
            + "$UMPLE_MODEL['execution_id'] = '_'.basename(dirname(__FILE__));" + NL);

    //$ELEMENTS associative array with info from each UmpleElement
    if (this.elements.size() > 0) {
      for (UmpleElement e : this.elements) {
        initFile.append(this.generator.getCode(super.getModel(), e));
      }
      initFile.append("$UMPLE_MODEL['ELEMENTS'] = $ELEMENTS;").append(NL);
    }
    initFile.append("return $UMPLE_MODEL;").append(NL).append("}");
    Path path = this.outputPath.resolve(Paths.get("initialize_model.php"));
    writeStringToFile(initFile.toString(), path);
  }

//  @umplesourcefile(line={74},file={"Generator_CodeUigu2.ump"},javaline={144},length={60})
  @umplesourcefile(line={75},file={"Generator_CodeUigu2.ump"},javaline={145},length={20})
  private void generateIndexFile () throws IOException 
  {
    String indexFile = "<?php" + NL + NL
        + "ini_set('display_errors','On');" + NL
        + "error_reporting(E_ALL);" + NL
        + "require_once('" + SETUP_RELATIVE_PATHNAME + "');" + NL
        + "define('WEB_DOMAIN', WEB_DOMAIN_ROOT . basename(dirname(__FILE__)));" + NL
        + "define('WEB_FOLDER', WEB_FOLDER_ROOT . basename(dirname(__FILE__)) . '/');" + NL
        + "require_once(APP_PATH.'kissmvc_uigu2.php');" + NL
        + "session_start();" + NL + NL
        + "function __autoload($classname) {" + NL
        + "\t$filename = $classname.'.php';" + NL
        + "\tif(file_exists($filename)){" + NL
        + "\t\trequire_once($classname.'.php');" + NL
        + "\t}" + NL
        + "}" + NL
        + "new Uigu2_Controller('main','index');";
    Path writePath = this.outputPath.resolve(Paths.get("index.php"));
    writeStringToFile(indexFile, writePath);
  }

//  @umplesourcefile(line={97},file={"Generator_CodeUigu2.ump"},javaline={167},length={38})
  @umplesourcefile(line={98},file={"Generator_CodeUigu2.ump"},javaline={168},length={11})
  private void generateModRewriteFile () throws IOException 
  {
    String mrFile = "RewriteEngine ON" + NL
      + "RewriteCond %{REQUEST_FILENAME} !-f" + NL
      + "RewriteCond %{REQUEST_FILENAME} !-d" + NL
      + "RewriteCond %{REQUEST_URI} !^/(index\\.php|images|css|js|robots\\.txt|favicon\\.ico)" + NL
      + "RewriteRule ^(.*)$ index.php/$1 [L]" + NL
      + "Options -Indexes";
    Path writePath = this.outputPath.resolve(Paths.get(".htaccess"));
    writeStringToFile(mrFile, writePath);
  }

//  @umplesourcefile(line={112},file={"Generator_CodeUigu2.ump"},javaline={181},length={25})
  @umplesourcefile(line={113},file={"Generator_CodeUigu2.ump"},javaline={182},length={14})
  private void writeStringToFile (String text, Path filePath) throws IOException 
  {
    Files.createDirectories(filePath.getParent());
    BufferedWriter bw = null;
    try {
      //Replaces existing files
      bw = Files.newBufferedWriter(filePath, CHARSET);
      bw.write(text);
    }finally{
      if(bw != null){
        bw.close();
      }
    }
  }

//  @umplesourcefile(line={136},file={"Generator_CodeUigu2.ump"},javaline={198},length={9})
  @umplesourcefile(line={137},file={"Generator_CodeUigu2.ump"},javaline={199},length={8})
  private void assertSetupFileExistent () throws Exception 
  {
    try{
      this.outputPath.resolve(Paths.get(SETUP_RELATIVE_PATHNAME)).toRealPath();
    }catch(NoSuchFileException e){
      throw new Exception("setup.php file not found, make sure the .ump input file is inside /umpleonline/ump/folder/",e);
    }
  }

  
}