import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;

public class AddTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTransaction frame = new AddTransaction();
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
	public AddTransaction() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cameron Gomke\\eclipse-workspace\\Git\\src\\res\\BrowserIcon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add A New Transaction:");
		lblAddANew.setBounds(158, 13, 139, 16);
		contentPane.add(lblAddANew);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 39, 431, 2);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(30, 70, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(30, 100, 56, 16);
		contentPane.add(lblAmount);
		
		JLabel lblSender = new JLabel("Sender:");
		lblSender.setBounds(30, 130, 56, 16);
		contentPane.add(lblSender);
		
		JLabel lblReceiver = new JLabel("Receiver:");
		lblReceiver.setBounds(30, 160, 56, 16);
		contentPane.add(lblReceiver);
		
		JLabel lblType = new JLabel("Payment Type:");
		lblType.setBounds(30, 190, 94, 16);
		contentPane.add(lblType);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(30, 220, 56, 16);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(180, 70, 164, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 100, 164, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 130, 164, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 160, 164, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 190, 164, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(180, 220, 164, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(Ex: 8/8/18)");
		lblNewLabel.setBounds(350, 220, 82, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Transaction");
		btnNewButton.setBounds(158, 260, 139, 25);
		contentPane.add(btnNewButton);
	}
}
