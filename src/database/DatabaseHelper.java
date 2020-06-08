package database;
import java.sql.*;
import java.util.ArrayList;

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
			res = st.executeQuery(sql); // EXECUTE SQL QUERY
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
			st.executeUpdate(sql); // EXECUTE SQL QUERY
			
		} catch (Exception e) {
			System.out.println("SQL ERROR for the query : "+sql);
			e.printStackTrace();
		}
		 
	}
	public void inserSql(String sql) {
		this.refresh_statment();
		try {
			st.executeQuery(sql);
		} catch (SQLException e) {
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
}
