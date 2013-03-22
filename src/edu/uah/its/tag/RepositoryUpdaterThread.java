package edu.uah.its.tag;

import java.io.File;
import java.util.logging.Logger;

public class RepositoryUpdaterThread implements Runnable {

	private String path, repoPath;
	private File dir, repoDir;
	
	private Repository repo;
	
	private final static Logger logger = Logger.getLogger(PeriodicReloaderThread.class .getName());
	
	public RepositoryUpdaterThread(Repository r) {
		repo = r;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
		
	}

}
