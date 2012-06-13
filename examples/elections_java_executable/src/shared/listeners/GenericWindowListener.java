/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

*/

package shared.listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import usecase.addElection.AddElectionController;
import usecase.addPoll.AddPollController;
import usecase.startup.Controller;
import view.addElection.AddElectionView;
import usecase.addPoll.AddPollController;
import usecase.addElection.AddElectionController;

public enum GenericWindowListener implements WindowListener {
	AddElectionViewWindowListener,
	AddPollViewWindowListener,
	AddPositionViewWindowListener,
	AssignPositionElectionViewWindowListener,
	RegisterCandidateViewWindowListener,
	MainViewWindowListener;

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		Controller.getInstance().start();
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		if (name().compareTo("AddElectionViewWindowListener")==0) {
			AddElectionController.getInstance().closeView();
		} else if (name().compareTo("AddPollViewWindowListener")==0) {
			AddPollController.getInstance().closeView();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
