package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class UMPWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
