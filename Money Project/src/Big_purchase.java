import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
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
import java.util.*;
import javax.swing.JButton;
public class Big_purchase {

	private JFrame frame;
	private JTextField downpay_disp;
	private JTextField frequency;
	private JTextField month;
	private JTextField week;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Big_purchase window = new Big_purchase();
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
	public Big_purchase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://34.72.116.206:3306/moneyproject", "newuser", "Rootpassword!");
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e2.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 458, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		downpay_disp = new JTextField();
		downpay_disp.setBounds(188, 88, 96, 20);
		frame.getContentPane().add(downpay_disp);
		downpay_disp.setColumns(10);
		
		frequency = new JTextField();
		frequency.setBounds(188, 119, 96, 20);
		frame.getContentPane().add(frequency);
		frequency.setColumns(10);
		
		month = new JTextField();
		month.setBounds(188, 157, 50, 20);
		frame.getContentPane().add(month);
		month.setColumns(10);
		
		JLabel lblDown = new JLabel("Down Payment:  $");
		lblDown.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblDown.setLabelFor(downpay_disp);
		lblDown.setBounds(49, 85, 133, 28);
		frame.getContentPane().add(lblDown);
		
		JLabel lblFrequency = new JLabel("Frequency:  $");
		lblFrequency.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblFrequency.setBounds(84, 122, 115, 17);
		frame.getContentPane().add(lblFrequency);
		
		JLabel lblBy = new JLabel("Goal Deadline:");
		lblBy.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblBy.setBounds(63, 158, 115, 20);
		frame.getContentPane().add(lblBy);
		
		JLabel Tittle = new JLabel("Big Purchase");
		Tittle.setForeground(SystemColor.desktop);
		Tittle.setHorizontalAlignment(SwingConstants.CENTER);
		Tittle.setVerticalAlignment(SwingConstants.BOTTOM);
		Tittle.setFont(new Font("Calibri", Font.BOLD, 36));
		Tittle.setBackground(Color.GRAY);
		Tittle.setBounds(27, 22, 359, 63);
		frame.getContentPane().add(Tittle);
		
		JLabel lblMonths = new JLabel("month(s)");
		lblMonths.setBounds(248, 160, 47, 14);
		frame.getContentPane().add(lblMonths);
		
		JLabel lblNewLabel = new JLabel("week(s)");
		lblNewLabel.setBounds(365, 160, 47, 14);
		frame.getContentPane().add(lblNewLabel);
		
		week = new JTextField();
		week.setBounds(305, 157, 50, 20);
		frame.getContentPane().add(week);
		week.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Amount:  $");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(27, 263, 155, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(175, 265, 96, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalc.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnCalc.setBounds(157, 207, 107, 23);
		frame.getContentPane().add(btnCalc);
	}
}
