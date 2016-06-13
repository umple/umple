package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.Method.Source;
import cruise.umple.util.SampleFileWriter;

public class UmpleTraitTest {
	String pathToInput;
	UmpleModel uMode;
	String defaultPath;

	@Before
	public void setup() {
		defaultPath = SampleFileWriter.rationalize("test/cruise/umple/compiler/trait/test/resources");

		String code = "class A { isA T;}" + "trait T {" + "depend cruise.umple.util.*;" + " tName;" + " Integer tAge;"
				+ " abstract; singleton; void xFun() {} " + "[tAge>=18]" + "}";
		uMode = getRunModel(code);

	}

	@After
	public void tearDown() {
		SampleFileWriter.destroy("traitTest.ump");
		SampleFileWriter.destroy("A.java");
		SampleFileWriter.destroy("B.java");
		SampleFileWriter.destroy("C.java");
		SampleFileWriter.destroy("I.java");
		SampleFileWriter.destroy("II.java");
	}

	@Test
	public void traitDetectionTest() {
		Assert.assertEquals(1, uMode.numberOfUmpleTraits());
	}

	@Test
	public void attributeDetectionTest() {
		Assert.assertEquals(2, uMode.getUmpleTrait("T").numberOfAttributes());
		Assert.assertEquals(2, uMode.getUmpleClass("A").numberOfAttributes());
	}

	@Test
	public void traitInheritanceTest() {
		Assert.assertEquals(1, uMode.getUmpleClass("A").numberOfExtendsTraits());
		Assert.assertEquals(1, uMode.getUmpleTrait("T").numberOfSubClasses());
	}

	@Ignore // we don't need this feature. maybe in the future we can find an
			// application
	public void abstractionTest() {
		Assert.assertEquals(true, uMode.getUmpleClass("A").isIsAbstract());
	}

	@Test
	public void singletonTest() {
		Assert.assertEquals(true, uMode.getUmpleClass("A").isIsSingleton());
	}

	@Test
	public void methodsTest() {
		Assert.assertEquals(1, uMode.getUmpleClass("A").numberOfMethods());
	}

	@Test
	public void dependTest() {
		Assert.assertEquals(1, uMode.getUmpleClass("A").numberOfDepends());
	}

	@Test
	public void constraintTest() {
		Assert.assertEquals(1, uMode.getUmpleTrait("T").numberOfConstraintTrees());
		Assert.assertEquals(1, uMode.getUmpleClass("A").numberOfConstraintTrees());
	}

	@Test
	public void checkValidNameTest() {
		String code = "class A{isA 12T;}trait 12T{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("200");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void checkUniqueNameTest() {
		String code = "class A{isA A;}trait A{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("203");

		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void selfInheritanceTest() {
		String code = "class A{isA T;} trait T { isA T;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("204");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void cyclicInheritanceTest() {
		String code = "class A{isA T;} trait T { isA T1;} trait T1 {isA T;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("206");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void multipleInheritanceTraitsTest() {
		String code = "class A {isA T1; isA T2;} trait T1 { lazy name1;} trait T2 {lazy name2;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfAttributes());
	}

	/*
	 * -------------------------------------------------------------------------
	 * ----------- ---------------------Tests related to state machines
	 * -------------------------------
	 * -------------------------------------------------------------------------
	 * -----------
	 */
	@Test
	public void stateMachineTraitsTest() {
		String code = "class A {isA T1;} class B {isA T1;} trait T1 { isA T2; status { on { turnOn -> on;}} } trait T2 {sm { active { goActive -> active;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfStateMachines());
		Assert.assertEquals(2, model.getUmpleClass("B").numberOfStateMachines());
	}

	@Test
	public void stateMachineTraits001Test() {
		String code = "class A {isA T1; status { on { turnOn -> on;}}} trait T1 { status { on { turnOn -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("226");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits002Test() {
		String code = "class A{ isA T1;} trait T1 {isA T2; status { on { turnOn -> on;}}} trait T2 { status { on { turnOn -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("226");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits003Test() {
		String code = "class A{isA T1,T2;} trait T1 {status { on { turnOn -> on;}}} trait T2 { status { on { turnOn -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("227");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits004Test() {
		String code = "class A{isA T1;} trait T1 {isA T2, T3;} trait T2 {status { on { turnOn -> on;}}} trait T3 { status { on { turnOn -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("227");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits005Test() {
		String code = "class A {isA T1,T2;} trait T1 { isA T3;} trait T2 { isA T3;} trait T3 { status { on { turnOn -> on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfStateMachines());
	}

	@Test
	public void stateMachineTraits006Test() {
		String code = "class A {isA T1; status { on { turnOn -> on;}} } trait T1 { status { on { enable -> on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine(0).getState(0).numberOfTransitions());
	}

	@Test
	public void stateMachineTraits007Test() {
		String code = "class A {isA T1; status { on { turnOn[x>0 and z>0] -> /{getData();} on;}} } trait T1 { status { on { turnOn[x>0 and z>0] -> /{getData();} on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").getStateMachine(0).getState(0).numberOfTransitions());
	}

	@Test
	public void stateMachineTraits008Test() {
		String code = "class A {isA T1; status { on { turnOn[x>0] -> on; [x] -> on;}  } } trait T1 { status { on { turnOn[z>0] -> on; [y] -> on;} } }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine(0).getState(0).numberOfTransitions());
		Assert.assertEquals("x > 0",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getGuard().getExpression());
		Assert.assertEquals("x",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(1).getGuard().getExpression());
	}

	@Test
	public void stateMachineTraits009Test() {
		String code = "class A {isA T1; status { on { turnOn -> on;}} } trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine(0).getState(0).numberOfTransitions());
		State st1 = model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getNextState();
		State st2 = model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(1).getNextState();
		Assert.assertEquals(st1, st2);

	}

	@Test
	public void stateMachineTraits010Test() {
		String code = "class A {isA T1; status { on { turnOn -> on;}} } trait T1 { status { onb { activate -> onb;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("228");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits011Test() {
		String code = "class A {isA T1 <status as mode,status as mood>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("229");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits012Test() {
		String code = "class A {isA T1 <status1 as mode>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("230");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits013Test() {
		String code = "class A {isA T1 <status as mode>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("mode", model.getUmpleClass("A").getStateMachine(0).getName());

	}

	@Test
	public void stateMachineTraits014Test() {
		String code = "class A {isA T1 <-status>;} trait T1 { status { on { activate -> on;}} status2{so{}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfStateMachines());
		Assert.assertEquals("status2", model.getUmpleClass("A").getStateMachine(0).getName());

	}

	@Test
	public void stateMachineTraits015Test() {
		String code = "class A {isA T1 <status as mode, status.on as alive>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("mode", model.getUmpleClass("A").getStateMachine(0).getName());
		Assert.assertEquals("mode",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getStateMachine().getName());
		Assert.assertEquals("alive", model.getUmpleClass("A").getStateMachine(0).getState(0).getName());

	}

	@Test
	public void stateMachineTraits016Test() {
		String code = "class A {isA T1 <status.on.running.mode1.submode1 as sm1, status.on.running.mode1.submode2 as sm2>;} trait T1 { status { on { running{mode1{ submode1{goSubMode2 -> submode2;}submode2{goSubMode1 -> submode1;}}} }} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("sm1", model.getUmpleClass("A").getStateMachine(0).findState("sm1", true).getName());
		Assert.assertEquals("sm2", model.getUmpleClass("A").getStateMachine(0).findState("sm2", true).getName());
		Assert.assertEquals(null, model.getUmpleClass("A").getStateMachine(0).findState("submode1", true));
		Assert.assertEquals(null, model.getUmpleClass("A").getStateMachine(0).findState("submode2", true));

	}

	@Test
	public void stateMachineTraits017Test() {
		String code = "class A {isA T1 <status.turnOff() as goOff>;} trait T1 { status { on { turnOff()-> off;} off{turnOff->off; } } }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("goOff",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getEvent().getName());
		Assert.assertEquals("goOff",
				model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0).getEvent().getName());
	}

	@Test
	public void stateMachineTraits018Test() {
		String code = "class A {isA T1 <status.turnOff() as goOff, status.turnOn() as goOn>;} trait T1 { status { on { turnOff()-> off;} off{turnOn->on; } } }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("goOff",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getEvent().getName());
		Assert.assertEquals("goOn",
				model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0).getEvent().getName());
	}

	@Test
	public void stateMachineTraits019Test() {
		String code = "class A{isA T<P=String>;}trait T<P> {	status{		on{			turnOff(P p) -> off;		}		off{			turnOn(P p1,P p2,P p3,int i) -> on; 		}	}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("String", model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0)
				.getEvent().getParam(0).getType());
		Assert.assertEquals("String", model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0)
				.getEvent().getParam(0).getType());
		Assert.assertEquals("String", model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0)
				.getEvent().getParam(1).getType());
		Assert.assertEquals("String", model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0)
				.getEvent().getParam(2).getType());
		Assert.assertEquals("int", model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0).getEvent()
				.getParam(3).getType());
	}

	@Test
	public void stateMachineTraits020Test() {
		String code = "class A {isA T1 <status.activate1() as enable>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("231");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits021Test() {
		String code = "class A {isA T1 <*.activate1() as enable>;} trait T1 { status { on { activate -> on;}} }";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("232");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits022Test() {
		String code = "class A {isA T1 <*.activate() as enable>;} trait T1 { status1 { on { activate -> on; activate2 -> on;}}  status2 { on { activate -> on;}}  }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("enable",
				model.getUmpleClass("A").getStateMachine("status1").getState(0).getTransition(0).getEvent().getName());
		Assert.assertEquals("activate2",
				model.getUmpleClass("A").getStateMachine("status1").getState(0).getTransition(1).getEvent().getName());
		Assert.assertEquals("enable",
				model.getUmpleClass("A").getStateMachine("status2").getState(0).getTransition(0).getEvent().getName());
	}

	@Test
	public void stateMachineTraits023Test() {
		String code = "	class A { isA T < st . on as ActiveA > ; } class B { isA T < st . on as ActiveB"
				+ "> ; } class C { isA T < st . on as ActiveC > ; } trait T { st { on { goTwo ->"
				+ "two ; } two { goOne -> on ; } } }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("ActiveA", model.getUmpleClass("A").getStateMachine(0).getState(0).getName());
		Assert.assertEquals("ActiveB", model.getUmpleClass("B").getStateMachine(0).getState(0).getName());
		Assert.assertEquals("ActiveC", model.getUmpleClass("C").getStateMachine(0).getState(0).getName());
	}

	@Test
	public void stateMachineTraits024Test() {
		String code = "class A {	isA T1 <status.turnOff() as goOff>;} class B{	isA T1;}trait T1 { 	status {		on {			turnOff()-> off;		}		off{			turnOff->off;		}	}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("goOff",
				model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getEvent().getName());
		Assert.assertEquals("goOff",
				model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0).getEvent().getName());
		Assert.assertEquals("turnOff",
				model.getUmpleClass("B").getStateMachine(0).getState(0).getTransition(0).getEvent().getName());
		Assert.assertEquals("turnOff",
				model.getUmpleClass("B").getStateMachine(0).getState(1).getTransition(0).getEvent().getName());

	}

	@Test
	public void stateMachineTraits025Test() {
		String code = "class A{		isA Player;}"
				+ "trait ElectricalDevice{	status{			on{			turnOff -> off;		}			off{			turnOn -> on;		}	}}"
				+ "trait Player{	isA ElectricalDevice<status.on as stop,status as sm>;	sm{			stop{					pressPlay -> playing;		}			playing{					pressStop -> stop;					pressPause -> pause;		}		pause{					pressStop -> stop;					pressPlay -> playing;		}	}}";

		UmpleModel model = getRunModel(code);
		Assert.assertEquals(4, model.getUmpleClass("A").getStateMachine("sm").numberOfStates());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("sm").getState(0).numberOfTransitions());
		Assert.assertEquals(1, model.getUmpleClass("A").getStateMachine("sm").getState(3).numberOfTransitions());
		Assert.assertEquals("turnOn",
				model.getUmpleClass("A").getStateMachine("sm").getState(3).getTransition(0).getEvent().getName());
	}

	@Test
	public void stateMachineTraits026Test() {
		String code = "class A {	isA T1;	status { on { turnOn -> on;}}}"
				+ "trait T1 {	status { onb { activate -> onb;}}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").getStateMachine("status").numberOfStates());
		Assert.assertEquals("status", model.getUmpleClass("A").getStateMachine("status").getStartState().getName());
		Assert.assertEquals(2,
				model.getUmpleClass("A").getStateMachine("status").getStartState().numberOfNestedStateMachines());
		Assert.assertEquals("on",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(0).getName());
		Assert.assertEquals("onb",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(1).getName());
	}

	@Test
	public void stateMachineTraits027Test() {
		String code = "class A{	isA T;}" + "trait T {	isA T1;	status { on { turnOn -> on;}}}"
				+ "trait T1 {	status { onb { activate -> onb;}}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").getStateMachine("status").numberOfStates());
		Assert.assertEquals("status", model.getUmpleClass("A").getStateMachine("status").getStartState().getName());
		Assert.assertEquals(2,
				model.getUmpleClass("A").getStateMachine("status").getStartState().numberOfNestedStateMachines());
		Assert.assertEquals("on",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(0).getName());
		Assert.assertEquals("onb",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(1).getName());
	}

	@Test
	public void stateMachineTraits028Test() {
		String code = "class A{  isA T1;}"
				+ "trait T1{	isA T2<status.active as on>;	status{		on{			turn_off -> off;			stop{				go_play -> play;			}			play{				go_stop -> stop;				go_pause -> pause;			}			pause{				go_play -> play;				go_stop -> stop;			}		}		off{			turn_on -> on;		}	}}"
				+ "trait T2{	status{		active{			s1{				go_s2 -> s2;			}			s2{				go_s1 -> s1;			}		}	}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("status").numberOfStates());
		Assert.assertEquals(2,
				model.getUmpleClass("A").getStateMachine("status").getStartState().numberOfNestedStateMachines());
		Assert.assertEquals("stop",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(0).getName());
		Assert.assertEquals("s1",
				model.getUmpleClass("A").getStateMachine("status").getStartState().getNestedStateMachine(1).getName());

	}

	@Test
	public void stateMachineTraits029Test() {
		String code = "class A {   isA T1<sm1 as sm,sm1.s00 as s0>;   sm {     s0 {       s1 {       }       ||       s2 {       }     }   }}"
				+ "trait T1 {   sm1 {     s00 {       s4 {         e -> s5;       }       s5 {}    }  }}";

		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3,
				model.getUmpleClass("A").getStateMachine("sm").getState(0).numberOfNestedStateMachines());
	}

	@Test
	public void stateMachineTraits030Test() {
		String code = "class A {  	isA T2;	isA T1<sm1 as sm,sm1.s00 as s0>; 	sm {     s0 {       s1 {       }       ||       s2 {       }     }   }}"
				+ "trait T1 {  	sm1 {    		s00 {      			s4 {         e -> s5;       }     			s5 {}		}	}}"
				+ "trait T2{	sm {   		 s0 {   			t1{				goT2 -> t2;			}				t2 {				goT1 -> t1;			}		}	}}";

		UmpleModel model = getRunModel(code);
		Assert.assertEquals(4,
				model.getUmpleClass("A").getStateMachine("sm").getState(0).numberOfNestedStateMachines());
	}

	@Test
	public void stateMachineTraits031Test() {
		String code = "class A{  isA T<status1 as st1,status2 as st2>;}" + "trait T{  isA T1;  isA T2;}"
				+ "trait T1{  status1{    A0{    T-> A1;    }    A1{      T-> A0;    }  }}"
				+ "trait T2{  status2{    B0{      T-> B1;    }    B1{}  }}";
		UmpleModel model = getRunModel(code);
		Assert.assertNotNull(model.getUmpleClass("A").getStateMachine("st1"));
		Assert.assertNotNull(model.getUmpleClass("A").getStateMachine("st2"));
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("st1").getStates().size());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("st2").getStates().size());
	}

	@Test
	public void stateMachineTraits032Test() {
		String code = "class A{  isA C;}"
				+ "trait Base{  fts{  zero{    water -> one;  }    one{    get -> zero;  }  }}"
				+ "trait C {  isA CC;  fts{    zero{    coin-> two;    }    two{    coffee -> one;     tea-> one;    }  }}"
				+ "trait CC{  isA Base;  fts{    zero{      card  -> three;      }    three{      pin -> two;    }   }}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").getStateMachine("fts").getState(0).numberOfTransitions());
	}

	@Test
	public void stateMachineTraits033Test() {
		String code = "class A{	isA T;}"
				+ "trait T{	void test1(){}	void test2(){}	void test3(){}	sm{		s0{	entry/Java{test1();}				do Java{test2();}				exit/Java{test3();}		}}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").getStateMachine("sm").getState(0).numberOfActivities());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("sm").getState(0).numberOfActions());
		Assert.assertEquals("test2();",
				model.getUmpleClass("A").getStateMachine("sm").getState(0).getActivity(0).getActivityCode());
		Assert.assertEquals("test1();",
				model.getUmpleClass("A").getStateMachine("sm").getState(0).getAction(0).getCodeblock().getCode("Java"));
		Assert.assertEquals("test3();",
				model.getUmpleClass("A").getStateMachine("sm").getState(0).getAction(1).getCodeblock().getCode("Java"));
	}

	@Test
	public void stateMachineTraits034Test() {
		String code = "trait T{	Boolean requiredMethod ();}"
				+ "class A{	isA T;	sm{		s0{			requiredMethod() -> s1;		}		s1{			getBack() -> s0;		}	}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("208");
		} finally {
			Assert.assertFalse(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void stateMachineTraits035Test() {
		String code = "trait T{	Boolean requiredMethod ();}"
				+ "class A{	sm{		s0{			requiredMethod() -> s1;		}		s1{			getBack() -> s0;		}	}}"
				+ "class B{isA T; isA A;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("208");
		} finally {
			Assert.assertFalse(result);
			SampleFileWriter.destroy("traitTest.ump");
		}

	}

	@Test
	public void stateMachineTraits036Test() {
		String code = "class A{	isA T <sm as system.executing>;	system {		initial{			excute -> executing;	}		executing{					}	}}"
				+ "trait T{	sm{			s0{goS1-> s1;}			s1{}		}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("system").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals("executing",
				model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0).getName());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0)
				.getState(0).getStateMachine().numberOfStates());

	}

	@Test
	public void stateMachineTraits037Test() {
		String code = "class A{	isA T2;}"
				+ "trait T2{	isA T <sm as system.executing>;	system {		initial{			excute -> executing;		}		executing{					}	}}"
				+ "trait T{	sm{			s0{goS1-> s1;}			s1{}		}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("system").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals("executing",
				model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0).getName());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0)
				.getState(0).getStateMachine().numberOfStates());

	}

	@Test
	public void stateMachineTraits038Test() {
		String code = "class A{	isA T2;}"
				+ "trait T2{	isA T <sm2 as system.executing>;	system {		initial{			excute -> executing;		}		executing{				}	}}"
				+ "trait T{	isA T1;	sm2{			s20{goS21-> s21;}			s21{}		}}"
				+ "trait T1{	sm{			s0{goS1-> s1;}			s1{}		}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("system").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals("executing",
				model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0).getName());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0)
				.getState(0).getStateMachine().numberOfStates());
		Assert.assertEquals("s20", model.getUmpleClass("A").getStateMachine("system").getState(1)
				.getNestedStateMachine(0).getState(0).getStateMachine().getState(0).getName());
	}

	@Test
	public void stateMachineTraits039Test() {
		String code = "class A{	isA T3<sm2 as system.executing>;}"
				+ "trait T3{	isA T2;	system {		initial{			excute -> executing;		}		executing{					}	}}"
				+ "trait T2{	isA T1<sm as sm2.s21>;	sm2{			s20{goS21-> s21;}			s21{}	}}"
				+ "trait T1{	sm{			s0{goS1-> s1;}			s1{}		}}";

		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("system").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals("executing",
				model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0).getName());
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0)
				.getState(1).getStateMachine().numberOfStates());
		Assert.assertEquals("s20", model.getUmpleClass("A").getStateMachine("system").getState(1)
				.getNestedStateMachine(0).getState(0).getStateMachine().getState(0).getName());
		Assert.assertEquals("s0",
				model.getUmpleClass("A").getStateMachine("system").getState(1).getNestedStateMachine(0).getState(1)
						.getNestedStateMachine(0).getState(0).getStateMachine().getState(0).getName());
	}

	@Test
	public void stateMachineTraits040Test() {
		UmpleModel model = getRunModelByFilename("trait_test_data_0001.ump");

		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("base_Behavior").getState(0).numberOfNestedStateMachines());
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("base_Behavior").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("base_Behavior").getState(2).numberOfNestedStateMachines());
	}

	@Test
	public void stateMachineTraits041Test() {
		String code = "class A{	isA T2;	isA T<sm1 as sw2,sm1 as sm.s2>;}"
				+ "trait T{	sm1{		s1{			goS1-> s1;		}		s3{				}	}}"
				+ "trait T2{	sm{		s1{			goS2-> s2;		}		s2{	}	}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("sm").getState(1).numberOfNestedStateMachines());
	}

	@Test
	public void stateMachineTraits042Test() {
		String code = "class A{	isA T2;}"
				+ "trait T2{	isA T<sm as sm2.s2,sm as sm2.s2>;sm2{		s2{					}	}}"
				+ "trait T{	sm{		so{			go->so;		}	}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("229");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}

	}

	@Test
	public void stateMachineTraits043Test() {
		UmpleModel model = getRunModelByFilename("trait_test_data_0002.ump");

		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("status").getState(0).numberOfNestedStateMachines());
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("status").getState(1).numberOfNestedStateMachines());
		Assert.assertEquals(1,
				model.getUmpleClass("A").getStateMachine("status").getState(2).numberOfNestedStateMachines());
	}

	@Test
	public void stateMachineTraits044Test() {
		String code = "trait T{	sm{		s1{			goS1->s1;		}}}"
				+ "trait T2{	isA T<sm.s1 as SS1, sm as sm2.a.ac>;	sm2{		a{			ac{}		}		}}"
				+ "class A{	isA T2;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("SS1", model.getUmpleClass("A").getStateMachine("sm2").getState(0).getNestedStateMachine(0)
				.getState(0).getNestedStateMachine(0).getState(0).getName());
	}

	@Test
	public void stateMachineTraits045Test() {
		UmpleModel model = getRunModelByFilename("trait_test_data_0003.ump");
		Assert.assertEquals(2, model.getUmpleClass("A").getStateMachine("status").getState(1).getNestedStateMachine(0)
				.numberOfStates());
	}
	
	@Test
	public void stateMachineTraits046Test() {
		UmpleModel model = getRunModelByFilename("trait_test_data_0004.ump");
		Assert.assertTrue(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction()
				.getCodeblock().getCode().contains("T->s0.e1"));
		Assert.assertTrue(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction()
				.getCodeblock().getCode().contains("T1->s0.e1"));
		Assert.assertFalse(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("superCall;"));
		Assert.assertTrue(model.getUmpleClass("B").getStateMachine("sm").getState(0).getTransition(0).getAction()
				.getCodeblock().getCode().contains("T->s0.e1"));
		Assert.assertTrue(model.getUmpleClass("B").getStateMachine("sm").getState(0).getTransition(0).getAction()
				.getCodeblock().getCode().contains("T1->s0.e1"));
		Assert.assertTrue(model.getUmpleClass("B").getStateMachine("sm").getState(0).getTransition(0).getAction()
				.getCodeblock().getCode().contains("T2->s0.e1"));
		Assert.assertFalse(model.getUmpleClass("B").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("superCall;"));

	}
	
	@Test
	public void stateMachineTraits047Test() {
		UmpleModel model = getRunModelByFilename("trait_test_data_0005.ump");
		Assert.assertTrue(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("T->s0.e1"));
		Assert.assertTrue(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("T1->s0.e1"));
		Assert.assertTrue(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("T2->s0.e1"));
		Assert.assertFalse(model.getUmpleClass("A").getStateMachine("sm").getState(0).getTransition(0).getAction().getCodeblock().getCode().contains("superCall;"));

	}


	// the last StateTest

	// This is related to issue #656
	// @Test
	// public void stateMachineTraits020Test() {
	// String code = "class A {isA T1 <status.turnOff(int) as goOff>;} trait T1
	// { status { on { turnOff(int a,int b)-> off;} off{turnOff(int a)->off; } }
	// }";
	// UmpleModel model = getRunModel(code);
	// Assert.assertEquals("turnOff",
	// model.getUmpleClass("A").getStateMachine(0).getState(0).getTransition(0).getEvent().getName());
	// Assert.assertEquals("goOff",
	// model.getUmpleClass("A").getStateMachine(0).getState(1).getTransition(0).getEvent().getName());
	// }

	/*
	 * -------------------------------------------------------------------------
	 * ----------- -------------------------------------END
	 * -------------------------------------------
	 * -------------------------------------------------------------------------
	 * -----------
	 */

	@Test
	public void codeInjectTraitsTest() {
		String code = "class A {isA T;} trait T { Integer x; after getX { x = 0;} before getX { x = 0;} } ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfCodeInjections());
	}

	@Test
	public void extraCodeTraitsTest() {
		String code = "class A {isA T;} trait T { cout<<x; } ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(false, model.getUmpleClass("A").getExtraCode().isEmpty());
	}

	@Test
	public void checkRequiredMethodTest1() {
		String code = "class A{isA T;} trait T { String test();}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("208");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void checkRequiredMethodTest2() {
		String code = "class A{abstract;isA T;} trait T { String test();}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("test", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals(true, model.getUmpleClass("A").getMethod(0).isIsAbstract());
	}

	@Ignore
	public void GeneraParameterTest() {
		String code = "class A{isA T<fname>;} trait T<p1> { %p1;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("fname", model.getUmpleClass("A").getAttribute(0).getName());

	}

	@Test
	public void checkDuplicatedMethods1Test() {
		String code = "class A{isA T1; isA T2;} trait T1 { String test(){}} trait T2 { String test(){}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("210");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void checkDuplicatedMethods2Test() {
		String code = "class A{isA T;}trait T{isA T1;isA T2;}trait T1{void test(){/*T1*/}}trait T2{void test(){/*T2*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("210");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void compositionTraitClassRule1Test() {
		String code = "class A{isA T;void test() {/*A*/} } trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());

	}

	@Test
	public void compositionTraitClassRule2Test() {
		String code = "class A{void test() {/*A*/}}class B{isA A;isA T;}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*T*/", model.getUmpleClass("B").getMethod(0).getMethodBody().getExtraCode());

	}

	@Test
	public void compositionTraitClassRule3Test() {
		String code = "class A{void test() {/*A*/}}class B{isA A;isA T;void test(){/*B*/}}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*B*/", model.getUmpleClass("B").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void compositionTraitClassRule4Test() {
		String code = "interface I{void test();}class A{isA I;isA T;void test(){/*A*/}}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void compositionTraitClassRule5Test() {
		String code = "interface I { void test();} class A { isA I; isA T; } trait T { void test() {/*T*/} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
	}

	@Test
	public void compositionTraitClassRule6Test() {
		String code = "class A{isA T;void need(){/*A*/}}trait T{void need();void show(){need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void compositionTraitClassRule7Test() {
		String code = "class A{isA T1;void test1() {/*A*/}isA T4;}trait T4{void test1() {/*T4*/}}trait T1{void test1() {/*T1*/}isA T2;}trait T2{isA T3;	void test2() {/*T2*/}}trait T3{void test3() {/*T3*/}void test2() {/*T3*/}void test1() {/*T3*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")) {
				Assert.assertEquals("/*A*/", method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test2")) {
				Assert.assertEquals("/*T2*/", method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test3")) {
				Assert.assertEquals("/*T3*/", method.getMethodBody().getExtraCode());
			}
		}

	}

	@Test
	public void compositionTraitClassRule8Test() {
		String code = "class A{isA T;}trait T{isA T1;void need(){/*T*/}}trait T1{void need();void show(){	need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")) {
				Assert.assertEquals("/*T*/", method.getMethodBody().getExtraCode());
			}
		}
	}

	@Test
	public void compositionTraitClassRule9Test() {
		String code = "class A{isA T;void need(){/*A*/}	}trait T{isA T1;void need(){/*T*/}}trait T1{void need();void show(){need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")) {
				Assert.assertEquals("/*A*/", method.getMethodBody().getExtraCode());
			}
		}
	}

	@Test
	public void compositionTraitClassRule10Test() {
		String code = "class A{isA T1,T2;}trait T1{isA T;}trait T2{isA T;}trait T{void test(){/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("/*T*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void compositionTraitClassRule11Test() {
		String code = "class A{isA T;}trait T{void test1(){/*T*/}}trait T{void test2(){/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
	}

	@Test
	public void compositionTraitClassRule12Test() {
		String code = "class A{isA T; }trait T{ isA T1; void need(); void show(){test(); }}trait T1{ void need(){ /*T1*/ }} ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")) {
				Assert.assertEquals("/*T1*/", method.getMethodBody().getExtraCode());
			}
		}
	}

	@Test
	public void includeExcludeRule1Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <-test2()>;void test1(){/*T1*/}  }trait T2{void test2(){/*T2*/}void test3(){/*T2*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")) {
				Assert.assertEquals("/*T1*/", method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test3")) {
				Assert.assertEquals("/*T2*/", method.getMethodBody().getExtraCode());
			}
		}
	}

	@Test
	public void includeExcludeRule2Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <+test2()>;void test1(){/*T1*/}  }trait T2{void test2(){/*T2*/}void test3(){/*T2*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")) {
				Assert.assertEquals("/*T1*/", method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test2")) {
				Assert.assertEquals("/*T2*/", method.getMethodBody().getExtraCode());
			}
		}
	}

	@Test
	public void includeExcludeRule3Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <-show()>;void test(){/*T1*/}  }trait T2{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("212");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule4Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <+show()>;void test(){/*T1*/}  }trait T2{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("212");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule5Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <+show(),+show()>;void test(){/*T1*/}  }trait T2{void show(){/*T2*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("211");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule6Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <-show(),+show()>;void test(){/*T1*/}  }trait T2{void show(){/*T2*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("211");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule7Test() {
		String code = "class A{isA T1;}trait T1{isA T2 <+display()>;}trait T2{void show(){/*T2*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("212");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule8Test() {
		String code = "class A{isA T1<-display1()>,T2<+show2()>;}trait T1{void display1(){/*T1*/}void show1(){/*T1*/}}trait T2{void display2(){/*T2*/}void show2(){/*T2*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("display1")) {
				Assert.assertEquals("/*T1*/", method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("show2")) {
				Assert.assertEquals("/*T2*/", method.getMethodBody().getExtraCode());
			}
		}

	}

	@Test
	public void includeExcludeRule9Test() {
		String code = "class A{isA T;}trait T{isA T1<-test()>;isA T2;}trait T1{void test(){/*T1*/}}trait T2{void test(){/*T2*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("/*T2*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void includeExcludeRule10Test() {
		String code = "class A{isA T1<-test()>,T2;}trait T1{void test(){/*T1*/}}trait T2{void test(){/*T2*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("/*T2*/", model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	}

	@Test
	public void includeExcludeRule11Test() {
		String code = "class A{isA T1< +test(String),+test(Integer,String)>;}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}void test(String str,Integer inData){/*T1-SI*/}void test(Integer inData, String str){/*T1-IS*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test")) {
				if (method.numberOfMethodParameters() == 1) {
					Assert.assertEquals("String", method.getMethodParameter(0).getType());
				} else if (method.numberOfMethodParameters() == 2) {
					Assert.assertEquals("Integer", method.getMethodParameter(0).getType());
					Assert.assertEquals("String", method.getMethodParameter(1).getType());
				}
			}
		}
	}

	@Test
	public void includeExcludeRule12Test() {
		String code = "class A{isA T1< +test(String),+test()>;}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}void test(String str,Integer inData){/*T1-SI*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("212");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRule13Test() {
		String code = "class A{isA T<test() as private>;}trait T{void test();}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("212");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Ignore
	public void includeExcludeRuleAlias1Test() {
		String code = "class A{isA T1<+test(Integer), -test(String) as t >;}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}void test(String str,Integer inData){/*T1-SI*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("213");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRuleAlias2Test() {
		String code = "class A{isA T1< test(String) as changedTest >;	}trait T1{void test(String str){/*T1-S*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("changedTest", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals("String", model.getUmpleClass("A").getMethod(0).getMethodParameter(0).getType());
	}

	@Test
	public void includeExcludeRuleAlias3Test() {
		String code = "class A{isA T1< test(String) as changedTest >;	}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
	}

	@Test
	public void includeExcludeRuleAlias4Test() {
		String code = "class A{isA T1< +test(Integer) as changedTestI >;	}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}void test(String str, Integer inData){/*T1-SI*/}void test(Integer inData, String str){/*T1-IS*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("changedTestI", model.getUmpleClass("A").getMethod(0).getName());
	}

	@Test
	public void includeExcludeRuleAlias5Test() {
		String code = "class A{isA T1< +test(Integer), +test(String) as changedTestS >;	}trait T1{void test(String str){/*T1-S*/}void test(Integer inData){/*T1-I*/}void test(String str, Integer inData){/*T1-SI*/}void test(Integer inData, String str){/*T1-IS*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getMethodParameters().get(0).getType().equals("Integer")) {
				Assert.assertEquals("test", method.getName());
			} else if (method.getMethodParameters().get(0).getType().equals("String")) {
				Assert.assertEquals("changedTestS", method.getName());
			}
		}

	}

	@Test
	public void includeExcludeRuleAlias6Test() {
		String code = "class A{isA T;}class B{isA T<test1() as show1,test2() as show2>;}trait T{void test1(){/**/}void test2(){/**/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("test1", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals("test2", model.getUmpleClass("A").getMethod(1).getName());
		Assert.assertEquals(2, model.getUmpleClass("B").numberOfMethods());
		Assert.assertEquals("show1", model.getUmpleClass("B").getMethod(0).getName());
		Assert.assertEquals("show2", model.getUmpleClass("B").getMethod(1).getName());
	}

	@Test
	public void includeExcludeRuleAlias7Test() {
		String code = "class A{ isA T<require() as requireT>;isA D<require() as requireD>;}trait T{    isA T1;	void require(){	 /*T*/	}} trait T1{void require(); void testT1(){	 /*T1*/}}trait D{ isA D1;  void require(){  /*D*/  };}trait D1{  void require(); void testD1(){	 /*D1*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("208");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRuleAlias8Test() {
		String code = "class A{isA T<test() as test1>;}trait T{isA T1;void test(){/*T*/}}trait T1{void test1(){/*T1*/}}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("220");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void includeExcludeRuleAlias9Test() {
		String code = "class A{isA T< test() as test1>;}trait T{isA T1;void test(){/*T*/}}trait T1{void testA(){/*T1*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
	}

	@Test
	public void includeExcludeRuleAlias10Test() {
		String code = "class A{isA T<X=B, -test1(X)>;}class B{}trait T<X>{void test1(X t){}void test2(X t){}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("test2", model.getUmpleClass("A").getMethod(0).getName());
	}

	@Test
	public void includeExcludeRuleVisibility1Test() {
		String code = "class A{isA T<test1() as private,test2() as protected,test3() as public>;}trait T{void test1(){	/*T*/}void test2(){	/*T*/}void test3(){	/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")) {
				Assert.assertEquals("private", method.getModifier());
			} else if (method.getName().equals("test2")) {
				Assert.assertEquals("protected", method.getModifier());
			} else if (method.getName().equals("test3")) {
				Assert.assertEquals("public", method.getModifier());
			}
		}
	}

	@Test
	public void includeExcludeRuleVisibility2Test() {
		String code = "class A{isA T<test1() as private show1,test2() as protected show2,test3() as public show3>;}trait T{void test1(){/*T*/}void test2(){	/*T*/}void test3(){	/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("show1", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals("private", model.getUmpleClass("A").getMethod(0).getModifier());
		Assert.assertEquals("show2", model.getUmpleClass("A").getMethod(1).getName());
		Assert.assertEquals("protected", model.getUmpleClass("A").getMethod(1).getModifier());
		Assert.assertEquals("show3", model.getUmpleClass("A").getMethod(2).getName());
		Assert.assertEquals("public", model.getUmpleClass("A").getMethod(2).getModifier());
		/*
		 * //this is also an alternative.Above, consider order for methods for
		 * (Method method : model.getUmpleClass("A").getMethods()) { if
		 * (method.getName().equals("show1")){
		 * Assert.assertEquals("private",method.getModifier()); } else if
		 * (method.getName().equals("show2")){
		 * Assert.assertEquals("protected",method.getModifier()); } else if
		 * (method.getName().equals("show3")){
		 * Assert.assertEquals("public",method.getModifier()); } }
		 */
	}

	@Test
	public void includeExcludeRuleVisibility3Test() {
		String code = "class A{isA T<+test1() as private,+test2() as protected>;}trait T{void test1(){	/*T*/}void test2(){	/*T*/}void test3(){	/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("test1", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals("private", model.getUmpleClass("A").getMethod(0).getModifier());
		Assert.assertEquals("test2", model.getUmpleClass("A").getMethod(1).getName());
		Assert.assertEquals("protected", model.getUmpleClass("A").getMethod(1).getModifier());
	}

	@Test
	public void includeExcludeRuleVisibility4Test() {
		String code = "class A{isA T<+test1() as private show1,+test2() as protected show2>;}trait T{void test1(){	/*T*/}void test2(){	/*T*/}void test3(){	/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("show1", model.getUmpleClass("A").getMethod(0).getName());
		Assert.assertEquals("private", model.getUmpleClass("A").getMethod(0).getModifier());
		Assert.assertEquals("show2", model.getUmpleClass("A").getMethod(1).getName());
		Assert.assertEquals("protected", model.getUmpleClass("A").getMethod(1).getModifier());
	}

	@Test
	public void generalRule1Test() {
		String code = "class A{ isA T; void test(){/**/ }}trait T{ void test();}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(false, model.getUmpleClass("A").getIsAbstract());
	}

	@Test
	public void TypeParameterTest00() {
		String code = "class A{isA T;}trait T<X,X>{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("214");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void TypeParameterTest01() {
		String code = "class A{isA T< X = String, X = Integer >;}trait T<X,Z>{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("216");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void TypeParameterTest02() {
		String code = "class A{isA T< X= Integer, Y = String>;}trait T<X>{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("215");
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
			Assert.assertTrue(result);
		}
	}

	@Test
	public void TypeParameterTest03() {
		String code = "class A{isA T< X = B, Z=C>;} class B{} class C{}trait T<X,Z>{X test(Z inData1, X inData2){}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("B", model.getUmpleClass("A").getMethod(0).getType());
		Assert.assertEquals("C", model.getUmpleClass("A").getMethod(0).getMethodParameter(0).getType());
		Assert.assertEquals("B", model.getUmpleClass("A").getMethod(0).getMethodParameter(1).getType());

	}

	@Test
	public void TypeParameterTest04() {
		String code = "class A{isA T< X = String>;}trait T<X>{isA T1 < A = X >;X test(X inData){}}trait T1<A>{void test1(A z){}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")) {
				Assert.assertEquals("String", method.getMethodParameter(0).getType());
			} else if (method.getName().equals("test")) {
				Assert.assertEquals("String", method.getType());
				Assert.assertEquals("String", method.getMethodParameter(0).getType());
			}
		}
	}

	@Test
	public void TypeParameterTest05() {
		String code = "class A{isA T1,T2;}trait T1{isA T<X=Integer>;}trait T2{isA T<X=String>;}trait T<X>{void test(X in){/**/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("Integer", model.getUmpleClass("A").getMethod(0).getMethodParameter(0).getType());
		Assert.assertEquals("String", model.getUmpleClass("A").getMethod(1).getMethodParameter(0).getType());
	}

	@Test
	public void TypeParameterTest06() {
		String code = "class A{isA T1<X = B>;}class B{}trait T1<X,Y>{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("219");
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
			Assert.assertTrue(result);
		}
	}

	@Test
	public void TypeParameterTest07() {
		String code = "class A{isA T1;}class B{} trait T1<X,Y>{}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("219");
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
			Assert.assertTrue(result);
		}
	}

	@Test
	public void Attribute01Test() {
		String code = "class A{name;isA T;}trait T{name;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("218");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void Attribute02Test() {
		String code = "class A{isA T;}trait T{	isA T1;}trait T1{name;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAttributes());
	}

	@Test
	public void Attribute03Test() {
		String code = "class A{isA T;}trait T{name;isA T1;}trait T1{name;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("218");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void Attribute04Test() {
		String code = "class A{name;isA T;}trait T{isA T1;}trait T1{name;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("218");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void Attribute05Test() {
		String code = "class A{isA T;}trait T{isA T1;isA T2;}trait T1{isA Share;}trait T2{isA Share;}trait Share{name;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAttributes());
	}

	@Test
	public void Attribute06Test() {
		String code = "class A{isA T1;isA T2;}trait T1{isA Share;}trait T2{isA Share;}trait Share{name;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAttributes());
	}

	@Test
	public void Attribute07Test() {
		String code = "class A{isA T1;isA T2;}trait T1{name;}trait T2{name;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("218");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void Attribute08Test() {
		String code = "class A{isA T<X=String>;}trait T<X>{X name;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAttributes());
		Assert.assertEquals("String", model.getUmpleClass("A").getAttribute(0).getType());
	}

	@Test
	public void Attribute09Test() {
		String code = "class A{isA T<X=String>;}trait T<X>{X name;isA T1<Y=X>;}trait T1<Y>{Y address;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfAttributes());
		Assert.assertEquals("String", model.getUmpleClass("A").getAttribute(0).getType());
		Assert.assertEquals("String", model.getUmpleClass("A").getAttribute(1).getType());
	}

	@Test
	public void Attribute10Test() {
		String code = "class A{isA T<X=String>;}trait T<X>{isA T1;	isA T2;}trait T1{isA Share<Type = Integer>;}trait T2{isA Share<Type = String>;}trait Share<Type> {Type name;}";
		UmpleModel model = getModel(code);
		boolean result = false;
		try {
			model.run();
		} catch (Exception e) {
			result = e.getMessage().contains("217");
		} finally {
			Assert.assertTrue(result);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void associationTraitsTest() {
		String code = "class A {isA T;} class B {} trait T { 1 -- * B;} ";
		UmpleModel model = getRunModel(code);
		SampleFileWriter.destroy("B.java");
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAssociationVariables());
	}

	@Test
	public void associationTraits000Test() {
		String code = "class A {isA T;} interface I {} trait T { 1 -- * I;}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("20");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void associations001Test() {
		String code = "class A{isA T<X=B>;}trait T<X>{0..1 -- * X;} class B{}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAssociationVariables());
		Assert.assertEquals(1, model.getUmpleClass("B").numberOfAssociationVariables());
	}

	@Test
	public void associations002Test() {
		String code = "class A{isA T<X=B, Z=C>;   }trait T<X,Z>{0..1 -- * X;0..1 -- * Z;} class B{}class C{isA T<X=A,Z=B>;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").numberOfAssociationVariables());
		Assert.assertEquals(2, model.getUmpleClass("B").numberOfAssociationVariables());
		Assert.assertEquals(3, model.getUmpleClass("C").numberOfAssociationVariables());
	}

	@Test
	public void associations003Test() {
		String code = "class A{isA T<X1=B>;   }trait T<X1>{0..1 -> * X1;isA T2<X2=X1>;} trait T2<X2>{0..1 -> 2 X2;} class B{}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfAssociationVariables());
	}

	@Test
	public void associations004Test() {
		String code = "class A{isA T<X1=B>;   }trait T<X1>{0..1 -> * X1;0..1 -> 2 B;} class B{}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfAssociationVariables());
	}

	@Test
	public void associations005Test() {
		String code = "class A{isA T<X=I>;} interface I{} trait T<X>{ 1 -- * X;} }";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("20");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void templateInCode01Test() {
		String code = "class A{isA T<X=B>;} class B{isA T<X=A>;} trait T<X>{void test(){#X# b=new #X#();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("B b=new B();",
				model.getUmpleClass("A").getMethod(0).getMethodBody().getCodeblock().getCode());
		Assert.assertEquals("A b=new A();",
				model.getUmpleClass("B").getMethod(0).getMethodBody().getCodeblock().getCode());
	}

	@Test
	public void templateInCode02Test() {
		String code = "class A{isA T<X=B>;} class B{} trait T<X>{void test(){#x# b=new #x#();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("#x# b=new #x#();",
				model.getUmpleClass("A").getMethod(0).getMethodBody().getCodeblock().getCode());

	}

	@Test
	public void templateInCode03Test() {
		String code = "class A{isA T<X=B>;} class B{} trait T<X>{status {on{turnOff -> /{#X# b=new #X#();} off;}off{}}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("B b=new B();", model.getUmpleClass("A").getStateMachine("status").getStartState()
				.getTransition(0).getAction().getCodeblock().getCode());

	}

	@Test
	public void templateInCode04Test() {
		String code = "interface B {  Boolean isEmpty();  void push(String e,String b);}"
				+ "class A{  isA B;  isA TStack <T=String>; }"
				+ "trait TStack<T>{    Boolean isEmpty() {   return true;   }   void push(T e,T b) {  	  } }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(Source.fTrait, model.getUmpleClass("A").getMethod(0).getSource());
		Assert.assertEquals(Source.fTrait, model.getUmpleClass("A").getMethod(1).getSource());

	}

	@Test
	public void InterfaceForTemplates001() {
		String code = "class A{isA T< X = B >;} class B{} interface I{} trait T<X isA I>{}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("205");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void InterfaceForTemplates002() {
		String code = "class A{isA T<X = B1>;} interface I{} trait T<X isA I>{}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("221");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void InterfaceForTemplates003() {
		String code = "class A{isA T<X = B>;} class B{} interface I{} interface II{} trait T<X isA I & II>{}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleTrait(0).getGeneralTemplateParameter(0).numberOfInterfacesAndClass());

	}

	@Test
	public void InterfaceForTemplates004() {
		String code = "class A{isA T1;} interface I{} trait T<X isA I>{} trait T1{ isA T<X=B>;}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("221");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void InterfaceForTemplates005() {
		String code = "class A{isA T1;} class B{} interface I{} trait T<X isA I>{} trait T1{ isA T<X=B>;}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("205");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void InterfaceForTemplates006() {
		String code = "class A{isA T<X = C>;} class B{isA I;} class C{isA B;} interface I{} trait T<X isA I >{X ins;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("C", model.getUmpleClass(0).getAttribute(0).getType());

	}

	@Test
	public void RequiredInterfaces001() {
		String code = "class A{isA T;isA I;} interface I{} interface II{} trait T{isA I;isA II;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleTrait(0).numberOfRequiredInterfaces());

	}

	@Test
	public void RequiredInterfaces002() {
		String code = "class A{isA T;} interface I{} trait T{isA I;}";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("222");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void RequiredInterfaces003() {
		String code = "class A{isA T;} interface I{} trait ST{isA I;}trait T{isA ST;} ";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("222");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void RequiredInterfaces004() {
		String code = "class A{abstract; isA T;} interface I{} trait T{isA I;} ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfParentInterface());
	}

	@Test
	public void semanticAnalysisTemplateRestriction001() {
		String code = "class A{isA T<X=B>;} class B{} trait T<X isA C>{} ";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("223");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void semanticAnalysisTemplateRestriction002() {
		String code = "class A{isA T<X=B>;} class B{} class C{} trait T<X isA B&C>{} ";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("224");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	@Test
	public void semanticAnalysisTemplateRestriction003() {
		String code = "class A{isA T<X=B>;} class B{} class C{} trait T<X isA C>{} ";
		UmpleModel model = getModel(code);
		boolean happened = false;
		try {
			model.run();
		} catch (Exception e) {
			happened = e.getMessage().contains("225");
		} finally {
			Assert.assertTrue(happened);
			SampleFileWriter.destroy("traitTest.ump");
		}
	}

	// -------------------------------------------------------------------------------------
	// ----------------------- Functional methods for this test case
	// -----------------------
	private UmpleModel getRunModel(String inCode) {
		SampleFileWriter.createFile("traitTest.ump", inCode);
		UmpleFile uFile = new UmpleFile("traitTest.ump");
		uMode = new UmpleModel(uFile);
		uMode.setShouldGenerate(false);
		try {
			uMode.run();
		} catch (Exception e) {
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}
		return uMode;
	}

	private UmpleModel getRunModelByFilename(String filename) {
		UmpleFile uFile = new UmpleFile(defaultPath, filename);
		uMode = new UmpleModel(uFile);
		uMode.setShouldGenerate(false);
		try {
			uMode.run();
		} catch (Exception e) {
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}
		return uMode;
	}

	/*
	 * This function is used to fetch a model from a string including umple
	 * code. It's used when the example is small and there is no need to create
	 * an external file.
	 */
	private UmpleModel getModel(String inCode) {
		SampleFileWriter.createFile("traitTest.ump", inCode);
		UmpleFile uFile = new UmpleFile("traitTest.ump");
		uMode = new UmpleModel(uFile);
		return uMode;
	}

	/*
	 * This function is used to fetch a model from a Umple file. It's used when
	 * the example is big and there is a need to keep it organized for more
	 * exploration.
	 */

	private UmpleModel getModelByFilename(String fileName) {
		UmpleFile uFile = new UmpleFile(defaultPath, fileName);
		uMode = new UmpleModel(uFile);
		uMode.setShouldGenerate(false);
		return uMode;
	}
}