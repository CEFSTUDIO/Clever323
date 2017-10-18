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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CreateAccountInside extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtBalance;

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
		setTitle("CleverBudget - Create New Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Grabbing text from text fields
				String firstName = txtFirst.getText();
				String lastName = txtLast.getText();
				String balance = txtBalance.getText();
				
				//Error checking for if Balance is a number
				int size = balance.length();
				
				for (int i = 0; i < size; i++) {
					if (!Character.isDigit(balance.charAt(i))) {
						JOptionPane.showMessageDialog(null, "The balance must be a number", "CleverBudget - Balance Error", JOptionPane.ERROR_MESSAGE);
						txtBalance.setText(null);
					}
				}
				

				//Error checking for blank fields
				if (firstName.equals("") || lastName.equals("") || balance.equals("")) {
					JOptionPane.showMessageDialog(null, "All fields were not filled out, Please try again", "CleverBudget - Fields Error", JOptionPane.ERROR_MESSAGE);
					txtFirst.setText(null);
					txtLast.setText(null);
					txtBalance.setText(null);
				}
				
				else {
					
				}
				
				
				
				//if (username.contains("CSAdmin") && password.contains("CSCI323")) {
					//txtPassword.setText(null);
					//txtUsername.setText(null);
					
					//Call a new package or something, 
				//	ExampleHome deletethis = new ExampleHome();
				//	ExampleHome.main(null);
					//Traveling info = new Traveling();
					//Traveling.main(null);
					
					//Get rid of main screen
					//frmLogIn.dispose();
			//	}
				
			//	else
			//	{
			//		JOptionPane.showMessageDialog(null, "Invalid Login Details, Please Try Again", "CleverBudget", JOptionPane.ERROR_MESSAGE);
			//		//txtPassword.setText(null);
					//txtUsername.setText(null);
			//	}
				
				
				
				
				
			}
		});
		btnCreateAccount.setBounds(153, 186, 132, 25);
		contentPane.add(btnCreateAccount);
		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(254, 224, 166, 16);
		contentPane.add(lblDevelopedByClever);
	}

}
