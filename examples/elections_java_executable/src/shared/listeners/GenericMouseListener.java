package shared.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import usecase.addPoll.AddPollController;
import usecase.addElection.AddElectionController;

public enum GenericMouseListener implements MouseListener {
	AddElectionViewMouseListener,
	AddPollViewMouseListener;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (name().compareTo("AddElectionViewMouseListener")==0) {
			AddElectionController.getInstance().addButtonClicked();
		} else if (name().compareTo("AddPollViewMouseListener")==0) {
			AddPollController.getInstance().addButtonClicked();
		} 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
