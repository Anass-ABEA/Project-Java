package flights;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;
public class Vol{

// importation pour utiliser Date et Instant.now()


// declaration des variables de la classe:
protected int idVol;
protected int idAvion;
protected Date heurDepart;
protected Date heurArrivee;
protected int duree;
protected String aeroportDepart;
protected String aeroportArrivee;

// le constructeur
public Vol(int idVol,int idAvion,Date heurDepart,Date heurArrivee,int duree,String aeroportDepart,String aeroportArrivee){
  this.idVol = idVol;
  this.idAvion = idAvion;
  this.heurDepart = heurDepart;
  this.heurArrivee = heurArrivee;
  this.duree = duree;
  this.aeroportDepart = aeroportDepart;
  this.aeroportArrivee = aeroportArrivee;
}

//Getters:
public int getIdVol(){
    return this.idVol;
}

public int getIdAvion(){
    return this.idAvion;
}

public Date getHeurDepart(){
    return this.heurDepart;
}

public Date getHeurArrivee(){
    return this.heurArrivee;
}

public int getDuree(){
    return this.duree;
}

public String getAeroportDepart(){
    return this.aeroportDepart;
}

public String getAeroportArrivee(){
    return this.aeroportArrivee;
}

//Setters:
public void setIdVol(int idVol){
    this.idVol = idVol;
}

public void setIdAvion(int idAvion){
    this.idAvion = idAvion;
}

public void setHeurDepart(Date heurDepart){
    this.heurDepart = heurDepart;
}

public void setHeurArrivee(Date heurArrivee){
    this.heurArrivee = heurArrivee;
}

public void setDuree(int duree){
    this.duree = duree;
}

public void setAeroportDepart(String aeroportDepart){
    this.aeroportDepart = aeroportDepart;
}

public void setAeroportArrivee(String aeroportArrivee){
    this.aeroportArrivee = aeroportArrivee;
}


}
