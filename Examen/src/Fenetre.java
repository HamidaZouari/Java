import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    Fenetre(){
        this.setTitle("Gestions des produits");
        this.setSize(530,150);
        JPanel mainPan =new JPanel();
        JPanel Form = new JPanel();
        Form.setLayout(new GridLayout(4,2));
        Form.add(new JLabel("numero commande"));
        JTextField num = new JTextField(10);
        JTextField id = new JTextField(10);
        JTextField libelle = new JTextField(10);
        JTextField prix = new JTextField(10);
        Form.add(num);
        Form.add(new JLabel("id produit"));
        Form.add(id);
        Form.add(new JLabel("Libelle produit"));
        Form.add(libelle);
        Form.add(new JLabel("Prix produit"));
        Form.add(prix);

        JPanel Buttons = new JPanel();
        Buttons.setLayout(new GridLayout(3,1));
        JButton creer = new JButton("Creer Commande");
        JButton ajouterP = new JButton("Ajouter produit");
        JButton annuler = new JButton("Annuler");
        Buttons.add(creer); Buttons.add(ajouterP); Buttons.add(annuler);

        creer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Commandes Com=new Commandes();
                num.setText(String.valueOf(Commandes.numC));
            }
        });
        ajouterP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num.setText("");id.setText("");libelle.setText("");prix.setText("");

            }
        });
        mainPan.setLayout(new GridLayout(1,2));
        mainPan.add(Form);
        mainPan.add(Buttons);

        this.setContentPane(mainPan);
        this.setVisible(true);
    }
}
