/*
  @(#)package.html	1.60 98/01/27

 * Copyright (c) 2009 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
*/

/**
Provides a patched version of the <a href="http://nanoxml.cyberelf.be/">NanoXML</a>
XML library.
<p>
NanoXML is a small XML parser for Java.
<p>
NanoXML is included here, to provide a fast and easy to XML parser which
can be used by security restricted Java Applets.
<p>
With this patched version, NanoXML has been made to be compilable with J2SE5
and to take advantage of the Java2 Collections API. 
<p>
NanoXML has been changed to not open a network connection to retrieve the DTD of
a document. This reduces the time needed to read an XML document and it
allows to open XML documents when a computer is offline, or when a Java applet
runs in a restricted environment that doesn't allow connections to the computer
hosting the DTD.

*/
package net.n3.nanoxml;