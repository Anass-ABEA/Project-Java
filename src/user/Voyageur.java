package user;
public class Voyageur extends Utilisateur{

// declaration des variables de la classe:
protected String passeport;
protected String nom;
protected String prenom;
protected String adresse;

// le constructeur:
  public Voyageur(String pLogin, String  pPWD ,String passeport ,String nom ,String prenom ,String adresse){
    super(pLogin,pPWD);
    this.passeport = passeport;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
  }

//Getters:
public String getPasseport(){
  return this.passeport;
}

public String getNom(){
  return this.nom;
}

public String getPrenom(){
  return this.prenom;
}

public String getAdresse(){
  return this.adresse;
}

//Setters:
public void setPasseport(String passeport){
  this.passeport = passeport;
}

public void setNom(String nom){
  this.nom = nom;
}

public void setPrenom(String prenom){
  this.prenom = prenom;
}

public void setAdresse(String adresse){
  this.adresse = adresse;
}

}
