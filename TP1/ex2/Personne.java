package ex2;

public class Personne implements Homme{
private String nom,prenom;

    public Personne(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
}
    
    public void identite() {
      System.out.println("Nom"+nom+"Prenom"+prenom);        
    }
    
}
