package org.cruise.umple.eclipse.plugin.editors;

import java.util.Enumeration;
import java.util.*;
import java.util.ResourceBundle;

public class UmpResourceBoundle extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		return Collections.enumeration(Arrays.asList("ContentAssistProposal.label","ContentAssistProposal.tooltip","ContentAssistProposal.description"));
	}

	@Override
	protected Object handleGetObject(String arg0) {
		// TODO Auto-generated method stub
		if (arg0.equals("ContentAssistProposal.label")) return "Content assist";
		if (arg0.equals("ContentAssistProposal.tooltip")) return "Content assist";
		if (arg0.equals("ContentAssistProposal.description")) return "Provides Content Assistanc";
		return null;
	}

}
