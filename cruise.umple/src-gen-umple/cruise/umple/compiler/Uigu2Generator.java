/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.exceptions.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import cruise.umple.compiler.uigu2.Uigu2ElementGenerator;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 * @umplesource Generator.ump 272
 * @umplesource Generator_CodeUigu2.ump 146
 */
// line 272 "../../../../src/Generator.ump"
// line 146 "../../../../src/Generator_CodeUigu2.ump"
public class Uigu2Generator extends PhpGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String PACKAGES_FILE_PATH = "/cruise/umple/compiler/uigu2/files/";
  public static final Charset CHARSET = StandardCharsets.UTF_8;
  public static final String NL = System.getProperty("line.separator");

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Uigu2Generator Attributes
  private Uigu2ElementGenerator generator;
  private List<UmpleElement> elements;
  private Path outputPath;
  private Path sharedFilesPath;
  private Map<String,String> sharedFilesToCopy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={176},file={"Generator_CodeUigu2.ump"},javaline={56},length={10})
  public Uigu2Generator()
  {
    super();
    generator = new Uigu2ElementGenerator();
    elements = new ArrayList<UmpleElement>();
    sharedFilesToCopy = new HashMap<String,String>();
    // line 176 "../../../../src/Generator_CodeUigu2.ump"
    this.sharedFilesToCopy.put("kissmvc_core.php", "app/kissmvc_core.php");
        this.sharedFilesToCopy.put("kissmvc_uigu2.php", "app/kissmvc_uigu2.php");
        this.sharedFilesToCopy.put("layout.php", "app/views/layout.php");
        //this.sharedFilesToCopy.put("css_layout.css", "app/views/layout.css");
        this.sharedFilesToCopy.put("views_main_index.php", "app/views/main/index.php");
        this.sharedFilesToCopy.put("views_main_show_element.php", "app/views/main/show_element.php");
        this.sharedFilesToCopy.put("controllers_main_index.php", "app/controllers/main/index.php");
        this.sharedFilesToCopy.put("controllers_main_clear.php", "app/controllers/main/clear.php");
        this.sharedFilesToCopy.put("controllers_main_show_element.php", "app/controllers/main/show_element.php");
        this.sharedFilesToCopy.put("controllers_main_new_instance.php", "app/controllers/main/new_instance.php");
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

  public boolean setSharedFilesPath(Path aSharedFilesPath)
  {
    boolean wasSet = false;
    sharedFilesPath = aSharedFilesPath;
    wasSet = true;
    return wasSet;
  }

  public boolean setSharedFilesToCopy(Map<String,String> aSharedFilesToCopy)
  {
    boolean wasSet = false;
    sharedFilesToCopy = aSharedFilesToCopy;
    wasSet = true;
    return wasSet;
  }

  /**
   * Absolute path where the PhpGenerator will place the domain classes
   */
  public Path getOutputPath()
  {
    return outputPath;
  }

  /**
   * Absolute path to output of uigu files that can be shared among different execution instances (clients).
   * If not provided, all files are placed in the directory specified by outputPath
   */
  public Path getSharedFilesPath()
  {
    return sharedFilesPath;
  }

  /**
   * Default files that can be shared between different clients. Maps filename of files to be copied 
   * (from "cruise.umple.compiler.uigu2.files" package) to its destination pathname and new filename - 
   * relative to sharedFilesPath whenever possible
   */
  public Map<String,String> getSharedFilesToCopy()
  {
    return sharedFilesToCopy;
  }

  public void delete()
  {
    super.delete();
  }


  /**
   * Returns the appropriate path for shared files - the sharedFilesPath when
   * available, or the outputPath when not
   */
  @umplesourcefile(line={345},file={"Generator_CodeUigu2.ump"},javaline={129},length={4})
   public Path getPreferredSharedFilesPath(){
    return this.sharedFilesPath == null ?
      this.outputPath : this.sharedFilesPath;
  }

  @umplesourcefile(line={350},file={"Generator_CodeUigu2.ump"},javaline={140},length={5})
   public void setSharedFilesPath(String pathname){
    if(pathname != null){
      this.sharedFilesPath = Paths.get(pathname).toAbsolutePath();
    }
  }

  @umplesourcefile(line={356},file={"Generator_CodeUigu2.ump"},javaline={147},length={5})
   public void setOutputPath(String pathname){
    if(pathname != null){
      this.outputPath = Paths.get(pathname).toAbsolutePath();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "outputPath" + "=" + (getOutputPath() != null ? !getOutputPath().equals(this)  ? getOutputPath().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sharedFilesPath" + "=" + (getSharedFilesPath() != null ? !getSharedFilesPath().equals(this)  ? getSharedFilesPath().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sharedFilesToCopy" + "=" + (getSharedFilesToCopy() != null ? !getSharedFilesToCopy().equals(this)  ? getSharedFilesToCopy().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={188},file={"Generator_CodeUigu2.ump"},javaline={167},length={146})
  @Override
  @umplesourcefile(line={190},file={"Generator_CodeUigu2.ump"},javaline={169},length={19})
  public void generate () 
  {
    //use default PHP generator to create the domain classes
    super.generate();
    
    this.setOutputPath(super.getModel().getUmpleFile().getPath());
    this.elements = super.getModel().getUmpleElements();

    try {
      this.copySharedFiles();
      this.copyNonSharedFiles();
      this.generateIndexFile();
      this.generateSetupFile();
      this.generateInitializationFile();
      
    } catch (Exception e) {
      throw new UmpleCompilerException("There was a problem with Uigu2 code generation: " + e, e);
    }
  }

//  @umplesourcefile(line={213},file={"Generator_CodeUigu2.ump"},javaline={190},length={124})
  @umplesourcefile(line={214},file={"Generator_CodeUigu2.ump"},javaline={191},length={16})
  private void copySharedFiles () throws IOException 
  {
    Iterator<Map.Entry<String, String>> iterator = this.sharedFilesToCopy.entrySet().iterator();
    String fileName = "";
    Path rootPath = getPreferredSharedFilesPath();
    Path writePath = null;

    while (iterator.hasNext()) {
      Map.Entry<String,String> entry = iterator.next();
      fileName = entry.getKey();
      writePath = rootPath.resolve(Paths.get(entry.getValue()));
      if(!writePath.toFile().exists()){
        copyFileFromPackage(fileName, writePath);
      }
    }
  }

//  @umplesourcefile(line={232},file={"Generator_CodeUigu2.ump"},javaline={209},length={106})
  @umplesourcefile(line={233},file={"Generator_CodeUigu2.ump"},javaline={210},length={5})
  private void copyNonSharedFiles () throws IOException 
  {
    Path writePath = this.outputPath.resolve(Paths.get(".htaccess"));
    copyFileFromPackage("mod_rewrite_file", writePath);
  }

//  @umplesourcefile(line={237},file={"Generator_CodeUigu2.ump"},javaline={217},length={99})
  @umplesourcefile(line={238},file={"Generator_CodeUigu2.ump"},javaline={218},length={7})
  private void copyFileFromPackage (String fileName, Path destinationPath) throws IOException 
  {
    //File is obtained as a Resource from the Classpath, not as Path or File
    InputStream from = this.getClass().getResourceAsStream(this.PACKAGES_FILE_PATH + fileName);
    Files.createDirectories(destinationPath.getParent());
    Files.copy(from, destinationPath, StandardCopyOption.REPLACE_EXISTING);
  }

//  @umplesourcefile(line={247},file={"Generator_CodeUigu2.ump"},javaline={227},length={90})
  @umplesourcefile(line={248},file={"Generator_CodeUigu2.ump"},javaline={228},length={22})
  private void generateIndexFile () throws IOException 
  {
    Path writePath = this.outputPath.resolve(Paths.get("index.php"));
    Path setupFilePath = getPreferredSharedFilesPath().resolve(Paths.get("setup.php")); 

    String indexFile = "<?php" + NL + NL
        + "ini_set('display_errors','On');" + NL
        + "error_reporting(E_ALL);" + NL
        + "require_once('" + setupFilePath + "');" + NL
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
    writeStringToFile(indexFile, writePath);
  }

//  @umplesourcefile(line={272},file={"Generator_CodeUigu2.ump"},javaline={252},length={66})
  @umplesourcefile(line={273},file={"Generator_CodeUigu2.ump"},javaline={253},length={26})
  private void generateSetupFile () throws IOException 
  {
    Path sharedFilesPath = getPreferredSharedFilesPath(); 
    Path writePath = sharedFilesPath.resolve(Paths.get("setup.php"));

    //setup.php carries user configurations and should change - so keep it if present
    if(!writePath.toFile().exists()){
      Path appPath = sharedFilesPath.resolve(Paths.get("app/"));
      String setupFile = "<?php" + NL + NL
          + "/*EDIT BELOW: parent URL of the folder where index.php is located" + NL
          + " *eg. to access 'http://a/b/c/index.php', use 'http://a/b/' (with trailing slash) */" + NL
          + "define('WEB_DOMAIN_ROOT','http://default/');" + NL + NL

          + "/*EDIT BELOW: parent path of the folder where index.php is located," + NL
          + " *relative to the <DocumentRoot> element of the apache config file " + NL
          + " *eg.  if <DocumentRoot> is '/var/www/' and the full path is '/var/www/a/b/index.php'" + NL
          + " *use '/a/' (with trailing slash) */" + NL 
          + "define('WEB_FOLDER_ROOT','/');" + NL + NL

          + "define('APP_PATH','" + appPath.toString() + "/');" + NL
          + "define('VIEW_PATH',APP_PATH.'views/');" + NL
          + "define('CONTROLLER_PATH',APP_PATH.'controllers/');" + NL;

      writeStringToFile(setupFile, writePath);
    }
  }

//  @umplesourcefile(line={301},file={"Generator_CodeUigu2.ump"},javaline={281},length={38})
  @umplesourcefile(line={302},file={"Generator_CodeUigu2.ump"},javaline={282},length={21})
  private void generateInitializationFile () throws IOException 
  {
    //this file is never shared
    Path path = this.outputPath.resolve(Paths.get("initialize_model.php"));

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
    writeStringToFile(initFile.toString(), path);
  }

//  @umplesourcefile(line={326},file={"Generator_CodeUigu2.ump"},javaline={305},length={15})
  @umplesourcefile(line={327},file={"Generator_CodeUigu2.ump"},javaline={306},length={14})
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

  
}