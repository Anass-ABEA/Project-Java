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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	
	private	JTable list;
	private JTable reservationNew;
	private JTextField to;
	private JTextField from;
	private String[][] corps_new=null;
	private String[][] corps_booked=null;
	private int IDENTIFIER;
	private JScrollPane scrollPane;
	private JLabel flight_id;
	private JLabel DateD;
	private JLabel DateA;
	private JLabel AD;
	private JLabel AA;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private ArrayList<String[]> arraycorps_new;
	
	
	

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
		this.IDENTIFIER=ID;
		System.out.println(ID);
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
		
		
		JButton book = new JButton("RESERVER");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHomePage.dispose();
				// create new form for reservation                                        INCOMPLETE
			}
		});
		
		book.setVisible(false);
		book.setBounds(12,628,115,44);
		reg.setBounds(902,619,154,62);
		frmHomePage.getContentPane().add(book);
		frmHomePage.getContentPane().add(reg);
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
		
		scrollPane = new JScrollPane();
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
		
		JButton annuler = new JButton("ANNULER");
		annuler.setBounds(234, 13, 97, 30);
		panel_2.add(annuler);
		annuler.setVisible(false);
		
		list.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {     // to detect doble click events
	            	annuler.setVisible(true);
	            	JTable target = (JTable)me.getSource();
	               	int row = target.getSelectedRow(); 
	               	
	               	
	               		
               		if (((String)list.getValueAt(row, 5)).contains("N"))  {
               			annuler.setEnabled(true);
               			annuler.setToolTipText("Annuler Votre Réservations");
               		}else {
               			annuler.setEnabled(false);
               			annuler.setToolTipText("Vous Ne Pouvez Pas Annuler Les Billets Validés");
               		}
	               	
	   
	            }
	         }
	      });
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(findMe.getText().length()!=0) {
					annuler.setVisible(false);
					cancel.setVisible(true);
					if(corps_booked==null) {
						list.setVisible(false);
						noReservation_label.setVisible(true);
					}else {
						if(corps_booked.length==0) {
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
		reservationNew.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {     // to detect doble click events
	            	JTable target = (JTable)me.getSource();
	               	int row = target.getSelectedRow(); 
	               	for( String[] str:arraycorps_new) {
	               		//System.out.println("start: "+str[1]+" end "+str[2]);
	               		if (str[1].equals((String)reservationNew.getValueAt(row, 0)) && str[2].equals((String)reservationNew.getValueAt(row, 1))) {
	               			flight_id.setText( str[0]);
	               		}
	               	}
	               	
		       		DateD.setText((String)reservationNew.getValueAt(row, 0));
		       		AD.setText((String)reservationNew.getValueAt(row, 2));
		       		AA.setText((String)reservationNew.getValueAt(row, 3));
		       		DateA.setText((String)reservationNew.getValueAt(row, 1));
		       		labels_visibility(true);
		       		book.setVisible(true);
	             
	            }
	         }
	      });
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel.setVisible(false);
				annuler.setVisible(false);
				findMe.setText("");
				int id = getid();
				fillReservationExisting(id);
			}
		});
		
		find_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labels_visibility(false);
				book.setVisible(false);
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
				labels_visibility(false);
				book.setVisible(false);
				
			}
		});
		clear_to.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillReservationNew();
				to.setText("");
				clear_to.setVisible(false);
				labels_visibility(false);
				book.setVisible(false);
			}
		});
		fillReservationNew();
		fillReservationExisting(this.IDENTIFIER);
		reservationNew.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		
		flight_id = new JLabel("New label");
		flight_id.setBounds(135, 648, 200, 30);
		frmHomePage.getContentPane().add(flight_id);
		
		 DateD = new JLabel("New label");
		DateD.setBounds(412, 619, 143, 30);
		frmHomePage.getContentPane().add(DateD);
		
		 AD = new JLabel("New label");
		AD.setBounds(412, 655, 168, 30);
		frmHomePage.getContentPane().add(AD);
		
		 AA = new JLabel("New label");
		AA.setBounds(660, 655, 223, 30);
		frmHomePage.getContentPane().add(AA);
		
		 DateA = new JLabel("New label");
		DateA.setBounds(660, 619, 143, 30);
		frmHomePage.getContentPane().add(DateA);
		
		 lblNewLabel_3 = new JLabel("ID Du Vol : ");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(135, 625, 73, 16);
		frmHomePage.getContentPane().add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("Depart :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(357, 642, 56, 16);
		frmHomePage.getContentPane().add(lblNewLabel_4);
		
		 lblNewLabel_4_1 = new JLabel("Arriv\u00E9e :");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(600, 642, 56, 16);
		frmHomePage.getContentPane().add(lblNewLabel_4_1);
		labels_visibility(false);
		frmHomePage.setVisible(true);
	}
	private void labels_visibility(boolean b) {
		flight_id.setVisible(b);
		DateD.setVisible(b);
		AD.setVisible(b);
		AA.setVisible(b);
		DateA.setVisible(b);
		lblNewLabel_3.setVisible(b);
		lblNewLabel_4.setVisible(b);
		lblNewLabel_4_1.setVisible(b);
		
	}

	protected int getid() {
		return this.IDENTIFIER;
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
			String[] title = {"Date D", "De", "Vers","Durée","Siège","Status"};
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
		this.arraycorps_new =body;
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
	protected void fillReservationExisting(int id){
		
		if(corps_booked == null) {
			
			
		}else {
			if(corps_booked.length==0) {
				list.setVisible(false);
				scrollPane.setVisible(false);
				
			}else {
				list.setVisible(true);
				scrollPane.setVisible(true);
				
				
				
			}
		}
		ArrayList<String[]> body = dbh.getflightsBooked(id);
		String[][] corps = new String[body.size()][6];
		//reservationNew.addColumn(new TableColumn());
		int i = 0;
		for (String[] e : body) {
			
			corps[i]=Arrays.copyOfRange(e, 2, 8);
			i++;
		}
		this.corps_booked=corps;
		if(corps_booked.length==0) {
			list.setVisible(false);
			scrollPane.setVisible(false);
			
		}else {
			list.setVisible(true);
			scrollPane.setVisible(true);
			
			
			
		}
		list.setModel(new DefaultTableModel(
				corps,
				new String[] {"Date départ", "Heure d'Embarquement", "Heure Décollage","Durée","Siège","Status"}
			));
		
	}

	protected void findReservation(String text) {
		//incomplete
		
	}
}
