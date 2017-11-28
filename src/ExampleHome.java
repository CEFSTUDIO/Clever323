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
	private String[] fname, lname, accountType, phoneNumber, email;
	private double[] balance;

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
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Reading in Both bigData and smallData ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Attributes for reading in small data:
		String smallDataFile = "./smallData.txt";
		String bigDataFile = "./bigData.txt";
		String line;
		BufferedReader reader;
		String[] details = null;
		
		Transaction newTransaction;
		Account newAccount;
		ArrayList<Account> smallDataList = new ArrayList<Account>();
		ArrayList<Transaction> bigDataList = new ArrayList<Transaction>();

		//Reading in Big Data
		try{       
		    reader = new BufferedReader(new FileReader(bigDataFile));
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
		    reader = new BufferedReader(new FileReader(smallDataFile));
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
				
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Frame and Graphical ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Main JFrame Statistics
		setIconImage(Toolkit.getDefaultToolkit().getImage("./AppIcon.png"));
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
		String bigColumns[] =  {"Name:", "Amount:", "Transaction:", "To/From:", "Type:", "Date:"};
		JTable bigTable = new JTable();
		DefaultTableModel tableModelB;

		//Table with 4 columns - Big Overview
		tableModelB = new DefaultTableModel(0,6);
		tableModelB.setColumnIdentifiers(bigColumns);
		bigTable.setModel(tableModelB);

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
		
		//~~~~~~~~~~~~~~~~ Small Table ~~~~~~~~~~~~~~~~
		//Small Table Overview
		String smallColumns[] =  {"Name:", "Balance:", "Last Transaction:"};
		JTable smallTable = new JTable();
		DefaultTableModel tableModelS;

		//Table with 4 columns - Small Overview
		tableModelS = new DefaultTableModel(0,3);
		tableModelS.setColumnIdentifiers(smallColumns);
		smallTable.setModel(tableModelS);
		 
		//Attributes for reading in big data:
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
				
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Frame and Graphical ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Label - Main logo, big one
		JLabel lblMainIcon = new JLabel("");
		lblMainIcon.setIcon(new ImageIcon("./logo.png"));
		lblMainIcon.setBounds(65, 117, 210, 210);
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

		//Label - Overview, above smallData table
		JLabel lblOverview = new JLabel("Overview:");
		lblOverview.setFont(new Font("Verdana", Font.BOLD, 11));
		lblOverview.setBounds(1112, 185, 116, 16);
		contentPane.add(lblOverview);
		
		//Label - Transaction
		JLabel lblTransaction = new JLabel("Transaction:");
		lblTransaction.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTransaction.setBounds(1112, 427, 116, 16);
		contentPane.add(lblTransaction);
		
		//Label - Total Balance 
		JLabel lblTotalBalance = new JLabel("Total Balance: " + totalBalance);
		lblTotalBalance.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTotalBalance.setBounds(1112, 371, 232, 25);
		contentPane.add(lblTotalBalance);
		
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
		txtrUserGuide.setBounds(55, 339, 290, 75);
		contentPane.add(txtrUserGuide);
		
		//Combo Box - Choose Combo Box
		JComboBox comboBoxChooseBox = new JComboBox();
		//comboBoxChooseBox.addItem("-- Overview --");
		for (int i = 0; i < smallDataList.size(); i++) {
			comboBoxChooseBox.addItem(smallDataList.get(i).getFirstName() + " " + smallDataList.get(i).getLastName());
		}
		comboBoxChooseBox.setBounds(55, 410, 195, 22);
		contentPane.add(comboBoxChooseBox);
		
		//Button - Log out button - Fully functional - maybe make the JOptionPane appear with our logo
		JButton btnLogOut = new JButton("Log Out");
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
		btnLogOut.setBounds(55, 610, 195, 25);
		contentPane.add(btnLogOut);
		
		//Button - Delete Account - NOT FUNCTIONAL
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBackground(new Color(200, 200, 200));
        btnDeleteAccount.setOpaque(true);
        btnDeleteAccount.setBorderPainted(true);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this account?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION);
				//comboBox.
			}
			
		});
		btnDeleteAccount.setBounds(55, 570, 195, 25);
		contentPane.add(btnDeleteAccount);
		
		
		
		
		
		
    
		

		

		

		//Button - Display Account Information - Can Edit
	   
        String line2 = "";
        String line3 = "";
        int lineCount = 0;
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(smallDataFile))){
            while((line3 = br.readLine()) != null) {
                lineCount++;
            }
            
            System.out.println("LINECOUNT:" + lineCount);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        fname = new String[lineCount];
        lname = new String[lineCount];
        accountType = new String[lineCount];
        phoneNumber = new String[lineCount];
        email = new String[lineCount];
        
        balance = new double[lineCount];
        

        try (BufferedReader br = new BufferedReader(new FileReader(smallDataFile))) {
            int i = 0;
            while ((line2 = br.readLine()) != null) {

                // use comma as separator
                String[] items = line2.split(cvsSplitBy);
                
                System.out.println("--------------------SMALL DATA TEST ---------------------");
                System.out.println(items[0] + items[1]+items[2]+items[3]+items[4]+items[5]);
                
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
		

		
		
		
		

		int numOfAccs = comboBoxChooseBox.getItemCount()-1;
		String first = (String) comboBoxChooseBox.getItemAt(0);
		System.out.println(first);
		
		try{       
		    reader = new BufferedReader(new FileReader(smallDataFile));
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
		
		
		JButton btnDisplayAccountInformation = new JButton("Display Account Information");
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
		btnDisplayAccountInformation.setBounds(55, 490, 195, 25);
		contentPane.add(btnDisplayAccountInformation);
		
		
	
		
		
		
		//Button - Add Account - link to jTable
		JButton btnAddAccount = new JButton("Add Account");
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
		btnAddAccount.setBounds(55, 530, 195, 25);
		contentPane.add(btnAddAccount);
				
		
		

		//Button - Add Transaction
		JButton btnAddTransaction = new JButton("Add Transaction");
		btnAddTransaction.setBackground(new Color(200, 200, 200));
        btnAddTransaction.setOpaque(true);
        btnAddTransaction.setBorderPainted(true);
		btnAddTransaction.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				//Calling AddTransaction panel
				AddTransaction.main(null);
				
				//Adding the row to the table??
				//Attributes:
				String bigDataFile = "./bigData.txt";
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
		btnAddTransaction.setBounds(1112, 458, 150, 25);
		contentPane.add(btnAddTransaction);
		
		JButton btnDeleteTransaction = new JButton("Delete Transaction");
		btnDeleteTransaction.setBackground(new Color(200, 200, 200));
        btnDeleteTransaction.setOpaque(true);
        btnDeleteTransaction.setBorderPainted(true);
		btnDeleteTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this Transaction?", "CleverBudget - Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				
			}
		});
		btnDeleteTransaction.setBounds(1112, 494, 150, 25);
		contentPane.add(btnDeleteTransaction);
		
		
		
		
		JRadioButton rdbtnFeesPaid = new JRadioButton("Fees Paid");
		rdbtnFeesPaid.setOpaque(false);
		rdbtnFeesPaid.setBackground(new Color (0, 0, 0, 100));
		rdbtnFeesPaid.setBounds(1112, 628, 127, 25);
		contentPane.add(rdbtnFeesPaid);
		
		
		
		JButton btnFees = new JButton("Fees");
		btnFees.setBackground(new Color(200, 200, 200));
        btnFees.setOpaque(true);
        btnFees.setBorderPainted(true);
		btnFees.setBounds(1112, 596, 150, 25);
		contentPane.add(btnFees);
		
		
		JButton btnPrintReport = new JButton("Print Report");
		btnPrintReport.setBackground(new Color(200, 200, 200));
        btnPrintReport.setOpaque(true);
        btnPrintReport.setBorderPainted(true);
		btnPrintReport.setBounds(1112, 530, 150, 25);
		btnPrintReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (! bigTable.print()) {
                        System.err.println("User cancelled printing");
                    }
                } catch (java.awt.print.PrinterException f) {
                    System.err.format("Cannot print %s%n", f.getMessage());
                }
                
            }
        });
		contentPane.add(btnPrintReport);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBackground(new Color(200, 200, 200));
        btnFilter.setOpaque(true);
        btnFilter.setBorderPainted(true);
		btnFilter.setBounds(55, 450, 195, 25);
		contentPane.add(btnFilter);
		
		//Label - Background Image - Add last, otherwise it will cover everything
		JLabel background_image = new JLabel();
		background_image.setIcon(new ImageIcon("./res/layout_bg.png"));
		background_image.setBounds(0, 0, 1500, 900);
		contentPane.add(background_image);
		
	} // End of Program
}
