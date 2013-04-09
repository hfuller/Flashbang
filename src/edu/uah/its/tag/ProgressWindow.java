package edu.uah.its.tag;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressWindow extends JFrame {
	
	private final static Logger logger = Logger.getLogger(PeriodicReloaderThread.class .getName());
		
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
	
	public void setProgress(final int p) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	progressBar.setValue(p);
            	ProgressWindow.this.setVisible(true);
            }
		});
	}
	public void setDescription(final String d) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	progressBar.setString(d);
            }
		});
	}
	public void setProgress(int p, String d) {
		this.setProgress(p); this.setDescription(d);
	}
	public void setVisible(final boolean b) {
		logger.finer("setVisible " + b);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ProgressWindow.super.setVisible(b);
            }
		});
	}
//	public void setVisible(final boolean b) {
//		logger.finer("setVisible " + b);
//		SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//				if (b) {
//					ProgressWindow.super.setVisible(b);
//					ProgressWindow.this.setAlwaysOnTop(b);
//				} else {
//					ProgressWindow.this.setAlwaysOnTop(b);
//					ProgressWindow.super.setVisible(b);
//				}
//            }
//		});
//	}

}
