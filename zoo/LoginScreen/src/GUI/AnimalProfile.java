package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import Database.DatabaseClasses;

public class AnimalProfile extends JFrame implements ActionListener {

	JLabel animalNameLabel, animalSpeciesLabel, animalLocationLabel, feedingTimesLabel, caretakerLabel, vetHistoryLabel,
			specialNeedsLabel, animalIDLabel;
	JTextField searchField, animalNameField, animalSpeciesField, animalLocationField, feedingTimesField, caretakerField, vetHistoryField,
			specialNeedsField, animalIDField;
	JButton searchButton, deleteButton, logoutButton, backButton;
	
	JFrame frame;

	private static final long serialVersionUID = 1L;

	AnimalProfile() {
		
		
		JFrame frame = new JFrame();
		 
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(this);
		
		
		// change the style of the labels.
		JLabel createAnimal = new JLabel("Animal Profile", SwingConstants.CENTER);
		createAnimal.setFont(new Font("Tahoma", Font.BOLD, 30));
		createAnimal.setForeground(Color.RED);
		 
		backButton = new JButton("<- Back");
		backButton.addActionListener(this);

		searchField = new JTextField(10);

		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		
		
		animalIDLabel = new JLabel("Animal ID: ");
		animalIDLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		animalIDLabel.setForeground(Color.BLACK);
		
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
		vetHistoryLabel .setFont(new Font("Tahoma", Font.ITALIC, 20));
		vetHistoryLabel .setForeground(Color.BLACK);
		
		specialNeedsLabel = new JLabel("Special Needs: ");
		specialNeedsLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		specialNeedsLabel.setForeground(Color.BLACK);
	    
	    

		animalIDField = new JTextField(20);
		animalNameField = new JTextField(20);
		animalSpeciesField = new JTextField(20);
		animalLocationField = new JTextField(20);
		feedingTimesField = new JTextField(20);
		caretakerField = new JTextField(20);
		vetHistoryField = new JTextField(20);
		specialNeedsField = new JTextField(20);

		deleteButton = new JButton("Delete Profile");
		//updateButton = new JButton("Update Button");
		
		Font f = new Font("Arial",Font.BOLD,25);
		deleteButton.setFont(f);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBackground(Color.BLACK);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 2));
		//bottomPanel.add(updateButton);
		bottomPanel.add(deleteButton);
		
		JPanel searchPanel = new JPanel();
		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 3));
		panel1.add(backButton);
		panel1.add(createAnimal);
		panel1.add(logoutButton);

		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(8, 2));
		bigPanel.add(animalIDLabel);
		bigPanel.add(animalIDField);
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
		mainPanel.add(searchPanel);
		//mainPanel.add(animalNameLabel);
		mainPanel.add(bigPanel);

		Container c = getContentPane();
		c.add(panel1, BorderLayout.NORTH);

		c.add(mainPanel);
		c.add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
		setSize(1000, 1000);
		setTitle("Animal Profile");
		
		deleteButton.addActionListener(this);
	}

	public static void main(String args[]) {
		DatabaseClasses.init();

		new AnimalProfile();

	}
	
	//execute query, database connection
	
	public void theQuery(String query) {
		
	    Connection con = null;
	    Statement st = null;
	    
	    try{
	    	System.out.println(query);
	    	con = DriverManager.getConnection("jdbc:mysql://localhost/zoo","root","root");
	    	st = (Statement) con.createStatement();
	    	st.executeUpdate(query);
	    	JOptionPane.showMessageDialog(null, "Query Executed");
	    }catch(Exception ex){
	    	JOptionPane.showMessageDialog(null,ex.getMessage());
	    	
	    }	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteButton) {  //when the delete button is pressed 
			String name = this.searchField.getText(); //get input text
			
			String sql = "delete from animal where name = '" + name + "'"; //delete animal from database
						
			theQuery(sql); 
		}

		
        if (e.getSource() == backButton) {
        	
        	
        	SelectionScreen second = new SelectionScreen();  //connect window
			second.setVisible(true); //show new opened window
			setVisible(false);  //close the window
			
			
}
		if (e.getSource() == searchButton) {

			String searchName = searchField.getText();

			//
			
			animalIDField.setText(DatabaseClasses.getAnimaID(searchName));

			animalNameField.setText(DatabaseClasses.getAnimalName(searchName));
			
			animalSpeciesField.setText(DatabaseClasses.getSpecies(searchName));

			animalLocationField.setText(DatabaseClasses.getLocation(searchName));

			feedingTimesField.setText(DatabaseClasses.getFeedingTime(searchName));

			caretakerField.setText(DatabaseClasses.getCaretaker(searchName));

			vetHistoryField.setText(DatabaseClasses.getVetHistory(searchName));

			specialNeedsField.setText(DatabaseClasses.getSpecialNeeds(searchName));
		}else{
			
		
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
