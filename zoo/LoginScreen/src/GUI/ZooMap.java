package GUI;
 
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.BorderLayout;




public class ZooMap implements ActionListener{




 ImageIcon image;
 JLabel label;
 JPanel panel;
 JFrame frame;

 
 // this programs shows a static map of the zoo

	ZooMap() {
		
	frame = new JFrame("Zoo Map");


	image = new ImageIcon("zoo.jpg");
	label = new JLabel(image);
    panel = new JPanel(new BorderLayout());
    panel.add(label, BorderLayout.CENTER);
 
		

	    
		frame.getContentPane().add(panel, BorderLayout.CENTER);	
		frame.setSize(600, 600);
		frame.setVisible(true);
		

		
	}

	public static void main (String args[]){
		try {
			String current = new File(".").getCanonicalPath();
			System.out.println(current);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new ZooMap();
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

			
			
}

	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
