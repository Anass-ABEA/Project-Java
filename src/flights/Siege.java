package flights;
public class Siege{

// declaration des variables de la classe:
protected int idSiege;
protected String type;

// d'apres la présentation UML:
protected Avion avion = new Avion();

// le constructeur:
public Siege(int idSiege,String type){
  this.idSiege = idSiege;
  this.type = type;
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
