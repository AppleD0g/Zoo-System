package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionScreen extends JFrame implements ActionListener{

	/**
	 * 
	 */
	JButton logoutButton, zooButton, createButton, viewButton;
	private static final long serialVersionUID = 1L;

	SelectionScreen() {
		
		
		logoutButton = new JButton("Logout"); 
		logoutButton.addActionListener(this);
		viewButton = new JButton("View Animal Profile");
		viewButton.addActionListener(this);
		createButton = new JButton("Create Animal Profile");
		createButton.addActionListener(this);
		zooButton = new JButton("View Zoo Map");
		zooButton.addActionListener(this);
		
		
		Font f = new Font("Arial",Font.BOLD,25);
		viewButton.setFont(f);
		viewButton.setForeground(Color.WHITE);
		viewButton.setBackground(Color.BLACK);
		
	
		logoutButton.setFont(f);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBackground(Color.RED);
		
		zooButton.setFont(f);
		zooButton.setForeground(Color.WHITE);
		zooButton.setBackground(Color.BLACK);
		
	
		createButton.setFont(f);
		createButton.setForeground(Color.WHITE);
		createButton.setBackground(Color.BLACK);
		
		
		JPanel panel1 = new JPanel();
		panel1.add(logoutButton);


		JPanel panel3 = new JPanel();
		panel3.add(viewButton);
		
		JPanel panel4 = new JPanel();
		panel4.add(createButton);
		
		JPanel panel5 = new JPanel();
		panel5.add(zooButton);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 1));
		panel2.add(panel3);
		panel2.add(panel4);
		panel2.add(panel5);
		
		
		Container c = getContentPane();
		c.add(panel1, BorderLayout.NORTH);
		c.add(panel2);

		
		setVisible(true);
		setSize(600, 600);
		setTitle("Login");
	}
	
	
	
	//activate and open the assigned windows after user choose an option
	public void actionPerformed(ActionEvent e) {
		
		
        if(e.getSource()== zooButton) {
        	ZooMap second = new ZooMap();
        	 second.setVisible(true);  
        	 
	}	
		
        
        if(e.getSource()== createButton) {
        	CreateAnimal second = new CreateAnimal();
    		second.setVisible(true);
    		setVisible(false);
	}	
	
        
        
        if(e.getSource()== viewButton) {
        	AnimalProfile second = new AnimalProfile();
    		second.setVisible(true);
    		setVisible(false);
	}	
	
		JFrame frame = new JFrame();

	if (e.getSource()== logoutButton) {
		

		Object[] options = {"Yes", "No"};

		
		int n = JOptionPane.showOptionDialog(frame,"Confirm to logout?","Question", JOptionPane.
		YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
		options[0]);

		if(n == JOptionPane.YES_OPTION){
			setVisible(false);

        JOptionPane.showMessageDialog(frame, "You are logged out", "Message",
        JOptionPane.PLAIN_MESSAGE);
        
		LoginScreen second = new LoginScreen();
		second.setVisible(true);
        }

        if(n == JOptionPane.NO_OPTION){

        
		} 
        
        
	}
			
}
	
	
	
	public static void main (String args[]){
		new SelectionScreen();
		
		
	}
}
