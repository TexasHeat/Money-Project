import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Register {

	private JFrame frmRegisterNewUser;
	private JTextField lntextField;
	private JTextField fntextField;
	private JTextField phonetextField;
	private JTextField usernametextField;
	private JTextField passwordtextField;
	private JTextField passwordtextField_2;
	private Connection con;

	private int userID = 0, userChoice = 0, userTracker = 0;
	private double userMoney = 0.00;
	
	/**
	 * Launch the application.
	 */
	public static void NewProfile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmRegisterNewUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	
	
	
	public Register() throws ClassNotFoundException {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		/*
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		*/		
		
		frmRegisterNewUser = new JFrame();
		frmRegisterNewUser.setFont(new Font("Dialog", Font.BOLD, 12));
		frmRegisterNewUser.setTitle("Register New User");
		frmRegisterNewUser.setBounds(100, 100, 532, 685);
		frmRegisterNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegisterNewUser.getContentPane().setLayout(null);
		
		JTextArea txtrThisScreenWill = new JTextArea();
		txtrThisScreenWill.setLineWrap(true);
		txtrThisScreenWill.setText("Basic information about yourself.");
		txtrThisScreenWill.setBounds(10, 11, 496, 29);
		frmRegisterNewUser.getContentPane().add(txtrThisScreenWill);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(10, 51, 86, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(106, 51, 86, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(",");
		lblNewLabel_2.setBounds(98, 79, 46, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(263, 51, 86, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_3);
				
		lntextField = new JTextField();
		lntextField.setBounds(10, 76, 86, 20);
		frmRegisterNewUser.getContentPane().add(lntextField);
		lntextField.setColumns(10);
		
		fntextField = new JTextField();
		fntextField.setBounds(106, 76, 86, 20);
		frmRegisterNewUser.getContentPane().add(fntextField);
		fntextField.setColumns(10);
		
		phonetextField = new JTextField();
		phonetextField.setBounds(263, 76, 86, 20);
		frmRegisterNewUser.getContentPane().add(phonetextField);
		phonetextField.setColumns(10);
		/*
		JButton saveBasicButton = new JButton("Save");
		saveBasicButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if () {
					try {
						Statement st = con.createStatement();
						String query = "UPDATE usermoney SET firstName = '"+ fntextField.getText() +"' WHERE eid = "+ eidtextField.getText() +"";
						st.executeUpdate(query);
						
						JOptionPane.showMessageDialog(frame,
							    "Saved Basic Info.");

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		saveBasicButton.setBounds(10, 107, 89, 23);
		frmRegisterNewUser.getContentPane().add(saveBasicButton);
		*/
						
		JTextArea txtrWhyYouWant = new JTextArea();
		txtrWhyYouWant.setText("Why you want to save and how often you want to save.");
		txtrWhyYouWant.setLineWrap(true);
		txtrWhyYouWant.setBounds(10, 174, 496, 29);
		frmRegisterNewUser.getContentPane().add(txtrWhyYouWant);
				
		JTextArea txtrThisShouldBe = new JTextArea();
		txtrThisShouldBe.setText("This should equal 3 months worth of your total spending. This is used in the case of an emergency or job loss.");
		txtrThisShouldBe.setLineWrap(true);
		txtrThisShouldBe.setBounds(10, 260, 166, 119);
		frmRegisterNewUser.getContentPane().add(txtrThisShouldBe);
			
		JTextArea txtrThisShouldEqual = new JTextArea();
		txtrThisShouldEqual.setText("This should equal a down payment on a car/house. It is common to have to make a down payment before purchasing.");
		txtrThisShouldEqual.setLineWrap(true);
		txtrThisShouldEqual.setBounds(183, 260, 166, 119);
		frmRegisterNewUser.getContentPane().add(txtrThisShouldEqual);
		
		JLabel lblNewLabel_4 = new JLabel("Reason for Saving?");
		lblNewLabel_4.setBounds(10, 214, 110, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_4);
		
		JCheckBox bpCheckBox = new JCheckBox("Big Purchase");
		bpCheckBox.setBounds(183, 230, 166, 23);
		frmRegisterNewUser.getContentPane().add(bpCheckBox);
		
		JCheckBox esCheckBox = new JCheckBox("Emergency Savings");
		esCheckBox.setBounds(10, 230, 166, 23);
		frmRegisterNewUser.getContentPane().add(esCheckBox);
		
		/*
		JButton saveReasonButton = new JButton("Save");
		saveReasonButton.setBounds(10, 390, 89, 23);
		frmRegisterNewUser.getContentPane().add(saveReasonButton);
		*/
		
		JTextArea txtrUserLogin = new JTextArea();
		txtrUserLogin.setText("Why you want to save and how often you want to save.");
		txtrUserLogin.setLineWrap(true);
		txtrUserLogin.setBounds(10, 448, 496, 29);
		frmRegisterNewUser.getContentPane().add(txtrUserLogin);
		
		JLabel lblNewLabel_5 = new JLabel("User Name:");
		lblNewLabel_5.setBounds(10, 488, 110, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password:");
		lblNewLabel_5_1.setBounds(10, 544, 110, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_5_1_1.setBounds(169, 544, 110, 14);
		frmRegisterNewUser.getContentPane().add(lblNewLabel_5_1_1);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(10, 513, 134, 20);
		frmRegisterNewUser.getContentPane().add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		passwordtextField.setBounds(10, 569, 134, 20);
		frmRegisterNewUser.getContentPane().add(passwordtextField);
		
		passwordtextField_2 = new JTextField();
		passwordtextField_2.setColumns(10);
		passwordtextField_2.setBounds(169, 569, 134, 20);
		frmRegisterNewUser.getContentPane().add(passwordtextField_2);
		
		JButton saveUserButton = new JButton("Save");
		/*public void actionPerformed(ActionEvent e) {
			if (!usernametextField.getText().equals("") && !passwordtextField.getText().equals("") && !lntextField.getText().equals("") && !fntextField.getText().equals("")) {
				try {
					Statement st = con.createStatement();
					String query = "INSERT INTO usermoney VALUES ('"+userID+"', '"+usernametextField.getText()+"', '"+passwordtextField.getText()+"', '"+lntextField.getText()+"', '"+fntextField.getText()+"', '"+userChoice+"', '"+userMoney+"', '"+userTracker+"')";
					st.executeUpdate(query);
											
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}*/
		saveUserButton.setBounds(10, 600, 89, 23);
		frmRegisterNewUser.getContentPane().add(saveUserButton);		
	}
		
}
	
