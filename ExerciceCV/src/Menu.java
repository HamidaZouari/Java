import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu
{
    JMenu menu, smenu;
    JMenuItem e1, e2, e3, e4, e5, e6;

    Menu()
    {
        // Créer le frame
        JFrame frame = new JFrame("Menu");
        // Créer la barre de menu
        JMenuBar menubar = new JMenuBar();
        // Créer le menu
        menu = new JMenu("Saisie");
        // Créer le sous menu


        e1 = new JMenuItem("CV");


        menu.add(e1);
       e1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new CV();
               frame.setVisible(false);

           }
       });


        menubar.add(menu);
        frame.setJMenuBar(menubar);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        new Menu();
    }
}