import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class CreateAcc extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setBounds(243, 29, 56, 16);
		contentPane.add(lblCreateAccount);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(54, 74, 56, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(54, 103, 56, 16);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(54, 132, 56, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 161, 56, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(54, 190, 56, 16);
		contentPane.add(lblConfirmPassword);
	}

}
