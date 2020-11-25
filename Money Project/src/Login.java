import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;



public class Login {

	private JFrame Login;
	private JTextField loginUserNameTextfield;
	private JTextField loginPasswordTextfield;
	private Connection con;
	
	private static String userLoginID = " ";
	private static double userMoneyGoal = 0;
	private static double userMoneyTracker = 0;
	private static int userChoice = 0;
	/**
	 * Launch the application.
	 */
	public void newLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.Login.setVisible(true);
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
	public Login() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	
	//Created get/set methods for user decision making.
	public void setUserID(String uid) {
		userLoginID = uid;
	}
	
	public void setUserGoal(double umg) {
		userMoneyGoal = umg;
	}
	
	public void setUserTracker(double umt) {
		userMoneyTracker = umt;
	}
	
	public void setChoice(int uc) {
		userChoice = uc;
	}
	
	public static String getUserID() {
		return userLoginID;
	}
	
	public static double getUserMoneyGoal() {
		return userMoneyGoal;
	}
	
	public static double getUserMoneyTracker() {
		return userMoneyTracker;
	}
	
	public static int getChoice() {
		return userChoice;
	}
	
	private void initialize() throws ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		Login = new JFrame();
		Login.setBounds(100, 100, 350, 200);
		Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Login.getContentPane().setLayout(null);

		loginUserNameTextfield = new JTextField();
		loginUserNameTextfield.setBounds(10, 11, 205, 29);
		Login.getContentPane().add(loginUserNameTextfield);
		loginUserNameTextfield.setColumns(10);

		loginPasswordTextfield = new JTextField();
		loginPasswordTextfield.setBounds(10, 51, 205, 29);
		Login.getContentPane().add(loginPasswordTextfield);
		loginPasswordTextfield.setColumns(10);
		
		
		

		// PROPERTIES FOR THE LOGIN BUTTON
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// THIS IS WHERE WE NEED TO COMPARE THE DATA THAT WAS INPUTTED TO WHAT WE HAVE IN THE SERVER
				if (!loginUserNameTextfield.getText().equals("") && !loginPasswordTextfield.getText().equals("")) {	// CHECKS IF FIELDS AREN'T EMPTY
					
					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM usermoney WHERE userName = '"+loginUserNameTextfield.getText()+"' AND userPassword = '"+loginPasswordTextfield.getText()+"' ");						
						
						while(rs.next()) {
							
							String userName = rs.getString("userName");			// Username from database
							String password = rs.getString("userPassword");		// Password from database
							String userID = rs.getString("userID");				// userID from Database
							double moneyGoal = rs.getDouble("userMoney");		// user money goal
							double moneyTracker = rs.getDouble("userTracker"); 	// 
							int userSavingsChoice = rs.getInt("userChoice");	// user savings choice from DataBase
							
							if(loginUserNameTextfield.getText().equals(userName) && loginPasswordTextfield.getText().equals(password)) {

								JOptionPane.showMessageDialog(null, "Successful login!");
								
								Profile user = new Profile();
								user.ExistingProfile();
								
								Login user1 = new Login();
								user1.setUserID(userID);
								user1.setUserGoal(moneyGoal);
								user1.setUserTracker(moneyTracker);
								user1.setChoice(userSavingsChoice);
								
								Login.dispose();
								break;
							}

							else if (rs.next() == false) {
								JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
							}
														
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
					System.out.println("Cannot have fields empty");
				}
			}
			
		});
		loginBtn.setBounds(10, 91, 98, 34);
		Login.getContentPane().add(loginBtn);



	}
}
