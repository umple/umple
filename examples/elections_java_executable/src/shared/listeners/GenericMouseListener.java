package shared.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import usecase.addPoll.AddPollController;
import usecase.addPosition.AddPositionController;
import usecase.addElection.AddElectionController;
import usecase.startup.Controller;
import view.main.MainView;

public enum GenericMouseListener implements MouseListener {
	AddElectionViewMouseListener,
	AddPollViewMouseListener,
	AddPositionViewMouseListener,
	MainViewMouseListener;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (name().compareTo("AddElectionViewMouseListener")==0) {
			AddElectionController.getInstance().addButtonClicked();
		} else if (name().compareTo("AddPollViewMouseListener")==0) {
			AddPollController.getInstance().addButtonClicked();
		} else if (name().compareTo("AddPositionViewMouseListener")==0) {
			AddPositionController.getInstance().addButtonClicked();
		} else if (name().compareTo("MainViewMouseListener")==0) {
			String task=MainView.getInstance().getSelectedTask();
			if (task.compareTo("Open Poll")==0)
				Controller.getInstance().openPoll();
			else if (task.compareTo("Add Election")==0)
				Controller.getInstance().addElection();
			else if (task.compareTo("Add Poll")==0)
				Controller.getInstance().addPoll();
			else if (task.compareTo("Add Position")==0)
				Controller.getInstance().addPosition();
			else
				Controller.getInstance().quit();
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
