import java.util.HashMap;

public class Commandes {
    HashMap<String,Commande> cmde;
    public Commandes(){
        cmde=new HashMap<>();
    }
    public void ajouterCommande(String code,Commande c){
        cmde.put(code,c);
    }
    public void retirerCommande(String code){
        cmde.remove(code);
    }
    public void ajouterProduit(String code,Produit p){
        cmde.get(code).ajouterProduit(p);

    }
    public void retirerProduit(String code,Produit p){
        cmde.get(code).retireProduit(p.getNumProd());

    }
}
