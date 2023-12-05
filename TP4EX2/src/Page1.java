import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class Page1 extends JFrame {
    Page1() {
        this.setSize(400,200);
        String data[][]={ {"1","PRODUIT1","100"},
                {"2","PRODUIT2","150"},
                {"3","PRODUIT3","54"},
                {"4","PRODUIT4","26"}};
        String column[]={"ID","LIBELLE","PRIX"};
        DefaultTableModel model = new DefaultTableModel(data,column);
        JTable jt=new JTable(data,column);
        jt.setModel(model);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        JPanel pan =new JPanel();
        pan.setLayout(new GridLayout(5,2));
        JLabel id = new JLabel("ID");
        JTextField idT = new JTextField(20);
        JLabel Libelle = new JLabel("LIbelle");
        JTextField LibelleT = new JTextField(20);
        JLabel Prix = new JLabel("Prix");
        JTextField PrixT = new JTextField(20);
        JLabel Etats = new JLabel("Etats");
        JCheckBox showX = new JCheckBox("Show");
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
        pan.add(showX);
        JPanel panB =new JPanel();
        JButton ok = new JButton("Ok");
        JButton Annuler = new JButton("Annuler");
        JButton Fermer = new JButton("Fermer");
        panB.add(ok);
        panB.add(Annuler);
        panB.add(Fermer);
        this.setLayout(new GridLayout(3,1));
        this.getContentPane().add(sp);
        this.getContentPane().add(pan);
        this.getContentPane().add(panB);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

}
