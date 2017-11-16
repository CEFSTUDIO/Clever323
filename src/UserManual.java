import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class UserManual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManual frame = new UserManual();
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
	public UserManual() {
		setTitle("CleverBudget - User Manual");
		setFont(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./BrowserIcon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserManual = new JLabel("User Manual");
		lblUserManual.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblUserManual.setBounds(36, 35, 170, 32);
		contentPane.add(lblUserManual);
		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(604, 524, 166, 16);
		contentPane.add(lblDevelopedByClever);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 80, 701, 2);
		contentPane.add(separator);
		
		JLabel lblTheFollowingThe = new JLabel("The following the ways to properly use this software:");
		lblTheFollowingThe.setBounds(36, 95, 305, 16);
		contentPane.add(lblTheFollowingThe);
	}
}
