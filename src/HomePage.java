import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import database.DatabaseHelper;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;

public class HomePage {
	private static DatabaseHelper dbh=null;
	private JFrame frmHomePage;
	private JTextField nom;
	private JTextField prenom;
	private JTextField passport;
	private JTextField findMe;
	private ArrayList<String> ticketList=null;
	private ArrayList<String> orderList=null;
	private	JTable list;
	private JTable reservationNew;
	private JTextField to;
	private JTextField from;
	private String[][] corps_new;
	private String[][] corps_booked;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					HomePage window = new HomePage(1);
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage(int ID) {
		dbh= new DatabaseHelper();
		dbh.connect();
		initialize(ID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int ID) {
		frmHomePage = new JFrame();
		frmHomePage.setTitle("Home Page");
		frmHomePage.setBounds(100, 100, 1107, 741);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		verticalBox.setBounds(12, 13, 352, 271);
		frmHomePage.getContentPane().add(verticalBox);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vos Informations :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 328, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOM :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(36, 53, 56, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRENOM :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(14, 98, 78, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PASSPORT :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(0, 143, 92, 30);
		panel.add(lblNewLabel_1_1_1);
		
		nom = new JTextField();
		
		nom.setBounds(123, 54, 198, 30);
		panel.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(123, 99, 198, 30);
		panel.add(prenom);
		
		passport = new JTextField();
		passport.setColumns(10);
		passport.setBounds(123, 144, 198, 30);
		panel.add(passport);
		
		JButton edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		edit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		edit.setToolTipText("Changer Vos Informations");
		
	
		edit.setIcon(new ImageIcon("img\\pen_small.png"));
		edit.setBounds(141, 208, 50, 50);
		edit.setOpaque(false);
		edit.setContentAreaFilled(false);
		edit.setBorderPainted(true);
		panel.add(edit);
		
		
		JButton save = new JButton("");
		save.setToolTipText("Changer Vos Informations");
		save.setIcon(new ImageIcon("img\\check_small.png"));
		save.setBounds(141, 208, 50, 50);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(true);
		save.setVisible(false);
		panel.add(save);
		passport.setFocusable(false);
		nom.setFocusable(false);
		prenom.setFocusable(false);
		ArrayList<String> infoList= dbh.getInfo(ID);
		nom.setText(infoList.get(0));
		prenom.setText(infoList.get(1));
		passport.setText(infoList.get(2));
		
		
		
		
		JButton reg = new JButton("DECONNEXION");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHomePage.dispose();
				new Login();
			}
		});
		reg.setBounds(902,619,154,62);
		frmHomePage.add(reg);
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		passport.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setFont(new Font("Tahoma", Font.BOLD, 13));
		prenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		passport.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(412, 13, 665, 271);
		frmHomePage.getContentPane().add(verticalBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		verticalBox_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVosRserveraions = new JLabel("Vos R\u00E9serveraions :");
		lblVosRserveraions.setHorizontalAlignment(SwingConstants.LEFT);
		lblVosRserveraions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVosRserveraions.setBounds(12, 13, 161, 30);
		panel_2.add(lblVosRserveraions);
		
		findMe = new JTextField();
		findMe.setBounds(495, 13, 116, 30);
		panel_2.add(findMe);
		findMe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("RECHERCHE ");
		lblNewLabel_2.setBounds(382, 13, 85, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton find = new JButton("");
		
		find.setIcon(new ImageIcon("img\\loupe_small.png"));
		find.setBounds(623, 13, 34, 30);
		panel_2.add(find);
		find.setOpaque(false);
		find.setContentAreaFilled(false);
		find.setBorderPainted(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 55, 641, 206);
		panel_2.add(scrollPane);
		
		String[] title = {"Date D", "De", "Vers","Durée","Siège","Status"};
		String[][] vals = {{"1","1","1","1","1","1"},{"2","2","2","2","2","2"}};
		
		list = new JTable(vals,title) {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		list.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "1", "1", "1", "1", "1"},
				{"2", "2", "2", "2", "2", "2"},
			},
			new String[] {
				"Date d\u00E9part", "Heure d'Embarquement", "Heure D\u00E9collage", "Dur\u00E9e", "Si\u00E8ge", "Status"
			}
		));
		list.getColumnModel().getColumn(0).setPreferredWidth(90);
		list.getColumnModel().getColumn(1).setPreferredWidth(168);
		list.getColumnModel().getColumn(2).setPreferredWidth(116);
		list.getColumnModel().getColumn(3).setPreferredWidth(59);
		list.getColumnModel().getColumn(4).setPreferredWidth(53);
		list.getColumnModel().getColumn(5).setPreferredWidth(55);
		list.setRowHeight(30);
		list.setShowVerticalLines(false);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton cancel = new JButton("");
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		cancel.setIcon(new ImageIcon("img\\x_small.png"));
		cancel.setOpaque(false);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(true);
		cancel.setBounds(461, 13, 25, 25);
		
		
		panel_2.add(cancel);
		cancel.setVisible(false);
		list.setBounds(12, 55, 641, 206);
		//panel_2.add(list);
		
		JLabel noReservation_label = new JLabel("Vous N'avez Pas Encore Fait Une R\u00E9servation");
		noReservation_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		noReservation_label.setHorizontalAlignment(SwingConstants.CENTER);
		noReservation_label.setBounds(12, 122, 641, 62);
		panel_2.add(noReservation_label);
		
		
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBounds(12, 297, 1065, 309);
		frmHomePage.getContentPane().add(verticalBox_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		verticalBox_1_1.add(panel_2_1);
		
		JLabel lblNouvelleRservations = new JLabel("Nouvelle R\u00E9servation :");
		lblNouvelleRservations.setHorizontalAlignment(SwingConstants.LEFT);
		lblNouvelleRservations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNouvelleRservations.setBounds(12, 13, 185, 16);
		panel_2_1.add(lblNouvelleRservations);
		
		reservationNew = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		reservationNew.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Date D", "Date A", "Source", "Destination", "Durée", "places restantes"
			}
		));
		reservationNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reservationNew.setRowHeight(30);
		reservationNew.setShowVerticalLines(false);
		reservationNew.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservationNew.setBounds(12, 42, 1041, 254);
		//panel_2_1.add(reservationNew);
		
		JScrollPane textArea = new JScrollPane();
		textArea.setViewportView(reservationNew);
		textArea.setBounds(12, 42, 1041, 254);
		panel_2_1.add(textArea);
		
		to = new JTextField();
		to.setColumns(10);
		to.setBounds(870, 7, 116, 30);
		panel_2_1.add(to);
		
		from = new JTextField();
		from.setColumns(10);
		from.setBounds(524, 7, 116, 30);
		panel_2_1.add(from);
		
		JLabel lblNewLabel_2_1 = new JLabel("SOURCE : ");
		lblNewLabel_2_1.setBounds(436, 7, 85, 30);
		panel_2_1.add(lblNewLabel_2_1);
		
		JButton find_new = new JButton("");
		find_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] content = Arrays.copyOfRange(corps_new, 0, corps_new.length);
				ArrayList<String[]> liste = new ArrayList<String[]>();
				if(!from.getText().equals("")) {
					liste=search_values_source(content,from.getText());
					content = new String[liste.size()][7];
				}
				for (int a = 0;a<liste.size();a++) {
					content[a]=Arrays.copyOfRange(liste.get(a), 0, liste.get(a).length);
				}
				if(!to.getText().equals("")) {
					liste=search_values_destination(content,to.getText());
					content = new String[liste.size()][7];
				}
				for (int a = 0;a<liste.size();a++) {
					content[a]=Arrays.copyOfRange(liste.get(a), 0, liste.get(a).length);
				}
				System.out.println(content.length);
				
				DefaultTableModel dtm = new DefaultTableModel(
						content,
						new String[] {
							"Date D", "Date A", "Source", "Destination", "Durée", "places restantes"
						}
				);
				
				reservationNew.setModel(dtm);
				
				dtm.fireTableDataChanged();
				
			}
		});
		find_new.setIcon(new ImageIcon("img\\loupe_small.png"));
		find_new.setOpaque(false);
		find_new.setContentAreaFilled(false);
		find_new.setBorderPainted(false);
		find_new.setBounds(1005, 7, 34, 30);
		find_new.setVisible(true);
		panel_2_1.add(find_new);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DESTIONATION :");
		lblNewLabel_2_1_1.setBounds(732, 7, 98, 30);
		panel_2_1.add(lblNewLabel_2_1_1);
			JButton clear_from = new JButton("");
		clear_from.setBounds(496, 10, 25, 25);
		clear_from.setIcon(new ImageIcon("img\\x_small.png"));
		clear_from.setOpaque(false);
		clear_from.setContentAreaFilled(false);
		clear_from.setBorderPainted(true);
		panel_2_1.add(clear_from);
		
		JButton clear_to = new JButton("");
		clear_to.setOpaque(false);
		clear_to.setContentAreaFilled(false);
		clear_to.setBorderPainted(true);
		clear_to.setIcon(new ImageIcon("img\\x_small.png"));
		clear_to.setBounds(829, 12, 25, 25);
		panel_2_1.add(clear_to);
		clear_from.setVisible(false);
		clear_to.setVisible(false);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prenom.setHorizontalAlignment(SwingConstants.LEADING);
				nom.setHorizontalAlignment(SwingConstants.LEADING);
				passport.setHorizontalAlignment(SwingConstants.LEADING);
				nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
				prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
				passport.setFont(new Font("Tahoma", Font.PLAIN, 13));
				passport.setFocusable(true);
				nom.setFocusable(true);
				prenom.setFocusable(true);
				edit.setVisible(false);
				save.setVisible(true);
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbh.udapteValuesOfUser(ID,nom.getText(),prenom.getText(),passport.getText());
				passport.setFocusable(false);
				nom.setFocusable(false);
				prenom.setFocusable(false);
				save.setVisible(false);
				edit.setVisible(true);
				nom.setHorizontalAlignment(SwingConstants.CENTER);
				prenom.setHorizontalAlignment(SwingConstants.CENTER);
				passport.setHorizontalAlignment(SwingConstants.CENTER);
				nom.setFont(new Font("Tahoma", Font.BOLD, 13));
				prenom.setFont(new Font("Tahoma", Font.BOLD, 13));
				passport.setFont(new Font("Tahoma", Font.BOLD, 13));
			}
		});
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(findMe.getText().length()!=0) {
					
					cancel.setVisible(true);
					if(ticketList==null) {
						list.setVisible(false);
						noReservation_label.setVisible(true);
					}else {
						if(ticketList.size()==0) {
							list.setVisible(false);
							noReservation_label.setVisible(true);
						}else {
							list.setVisible(true);
							noReservation_label.setVisible(false);
							findReservation(findMe.getText());
						}
					}
				}
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel.setVisible(false);
				
				findMe.setText("");
				fill_reservation(list,ticketList);
			}
		});
		//fill_reservation(list,ticketList);
		find_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!from.getText().equals("")) {
					clear_from.setVisible(true);
					
				}
				if (!to.getText().equals("")) {
					clear_to.setVisible(true);
					
				}
				//perform the search and refresh the JTable.
			}
		});
		clear_from.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillReservationNew();
				from.setText("");
				clear_from.setVisible(false);
				
			}
		});
		clear_to.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillReservationNew();
				to.setText("");
				clear_to.setVisible(false);
			}
		});
		fillReservationNew();
		fillReservationExisting();
		frmHomePage.setVisible(true);
	}

	protected ArrayList<String[]> search_values_source(String[][] content, String text) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		
		for(String[] e: content) {
			if(e[2].toLowerCase().contains(text.toLowerCase())) {
				res.add(e);
				
			}
			
		}
		return res;
	}
	protected ArrayList<String[]> search_values_destination(String[][] content, String text) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		
		System.out.println(text);
		for(String[] e: content) {
			if(e[3].toLowerCase().contains(text.toLowerCase())) {
				res.add(e);
				
			}
			
		}
		return res;
	}

	private void fill_reservation(JTable list,ArrayList<String> ticketList) {
		
		if(ticketList == null) {
			list.setVisible(true);
			list.setBackground(new Color(66, 182, 245));
			String[] title = {"Date départ", "Heure d'Embarquement", "Heure Décollage","Durée","Siège","Status"};
			String[][] vals = {{"1","1","1","1","1","1"}};
			list = new JTable(vals,title){
		        private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        };
		    };
		}else {
			if(ticketList.size()==0) {
				list.setVisible(false);
			}else {
				list.setVisible(true);
				
				
				
			}
		}
		
	}
	protected void fillReservationNew(){
		ArrayList<String[]> body = dbh.getflights();
		String[][] corps = new String[body.size()][6];
		//reservationNew.addColumn(new TableColumn());
		int i = 0;
		for (String[] e : body) {
			
			corps[i]=Arrays.copyOfRange(e, 1, 7);
			i++;
		}
		this.corps_new=corps;
		reservationNew.setModel(new DefaultTableModel(
				corps,
				new String[] {
					"Date D", "Date A", "Source", "Destination", "Durée", "places restantes"
				}
			));
		
	}
	protected void fillReservationExisting(){
		ArrayList<String[]> body = dbh.getflightsBooked();
		String[][] corps = new String[body.size()][6];
		//reservationNew.addColumn(new TableColumn());
		int i = 0;
		for (String[] e : body) {
			
			corps[i]=Arrays.copyOfRange(e, 2, 8);
			i++;
		}
		this.corps_booked=corps;
		list.setModel(new DefaultTableModel(
				corps,
				new String[] {"Date départ", "Heure d'Embarquement", "Heure Décollage","Durée","Siège","Status"}
			));
		
	}

	protected void findReservation(String text) {
		//incomplete
		
	}
}
