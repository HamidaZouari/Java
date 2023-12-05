package ex2;

import java.util.ArrayList;
import java.util.List;

public class Peuple {
    private List<Homme> pays;
    private int nbHommes;
     public Peuple(){
        pays= new ArrayList<>();
        nbHommes=0;
     }
     public void naissance(Homme H){
pays.add(H)     ;
   nbHommes++;
     }
    public void explorer(){
      for(Homme homme : pays)
        
    }
     
}
