package edu.uah.its.tag;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public Flashbang() {
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
	    String[] testData = {"one","two","three"};
	    JList repoList = new JList(testData);
	    repoSelectorPanel.add(repoList,BorderLayout.CENTER);
	    selectorsPanel.add(repoSelectorPanel);
    		    
	    JPanel driveSelectorPanel = new JPanel();
	    driveSelectorPanel.setLayout(new BorderLayout());
	    driveSelectorPanel.add(new JLabel("Drives:"),BorderLayout.NORTH);
	    JList flashDriveList = new JList(new FlashDriveListModel());
	    driveSelectorPanel.add(flashDriveList,BorderLayout.CENTER);
	    selectorsPanel.add(driveSelectorPanel);
    	
    	getContentPane().add(selectorsPanel,BorderLayout.CENTER);
    	getContentPane().add(quitButton,BorderLayout.PAGE_END);
		
    	
		setTitle("Simple example");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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