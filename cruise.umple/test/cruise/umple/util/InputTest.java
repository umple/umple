package cruise.umple.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.Input;

public class InputTest {

  Input input;
  ByteArrayInputStream stream;
  PrintStream output;
  
  @Before
  public void setUp()
  {
    OutputStream bytes = new ByteArrayOutputStream();
    output = new PrintStream(bytes);
    stream = new ByteArrayInputStream("yourfile.ump".getBytes());
    input = new Input(stream);
  }

  @Test
  public void readLine()
  {
    String command = input.readLine();
    Assert.assertEquals("yourfile.ump",command);
  }  
 
  @Test
  public void readUmpleFile_fromArgs()
  {
    String[] args = new String[] {"myfile.ump"};
    String filename = input.readUmpleFile(args,output);
    Assert.assertEquals("myfile.ump", filename);
  }
  
  @Test
  public void readUmpleFile_fromInput()
  {
    String[] args = new String[] {};
    String filename = input.readUmpleFile(args,output);
    Assert.assertEquals("yourfile.ump", filename);
  }  
  
}
