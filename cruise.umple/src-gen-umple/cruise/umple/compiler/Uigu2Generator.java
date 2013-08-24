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

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Uigu2Generator Attributes
  private Uigu2ElementGenerator generator;
  private List<UmpleElement> elements;
  private Path outputPath;
  private Path sharedFilesPath;
  private Map<String,String> sharedFilesToCopy;
  private Map<String,String> filesToGenerate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={130},file={"Generator_CodeUigu2.ump"},javaline={54},length={13})
  public Uigu2Generator()
  {
    super();
    generator = new Uigu2ElementGenerator();
    sharedFilesToCopy = new HashMap<String,String>();
    filesToGenerate = new HashMap<String,String>();
    // line 130 "../../../../src/Generator_CodeUigu2.ump"
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
        this.filesToGenerate.put("index.php", "index.php");
        this.filesToGenerate.put("setup.php", "setup.php");
        this.filesToGenerate.put("initialize_model.php", "initialize_model.php");
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

  public boolean setFilesToGenerate(Map<String,String> aFilesToGenerate)
  {
    boolean wasSet = false;
    filesToGenerate = aFilesToGenerate;
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

  /**
   * Maps filename of files to be dynamically generated
   * to destination pathname and new filename (always relative to outputPath).
   * Different than sharedFilesToCopy, this is used only to facilitate the change of the final output path / filename
   */
  public Map<String,String> getFilesToGenerate()
  {
    return filesToGenerate;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "outputPath" + "=" + (getOutputPath() != null ? !getOutputPath().equals(this)  ? getOutputPath().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sharedFilesPath" + "=" + (getSharedFilesPath() != null ? !getSharedFilesPath().equals(this)  ? getSharedFilesPath().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sharedFilesToCopy" + "=" + (getSharedFilesToCopy() != null ? !getSharedFilesToCopy().equals(this)  ? getSharedFilesToCopy().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "filesToGenerate" + "=" + (getFilesToGenerate() != null ? !getFilesToGenerate().equals(this)  ? getFilesToGenerate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={145},file={"Generator_CodeUigu2.ump"},javaline={162},length={156})
  @Override
  @umplesourcefile(line={147},file={"Generator_CodeUigu2.ump"},javaline={164},length={18})
  public void generate() {
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

  /*
  * Returns the appropriate path for shared files - the sharedFilesPath when
  * available, or the outputPath when not
  */
  @umplesourcefile(line={170},file={"Generator_CodeUigu2.ump"},javaline={188},length={4})
  public Path getPreferredSharedFilesPath(){
    return this.sharedFilesPath == null ?
      this.outputPath : this.sharedFilesPath;
  }

  @umplesourcefile(line={175},file={"Generator_CodeUigu2.ump"},javaline={194},length={5})
  public void setSharedFilesPath(String pathname){
    if(pathname != null){
      this.sharedFilesPath = Paths.get(pathname).toAbsolutePath();
    }
  }

  @umplesourcefile(line={181},file={"Generator_CodeUigu2.ump"},javaline={201},length={5})
  public void setOutputPath(String pathname){
    if(pathname != null){
      this.outputPath = Paths.get(pathname).toAbsolutePath();
    }
  }

  /**
   * Copies default libraries and other necessary files - that are not meant to be
   * modified - to the destination folder, as indicated by the attribute Map sharedFilesToCopy.
   * Files are only copied when they dont already exist in the destination path
   */
  @umplesourcefile(line={192},file={"Generator_CodeUigu2.ump"},javaline={213},length={15})
  private void copySharedFiles() throws IOException{
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

  /**
  * Copies default files that are always put in outputPath Path
  */
  @umplesourcefile(line={211},file={"Generator_CodeUigu2.ump"},javaline={233},length={4})
  private void copyNonSharedFiles() throws IOException{
    //if more default non shared files are needed, create a Map nonSharedFilesToCopy
    copyFileFromPackage("mod_rewrite_file", this.outputPath.resolve(Paths.get(".htaccess"))); 
  }

  @umplesourcefile(line={216},file={"Generator_CodeUigu2.ump"},javaline={239},length={6})
  private void copyFileFromPackage(String fileName, Path destinationPath) throws IOException{
    //File is obtained as a Resource from the Classpath, not as Path or File
    InputStream from = this.getClass().getResourceAsStream(this.packageFilesPath + fileName);
    Files.createDirectories(destinationPath.getParent());
    Files.copy(from, destinationPath);
  }

  /*
  * Generates index.php to outputPath
  */
  @umplesourcefile(line={226},file={"Generator_CodeUigu2.ump"},javaline={250},length={21})
  private void generateIndexFile() throws IOException{
    String nl = System.getProperty("line.separator");
    Path writePath = this.outputPath.resolve(Paths.get(this.filesToGenerate.get("index.php")));
    Path setupFilePath = getPreferredSharedFilesPath().resolve(Paths.get(this.filesToGenerate.get("setup.php"))); 

    StringBuilder indexFile = new StringBuilder();
    indexFile.append("<?php").append(nl);
    indexFile.append("ini_set('display_errors','On');").append(nl);
    indexFile.append("error_reporting(E_ALL);").append(nl);
    indexFile.append("require_once('").append(setupFilePath).append("');").append(nl);
    indexFile.append("define('WEB_DOMAIN', WEB_DOMAIN_ROOT . basename(__DIR__));").append(nl);
    indexFile.append("define('WEB_FOLDER', WEB_FOLDER_ROOT . basename(__DIR__) . '/');").append(nl);
    indexFile.append("require_once(APP_PATH.'kissmvc_uigu2.php');").append(nl);
    indexFile.append("session_start();").append(nl);
    indexFile.append("function __autoload($classname) {").append(nl);
    indexFile.append("$filename = $classname.'.php';").append(nl);
    indexFile.append("if(file_exists($filename)){").append(nl);
    indexFile.append("require_once($classname.'.php');}}").append(nl);
    indexFile.append("new Uigu2_Controller(CONTROLLER_PATH,WEB_FOLDER,'main','index');").append(nl);
    writeStringToFile(indexFile.toString(), writePath);
  }

  @umplesourcefile(line={248},file={"Generator_CodeUigu2.ump"},javaline={273},length={14})
  private void generateSetupFile() throws IOException{
    String nl = System.getProperty("line.separator");
    Path sharedFilesPath = getPreferredSharedFilesPath(); 
    Path writePath = sharedFilesPath.resolve(Paths.get(this.filesToGenerate.get("setup.php")));
    Path appPath = sharedFilesPath.resolve(Paths.get("app/"));
    StringBuilder setupFile = new StringBuilder("<?php").append(nl);

    setupFile.append("define('WEB_DOMAIN_ROOT','http://cruise.local');").append(nl);
    setupFile.append("define('WEB_FOLDER_ROOT','/');").append(nl);
    setupFile.append("define('APP_PATH','").append(appPath.toString()).append("/").append("');").append(nl);
    setupFile.append("define('VIEW_PATH',APP_PATH.'views/');").append(nl);
    setupFile.append("define('CONTROLLER_PATH',APP_PATH.'controllers/');").append(nl);
    writeStringToFile(setupFile.toString(), writePath);
  }

  /*
   * Generates initialize_model.php file with UmpleModel information accessible to all controllers.
   */
  @umplesourcefile(line={266},file={"Generator_CodeUigu2.ump"},javaline={292},length={16})
  private void generateInitializationFile() throws IOException{
    String nl = System.getProperty("line.separator");
    StringBuilder initFile = new StringBuilder("<?php" + nl
            + "function init(){" + nl
            + "$UMPLE_MODEL = array();" + nl);
    //this file is never shared
    Path path = this.outputPath.resolve(Paths.get(this.filesToGenerate.get("initialize_model.php")));

    if (this.elements.size() > 0) { //$ELEMENTS associative array with info from each UmpleElement
      for (UmpleElement e : this.elements) {
        initFile.append(this.generator.getCode(super.getModel(), e));
      }
      initFile.append("$UMPLE_MODEL['ELEMENTS'] = $ELEMENTS;").append(nl);
    }
    
    initFile.append("return $UMPLE_MODEL; }");
    writeStringToFile(initFile.toString(), path);
  }

  /**
   * @param text content of text file to be written
   * @param filePath Absolute path in the FileSystem to file to be written
   */
  @umplesourcefile(line={289},file={"Generator_CodeUigu2.ump"},javaline={316},length={12})
  private void writeStringToFile(String text, Path filePath) throws IOException {
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