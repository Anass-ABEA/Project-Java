import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DatabaseHelper;
import flights.Avion;

public class gestion_avions {

	private JFrame frame;
	private JTextField id;
	private JTextField com;
	private JTextField nb;
	private JTable table;
	private DatabaseHelper dbh =null;
	private ArrayList<Avion> list;
	private int ident;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_avions window = new gestion_avions(1);
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
	public gestion_avions(int id) {
		this.dbh = new DatabaseHelper ();
		this.dbh.connect();
		this.ident = id;
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idx) {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(12, 13, 97, 49);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Home_admin(ident);
				
			}
			
		});
		
		
		id = new JTextField();
		id.setBounds(12, 104, 221, 38);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		com = new JTextField();
		com.setColumns(10);
		com.setBounds(344, 104, 221, 38);
		frame.getContentPane().add(com);
		
		nb = new JTextField();
		nb.setColumns(10);
		nb.setBounds(667, 104, 221, 38);
		frame.getContentPane().add(nb);
		nb.setHorizontalAlignment(SwingConstants.CENTER);
		com.setHorizontalAlignment(SwingConstants.CENTER);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblNewLabel = new JLabel("IDA : ");
		lblNewLabel.setBounds(12, 75, 221, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCompanie = new JLabel("Companie :");
		lblCompanie.setBounds(344, 75, 221, 32);
		frame.getContentPane().add(lblCompanie);
		
		JLabel lblNbplaces = new JLabel("Nombre De Places :");
		lblNbplaces.setBounds(667, 75, 221, 32);
		frame.getContentPane().add(lblNbplaces);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 188, 876, 497);
		frame.getContentPane().add(scrollPane);
		
		this.list = dbh.fillListe();
		String[][]  liste = new String[list.size()][3];
		System.out.println(list.size());
		int e= 0;
		for(Avion a : list) {
			System.out.println(a.getCompagnie());
			liste[e][0]= ""+a.getIdAvion();
			liste[e][1]= ""+a.getCompagnie();
			liste[e][2]= ""+a.getNb_place();
			e++;
		}
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			liste,
			new String[] {
				"ID avion", "Companie","N\\u00B0 Places"
			}
		));
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				filltb(table.getSelectedRow());
				
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
		
		JButton btnNewButton_1 = new JButton("Appliquer");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 51, 255), 2, true));
		btnNewButton_1.setForeground(new Color(0, 51, 255));
		btnNewButton_1.setBounds(791, 13, 97, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton del = new JButton("Supprimer");
		del.setForeground(new Color(255, 51, 51));
		del.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		del.setBounds(667, 13, 97, 49);
		frame.getContentPane().add(del);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.addnewavion(new Avion(id.getText(),com.getText(),nb.getText()),idx);
				frame.dispose();
				new gestion_avions(idx);
			}
			
		});
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbh.deleteAvion(new Avion(id.getText(),com.getText(),nb.getText()),idx);
				frame.dispose();
				new gestion_avions(idx);
			}
			
		});
		frame.setVisible(true);
		
	}

	protected void filltb(int selectedRow) {
		Avion a = this.list.get(selectedRow);
		this.id.setText(""+a.getIdAvion());
		this.com.setText(a.getCompagnie());
		this.nb.setText(""+a.getNb_place());
		
	}
}
