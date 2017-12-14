//Author(s): Cameron Gomke, Cheyanne
//File Name: User_Manual
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/12/2017
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
import javax.swing.ImageIcon;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("AppIcon.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 700, 700);
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
        
        JLabel lblManual = new JLabel();
        lblManual.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/User_Manual.png")));
        lblManual.setBounds(20, 51, 742, 645);
        contentPane.add(lblManual);
        
        
    }
}
