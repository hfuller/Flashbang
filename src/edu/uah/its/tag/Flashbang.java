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
        
	    JButton quitButton = new JButton("Quit");
	    quitButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            System.exit(0);
	       }
	    });
			    
    	
	    JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(0,2));
    	
    	JButton tempButton1 = new JButton("Temp1");
	    JButton tempButton2 = new JButton("Temp2");
	    getContentPane().add(tempButton1,BorderLayout.PAGE_END);
		getContentPane().add(tempButton2,BorderLayout.PAGE_START);
		
		getContentPane().add(panel,BorderLayout.PAGE_END);
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