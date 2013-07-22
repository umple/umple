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
 * @umplesource Generator.ump 264
 * @umplesource Generator_CodeUigu2.ump 69
 */
// line 264 "../../../../src/Generator.ump"
// line 69 "../../../../src/Generator_CodeUigu2.ump"
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
  private String outputPathname;
  private Map<String,String> filesToCopy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={84},file={"Generator_CodeUigu2.ump"},javaline={52},length={10})
  public Uigu2Generator()
  {
    super();
    generator = new Uigu2ElementGenerator();
    outputPathname = null;
    filesToCopy = new HashMap<String,String>();
    // line 84 "../../../../src/Generator_CodeUigu2.ump"
    this.filesToCopy.put("index.php", "/index.php");
        this.filesToCopy.put("kissmvc_core.php", "/uigu2/kissmvc_core.php");
        this.filesToCopy.put("kissmvc_uigu2.php", "/uigu2/kissmvc_uigu2.php");
        this.filesToCopy.put("layout.php", "/uigu2/views/layout.php");
        this.filesToCopy.put("views_main_index.php", "/uigu2/views/main/index.php");
        this.filesToCopy.put("views_main_show_element.php", "/uigu2/views/main/show_element.php");
        this.filesToCopy.put("controllers_main_index.php", "/uigu2/controllers/main/index.php");
        this.filesToCopy.put("controllers_main_show_element.php", "/uigu2/controllers/main/show_element.php");
        //this.filesToCopy.put("controllers_main_new_instance.php", "/uigu2/controllers/main/new_instance.php");
        this.filesToCopy.put("css_layout.css", "/uigu2/css/layout.css");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOutputPathname(String aOutputPathname)
  {
    boolean wasSet = false;
    outputPathname = aOutputPathname;
    wasSet = true;
    return wasSet;
  }

  public boolean setFilesToCopy(Map<String,String> aFilesToCopy)
  {
    boolean wasSet = false;
    filesToCopy = aFilesToCopy;
    wasSet = true;
    return wasSet;
  }

  public String getOutputPathname()
  {
    return outputPathname;
  }

  /**
   * maps filename of files to be copied (from "cruise.umple.compiler.uigu2.files" package) 
   * to each destination pathname (relative to outputPath) + new filename
   */
  public Map<String,String> getFilesToCopy()
  {
    return filesToCopy;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "outputPathname" + ":" + getOutputPathname()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "filesToCopy" + "=" + (getFilesToCopy() != null ? !getFilesToCopy().equals(this)  ? getFilesToCopy().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={96},file={"Generator_CodeUigu2.ump"},javaline={116},length={72})
  @Override
  @umplesourcefile(line={98},file={"Generator_CodeUigu2.ump"},javaline={118},length={15})
  public void generate() {
    //use default PHP generator to create the domain classes
    super.generate();
    
    this.outputPathname = super.getModel().getUmpleFile().getPath();
    this.elements = super.getModel().getUmpleElements();

    try {
      this.copyDefaultFiles();
      this.generateInitializationFile();
      
    } catch (Exception e) {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }
  }

  /**
   * Copies default libraries and other necessary files - that are not meant to be
   * modified - to the destination folder, as indicated by the attribute Map filesToCopy.
   */
  @umplesourcefile(line={118},file={"Generator_CodeUigu2.ump"},javaline={139},length={11})
  private void copyDefaultFiles() throws IOException{
    Iterator iterator = this.filesToCopy.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = (Map.Entry) iterator.next();
      //File is obtained as a Resource from the Classpath, not as Path or File
      InputStream from = this.getClass().getResourceAsStream(packageFilesPath + entry.getKey());
      Path to = Paths.get(this.outputPathname + entry.getValue());
      Files.createDirectories(to.getParent());
      Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
    }
  }

  /*
   * Generates init.php file with UmpleModel information accessible to all controllers.
   */
  @umplesourcefile(line={133},file={"Generator_CodeUigu2.ump"},javaline={155},length={15})
  private void generateInitializationFile() throws IOException{
    final String nl = System.getProperty("line.separator");
    StringBuilder initFile = new StringBuilder("<?php" + nl
            + "function init(){" + nl
            + "$UMPLE_MODEL = array();" + nl);
    String path = this.outputPathname + "/uigu2/controllers/init.php";

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
   * @param filePathname Absolute path in the FileSystem to file to be written
   */
  @umplesourcefile(line={155},file={"Generator_CodeUigu2.ump"},javaline={178},length={13})
  private void writeStringToFile(String text, String filePathname) throws IOException {
    Path path = Paths.get(filePathname);
    Files.createDirectories(path.getParent());
    BufferedWriter bw = null;
    try {
      bw = Files.newBufferedWriter(path, charset);
      bw.write(text);
    }finally{
      if(bw != null){
        bw.close();
      }
    }
  }

}