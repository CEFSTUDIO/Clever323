import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAccount extends JFrame {

	private JPanel contentPane;

	//Launch Application:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	//Create The Frame:
	public DeleteAccount() {
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
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//Combo Box - Choose Combo Box
				JComboBox comboBoxChooseBox = new JComboBox();
				
				for (int i = 0; i < smallDataList.size(); i++) {
					comboBoxChooseBox.addItem(smallDataList.get(i).getFirstName() + " " + smallDataList.get(i).getLastName());
				}
				contentPane.setLayout(null);
				comboBoxChooseBox.setBounds(23, 114, 108, 22);
				contentPane.add(comboBoxChooseBox);
				
				
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton.setBounds(84, 226, 97, 25);
				contentPane.add(btnNewButton);
				
				
				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCancel.setBounds(278, 226, 97, 25);
				contentPane.add(btnCancel);
	}
	

}
