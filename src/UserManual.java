//Author(s): Cameron Gomke, Cheyanne
//File Name: User_Manual
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/03/2017
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UserManual extends JFrame {

    private JPanel contentPane;

    //Launch Application:
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserManual frame = new UserManual();
                    frame.getContentPane().setBackground(new Color(207, 210, 215));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Creating the Frame:
    public UserManual() {
    	//Main JFrame Statistics:
        setTitle("CleverBudget - User Manual");
        setFont(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("./BrowserIcon.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //Separator - Looks Nice
        JSeparator separator = new JSeparator();
        separator.setBounds(36, 80, 701, 2);
        contentPane.add(separator);

        //Label - Title
        JLabel lblUserManual = new JLabel("User Manual");
        lblUserManual.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 26));
        lblUserManual.setBounds(36, 35, 189, 32);
        contentPane.add(lblUserManual);

        //Label - Developed By:
        JLabel lblDevelopedByClever = new JLabel("Developed by: Clever 323");
        lblDevelopedByClever.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
        lblDevelopedByClever.setBounds(581, 824, 189, 16);
        contentPane.add(lblDevelopedByClever);
        
        //Bulk of the Meat
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBackground(new Color (0, 0, 0, 100));
        textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
        textArea.setText("Login Screen - Buttons:\r\n     "
        		+ "Login\r\n          -If the correct Username + Password is entered, the user will be granted access\r\n          -If not, the user will be denied access\r\n     "
        		+ "Forgot Password\r\n          -If a user forgets their username/password, they can have it recovered to their email\r\n     "
        		+ "Create Account\r\n          -Allows for new users to create accounts to be allowed access to their own data\r\n     "
        		+ "Reset\r\n          -Resets the Username and Password fields to blank\r\n     "
        		+ "User Manual\r\n          -Opens a new page that contains the User Manual\r\n     "
        		+ "Exit\r\n          -Exits the program\r\n     "
        		+ "\r\n\r\n"
        		+ "Forget Password"
        		+ "\r\n\r\n"
        		+ "Create New Account"
        		+ "\r\n\r\n"
        		+ "Home Page"
        		+ "\r\n\r\n");
        textArea.setBounds(36, 108, 701, 337);
        contentPane.add(textArea);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setLocation(50, 100);
		scrollPane.setSize(675, 700);
		scrollPane.getViewport().setBackground(new Color(0,0,0,25));
		contentPane.add(scrollPane);
        
        
    }
}
