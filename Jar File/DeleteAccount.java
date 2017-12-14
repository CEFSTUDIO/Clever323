//Author(s): Cameron Gomke, Cheyanne
//File Name: Delete Account 
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/12/2017
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class DeleteAccount extends JFrame {

	private JPanel contentPane;

	//Launch Application:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
					frame.getContentPane().setBackground(new Color(207, 210, 215));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(this, "There is a tranaction associated with this account, please delete all transactions prior");
	}
	
	
	//Create The Frame:
	public DeleteAccount() {
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Attributes for reading in small and big data: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		String smallDataFile = "smallData.txt";
		String bigDataFile = "bigData.txt";
		String line;
		BufferedReader reader;
		String[] details = null;
		
		Transaction newTransaction;
		Account newAccount;
		ArrayList<Account> smallDataList = new ArrayList<Account>();
		ArrayList<Transaction> bigDataList = new ArrayList<Transaction>();

		//Reading in Big Data:
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
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Statistics for Frame: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("res/AppIcon.png")));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Delete Account");
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Label - Title
		JLabel lblTitle = new JLabel("Please Choose an Account to Delete:");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTitle.setBounds(12, 25, 362, 16);
		contentPane.add(lblTitle);
		
		//Separator - Looks nice
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 364, 2);
		contentPane.add(separator);
		
		//Combo Box - Choose Combo Box
		JComboBox<String> comboBoxChooseBox = new JComboBox<String>();
		for (int i = 0; i < smallDataList.size(); i++) {
			comboBoxChooseBox.addItem(smallDataList.get(i).getFirstName() + " " + smallDataList.get(i).getLastName());
		}
		contentPane.setLayout(null);
		comboBoxChooseBox.setBounds(32, 95, 310, 22);
		contentPane.add(comboBoxChooseBox);		
		
		//Button - Cancel - FUNCTIONAL
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.BOLD, 11));
		//Button Attributes:
		btnCancel.setBackground(new Color(225, 79, 79));
		btnCancel.setOpaque(true);
		btnCancel.setBorderPainted(true);
		//Button Action Listener:
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(245, 149, 97, 25);
		contentPane.add(btnCancel);
		
		
		
		//Button - Delete - NOT FUNCTIONAL
		JButton btnDelete = new JButton("Delete");
		//Button Attributes:
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDelete.setBackground(new Color(70, 137, 191));
		btnDelete.setOpaque(true);
        btnDelete.setBorderPainted(true);
        //Button Action Listener:
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < bigDataList.size(); i++)
				{
					if(bigDataList.get(i).getName().equalsIgnoreCase((String) comboBoxChooseBox.getSelectedItem())) 
					{
						showMessage();
						return;
					}
				}

				JFrame deleteFrame = new JFrame("Delete Confirmation");
				if (JOptionPane.showConfirmDialog(deleteFrame, "Are you sure you want to delete '" + comboBoxChooseBox.getSelectedItem() + "'?", "Delete Confirmation", 
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) 
				{
										
					
					File inputFile = new File("smallData.txt");
					File tempFile = new File("smallDataEx.txt");

					
					BufferedReader reader;
					try {
						reader = new BufferedReader(new FileReader(inputFile));
						BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

						String lineToRemove = (String) comboBoxChooseBox.getSelectedItem();
						String currentLine;
						
						while((currentLine = reader.readLine()) != null) {
						    // trim newline when comparing with lineToRemove
						    String trimmedLine = currentLine.trim();
						    
						    // Split line into tokens
						    String[] tokens = trimmedLine.split(",");
						    
						    // First name + space + last name
						    String currentName = tokens[0] + " " + tokens[1];
						    
						    if(currentName.equalsIgnoreCase(lineToRemove)) continue;
						    writer.write(currentLine + System.getProperty("line.separator"));
						}
						writer.close();
						reader.close(); 
						inputFile.delete();
						boolean successful = tempFile.renameTo(inputFile);
						
			
					} 
					catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					catch (IOException e2) {
						e2.printStackTrace();
					}
				}

				
				dispose();
				
			}
		});
		btnDelete.setBounds(32, 149, 97, 25);
		contentPane.add(btnDelete);
	
	} // End of Frame
}
