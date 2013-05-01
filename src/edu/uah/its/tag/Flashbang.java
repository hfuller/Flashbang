package edu.uah.its.tag;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Flashbang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 399258204214611992L;
	private Logger logger;

	public Flashbang() {
		
		logger = Logger.getLogger(this.getClass().getPackage().getName());
		logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.finer("Created logger " + this.getClass().getPackage().getName());
        
        //prepare progress window
        final ProgressWindow progressWindow = new ProgressWindow();
        progressWindow.setProgress(10,"Initializing application");
		
		setLayout(new BorderLayout());
        
	    JButton quitButton = new JButton("Quit");
	    quitButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            System.exit(0);
	       }
	    });
			    
    	
	    JPanel selectorsPanel = new JPanel();
	    selectorsPanel.setLayout(new GridLayout(0,2));
	    
	    JPanel repoSelectorPanel = new JPanel();
	    repoSelectorPanel.setLayout(new BorderLayout());
	    repoSelectorPanel.add(new JLabel("Repositories:"),BorderLayout.NORTH);
	    final RepositoryListModel repoListModel = new RepositoryListModel();
	    //reloader thread
	    //(new Thread(new PeriodicReloaderThread(repoListModel,3))).start();
	    JList repoList = new JList(repoListModel);
	    repoSelectorPanel.add(repoList,BorderLayout.CENTER);
	    JButton repoUpdateButton = new JButton("Update repo data");
	    repoUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	progressWindow.setProgress(0,"Updating repositories");
		            }
		        });
				
				//RepositoryUpdaterTask task = new RepositoryUpdaterTask(repoListModel.getElementAt(0));
				RepositoryListUpdaterTask task = new RepositoryListUpdaterTask(repoListModel);
		        task.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						
					}
		        });
		        task.execute();
			}
	    });
	    repoSelectorPanel.add(repoUpdateButton,BorderLayout.SOUTH);
	    selectorsPanel.add(repoSelectorPanel);
    		    
	    
	    JPanel driveSelectorPanel = new JPanel();
	    driveSelectorPanel.setLayout(new BorderLayout());
	    driveSelectorPanel.add(new JLabel("Drives:"),BorderLayout.NORTH);
	    FlashDriveListModel fdListModel = new FlashDriveListModel();
	    
	    //START THE CAPS LOCKED COMMENTS
	    //START THE RELOADER THREAD
	    //(new Thread(new PeriodicReloaderThread(fdListModel,1))).start();
	    
	    JList flashDriveList = new JList(fdListModel);
	    driveSelectorPanel.add(flashDriveList,BorderLayout.CENTER);
	    selectorsPanel.add(driveSelectorPanel);
    	
    	
	    getContentPane().add(selectorsPanel,BorderLayout.CENTER);
    	getContentPane().add(quitButton,BorderLayout.PAGE_END);
		
    	
		setTitle("Simple example");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		progressWindow.setVisible(false);
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Flashbang x = new Flashbang();
                x.setVisible(true);
            }
        });
    }
}