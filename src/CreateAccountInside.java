import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class CreateAccountInside extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtBalance;
	private JTextField txtDesc;
	private JTextField txtPhoneNum;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountInside frame = new CreateAccountInside();
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
	public CreateAccountInside() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cameron Gomke\\eclipse-workspace\\Git\\src\\res\\BrowserIcon.png"));
		setTitle("CleverBudget - Create New Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUseCreateA = new JLabel("Use: Create a new account for the table\r\n");
		lblUseCreateA.setBounds(12, 13, 229, 16);
		contentPane.add(lblUseCreateA);
		
		JLabel lblPleaseFillOut = new JLabel("Please fill out the following fields completely:");
		lblPleaseFillOut.setBounds(12, 29, 257, 16);
		contentPane.add(lblPleaseFillOut);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(12, 73, 67, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(12, 102, 65, 16);
		contentPane.add(lblLastName);
		
		JLabel lblAccountBalance = new JLabel("Account Balance:");
		lblAccountBalance.setBounds(12, 131, 110, 16);
		contentPane.add(lblAccountBalance);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(153, 70, 116, 22);
		contentPane.add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setBounds(153, 99, 116, 22);
		contentPane.add(txtLast);
		txtLast.setColumns(10);
		
		txtBalance = new JTextField();
		txtBalance.setBounds(153, 128, 116, 22);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);
		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(254, 298, 166, 16);
		contentPane.add(lblDevelopedByClever);
		
		JLabel lblex = new JLabel("(Ex: 1000.00)");
		lblex.setBounds(279, 131, 78, 16);
		contentPane.add(lblex);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 58, 408, 2);
		contentPane.add(separator);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 160, 68, 16);
		contentPane.add(lblDescription);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(12, 189, 89, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 218, 56, 16);
		contentPane.add(lblEmail);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(153, 157, 116, 22);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(153, 186, 116, 22);
		contentPane.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(153, 215, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblex_1 = new JLabel("(Ex: 406-111-3324)");
		lblex_1.setBounds(279, 189, 112, 16);
		contentPane.add(lblex_1);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Grabbing text from text fields
				String firstName = txtFirst.getText();
				String lastName = txtLast.getText();
				String balance = txtBalance.getText();
				String description = txtDesc.getText();
				String phoneNum = txtPhoneNum.getText();
				String email = txtEmail.getText();
				
				//Error checking for if Balance is a number
				int size = balance.length();
				int sizeError = 0;
				
				for (int i = 0; i < size; i++) {
					if (!Character.isDigit(balance.charAt(i))) {
						sizeError += 1;
					}
				}
				if(sizeError > 0) {
					JOptionPane.showMessageDialog(null, "The balance must be a number", "CleverBudget - Balance Error", JOptionPane.ERROR_MESSAGE);
					txtBalance.setText(null);
				}
				
				//Error checking for if phoneNum is in right format
				int phoneNumError = 0;
				if (phoneNum.matches("\\d{3}-\\d{3}-\\d{4}")) {
					phoneNumError = 0;
				}
				else {
					phoneNumError +=1;
				}
				if(phoneNumError > 0) {
					JOptionPane.showMessageDialog(null, "The phone number must look like the following: 111-111-1111", "CleverBudget - Phone Number Error", JOptionPane.ERROR_MESSAGE);
					txtPhoneNum.setText(null);
				}
				
				//Error checking if email has a @ and .com or .org, ect...
				int emailError = 0;
				if (email.contains("@") && email.contains(".")) {
					emailError = 0;
				}
				else {
					emailError += 1;
				}
				if(emailError > 0) {
					JOptionPane.showMessageDialog(null, "The email must be valid", "CleverBudget - Email Error", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText(null);
				}
				
				//Error checking for blank fields
				if (firstName.equals("") || lastName.equals("") || balance.equals("") || description.equals("") || phoneNum.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "All fields were not filled out, Please try again", "CleverBudget - Fields Error", JOptionPane.ERROR_MESSAGE);
					
				}
				else {
					//Writing information to a file, and putting first name in main file
					try {
						PrintWriter writer = new PrintWriter(firstName + ".txt", "UTF-8");
						writer.println(firstName + ", " + lastName + ", " + balance + ", " + description + ", " + phoneNum + ", " + email);
						writer.close();
						
						
					} 
					catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} 
					catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					
					//Dont need to call homepage, it should dispose on close
					//ExampleHome home = new ExampleHome();
					//home.main(null);
					
				}
			
		
			}
		});
		btnCreateAccount.setBounds(153, 260, 132, 25);
		contentPane.add(btnCreateAccount);
	}
}
