import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
public Form(){
    JPanel pan =new JPanel();
    pan.setLayout(new GridLayout(5,2));
    JLabel id = new JLabel("ID");
    JTextField idT = new JTextField(20);
    JLabel Libelle = new JLabel("LIbelle");
    JTextField LibelleT = new JTextField(20);
    JLabel Prix = new JLabel("Pix");
    JTextField PrixT = new JTextField(20);
    JLabel Etats = new JLabel("Etats");
    String[] C={
            "Disponible","Non disponible"
    };
    JComboBox<String>EtatsT = new JComboBox<String>(C);
    pan.add(id) ;
    pan.add(idT) ;
    pan.add(Libelle) ;
    pan.add(LibelleT) ;
    pan.add(Prix) ;
    pan.add(PrixT) ;
    pan.add(Etats);
    pan.add(EtatsT);
    this.setContentPane(pan);
    this.setVisible(true);
}
}
