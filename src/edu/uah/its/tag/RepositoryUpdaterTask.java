package edu.uah.its.tag;

import java.io.File;
import java.util.logging.Logger;

import javax.swing.SwingWorker;

public class RepositoryUpdaterTask extends SwingWorker<Void, Void> {

	private String path, repoPath;
	private File dir, repoDir;
	
	private Repository repo;
	
	private final static Logger logger = Logger.getLogger(PeriodicReloaderThread.class .getName());
	
	public RepositoryUpdaterTask(Repository r) {
		repo = r;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		setProgress(5);
		
		path = "./repo_data";
		dir = new File(path);
		
		if ( !dir.exists() ) {
			dir.mkdir();
		}
		
		repoPath = path + "/" + repo.getName();
		repoDir = new File(repoPath);
		
		if ( !repoDir.exists() ) {
			repoDir.mkdir();
		}
		
		logger.fine("Prepared to update repo_data for " + repo.getName());
		setProgress(10);
		
		return null;
	}

}
