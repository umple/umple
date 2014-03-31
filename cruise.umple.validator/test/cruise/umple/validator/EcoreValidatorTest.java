package cruise.umple.validator;

import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Assert;
import org.junit.Test;

public class EcoreValidatorTest{
  
  private final String rootPath = "../cruise.umple.validator/test/cruise/umple/validator/";
  
  @Test
  public void validateString(){
    String validString = null;
    String invalidString = null;
    
    try{
      validString = new String(Files.readAllBytes(FileSystems.getDefault().getPath(rootPath, "EcoreValidatorTest_valid.ecore")));
      invalidString = new String(Files.readAllBytes(FileSystems.getDefault().getPath(rootPath, "EcoreValidatorTest_invalid.ecore")));
    }catch(Exception e){
      Assert.fail("Files for the test cannot be read");
    }
    
    /* Valid */
    Assert.assertTrue(UmpleEcoreValidator.getInstance().validate(validString));
    
    /* Invalid */
    Assert.assertFalse(UmpleEcoreValidator.getInstance().validate(invalidString));
    
    /* Null String */
    Assert.assertFalse(UmpleEcoreValidator.getInstance().validate((String)null));
    
    /* Non-XML String */
    Assert.assertFalse(UmpleEcoreValidator.getInstance().validate("Non-XML String"));
  }
  
  @Test
  public void validateFile(){
    URI validUri = URI.createURI(rootPath + "EcoreValidatorTest_valid.ecore");
    URI invalidUri = URI.createURI(rootPath + "EcoreValidatorTest_invalid.ecore");
    URI nonExistUri = URI.createURI("File_NonExist.ecore");
        
    /* Valid */
    try{
      Assert.assertTrue(UmpleEcoreValidator.getInstance().validate(validUri));
    }catch (Exception e){
      Assert.fail();
    }
    
    /* Invalid */
    try{
      Assert.assertFalse(UmpleEcoreValidator.getInstance().validate(invalidUri));
    }catch (Exception e){
      Assert.fail();
    }
    
    /* File not exist */
    try{
      UmpleEcoreValidator.getInstance().validate(nonExistUri);
      Assert.fail();
    }catch (FileNotFoundException e){
      
    }catch (Exception e){
      Assert.fail();
    }
  }
  
  @Test
  public void validateResource(){
    /* Resource null */
    Assert.assertFalse(UmpleEcoreValidator.getInstance().validate((Resource)null));
  }
  
  @Test
  public void validatePath(){
    Path validPath = FileSystems.getDefault().getPath(rootPath, "EcoreValidatorTest_valid.ecore");
    Path invalidPath = FileSystems.getDefault().getPath(rootPath, "EcoreValidatorTest_invalid.ecore");
    Path nonExistPath = FileSystems.getDefault().getPath(rootPath, "File_NonExist.ecore");
        
    /* Valid */
    try{
      Assert.assertTrue(UmpleEcoreValidator.getInstance().validate(validPath));
    }catch (Exception e){
      Assert.fail();
    }
    
    /* Invalid */
    try{
      Assert.assertFalse(UmpleEcoreValidator.getInstance().validate(invalidPath));
    }catch (Exception e){
      Assert.fail();
    }
    
    /* File not exist */
    try{
      UmpleEcoreValidator.getInstance().validate(nonExistPath);
      Assert.fail();
    }catch (FileNotFoundException e){
      
    }catch (Exception e){
      Assert.fail();
    }
  }
}
