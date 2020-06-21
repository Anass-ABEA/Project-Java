import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import database.DatabaseHelper;
import user.Utilisateur;


public class Login  extends JFrame{
	private static DatabaseHelper dbh= null;

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=193,124
	 */
	private final JLabel background = new JLabel("");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		dbh = new DatabaseHelper();
		dbh.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextField PASSWORD = new JPasswordField();
		PASSWORD.setSize(new Dimension(200, 0));
		JTextField LOGIN = new JTextField();
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		LOGIN.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		PASSWORD.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		PASSWORD.setToolTipText("password");
		PASSWORD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		PASSWORD.setColumns(10);
		
		LOGIN.setToolTipText("login");
		LOGIN.setColumns(10);
		LOGIN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(52, 125, 235));
		frame.setResizable(false);
		frame.setTitle("Login Page");
		frame.setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.png"));
		frame.setBounds(100, 100, 1251, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Image img = new ImageIcon(this.getClass().getResource("/plane.jpg")).getImage();
		
		background.setIcon(new ImageIcon(img));
		background.setBounds(0,0,760,506);
		background.setLayout( new FlowLayout() );
		
		
		JButton button1 = new JButton("   CONNECT   ");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = LOGIN.getText();
				String pass = PASSWORD.getText();
				
				
				
				if(user.length()==0 || pass.length()==0) {
					
					show_options("You have entred empty fields.");
					
				}else {
					int  b = dbh.connect_user(new Utilisateur(user, pass));
					if(b==-1) {
						show_options("You have entred Wrong info.\nFeel fre to create an account!");
					}else {
						int id_user = dbh.getId(user,pass);
						if(b==0) {
							// open user inteface. INCOMPLETE
							System.out.println("user");
							
							frame.dispose();
							
							new HomePage(id_user);
							
						}else {
							System.out.println("admin");
							frame.dispose();
							
							
							new Home_admin(id_user);
							
						}
						
					}
					
				}
				
			}

			private void show_options(String string) {
				Object[] options = {"Create An Account","Try Again"
                };
				int x = JOptionPane.showOptionDialog(frame,
					    string,
					    "Warning !!",
					    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
					    ,null,options,options[1]);
				
				
				if( x == 1 ) {
					LOGIN.setText("");
					PASSWORD.setText("");
				}else {
					if(x==0) {
						frame.dispose();
						new Register(true);
						
					}
					
					
				}
				
			}
		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button1.setForeground(Color.BLACK);
		
		JButton button2 = new JButton("   REGISTER   ");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Register(true);
				
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 18));
		button2.setForeground(Color.BLACK);
		
		
		JPanel panel = new JPanel(new GridLayout());
		panel.setBackground(new Color(52, 125, 235));
		panel.add(background);
		JPanel details = new JPanel(new GridLayout(5,0,0,70));
		details.setBackground(new Color(52, 125, 235));
		JPanel conn = new JPanel(new GridLayout(0,3,30,30));
		conn.setBackground(new Color(52, 125, 235));
		JPanel signup = new JPanel(new GridLayout(0,3,30,30));
		signup.setBackground(new Color(52, 125, 235));
		JPanel log = new JPanel(new GridLayout(0,4,10,150));
		log.setBackground(new Color(52, 125, 235));
		JPanel pass = new JPanel(new GridLayout(0,4,10,150));
		pass.setBackground(new Color(52, 125, 235));
		JLabel login =   new JLabel("LOG-IN   : ");
		JLabel passwd  = new JLabel("PASSWORD : ");
		login.setHorizontalAlignment(SwingConstants.RIGHT);
		login.setBackground(new Color(255, 255, 255));
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		//JLabel passwd  = new JLabel("PASSWORD : ");
		passwd.setHorizontalAlignment(SwingConstants.RIGHT);
		passwd.setSize(new Dimension(100, 0));
		passwd.setFont(new Font("Tahoma", Font.BOLD, 15));
		signup.add(button2,BorderLayout.WEST);
		log.add(new JLabel(""));
		log.add(login);
		
		log.add(LOGIN);
		LOGIN.requestFocusInWindow();
		JLabel label = new JLabel("");
		label.setSize(new Dimension(10, 0));
		pass.add(label);
		pass.add(passwd);
		pass.add(PASSWORD);
		details.add(signup);
		details.add(log);
		details.add(pass);
		conn.add(new JLabel(""));
		conn.add(button1);
		details.add(conn);
		
		
		
		panel.add(details);
		frame.getContentPane().add(panel);
		
		frame.getRootPane().setDefaultButton(button1);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}

}
