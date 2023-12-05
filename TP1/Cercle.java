public class Cercle extends Forme{
public Cercle(float rayon) throws MathException {
    if(Rayon <=0)throw new MathException("Rayon Invalide");
        Rayon = rayon;
    }

private float Rayon;
    @Override
    public float perimetre() {
        // TODO Auto-generated method stub
        return 2*3.14f*Rayon;
    }

    @Override
    public float surface() {
        // TODO Auto-generated method stub
        return Rayon*Rayon*3.14f;
    }
    
}
