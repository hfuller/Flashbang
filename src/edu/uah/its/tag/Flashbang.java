package edu.uah.its.tag;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Flashbang extends JFrame {

    public Flashbang() {
    	setLayout(new BorderLayout());
        
    	JPanel panel = new JPanel();
    	getContentPane().add(panel,BorderLayout.PAGE_END);
        
        panel.setLayout(null);

	    JButton quitButton = new JButton("Quit");
	    quitButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            System.exit(0);
	       }
	    });
			    
	    JButton tempButton1 = new JButton("Temp1");
		
		//panel.add(quitButton);
		    
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