public class Test extends Exception {

   public static void main(String[] args){
    try {
        Forme rec =new Rectangle(2, 1);
    rec.contenantCarre(20);
    } catch (Exception e) {
System.out.println(e.getMessage());    }
    try {
        Forme cer = new Cercle(1);
        cer.contenantCarre(20);

    } catch (Exception e) {
        System.out.println(e.getMessage());    }
    }
   }
    

