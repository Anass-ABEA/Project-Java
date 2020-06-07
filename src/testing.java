import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Component;

public class testing {
	private final JLabel background = new JLabel("");
	private JFrame frame;
	
	private JTextField username;
	private JTextField pass1;
	private JTextField pass2;
	private JTextField prenom;
	private JTextField passport;
	private JTextField adr;
	private JTextField nom;
	
	private String U,P,CP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing window = new testing();
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
	public testing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(52, 125, 235));
		Image img = new ImageIcon(this.getClass().getResource("/register.jpeg")).getImage();
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
				String Pname,Fname,PassPort,Adress;
				if (prenom.getText().equals("") || nom.getText().equals("")||passport.getText().equals("")||adr.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Vous avez laissé une des cases ouvertes", "Attetion!!",JOptionPane.OK_OPTION);
				}else {
					Pname=prenom.getText();
					Fname=nom.getText();
					PassPort=passport.getText();
					Adress = adr.getText();
					//dbh.addNewUser(U,P,Pname,Fname,PassPort,Adress);
					//go to home page INCOMPLETE
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
	
}
