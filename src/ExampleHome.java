//Author(s): Cameron Gomke, Hank, Cheyanne, Chase
//File Name: Example Home
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/12/2017
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ExampleHome extends JFrame {

	//Private Attributes:
	private JPanel contentPane;
	private String[] fname, lname, accountType, phoneNumber, email;
	private double[] balance;
	private TableRowSorter<DefaultTableModel> sorter; 
	public static int getIndex;

	//Launch Application:
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
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Reading in Both bigData and smallData ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Attributes for reading in small data:
		String smallDataFile = "smallData.txt";
		String bigDataFile = "bigData.txt";
		String line;
		BufferedReader reader;
		String[] details = null;
		
		Transaction newTransaction;
		Account newAccount;
		ArrayList<Account> smallDataList = new ArrayList<Account>();
		ArrayList<Transaction> bigDataList = new ArrayList<Transaction>();

		//Reading in Big Data
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
		    while((line = reader.readLine()) != null){
		    	
		    	//Splitting the line, and adding the first and last name to transaction (names)
		    	details = line.split(",");
		        newTransaction = new Transaction();
		        newTransaction.setName(details[0]);
		        newTransaction.setAmount(Double.parseDouble(details[1]));
		        newTransaction.setDepositOrWithdraw(details[2]);
		        newTransaction.setToOrFrom(details[3]);
		        newTransaction.setType(details[4]);
		        newTransaction.setDate(details[5]);
		        bigDataList.add(newTransaction);

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
		
		//Reading in Small Data
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)));
		    while((line = reader.readLine()) != null){
		    	
		    	//Splitting the line, and adding the first and last name to transaction (names)
		    	details = line.split(",");
		        newAccount = new Account();
		        newAccount.setFirstName(details[0]);
		        newAccount.setLastName(details[1]);
		        newAccount.setStartingBalance(Double.parseDouble(details[2]));
		        newAccount.setDescription(details[3]);
		        newAccount.setPhoneNumber(details[4]);
		        newAccount.setEmail(details[5]);
		        smallDataList.add(newAccount);

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
		
		//System.out.println(smallDataList.toString());
		//System.out.println(bigDataList.toString());
				
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Frame and Graphical ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Main JFrame Statistics
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("res/AppIcon.png")));
		setTitle("CleverBudget - Homepage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Separator - Looks nice
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 91, 1383, 2);
		contentPane.add(separator);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Code for Main Overview Tables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//~~~~~~~~~~~~~~~~ Big Table ~~~~~~~~~~~~~~~~
		//Big Table Overview
		String bigColumns[] =  {"Name:", "Amount:", "Transaction:", "To/From:", "Type:", "Code:", "Date:"};
		JTable bigTable = new JTable();
		bigTable.setEnabled(false);
		bigTable.setCellSelectionEnabled(true);
		bigTable.setColumnSelectionAllowed(true);
		bigTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel tableModelB;


		//Table with 4 columns - Big Overview
		tableModelB = new DefaultTableModel(0,7);
		tableModelB.setColumnIdentifiers(bigColumns);
		bigTable.setModel(tableModelB);

		//Reading in the file, adding the data within to bigTable
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
		       
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
		bigTable.setRowHeight(25);
		bigTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bigTable.setBorder(null);
		bigTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		bigTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		bigTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		bigTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		bigTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		bigTable.getColumnModel().getColumn(5).setPreferredWidth(150);
		bigTable.getColumnModel().getColumn(6).setPreferredWidth(75);
		bigTable.setBounds(467, 200, 594, 375);
		JScrollPane scrollPane = new JScrollPane(bigTable);
		scrollPane.setLocation(347, 187);
		scrollPane.setSize(862, 458);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		//~~~~~~~~~~~~~~~~ Small Table ~~~~~~~~~~~~~~~~
		//Small Table Overview
		String smallColumns[] =  {"Name:", "Balance:", "Last Transaction:"};
		DefaultTableModel tableModelS;

		//Table with 4 columns - Small Overview
		tableModelS = new DefaultTableModel(0,3);
		tableModelS.setColumnIdentifiers(smallColumns);
		 
		//Attributes for reading in big data:
		Transaction newT;
		ArrayList<Transaction> bigData = new ArrayList<Transaction>();

		//Reading in the file, adding the data within to bigTable
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
		       
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
			
			
		}
				
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Frame and Graphical ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Label - Main logo, big one
		JLabel lblMainIcon = new JLabel();
		lblMainIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/logo.png")));
		lblMainIcon.setBounds(65, 104, 210, 210);
		contentPane.add(lblMainIcon);
		
		//Label - Welcome Text
		JLabel lblHomepage = new JLabel("Welcome to CleverBudget!");
		lblHomepage.setFont(new Font("Verdana", Font.BOLD, 31));
		lblHomepage.setBounds(55, 31, 555, 62);
		contentPane.add(lblHomepage);
		
		//Label - Developed by:
		JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
		lblDevelopedByClever.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopedByClever.setBounds(1304, 824, 166, 16);
		contentPane.add(lblDevelopedByClever);
		
		//Label - Total Balance 
		JLabel lblTotalBalance = new JLabel("Total Balance: " + totalBalance);
		lblTotalBalance.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTotalBalance.setBounds(650, 656, 514, 54);
		contentPane.add(lblTotalBalance);
		
		//Label - Transaction
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTransaction.setBounds(1234, 190, 136, 16);
		contentPane.add(lblTransaction);
		
		//Label - Account
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAccount.setBounds(1253, 504, 86, 16);
		contentPane.add(lblAccount);
		
		//Label - All Transactions
		JLabel lblAllTransactions = new JLabel("All Transactions:");
		lblAllTransactions.setFont(new Font("Verdana", Font.BOLD, 20));
		lblAllTransactions.setBounds(650, 128, 437, 57);
		contentPane.add(lblAllTransactions);
		
		//Text Area - Small User Guide
		JTextArea txtrUserGuide = new JTextArea();
		txtrUserGuide.setEditable(false);
		txtrUserGuide.setOpaque(false);
		txtrUserGuide.setBackground(new Color (0, 0, 0, 100));
		txtrUserGuide.setFont(new Font("Verdana", Font.BOLD, 11));
		txtrUserGuide.setText("This Program allows a user to keep track of\r\n"
				+ "the Department's funds and spendings via\r\n"
				+ "professors through the use of dynamic, yet\r\n"
				+ "simple implementation of Java!");
		txtrUserGuide.setBounds(55, 324, 290, 75);
		contentPane.add(txtrUserGuide);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Combo Box - Choose Combo Box
		JComboBox comboBoxChooseBox = new JComboBox();
		comboBoxChooseBox.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBoxChooseBox.addItem("-- Overview --");
		for (int i = 0; i < smallDataList.size(); i++) {
			comboBoxChooseBox.addItem(smallDataList.get(i).getFirstName() + " " + smallDataList.get(i).getLastName());
		}
		comboBoxChooseBox.setBounds(55, 397, 195, 22);
		contentPane.add(comboBoxChooseBox);
		
		
		
		//Button - Log out button - Fully functional - maybe make the JOptionPane appear with our logo
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Verdana", Font.BOLD, 10));
		btnLogOut.setBackground(new Color(225, 79, 79));
        btnLogOut.setOpaque(true);
        btnLogOut.setBorderPainted(true);
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
		btnLogOut.setBounds(55, 618, 195, 25);
		contentPane.add(btnLogOut);
		
		//Button - Delete Account - NOT FUNCTIONAL
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setFont(new Font("Verdana", Font.BOLD, 10));
		btnDeleteAccount.setBackground(new Color(200, 200, 200));
        btnDeleteAccount.setOpaque(true);
        btnDeleteAccount.setBorderPainted(true);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAccount.main(null);
			}
			
		});
		btnDeleteAccount.setBounds(1219, 619, 141, 25);
		contentPane.add(btnDeleteAccount);
		
		
		
		
		
		
    
		

		

		

		//Button - Display Account Information - Can Edit
	   
        String line2 = "";
        String line3 = "";
        int lineCount = 0;
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)))){
            while((line3 = br.readLine()) != null) {
                lineCount++;
            }
            
           // System.out.println("LINECOUNT:" + lineCount);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        fname = new String[lineCount];
        lname = new String[lineCount];
        accountType = new String[lineCount];
        phoneNumber = new String[lineCount];
        email = new String[lineCount];
        
        balance = new double[lineCount];
        

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)))) {
            int i = 0;
            while ((line2 = br.readLine()) != null) {

                // use comma as separator
                String[] items = line2.split(cvsSplitBy);
                
               // System.out.println("--------------------SMALL DATA TEST ---------------------");
               // System.out.println(items[0] + items[1]+items[2]+items[3]+items[4]+items[5]);
                
                fname[i] = items[0];
                lname[i] = items[1];
                balance[i] = Double.parseDouble(items[2]);
                accountType[i] = items[3];
                phoneNumber[i] = items[4];
                email[i] = items[5];
                i++;
                

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		

		
		
		
		

		
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)));
		    while((line = reader.readLine()) != null){
		    	
		    	//Splitting the line, and adding the first and last name to transaction (names)
		    	details = line.split(",");
		        newAccount = new Account();
		        newAccount.setFirstName(details[0]);
		        newAccount.setLastName(details[1]);
		        newAccount.setStartingBalance(Double.parseDouble(details[2]));
		        newAccount.setDescription(details[3]);
		        newAccount.setPhoneNumber(details[4]);
		        newAccount.setEmail(details[5]);
		        smallDataList.add(newAccount);

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
		
		
		JButton btnDisplayAccountInformation = new JButton("Display Account Info");
		btnDisplayAccountInformation.setFont(new Font("Verdana", Font.BOLD, 10));
		btnDisplayAccountInformation.setBackground(new Color(200, 200, 200));
        btnDisplayAccountInformation.setOpaque(true);
        btnDisplayAccountInformation.setBorderPainted(true);
		btnDisplayAccountInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String compareName = (String) comboBoxChooseBox.getSelectedItem();

				for(int i = 0; i < fname.length; i++) {
				    if(compareName.equals(fname[i] + " " + lname[i])) {
				        String infoMessage = "Name: " + fname[i] + " " + lname[i] + "\nAccount Type: " + accountType[i] 
				                + "\nAccount Balance: " + balance[i] + "\nPhone Number: " + phoneNumber[i] + "\nEmail: " + email[i];
				        
				        JOptionPane.showMessageDialog(null, infoMessage, "Account Information", JOptionPane.INFORMATION_MESSAGE);
				    }
				}
				
				
				
				
				
				
				
				
			}
		});
		btnDisplayAccountInformation.setBounds(55, 466, 195, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		
	
		
		
		
		//Button - Add Account - link to jTable
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setFont(new Font("Verdana", Font.BOLD, 10));
		btnAddAccount.setBackground(new Color(200, 200, 200));
        btnAddAccount.setOpaque(true);
        btnAddAccount.setBorderPainted(true);
		btnAddAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CreateAccountInside.main(null);
				
				
				
			}
		});
		btnAddAccount.setBounds(1219, 541, 141, 25);
		contentPane.add(btnAddAccount);
				
		
		

		//Button - Add Transaction
		JButton btnAddTransaction = new JButton("Add Transaction");
		btnAddTransaction.setFont(new Font("Verdana", Font.BOLD, 10));
		btnAddTransaction.setBackground(new Color(200, 200, 200));
        btnAddTransaction.setOpaque(true);
        btnAddTransaction.setBorderPainted(true);
		btnAddTransaction.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Calling AddTransaction panel
				AddTransaction.main(null);
				
			}
			
		});
		btnAddTransaction.setBounds(1219, 226, 141, 25);
		contentPane.add(btnAddTransaction);
		
		
		//Button - Delete Transaction - NOT FUNCTIONAL
		JButton btnDeleteTransaction = new JButton("Delete Transaction");
		btnDeleteTransaction.setFont(new Font("Verdana", Font.BOLD, 10));
		btnDeleteTransaction.setBackground(new Color(200, 200, 200));
        btnDeleteTransaction.setOpaque(true);
        btnDeleteTransaction.setBorderPainted(true);
		btnDeleteTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Calling DeleteTransaction panel
				DeleteTransaction.main(null);
			}
		});
		btnDeleteTransaction.setBounds(1219, 262, 141, 25);
		contentPane.add(btnDeleteTransaction);
		
		
		//Button - Fees - NOT FUNCTIONAL
		JButton btnFees = new JButton("Fees");
		//Button Attributes:
		btnFees.setFont(new Font("Verdana", Font.BOLD, 10));
		btnFees.setBackground(new Color(200, 200, 200));
        btnFees.setOpaque(true);
        btnFees.setBorderPainted(true);
		btnFees.setBounds(55, 540, 195, 25);
		contentPane.add(btnFees);
		
		//Button - Print Report - FUNCTIONAL
		JButton btnPrintReport = new JButton("Print Report");
		//Button Attributes:
		btnPrintReport.setFont(new Font("Verdana", Font.BOLD, 10));
		btnPrintReport.setBackground(new Color(200, 200, 200));
        btnPrintReport.setOpaque(true);
        btnPrintReport.setBorderPainted(true);
		btnPrintReport.setBounds(55, 502, 195, 25);
		//Button Action Listener:
		btnPrintReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (! bigTable.print()) {
                        System.err.println("User Cancelled Printing");
                    }
                } catch (java.awt.print.PrinterException f) {
                    System.err.format("Cannot print %s%n", f.getMessage());
                }
                
            }
        });
		contentPane.add(btnPrintReport);
		
		//Button - Filter
		JButton btnFilter = new JButton("Filter");
		//Button Attributes:
		btnFilter.setFont(new Font("Verdana", Font.BOLD, 10));
		btnFilter.setBackground(new Color(200, 200, 200));
        btnFilter.setOpaque(true);
        btnFilter.setBorderPainted(true);
		btnFilter.setBounds(55, 430, 195, 25);
		//Button Action Listener:
		btnFilter.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if(comboBoxChooseBox.getSelectedItem().equals("-- Overview --")) {
	            		RowFilter<DefaultTableModel, Object> overviewFilter  = RowFilter.regexFilter("",0);
		                sorter.setRowFilter(overviewFilter);
	            	}
	            	else {
	            		RowFilter<DefaultTableModel, Object> personFilter  = RowFilter.regexFilter(comboBoxChooseBox.getSelectedItem().toString(), 0);
		                sorter.setRowFilter(personFilter);
	            	}
	            }
	        });
		contentPane.add(btnFilter);
		//Filter Button Misc
		sorter = new TableRowSorter<DefaultTableModel>(tableModelB);
	    bigTable.setRowSorter(sorter);
		

		//Button - Refreshes Main Table - Functional - Can make it refresh smaller tables too
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Verdana", Font.BOLD, 10));
	    btnRefresh.setBackground(new Color(70, 137, 191));
	    btnRefresh.setOpaque(true);
	    btnRefresh.setBorderPainted(true);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableModelB.fireTableDataChanged();
				
				String bigDataFile = "bigData.txt";
				String line;
				BufferedReader reader;
				String[] details = null;
				
				Transaction newTransaction;
				Account newAccount;
				ArrayList<Account> smallDataList = new ArrayList<Account>();
				ArrayList<Transaction> bigDataList = new ArrayList<Transaction>();

				//Reading in Big Data
				try{       
				    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
				    while((line = reader.readLine()) != null){
				    	
				    	//Splitting the line, and adding the first and last name to transaction (names)
				    	details = line.split(",");
				        newTransaction = new Transaction();
				        newTransaction.setName(details[0]);
				        newTransaction.setAmount(Double.parseDouble(details[1]));
				        newTransaction.setDepositOrWithdraw(details[2]);
				        newTransaction.setToOrFrom(details[3]);
				        newTransaction.setType(details[4]);
				        newTransaction.setDate(details[5]);
				        bigDataList.add(newTransaction);

				    }
				    reader.close();
				 }
						   
				//Catching Errors
				catch(FileNotFoundException e1){
				    JOptionPane.showMessageDialog(null, "File not Found.");
				}
				catch(IOException e1){
				    JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
				}
				
				//~~~~~~~~~~~~~~~~ Big Table ~~~~~~~~~~~~~~~~
				//Big Table Overview
				String bigColumns[] =  {"Name:", "Amount:", "Transaction:", "To/From:", "Type:", "Code:", "Date:"};
				JTable bigTable = new JTable();
				bigTable.setEnabled(false);
				bigTable.setCellSelectionEnabled(true);
				bigTable.setColumnSelectionAllowed(true);
				bigTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				DefaultTableModel tableModelB;


				//Table with 4 columns - Big Overview
				tableModelB = new DefaultTableModel(0,7);
				tableModelB.setColumnIdentifiers(bigColumns);
				bigTable.setModel(tableModelB);

				//Reading in the file, adding the data within to bigTable
				try{       
				    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
				       
				    while((line = reader.readLine()) != null){
				       tableModelB.addRow(line.split(",")); 
				    }
				    reader.close();
				 }
				   
				//Catching Errors
				catch(FileNotFoundException e1){
				    JOptionPane.showMessageDialog(null, "File not Found.");
				}
				catch(IOException e1){
				    JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
				}
				bigTable.setRowHeight(25);
				bigTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
				bigTable.setBorder(null);
				bigTable.getColumnModel().getColumn(0).setPreferredWidth(150);
<<<<<<< HEAD
				bigTable.getColumnModel().getColumn(1).setPreferredWidth(75);
				bigTable.getColumnModel().getColumn(2).setPreferredWidth(100);
				bigTable.getColumnModel().getColumn(3).setPreferredWidth(200);
				bigTable.getColumnModel().getColumn(4).setPreferredWidth(100);
				bigTable.getColumnModel().getColumn(5).setPreferredWidth(150);
				bigTable.getColumnModel().getColumn(6).setPreferredWidth(75);
				bigTable.setBounds(467, 200, 594, 375);
				JScrollPane scrollPane = new JScrollPane(bigTable);
				scrollPane.setLocation(365, 185);
				scrollPane.setSize(862, 458);
				scrollPane.getViewport().setBackground(Color.WHITE);
				contentPane.add(scrollPane);
=======
		        bigTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		        bigTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		        bigTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		        bigTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		        bigTable.getColumnModel().getColumn(5).setPreferredWidth(150);
		        bigTable.getColumnModel().getColumn(6).setPreferredWidth(75);
		        bigTable.setBounds(467, 200, 594, 375);
		        JScrollPane scrollPane = new JScrollPane(bigTable);
		        scrollPane.setLocation(347, 187);
		        scrollPane.setSize(862, 458);
		        scrollPane.getViewport().setBackground(Color.WHITE);
		        contentPane.add(scrollPane);
>>>>>>> 4315683b6c78df9b992c6168788a9bdc874ae17b
				
			    
				
				
				
				

			}
		});
		btnRefresh.setBounds(55, 576, 195, 25);
		contentPane.add(btnRefresh);
		
		
		
		
	    //Button - Modify Account - NOT FUNCTIONAL
		JButton btnModifyAccount = new JButton("Modify Account");
		btnModifyAccount.setBackground(new Color(200,200,200));
		btnModifyAccount.setFont(new Font("Verdana", Font.BOLD, 10));
		btnModifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(comboBoxChooseBox.getSelectedIndex() != 0) {
				ModifyAccount.main(comboBoxChooseBox.getSelectedIndex());
				}
			}
		});
		btnModifyAccount.setBounds(1219, 583, 141, 25);
		contentPane.add(btnModifyAccount);
		
		
		
		
		
		
		//Label - Background Image - Add last, otherwise it will cover everything
		JLabel background_image = new JLabel();
		background_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/layout_bg.png")));
		background_image.setBounds(0, 0, 1500, 900);
		contentPane.add(background_image);
		
		
	}
	
}
