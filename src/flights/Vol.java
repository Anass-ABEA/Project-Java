package flights;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;
public class Vol{

// importation pour utiliser Date et Instant.now()


// declaration des variables de la classe:
protected String idVol;
protected int idAvion;
protected String heurDepart;
protected String heurArrivee;
protected String duree;
protected String aeroportDepart;
protected String aeroportArrivee;
protected int distance;

// le constructeur
public Vol(String idVol,int idAvion,String heurDepart,String heurArrivee,String duree,String aeroportDepart,String aeroportArrivee,int distance){
  this.idVol = idVol;
  this.idAvion = idAvion;
  this.heurDepart = heurDepart;
  this.heurArrivee = heurArrivee;
  this.duree = duree;
  this.aeroportDepart = aeroportDepart;
  this.aeroportArrivee = aeroportArrivee;
  this.distance = distance;
}





public Vol(String text, String text2, String text3, String text4, String text5, String text6, String text7,
		String text8) {
	  this.idVol = text;
	  this.idAvion = Integer.parseInt(text2);
	  this.heurDepart = text3;
	  this.heurArrivee = text4;
	  this.duree = text5;
	  this.aeroportDepart = text6;
	  this.aeroportArrivee = text7;
	  this.distance = Integer.parseInt(text8);
}





//Getters:
public String getIdVol(){
    return this.idVol;
}

public int getDistance() {
	return distance;
}

public int getIdAvion(){
    return this.idAvion;
}

public String getHeurDepart(){
    return this.heurDepart;
}

public String getHeurArrivee(){
    return this.heurArrivee;
}

public String getDuree(){
    return this.duree;
}

public String getAeroportDepart(){
    return this.aeroportDepart;
}

public String getAeroportArrivee(){
    return this.aeroportArrivee;
}

//Setters:
public void setDistance(int distance) {
	this.distance = distance;
}

public void setIdVol(String idVol){
    this.idVol = idVol;
}

public void setIdAvion(int idAvion){
    this.idAvion = idAvion;
}

public void setHeurDepart(String heurDepart){
    this.heurDepart = heurDepart;
}

public void setHeurArrivee(String heurArrivee){
    this.heurArrivee = heurArrivee;
}

public void setDuree(String duree){
    this.duree = duree;
}

public void setAeroportDepart(String aeroportDepart){
    this.aeroportDepart = aeroportDepart;
}

public void setAeroportArrivee(String aeroportArrivee){
    this.aeroportArrivee = aeroportArrivee;
}


}
