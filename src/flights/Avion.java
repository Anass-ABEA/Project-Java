package flights;
public class Avion{

// declaration des variables de la classe:
  protected int idAvion;
  protected String compagnie;
  protected int nb_place;

// le constructeur:
public Avion(int idAvion,String compagnie,int nb_place){
  this.idAvion = idAvion;
  this.compagnie = compagnie;
  this.nb_place = nb_place;
}
public Avion(){
	  this.idAvion = 0;
	  this.compagnie = "";
	  this.nb_place = 0;
}

public Avion(String text, String text2, String text3) {
	this.idAvion = Integer.parseInt(text);
	  this.compagnie = text2;
	  this.nb_place = Integer.parseInt(text3);
}
//Getters:
public int getIdAvion(){
    return this.idAvion;
}

public String getCompagnie(){
    return this.compagnie;
}

public int getNb_place(){
    return this.nb_place;
}

//Setters:

public void setIdAvion(int idAvion){
    this.idAvion = idAvion;
}

public void setCompagnie(String compagnie){
    this.compagnie = compagnie;
}

public void setNb_place(int nb_place){
    this.nb_place = nb_place;
}




}
