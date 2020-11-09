import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main {

	private JFrame frame;

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
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This button will take you to the login screen!");
				Profile user = new Profile();
				user.ExistingProfile();
			}
		});
		btnLogin.setBounds(38, 83, 114, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.BLACK);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This button will take you to the register screen!");
				Register user = new Register();
				user.NewProfile();
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
