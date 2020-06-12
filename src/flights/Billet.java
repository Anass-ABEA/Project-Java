package flights;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;
import user.*;
public class Billet{
// importation pour utiliser Date et Instant.now()


// declaration des variables de la classe:
  protected int idBillet;
  protected String dateReservation;
  protected String dateVoyage;
  protected String dateArrivee;
  protected boolean etat;

  protected Vol vol ;
  protected Voyageur voyageur ;
  protected SiegeReserve siegeReserve;
// le constructeur:
public Billet(String dateVoyage,String dateArrivee){
		this.dateVoyage = dateVoyage;
		this.dateArrivee = dateArrivee;
  
}

// Surcharge du constructeur:
public Billet(int idBillet,String dateReservation,String dateVoyage,String dateArrivee,boolean etat){
  this.idBillet = idBillet;
  this.dateReservation = dateReservation;
  this.dateVoyage = dateVoyage;
  this.dateArrivee = dateArrivee;
  this.etat = etat;
}



//Getters:
public int getIdBillet(){
  return this.idBillet;
}

public String getDateReservation(){
  return this.dateReservation;
}

public String getDateVoyage(){
  return this.dateVoyage;
}

public String getDateArrivee(){
  return this.dateArrivee;
}

public boolean getEtat(){
  return this.etat;
}

//Setters:
public void setetIdBillet(int idBillet){
  this.idBillet = idBillet;
}

public void setetDateReservation(String dateReservation){
  this.dateReservation = dateReservation;
}

public void setetDateVoyage(String dateVoyage){
  this.dateVoyage = dateVoyage;
}

public void setetDateArrivee(String dateArrivee){
  this.dateArrivee = dateArrivee;
}

public void setetEtat(boolean etat){
  this.etat = etat;
}






}
