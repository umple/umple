package cruise.umplificator.visitorTestFiles;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class InputForVisitorTest { 

boolean result = true;
char capitalC = 'C';
byte b = 100;
short s = 10000;
int i = 100000;
double d1 = 123.4;
long creditCardNumber = 1234_5678_9012_3456L;

InputForVisitorTest () { }

InputForVisitorTest(byte b) {
	this.b=b;
}

public int getB(){
return b;
}
 
}