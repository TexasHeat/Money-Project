import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;



public class Login {

	private JFrame frame;
	private JTextField loginUserNameTextfield;
	private JTextField loginPasswordTextfield;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public void newLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Compare the users information to that of the database
	
	//String query = "SELECT * FROM employees WHERE userName LIKE '%"+ loginUserNameTextfield.getText() +"%";
	
//	public void checkLoginInfo() {
//		if(loginUserNameTextfield.getText() != ) {
//			
//		}
//	}
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
	private void initialize() throws ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		loginUserNameTextfield = new JTextField();
		loginUserNameTextfield.setBounds(92, 105, 253, 29);
		frame.getContentPane().add(loginUserNameTextfield);
		loginUserNameTextfield.setColumns(10);

		loginPasswordTextfield = new JTextField();
		loginPasswordTextfield.setBounds(92, 161, 253, 29);
		frame.getContentPane().add(loginPasswordTextfield);
		loginPasswordTextfield.setColumns(10);
		
		
		

		// PROPERTIES FOR THE LOGIN BUTTON
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// THIS IS WHERE WE NEED TO COMPARE THE DATA THAT WAS INPUTTED TO WHAT WE HAVE IN THE SERVER
				if (!loginUserNameTextfield.getText().equals("") && !loginPasswordTextfield.getText().equals("")) {	// CHECKS IF FIELDS AREN'T EMPTY
					
					try {
						Statement st = con.createStatement();
						//String userNameFromQuery = "SELECT * FROM moneyproject.usermoney WHERE userName = '"+loginUserNameTextfield.getText()+"' and userPassword = '"+loginPasswordTextfield.getText();
						//String userPasswordFromQuery = "SELECT * FROM moneyproject.usermoney WHERE userPassword LIKE '%"+loginPasswordTextfield.getText()+"%'";
						
						ResultSet rs = st.executeQuery("select * from usermoney");
						//rs.next();
						
						
						/*
						loginUserNameTextfield.getText(); // should be test
						loginPasswordTextfield.getText(); // should be test
						*/
						while(rs.next()) {
							
							String userName = rs.getString("userName");			// Username from database
							String password = rs.getString("userPassword");		// Password from database
							
							if(loginUserNameTextfield.getText().equals(userName) && loginPasswordTextfield.getText().equals(password)) {
								System.out.println("Successful login");
								JOptionPane.showMessageDialog(null, "Successful login!");
								
								Profile user = new Profile();
								user.ExistingProfile();
								frame.dispose();
								break;
							}

							else if (rs.next() == false) {
								JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
							}
							
							
							//System.out.println("Username from database: "+ userName);
							//System.out.println("Password from database: "+ password);
							
						}
						

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
					System.out.println("Cannot have fields empty");
				}
			}
			
			
		});
		loginBtn.setBounds(171, 228, 98, 34);
		frame.getContentPane().add(loginBtn);



	}
}
