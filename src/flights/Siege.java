package flights;
public class Siege{

// declaration des variables de la classe:
protected int idSiege;
protected String type;
protected String place;

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}

// d'apres la présentation UML:
protected Avion avion = new Avion();

// le constructeur:
public Siege(int idSiege,String type){
  this.idSiege = idSiege;
  this.type = type;
}

public Siege(String type,String place){
	  this.type = type;
	  this.place = place;
}

//Getters:
public int getIdSiege(){
    return this.idSiege;
}

public String getType(){
    return this.type;
}

//Setters:
public void setIdSiege(int idSiege){
    this.idSiege = idSiege;
}

public void setType(String type){
    this.type = type;
}




}
