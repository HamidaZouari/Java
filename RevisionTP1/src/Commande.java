import java.util.LinkedList;

public class Commande {
    LinkedList<Produit> l;
    private float total;
    public Commande(){
        total=0;
        l=new LinkedList<>();
    }
    public void ajouterProduit(Produit p){
        l.add(p);
    }
    public void retireProduit(int num){
        for (Produit p :l){
            if(p.getNumProd()==num)
                l.remove(p);
        }
    }
    public int nombreProd(){
        return l.size();
    }
    public boolean estPresent(Produit p1){
       if(l.contains(p1))
           return true;
       else
           return false;
    }
    @Override
    public String toString() {
        String ch="";
for (Produit p :l) {
    ch += p.toString();
}
return ch;
    }

}
