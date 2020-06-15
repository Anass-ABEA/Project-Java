import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DatabaseHelper;

public class gestionVoyageurs {

	private JFrame frmGererLesVoyageurs;
	private JTextField idx;
	private JTextField nom;
	private JTextField prenom;
	
	private JTextField adr;
	private JTextField pass;
	private JTable table;
	private DatabaseHelper dbh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionVoyageurs window = new gestionVoyageurs(1);
					window.frmGererLesVoyageurs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestionVoyageurs(int id) {
		
		this.dbh= new DatabaseHelper();
		dbh.connect();
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frmGererLesVoyageurs = new JFrame();
		frmGererLesVoyageurs.setTitle("Gerer les Voyageurs");
		frmGererLesVoyageurs.setBounds(100, 100, 1119, 769);
		frmGererLesVoyageurs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGererLesVoyageurs.getContentPane().setLayout(null);
		
		JButton back = new JButton("Retour");
		back.setBounds(12, 13, 97, 49);
		frmGererLesVoyageurs.getContentPane().add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGererLesVoyageurs.dispose();
				new Home_admin(id);
				
			}
			
		});
		
		JButton del = new JButton("Supprimer");
		del.setForeground(new Color(255, 51, 51));
		del.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		del.setBounds(868, 13, 97, 49);
		frmGererLesVoyageurs.getContentPane().add(del);
		
		JButton save = new JButton("Modifier");
		save.setForeground(new Color(0, 51, 255));
		save.setBorder(new LineBorder(new Color(0, 51, 255), 2, true));
		save.setBounds(992, 13, 97, 49);
		frmGererLesVoyageurs.getContentPane().add(save);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 119, 698, 553);
		frmGererLesVoyageurs.getContentPane().add(scrollPane);
		
		ArrayList<ArrayList<String>> voy =dbh.getVoyList();
		String[][] voya = new String[voy.size()][5];
		
		int i=0;
		for (ArrayList<String> L : voy) {
			for (int j = 0 ; j<5 ;j++){
				
				voya[i][j]= L.get(j);
				
			}
			i++;
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(
				voya,
			new String[] {
				"ID", "Nom", "Prenom", "Adresse", "N\u00B0 Passport"
			}
		));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				idx.setText(voy.get(table.getSelectedRow()).get(0));
				nom.setText(voy.get(table.getSelectedRow()).get(1));
				prenom.setText(voy.get(table.getSelectedRow()).get(2));
				adr.setText(voy.get(table.getSelectedRow()).get(3));
				pass.setText(voy.get(table.getSelectedRow()).get(4));
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(763, 127, 326, 28);
		frmGererLesVoyageurs.getContentPane().add(lblNewLabel);
		
		idx = new JTextField();
		idx.setEditable(false);
		idx.setColumns(10);
		idx.setBounds(763, 153, 326, 35);
		frmGererLesVoyageurs.getContentPane().add(idx);
		
		JLabel lblNom = new JLabel("Nom ");
		lblNom.setBounds(763, 228, 326, 28);
		frmGererLesVoyageurs.getContentPane().add(lblNom);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(763, 254, 326, 35);
		frmGererLesVoyageurs.getContentPane().add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(763, 370, 326, 35);
		frmGererLesVoyageurs.getContentPane().add(prenom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(763, 344, 326, 28);
		frmGererLesVoyageurs.getContentPane().add(lblPrnom);
		
		adr = new JTextField();
		adr.setColumns(10);
		adr.setBounds(763, 503, 326, 35);
		frmGererLesVoyageurs.getContentPane().add(adr);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(763, 477, 326, 28);
		frmGererLesVoyageurs.getContentPane().add(lblAdresse);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(763, 637, 326, 35);
		frmGererLesVoyageurs.getContentPane().add(pass);
		
		JLabel lblNPassport = new JLabel("N\u00B0 Passport");
		lblNPassport.setBounds(763, 611, 326, 28);
		frmGererLesVoyageurs.getContentPane().add(lblNPassport);
		frmGererLesVoyageurs.setVisible(true);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.updateVoyageur(id,idx.getText(),nom.getText(),prenom.getText(),pass.getText(),adr.getText());
				frmGererLesVoyageurs.dispose();
				new gestionVoyageurs(id);
			}
			
		});
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.deleteVoyageur(id,idx.getText(),nom.getText(),prenom.getText(),pass.getText(),adr.getText());
				frmGererLesVoyageurs.dispose();
				new gestionVoyageurs(id);
			}
			
		});
	}
}
