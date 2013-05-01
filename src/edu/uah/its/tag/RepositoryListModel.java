package edu.uah.its.tag;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;

public class RepositoryListModel extends AbstractListModel implements Refreshable, Iterable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5704442921620379584L;
	private String path;
	private File dir;
	private File[] files;
	private ArrayList<Repository> repos;
	
	private Logger logger;
	
	public RepositoryListModel() {
		
		logger = Logger.getLogger(this.getClass().getPackage().getName());

		path = "./repo";
		
		dir = new File(path);
		repos = new ArrayList<Repository>();
		
		this.refresh();
	}

	@Override
	public void refresh() {
		files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {

			if (files[i].isFile()) {
				logger.fine("Repository file: " + files[i].toString());
				repos.add(new Repository(files[i]));
			}
		}
	}

	@Override
	public Repository getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return repos.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return repos.size();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return repos.iterator();
	}

}
