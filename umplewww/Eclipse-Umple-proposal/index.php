<?php  																														require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/app.class.php");	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/nav.class.php"); 	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/menu.class.php"); 	$App 	= new App();	$Nav	= new Nav();	$Menu 	= new Menu();		include($App->getProjectCommon());    # All on the same line to unclutter the user's desktop'

require_once("functions.php");
$proposal_title = get_title_from_html_document("proposal.html");

$pageTitle 		= $proposal_title;
$pageKeywords	= "Eclipse, proposal";
$pageAuthor		= "";


ob_start();
?>
<div id="maincontent">
	<div id="midcolumn">
	
		<h1><?= $proposal_title ?></h1>
	
		<?php
			include_once($_SERVER['DOCUMENT_ROOT'] . "/projects/fragments/proposal-page-header.php");
			generate_header($proposal_title);
			
			include("proposal.html");
		?>
	</div>
</div>
<?php
$html = ob_get_contents();
ob_end_clean();

# Generate the web page
$App->generatePage($theme, $Menu, $Nav, $pageAuthor, $pageKeywords, $pageTitle, $html);
?>
