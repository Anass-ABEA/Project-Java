import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DatabaseHelper;
import flights.Avion;
import flights.Vol;

public class gestion_vol {

	private JFrame frmGestionDesVols;
	private JTextField idv;
	private JTextField dd;
	private JTextField duree;
	private JTextField ad;
	private JTextField ida;
	private JTextField da;
	private JTextField distance;
	private JTextField aa;
	private JTable table;
	private DatabaseHelper dbh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_vol window = new gestion_vol(1);
					window.frmGestionDesVols.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestion_vol(int id) {
		this.dbh = new DatabaseHelper();
		dbh.connect();
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frmGestionDesVols = new JFrame();
		frmGestionDesVols.setResizable(false);
		frmGestionDesVols.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.png"));
		frmGestionDesVols.setTitle("Gestion Des Vols");
		frmGestionDesVols.setBounds(100, 100, 1118, 745);
		frmGestionDesVols.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesVols.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(12, 13, 97, 49);
		frmGestionDesVols.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGestionDesVols.dispose();
				new Home_admin(id);
				
			}
			
		});
		
		JButton del = new JButton("Supprimer");
		del.setForeground(new Color(255, 51, 51));
		del.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		del.setBounds(848, 13, 97, 49);
		frmGestionDesVols.getContentPane().add(del);
		
		JButton save = new JButton("Appliquer");
		save.setForeground(new Color(0, 51, 255));
		save.setBorder(new LineBorder(new Color(0, 51, 255), 2, true));
		save.setBounds(991, 13, 97, 49);
		frmGestionDesVols.getContentPane().add(save);
		
		idv = new JTextField();
		idv.setHorizontalAlignment(SwingConstants.CENTER);
		idv.setColumns(10);
		idv.setBounds(22, 104, 221, 38);
		frmGestionDesVols.getContentPane().add(idv);
		
		JLabel lblNbplaces = new JLabel("Date De D\u00E9part");
		lblNbplaces.setBounds(284, 65, 221, 32);
		frmGestionDesVols.getContentPane().add(lblNbplaces);
		
		dd = new JTextField();
		dd.setHorizontalAlignment(SwingConstants.CENTER);
		dd.setColumns(10);
		dd.setBounds(284, 103, 221, 38);
		frmGestionDesVols.getContentPane().add(dd);
		
		JLabel lblCompanie = new JLabel("Dur\u00E9e");
		lblCompanie.setBounds(563, 65, 221, 32);
		frmGestionDesVols.getContentPane().add(lblCompanie);
		
		duree = new JTextField();
		duree.setHorizontalAlignment(SwingConstants.CENTER);
		duree.setColumns(10);
		duree.setBounds(562, 102, 221, 38);
		frmGestionDesVols.getContentPane().add(duree);
		
		JLabel lblNewLabel = new JLabel("ID VOL  : ");
		lblNewLabel.setBounds(22, 65, 221, 32);
		frmGestionDesVols.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 231, 1076, 454);
		frmGestionDesVols.getContentPane().add(scrollPane);
		
		table = new JTable();
		ArrayList<Vol> liste = dbh.fillListeVol();
		String[][] list = new String[liste.size()][8];
		int e= 0;
		for(Vol a : liste) {
			
			list[e][0]= ""+a.getIdVol();
			list[e][1]= ""+a.getIdAvion();
			list[e][2]= ""+a.getHeurDepart();
			list[e][3]= ""+a.getHeurArrivee();
			list[e][4]= ""+a.getDuree();
			list[e][5]= ""+a.getAeroportDepart();
			list[e][6]= ""+a.getAeroportArrivee();
			list[e][7]= ""+a.getDistance();
			
			e++;
		}
		
	
		table.setModel(new DefaultTableModel(
				list,
			new String[] {
				"ID VOL", "ID Avion", "Date Départ", "Date d'Arrivée", "Durée du vol", "Aéroport De Départ",
				"Aéroport d'arivée","Distance"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		
		JLabel lblCompanie_1 = new JLabel("A\u00E9roport De D\u00E9part");
		lblCompanie_1.setBounds(851, 63, 221, 32);
		frmGestionDesVols.getContentPane().add(lblCompanie_1);
		
		ad = new JTextField();
		ad.setHorizontalAlignment(SwingConstants.CENTER);
		ad.setColumns(10);
		ad.setBounds(850, 100, 221, 38);
		frmGestionDesVols.getContentPane().add(ad);
		
		ida = new JTextField();
		ida.setHorizontalAlignment(SwingConstants.CENTER);
		ida.setColumns(10);
		ida.setBounds(22, 184, 221, 38);
		frmGestionDesVols.getContentPane().add(ida);
		
		JLabel lblNewLabel_1 = new JLabel("IDA : ");
		lblNewLabel_1.setBounds(22, 145, 221, 32);
		frmGestionDesVols.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDateDarrive = new JLabel("Date d'arriv\u00E9e");
		lblDateDarrive.setBounds(284, 145, 221, 32);
		frmGestionDesVols.getContentPane().add(lblDateDarrive);
		
		da = new JTextField();
		da.setHorizontalAlignment(SwingConstants.CENTER);
		da.setColumns(10);
		da.setBounds(284, 183, 221, 38);
		frmGestionDesVols.getContentPane().add(da);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(563, 145, 221, 32);
		frmGestionDesVols.getContentPane().add(lblDistance);
		
		distance = new JTextField();
		distance.setHorizontalAlignment(SwingConstants.CENTER);
		distance.setColumns(10);
		distance.setBounds(562, 182, 221, 38);
		frmGestionDesVols.getContentPane().add(distance);
		
		JLabel lblCompanie_1_1 = new JLabel("A\u00E9roport D'Arriv\u00E9e");
		lblCompanie_1_1.setBounds(851, 143, 221, 32);
		frmGestionDesVols.getContentPane().add(lblCompanie_1_1);
		
		aa = new JTextField();
		aa.setHorizontalAlignment(SwingConstants.CENTER);
		aa.setColumns(10);
		aa.setBounds(850, 180, 221, 38);
		frmGestionDesVols.getContentPane().add(aa);
		
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idv.setText(liste.get(i).getIdVol());
				ida.setText(""+liste.get(i).getIdAvion());
				aa.setText(""+liste.get(i).getAeroportArrivee());
				ad.setText(""+liste.get(i).getAeroportDepart());
				dd.setText(""+liste.get(i).getHeurDepart());
				da.setText(""+liste.get(i).getHeurArrivee());
				distance.setText(""+liste.get(i).getDistance());
				duree.setText(""+liste.get(i).getDuree());
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
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.deleteVol(liste.get(table.getSelectedRow()),id);
				frmGestionDesVols.dispose();
				new gestion_vol(id);
			}
			
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.addnewvol(new Vol(idv.getText(),ida.getText(),dd.getText(),da.getText(),duree.getText(),ad.getText(),aa.getText(),distance.getText()),id);
				frmGestionDesVols.dispose();
				new gestion_vol(id);
			}
			
		});
		frmGestionDesVols.setVisible(true);
	}

}
