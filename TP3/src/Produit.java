public class Produit {
    int id;
    String Libelle;
     double prix;

    public  Produit(int id,String libelle , double prix){
        this.id=id;
        this.Libelle=libelle;
        this.prix=prix;
    }
    public  Produit(){
        Libelle=" ";
        prix=0;
    }
    public  Produit(String libelle , double prix){
        this.Libelle=libelle;
        this.prix=prix;
    }
    public int getId(){
        return id;
    }
    public String getLibelle(){
        return Libelle;
    }
    public double getprix(){
        return prix;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setlibelle(String Libelle){
        this.Libelle=Libelle;
    }
    public void setPrix(double prix){
        this.prix=prix;
    }
    public String toString(){
        return "Le nom du produit: "+Libelle+"son id"+id+"/t Prix"+prix;
    }






}
