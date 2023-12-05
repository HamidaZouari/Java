import java.util.ArrayList;
import java.util.Hashtable;

public class Commandes {

    private Hashtable<String, ArrayList<Produit>> HM;

    static int numC =1;
    String nom =null;
    public Commandes(){

        HM=new Hashtable<String,ArrayList<Produit>>();

    }
    public void ajouterLigne(){
        HM.put("Commande"+numC,new ArrayList<Produit>());
        nom="Commande"+numC;
        //System.out.println(nom);
        numC++;
    }
    public void ajouter(String x,Produit p){
        for(String l : HM.keySet()){
            if(l.equals(x)){
                HM.get(l).add(p);
            }
        }
    }
   /** public String returnCommande(int num){
        String nom =null;
        if(num==)
            return
    }**/
    public void afficher(){
        for (String l : HM.keySet()){
            System.out.println(l);
            for (ArrayList<Produit> p : HM.values()){
                System.out.println(p.toString());
            }
        }
    }

}
