package GUI;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;



import Database.DatabaseClasses;
import Database.sqlengine;

public class LoginScreen extends JFrame implements ActionListener{
	

	JTextField username;
	JPasswordField password;
	JButton loginButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LoginScreen() {
		
		JFrame frame = new JFrame();
		
		
		//set text style
		JLabel usernameLabel = new JLabel("Username: ");
		username = new JTextField(20);
	    usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	    usernameLabel.setForeground(Color.BLACK);
	    username.setBackground(Color.GRAY);
		JLabel passwordLabel = new JLabel("Password: ");
		password = new JPasswordField(20);	
	    passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	    passwordLabel.setForeground(Color.BLACK);
	    password.setBackground(Color.GRAY);
	    
	    
	    Font fieldFont = new Font("Arial", Font.PLAIN, 20);
        username.setFont(fieldFont);
        username.setBackground(Color.white);
        username.setForeground(Color.gray.brighter());
        username.setColumns(10);

        password.setFont(fieldFont);
        password.setBackground(Color.white);
        password.setForeground(Color.gray.brighter());
        password.setColumns(10);
	    
		loginButton = new JButton("Login");
		//loginButton.setSize(500,400);
		
		Font f = new Font("Arial",Font.BOLD,25);
		loginButton.setFont(f);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		
		
		loginButton.addActionListener(this);
		this.getRootPane().setDefaultButton(loginButton); 
		frame.getRootPane().setDefaultButton(loginButton); 
		//allow enter key to behave like loginButton.

		


		
		loginButton = new JButton("Login");
		
		loginButton.addActionListener(this);
		loginButton.setFont(f);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		
		JPanel panel1 = new JPanel();
		panel1.add(usernameLabel);
		panel1.add(username);
		
		JPanel panel2 = new JPanel();
		panel2.add(passwordLabel);
		panel2.add(password);
		
		JPanel panel3 = new JPanel();
		panel3.add(loginButton);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 1));
		c.add(panel1);
		c.add(panel2);
		c.add(panel3);

		setVisible(true);
		setSize(600, 600);
		setTitle("Login");
	}
	
	public static void main (String args[]){
		DatabaseClasses.init();
		
		new LoginScreen();
		
	}

	public void actionPerformed(ActionEvent e) {

		
		// TODO Auto-generated method stub
		if (e.getSource()== loginButton) {
			
			String uname = username.getText();
			String pass = new String (this.password.getPassword());
			String correctUser = DatabaseClasses.getUsername(uname);
			String correctPass = DatabaseClasses.getPassword(pass);

			if (uname.equals(correctUser)) {
				if (pass.equals(correctPass)) {
					JOptionPane.showMessageDialog(null, "Login successful", "", JOptionPane.INFORMATION_MESSAGE);

					System.out.println("Login successful");
					
					setVisible(false);
					
					SelectionScreen second = new SelectionScreen();
					second.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
					System.out.println("Incorrect Password");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Incorrect Username ");
			}
			
			
		}
	}
}
