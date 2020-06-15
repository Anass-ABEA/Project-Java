package database;
import java.sql.*;
import java.util.ArrayList;

import flights.Avion;
import flights.Billet;
import flights.Siege;
import flights.Vol;
import user.Utilisateur;
import user.Voyageur;


public class DatabaseHelper {
	Connection conn = null;
	Statement st ;
	
	
	void DatabaseHelper() {
		conn = null;
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/manager","root","");
			//System.out.print("connected");
			this.st  = conn.createStatement(); //cursor
			
		} catch (Exception e) {
			System.out.println("error while connecting to database");
			e.printStackTrace();
		}
		
	}
	private ResultSet executeSql(String sql) {
		ResultSet res = null;
		this.refresh_statment();
		try {
			res = st.executeQuery(sql); // EXECUTE SQL QUERY (select only)
			return res;
		} catch (Exception e) {
			System.out.println("SQL ERROR for the query : "+sql);
			e.printStackTrace();
		}
		 return res;
	}
	private void executeModif(String sql) {
		ResultSet res = null;
		this.refresh_statment();
		try {
			st.executeUpdate(sql); // EXECUTE SQL QUERY (insert and update)
			
		} catch (Exception e) {
			System.out.println("SQL ERROR for the query : "+sql);
			e.printStackTrace();
		}
		 
	}
	
	public int connect_user(Utilisateur u){
		String name;
		String pass;
		name = u.getLogin();
		pass= u.getPWD();
		int allow =-1;
		
		try {
			ResultSet  rs = this.executeSql("SELECT COUNT(*),admin from utilisateur WHERE login = '"+name+"' and pass = '"+pass+"';");
			if(rs.next()) {
				int e;
				e = rs.getInt(1);
				if (e==1){
					return rs.getInt(2);
				}
			}
		} catch (SQLException e1) {
			System.out.println("SQL ERROR for the query : "+"SELECT COUNT(*),admin from utilisateur WHERE login = '"+name+"' and pass = '"+pass+"';");
			allow = -1;
		}
		
		return allow;
	}

	public int addNewUser(Voyageur v) {
		String u; String p;String pname; String fname; String passPort; String adress;
		u=v.getLogin();
		p=v.getPWD();
		fname=v.getNom();
		pname=v.getPrenom();
		adress=v.getAdresse();
		passPort=v.getPasseport();
		this.executeModif("INSERT INTO Utilisateur (login,pass,admin)values ('"+u+"','"+p+"',0);");
		this.executeSql("commit;");
		ResultSet rs = this.executeSql("SELECT ID from Utilisateur where login ='"+u+"' and pass ='"+p+"';");
		int id=0;
		try {
			if(rs.next()) {
				id= rs.getInt(1);
				this.executeModif("INSERT INTO voyageur (id,nom,prenom,adresse,passport) values("+id+",'"+pname+"','"+fname+"','"+adress+"','"+passPort+"');");
			}
			
		} catch (SQLException e) {
			System.out.println("SQL ERROR for the query : "+"INSERT INTO voyageur (id,nom,prenom,adresse,passport) values("+id+",'"+pname+"','"+fname+"','"+adress+"','"+passPort+"');");
			id = 0;
		}
		
		
		return id;
		
	}
	public ArrayList<String> getInfo(int ID){
		ArrayList<String> res = new ArrayList<String>();
		
		ResultSet  rs = this.executeSql("SELECT * from voyageur WHERE ID = "+String.valueOf(ID)+";");
		try {
			if(rs.next()) {
				res.add(rs.getString(2));
				res.add(rs.getString(3));
				res.add(rs.getString(5));
				res.add(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("SQL ERROR for the query : "+"SELECT * from voyageur WHERE ID = "+String.valueOf(ID)+";");
			e.printStackTrace();
		}
		return res;
	}

	public void udapteValuesOfUser(int iD, String text, String text2, String text3) {
		this.executeModif("UPDATE voyageur SET nom = '"+text+"', prenom = '"+text2+"' ,passport ='"+text3+"' WHERE ID = "+String.valueOf(iD)+";");
		
	}

	public int getId(String user, String pass) {
		
		ResultSet rs = this.executeSql("SELECT ID from Utilisateur where login ='"+user+"' and pass ='"+pass+"';");
		
		try {
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} catch (SQLException e) {
			System.out.println("SQL ERROR for the query : "+"SELECT ID from Utilisateur where login ='"+user+"' and pass ='"+pass+"';");
			return 0;
		}
	}
	
	private void refresh_statment() {
		try {
			st  = conn.createStatement();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	public ArrayList<String[]> getflights() {
		String[] row = new String[7];
		ArrayList<String[]> res = new ArrayList<String[]>();
		ResultSet rs = this.executeSql("SELECT * from reservationnew;");
		
		try {
			while (rs.next()) {
				row = new String[7];
				row[0]=rs.getString(1);
				row[1]=rs.getString(2).substring(0,16);
				row[2]=rs.getString(3).substring(0,16);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
				row[5]=rs.getString(6).substring(0,5);;
				row[6]=rs.getString(7);
				res.add(row);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	public ArrayList<String[]> getflightsBooked(int iDENTIFIER) {
		String[] row = new String[8];
		ArrayList<String[]> res = new ArrayList<String[]>();
		ResultSet rs = this.executeSql("SELECT * from reservationbooked WHERE id_user = "+String.valueOf(iDENTIFIER));
		System.out.println();
		
		try {
			while (rs.next()) {
				row = new String[8];
				row[0]=rs.getString(1);
				row[1]=rs.getString(2);
				row[2]=rs.getString(3).substring(0,16);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
				row[5]=rs.getString(6).substring(0,5);
				row[6]=rs.getString(7);
				row[7]=rs.getString(8);
				res.add(row);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	public void cancelBooking(String id, String idv) {
		ResultSet rs = this.executeSql("SELECT idb FROM reservation where id_user="+id+" and idv = '"+idv+"';");
		try {
			if (rs.next()) {
				int idb = rs.getInt(1);
				this.executeModif("DELETE FROM billet where idb = "+String.valueOf(idb));
				//this.executeModif("DELETE FROM reservation where  id_user="+id+" and idv = '"+idv+"'and idb = "+String.valueOf(idb)+";");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//this.executeModif("");
	}

	public ArrayList<String> getFlightInfo(String idv) {
		ResultSet rs = this.executeSql("SELECT * FROM booking_list where idv='"+idv+"';");
		ArrayList<String> res = new ArrayList<String>();
		
		try {
			rs.next();
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
			res.add(""+rs.getInt(6));
			res.add(""+rs.getInt(7));
		} catch (SQLException e) {
			System.out.println("ERROR executing SQL : "+"SELECT * FROM booking_list where idv='"+idv+"';");
			e.printStackTrace();
		}
		
		
		
		
		return res;
	}

	public int getDistance(String idv) {
		ResultSet rs = this.executeSql("SELECT distance from vol where idv ='"+idv+"';");
		try {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
		
		
	}

	public void addReservation(Siege s, Billet b2, int identifier, String idv) {
		this.executeModif("INSERT INTO Siege (type,place) values ('"+s.getType()+"','"+s.getPlace()+"');");
		this.executeModif("INSERT INTO BILLET (dateVoyage,dateArrivee) values ('"+b2.getDateVoyage()+"','"+b2.getDateArrivee()+"');");
		ResultSet rs = this.executeSql("SELECT max(idb) from BILLET; ");
		ResultSet rs2 = this.executeSql("SELECT max(ids) from Siege; ");
		int idb = 0;
		int ids = 0;
		try {
			rs.next() ;  idb =  rs.getInt(1);
			rs2.next();  ids = rs2.getInt(1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		this.executeModif("INSERT INTO reservation values ('"+idv+"',"+identifier+","+ids+","+idb+");");
		
	}

	public ArrayList<int[]> getcoords(String idv) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		ResultSet rs = this.executeSql("SELECT place from reservationseats where idv = '"+idv+"';");
		System.out.println("SELECT place from reservationseats where idv = '"+idv+"';");
		try {
			while(rs.next()) {
				
				String s = rs.getString(1);
				int x = Integer.parseInt(s.substring(0,1));
				if (s.length()==3) {
					 x = Integer.parseInt(s.substring(0,2));
				}
				
				System.out.println("x = "+x);
				int y =0;
				switch (s.substring(1)) {
				case "A":
					y= 0;
					break;
				case "B":
					y= 1;
					break;
				case "C":
					y= 2;
					break;
				case "D":
					y= 4;
					break;
				case "E":
					y= 5;
					break;
				case "F":
					y= 6;
					break;
				}
				res.add(new int[] {y,x-1});
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<String> getLog() {
		ArrayList<String> res = new ArrayList<String>();
		
		ResultSet rs = this.executeSql("SELECT date,text from logs order by date DESC;");
		try {
			while(rs.next()) {
				res.add(rs.getString(1).substring(0,16)+ " :  "+rs.getString(2));
			}
		} catch (SQLException e) {
			res = new ArrayList<String>();
			res.add("THERE HAS BEEN A PROBLEM PLEASE TRY AGAIN LATER");
		}
		return res;
	}

	public String getbilletscount() {
		int count = 0;
		try {
			ResultSet rs  = this.executeSql("SELECT COUNT(*) From billet where etat = 'NV' ;");
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			
		}
		return String.valueOf(count);
	}

	public ArrayList<Avion> fillListe() {
		ArrayList<Avion> liste =new ArrayList<Avion>();
		
		try {
			ResultSet rs  = this.executeSql("SELECT * from Avion");
			
			while(rs.next()) {
				liste.add(new Avion(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}

	public void addnewavion(Avion avion,int id) {
		this.executeModif("INSERT INTO avion values ("+avion.getIdAvion()+",'"+avion.getCompagnie()+"',"+avion.getNb_place()+
				") ON DUPLICATE KEY UPDATE companie= '"+avion.getCompagnie()+"' , nb_place = "+avion.getNb_place()+" ;");
		this.executeModif("INSERT INTO logs(text) values (\"l'admin : "+id+" a modifié l'avion vers les caratéristiques : "+
				"("+avion.getIdAvion()+",'"+avion.getCompagnie()+"',"+avion.getNb_place()+
				")"+"\")");
	}

	public void deleteAvion(Avion avion,int id) {
		
		this.executeModif("DELETE FROM avion where ida = "+avion.getIdAvion());
		this.executeModif("INSERT INTO logs(text) values (\"l'admin : "+id+" a supprimé l'avion avec les caratéristiques : "+
				"("+avion.getIdAvion()+",'"+avion.getCompagnie()+"',"+avion.getNb_place()+
				")"+"\")");
	}

	public ArrayList<Vol> fillListeVol() {
		ArrayList<Vol> liste = new ArrayList<Vol>();
		try {
			ResultSet rs  = this.executeSql("SELECT * from VOL");
			
			while(rs.next()) {
				liste.add(new Vol(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public void deleteVol(Vol vol, int id) {
		this.executeModif("DELETE from VOL  where idv = '"+vol.getIdVol()+"';");
		this.executeModif("INSERT INTO logs(text) values (\"l'admin : "+id+" a supprimé le vol avec les caratéristiques : "+
				"("+vol.getIdVol()+","+vol.getIdAvion()+","+vol.getHeurDepart()+","+vol.getHeurArrivee()+","+vol.getDuree()+","+
				vol.getAeroportDepart()+","+vol.getAeroportArrivee()+","+vol.getDistance()+"\");");
		
	}

	public void addnewvol(Vol vol, int id) {
		this.executeModif("INSERT INTO VOL values "+"('"+vol.getIdVol()+"',"+vol.getIdAvion()+",'"+vol.getHeurDepart()+"','"+vol.getHeurArrivee()+"','"+vol.getDuree()+"','"+
				vol.getAeroportDepart()+"','"+vol.getAeroportArrivee()+"',"+vol.getDistance()+") ON DUPLICATE KEY UPDATE ida = "+vol.getIdAvion()+", HeureDepart = '"+vol.getHeurDepart()+"', heureArrivee = '"+vol.getHeurDepart()+"', duree = '"+
				vol.getDistance()+"',AeroportDepart = '"+vol.getAeroportDepart()+"',AeroportArrivee = '"+vol.getAeroportArrivee()+"',distance = "+vol.getDistance()+" ;");
		
		this.executeModif("INSERT INTO logs(text) values (\"l'admin : "+id+" a modifié le vol vers les caratéristiques : "+
				"("+vol.getIdVol()+","+vol.getIdAvion()+","+vol.getHeurDepart()+","+vol.getHeurArrivee()+","+vol.getDuree()+","+
				vol.getAeroportDepart()+","+vol.getAeroportArrivee()+","+vol.getDistance()+"\");");
		
	}

	public ArrayList<ArrayList<String>> getTablesContent() {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ResultSet rs = this.executeSql("SELECT * from GestionB;");
		
		try {
			ArrayList<String> temp = new ArrayList<String>();
			while (rs.next()) {
				temp = new ArrayList<String>();
				temp.add(rs.getString(3));
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				temp.add(rs.getString(7).substring(0,16));
				temp.add(rs.getString(6));
				
				temp.add(rs.getString(8));
				list.add(temp);
			}
		} catch (SQLException e) {
		
			return list;
		}
		return list;
	}

	public void validate(String string,int id) {
		this.executeModif("UPDATE billet set etat = 'V' where idb = "+string);
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a validé le billet dont l'idb = "+string+"\")");
		
	}

	public void unvalidate(String string, int id) {
		this.executeModif("UPDATE billet set etat = 'NV' where idb = "+string);
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a annulé la validiation du billet dont l'idb = "+string+"\")");
		
	}

	public ArrayList<ArrayList<String>> getUserList() {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ResultSet rs = this.executeSql("select id, login,admin from utilisateur");
		ArrayList<String> temp = new ArrayList<String>();
		try {
			while(rs.next()) {
				temp = new ArrayList<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				if (rs.getString(3).equals("1")){
					temp.add("ADMIN");
				}else {
					temp.add("");
				}
				
				res.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public void addNewUserByAdmin(int id, String string, String string2, int i) {
		this.executeModif("Update utilisateur set Login = '"+string2+"', admin = "+i+" where id = "+string+";");
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a modifié les détails de l'utilisateur de celui dont l'id  = "+string+"\")");
	}

	public void deleteUserByAdmin(int id, String text, String text2) {
		this.executeModif("DELETE FROM voyageur where id = "+text+";");
		this.executeModif("DELETE FROM utilisateur where id = "+text+";");
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a supprimé l'utilisateur :( "+text+","+text2+")"+"\")");
	}

	public ArrayList<ArrayList<String>> getVoyList() {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ResultSet rs = this.executeSql("select * from voyageur");
		ArrayList<String> temp = new ArrayList<String>();
		try {
			while(rs.next()) {
				temp = new ArrayList<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				
				
				
				res.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public void updateVoyageur(int id,String idxs, String text, String text2, String text3, String text4) {
		this.executeModif("Update voyageur set nom = '"+text+"', prenom = '"+text2+"',adresse = '"+text4+"' ,passport = '"+text3+"' where id = "+idxs);
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a modifié les informations du voyageur dont l'id  = "+idxs+"\")");
		
	}

	public void deleteVoyageur(int id,String idxs, String text, String text2, String text3, String text4) {
		this.executeModif("DELETE FROM  voyageur  where id = "+idxs);
		this.executeModif("DELETE FROM  utilisateur  where id = "+idxs);
		this.executeModif("INSERT INTO logs(text) values (\"l'admin :"+id+" a supprimé  le voyageur  = ("+idxs+" "+text+" "+text2+" "+text3+" "+text4+")\")");
		
		
	}

}
