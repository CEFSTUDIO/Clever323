//Author(s): Cameron Gomke, Cheyanne Flickinger
//File Name: AddTransaction (used for a button in the main function)
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/03/2017
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AddTransaction extends JFrame {

	//Private Attributes:
	private JPanel contentPane;
	private JTextField textAmount;
	private JTextField textToFrom;
	private JTextField textDate;

	//Launch The Application:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTransaction frame = new AddTransaction();
					frame.getContentPane().setBackground(new Color(207, 210, 215));
                    frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the Frame:
	public AddTransaction() {
		//Attributes for reading in small data:
		String smallDataFile = "smallData.txt";
		String line;
		BufferedReader reader;
		String[] details = null;
		Transaction newT;
		ArrayList<Transaction> names = new ArrayList<Transaction>();

		//Reading in the file, used for Name Combo Box
		try{       
		    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(smallDataFile)));
		    while((line = reader.readLine()) != null){
		    	//Splitting the line, and adding the first and last name to transaction (names)
		    	details = line.split(",");
		        newT = new Transaction();
		        newT.setName(details[0] + " " + details[1]);
		        names.add(newT);
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
		
		//Add Transaction Statistics
		setTitle("Cleverbudget - Add Transaction");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("res/BrowserIcon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Separator - Looks nice
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 39, 431, 2);
		contentPane.add(separator);
		
		//Label - Overall Title
		JLabel lblAddANew = new JLabel("Add A New Transaction\r\n");
		lblAddANew.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAddANew.setBounds(150, 11, 215, 22);
		contentPane.add(lblAddANew);
		
		//Label - Name
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblName.setBounds(30, 70, 140, 19);
		contentPane.add(lblName);
		
		//Label - Amount
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmount.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAmount.setBounds(30, 100, 140, 16);
		contentPane.add(lblAmount);
		
		//Label - Transaction
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTransaction.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTransaction.setBounds(30, 130, 140, 16);
		contentPane.add(lblTransaction);
		
		//Label - To/From
		JLabel lblToFrom = new JLabel("To/From");
		lblToFrom.setFont(new Font("Verdana", Font.BOLD, 16));
		lblToFrom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblToFrom.setBounds(30, 160, 140, 16);
		contentPane.add(lblToFrom);
		
		//Label - Payment Type
		JLabel lblType = new JLabel("Payment Type");
		lblType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblType.setFont(new Font("Verdana", Font.BOLD, 16));
		lblType.setBounds(30, 190, 140, 19);
		contentPane.add(lblType);
		
		//Label - Date
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDate.setBounds(30, 220, 140, 16);
		contentPane.add(lblDate);
		
		//Combo Box - Name Box
		JComboBox<String> comboBoxNameBox = new JComboBox<String>();
		for(int i = 0; i < names.size(); i++) 
		{
			comboBoxNameBox.addItem(names.get(i).getName());
		}
		comboBoxNameBox.setBackground(Color.WHITE);
		comboBoxNameBox.setBounds(180, 70, 164, 22);
		contentPane.add(comboBoxNameBox);
		
		//Text Field - Amount
		textAmount = new JTextField();
		textAmount.setBounds(180, 100, 164, 22);
		contentPane.add(textAmount);
		textAmount.setColumns(10);
		
		//Combo Box - Deposit or Expense
		JComboBox<String> comboBoxTransactionBox = new JComboBox<String>();
		comboBoxTransactionBox.addItem("Expense");
		comboBoxTransactionBox.addItem("Deposit");
		comboBoxTransactionBox.setBackground(Color.WHITE);
		comboBoxTransactionBox.setBounds(180, 130, 164, 22);
		contentPane.add(comboBoxTransactionBox);
		
		//Text Field - To/From
		textToFrom = new JTextField();
		textToFrom.setBounds(180, 160, 164, 22);
		contentPane.add(textToFrom);
		textToFrom.setColumns(10);
		
		//Combo Box - Payment Type Box
		JComboBox<String> comboBoxPaymentTypeBox = new JComboBox<String>();
		comboBoxPaymentTypeBox.addItem("Credit Card");
		comboBoxPaymentTypeBox.addItem("Debit Card");
		comboBoxPaymentTypeBox.addItem("Check");
		comboBoxPaymentTypeBox.addItem("Cash");
		comboBoxPaymentTypeBox.setBackground(Color.WHITE);
		comboBoxPaymentTypeBox.setBounds(180, 190, 164, 22);
		contentPane.add(comboBoxPaymentTypeBox);
		
		//Text Field - Date
		textDate = new JTextField();
		textDate.setFont(new Font("Verdana", Font.BOLD, 11));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		textDate.setText(dateFormat.format(date));
		textDate.setBounds(180, 220, 164, 22);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		//Button - Add Transaction (The Magic)
		JButton btnNewButton = new JButton("Add Transaction");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(70, 137, 191));
		btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Grabbing text / data
				String name = (String) comboBoxNameBox.getSelectedItem();
				String amount = textAmount.getText();
				String transaction = (String) comboBoxTransactionBox.getSelectedItem();
				String toFrom = textToFrom.getText();
				String paymentType = (String) comboBoxPaymentTypeBox.getSelectedItem();
				String date = textDate.getText();
				
				//delete
				System.out.println(name + "," + amount + "," + transaction + "," + toFrom + "," + paymentType + "," + date);
				
				//Error checking for if Amount is a number
				int size = amount.length();
				int sizeError = 0;
				
				for (int i = 0; i < size; i++) 
				{
					if (!Character.isDigit(amount.charAt(i))) 
					{
						sizeError += 1;
					}
				}
				
				//Error checking for blank fields
				if (amount.equals("") || toFrom.equals("") || date.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "All fields were not filled out, Please try again", "CleverBudget - Fields Error", JOptionPane.ERROR_MESSAGE);
				}
				//Balance error
				else if(sizeError > 0) 
				{
					JOptionPane.showMessageDialog(null, "The amount must be a number", "CleverBudget - Amount Error", JOptionPane.ERROR_MESSAGE);
					textAmount.setText(null);
				}
				//If there are no errors, we can add this transaction
				else 
				{
					//Attributes:
					String bigDataFile = "bigData.txt";
					BufferedReader reader = null;
					//Suppress warning, it was saying that this "String line" was being unused
					@SuppressWarnings("unused")
					String line;
					Transaction newTran;
					ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
					
					//Reading in the file, parsing the file:
					try 
					{
						reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(bigDataFile)));
						while ((line = reader.readLine()) != null) 
						{
							newTran = new Transaction();
							newTran.setName(name);
							newTran.setAmount(Double.parseDouble(amount));
							newTran.setDepositOrWithdraw(transaction);
							newTran.setToOrFrom(toFrom);
							newTran.setType(paymentType);
							newTran.setDate(date);
							transactionList.add(newTran);
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
					
					
					//Writing to bigData.txt
					try(FileWriter fw = new FileWriter(bigDataFile, true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw))
					{
						out.println(name + "," + amount + "," + transaction + "," + toFrom + "," + paymentType + "," + date);
						dispose();
					}
						
					catch (IOException e1) 
					{
						System.out.println("Was not able to find the file: bigData.txt, " + bigDataFile);
						e1.printStackTrace();
					}
					
				}//End of else, start of the reading/writing, no errors	
			}
		});
		btnNewButton.setBounds(180, 262, 164, 25);
		contentPane.add(btnNewButton);
		

	}
}
