package edu.uah.its.tag;

import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.filechooser.FileSystemView;

public class FlashDriveListModel extends AbstractListModel {
	
	private ArrayList flashDrives;
	
	public FlashDriveListModel() {
		flashDrives = new ArrayList();
		this.refresh();
	}

	public void refresh() {
		// TODO Auto-generated method stub
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] roots = fsv.getRoots();
		File[] f = File.listRoots();
		for (int i = 0; i < f.length; i++) {
			if ((Boolean)(fsv.getSystemTypeDescription(f[i]).toLowerCase().contains("removable"))) {
				flashDrives.add(f[i]);
			}
		}
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
