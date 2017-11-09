import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Login_System {

	private JFrame frmLogIn;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(new Color(207, 210, 215));
		frmLogIn.setTitle("CleverBudget - Log In");
		frmLogIn.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/res/BrowserIcon.png"));
		frmLogIn.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		frmLogIn.setBounds(100, 100, 600, 400);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(49, 95, 81, 16);
		frmLogIn.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(49, 168, 81, 16);
		frmLogIn.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(169, 92, 195, 22);
		frmLogIn.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(169, 165, 195, 22);
		frmLogIn.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(70, 137, 191));
		btnLogin.setOpaque(true);
		btnLogin.setBorderPainted(true);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				if (username.contains("csadmin") && password.contains("csci323")) {
					
					//Set both fields to null
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					//Store information in a file
					try {
						PrintWriter writer = new PrintWriter("user-and-pass.txt", "UTF-8");
						writer.println(username + "," + password);
						writer.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//Call a new package or something, 
					ExampleHome home = new ExampleHome();
					home.main(null);
					
					
					//Get rid of main screen
					frmLogIn.dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details, Please Try Again", "CleverBudget - Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(49, 229, 97, 25);
		frmLogIn.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(200, 200, 200));
		btnReset.setOpaque(true);
		btnReset.setBorderPainted(true);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(121, 267, 97, 25);
		frmLogIn.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(225, 79, 79));
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(true);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame exitFrame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(exitFrame, "Are you sure you want to leave?", "CleverBudget - Exit", 
				JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				
				}
			}
		});
		btnExit.setBounds(211, 305, 97, 25);
		frmLogIn.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(49, 197, 478, 2);
		frmLogIn.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(49, 77, 478, 2);
		frmLogIn.getContentPane().add(separator_1);
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBackground(new Color(200, 200, 200));
		btnForgotPassword.setOpaque(true);
		btnForgotPassword.setBorderPainted(true);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ForgotPass forgotFrame = new ForgotPass();
				forgotFrame.main(null);
			}
		});
		btnForgotPassword.setBounds(179, 229, 158, 25);
		frmLogIn.getContentPane().add(btnForgotPassword);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setBackground(new Color(70, 137, 191));
		btnCreateNewAccount.setOpaque(true);
		btnCreateNewAccount.setBorderPainted(true);
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnCreateNewAccount.setBounds(364, 229, 165, 25);
		frmLogIn.getContentPane().add(btnCreateNewAccount);
		
		JLabel lblCleverbudget = new JLabel("CleverBudget");
		lblCleverbudget.setFont(new Font("Tahoma", Font.ITALIC, 29));
		lblCleverbudget.setBounds(179, 29, 195, 35);
		frmLogIn.getContentPane().add(lblCleverbudget);
		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(404, 330, 166, 16);
		frmLogIn.getContentPane().add(lblDevelopedByClever);
		
		JButton btnUserManual = new JButton("User Manual");
		btnUserManual.setBackground(new Color(200, 200, 200));
		btnUserManual.setOpaque(true);
		btnUserManual.setBorderPainted(true);
		btnUserManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserManual manual = new UserManual();
				manual.main(null);
				
			}
		});
		btnUserManual.setBounds(298, 267, 109, 25);
		frmLogIn.getContentPane().add(btnUserManual);
	}
}
