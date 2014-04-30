package cruise.tracer.test.Console;

import java.io.PrintStream;
import org.junit.*;

@Ignore
public class ConsoleTracerTemplateTest
{
	PrintStream defaultPS;

	@Before
	public void setUp()
	{
		defaultPS = System.err;
	}

	@After
	public void cleanUp()
	{
		System.setErr(defaultPS);
	}
}
