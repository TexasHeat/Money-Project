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
import java.awt.Font;
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
		int randNum = (int)(Math.random()*10)%3;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Easy $ave");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 11, 284, 68);
		frame.getContentPane().add(lblNewLabel);
		//Labels
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 90, 47, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LastName:");
		lblNewLabel_1_1.setBounds(149, 90, 68, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number:");
		lblNewLabel_1_2.setBounds(10, 134, 85, 33);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Initial Goal: $");
		lblNewLabel_1_3.setBounds(10, 178, 85, 33);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel Deposit = new JLabel("Deposit:");
		Deposit.setBounds(10, 327, 47, 33);
		frame.getContentPane().add(Deposit);
		

		depositTextfield = new JTextField();
		depositTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		depositTextfield.setBounds(100, 333, 117, 20);
		frame.getContentPane().add(depositTextfield);
		depositTextfield.setColumns(10);
		
		//bottom to insert to tracker
		JButton saveDepositbtn = new JButton("Save");
		saveDepositbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					double money = 0;
					money = Login.getUserMoneyTracker();
					//System.out.print("money tracker before adding "+money);
					money += Double.parseDouble(depositTextfield.getText());
					//System.out.print("money tracker after adding "+money);
					
					try {
						Statement st = con.createStatement();
						String que = "UPDATE usermoney SET userTracker = '"+money+"' WHERE userID = '"+Login.getUserID()+"'";
						st.executeUpdate(que);
					}
					catch(Exception e1){
						e1.printStackTrace();
						
					}
				
				
					/*					
					try {
						Statement st = con.createStatement();
						String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
						ResultSet rs = st.executeQuery(que);
						while(rs.next()) {
							String userMoneyTracker = rs.getString("userTracker");
														  
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
					*/
			}
		});
		saveDepositbtn.setBounds(128, 364, 89, 23);
		frame.getContentPane().add(saveDepositbtn);
		
		//Progress Bar
		int progress = (int) (Login.getUserMoneyTracker()/(Login.getUserMoneyGoal())*100);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(229, 157, 279, 47);
		frame.getContentPane().add(progressBar);
		progressBar.setValue(progress);
		
		
		/*
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
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
		*/
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
		lntextArea.setBounds(216, 94, 85, 22);
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
		phtextArea.setBounds(100, 138, 117, 22);
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
		gotextArea.setBounds(100, 182, 117, 22);
		frame.getContentPane().add(gotextArea);
		
		JTextArea moneyTrackertextArea = new JTextArea();
		try {
			Statement st = con.createStatement();
			String que = "SELECT * FROM usermoney WHERE userID = '"+Login.getUserID()+"'";
			ResultSet rs = st.executeQuery(que);
			while(rs.next()) {
				moneyTrackertextArea.setText(rs.getString("userTracker"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		moneyTrackertextArea.setBounds(100, 226, 117, 22);
		frame.getContentPane().add(moneyTrackertextArea);
		
		JTextArea tiptextArea = new JTextArea();
		
		switch(randNum) {
		case 0:
			tiptextArea.setText("Understanding how much you spend each month in general "
					+ "expenses is the first step in saving. When you can identify where your "
					+ "money is going you will be better prepared to cut costs. Cutting costs "
					+ "equals more money available. More money available equals easier time "
					+ "saving money!!!");
			break;
			
		case 1:
			tiptextArea.setText("Creating free cash flow (money not tied up in bills) can be "
					+ "done in one of two ways. Either increase your monthly income or decrease"
					+ "your monthly spending. Increasing monthly income can be seen as getting a"
					+ "second job or getting a better paying job. Decreasing monthly spending "
					+ "can be done by paying off loans/credit cards.");
			break;
			
		case 2:
			tiptextArea.setText("Many Employeers who offer direct deposit will let you depost "
					+ "money into multiple accounts. This will take advantange of the old saying "
					+ "''out of sight! out of mind!'' and make it easier to deposit money and "
					+ "not spend it.");
			break;
		}
		
		tiptextArea.setLineWrap(true);
		tiptextArea.setBounds(229, 237, 276, 150);
		frame.getContentPane().add(tiptextArea);
		
		JLabel lblNewLabel_2 = new JLabel("Saving Tip:");
		lblNewLabel_2.setBounds(229, 212, 95, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Saving Progress:");
		lblNewLabel_3.setBounds(229, 134, 95, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel savedMoneyLabel = new JLabel("Saved:");
		savedMoneyLabel.setBounds(10, 231, 46, 14);
		frame.getContentPane().add(savedMoneyLabel);
				
	}

	private void JProgressBar(int i, int progress) {
		// TODO Auto-generated method stub
		
	}
}
