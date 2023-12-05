import java.util.LinkedList;

public class Commande {
    
    private LinkedList<Produit> ListeProduit;
    private float prixTotal;

    public Commande() {
        ListeProduit = new LinkedList<>();
        
        prixTotal=0;
    }
    public void ajouterProduit(Produit p){
        ListeProduit.add(p);
        prixTotal=prixTotal+p.getPrixProd();
    }
    public void retireProduit(int num){
        for(Produit p : ListeProduit){
            if(p.getNumProd()==num){
            prixTotal=prixTotal-p.getPrixProd();
            ListeProduit.remove(p);}
            break;
        }
    }
    public int nombreProduit(){
        int s=0;
        for(Produit p : ListeProduit){
            s=s+1;
        }
        return s;
    }
    @Override
    public String toString() {
        
        return "Produit"+ListeProduit.toString()+"prixTotal=" + prixTotal +"\n" ;
    }
    public Boolean estPresent (Produit produit){
        for(Produit p : ListeProduit){
            if(p.getNumProd()==produit.getNumProd()){
                return true;
                
        }}
        return false;

    
}
    public LinkedList<Produit> getListeProduit() {
        return ListeProduit;
    }
    public float getPrixTotal() {
        return prixTotal;
    }}

   


