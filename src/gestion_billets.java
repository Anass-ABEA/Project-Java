import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import database.DatabaseHelper;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class gestion_billets {

	private JFrame frame;
	private JTable table_NV;
	private JTable table_V;
	private DatabaseHelper dbh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_billets window = new gestion_billets(1);
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
	public gestion_billets(int id) {
		this.dbh= new DatabaseHelper();
		dbh.connect();
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton back = new JButton("Retour");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Home_admin(id);
			}
		});
		back.setBounds(12, 13, 159, 62);
		frame.getContentPane().add(back);
		
		JButton users = new JButton("Gerer Les Utilisateurs");
		users.setBounds(456, 13, 159, 62);
		frame.getContentPane().add(users);
		users.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new gestionUsers(id);
				
			}
			
		});
		JButton flights = new JButton("G\u00E9rer Les Vols");
		flights.setBounds(911, 13, 159, 62);
		frame.getContentPane().add(flights);
		flights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new gestion_vol(id);
			}
			
		});
		
		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(512, 331, 58, 42);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton(">");
		btnNewButton_4_1.setBorder(new LineBorder(new Color(0, 51, 255), 2, true));
		btnNewButton_4_1.setForeground(new Color(0, 51, 255));
		btnNewButton_4.setBorder(new LineBorder(new Color(255, 51, 51), 2, true));
		btnNewButton_4.setForeground(new Color(255, 51, 0));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4_1.setBounds(512, 448, 58, 42);
		frame.getContentPane().add(btnNewButton_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 141, 476, 538);
		frame.getContentPane().add(scrollPane);
		
		table_NV = new JTable();
		ArrayList<ArrayList<String>> liste_nv =fill_tables().get(0);
		String[][] NV = new String[liste_nv.size()][7];
		
		int i=0;
		for (ArrayList<String> L : liste_nv) {
			for (int j = 0 ; j<7 ;j++){
				
					NV[i][j]= L.get(j);
				
			}
			i++;
		}
		
		table_NV.setModel(new DefaultTableModel(
			NV,
			new String[] {
				"id Billet", "id user", "id vol", "id Siege", "place", "Date r\u00E9servation", "type"
			}
		));
		table_NV.getColumnModel().getColumn(0).setPreferredWidth(53);
		table_NV.getColumnModel().getColumn(1).setPreferredWidth(53);
		table_NV.getColumnModel().getColumn(2).setPreferredWidth(130);
		table_NV.getColumnModel().getColumn(3).setPreferredWidth(64);
		table_NV.getColumnModel().getColumn(5).setPreferredWidth(118);
		scrollPane.setViewportView(table_NV);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(582, 141, 476, 538);
		frame.getContentPane().add(scrollPane_1);
		
		table_V = new JTable();
		ArrayList<ArrayList<String>> liste_v = fill_tables().get(1);
		String[][] V = new String[liste_v.size()][7];
		i=0;
	
		for (ArrayList<String> L : liste_v) {
			for (int j = 0 ; j<7 ;j++){
				
				V[i][j]= L.get(j);
			
		}
			i++;
		}
		
		table_V.setModel(new DefaultTableModel(
			V,
			new String[] {
					"id Billet","id user", "id vol", "id Siege", "place ", "Date réservation","type"
			}
		));
		table_V.getColumnModel().getColumn(0).setPreferredWidth(53);
		table_V.getColumnModel().getColumn(1).setPreferredWidth(53);
		table_V.getColumnModel().getColumn(2).setPreferredWidth(130);
		table_V.getColumnModel().getColumn(3).setPreferredWidth(64);
		table_V.getColumnModel().getColumn(5).setPreferredWidth(118);
		scrollPane_1.setViewportView(table_V);
		
		JLabel lblNewLabel = new JLabel("Les billets Non Valid\u00E9s :");
		lblNewLabel.setBounds(12, 112, 247, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Les billets Valid\u00E9s :");
		lblNewLabel_1.setBounds(582, 112, 247, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbh.validate(liste_nv.get(table_NV.getSelectedRow()).get(0),id);
				refresh(id);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbh.unvalidate(liste_v.get(table_V.getSelectedRow()).get(0),id);
				refresh(id);
			}
		});
		frame.setVisible(true);
		
		
	}
	private void refresh(int id) {
		frame.dispose();
		new gestion_billets(id);
	}

	private ArrayList<ArrayList<ArrayList<String>>> fill_tables() {
		ArrayList<ArrayList<ArrayList<String>>> res = new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> list = dbh.getTablesContent();
		ArrayList<ArrayList<String>> list_nv = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> list_v = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> L : list) {
			if(L.get(L.size()-1).equals("NV")) {
				list_nv.add(L);
			}else {
				list_v.add(L);
			}
		}
		res.add(list_nv);
		res.add(list_v);
		
		return res;
	}
}
