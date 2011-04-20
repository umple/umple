package cruise.umple.ui.eclipse.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class UmpleWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
