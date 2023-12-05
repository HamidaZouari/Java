import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produit p =new Produit(1,"PC",85.5);
        Produit p2 =new Produit(2,"Souris",100);
        Produit p3 =new Produit(3,"Cartable",5);
        Produit p4 =new Produit(4,"Stylo",55);

        Commandes c= new Commandes();
        ArrayList<Produit> l =new ArrayList<>();
        l.add(p);l.add(p2);
        c.ajouterLigne();
        c.afficher();

        c.ajouter("Commande1",p);c.ajouter("Commande1",p2);
c.afficher();

       new Fenetre();

    }
}