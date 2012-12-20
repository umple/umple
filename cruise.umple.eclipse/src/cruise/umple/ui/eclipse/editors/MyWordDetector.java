package cruise.umple.ui.eclipse.editors;

import org.eclipse.jface.text.rules.IWordDetector;

public class MyWordDetector implements IWordDetector
{

	public boolean isWordPart(char c)
	{
		return (c > ' ') && (c <= '~');
	}

	public boolean isWordStart(char c)
	{
		return (c > ' ') && (c <= '~');
	}

}
