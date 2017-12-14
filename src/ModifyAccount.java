import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ModifyAccount extends JFrame {
    
    private JPanel contentPane;
    private JTextField txtFirst;
    private JTextField txtLast;
    private JTextField txtBalance;
    private JTextField txtDesc;
    private JTextField txtPhoneNum;
    private JTextField txtEmail;
    
    

	/**
	 * Launch the application.
	 */
	public static void main(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    int index = (args);
					ModifyAccount frame = new ModifyAccount(index);
	                 frame.getContentPane().setBackground(new Color(207, 210, 215));
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
	public ModifyAccount(int index) {
	    //read in small data
	    int theIndex = index - 1;
	    
	     
	       String smallDataFile = "smallData.txt";
	        String line;
	        BufferedReader reader;
	        String[] details = null;
	        
	        Account newAccount;
	        ArrayList<Account> smallDataList = new ArrayList<Account>();


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
	        
	    
	    
	    
        //Frame Statistics
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("BrowserIcon.png")));
        setTitle("CleverBudget - Create New Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 375);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //Separator - Looks nice
        JSeparator separator = new JSeparator();
        separator.setBounds(12, 58, 408, 2);
        contentPane.add(separator);
        
        //Label - Use label at top
        JLabel lblUseCreateA = new JLabel("Use: Create a New Account for the Table\r\n");
        lblUseCreateA.setFont(new Font("Verdana", Font.BOLD, 11));
        lblUseCreateA.setBounds(12, 13, 379, 16);
        contentPane.add(lblUseCreateA);
        
        //Label - fill out label at top
        JLabel lblPleaseFillOut = new JLabel("Please Fill Out the Following Fields Completely:");
        lblPleaseFillOut.setFont(new Font("Verdana", Font.BOLD, 11));
        lblPleaseFillOut.setBounds(12, 40, 379, 16);
        contentPane.add(lblPleaseFillOut);
        
        //Label - First Name
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Verdana", Font.BOLD, 13));
        lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblFirstName.setBounds(45, 74, 89, 16);
        contentPane.add(lblFirstName);
        
        //Label - Last Name
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Verdana", Font.BOLD, 13));
        lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblLastName.setBounds(45, 101, 89, 16);
        contentPane.add(lblLastName);
        
        //Label - Account Balance
        JLabel lblAccountBalance = new JLabel("Account Balance");
        lblAccountBalance.setFont(new Font("Verdana", Font.BOLD, 13));
        lblAccountBalance.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAccountBalance.setBounds(-20, 130, 153, 16);
        contentPane.add(lblAccountBalance);
        
        //Label - Account Balance Example
        JLabel lblExampleBalance = new JLabel("(Ex: 1000.00)");
        lblExampleBalance.setFont(new Font("Verdana", Font.BOLD, 11));
        lblExampleBalance.setBounds(300, 131, 112, 16);
        contentPane.add(lblExampleBalance);
        
        //Label - Description
        JLabel lblDescription = new JLabel("Description");
        lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
        lblDescription.setFont(new Font("Verdana", Font.BOLD, 13));
        lblDescription.setBounds(45, 177, 89, 16);
        contentPane.add(lblDescription);
        
        //Label - Phone Number
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPhoneNumber.setFont(new Font("Verdana", Font.BOLD, 13));
        lblPhoneNumber.setBounds(20, 209, 114, 16);
        contentPane.add(lblPhoneNumber);
        
        //Label - Phone Number Example
        JLabel lblExamplePhoneNum = new JLabel("(Ex: 406-111-3324)");
        lblExamplePhoneNum.setFont(new Font("Verdana", Font.BOLD, 11));
        lblExamplePhoneNum.setBounds(293, 209, 141, 16);
        contentPane.add(lblExamplePhoneNum);
        
        //Label - Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Verdana", Font.BOLD, 13));
        lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
        lblEmail.setBounds(45, 241, 89, 16);
        contentPane.add(lblEmail);
        
        
        //Text Field - First Name
        txtFirst = new JTextField();
        txtFirst.setBounds(137, 71, 153, 22);
        txtFirst.setText(smallDataList.get(theIndex).getFirstName());
        contentPane.add(txtFirst);
        txtFirst.setColumns(10);
        
        //Text Field - Last Name
        txtLast = new JTextField();
        txtLast.setBounds(137, 100, 153, 22);
        txtLast.setText(smallDataList.get(theIndex).getLastName());
        contentPane.add(txtLast);
        txtLast.setColumns(10);
        
        //Text Field - Balance
        txtBalance = new JTextField();
        txtBalance.setBounds(137, 129, 153, 22);
        txtBalance.setEnabled(false);
        contentPane.add(txtBalance);
        txtBalance.setColumns(10);
   
        
    
        //Text Field - Description
        txtDesc = new JTextField();
        txtDesc.setBounds(137, 176, 153, 22);
        txtDesc.setText(smallDataList.get(theIndex).getDescription());
        contentPane.add(txtDesc);
        txtDesc.setColumns(10);
        
        //Text Field - Phone Number
        txtPhoneNum = new JTextField();
        txtPhoneNum.setBounds(137, 207, 153, 22);
        txtPhoneNum.setText(smallDataList.get(theIndex).getPhoneNumber());
        contentPane.add(txtPhoneNum);
        txtPhoneNum.setColumns(10);
        
        //Text Field - Email
        txtEmail = new JTextField();
        txtEmail.setBounds(137, 240, 153, 22);
        txtEmail.setText(smallDataList.get(theIndex).getEmail());
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);
        
        JButton btnModifyAccount = new JButton("Modify Account");
        btnModifyAccount.setBackground(new Color(70, 137, 191));
        btnModifyAccount.setOpaque(true);
        btnModifyAccount.setBorderPainted(true);
        btnModifyAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                smallDataList.get(theIndex).setFirstName(txtFirst.getText());
                smallDataList.get(theIndex).setLastName(txtLast.getText());
               
                smallDataList.get(theIndex).setDescription(txtDesc.getText());
                smallDataList.get(theIndex).setPhoneNumber(txtPhoneNum.getText());
                smallDataList.get(theIndex).setEmail(txtEmail.getText());
                
                String firstName = txtFirst.getText();
                String lastName = txtLast.getText();
                String balance = txtBalance.getText();
                String description = txtDesc.getText();
                String phoneNum = txtPhoneNum.getText();
                String email = txtEmail.getText();
                
                try (
                    FileWriter fw = new FileWriter(smallDataFile, false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)){
                    for(int i = 0; i < smallDataList.size(); i++) {
                        out.println(smallDataList.get(i).getFirstName() +
                                "," + smallDataList.get(i).getLastName() +
                                "," + smallDataList.get(i).getStartingBalance() +
                                "," + smallDataList.get(i).getDescription() +
                                "," + smallDataList.get(i).getPhoneNumber() +
                                "," + smallDataList.get(i).getEmail());
                    }
                    dispose();
                }catch(Exception ex) {
                    ex.printStackTrace();
                }
                
            }
            });
        
        btnModifyAccount.setBounds(137, 288, 153, 25);
        contentPane.add(btnModifyAccount);

}}

