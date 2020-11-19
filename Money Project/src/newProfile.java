import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class Profile {

	private JFrame frame;
	private Connection con;
	private JTextField depositTextfield;

	/**
	 * Launch the application.
	 */
	public void ExistingProfile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Profile() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MONEY MAGIC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 11, 284, 68);
		frame.getContentPane().add(lblNewLabel);
		//Labels
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 90, 47, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LastName:");
		lblNewLabel_1_1.setBounds(149, 90, 68, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number:");
		lblNewLabel_1_2.setBounds(10, 134, 122, 33);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Initial Goal:  $");
		lblNewLabel_1_3.setBounds(10, 192, 85, 33);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel Deposit = new JLabel("Deposit:");
		Deposit.setBounds(10, 236, 85, 33);
		frame.getContentPane().add(Deposit);
		//bottom to insert to tracker
		JButton saveDepositbtn = new JButton("Save");
		saveDepositbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int totaluserMoney = 0;
					String newMoney = null;
					
					try {
						Statement st = con.createStatement();
						String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
						ResultSet rs = st.executeQuery(que);
						while(rs.next()) {
							String userMoneyTracker = rs.getString("userTracker");
							  int userMoneyDeposit = Integer.parseInt(userMoneyTracker);
							  totaluserMoney += userMoneyDeposit; 
							  newMoney = Integer.toString(totaluserMoney);
							  
							  
						}
					}
					catch(Exception e2){
						e2.printStackTrace();
						
					}
				
					try {
						Statement st = con.createStatement();
						String que = "UPDATE usermoney SET userTracker = '"+100+"' WHERE userID = '"+Login.getUserID()+"'";
						st.executeUpdate(que);
						

					}
					catch(Exception e1){
						e1.printStackTrace();
						
					}
			}
		});
		saveDepositbtn.setBounds(216, 241, 89, 23);
		frame.getContentPane().add(saveDepositbtn);
		
		depositTextfield = new JTextField();
		depositTextfield.setBounds(93, 242, 96, 20);
		frame.getContentPane().add(depositTextfield);
		depositTextfield.setColumns(10);
		//Progress Bar
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				int progress = rs.getInt("userMoney");
				//JProgressBar(0,progress);
				progress = 0;
				progressBar.setValue(progress);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		progressBar.setBounds(419, 270, 122, -241);
		frame.getContentPane().add(progressBar);
		//Display user's info 
		JTextArea fntextArea = new JTextArea();
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				fntextArea.setText(rs.getString("userFirstName"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		fntextArea.setBounds(54, 94, 85, 22);
		frame.getContentPane().add(fntextArea);
		
		JTextArea lntextArea = new JTextArea();
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				lntextArea.setText(rs.getString("userLastName"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		lntextArea.setBounds(220, 90, 85, 22);
		frame.getContentPane().add(lntextArea);
		
		JTextArea phtextArea = new JTextArea();
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				phtextArea.setText(rs.getString("userID"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		phtextArea.setBounds(104, 138, 85, 22);
		frame.getContentPane().add(phtextArea);
		
		JTextArea gotextArea = new JTextArea();
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				gotextArea.setText(rs.getString("userMoney"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		gotextArea.setBounds(104, 196, 85, 22);
		frame.getContentPane().add(gotextArea);
	}

	private void JProgressBar(int i, int progress) {
		// TODO Auto-generated method stub
		
	}
}
