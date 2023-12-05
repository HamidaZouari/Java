package ex2;

public class Test {
    
    public static void main (String[]args){
        Personne P = new Personne("aa", "bb");
        Client C  = new Client("nomClient", "prenomClient", 111);
        Peuple PL = new Peuple();
        PL.naissance(P);
        PL.naissance(C);
        PL.explorer();
        
    }
}
