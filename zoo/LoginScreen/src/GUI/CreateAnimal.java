package GUI;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateAnimal extends JFrame implements ActionListener {

	JLabel animalNameLabel, animalSpeciesLabel, animalLocationLabel, feedingTimesLabel, caretakerLabel, vetHistoryLabel, idLabel,
			specialNeedsLabel;
	JTextField animalNameField, animalSpeciesField, animalLocationField, feedingTimesField, caretakerField, vetHistoryField, idField,
			specialNeedsField;
	
	JButton backButton, logoutButton, createButton, insertButton;

	private static final long serialVersionUID = 1L;
	private static final Component frame = null;

	CreateAnimal() {
		 logoutButton = new JButton("Logout");
		// logoutButton.addActionListener(this);
		 
		 JFrame frame = new JFrame();
		 
		JLabel createAnimal = new JLabel("Ceate Animal Profile", SwingConstants.CENTER);
		createAnimal.setFont(new Font("Tahoma", Font.BOLD, 30));
		createAnimal.setForeground(Color.RED);
		
		backButton = new JButton("<- Back");
		backButton.addActionListener(this);
		
	
		
		//change the style of the labels
		idLabel = new JLabel("ID: ");
		idLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		idLabel.setForeground(Color.BLACK);

		animalNameLabel = new JLabel("Name: ");
		animalNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		animalNameLabel.setForeground(Color.BLACK);

		animalSpeciesLabel = new JLabel("Species: ");
		animalSpeciesLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		animalSpeciesLabel.setForeground(Color.BLACK);
		
		animalLocationLabel = new JLabel("Location: ");
		animalLocationLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		animalLocationLabel.setForeground(Color.BLACK);
		
		feedingTimesLabel = new JLabel("Feeding Times: ");
		feedingTimesLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		feedingTimesLabel.setForeground(Color.BLACK);
		
		caretakerLabel = new JLabel("Caretaker: ");
		caretakerLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		caretakerLabel.setForeground(Color.BLACK);
		
		vetHistoryLabel = new JLabel("Vet History: ");
		vetHistoryLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		vetHistoryLabel.setForeground(Color.BLACK);
		
		specialNeedsLabel = new JLabel("Special Needs: ");
		specialNeedsLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		specialNeedsLabel.setForeground(Color.BLACK);
		
		idField = new JTextField(20);
		animalNameField = new JTextField(20);
		animalSpeciesField = new JTextField(20);
		animalLocationField = new JTextField(20);
		feedingTimesField = new JTextField(20);
		caretakerField = new JTextField(20);
		vetHistoryField = new JTextField(20);
		specialNeedsField = new JTextField(20);

		//createButton = new JButton("Create Profile");
		
		insertButton = new JButton("Create");
		
		Font f = new Font("Arial",Font.BOLD,25);
		insertButton.setFont(f);
		insertButton.setForeground(Color.WHITE);
		insertButton.setBackground(Color.BLACK);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 3));
		panel1.add(backButton);
		panel1.add(createAnimal);
		panel1.add(logoutButton);
		logoutButton.addActionListener(this);
		panel1.add(insertButton);

		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(8, 2));
		bigPanel.add(idLabel);
		bigPanel.add(idField);
		bigPanel.add(animalNameLabel);
		bigPanel.add(animalNameField);
		bigPanel.add(animalSpeciesLabel);
		bigPanel.add(animalSpeciesField);
		bigPanel.add(animalLocationLabel);
		bigPanel.add(animalLocationField);
		bigPanel.add(feedingTimesLabel);
		bigPanel.add(feedingTimesField);
		bigPanel.add(caretakerLabel);
		bigPanel.add(caretakerField);
		bigPanel.add(vetHistoryLabel);
		bigPanel.add(vetHistoryField);
		bigPanel.add(specialNeedsLabel);
		bigPanel.add(specialNeedsField);

		bigPanel.setPreferredSize(new Dimension(900, 600));

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(bigPanel);
		//mainPanel.add(createButton);
		mainPanel.add(insertButton);

		Container c = getContentPane();
		c.add(panel1, BorderLayout.NORTH);

		c.add(mainPanel);
		
		
		//database connection where inserted animal detail is equal to titles in animal database
		insertButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					theQuery("insert into animal(animalID,name,species,location,feedingtime,caretaker,vetHistory,specialNeeds) values('"+idField.getText()+"',"
							+ "'"+animalNameField.getText()+"',"
							+ "'"+specialNeedsField.getText()+"','"+
				animalLocationField.getText()+"','"+feedingTimesField.getText()+"','"+caretakerField.getText()
				+"','"+vetHistoryField.getText()+"','"+specialNeedsField.getText()+"')"); //input entered information to textfield
							
				}catch(Exception ex){}
			}
		});
		
//		createButton.addActionListener(new ActionListener(){
//			
//			public void actionPerformed(ActionEvent e){
//				try{
//					
//				theQuery("update animal='"+idField.getText()+"','"+animalNameField.getText()+"','"+animalSpeciesField.getText()+"','"+
//				animalLocationField.getText()+"','"+feedingTimesField.getText()+"','"+caretakerField.getText()
//				+"','"+vetHistoryField.getText()+"','"+specialNeedsField.getText()+");");
//				}
//			catch(Exception ex){}
//			
//			}		
//		});

		setVisible(true);
		setSize(1000, 1000);
		setTitle("Animal Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//database connection

	public void theQuery(String query) {
		
	    Connection con = null;
	    Statement st = null;
	    
	    try{
	    	System.out.println(query);
	    	con = DriverManager.getConnection("jdbc:mysql://localhost/zoo","root","root");
	    	st = (Statement) con.createStatement(); //create database info
	    	st.executeUpdate(query); //update database
	    	JOptionPane.showMessageDialog(null, "Query Executed"); //pops up when database has successfully connected and executed
	    }catch(Exception ex){
	    	JOptionPane.showMessageDialog(null,ex.getMessage());
	    	
	    }	
	}
	
	public static void main(String args[]) {
		new CreateAnimal();

	}




	    
	


	@Override
	
	//logoutButton.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		
		
		
		// TODO Auto-generated method stub
      

		
		if (e.getSource()== backButton) {
        	
        	
        	SelectionScreen second = new SelectionScreen(); //connection windows
			second.setVisible(true); //open SelectionScreen other window
			setVisible(false); //set CreateAnimal window visible
		
			
			
		}else{
			
			// simple logout notice. opens when logout button is clicked
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
	}
}



		
		







