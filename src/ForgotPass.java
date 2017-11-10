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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("./res/BrowserIcon.png"));
		setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setTitle("CleverBudget - Forgot Password");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(52, 37, 68, 16);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(275, 34, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(52, 86, 116, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(52, 139, 147, 16);
		contentPane.add(lblLastName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question:");
		lblYourSecurityQuestion.setBounds(52, 188, 196, 16);
		contentPane.add(lblYourSecurityQuestion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 83, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 136, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "What was your first pet's name?", "Who was your childhood best friend?"}));
		comboBox.setBounds(275, 185, 284, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Your Answer:");
		lblNewLabel.setBounds(52, 233, 116, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnRetrievePassword = new JButton("Retrieve Password");
		btnRetrievePassword.setBounds(201, 277, 147, 25);
		contentPane.add(btnRetrievePassword);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 230, 284, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDevelopedByCameron = new JLabel("Developed by: Clever 323");
		lblDevelopedByCameron.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByCameron.setBounds(393, 324, 166, 16);
		contentPane.add(lblDevelopedByCameron);
	}
}
