package ex2;

public class Client extends Personne implements Homme{

    private int numero;
    public Client(String nom, String prenom,int numero) {
        super(nom, prenom);
        this.numero=numero;
    }

    @Override
    public void identite() {
super.identite();
System.out.println("Numero"+numero);
    }
    
}
