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

public class Book {

	private JFrame frmRservezVotrePlace;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel places;
	private JTextField textField_8;
	private JTextField textField_9;
	private int coord_x,coord_y;
	private boolean clicked=false;
	private ArrayList<ArrayList> list= new ArrayList<ArrayList>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book window = new Book("qsd",1);
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
		frmRservezVotrePlace.setBounds(100, 100, 1220, 706);
		frmRservezVotrePlace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRservezVotrePlace.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 153, 51));
		progressBar.setValue(36);
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
		head.setIcon(new ImageIcon("D:\\Project Java final\\Projet\\img\\head.png"));
		
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
		
		
		
		
		
		
		
		
		JButton valider = new JButton("Valider Et Continuer");
		valider.setIcon(new ImageIcon("img\\check_small.png"));
		valider.setBounds(1178-191, 559, 191, 34);
		panel_3.add(valider);
		
		JButton btnPageDacceuil_1 = new JButton("Page d'accueil");
		btnPageDacceuil_1.setIcon(new ImageIcon("img\\home_small.png"));
		btnPageDacceuil_1.setBounds(12, 554, 161, 34);
		panel_3.add(btnPageDacceuil_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(306, 52, 497, 108);
		panel_3.add(horizontalBox);
		
		JPanel panel_5 = new JPanel();
		horizontalBox.add(panel_5);
		panel_5.setLayout(null);
		
		JRadioButton radio_front = new JRadioButton("Avant");
		radio_front.setBounds(53, 65, 127, 25);
		radio_front.setSelected(true);
		panel_5.add(radio_front);
		radio_front.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 19));
		
		JRadioButton radio_center = new JRadioButton("Milieu");
		radio_center.setBounds(207, 65, 127, 25);
		panel_5.add(radio_center);
		radio_center.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 19));
		
		JRadioButton radio_back = new JRadioButton("Arri\u00E8re");
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
				tail.setIcon(null);
				head.setText("");
				tail.setText("");
				update(panel_6,0);
			}
			
		});
		radio_center.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
				tail.setIcon(new ImageIcon("img\\tail.png"));
				head.setIcon(null);
				head.setText("");
				tail.setText("");
				update(panel_6,40);
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 39, 958, 601);
		frmRservezVotrePlace.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID VOL :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_4_1 = new JLabel("De : ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Vers :");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
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
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 Passport :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		//scrollPane.addContent()
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setColumns(10);
		
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
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnPageDacceuil = new JButton("Page d'accueil");
		btnPageDacceuil.setIcon(new ImageIcon("D:\\Project Java final\\Projet\\img\\home_small.png"));
		btnPageDacceuil.setBounds(12, 554, 161, 34);
		panel.add(btnPageDacceuil);
		
		JButton btnNewButton_1_1 = new JButton("Valider Et Continuer");
		btnNewButton_1_1.setIcon(new ImageIcon("D:\\Project Java final\\Projet\\img\\check_small.png"));
		btnNewButton_1_1.setBounds(755, 559, 191, 34);
		panel.add(btnNewButton_1_1);
		//JScrollPane scrollPane = new JScrollPane();
		
		frmRservezVotrePlace.setVisible(true);
	}

	protected void update(JPanel panel_6, int i) {
		int count = 1;
		for( ArrayList<Object> liste_objets : this.list) {
			if(this.clicked && count-1 == this.coord_y) {
				((JButton)liste_objets.get(this.coord_x)).setIcon(new ImageIcon("img\\seat_un.png"));
				this.clicked=false;
			}
			((JLabel)liste_objets.get(3)).setText("   "+String.valueOf(count+i));
			count++;
		}
		
	}

	private void addNumberOfRows(JPanel panel_4, int i) {
		ArrayList<Box> listBox = new ArrayList<Box>();
		
		ArrayList<ArrayList> res = new  ArrayList<ArrayList>();
		ArrayList<Object> listrow = new ArrayList<Object>();
		for (int e =0; e<i;e++) {
			
			listBox.add(Box.createVerticalBox());
		//	int x = listBox.size()-1;
			listBox.get(e).setPreferredSize(new Dimension(37,415));
			listBox.get(e).setBounds((e)*37, 0, 37, 415);
			panel_4.add(listBox.get(e));
			listrow = new ArrayList<Object>();
			listrow = getlist(e+1);
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



	
	private ArrayList<Object> getlist(int i) {
		ArrayList<Object> listrow = new ArrayList<Object>();
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
		//JButton btnNewButton = new JButton("  ");
		//verticalBox_2.add(btnNewButton);
		listrow.add(new JButton(""));
		//JButton btnNewButton_1 = new JButton("  ");
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
		//verticalBox_2.add(btnNewButton_1);
		listrow.add(new JLabel("   "+i));
		
		//JLabel lblNewLabel_5 = new JLabel("     1     ");
		//verticalBox_2.add(lblNewLabel_5);
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
		//JButton btnNewButton_2 = new JButton("  ");
		//verticalBox_2.add(btnNewButton_2);
		listrow.add(new JButton(""));
		
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
		listrow.add(new JButton(""));
		((JButton)listrow.get(listrow.size()-1)).setIcon(new ImageIcon("img\\seat_un.png"));
	
		((JButton) listrow.get(0)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(0,i-1);
				((JButton) listrow.get(0)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		((JButton) listrow.get(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(1,i-1);
				((JButton) listrow.get(1)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		((JButton) listrow.get(2)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(2,i-1);
				((JButton) listrow.get(2)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		((JButton) listrow.get(4)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(4,i-1);
				((JButton) listrow.get(4)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		((JButton) listrow.get(5)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					unclick(get_x(),get_y());resetImage(get_x(),get_y());
				}
				setcoord(5,i-1);
				((JButton) listrow.get(5)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		((JButton) listrow.get(6)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getclicked()) {
					resetImage(get_x(),get_y());
					unclick(get_x(),get_y());
					
				}
				setcoord(6,i-1);
				((JButton) listrow.get(6)).setIcon(new ImageIcon("img\\seat_selected.png"));
			}
			
		});
		
		//JButton btnNewButton_1_2 = new JButton("  ");
		//verticalBox_2.add(btnNewButton_1_2);
		return listrow;
	}
	protected void resetImage(int get_x, int get_y) {
		((JButton)(this.list.get(get_y).get(get_x))).setIcon(new ImageIcon("img\\seat_un.png"));
		
		
	}

	private void setcoord(int x, int y) {
		this.coord_x=x;
		this.coord_y=y;
		this.clicked=true;
		System.out.println(x+" "+y);
	}
	private int get_x() {
		return this.coord_x;
	}
	private int get_y() {
		return this.coord_y;
	}
	private void unclick(int x, int y) {
		// INCOMPLETE
	}
	private boolean getclicked() {
		return this.clicked;
	}
}
