package org.cruise.umple.eclipse.plugin.editors;

public class Parser {
	public static final String[] KEYWORDS = {
			"class","trait","interface","association","associationClass","namespace",
			"use","isA","const","lazy","settable","internal","autounique","defaulted",
			"after","before","--","->","<-","<@>-","-<@>","sorted","return",
			"entry","do","exit","queued","pooled","||","active",
			"singleton","immutable","trace", "external","depend"};
	public static final String[] KEYWORDS_TYPES = {"String","Boolean","Integer","Double","Float","void","Date","Time"};
	public static final String[] KEYWORDS_VISIBILITY = {"public","private","protected"};
	public static final String[] KEYWORDS_LANGUAGES = {"Java","Php","Cpp","Ruby"};
}
