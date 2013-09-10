/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.exceptions.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import cruise.umple.compiler.uigu2.Uigu2ElementGenerator;

/**
 * @umplesource Generator.ump 257
 * @umplesource Generator_CodeUigu2.ump 98
 */
// line 257 "../../../../src/Generator.ump"
// line 98 "../../../../src/Generator_CodeUigu2.ump"
public class Uigu2Generator extends PhpGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String packageFilesPath = "/cruise/umple/compiler/uigu2/files/";
  public static final Charset charset = StandardCharsets.UTF_8;
  public static final String nl = System.getProperty("line.separator");

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

  @umplesourcefile(line={126},file={"Generator_CodeUigu2.ump"},javaline={53},length={10})
  public Uigu2Generator()
  {
    super();
    generator = new Uigu2ElementGenerator();
    sharedFilesToCopy = new HashMap<String,String>();
    // line 126 "../../../../src/Generator_CodeUigu2.ump"
    this.sharedFilesToCopy.put("kissmvc_core.php", "app/kissmvc_core.php");
        this.sharedFilesToCopy.put("kissmvc_uigu2.php", "app/kissmvc_uigu2.php");
        this.sharedFilesToCopy.put("layout.php", "app/views/layout.php");
        this.sharedFilesToCopy.put("views_main_index.php", "app/views/main/index.php");
        this.sharedFilesToCopy.put("views_main_show_element.php", "app/views/main/show_element.php");
        this.sharedFilesToCopy.put("controllers_main_index.php", "app/controllers/main/index.php");
        this.sharedFilesToCopy.put("controllers_main_clear.php", "app/controllers/main/clear.php");
        this.sharedFilesToCopy.put("controllers_main_show_element.php", "app/controllers/main/show_element.php");
        this.sharedFilesToCopy.put("controllers_main_new_instance.php", "app/controllers/main/new_instance.php");
        this.sharedFilesToCopy.put("css_layout.css", "app/css/layout.css");
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
  @umplesourcefile(line={291},file={"Generator_CodeUigu2.ump"},javaline={126},length={4})
   public Path getPreferredSharedFilesPath(){
    return this.sharedFilesPath == null ?
      this.outputPath : this.sharedFilesPath;
  }

  @umplesourcefile(line={296},file={"Generator_CodeUigu2.ump"},javaline={137},length={5})
   public void setSharedFilesPath(String pathname){
    if(pathname != null){
      this.sharedFilesPath = Paths.get(pathname).toAbsolutePath();
    }
  }

  @umplesourcefile(line={302},file={"Generator_CodeUigu2.ump"},javaline={144},length={5})
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
  //  @umplesourcefile(line={138},file={"Generator_CodeUigu2.ump"},javaline={164},length={140})
  @Override public void generate() 
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

//  @umplesourcefile(line={164},file={"Generator_CodeUigu2.ump"},javaline={185},length={119})
  @umplesourcefile(line={165},file={"Generator_CodeUigu2.ump"},javaline={186},length={16})
  private void copySharedFiles() throws IOException 
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

//  @umplesourcefile(line={183},file={"Generator_CodeUigu2.ump"},javaline={204},length={101})
  @umplesourcefile(line={184},file={"Generator_CodeUigu2.ump"},javaline={205},length={5})
  private void copyNonSharedFiles() throws IOException 
  {
    //if more default non shared files are needed, create a Map nonSharedFilesToCopy
    copyFileFromPackage("mod_rewrite_file", this.outputPath.resolve(Paths.get(".htaccess")));
  }

//  @umplesourcefile(line={188},file={"Generator_CodeUigu2.ump"},javaline={212},length={94})
  @umplesourcefile(line={189},file={"Generator_CodeUigu2.ump"},javaline={213},length={7})
  private void copyFileFromPackage(String fileName, Path destinationPath) throws IOException 
  {
    //File is obtained as a Resource from the Classpath, not as Path or File
    InputStream from = this.getClass().getResourceAsStream(this.packageFilesPath + fileName);
    Files.createDirectories(destinationPath.getParent());
    Files.copy(from, destinationPath);
  }

//  @umplesourcefile(line={198},file={"Generator_CodeUigu2.ump"},javaline={222},length={85})
  @umplesourcefile(line={199},file={"Generator_CodeUigu2.ump"},javaline={223},length={22})
  private void generateIndexFile() throws IOException 
  {
    Path writePath = this.outputPath.resolve(Paths.get("index.php"));
    Path setupFilePath = getPreferredSharedFilesPath().resolve(Paths.get("setup.php")); 

    String indexFile = "<?php" + nl + nl
        + "ini_set('display_errors','On');" + nl
        + "error_reporting(E_ALL);" + nl
        + "require_once('" + setupFilePath + "');" + nl
        + "define('WEB_DOMAIN', WEB_DOMAIN_ROOT . basename(__DIR__));" + nl
        + "define('WEB_FOLDER', WEB_FOLDER_ROOT . basename(__DIR__) . '/');" + nl
        + "require_once(APP_PATH.'kissmvc_uigu2.php');" + nl
        + "session_start();" + nl + nl
        + "function __autoload($classname) {" + nl
        + "\t$filename = $classname.'.php';" + nl
        + "\tif(file_exists($filename)){" + nl
        + "\t\trequire_once($classname.'.php');" + nl
        + "\t}" + nl
        + "}" + nl
        + "new Uigu2_Controller(CONTROLLER_PATH,WEB_FOLDER,'main','index');";
    writeStringToFile(indexFile, writePath);
  }

//  @umplesourcefile(line={223},file={"Generator_CodeUigu2.ump"},javaline={247},length={61})
  @umplesourcefile(line={224},file={"Generator_CodeUigu2.ump"},javaline={248},length={22})
  private void generateSetupFile() throws IOException 
  {
    String nl = System.getProperty("line.separator");
    Path sharedFilesPath = getPreferredSharedFilesPath(); 
    Path writePath = sharedFilesPath.resolve(Paths.get("setup.php"));
    Path appPath = sharedFilesPath.resolve(Paths.get("app/"));

    String setupFile = "<?php" + nl + nl
        + "/*EDIT BELOW: parent URL of the folder where index.php is located" + nl
        + " *eg. to access 'http://a/b/c/index.php', use 'http://a/b/' (with trailing slash) */" + nl
        + "define('WEB_DOMAIN_ROOT','http://default/');" + nl + nl
        + "/*EDIT BELOW: parent path of the folder where index.php is located," + nl
        + " *relative to the <DocumentRoot> element of the apache config file " + nl
        + " *eg.  if <DocumentRoot> is '/var/www/' and the full path is '/var/www/a/b/index.php'" + nl
        + " *use '/a/' (with trailing slash) */" + nl 
        + "define('WEB_FOLDER_ROOT','/');" + nl + nl
        + "define('APP_PATH','" + appPath.toString() + "/');" + nl
        + "define('VIEW_PATH',APP_PATH.'views/');" + nl
        + "define('CONTROLLER_PATH',APP_PATH.'controllers/');" + nl;

    writeStringToFile(setupFile, writePath);
  }

//  @umplesourcefile(line={248},file={"Generator_CodeUigu2.ump"},javaline={272},length={37})
  @umplesourcefile(line={249},file={"Generator_CodeUigu2.ump"},javaline={273},length={21})
  private void generateInitializationFile() throws IOException 
  {
    //this file is never shared
    Path path = this.outputPath.resolve(Paths.get("initialize_model.php"));

    StringBuilder initFile = new StringBuilder("<?php" + nl + nl
            + "function initialize_model(){" + nl
            + "$UMPLE_MODEL = array();" + nl
            + "$UMPLE_MODEL['execution_id'] = basename(__DIR__);" + nl);

    //$ELEMENTS associative array with info from each UmpleElement
    if (this.elements.size() > 0) {       
      for (UmpleElement e : this.elements) {
        initFile.append(this.generator.getCode(super.getModel(), e));
      }
      initFile.append("$UMPLE_MODEL['ELEMENTS'] = $ELEMENTS;").append(nl);
    }
    
    initFile.append("return $UMPLE_MODEL;").append(nl).append("}");
    writeStringToFile(initFile.toString(), path);
  }

//  @umplesourcefile(line={273},file={"Generator_CodeUigu2.ump"},javaline={296},length={14})
  @umplesourcefile(line={274},file={"Generator_CodeUigu2.ump"},javaline={297},length={13})
  private void writeStringToFile(String text, Path filePath) throws IOException 
  {
    Files.createDirectories(filePath.getParent());
    BufferedWriter bw = null;
    try {
      bw = Files.newBufferedWriter(filePath, charset);
      bw.write(text);
    }finally{
      if(bw != null){
        bw.close();
      }
    }
  }

}