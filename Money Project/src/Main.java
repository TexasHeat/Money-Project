import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Color;

public class Main {

	JFrame frame;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Main() throws ClassNotFoundException, SQLException {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() throws SQLException, ClassNotFoundException  {
		
		// Define connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		
		try {
			Statement st = con.createStatement();
			String query = "SELECT * FROM usermoney";
			ResultSet rs = st.executeQuery(query);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 350, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login user;
				try {
					user = new Login();
					user.newLogin();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		btnLogin.setBounds(38, 83, 114, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register user;
				try {
					user = new Register();
					user.NewProfile();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		btnRegister.setBounds(183, 83, 114, 37);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Segoe Script", Font.ITALIC, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(38, 11, 259, 61);
		frame.getContentPane().add(lblNewLabel);
	}

}
