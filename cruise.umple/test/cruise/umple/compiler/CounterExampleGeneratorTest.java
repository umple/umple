package cruise.umple.compiler;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cruise.umple.nusmv.*;

public class CounterExampleGeneratorTest {

			List< CounterExampleColumn > myColumns; 
			String sourceMachine = "";
			List< String > header;
			String name = "";
			String machineAbsoluteName = "";
			
		  @Before
		  public void setUp()
		  {
		  		header = new ArrayList< String >();
		  		myColumns = builderFactory(  );
		  		if( header.size() != 0 )
		  				name = header.get(0);
					sourceMachine = getName( name, '.', 0 );
					machineAbsoluteName = getName(getName( name, '.', 0 ), '.',1);
		  }
		  
		  private CTLSpecification composeRequirement(){
		  		BasicExpression bexp1 = new BasicExpression(sourceMachine+".state");
	    		BasicExpression bexp2 = new BasicExpression(sourceMachine+"_s2");
	    		CTLExpression expression = new CTLExpression("ctl");
	    		expression.addChild(bexp1);
	    		expression.addChild(bexp2);
	    		expression.setOperator(BasicExpression.Operator.EQ);
	    		expression.setBracketed(true);
	    		expression.setQualified(true);
	    		expression.setCtlOperator(CTLExpression.CtlOperator.EF);
	    		return new CTLSpecification( expression );
		  }
		  
		  private CounterExampleTable composeTable(List< CounterExampleColumn > columns) {
		  		
		  		CTLSpecification aRequirement = composeRequirement();
		  		CounterExampleTable table = new CounterExampleTable(machineAbsoluteName, aRequirement);
		  		for( CounterExampleColumn column : columns )
		  				table.addCounterExampleColumn( column );
		 
		  		table.setRowLabels(header);
		  		
		  		return table;
		  }
		  
		  //returns the first occurrence of delimiter from the rear
		  private int getPosOfDelimeter( String input , char delimiter){
		  	 int length = input.length() ;
		  	 
		  		while( length > 1) {
		  				if( input.charAt( length - 1 ) == delimiter)
		  						return length;
		  				length--;
		  		}	
				return -1;
		  }
		  
		  private String getName( String input, char delimiter, int direction ) {
		  		if(input.length() > 2)
		  				if( direction == 0)
		  						return input.substring(0, getPosOfDelimeter(input,delimiter) -1);
		  				if( direction == 1)
		  						return input.substring(getPosOfDelimeter(input,delimiter), input.length() );
		  		return "";
		  }
		  
		 @SuppressWarnings("static-access")
		 private List< CounterExampleColumn > builderFactory() {
				List< CounterExampleColumn > maincolumns = new ArrayList< CounterExampleColumn >(); 
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

					String pathToInput = "test/cruise/umple/compiler/";
					try {
						DocumentBuilder builder = factory.newDocumentBuilder();
						try {
								Document doc = builder.parse(pathToInput + "outputV2");
								NodeList stateList = doc.getElementsByTagName("state");
								
								for(int i = 0; i < stateList.getLength(); i++ ) {
										Node s = stateList.item(i);
										if( s.getNodeType() == s.ELEMENT_NODE ) {
												
												Element state = (Element) s;
												List< String > stateValues = new ArrayList< String >();
												NodeList attributeList = state.getChildNodes();
												for(int j = 0; j < attributeList.getLength(); j++) {
																													
														Node a = attributeList.item( j );
														if(a.getNodeType()==Node.ELEMENT_NODE) {
														
																Element value = (Element) a;
																stateValues.add( value.getTextContent() );
																if(i == 0)
																		header.add( value.getAttribute("variable") );
														}			
												}
												Integer id = Integer.parseInt(state.getAttribute("id")) ;
												CounterExampleColumn column = new CounterExampleColumn(  id , "State "+id );
												column.setStateValues( stateValues );
												maincolumns.add( column );
										}
								}
						} catch (SAXException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
				} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					return maincolumns;
				}

	    @Test
		  public void validateColumn()
		  {
	    		if(myColumns.size() > 0)
	    				Assert.assertEquals(3, myColumns.size());
	    		for(int i = 0; i < myColumns.size(); i++) {
	    				Assert.assertEquals(i+1, myColumns.get(i).getIndex());
	    				if( i == 0)
	    						Assert.assertEquals("State 1 :: Sm_s1 , ev_null , 4 , 5 , FALSE , TRUE , FALSE , FALSE , TRUE", myColumns.get(0).toString());
	    				if( i == 1)
	    						Assert.assertEquals("State 2 :: Sm_s1 , ev_e , 63 , 69 , FALSE , TRUE , FALSE , TRUE , FALSE", myColumns.get(1).toString());
	    				if( i== 2)
	    						Assert.assertEquals("State 3 :: Sm_s2 , ev_null , 0 , 0 , TRUE , FALSE , FALSE , FALSE , TRUE", myColumns.get(2).toString());
		    }
		  }
		  
		  @Test
		  public void validateTable()
		  {	
		  		myColumns = builderFactory();
					CounterExampleTable table = composeTable( myColumns ) ;
		  		System.out.println(table.toString());
	  		  
		  		CounterExampleTable myTable = table.editTable();
	  			System.out.println(myTable.toString());	
	  		}
}
