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
		setIconImage(Toolkit.getDefaultToolkit().getImage("./BrowserIcon.png"));
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
		lblUsername.setBounds(96, 35, 103, 24);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(209, 39, 284, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblFirstName.setBounds(96, 87, 103, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblLastName.setBounds(96, 133, 103, 23);
		contentPane.add(lblLastName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Security Question");
		lblYourSecurityQuestion.setFont(new Font("Verdana", Font.BOLD, 16));
		lblYourSecurityQuestion.setBounds(30, 193, 169, 32);
		contentPane.add(lblYourSecurityQuestion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 87, 284, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 136, 284, 22);
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
		forgot_pass_topbar.setIcon(new ImageIcon("./blue_border.png"));
		forgot_pass_topbar.setBounds(0, 0, 620, 24);
		contentPane.add(forgot_pass_topbar);
		
		JLabel forgot_pass_middlebar = new JLabel();
		forgot_pass_middlebar.setIcon(new ImageIcon("./blue_border.png"));
		forgot_pass_middlebar.setBounds(0, 167, 605, 24);
		contentPane.add(forgot_pass_middlebar);
		
		JLabel forgot_pass_bottombar = new JLabel();
		forgot_pass_bottombar.setIcon(new ImageIcon("./blue_border.png"));
		forgot_pass_bottombar.setBounds(0, 342, 605, 32);
		contentPane.add(forgot_pass_bottombar);
		
		JLabel forgot_bg = new JLabel();
		//Must be ./res/pass_bg.png otherwise it loads improperly
		forgot_bg.setIcon(new ImageIcon("./res/pass_bg.png"));
		forgot_bg.setBounds(-11, 0, 639, 182);
		contentPane.add(forgot_bg);
	}
}
