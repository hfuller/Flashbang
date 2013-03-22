package edu.uah.its.tag;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressWindow extends JFrame {
	
	private JProgressBar progressBar;
	
	public ProgressWindow() {
		
		setLayout(new BorderLayout());
		
		setTitle("Simple example");
		setSize(400, 100);
		setLocationRelativeTo(null);
		
		progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setString("Loading");
        
        add(progressBar,BorderLayout.CENTER);
		
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
        } else if ( "description" == evt.getPropertyName() ) {
        	progressBar.setString((String) evt.getNewValue());
        }
        
    	//now show us in case we are hidden
		if ( !this.isVisible() ) this.setVisible(true);
	
    }

}
