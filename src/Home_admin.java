import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import database.DatabaseHelper;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Home_admin {

	private JFrame frmGestion;
	private int id;
	private DatabaseHelper dbh = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_admin window = new Home_admin(1);
					window.frmGestion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param id_user 
	 */
	public Home_admin(int id_user) {
		this.id = id_user;
		this.dbh = new DatabaseHelper();
		dbh.connect();
		initialize(id_user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id_user) {
		frmGestion = new JFrame();
		frmGestion.setTitle("Gestion");
		frmGestion.setBounds(100, 100, 1029, 689);
		frmGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestion.getContentPane().setLayout(null);
		
		JLabel billets = new JLabel("0");
		billets.setForeground(Color.RED);
		billets.setFont(new Font("Tahoma", Font.BOLD, 16));
		billets.setHorizontalAlignment(SwingConstants.CENTER);
		billets.setBounds(917, 71, 41, 53);
		frmGestion.getContentPane().add(billets);
		
		JLabel lblNewLabel = new JLabel("Bienvenue : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(69, 13, 139, 23);
		frmGestion.getContentPane().add(lblNewLabel);
		
		JLabel name = new JLabel("New label");
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(209, 13, 458, 23);
		frmGestion.getContentPane().add(name);
		
		JButton planes = new JButton("Gestion d'avions");
		planes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		planes.setContentAreaFilled(false);
		planes.setBounds(49, 71, 185, 53);
		frmGestion.getContentPane().add(planes);
		
		planes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGestion.dispose();
				new gestion_avions(id);
			}
			
		});
		
		JButton flights = new JButton("Gestion de Vols");
		flights.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		flights.setContentAreaFilled(false);
		flights.setBounds(290, 71, 185, 53);
		frmGestion.getContentPane().add(flights);
		flights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGestion.dispose();
				new gestion_vol(id);
			}
			
		});
		JButton travelers = new JButton("Gestion de voyageurs");
		travelers.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		travelers.setContentAreaFilled(false);
		travelers.setBounds(528, 71, 185, 53);
		frmGestion.getContentPane().add(travelers);
		travelers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGestion.dispose();
				new gestionVoyageurs(id);
				
			}
			
		});
		
		JButton ticekts = new JButton("gestion des billets");
		ticekts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestion.dispose();
				new gestion_billets(id);
			}
		});
		ticekts.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ticekts.setContentAreaFilled(false);
		ticekts.setOpaque(false);
		ticekts.setBounds(773, 71, 185, 53);
		frmGestion.getContentPane().add(ticekts);
		
		JButton disconnect = new JButton("Se D\u00E9connecter");
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestion.dispose();
				new Login();
			}
		});
		disconnect.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		disconnect.setContentAreaFilled(false);
		disconnect.setBounds(49, 564, 185, 53);
		frmGestion.getContentPane().add(disconnect);
		
		JList log = new JList();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 201, 909, 320);
		frmGestion.getContentPane().add(scrollPane);
		frmGestion.setVisible(true);
		
		scrollPane.setViewportView(log);
		
		JLabel lblNewLabel_1 = new JLabel("LOG Des Administrateurs : ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(49, 174, 196, 16);
		frmGestion.getContentPane().add(lblNewLabel_1);
		

		
		
		
		ArrayList<String> info = dbh.getInfo(id_user);
		String full_name = info.get(1).substring(0,1).toUpperCase()+info.get(1).substring(1).toLowerCase()+" "+ info.get(0).toUpperCase();
		name.setText(full_name);
		
		ArrayList<String> log_list = dbh.getLog();
		DefaultListModel listModel = new DefaultListModel();

	    
		for (int i = 0 ; i <log_list.size() ; i++) {
			listModel.add(i," # "+log_list.get(i));
		}
		log.setModel(listModel);
		billets.setText(dbh.getbilletscount());
		
		
	}
}
