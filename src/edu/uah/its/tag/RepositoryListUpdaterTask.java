package edu.uah.its.tag;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

import javax.swing.SwingWorker;

public class RepositoryListUpdaterTask extends SwingWorker<Void, Void> {

	private final static Logger logger = Logger.getLogger(RepositoryUpdaterTask.class .getName());
	
	private RepositoryListModel theModel = null;
	
	
	public RepositoryListUpdaterTask(RepositoryListModel m) {
		theModel = m;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		setProgress(0);
		
		for ( Object r : theModel ) {
			RepositoryUpdaterTask task = new RepositoryUpdaterTask((Repository) r);
			task.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					logger.finest("Got property change event " + arg0.getNewValue());
					if ( arg0.getNewValue() == SwingWorker.StateValue.DONE ) {
						RepositoryListUpdaterTask.this.setProgress(50); //not sure this works even but it's time to leave for summer :)
					}
				}
	        });
			task.execute();
		}
		
		return null;
		
	}

}
