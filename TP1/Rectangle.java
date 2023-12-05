public class Rectangle extends Forme{
    private float Longueur;
    private float Largeur;

    public Rectangle(float longueur, float largeur) throws MathException{
if(Longueur<=0) throw new MathException("Longuer Invalide");
if(Largeur<=0) throw new MathException("Largeur Invalide");

        Longueur = longueur;
        Largeur = largeur;
    }


    @Override
    public float perimetre() {
        
        return (Longueur+Largeur)*2;
    }

    @Override
    public float surface() {
        return Longueur*Largeur;
    }
    
}
