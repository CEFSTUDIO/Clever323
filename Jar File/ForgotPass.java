//Author(s): Cameron Gomke, Cheyanne, Chase
//File Name: ForgotPass
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/03/2017
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class ForgotPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass frame = new ForgotPass();
					frame.getContentPane().setBackground(new Color(207, 210, 215));
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("BrowserIcon.png")));
		setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setTitle("CleverBudget - Forgot Password");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUsername.setBounds(105, 22, 94, 24);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(209, 26, 284, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblFirstName.setBounds(107, 77, 94, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblLastName.setBounds(105, 130, 94, 23);
		contentPane.add(lblLastName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Security Question");
		lblYourSecurityQuestion.setFont(new Font("Verdana", Font.BOLD, 16));
		lblYourSecurityQuestion.setBounds(30, 193, 169, 32);
		contentPane.add(lblYourSecurityQuestion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 77, 284, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 133, 284, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "What was your first pet's name?", "Who was your childhood best friend?"}));
		comboBox.setBounds(209, 201, 284, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Answer");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 244, 84, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnRetrievePassword = new JButton("Retrieve Password");
		btnRetrievePassword.setBackground(new Color(70, 137, 191));
        btnRetrievePassword.setOpaque(true);
        btnRetrievePassword.setBorderPainted(true);
		btnRetrievePassword.setBounds(209, 295, 284, 25);
		contentPane.add(btnRetrievePassword);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 247, 284, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDevelopedByCameron = new JLabel("Developed by: Clever 323");
		lblDevelopedByCameron.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDevelopedByCameron.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDevelopedByCameron.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblDevelopedByCameron.setBounds(397, 342, 187, 19);
		contentPane.add(lblDevelopedByCameron);
		
		JLabel forgot_pass_topbar = new JLabel();
		forgot_pass_topbar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/blue_border.png")));
		contentPane.add(forgot_pass_topbar);
		
		JLabel forgot_pass_middlebar = new JLabel();
		forgot_pass_middlebar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/blue_border.png")));
		forgot_pass_middlebar.setBounds(0, 167, 605, 24);
		contentPane.add(forgot_pass_middlebar);
		
		JLabel forgot_pass_bottombar = new JLabel();
		forgot_pass_bottombar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/blue_border.png")));
		forgot_pass_bottombar.setBounds(0, 342, 605, 32);
		contentPane.add(forgot_pass_bottombar);
		
		JLabel forgot_bg = new JLabel();
		forgot_bg.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/pass_bg.png")));
		forgot_bg.setBounds(-11, 0, 639, 182);
		contentPane.add(forgot_bg);
	}
}
