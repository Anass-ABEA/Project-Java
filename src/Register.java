import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import database.DatabaseHelper;
import user.Utilisateur;
import user.Voyageur;

import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame{
	private static DatabaseHelper dbh= null;
	private final JLabel background = new JLabel("");

	private JFrame frame;
	private JTextField username;
	private JTextField pass1;
	private JTextField pass2;
	private JTextField prenom;
	private JTextField passport;
	private JTextField adr;
	private JTextField nom;
	private Utilisateur uInstance;
	private Voyageur vInstance;

	private String U,P,CP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbh = new DatabaseHelper();
		dbh.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register(true);
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
	public Register(Boolean e) {
		dbh = new DatabaseHelper();
		dbh.connect();
		initialize(e);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Boolean e) {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1028, 560));
		frame.getContentPane().setBackground(new Color(52, 125, 235));
		frame.setTitle("Register Page");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1028, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img = new ImageIcon(this.getClass().getResource("/register.jpeg")).getImage();
		if (e) {
			frame.getContentPane().setLayout(null);
			
			background.setIcon(new ImageIcon(img));
			background.setBounds(511,0,511,525);
			background.setLayout( new FlowLayout() );
			
			
			
			
			frame.getContentPane().add(background);
			
			JButton next_btn = new JButton("NEXT");
			
			next_btn.setFont(new Font("Yu Gothic", Font.BOLD, 13));
			next_btn.setBounds(175, 394, 139, 43);
			frame.getContentPane().add(next_btn);
			
			JLabel lblNewLabel = new JLabel("USERNAME : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(30, 151, 179, 40);
			frame.getContentPane().add(lblNewLabel);
			
			username = new JTextField();
			username.setBounds(215, 150, 200, 40);
			frame.getContentPane().add(username);
			username.setColumns(10);
			
			JLabel lblPassword = new JLabel("PASSWORD : ");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setBounds(30, 220, 179, 40);
			frame.getContentPane().add(lblPassword);
			
			pass1 = new JPasswordField();
			pass1.setColumns(10);
			pass1.setBounds(215, 220, 200, 40);
			
			
			frame.getContentPane().add(pass1);
			
			JLabel lblConfirm = new JLabel("CONFIRM PASSWORD : ");
			lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
			lblConfirm.setBounds(30, 290, 179, 40);
			frame.getContentPane().add(lblConfirm);
			
			pass2 = new JPasswordField();
			pass2.setColumns(10);
			pass2.setBounds(215, 290, 200, 40);
			frame.getContentPane().add(pass2);
			frame.setVisible(true);
			
			
			
			frame.getRootPane().setDefaultButton(next_btn);
			
			
			JLabel pass_error = new JLabel("PASS Diff\u00E9rents!");
			pass_error.setHorizontalAlignment(SwingConstants.CENTER);
			pass_error.setBackground(UIManager.getColor("Button.highlight"));
			pass_error.setFont(new Font("Adobe Heiti Std R", Font.ITALIC, 17));
			pass_error.setForeground(Color.RED);
			pass_error.setBounds(175, 343, 258, 16);
			pass_error.setVisible(false);
			next_btn.setEnabled(false);
			
			frame.getContentPane().add(pass_error);
			pass1.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					check2();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					check2();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					check2();
				}
				public void check2() {
					if(pass1.getText().equals("")) {
						pass_error.setVisible(true);
						pass_error.setText("PASS VIDE!");
						pass1.setBorder(new LineBorder(Color.red,2));
						
						
					}else {
						pass_error.setVisible(false);
						pass1.setBorder(username.getBorder());
						
						
					}
				}
				
			});
			pass2.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					check();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					check();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					check();
				}
				public void check() {
					if(!pass2.getText().equals(pass1.getText())) {
						pass_error.setVisible(true);
						pass_error.setText("PASS Diff\u00E9rents!");
						pass1.setBorder(new LineBorder(Color.red,2));
						pass2.setBorder(new LineBorder(Color.red,2));
						next_btn.setEnabled(false);
						
					}else {
						pass_error.setVisible(false);
						pass1.setBorder(username.getBorder());
						pass2.setBorder(username.getBorder());
						next_btn.setEnabled(true);
					}
					if(pass1.getText().equals("")) {
						pass_error.setVisible(true);
						pass_error.setText("PASS VIDE!");
						pass1.setBorder(new LineBorder(Color.red,2));
						pass2.setBorder(new LineBorder(Color.red,2));
						next_btn.setEnabled(false);
					}
				}
				
			});
			next_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					U=username.getText();
					P=pass1.getText();
					Utilisateur u = new Utilisateur(U,P);
					updateLocalval(U,P);
					//System.out.println(U+" "+P);
					CP=pass2.getText();
					if (!U.equals("")) {
						int res = dbh.connect_user(u);
						if (res<0) {
							frame.dispose();
							initialize(false);
						}else {
							show_options("Un nom d'utilisateur existe deja avec ce nom veuillez le changer");
						}
						
					}else {
						JOptionPane.showMessageDialog(frame, "le nom d'utilisateur est vide", "ATTENTION!!", JOptionPane.OK_OPTION);
					}
					
				}
				
				private void show_options(String string) {
					Object[] options = {"Login Now","Try Again"
	                };
					int x = JOptionPane.showOptionDialog(frame,
						    string,
						    "Warning !!",
						    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
						    ,null,options,options[1]);
					
					if( x == 1 ) {
						username.setText("");
						pass1.setText("");
						pass2.setText("");
						pass_error.setVisible(false);
						pass1.setBorder(username.getBorder());
						pass2.setBorder(username.getBorder());
						next_btn.setEnabled(false);
					}else {
						if(x==0) {
							frame.dispose();
							new Login();
						}
						
					}
					
				}
			});
		}else {
			System.out.println("NEW "+U+" "+P);
			frame.getContentPane().setLayout(null);
			background.setIcon(new ImageIcon(img));
			background.setBounds(0,0,511,525);
			background.setLayout( new FlowLayout() );
			
			
			
			
			frame.getContentPane().add(background);
			
			
			JButton sign = new JButton("AJOUTEZ MOI!");
			sign.setFont(new Font("Yu Gothic", Font.BOLD, 13));
			sign.setBounds(708, 417, 139, 43);
			frame.getContentPane().add(sign);
			
			JLabel lblNewLabel = new JLabel("PRENOM : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(537, 173, 179, 40);
			frame.getContentPane().add(lblNewLabel);
			
			prenom = new JTextField();
			prenom.setBounds(722, 172, 200, 40);
			frame.getContentPane().add(prenom);
			prenom.setColumns(10);
			
			JLabel lblPassword = new JLabel("PASSPORT N\u00B0 : ");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setBounds(537, 242, 179, 40);
			frame.getContentPane().add(lblPassword);
			
			passport = new JTextField();
			passport.setColumns(10);
			passport.setBounds(722, 242, 200, 40);
			frame.getContentPane().add(passport);
			
			JLabel lblConfirm = new JLabel("ADRESSE :");
			lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
			lblConfirm.setBounds(537, 312, 179, 40);
			frame.getContentPane().add(lblConfirm);
			
			adr = new JTextField();
			adr.setColumns(10);
			adr.setBounds(722, 312, 200, 40);
			frame.getContentPane().add(adr);
			
			JLabel lblFirstName = new JLabel("NOM : ");
			lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblFirstName.setBounds(537, 102, 179, 40);
			frame.getContentPane().add(lblFirstName);
			
			nom = new JTextField();
			nom.setColumns(10);
			nom.setBounds(722, 102, 200, 40);
			frame.getContentPane().add(nom);
			frame.getRootPane().setDefaultButton(sign);
			frame.setVisible(true);
			sign.setEnabled(false);
			
				
			
			sign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Voyageur v ;
					String Pname,Fname,PassPort,Adress;
					if (prenom.getText().equals("") || nom.getText().equals("")||passport.getText().equals("")||adr.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Vous avez laissé une des cases vides", "Attetion!!",JOptionPane.OK_OPTION);
						
					}else {
						v= new Voyageur(uInstance,nom.getText(),prenom.getText(),passport.getText(),adr.getText());
						Pname=prenom.getText();
						Fname=nom.getText();
						PassPort=passport.getText();
						Adress = adr.getText();
						int ID = dbh.addNewUser(v);
						frame.dispose();
						new HomePage(ID);
					}
					
				}
				
			});
		
			
			nom.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					nomcheck();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					nomcheck();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					nomcheck();
				}
				public void nomcheck() {
					if(nom.getText().equals("")||prenom.getText().equals("")||adr.getText().equals("")||passport.getText().equals("")) {
						if(nom.getText().equals("")) {
							nom.setBorder(new LineBorder(Color.red,2));
							sign.setEnabled(false);
						}else {
							nom.setBorder(new LineBorder(Color.white));
							
						}
						
						
						
					}else {
						sign.setEnabled(true);
						nom.setBorder(new LineBorder(Color.white));
						prenom.setBorder(new LineBorder(Color.white));
						passport.setBorder(new LineBorder(Color.white));
						adr.setBorder(new LineBorder(Color.white));
					}
					
				}
				
			});
			prenom.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					prenomcheck();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					prenomcheck();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					prenomcheck();
				}
				public void prenomcheck() {
					if(nom.getText().equals("")||prenom.getText().equals("")||adr.getText().equals("")||passport.getText().equals("")) {
						if(prenom.getText().equals("")) {
							prenom.setBorder(new LineBorder(Color.red,2));
							sign.setEnabled(false);
						}else {
							prenom.setBorder(new LineBorder(Color.white));
							
						}
						
						
						
					}else {
						sign.setEnabled(true);
						nom.setBorder(new LineBorder(Color.white));
						prenom.setBorder(new LineBorder(Color.white));
						passport.setBorder(new LineBorder(Color.white));
						adr.setBorder(new LineBorder(Color.white));
					}
					
				}
				
			});
			passport.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkpassport();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					checkpassport();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					checkpassport();
				}
				public void checkpassport() {
					if(nom.getText().equals("")||prenom.getText().equals("")||adr.getText().equals("")||passport.getText().equals("")) {
						if(passport.getText().equals("")) {
							passport.setBorder(new LineBorder(Color.red,2));
							sign.setEnabled(false);
						}else {
							passport.setBorder(new LineBorder(Color.white));
							
						}
						
						
						
					}else {
						sign.setEnabled(true);
						nom.setBorder(new LineBorder(Color.white));
						prenom.setBorder(new LineBorder(Color.white));
						passport.setBorder(new LineBorder(Color.white));
						adr.setBorder(new LineBorder(Color.white));
					}
					
				}
				
			});
			adr.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkadr();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					checkadr();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					checkadr();
				}
				public void checkadr() {
					if(nom.getText().equals("")||prenom.getText().equals("")||adr.getText().equals("")||passport.getText().equals("")) {
						if(adr.getText().equals("")) {
							adr.setBorder(new LineBorder(Color.red,2));
							sign.setEnabled(false);
						}else {
							adr.setBorder(new LineBorder(Color.white));
							
						}
						
						
						
					}else {
						sign.setEnabled(true);
						nom.setBorder(new LineBorder(Color.white));
						prenom.setBorder(new LineBorder(Color.white));
						passport.setBorder(new LineBorder(Color.white));
						adr.setBorder(new LineBorder(Color.white));
					}
					
				}
				
			});
			
			
		}
		
		
		frame.setVisible(true);
		
		
	}
	private void updateLocalval(String u, String p) {
		this.uInstance = new Utilisateur(u,p);
		
	}
	
}
