public class Main {
    public static void main(String[] args) {

        Produit p1 = new Produit("aa","bb",12,12.5F);
        Commande c = new Commande();
        c.ajouterProduit(p1);
        c.retireProduit(12);
        System.out.println(c.toString());
        System.out.println("Taille:"+c.nombreProd());
        System.out.println(c.estPresent(p1));

    }
}