import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import database.DatabaseHelper;
import flights.Billet;
import flights.Siege;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Book {

	private JFrame frmRservezVotrePlace;
	private JTextField fname;
	private JTextField adr;
	private JTextField pname;
	private JTextField passportn;
	private JTextField idflight;
	private JTextField aeroStart;
	private JTextField aeroEnd;
	private JLabel places;
	private JLabel places_final;
	private JTextField timeStart;
	private JTextField timeEnd;
	private int coord_x,coord_y;
	private boolean clicked=false;
	private ArrayList<ArrayList> list= new ArrayList<ArrayList>();
	private String idv;
	private int IDENTIFIER;
	private DatabaseHelper dbh=null;
	private JTextField idv_final;
	private JTextField from_time;
	private JTextField from_aero;
	private JTextField to_time;
	private JTextField to_aero;
	private JLabel seat;
	private JLabel price;
	private int[] premium = {2,3,4,22,23,24,42,43,44};
	private JLabel YY;
	private JButton F;
	private JButton E;
	private JButton D;
	private JButton C;
	private JButton B;
	private JButton A;
	private JLabel type;
	private JRadioButton radio_front;
	private JRadioButton radio_center;
	private JRadioButton radio_back;
	private int selected_radio=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book window = new Book("JBU1420-1510381558-airline-037",1);
					window.frmRservezVotrePlace.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Book(String idv,int id) {
		
		this.IDENTIFIER = id;
		this.idv = idv;
		dbh = new DatabaseHelper();
		dbh.connect();
		initialize(idv,id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param id 
	 * @param idv 
	 */
	private void initialize(String idv, int id) {
		
		int number_of_rows = 20;
		frmRservezVotrePlace = new JFrame();
		frmRservezVotrePlace.setResizable(false);
		frmRservezVotrePlace.setTitle("R\u00E9servez Votre Place");
		frmRservezVotrePlace.setBounds(100, 100, 1221, 703);
		frmRservezVotrePlace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRservezVotrePlace.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("  Terminer et Payer");
		btnNewButton.setIcon(new ImageIcon("img\\pay_small.png"));
		btnNewButton.setBounds(714, 522, 234, 48);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 39, 960, 599);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(218, 13, 516, 447);
		panel_7.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Prix \u00E0 Payer : ");
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2_1.setBounds(186, 113, 91, 26);
		panel_10.add(lblNewLabel_6_2_1);
		
		JLabel price_1 = new JLabel("New label");
		price_1.setForeground(Color.RED);
		price_1.setBounds(284, 113, 56, 26);
		panel_10.add(price_1);
		
		JLabel bank = new JLabel("New label");
		bank.setBorder(new LineBorder(Color.RED, 1, true));
		bank.setHorizontalAlignment(SwingConstants.CENTER);
		bank.setBounds(62, 270, 382, 35);
		panel_10.add(bank);
		
		JButton copy = new JButton("");
		copy.setToolTipText("Copier Le Code");
		copy.setIcon(new ImageIcon("D:\\Project Java final\\Projet\\img\\copy.png"));
		copy.setBounds(239, 323, 40, 40);
		panel_10.add(copy);
		
		JLabel lblNewLabel_8 = new JLabel("Payer cette somme chez votre banque au compte bancaire suivant ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(62, 164, 395, 52);
		panel_10.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel(" avec comme message  votre N\u00B0 de passport");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setBounds(62, 205, 395, 52);
		panel_10.add(lblNewLabel_8_1);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBounds(254, 5, 452, 476);
		verticalBox_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_7.add(verticalBox_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(null);
		verticalBox_1_1.add(panel_2_1);
		
		JLabel lblInformationsSueLe_1 = new JLabel("RECAPITULATIF DE LA RESERVATION");
		lblInformationsSueLe_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationsSueLe_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformationsSueLe_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JLabel lblNewLabel_4_4 = new JLabel("ID VOL :");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		idv_final = new JTextField();
		idv_final.setText((String) null);
		idv_final.setFocusable(false);
		idv_final.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("De : ");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		from_time = new JTextField();
		from_time.setText((String) null);
		from_time.setFocusable(false);
		from_time.setColumns(10);
		
		from_aero = new JTextField();
		from_aero.setText((String) null);
		from_aero.setFocusable(false);
		from_aero.setColumns(10);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Vers :");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		to_time = new JTextField();
		to_time.setText((String) null);
		to_time.setFocusable(false);
		to_time.setColumns(10);
		
		to_aero = new JTextField();
		to_aero.setText((String) null);
		to_aero.setFocusable(false);
		to_aero.setColumns(10);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("NB De Places :");
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		places_final = new JLabel("<dynamic> / <dynamic>");
		places_final.setHorizontalAlignment(SwingConstants.CENTER);
		places_final.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Si\u00E8ge : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		seat = new JLabel("New label");
		seat.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_6_2 = new JLabel("Prix \u00E0 Payer : ");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		price = new JLabel("New label");
		price.setForeground(Color.RED);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Afficher Le Si\u00E8ge");
		
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		//chckbxNewCheckBox
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInformationsSueLe_1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblNewLabel_4_4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(idv_final, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
										.addComponent(from_time, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(from_aero, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblNewLabel_4_2_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
										.addComponent(to_time, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(to_aero, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblNewLabel_4_3_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(places_final, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(seat)
									.addGap(100)
									.addComponent(lblNewLabel_6_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(price))
								.addComponent(chckbxNewCheckBox))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addComponent(lblInformationsSueLe_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(idv_final, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addComponent(from_time, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(from_aero, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_4_2_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addComponent(to_time, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(to_aero, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_3_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(places_final, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(seat, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(price, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(chckbxNewCheckBox)
					.addContainerGap())
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(545, 91, 349, 328);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(142, 41, 79, 242);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(7, 2, 0, 0));
		panel_9.setVisible(false);
		JLabel lblNewLabel_7_1 = new JLabel("A");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1);
		
		this.A = new JButton("");
		panel_9.add(A);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("B");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_1);
		
		this.B = new JButton("");
		panel_9.add(B);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("C");
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_2);
		
		this.C = new JButton("");
		panel_9.add(C);
		
		JLabel lblNewLabel_7_1_3 = new JLabel(" ");
		lblNewLabel_7_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_3);
		
		 this.YY = new JLabel("3");
		YY.setFont(new Font("Tahoma", Font.BOLD, 13));
		YY.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(YY);
		
		JLabel lblNewLabel_7_1_4 = new JLabel("D");
		lblNewLabel_7_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_4);
		
		this.D = new JButton("");
		panel_9.add(D);
		
		JLabel lblNewLabel_7_1_5 = new JLabel("E");
		lblNewLabel_7_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_5);
		
		this.E = new JButton("");
		panel_9.add(E);
		
		JLabel lblNewLabel_7_1_6 = new JLabel("F");
		lblNewLabel_7_1_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7_1_6);
		
		this.F = new JButton("");
		panel_9.add(F);
		
		this.type = new JLabel("Economique");
		type.setBounds(226, 141, 111, 33);
		panel_8.add(type);
		panel_7.add(btnNewButton);
		frmRservezVotrePlace.getContentPane().add(panel_7);								
		panel_7.setLayout(null);
		
		JButton btnChangerLeSige = new JButton("Changer Le Si\u00E8ge");
		btnChangerLeSige.setIcon(new ImageIcon("img\\seat_next.png"));
		btnChangerLeSige.setBounds(12, 522, 234, 48);
		panel_7.add(btnChangerLeSige);
		
		JButton backhome = new JButton("Revenir A L'accueil");
		backhome.setBounds(358, 522, 234, 48);
		panel_7.add(backhome);
		backhome.setIcon(new ImageIcon("img\\home_small.png"));
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 153, 51));
		progressBar.setValue(2);
		progressBar.setBounds(12, 13, 1190, 13);
		frmRservezVotrePlace.getContentPane().add(progressBar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 39, 1190, 601);
		frmRservezVotrePlace.getContentPane().add(panel_3); 
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(12, 191, 1166, 294);
		ArrayList<Box> listBox = new ArrayList<Box>();
		ArrayList<Object> listrow = new ArrayList<Object>();
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panel_6.setBounds(12, 191, number_of_rows*35, 294);
		
		JLabel head = new JLabel("");
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setIcon(new ImageIcon("img\\head.png"));
		
		JLabel tail = new JLabel("");
		head.setBounds(0,0,45,294);
		
		tail.setBounds(0,0,45,294);
		addNumberOfRows(panel_6,number_of_rows);  				
		panel_3.add(panel_4,BorderLayout.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(head)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(998)
							.addComponent(tail))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 981, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(head))
						.addComponent(tail, Alignment.TRAILING)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		
		
		
		
		
		JButton valider = new JButton(" Vérifier Et Réserver");
		valider.setIcon(new ImageIcon("img\\check_small.png"));
		valider.setBounds(1178-191, 559, 191, 40);
		panel_3.add(valider);
		
		JButton btnPageDacceuil_1 = new JButton("Choix du siège");
		btnPageDacceuil_1.setIcon(new ImageIcon("img\\\\seat_next.png"));
		btnPageDacceuil_1.setBounds(12, 554, 161, 40);
		panel_3.add(btnPageDacceuil_1);
		
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(306, 52, 497, 108);
		panel_3.add(horizontalBox);
		
		JPanel panel_5 = new JPanel();
		horizontalBox.add(panel_5);
		panel_5.setLayout(null);
		
		this.radio_front = new JRadioButton("Avant");
		radio_front.setBounds(53, 65, 127, 25);
		radio_front.setSelected(true);
		panel_5.add(radio_front);
		radio_front.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 19));
		
		this.radio_center = new JRadioButton("Milieu");
		radio_center.setBounds(207, 65, 127, 25);
		panel_5.add(radio_center);
		radio_center.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 19));
		
		this.radio_back = new JRadioButton("Arri\u00E8re");
		radio_back.setBounds(374, 65, 117, 25);
		panel_5.add(radio_back);
		radio_back.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblNewLabel_5 = new JLabel("S\u00E9l\u00E9ctionnez L'emplacement Du si\u00E8ge Souhait\u00E9");
		lblNewLabel_5.setBounds(0, 13, 496, 25);
		panel_5.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup  rg = new ButtonGroup ();
		rg.add(radio_front);
		rg.add(radio_center);
		rg.add(radio_back);
		radio_front.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				head.setIcon(new ImageIcon("img\\head.png"));
				setSelectedradion(0);
				tail.setIcon(null);
				head.setText("");
				tail.setText("");
				update(panel_6,0);
				
			}
			
		});
		radio_center.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedradion(1);
				head.setIcon(null);
				head.setText("                  " );
				tail.setIcon(null);
				tail.setText("                  " );
				update(panel_6,20);
			}
			
		});
		radio_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedradion(2);
				tail.setIcon(new ImageIcon("img\\tail.png"));
				head.setIcon(null);
				head.setText("");
				tail.setText("");
				update(panel_6,40);
			}
			
		});
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					verticalBox_1_1.setBounds(24, 5, 452, 476);
					type.setVisible(true);
					
					panel_9.setVisible(true);
				}else {
					verticalBox_1_1.setBounds(254, 5, 452, 476);
					panel_9.setVisible(false);
					type.setVisible(false);
				}
			}
		});
		type.setVisible(false);
		JPanel panel = new JPanel();
		panel.setBounds(12, 39, 958, 601);
		frmRservezVotrePlace.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		verticalBox_1.setBounds(506, 13, 440, 476);
		panel.add(verticalBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		verticalBox_1.add(panel_2);
		
		JLabel lblInformationsSueLe = new JLabel("INFORMATIONS SUE LE VOL");
		lblInformationsSueLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationsSueLe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformationsSueLe.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		idflight = new JTextField();
		idflight.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID VOL :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_4_1 = new JLabel("De : ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		aeroStart = new JTextField();
		aeroStart.setColumns(10);
		
		timeStart = new JTextField();
		timeStart.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Vers :");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		aeroEnd = new JTextField();
		aeroEnd.setColumns(10);
		
		timeEnd = new JTextField();
		timeEnd.setColumns(10);
		
		places = new JLabel("0/0");
		places.setFont(new Font("Tahoma", Font.PLAIN, 16));
		places.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4_3 = new JLabel("NB De Places :");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInformationsSueLe, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(idflight, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(aeroStart, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(timeStart, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(aeroEnd, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(timeEnd, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(places, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblInformationsSueLe, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(idflight, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(aeroStart, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(timeStart, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(aeroEnd, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(timeEnd, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(places, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		verticalBox.setBounds(12, 13, 440, 476);
		panel.add(verticalBox);
		
		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		adr = new JTextField();
		adr.setColumns(10);
		
		passportn = new JTextField();
		passportn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 Passport :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		//scrollPane.addContent()
		pname = new JTextField();
		pname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		fname = new JTextField();
		fname.setColumns(10);
		
		JLabel nom = new JLabel("Nom : ");
		nom.setAlignmentX(Component.CENTER_ALIGNMENT);
		nom.setFont(new Font("Tahoma", Font.BOLD, 13));
		nom.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel = new JLabel("INFORMATIONS PERSONNELLES");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(fname, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(pname, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(passportn, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(adr, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(nom, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(fname, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(pname, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(passportn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(adr, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
		);
		panel_1.setLayout(gl_panel_1);
		fill_textboxes(idv,this.IDENTIFIER);
		JButton btnPageDacceuil = new JButton("Page d'accueil");
		btnPageDacceuil.setIcon(new ImageIcon("img\\home_small.png"));
		btnPageDacceuil.setBounds(12, 554, 161, 40);
		panel.add(btnPageDacceuil);
		btnPageDacceuil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmRservezVotrePlace.dispose();
				backToHomePage();
				
			}
			
		});
		
		JButton btnNewButton_1_1 = new JButton("Choix du siège");
		btnNewButton_1_1.setIcon(new ImageIcon("img\\seat_next.png"));
		btnNewButton_1_1.setBounds(755, 559, 191, 40);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);
				panel_7.setVisible(false);
				panel.setVisible(false);
				frmRservezVotrePlace.setBounds(100, 100, 1221, 703);
				progressBar.setBounds(12, 13, 1190, 13);
				progressBar.setValue(40);
				
			}
			
		});
		btnChangerLeSige.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);
				panel.setVisible(false);
				panel_7.setVisible(false);
				frmRservezVotrePlace.setBounds(100, 100, 1221, 703);
				progressBar.setBounds(12, 13, 1190, 13);
				progressBar.setValue(40);
				
			}
			
		});
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmRservezVotrePlace.setBounds(100, 100, 988, 703);
				progressBar.setBounds(12, 13, 957, 13);
				progressBar.setValue(80);
				panel.setVisible(false);
				panel_3.setVisible(false);
				panel_7.setVisible(true);
				fill_final_page();
				
			}
			
		});
		//JScrollPane scrollPane = new JScrollPane();
		panel_3.setVisible(false);
		panel.setVisible(true);
		frmRservezVotrePlace.setBounds(100, 100, 988, 703);
		progressBar.setBounds(12, 13, 957, 13);
		frmRservezVotrePlace.setVisible(true);
		
		btnPageDacceuil_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_3.setVisible(false);
				progressBar.setBounds(12, 13, 957, 13);
				progressBar.setValue(2);
				frmRservezVotrePlace.setBounds(100, 100, 988, 703);
			}
			
		});
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(100);
				verticalBox_1_1.setVisible(false);
				panel_8.setVisible(false);
				progressBar.setBounds(12, 13, 957, 13);
				panel_10.setVisible(true);
				backhome.setVisible(true);
				btnNewButton.setVisible(false);
				btnChangerLeSige.setVisible(false);
				price_1.setText(price.getText());
				Math.random();
				   String rand = "";
				   for (int e1  = 0; e1<24; e1++) {
					   int random1= (int) (Math.random()*10);System.out.println(random1);
					   while (random1==0) {
						   
						   random1= (int)( Math.random()*10);
						   System.out.println(random1);
					   }
					   rand = rand + random1;
				   }
				
				bank.setText(""+rand);
				 
				Siege s;
				if(type.getText().contains("1")) {
					s = new Siege("P",seat.getText());
				}else {
					s = new Siege("E",seat.getText());
				}
				Billet b = new Billet(from_time.getText(),to_time.getText());
				
				addReservation(s,b);
			}
			
		});
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				
				clipboard.setContents(new StringSelection(bank.getText()),null);
				
			}
			
		});
		backhome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmRservezVotrePlace.dispose();
				 backToHomePage();
				
			}
			
		});
		
		frmRservezVotrePlace.setBounds(100, 100, 988, 703);
		//panel.setVisible(false);
		panel_3.setVisible(false);
		panel_7.setVisible(false);
		panel_10.setVisible(false);
		backhome.setVisible(false);
		updateAddBooked(panel_6,0);
		
		JLabel lblNewLabel_7 = new JLabel("Informations : ");
		lblNewLabel_7.setBounds(150, 500, 89, 45);
		panel_3.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("img\\seat_prem.png"));
		btnNewButton_1.setBounds(330, 500, 45, 45);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setIcon(new ImageIcon("img\\seat_un.png"));
		btnNewButton_1_2.setBounds(514, 502, 45, 45);
		panel_3.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setEnabled(false);
		btnNewButton_1_3.setIcon(new ImageIcon("img\\seat_full.png"));
		btnNewButton_1_3.setBounds(774, 502, 45, 45);
		panel_3.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_9 = new JLabel("1\u00E8re classe");
		lblNewLabel_9.setBounds(319, 559, 115, 16);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Economique");
		lblNewLabel_10.setBounds(501, 559, 89, 16);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("R\u00E9serv\u00E9");
		lblNewLabel_11.setBounds(774, 559, 56, 16);
		panel_3.add(lblNewLabel_11);
		
	}

	protected void addReservation(Siege s, Billet b2) {
		dbh.addReservation(s,b2,this.IDENTIFIER,this.idv);
		
	}

	protected void setSelectedradion(int i) {
		this.selected_radio = i;
		System.out.println("zzzz = : "+i);
	}

	private void fill_final_page() {
		ArrayList<String> flight = dbh.getFlightInfo(this.idv);
		idv_final.setText(flight.get(0));
		from_aero.setText(flight.get(1));
		from_time.setText(flight.get(2).substring(0,16));
		to_aero.setText(flight.get(3));
		to_time.setText(flight.get(4).substring(0,16));
		places_final.setText(""+(Integer.parseInt(flight.get(5))-1)+" / "+flight.get(6));
		idv_final.setFocusable(false);
		from_aero.setFocusable(false);
		from_time.setFocusable(false);
		to_aero.setFocusable(false);
		to_time.setFocusable(false);
		String pos = "";
		switch(this.coord_x) {
		case 0:
			pos="A";
			break;
		case 1:
			pos="B";
			break;
		case 2:
			pos="C";
			break;
		case 4:
			pos="D";
			break;
		case 5:
			pos="E";
			break;
		case 6:
			pos="F";
			break;
		}
		seat.setText(""+(this.coord_y+1)+pos);
		int prix[] = getprice();
		price.setText("MAD "+prix[0]);
		YY.setText(""+(this.coord_y+1));
		ArrayList<JButton> btnlist = new ArrayList<JButton>(); 
		btnlist.add(A);btnlist.add(B);btnlist.add(C);btnlist.add(D);btnlist.add(E);btnlist.add(F);
		if(prix[1]==1) {
			type.setText("Siège 1ère classe");
			for (int i = 0 ; i <6;i++) {

				int r = i;
				if (r>=3) {
					r = r+1;
				}
				if (this.coord_x==r) {
					btnlist.get(i).setIcon(new ImageIcon("img\\seat_taken.png"));
				}else {
					btnlist.get(i).setIcon(new ImageIcon("img\\seat_prem.png"));
				}
				
			}
			
		}else {
			type.setText("Siège économique");
			for (int i = 0 ; i <6;i++) {
				int r = i;
				if (r>=3) {
					r = r+1;
				}
				if (this.coord_x==r) {
					btnlist.get(i).setIcon(new ImageIcon("img\\seat_selected.png"));
				}else {
					btnlist.get(i).setIcon(new ImageIcon("img\\seat_un.png"));
				}
				
			}
		}
	}

	private int[] getprice() {
		int[]  r = new int[2];
		int temp = dbh.getDistance(idv);
		boolean exists = false;
		for (int e : this.premium) {
			if (e-1==this.coord_y) {
				exists = true;
			}
		}
		
		
		if (exists) {
			 r[0] = ((int) ((float)temp*1.75));
			 r[1]= 1;
			return r;
		}else {
			r[0] = temp;
			 r[1]= 0;
			return r;
		}
		
	}

	protected void backToHomePage() {
		new HomePage(this.IDENTIFIER);
	}

	private void fill_textboxes(String idv2, int id) {
		
		ArrayList<String> user_data = dbh.getInfo(id);
		ArrayList<String> flight = dbh.getFlightInfo(idv);
		idflight.setText(flight.get(0));
		aeroStart.setText(flight.get(1));
		timeStart.setText(flight.get(2).substring(0,16));
		aeroEnd.setText(flight.get(3));
		timeEnd.setText(flight.get(4).substring(0,16));
		places.setText(flight.get(5)+" / "+flight.get(6));
		idflight.setFocusable(false);
		aeroStart.setFocusable(false);
		aeroEnd.setFocusable(false);
		timeEnd.setFocusable(false);
		timeStart.setFocusable(false);
		
		System.out.println(user_data.size());
		
		
		this.pname.setText(user_data.get(1));
		this.fname.setText(user_data.get(0));
		this.adr.setText(user_data.get(3));
		this.passportn.setText(user_data.get(2));
		
	}

	protected void update(JPanel panel_6, int i) {
		int count = 1;
		for( ArrayList<Object> liste_objets : this.list) {
			
			
				boolean exists = false;
				for (int e : this.premium) {
					if (e==count+i) {
						exists = true;
					}
				}
				//System.out.println("row number "+(count+i));
				String s = "";
				if (exists ) {
					s= "img\\seat_prem.png";
					((JButton)liste_objets.get(0)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(1)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(2)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(4)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(5)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(6)).setIcon(new ImageIcon(s));
					
					((JButton)liste_objets.get(0)).setEnabled(true);
					((JButton)liste_objets.get(1)).setEnabled(true);
					((JButton)liste_objets.get(2)).setEnabled(true);
					((JButton)liste_objets.get(4)).setEnabled(true);
					((JButton)liste_objets.get(5)).setEnabled(true);
					((JButton)liste_objets.get(6)).setEnabled(true);
				}else {
					s= "img\\seat_un.png";
					((JButton)liste_objets.get(0)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(1)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(2)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(4)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(5)).setIcon(new ImageIcon(s));
					((JButton)liste_objets.get(6)).setIcon(new ImageIcon(s));
					
					((JButton)liste_objets.get(0)).setEnabled(true);
					((JButton)liste_objets.get(1)).setEnabled(true);
					((JButton)liste_objets.get(2)).setEnabled(true);
					((JButton)liste_objets.get(4)).setEnabled(true);
					((JButton)liste_objets.get(5)).setEnabled(true);
					((JButton)liste_objets.get(6)).setEnabled(true);
				}
				
				this.clicked=false;
			
			((JLabel)liste_objets.get(3)).setText("   "+String.valueOf(count+i));
			count++;
		}
		updateAddBooked(panel_6,(int)i/20);
		
	}
	
	
	protected void updateAddBooked(JPanel panel_6, int i) {
	
		ArrayList<int[]> coord = dbh.getcoords(this.idv);
		
		
		for (int[] couple_Ai : coord) {
			System.out.println("coords selected "+couple_Ai[0]+" "+couple_Ai[1]);
			if(i == 0) {
				if(couple_Ai[1]<20) {
					((JButton)(this.list.get(couple_Ai[1]).get(couple_Ai[0]))).setIcon(new ImageIcon("img\\seat_full.png"));
					((JButton)(this.list.get(couple_Ai[1]).get(couple_Ai[0]))).setEnabled(false);;
				} 

				
			} else 
			if(i == 1) {
				if(couple_Ai[1]>=20 && couple_Ai[1]<40) {
					((JButton)(this.list.get(couple_Ai[1]-20).get(couple_Ai[0]))).setIcon(new ImageIcon("img\\seat_full.png"));
					((JButton)(this.list.get(couple_Ai[1]-20).get(couple_Ai[0]))).setEnabled(false);;
				}

				
			}else 

			if(i == 2) {
				
				if(couple_Ai[1]>=40) {
					((JButton)(this.list.get(couple_Ai[1]-40).get(couple_Ai[0]))).setIcon(new ImageIcon("img\\seat_full.png"));
					((JButton)(this.list.get(couple_Ai[1]-40).get(couple_Ai[0]))).setEnabled(false);;
				}
			}
			

		}
		
		
		
	}
	

	

	private void addNumberOfRows(JPanel panel_4, int i) {
		ArrayList<Box> listBox = new ArrayList<Box>();
		
		ArrayList<ArrayList> res = new  ArrayList<ArrayList>();
		ArrayList<Object> listrow = new ArrayList<Object>();
		int zzz = this.selected_radio;
		for (int e =0; e<i;e++) {
			
			listBox.add(Box.createVerticalBox());
		//	int x = listBox.size()-1;
			listBox.get(e).setPreferredSize(new Dimension(37,415));
			listBox.get(e).setBounds((e)*37, 0, 37, 415);
			panel_4.add(listBox.get(e));
			listrow = new ArrayList<Object>();
			
			
			listrow = getlist(e+1,zzz);
			res.add(listrow);
			listBox.get(e).add((JButton)listrow.get(0));
			listBox.get(e).add((JButton)listrow.get(1));
			listBox.get(e).add((JButton)listrow.get(2));
			listBox.get(e).add( (JLabel)listrow.get(3));
			listBox.get(e).add((JButton)listrow.get(4));
			listBox.get(e).add((JButton)listrow.get(5));
			listBox.get(e).add((JButton)listrow.get(6));
			
		}
		this.list=res;
			
	}



	
	private ArrayList<Object> getlist(int i,int extra) {
		ArrayList<Object> listrow = new ArrayList<Object>();
		String  s =nameImage(i-1+extra*20 );
		String S ="";
		if(s.contains("taken")) {
			S="seat_prem";
		}else {
			S="seat_un";
		}
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		//JButton btnNewButton = new JButton("  ");
		//verticalBox_2.add(btnNewButton);
		listrow.add(new JButton(""));
		//JButton btnNewButton_1 = new JButton("  ");
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		//verticalBox_2.add(btnNewButton_1);
		listrow.add(new JLabel("   "+i));
		
		//JLabel lblNewLabel_5 = new JLabel("     1     ");
		//verticalBox_2.add(lblNewLabel_5);
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		//JButton btnNewButton_2 = new JButton("  ");
		//verticalBox_2.add(btnNewButton_2);
		listrow.add(new JButton(""));
		
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\"+S+".png"));
		
		((JButton) listrow.get(0)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(0,i-1+extra*20);
				((JButton) listrow.get(0)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		((JButton) listrow.get(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(1,i-1+extra*20);
				((JButton) listrow.get(1)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		((JButton) listrow.get(2)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(2,i-1+extra*20);
				((JButton) listrow.get(2)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		((JButton) listrow.get(4)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(4,i-1+extra*20);
				((JButton) listrow.get(4)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		((JButton) listrow.get(5)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(5,i-1+extra*20);
				((JButton) listrow.get(5)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		((JButton) listrow.get(6)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					resetImage(get_x(),get_y());
					unclick(get_x(),get_y());
					
				}
				setcoord(6,i-1+extra*20);
				
				((JButton) listrow.get(6)).setIcon(new ImageIcon("img\\"+s+".png"));
			}
			
		});
		
		//JButton btnNewButton_1_2 = new JButton("  ");
		//verticalBox_2.add(btnNewButton_1_2);
		return listrow;
	}
	protected String nameImage(int r ) {
		boolean exists = false;
		for (int e : this.premium) {
			if (e==r+1+(20*this.selected_radio)) {
				exists = true;
			}
		}
		//System.out.println("row number "+get_x);
		if (exists ) {
			return "seat_taken";
		}else {
			return "seat_selected";
		}
	}
	protected void resetImage(int get_x, int get_y) {
		
		boolean exists = false;
		for (int e : this.premium) {
			if (e-1==get_y+(20*this.selected_radio)) {
				exists = true;
			}
		}
	
		if (exists ) {
			((JButton)(this.list.get(get_y).get(get_x))).setIcon(new ImageIcon("img\\seat_prem.png"));
		}else {
			((JButton)(this.list.get(get_y).get(get_x))).setIcon(new ImageIcon("img\\seat_un.png"));
		}
		
		
		
	}

	private void setcoord(int x, int y) {
		this.coord_x=x;
		int extra = this.selected_radio;
		//System.out.println("extra = "+extra);
		this.coord_y= y + 20*extra;
		this.clicked=true;
		System.out.println(x+" "+coord_y);
	}
	private int get_x() {
		return this.coord_x;
	}
	private int get_y() {
		return this.coord_y%20;
	}
	private void unclick(int x, int y) {
		// INCOMPLETE
	}
	private boolean getclicked() {
		return this.clicked;
	}
}
