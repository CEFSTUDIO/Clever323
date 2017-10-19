import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

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
import javax.swing.JSeparator;

public class ExampleHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable tab;

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
	public ExampleHome() {//src/res/cam.jpg
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/res/logo.jpg (2).png"));
		setTitle("CleverBudget - Homepage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomepage = new JLabel("Welcome to CleverBudget!");
		lblHomepage.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblHomepage.setBounds(55, 31, 374, 62);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "Patricia Duce", "Michael Cassens", "Yolanda Reimer"}));
		comboBox.setBounds(55, 451, 195, 22);
		contentPane.add(comboBox);
		
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this account?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION);
				//comboBox.
			}
			
		});
		btnDeleteAccount.setBounds(55, 562, 132, 25);
		contentPane.add(btnDeleteAccount);
		
		JButton btnDisplayAccountInformation = new JButton("Display Account Information");
		btnDisplayAccountInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = (String) comboBox.getSelectedItem();
				
				if (name.contains("-- Choose --"))
				{
					System.out.println("Choose");
				}
				else if (name.contains("Patricia Duce"))
				{
					System.out.println("Patricia Duce");
				}
				else if (name.contains("Michael Cassens"))
				{
					System.out.println("Michael Cassens");
				}
				else if (name.contains("Yolanda Reimer"))
				{
					System.out.println("Yolanda Reimer");
				}
				else {
					System.out.println("Not known");
				}
				
			}
		});
		btnDisplayAccountInformation.setBounds(55, 486, 205, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/res/logo.jpg.png"));
		lblNewLabel.setBounds(65, 117, 270, 210);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		 Object data[][] = new Object[][]{{"Thirrrs needs to be csfsdhanged", "1000.00", "10/18/17"},
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
					{null, null, null}};
		Object[] col = new Object[]{"Name:","Balance:","Date Last Updated:"};
//		DefaultTableModel model = new DefaultTableModel(data,col);
//		tab = new JTable(data, col);
//		
//		tab.setRowHeight(25);
//		tab.setEnabled(false);
//		tab.setFont(new Font("Tahoma", Font.PLAIN, 23));
//		tab.getColumnModel().getColumn(0).setPreferredWidth(136);
//		tab.getColumnModel().getColumn(1).setPreferredWidth(121);
//		tab.getColumnModel().getColumn(2).setPreferredWidth(98);
//		tab.setBounds(467, 200, 594, 375);
//				  
//		//JTableHeader header = tab.getTableHeader();
//		//header.setBackground(Color.yellow);
//		//JScrollPane pane = new JScrollPane(tab);
//		contentPane.add(tab);
//				 /* frame.add(panel);
//				  frame.setUndecorated(true);
//				  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
//				  frame.setSize(460,200);
//				  frame.setVisible(true); */
//		

		table_1 = new JTable(data, col);
		table_1.setRowHeight(25);
		table_1.setEnabled(false);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(136);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(121);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(98);
		table_1.setBounds(467, 200, 594, 375);
		contentPane.add(table_1);

		
		JTextArea txtrThisProgramAllows = new JTextArea();
		txtrThisProgramAllows.setEditable(false);
		Color defColor = this.getBackground();
		txtrThisProgramAllows.setBackground(defColor);
		txtrThisProgramAllows.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrThisProgramAllows.setText("This program allows a user to keep track of the \r\nDepartments funds and spendings via \r\nteachersthrough the use of dynamic yet simple \r\nimplementationof Java");
		txtrThisProgramAllows.setBounds(55, 347, 280, 75);
		contentPane.add(txtrThisProgramAllows);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 91, 1068, 2);
		contentPane.add(separator);
		
		
	}
}
