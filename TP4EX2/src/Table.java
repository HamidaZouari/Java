import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {

    Table(){
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
        this.add(sp);
        this.setSize(300,400);
        this.setVisible(true);
    }

}  