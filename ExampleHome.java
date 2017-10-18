import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.Component;

public class ExampleHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtThisProgramAllows;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleHome frame = new ExampleHome();
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
	public ExampleHome() {
		setTitle("CleverBudget - Homepage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomepage = new JLabel("Welcome to CleverBudget!");
		lblHomepage.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblHomepage.setBounds(55, 47, 374, 62);
		contentPane.add(lblHomepage);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame exitFrame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(exitFrame, "Are you sure you want to log out?", "Log Out", 
				JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION) {
					Login_System LogIn = new Login_System();
					LogIn.main(null);
					dispose();
				}
			}
		});
		btnLogOut.setBounds(55, 600, 97, 25);
		contentPane.add(btnLogOut);
		
		table = new JTable();
		table.setBounds(864, 342, 173, -197);
		contentPane.add(table);
		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(1004, 724, 166, 16);
		contentPane.add(lblDevelopedByClever);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateAccountInside newAcc = new CreateAccountInside();
				newAcc.main(null);
				
			}
		});
		btnCreateAccount.setBounds(55, 524, 132, 25);
		contentPane.add(btnCreateAccount);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this account?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION);
			}
		});
		btnDeleteAccount.setBounds(55, 562, 132, 25);
		contentPane.add(btnDeleteAccount);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "Patricia Duce", "Michael Cassens", "Yolanda Reimer"}));
		comboBox.setBounds(55, 451, 195, 22);
		contentPane.add(comboBox);
		
		JButton btnDisplayAccountInformation = new JButton("Display Account Information");
		btnDisplayAccountInformation.setBounds(55, 486, 205, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Cameron Gomke\\Documents\\College\\Senior First Semester\\Software Science\\Assignments\\Project\\logo.png"));
		lblNewLabel.setBounds(65, 117, 270, 210);
		contentPane.add(lblNewLabel);
		
		txtThisProgramAllows = new JTextField();
		txtThisProgramAllows.setHorizontalAlignment(SwingConstants.CENTER);
		txtThisProgramAllows.setText("This program allows a user to keep track of \r\nthe Departments funds and spendings via teachers\r\nthrough the use of dynamic yet simple implementation\r\nof Java");
		txtThisProgramAllows.setBounds(55, 342, 195, 90);
		contentPane.add(txtThisProgramAllows);
		txtThisProgramAllows.setColumns(10);
		
		table_1 = new JTable();
		table_1.setRowHeight(25);
		table_1.setEnabled(false);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Patricia Duce", "1000.00", "10/18/17"},
				{"Michael Cassens", "500.00", "10/17/17"},
				{"Yolanda Reimer", "250.00", "10/6/17"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Name:", "Account Balance:", "Last Updated:"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(136);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(121);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(98);
		table_1.setBounds(467, 200, 594, 375);
		contentPane.add(table_1);
		
		
	}
}
