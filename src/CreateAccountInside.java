// Author: Cameron Gomke, Cheyanne Flickinger
// File Name: Create Account Inside
// Purpose: CleverBudget
// Date Created: 10/30/2017
// Last Updated: 12/12/2017
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CreateAccountInside extends JFrame {

	//Attributes:
	private JPanel contentPane;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtBalance;
	private JTextField txtDesc;
	private JTextField txtPhoneNum;
	private JTextField txtEmail;

	//Launch Application:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountInside frame = new CreateAccountInside();
					frame.getContentPane().setBackground(new Color(207, 210, 215));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	//Create the Frame
	public CreateAccountInside() {
		//Frame Statistics
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("BrowserIcon.png")));
		setTitle("CleverBudget - Create New Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Separator - Looks nice
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 58, 408, 2);
		contentPane.add(separator);
		
		//Label - Use label at top
		JLabel lblUseCreateA = new JLabel("Use: Create a New Account for the Table\r\n");
		lblUseCreateA.setFont(new Font("Verdana", Font.BOLD, 11));
		lblUseCreateA.setBounds(12, 13, 379, 16);
		contentPane.add(lblUseCreateA);
		
		//Label - fill out label at top
		JLabel lblPleaseFillOut = new JLabel("Please Fill Out the Following Fields Completely:");
		lblPleaseFillOut.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPleaseFillOut.setBounds(12, 40, 379, 16);
		contentPane.add(lblPleaseFillOut);
		
		//Label - First Name
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 13));
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setBounds(45, 74, 89, 16);
		contentPane.add(lblFirstName);
		
		//Label - Last Name
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Verdana", Font.BOLD, 13));
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setBounds(45, 101, 89, 16);
		contentPane.add(lblLastName);
		
		//Label - Account Balance
		JLabel lblAccountBalance = new JLabel("Account Balance");
		lblAccountBalance.setFont(new Font("Verdana", Font.BOLD, 13));
		lblAccountBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAccountBalance.setBounds(-20, 130, 153, 16);
		contentPane.add(lblAccountBalance);
		
		//Label - Account Balance Example
		JLabel lblExampleBalance = new JLabel("(Ex: 1000.00)");
		lblExampleBalance.setFont(new Font("Verdana", Font.BOLD, 11));
		lblExampleBalance.setBounds(300, 131, 112, 16);
		contentPane.add(lblExampleBalance);
		
		//Label - Description
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescription.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDescription.setBounds(45, 177, 89, 16);
		contentPane.add(lblDescription);
		
		//Label - Phone Number
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setFont(new Font("Verdana", Font.BOLD, 13));
		lblPhoneNumber.setBounds(20, 209, 114, 16);
		contentPane.add(lblPhoneNumber);
		
		//Label - Phone Number Example
		JLabel lblExamplePhoneNum = new JLabel("(Ex: 406-111-3324)");
		lblExamplePhoneNum.setFont(new Font("Verdana", Font.BOLD, 11));
		lblExamplePhoneNum.setBounds(293, 209, 141, 16);
		contentPane.add(lblExamplePhoneNum);
		
		//Label - Email
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(45, 241, 89, 16);
		contentPane.add(lblEmail);
		
		
		//Text Field - First Name
		txtFirst = new JTextField();
		txtFirst.setBounds(137, 71, 153, 22);
		contentPane.add(txtFirst);
		txtFirst.setColumns(10);
		
		//Text Field - Last Name
		txtLast = new JTextField();
		txtLast.setBounds(137, 100, 153, 22);
		contentPane.add(txtLast);
		txtLast.setColumns(10);
		
		//Text Field - Balance
		txtBalance = new JTextField();
		txtBalance.setBounds(137, 129, 153, 22);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);
	
		//Text Field - Description
		txtDesc = new JTextField();
		txtDesc.setBounds(137, 176, 153, 22);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		//Text Field - Phone Number
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(137, 207, 153, 22);
		contentPane.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		//Text Field - Email
		txtEmail = new JTextField();
		txtEmail.setBounds(137, 240, 153, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(new Color(70, 137, 191));
        btnCreateAccount.setOpaque(true);
        btnCreateAccount.setBorderPainted(true);
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
				
				for (int i = 0; i < size; i++) 
				{
					if (!Character.isDigit(balance.charAt(i))) 
					{
						sizeError += 1;
					}
				}
				
				//Error checking for if phoneNum is in right format
				int phoneNumError = 0;
				if (phoneNum.matches("\\d{3}-\\d{3}-\\d{4}")) 
				{
					phoneNumError = 0;
				}
				else 
				{
					phoneNumError +=1;
				}
				
				//Error checking if email has a @ and .com or .org, ect...
				int emailError = 0;
				if (email.contains("@") && email.contains(".")) 
				{
					emailError = 0;
				}
				else 
				{
					emailError += 1;
				}
				
				//Error checking for blank fields, and throwing other error messages
				if (firstName.equals("") || lastName.equals("") || balance.equals("") || description.equals("") || phoneNum.equals("") || email.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "All fields were not filled out, Please try again", "CleverBudget - Fields Error", JOptionPane.ERROR_MESSAGE);
					
				}
				//Balance error
				else if(sizeError > 0) 
				{
					JOptionPane.showMessageDialog(null, "The Balance must be a Number", "CleverBudget - Balance Error", JOptionPane.ERROR_MESSAGE);
					txtBalance.setText(null);
				}
				//Phone Number Error
				else if(phoneNumError > 0) 
				{
					JOptionPane.showMessageDialog(null, "The Phone Number must look like the Following: 111-111-1111", "CleverBudget - Phone Number Error", JOptionPane.ERROR_MESSAGE);
					txtPhoneNum.setText(null);
				}
				//Email Error
				else if(emailError > 0) 
				{
					JOptionPane.showMessageDialog(null, "The Email must be Valid", "CleverBudget - Email Error", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText(null);
				}
				
				//If there are no errors, we can make this new account
				else 
				{
					//Attributes:
					String smallDataFile = "smallData.txt";
					BufferedReader r = null;
					String line = null;
					String[] t = null;
					Account newAccount;
					ArrayList<Account> accs = new ArrayList<Account>();
					
					//Reading in the file, parsing the file:
					try 
					{
						r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)));
						while ((line = r.readLine()) != null) 
						{
							t = line.split(",");
							newAccount = new Account();
							newAccount.setFirstName(t[0]);
							newAccount.setLastName(t[1]);
							accs.add(newAccount);
						}
					} 
					
					
			
					//Catching Errors:
					catch (FileNotFoundException e1) 
					{
						System.out.println("Was not able to find the file: smallData.txt," + smallDataFile);
						e1.printStackTrace();
					}
					catch (IOException e2) 
					{
						System.out.println("IOE Exception");
						e2.printStackTrace();
					}
					
					//Checking to see if the account already exists
					int Jerror = 0;
					for(int i = 0; i < accs.size(); i++) 
					{
						//If it does, give an error message
						if((accs.get(i).getFirstName() + " " + accs.get(i).getLastName()).equalsIgnoreCase(firstName.trim() + " " + lastName.trim()))
						{
							Jerror += 1;
						}
					}
					System.out.println(Jerror);
					//If it does, tell the user
					if(Jerror > 0) 
					{
						JOptionPane.showMessageDialog(null, "This account already exists. Please use a different first/last name", "CleverBudget - Account Creation Error", JOptionPane.ERROR_MESSAGE);
					}
					//If it does not exist, write the data to the small data file
					else 
					{
						try(FileWriter fw = new FileWriter(smallDataFile, true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter out = new PrintWriter(bw))
						{
							out.println(firstName + "," + lastName + "," + balance + "," + description + "," + phoneNum + "," + email);
							dispose();
						}
							
						catch (IOException e1) 
						{
							System.out.println("Was not able to find the file: smallData.txt, " + smallDataFile);
							e1.printStackTrace();
						}
					}
				} // End of else, button pressed and all is good
			}
		});
		btnCreateAccount.setBounds(137, 288, 153, 25);
		contentPane.add(btnCreateAccount);
	}
}
