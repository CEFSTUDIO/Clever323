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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class ExampleHome extends JFrame {

	//Private Attributes
	private JPanel contentPane;


	//Launch Application
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

	//Creating the Frame:
	public ExampleHome() {
		//Main JFrame Statistics
		setIconImage(Toolkit.getDefaultToolkit().getImage("./src/res/BrowserIcon.png"));
		setTitle("CleverBudget - Homepage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label - Main logo, big one
		JLabel lblMainIcon = new JLabel("");
		lblMainIcon.setIcon(new ImageIcon("./src/res/logo.png"));
		lblMainIcon.setBounds(65, 117, 210, 210);
		contentPane.add(lblMainIcon);
		
		//Label - Welcome Text
		JLabel lblHomepage = new JLabel("Welcome to CleverBudget!");
		lblHomepage.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblHomepage.setBounds(55, 31, 374, 62);
		contentPane.add(lblHomepage);
		
		//Label - Developed by:
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(1304, 824, 166, 16);
		contentPane.add(lblDevelopedByClever);

		//Label - Overview, above smallData table
		JLabel lblOverview = new JLabel("Overview:");
		lblOverview.setBounds(1112, 106, 58, 16);
		contentPane.add(lblOverview);
		
		//Label - Transaction
		JLabel lblTransaction = new JLabel("Transaction:");
		lblTransaction.setBounds(1266, 490, 72, 16);
		contentPane.add(lblTransaction);
		
		

		//Button - Log out button - Fully functional - maybe make the JOptionPane appear with our logo
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame exitFrame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(exitFrame, "Are you sure you want to log out?", "Log Out", 
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION) 
				{
					Login_System.main(null);
					dispose();
				}
			}
		});
		btnLogOut.setBounds(55, 650, 97, 25);
		contentPane.add(btnLogOut);
		
		
		
				
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Choose --", "Overview", "Patricia Duce", "Michael Cassens", "Yolanda Reimer"}));
		comboBox.setBounds(55, 450, 195, 22);
		contentPane.add(comboBox);
		
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this account?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION);
				//comboBox.
			}
			
		});
		btnDeleteAccount.setBounds(55, 610, 132, 25);
		contentPane.add(btnDeleteAccount);
		
		
		
		
		
		
    
		
/*		//Small Overview
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
		JScrollPane scrollPane1 = new JScrollPane(table_1);
		scrollPane1.setLocation(1144, 137);
		scrollPane1.setSize(310, 119);
		scrollPane1.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane1);*/
		
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Code for Main Overview Tables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Big Table Overview
		String bigColumns[] =  {"Name:", "Amount:", "Transaction:", "To/From:", "Type:", "Date:"};
		JTable bigTable = new JTable();
		DefaultTableModel tableModelB;

		//Table with 4 columns - Big Overview
		tableModelB = new DefaultTableModel(0,6);
		tableModelB.setColumnIdentifiers(bigColumns);
		bigTable.setModel(tableModelB);
		 
		//Attributes for reading in big data:
		String bigDataFile = "./src/bigData.txt";
		String line;
		BufferedReader reader;

		//Reading in the file, adding the data within to bigTable
		try{       
		    reader = new BufferedReader(new FileReader(bigDataFile));
		       
		    while((line = reader.readLine()) != null){
		       tableModelB.addRow(line.split(",")); 
		    }
		    reader.close();
		 }
		   
		//Catching Errors
		catch(FileNotFoundException e1){
		    JOptionPane.showMessageDialog(null, "File not Found.");
		}
		catch(IOException e){
		    JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
		}
		
		//Big table Statistics
		bigTable.setEnabled(false);
		bigTable.setColumnSelectionAllowed(true);			
		bigTable.setRowHeight(25);
		bigTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bigTable.setBorder(null);
		bigTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		bigTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		bigTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		bigTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		bigTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		bigTable.getColumnModel().getColumn(5).setPreferredWidth(75);
		bigTable.setBounds(467, 200, 594, 375);
		JScrollPane scrollPane = new JScrollPane(bigTable);
		scrollPane.setLocation(400, 185);
		scrollPane.setSize(700, 600);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		
		//Small Table Overview
		String smallColumns[] =  {"Name:", "Balance:", "Last Transaction:"};
		JTable smallTable = new JTable();
		DefaultTableModel tableModelS;

		//Table with 4 columns - Small Overview
		tableModelS = new DefaultTableModel(0,3);
		tableModelS.setColumnIdentifiers(smallColumns);
		smallTable.setModel(tableModelS);
		 
		//Attributes for reading in big data:
		String[] details = null;
		Transaction newT;
		ArrayList<Transaction> bigData = new ArrayList<Transaction>();


		//Reading in the file, adding the data within to bigTable
		try{       
		    reader = new BufferedReader(new FileReader(bigDataFile));
		       
		    while((line = reader.readLine()) != null){
		       details = line.split(",");
		       newT = new Transaction();
		       newT.setName(details[0]);
		       newT.setAmount(Double.parseDouble(details[1]));
		       newT.setDepositOrWithdraw(details[2]);
		       newT.setToOrFrom(details[3]);
		       newT.setType(details[4]);
		       newT.setDate(details[5]);
		       bigData.add(newT);
		       
		       tableModelS.addRow(line.split(",")); 
		    }
		    reader.close();
		 }
		   
		//Catching Errors
		catch(FileNotFoundException e1){
		    JOptionPane.showMessageDialog(null, "File not Found.");
		}
		catch(IOException e){
		    JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
		}
		
		double totalBalance = 0;
		for(int i = 0; i < bigData.size(); i++) 
		{
			if(bigData.get(i).getDepositOrWithdraw().equalsIgnoreCase("Expense")){
				totalBalance -= bigData.get(i).getAmount();
			}
			else {
				totalBalance += bigData.get(i).getAmount();
			}
			
			System.out.println(bigData.get(i).toString());
			System.out.println(totalBalance);
		}
		//Small table Statistics
		smallTable.setEnabled(false);
		smallTable.setColumnSelectionAllowed(true);			
		smallTable.setRowHeight(25);
		smallTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		smallTable.setBorder(null);
		smallTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		smallTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		smallTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		smallTable.setBounds(800, 200, 594, 375);
		JScrollPane scrollPane1 = new JScrollPane(smallTable);
		scrollPane1.setLocation(1112, 137);
		scrollPane1.setSize(346, 137);
		scrollPane1.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane1);		
		
		
		//Button - Add Account - link to jTable
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CreateAccountInside.main(null);
			}
		});
		btnAddAccount.setBounds(55, 570, 132, 25);
		contentPane.add(btnAddAccount);
		
		//Label - Total Balance 
		JLabel lblTotalBalance = new JLabel("Total Balance: " + totalBalance);
		lblTotalBalance.setBounds(1112, 287, 294, 25);
		contentPane.add(lblTotalBalance);
		
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
		TableModel tm = bigTable.getModel();
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
		
		
		
		
		

		//Button - Add Transaction
		JButton btnAddTransaction = new JButton("Add Transaction");
		btnAddTransaction.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				//Calling AddTransaction panel
				AddTransaction.main(null);
				
				//Adding the row to the table??
				//Attributes:
				String bigDataFile = "./src/bigData.txt";
				BufferedReader reader = null;
				
				String line;
				String details[] = null;
				
				//Reading in the file, parsing the file:
				try 
				{
					reader = new BufferedReader( new FileReader(bigDataFile) );
					while ((line = reader.readLine()) != null) 
					{
						details = line.split(",");
						String name = details[0];
						String amount = details[1];
						String transaction = details[2];
						String toFrom = details[3];
						String type = details[4];
						String date = details[5];
					}
				} 
				//Catching Errors:
				catch (FileNotFoundException e1) 
				{
					System.out.println("Was not able to find the file: bigData.txt," + bigDataFile);
					e1.printStackTrace();
				}
				catch (IOException e2) 
				{
					System.out.println("IOE Exception");
					e2.printStackTrace();
				}
				
				
				
				tableModelB.addRow(details);
				
				
				
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
				
				
				
				
				
				
				
			}
		});
		btnDisplayAccountInformation.setBounds(55, 530, 205, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		JRadioButton rdbtnFeesPaid = new JRadioButton("Fees paid");
		rdbtnFeesPaid.setBounds(1120, 450, 127, 25);
		contentPane.add(rdbtnFeesPaid);
		
		
		
		JButton btnFees = new JButton("Fees");
		btnFees.setBounds(1241, 600, 97, 25);
		contentPane.add(btnFees);
		
		JButton btnPrintReport = new JButton("Print Report");
		btnPrintReport.setBounds(1237, 636, 101, 25);
		contentPane.add(btnPrintReport);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(55, 490, 97, 25);
		contentPane.add(btnFilter);
		
		
	}
}
