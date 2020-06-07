package flights;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;
import user.*;
public class Billet{
// importation pour utiliser Date et Instant.now()


// declaration des variables de la classe:
  protected int idBillet;
  protected Date dateReservation;
  protected Date dateVoyage;
  protected Date dateArrivee;
  protected boolean etat;

  protected Vol vol ;
  protected Voyageur voyageur ;
  protected SiegeReserve siegeReserve;
// le constructeur:
public Billet(){

  this.dateReservation = new Date();
}

// Surcharge du constructeur:
public Billet(int idBillet,Date dateReservation,Date dateVoyage,Date dateArrivee,boolean etat){
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

public Date getDateReservation(){
  return this.dateReservation;
}

public Date getDateVoyage(){
  return this.dateVoyage;
}

public Date getDateArrivee(){
  return this.dateArrivee;
}

public boolean getEtat(){
  return this.etat;
}

//Setters:
public void setetIdBillet(int idBillet){
  this.idBillet = idBillet;
}

public void setetDateReservation(Date dateReservation){
  this.dateReservation = dateReservation;
}

public void setetDateVoyage(Date dateVoyage){
  this.dateVoyage = dateVoyage;
}

public void setetDateArrivee(Date dateArrivee){
  this.dateArrivee = dateArrivee;
}

public void setetEtat(boolean etat){
  this.etat = etat;
}






}
