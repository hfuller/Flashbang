package edu.uah.its.tag;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PeriodicReloaderThread implements Runnable {
	
	private Refreshable theObject;
	private int theInterval;
	private final static Logger logger = Logger.getLogger(PeriodicReloaderThread.class .getName());
	
	public PeriodicReloaderThread(Object b, int in) {
		
		this.theObject = (Refreshable) b;
		this.theInterval = in;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			try {
		        Thread.sleep(theInterval*2000);
		    } catch (InterruptedException e) {
		        return;
		    }
			logger.log(Level.FINER,"Initiating reload of " + theObject.toString());
			theObject.refresh();
			
		}
		
	}

}
