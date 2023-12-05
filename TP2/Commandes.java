import java.util.Map;
import java.util.TreeMap;

public class Commandes {

    private Map<String,Commande> Cmde;

    /**
     * 
     */
    public Commandes(){
        Cmde= new TreeMap<>();
    }
    public void ajouterCommande (String code , Commande C){
        Cmde.put(code, C);
    }
    public void retirerCommande (String code){
        Cmde.remove(code);
    }
    public void ajouterProduit(String code , Produit p ){
        Cmde.get(code).ajouterProduit(p);
    }
    public void retirerProduit(String code , Produit p ){
        if(Cmde.get(code).estPresent(p)==true)
        Cmde.get(code).ajouterProduit(p);
       

    }
    public float calculerRecette(){
        float recette=0;
        for(Commande c :Cmde.values()){
            recette=recette+c.getPrixTotal();
        }
return recette;
    }
    public void Afficher(){
        for(Commande c :Cmde.values()){
            System.out.println(c.toString());

    }
}
}
