import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CreateAcc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAcc frame = new CreateAcc();
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
	public CreateAcc() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create New Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateAccount.setBounds(177, 13, 225, 31);
		contentPane.add(lblCreateAccount);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(54, 74, 67, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(54, 103, 65, 16);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(54, 189, 63, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(54, 217, 60, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(54, 246, 109, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(54, 132, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(54, 160, 89, 16);
		contentPane.add(lblPhoneNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 59, 498, 2);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setBounds(198, 71, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 100, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 129, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(198, 157, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(198, 186, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblExSomebodyemailservicecom = new JLabel("(Ex: Somebody@emailservice.com)");
		lblExSomebodyemailservicecom.setBounds(326, 132, 203, 16);
		contentPane.add(lblExSomebodyemailservicecom);
		
		JLabel lblex = new JLabel("(Ex: 406-555-1234)");
		lblex.setBounds(326, 160, 112, 16);
		contentPane.add(lblex);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 214, 116, 22);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(198, 243, 116, 22);
		contentPane.add(passwordFieldConfirm);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Grabbing all the information
				String firstName = lblFirstName.getText();
				String lastName = lblLastName.getText();
				String email = lblEmail.getText();
				String phoneNumber = lblPhoneNumber.getText();
				String userName = lblUsername.getText();
				String password = passwordField.getText();
				String passwordC = passwordFieldConfirm.getText();
				
				//Error checking for different errors in different fields:
				
				//First and Last name - filled out, letters only, no more than 30 characters?,
				
				
				
				
				
				
				
				
			}
		});
		btnCreateNewAccount.setBounds(198, 298, 149, 25);
		contentPane.add(btnCreateNewAccount);
	}
}
