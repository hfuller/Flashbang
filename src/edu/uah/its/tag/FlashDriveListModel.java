package edu.uah.its.tag;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;
import javax.swing.filechooser.FileSystemView;

public class FlashDriveListModel extends AbstractListModel implements Refreshable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7680687955346728878L;
	private ArrayList flashDrives;
	private final static Logger logger = Logger.getLogger(FlashDriveListModel.class .getName());
	
	public FlashDriveListModel() {
		this.refresh();
	}

	public void refresh() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] f = File.listRoots();

		//TODO: slow as ****
		flashDrives = new ArrayList();
		for (int i = 0; i < f.length; i++) {
			if ((Boolean)(fsv.getSystemTypeDescription(f[i]).toLowerCase().contains("removable"))) {
				logger.log(Level.FINEST,"Adding flash drive " + (fsv.getSystemTypeDescription(f[i]).toLowerCase() + " " + f[i].toString()));
				flashDrives.add(f[i]);
			}
		}
		fireContentsChanged(this, 0, getSize());
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return flashDrives.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return flashDrives.size();
	}

}
