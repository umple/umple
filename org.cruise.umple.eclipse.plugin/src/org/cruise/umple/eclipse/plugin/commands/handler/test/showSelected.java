package org.cruise.umple.eclipse.plugin.commands.handler.test;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class showSelected implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		 ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
	    if (selection != null & selection instanceof IStructuredSelection) {
	      IStructuredSelection strucSelection = (IStructuredSelection) selection;
	      for (Iterator<Object> iterator = strucSelection.iterator(); iterator
	          .hasNext();) {
	        Object element = iterator.next();
	        System.out.println(element.toString());
	      }
	    }
		return null;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

	@Override
	public boolean isHandled() {
		
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
