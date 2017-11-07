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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

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
import javax.swing.JRadioButton;

public class ExampleHome extends JFrame {

	//Private Attributes
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
	public ExampleHome() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("./res/BrowserIcon.png"));

		setTitle("CleverBudget - Homepage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		
		setBounds(0, 0, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMainIcon = new JLabel("");
		lblMainIcon.setIcon(new ImageIcon("./res/logo.png"));
		lblMainIcon.setBounds(65, 117, 210, 210);
		contentPane.add(lblMainIcon);
		
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
		btnLogOut.setBounds(55, 676, 97, 25);
		contentPane.add(btnLogOut);
		

		
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(1304, 824, 166, 16);
		contentPane.add(lblDevelopedByClever);
		
		JButton btnCreateAccount = new JButton("Add Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateAccountInside newAcc = new CreateAccountInside();
				newAcc.main(null);
				
				
			
			}
		});
		btnCreateAccount.setBounds(55, 524, 132, 25);
		contentPane.add(btnCreateAccount);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "Overview", "Patricia Duce", "Michael Cassens", "Yolanda Reimer"}));
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
		
		
		
		
		
		
    
		
		
		//Jtables for each person
		//Overview, small one
		Object smallOverviewData[][] = new Object[][]{{"Patricia Duce", "624950.00", "10/18/17"},
					{"Michael Cassens", "500.00", "10/17/17"},
					{"Yolanda Reimer", "250.00", "10/6/17"},};
		Object[] smallOverviewCol = new Object[]{"Name:","Balance:","Date:"};
		DefaultTableModel model = new DefaultTableModel(smallOverviewData, smallOverviewCol);
		table_1 = new JTable(smallOverviewData, smallOverviewCol);
		table_1.setEnabled(false);
		table_1.setColumnSelectionAllowed(true);
		table_1.setRowHeight(25);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_1.setBorder(null);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(250);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_1.setBounds(467, 200, 594, 375);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setLocation(1144, 137);
		scrollPane.setSize(310, 119);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		
		//Code for Main Overview Table
		//Reading BigData.txt

		String bigDataFile = "BigData.txt";
		String columns[] =  {"Name:", "Amount:", "Transaction:", "To/From:", "Type:", "Date:"};
		JTable contactTable = new JTable();
		DefaultTableModel tableModel;

		// table with 4 columns
		tableModel = new DefaultTableModel(0,6);
		tableModel.setColumnIdentifiers(columns);
		contactTable.setModel(tableModel);
		 
		String line;
		   BufferedReader reader;
		   String[] tokens = null;

		   try
		   {       
		       reader = new BufferedReader(new FileReader(bigDataFile));

		       while((line = reader.readLine()) != null)
		       {
		        	
		        	
		          tableModel.addRow(line.split(",")); 
		          tokens = line.split(",");
		           
		       }
		       reader.close();
		    }
		   catch(IOException e)
		   {
		       JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
		   }

		   for(int i = 0; i < tokens.length; i++) {
			   //System.out.println(tokens[i]);
		   }
		
		   contactTable.setEnabled(false);
		   contactTable.setColumnSelectionAllowed(true);			
		   contactTable.setRowHeight(25);
		   contactTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		   contactTable.setBorder(null);
		   contactTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		   contactTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		   contactTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		   contactTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		   contactTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		   contactTable.getColumnModel().getColumn(5).setPreferredWidth(75);
		   contactTable.setBounds(467, 200, 594, 375);
		   JScrollPane scrollPane1 = new JScrollPane(contactTable);
		   scrollPane1.setLocation(400, 185);
		   scrollPane1.setSize(700, 600);
		   scrollPane1.getViewport().setBackground(Color.WHITE);
		   contentPane.add(scrollPane1);
		
		


		//
		int numOfAccs = comboBox.getItemCount()-1;
		String first = (String) comboBox.getItemAt(0);
		System.out.println(first);
		
		JTextArea txtrUserGuide = new JTextArea();
		txtrUserGuide.setEditable(false);
		Color defColor = this.getBackground();
		txtrUserGuide.setBackground(defColor);
		txtrUserGuide.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrUserGuide.setText("This program allows a user to keep track of the \r\nDepartments funds and spendings via \r\nteachers through the use of dynamic yet simple \r\nimplementationof Java");
		txtrUserGuide.setBounds(55, 347, 280, 75);
		contentPane.add(txtrUserGuide);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 91, 1383, 2);
		contentPane.add(separator);
		
		
		//Getting the Total Balance from the Small Overview Table to show
		TableModel tm = contactTable.getModel();
		int total = 0;
		
		for (int i = 0; i < tm.getRowCount(); i++) 
		{
		  for (int j = 0; j < tm.getColumnCount(); j++) 
		  {
		    Object o = tm.getValueAt(i, j);
		    if (o instanceof Integer) 
		    {
		      int l = (Integer) 0;
		      System.out.println(l);
		      System.out.println((Integer)o);
		      
		    } 
		    else if (o instanceof String) 
		    {
		      System.out.println((String)o);
		    }
		  }
		}
		System.out.println(total);
		
		String totalBalance = (String) smallOverviewData[0][1];
		//double total = Double.parseDouble(totalBalance);
		JLabel lblTotalBalance = new JLabel("Total Balance: " + total);
		lblTotalBalance.setBounds(1144, 269, 294, 25);
		contentPane.add(lblTotalBalance);
		
		JLabel lblOverview = new JLabel("Overview:");
		lblOverview.setBounds(1144, 108, 58, 16);
		contentPane.add(lblOverview);
		
		
		
		JButton btnAddTransaction = new JButton("Add Transaction");
		btnAddTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddTransaction addT = new AddTransaction();
				addT.main(null);
			}
		});
		btnAddTransaction.setBounds(1224, 524, 141, 25);
		contentPane.add(btnAddTransaction);
		
		JButton btnDeleteTranscation = new JButton("Delete Transaction");
		btnDeleteTranscation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this Transaction?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				
			}
		});
		btnDeleteTranscation.setBounds(1224, 562, 150, 25);
		contentPane.add(btnDeleteTranscation);
		
		
		JButton btnDisplayAccountInformation = new JButton("Display Account Information");
		btnDisplayAccountInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String compareName = (String) comboBox.getSelectedItem();
				System.out.println(compareName);
				
				
				
				TableModel tm = contactTable.getModel();
				for (int i = 0; i < tm.getRowCount(); i++) 
				{
				  for (int j = 0; j < tm.getColumnCount(); j++) 
				  {
				    Object o = tm.getValueAt(i, j);
				    if (o instanceof Integer) 
				    {
				      System.out.println((Integer)o);
				    } 
				    else if (o instanceof String) 
				    {
				      System.out.println((String)o);
				    }
				  }
				}
				
				
				//if (contactTable)
				
				//Grab the name from the jtable, and compare it to the name i just grabbed from combo box
				
			}
		});
		btnDisplayAccountInformation.setBounds(55, 486, 205, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		JRadioButton rdbtnFeesPaid = new JRadioButton("Fees paid");
		rdbtnFeesPaid.setBounds(1120, 450, 127, 25);
		contentPane.add(rdbtnFeesPaid);
		
		JLabel lblTransaction = new JLabel("Transaction:");
		lblTransaction.setBounds(1266, 490, 72, 16);
		contentPane.add(lblTransaction);
		
		JButton btnFees = new JButton("Fees");
		btnFees.setBounds(1241, 600, 97, 25);
		contentPane.add(btnFees);
		
		JButton btnPrintReport = new JButton("Print Report");
		btnPrintReport.setBounds(1237, 636, 101, 25);
		contentPane.add(btnPrintReport);
		
		
	}
}
