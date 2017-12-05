//Author(s): Cameron Gomke, Hank, Cheyanne, Chase
//File Name: Login_System
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/03/2017
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Login_System {

	//Private Attributes:
	private JFrame contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	//Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create Application:
	public Login_System() {
		initialize();
	}

	//Initialize Frame Contents:
	private void initialize() {
		//Main JFrame Statistics
		contentPane = new JFrame();
		contentPane.getContentPane().setBackground(new Color(207, 210, 215));
		contentPane.setTitle("CleverBudget - Log In");
		contentPane.setIconImage(Toolkit.getDefaultToolkit().getImage("./AppIcon.png"));
		contentPane.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.setResizable(false);
		contentPane.setBounds(100, 100, 600, 400);
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.getContentPane().setLayout(null);
		contentPane = new JFrame();
		contentPane.getContentPane().setBackground(new Color(207, 210, 215));
		contentPane.setTitle("CleverBudget - Log In");
		contentPane.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("AppIcon.png")));
		contentPane.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.setResizable(false);
		contentPane.setBounds(100, 100, 600, 400);
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.getContentPane().setLayout(null);
		
		//Label - Username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUsername.setBounds(123, 116, 127, 22);
		contentPane.getContentPane().add(lblUsername);
		
		//Label - Password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(123, 149, 127, 22);
		contentPane.getContentPane().add(lblPassword);
		
		//Text Field - Username
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(260, 120, 178, 20);
		contentPane.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		//Text Password - Password
		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(260, 151, 178, 20);
		contentPane.getContentPane().add(txtPassword);
		
		//Label - Top Blue Border
		JLabel top_blue = new JLabel("");
		top_blue.setIcon(new ImageIcon("./blue_border.png"));
		top_blue.setBounds(0, 0, 594, 22);
		contentPane.getContentPane().add(top_blue);
		
		//Label - Middle Blue Border
		JLabel middle_blue = new JLabel();
		middle_blue.setIcon(new ImageIcon("./blue_border.png"));
		middle_blue.setBounds(0, 196, 594, 22);
		contentPane.getContentPane().add(middle_blue);
		
		//Label - Bottom Blue Border
		JLabel bottom_blue = new JLabel();
		bottom_blue.setIcon(new ImageIcon("./blue_border.png"));
		bottom_blue.setBounds(0, 349, 594, 22);
		contentPane.getContentPane().add(bottom_blue);
		
		//Label - Background Image
		JLabel banner_image = new JLabel();
		banner_image.setIcon(new ImageIcon("./res/login_bg.png"));
		banner_image.setBounds(-6, 0, 611, 218);
		contentPane.getContentPane().add(banner_image);
		
		//Label - Developed By:
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setBackground(Color.WHITE);
		lblDevelopedByClever.setForeground(Color.BLACK);
		lblDevelopedByClever.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDevelopedByClever.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblDevelopedByClever.setBounds(312, 349, 272, 16);
		contentPane.getContentPane().add(lblDevelopedByClever);
		
		//Button - Reset Text Fields
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
		btnReset.setBounds(49, 292, 97, 25);
		contentPane.getContentPane().add(btnReset);
		
		//Button - Exit Program
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
		btnExit.setBounds(364, 292, 165, 25);
		contentPane.getContentPane().add(btnExit);
		
		//Button - User Manual - Fill Out
		JButton btnUserManual = new JButton("User Manual");
		btnUserManual.setBackground(new Color(200, 200, 200));
		btnUserManual.setOpaque(true);
		btnUserManual.setBorderPainted(true);
		btnUserManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserManual.main(null);
				
			}
		});
		btnUserManual.setBounds(177, 292, 158, 25);
		contentPane.getContentPane().add(btnUserManual); 
		
		//Button - Login - Encrypt? - More than just robyn?
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(70, 137, 191));
		btnLogin.setOpaque(true);
		btnLogin.setBorderPainted(true);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				//If the file contains the username and password:
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
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					
					//Call Homepage
					ExampleHome.main(null);
					
					//Get rid of Login Screen
					contentPane.dispose();
				}
				
				//If it doesn't contain the username and password:
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details, Please Try Again", "CleverBudget - Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(49, 241, 97, 25);
		contentPane.getContentPane().add(btnLogin);
		
		//Button - Forgot Password - NOT FUNCTIONAL
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBackground(new Color(200, 200, 200));
		btnForgotPassword.setOpaque(true);
		btnForgotPassword.setBorderPainted(true);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ForgotPass.main(null);
			}
		});
		btnForgotPassword.setBounds(177, 241, 158, 25);
		contentPane.getContentPane().add(btnForgotPassword);
		
		//Button - Create New Account  - NOT FUNCTIONAL
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setBackground(new Color(70, 137, 191));
		btnCreateNewAccount.setOpaque(true);
		btnCreateNewAccount.setBorderPainted(true);
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCreateNewAccount.setBounds(364, 241, 165, 25);
		contentPane.getContentPane().add(btnCreateNewAccount);
		
	}
}
