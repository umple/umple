/**
 * 
 */
package cruise.umple.mutation.test;
import cruise.umple.mutation.*;
import cruise.umple.util.SampleFileWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

public class MutationTest {
	MutationSuite ms = new MutationSuite(null,0,"","",0);
	String path = "";
	String uFileName = "";
	File aFile = null;
	
	
	
	@Before
	public void setup (){
		
		
		
	}
	
	@Test
	  public void avoidJunitError()
	  {}
	
	///// Association Mutation tests
	
	@Test 
	public void mutateAssociation_OneToManyWithOptionalOneToMany(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
		ms.prepare(path, uFileName,"Java","OptionalOneToMany","OneToMany");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		
		
		
		assertMutatedModelEqualFalse(path+uFileName, path+"0_OneToMany/"+"OneToManyMutation_" +uFileName);
		/*if (assertMutatedModelEqualTrue(path+uFileName, path+"OneToMany/"+"OneToManyMutation_" +uFileName))
		{	
			Assert.fail("generated mutation model is identical to original");
		
		}
		else 
		{
			//some code 
		}*/
		
		
	
	}
	
	
	@Test
	public void mutateAssociation_OneToManyWithOptionalOneToMany_GeneratedFiles(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
	    ms.prepare(path, uFileName,"Java","OptionalOneToMany","OneToMany");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);		
		 SampleFileWriter.assertFileExists(path + "0_OneToMany");
						
	}
	
	@Test
	public void mutateAssociation_OptionalOneToManyWithOneToMany(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
		ms.prepare(path, uFileName,"Java","OneToMany","OptionalOneToMany");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		assertMutatedModelEqualFalse(path+uFileName, path+"0_OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName);
		/*if (assertMutatedModelEqualFalse(path+uFileName, path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName))
		{	
			Assert.fail("New mutation is identical");
		
		}*/
		
		
				
	}
	
	@Test
	public void mutateAssociation_OptionalOneToManyWithOneToMany_GeneratedFiles(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
		ms.prepare(path, uFileName,"Java","OneToMany","OptionalOneToMany");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileExists(path + "0_OptionalOneToMany");	
	}
	
	@Test
	public void mutateAssociation_Directionality(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
		ms.prepare(path, uFileName,"Java","","direction");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		
		assertMutatedModelEqualFalse(path+uFileName, path+"0_direction/"+"directionMutation_" +uFileName);
		/*if (AssertMutatedModel(path+uFileName, path+"AssociationDirectionality/"+"AssociationDirectionalityMutation_" +uFileName))
		{	
			Assert.fail("New mutation is identical");
		
		}*/
		
		//System.out.println(ms.getMutant(0).getMuModel().getUmpleClass("PhoneCall").toString());
		 
						
	}
	
	@Test @Ignore
	public void mutateAssociation_DirectionalityGeneratedFiles(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel.ump";
	     
		ms.prepare(path, uFileName,"Java","","direction");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);		
		 SampleFileWriter.assertFileExists(path + "0_direction");
						
	}
	
	///// Name space and directives
	
	@Test
	public void mutate_namespace(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_namespace.ump";
	     
		ms.prepare(path, uFileName,"Java","","direction");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_namespace_expected.ump.txt"), new File(path + "0_direction/directionMutation_uModel_namespace.ump"), false);
		
		
		 
						
	}
	
	///// Attribute Mutation tests
	@Test
	public void mutate_attributeTyped_intWithFloat(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_int.ump";
	     
		ms.prepare(path, uFileName,"Java","Float","Integer");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_int_expectedFloat.ump.txt"), new File(path + "0_Integer/IntegerMutation_uModel_attributeTyped_int.ump"), false);	 
						
	}
	
	@Test
	public void mutate_attributeTyped_intWithString(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_int.ump";
	     
		ms.prepare(path, uFileName,"Java","String","Integer");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_int_expectedString.ump.txt"), new File(path + "0_Integer/IntegerMutation_uModel_attributeTyped_int.ump"), false);	 
						
	}
	@Test
	public void mutate_attributeTyped_intWithDouble(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_int.ump";
	     
		ms.prepare(path, uFileName,"Java","Double","Integer");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_int_expectedDouble.ump.txt"), new File(path + "0_Integer/IntegerMutation_uModel_attributeTyped_int.ump"), false);	 
						
	}
	
	@Test
	public void mutate_attributeTyped_floatWithDouble(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_float.ump";
	     
		ms.prepare(path, uFileName,"Java","Double","Float");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_float_expectedDouble.ump.txt"), new File(path + "0_Float/FloatMutation_uModel_attributeTyped_float.ump"), false);	 
						
	}
	
	
	@Test
	public void mutate_attributeTyped_floatWithInt(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_float.ump";
	     
		ms.prepare(path, uFileName,"Java","Integer","Float");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_float_expectedInt.ump.txt"), new File(path + "0_Float/FloatMutation_uModel_attributeTyped_float.ump"), false);	 
						
	}
	
	@Test
	public void mutate_attributeTyped_floatWithString(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_float.ump";
	     
		ms.prepare(path, uFileName,"Java","String","Float");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_float_expectedString.ump.txt"), new File(path + "0_Float/FloatMutation_uModel_attributeTyped_float.ump"), false);	 
						
	}
	
	
	@Test
	public void mutate_attributeTyped_stringWithDouble(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_string.ump";
	     
		ms.prepare(path, uFileName,"Java","Double","String");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_string_expectedDouble.ump.txt"), new File(path + "0_String/StringMutation_uModel_attributeTyped_string.ump"), false);	 
						
	}
	
	
	@Test
	public void mutate_attributeTyped_stringWithInt(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_string.ump";
	     
		ms.prepare(path, uFileName,"Java","Integer","String");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_string_expectedInt.ump.txt"), new File(path + "0_String/StringMutation_uModel_attributeTyped_string.ump"), false);	 
						
	}
	
	@Test
	public void mutate_attributeTyped_stringWithFloat(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_attributeTyped_string.ump";
	     
		ms.prepare(path, uFileName,"Java","Float","String");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		SampleFileWriter.assertFileContent(new File(path+"uModel_attributeTyped_string_expectedFloat.ump.txt"), new File(path + "0_String/StringMutation_uModel_attributeTyped_string.ump"), false);	 
						
	}
	
	
	@Test
	public void mutate_AssertMutateModelTest_True(){	
		path = "test/cruise/umple/mutation/test/";
		String model1 = "uModel_mutateAssert_model.ump";
		String model2 = "uModel_mutateAssert_model_identical.ump";		
		String model3 = "uModel_mutateAssert_model_mutated.ump";
		//Assert.assertFalse(assertMutatedModel(path+model1,path+model3));
		Assert.assertTrue("AssertMethod: AssertMutateModell failed! @ identical",assertMutatedModelEqualTrue(path+model1,path+ model2));
						
	}
	@Test
	public void mutate_AssertMutateModelTest_False(){	
		path = "test/cruise/umple/mutation/test/";
		String model1 = "uModel_mutateAssert_model.ump";
		String model2 = "uModel_mutateAssert_model_identical.ump";		
		String model3 = "uModel_mutateAssert_model_mutated.ump";
		//Assert.assertFalse(assertMutatedModel(path+model1,path+model3));
		Assert.assertTrue("AssertMethod: AssertMutateModell failed @ mutated!",assertMutatedModelEqualFalse(path+model1,path+model3));
						
	}
	
	
	@Test @Ignore
	public void mutate_constraint(){
	    path = "test/cruise/umple/mutation/test/";
	    uFileName = "uModel_mutateConstraint.ump";
	     
		ms.prepare(path, uFileName,"Java","<","ConstraintBiggerEq");
	    
		//SampleFileWriter.assertFileContent(new File(path+uFileName),new File (path+"OptionalOneToMany/"+"OptionalOneToManyMutation_" +uFileName), true);
		//SampleFileWriter.assertFileContent(new File(path+"uModel_mutateConstraint.ump.txt"), new File(path + "ConstraintsBiggerEqMutation_uModel_mutateConstraint.ump"), false);	 
						
	}
	
	
	
	/// use model Files
	
	@Test
	public void mutate_useFiles(){	
		path = "test/cruise/umple/mutation/test/";
		String model1 = "uModel_useFiles.ump";
		//String model2 = "uModel_mutateAssert_model_identical.ump";		
		//String model3 = "uModel_mutateAssert_model_mutated.ump";
		//Assert.assertFalse(assertMutatedModel(path+model1,path+model3));
		//Assert.assertTrue("AssertMethod: AssertMutateModell failed! @ identical",assertMutatedModelEqualTrue(path+model1,path+ model2));
		//Assert.assertTrue("AssertMethod: AssertMutateModell failed @ mutated!",assertMutatedModelEqualFalse(path+model1,path+model3));
		ms.prepare(path, model1, "Java", "", "direction");
	}
	
	
	////// Regex testing for several cases 
	
	
	
	////// Test for the paper 
	
	@Test
	public void mutate_telephoneSystem(){	
		path = "test/cruise/umple/mutation/test/";
		String model1 = "uModel_telephone.ump";
		//String model2 = "uModel_mutateAssert_model_identical.ump";		
		//String model3 = "uModel_mutateAssert_model_mutated.ump";
		//Assert.assertFalse(assertMutatedModel(path+model1,path+model3));
		//Assert.assertTrue("AssertMethod: AssertMutateModell failed! @ identical",assertMutatedModelEqualTrue(path+model1,path+ model2));
		//Assert.assertTrue("AssertMethod: AssertMutateModell failed @ mutated!",assertMutatedModelEqualFalse(path+model1,path+model3));
		ms.prepare(path, model1, "Java", "random", "random");
	}
	
	
	///Utilities 
	
	public Boolean assertMutatedModelEqualTrue (String file1, String file2)
	
	{   
		String modelCode1="";
		String modelCode2= "";
		
		
		System.out.println(file1);
		BufferedReader br1 = null;
		try {
			br1 = new BufferedReader(new FileReader(file1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   String line = null;
		   
		   try {
			while ((line = br1.readLine()) != null) {
			     //System.out.println(line);
			     modelCode1 += line+"\n";			     
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println(file2);
		   
		   BufferedReader br2 = null;
			try {
				br2 = new BufferedReader(new FileReader(file2));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   line = null;
			   
			   try {
				while ((line = br2.readLine()) != null) {
				     //System.out.println(line);
				     modelCode2 += line+"\n";			     
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
			   
			   Assert.assertTrue(modelCode1.equals(modelCode2));
			   /*if( modelCode1.equals(modelCode2))
			   {
				   //Assert.assertTrue(condition);
				   return true;
			   }*/
		return true;
		
	}
	
	
public Boolean assertMutatedModelEqualFalse (String file1, String file2)
	
	{   
		String modelCode1="";
		String modelCode2= "";
		
		
		System.out.println(file1);
		BufferedReader br1 = null;
		try {
			br1 = new BufferedReader(new FileReader(file1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   String line = null;
		   
		   try {
			while ((line = br1.readLine()) != null) {
			     //System.out.println(line);
			     modelCode1 += line+"\n";			     
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println(file2);
		   
		   BufferedReader br2 = null;
			try {
				br2 = new BufferedReader(new FileReader(file2));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   line = null;
			   
			   try {
				while ((line = br2.readLine()) != null) {
				     //System.out.println(line);
				     modelCode2 += line+"\n";			     
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
			   
			   
			   Assert.assertFalse(modelCode1.equals(modelCode2));
			   /*if( modelCode1.equals(modelCode2))
			   {
				   return false;
			   }*/
		return true;
		
	}
	
	@After
	public void teardown() {
		path = "test/cruise/umple/mutation/test/";
		//System.out.println(path + "cruise/umple/mutation/test/mutation/Direction/Feature.java");
		SampleFileWriter.destroy(path + "AssociationDirectionality");
		SampleFileWriter.destroy(path + "OneToMany");
		SampleFileWriter.destroy(path + "OneToOptionalOne");
		SampleFileWriter.destroy(path + "OptionalOneToMany");
		SampleFileWriter.destroy(path + "OneToNN_aboveLowerBound");
		SampleFileWriter.destroy(path + "OneToNN_belowUpperBound");
		SampleFileWriter.destroy(path + "OneToNN_belowLowerBound");
		SampleFileWriter.destroy(path + "OneToNN_aboveUpperBound");
		SampleFileWriter.destroy(path + "TypedAttributeFloat");
	    SampleFileWriter.destroy(path + "TypedAttributeString");
		SampleFileWriter.destroy(path + "TypedAttributeInteger");
		SampleFileWriter.destroy(path + "TypedAttributeDouble");
		SampleFileWriter.destroy(path + "ConstraintsBiggerEq");
		
		
		
	}
	

}
