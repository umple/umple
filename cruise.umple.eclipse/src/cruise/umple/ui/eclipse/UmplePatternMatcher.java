package cruise.umple.ui.eclipse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.ui.console.FileLink;

public class UmplePatternMatcher implements IPatternMatchListenerDelegate{
	protected TextConsole fConsole;
	public UmplePatternMatcher()
	{		
	  //System.out.println("loading");
	}
	public void connect(TextConsole console) {
		  fConsole= console;
	}
	public void disconnect() {
		fConsole = null;
	}
	private IFile search(IFolder folder, String filename)
	{
		if(folder.isHidden()||folder.isDerived()||folder.isPhantom())
		{
		  return null;
		}
		for(java.io.File f: new java.io.File(folder.getLocationURI().getPath()).listFiles())
    	{
    		if(f.isDirectory())
    	    {
    		  return search(folder.getFolder(f.getName()),filename);
    		  
    	    }
    		else
    		{
    		  if(f.getName().equals(filename))
    		  {
    			return folder.getFile(filename);    			
    		  }
    		}		    		
    	}
	  return null;
	}
	public void matchFound(PatternMatchEvent event) {
		if(fConsole!=null){
		  int eventOffset= event.getOffset();
		  int eventLength= event.getLength();
		  IDocument document= fConsole.getDocument();
		  String matchedText= null;
		  
		  try {
		    matchedText= document.get(eventOffset, eventLength);
		    String filename = matchedText.split(":")[0];
		    //ResourcesPlugin.getWorkspace().getRoot().findMember("/test/src/");
		    String filepath = "";
		    IFile file = null;
		    for(IProject p: ResourcesPlugin.getWorkspace().getRoot().getProjects())
		    {		    	
		    	for(java.io.File f: new java.io.File(p.getLocationURI().getPath()).listFiles())
		    	{
		    		if(f.isDirectory())
		    	    {
		    		  file = search(p.getFolder(f.getName()),filename);
		    		  if(file!=null)
			    	  {
			    		break;
			          }
		    	    }
		    		else
		    		{
		    		  if(f.getName().equals(filename))
		    		  {
		    			file = p.getFile(filename);
		    			break;
		    		  }
		    		}		    		
		    	}
		    	if(file!=null)
	    		{
	    		  break;
	    		}
		    }
			
		    FileLink fileLink = new FileLink(file, null, -1, -1, Integer.parseInt(matchedText.split(":")[1]));
		    (fConsole).addHyperlink(fileLink, eventOffset, eventLength);
		  } catch (BadLocationException e){
		    e.printStackTrace();
		  } 
		}
    }
}
