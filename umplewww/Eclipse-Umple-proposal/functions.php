<? 
/*******************************************************************************
 * Copyright (c) 2007 Eclipse Foundation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Wayne Beaton (Eclipse Foundation)- initial API and implementation
 *******************************************************************************/

function get_title_from_html_document($file_name) {
	$header = get_header_from_html_document($file_name);
	
	/*
	 * Break the header up into multiple lines. Handle the
	 * case where line breaks are lf, crlf, or cr.
	 */
	
	$lines = preg_split("/\r?\n|\r/", $header); 
	
	/*
	 * Merge the lines into a single line so that eregi
	 * can find the title even if it is split over multiple
	 * lines
	 */
	$one_line = implode(" ", $lines); 
	
	/*
	 * If we can match a title tag, extract it.
	 */
	if (eregi("<title>(.*)</title>", $one_line, $title)) {
    	return $title[1];
	}
	
	return "An Eclipse Proposal";
}

function get_header_from_html_document(&$file_name) {
	$handle = @fopen($file_name, "r");
	$content = "";
    while (!feof($handle)) {
        $part = fread($handle, 1024);
        $content .= $part;
        
        /*
         * Only read up to the part that includes the
         * end tag for the header area.
         */
        if (eregi("</head>", $part)) break;
    }
    fclose($handle);
    return $content;
}