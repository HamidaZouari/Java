public class ExecuteAbonnement {
    public static void main(String [] args)
{


        Produit p1= new Produit("Produit numero 1", "P1", 01, 1000);
        Produit p2= new Produit("Produit numero 2", "P2", 2, 320);
        Produit p3= new Produit("Produit numero 3", "P3", 3, 70);
        Produit p4= new Produit("Produit numero 4", "P4", 4, 6000);
        Produit p5= new Produit("Produit numero 5", "P5", 5, 70);
        Produit p6= new Produit("Produit numero 6", "P6", 6, 30);

        Commande c1=new Commande();
        Commande c2=new Commande();

        c1.ajouterProduit(p1);
        c1.ajouterProduit(p6);
        c1.ajouterProduit(p4);

        c2.ajouterProduit(p2);
        c2.ajouterProduit(p5);
        c2.ajouterProduit(p3);

        Commandes comd= new Commandes();
        comd.ajouterCommande("Commande 2", c2);
        comd.ajouterCommande("Commande 1", c1);


        comd.Afficher();


        c1.retireProduit(p1.getNumProd());

        comd.retirerProduit("Commande 2", p2);

        System.out.println("Aprés modification");
        
        comd.Afficher();
}
}
