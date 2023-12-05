import javax.swing.*;
import java.awt.*;
public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("Ma premiére fenetre");
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan =new JPanel();
        JPanel pan3 =new JPanel();
        JPanel pan2 =new JPanel();
        // pan.setBackground(Color.lightGray);
        JLabel login = new JLabel("Login");
        JLabel Pass = new JLabel("Password");
        JTextField LoginT = new JTextField(20);
        JPasswordField  passT = new JPasswordField(20);
        JButton ok = new JButton("Ok");
        JButton Annuler = new JButton("Annuler");
        JButton Fermer = new JButton("Fermer");
        //idha maahatynech pan nhotou direct ContentPane this.getContentPane().add(login);
        pan.setLayout(new GridLayout(2,2));
        pan3.setLayout(new GridLayout(2,1));
        pan.add(login);
        pan.add(LoginT);
        pan.add(Pass);
        pan.add(passT);
        pan2.add(ok);
        pan2.add(Annuler);
        pan2.add(Fermer);
        pan3.add(pan);
        pan3.add(pan2);
        pan3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setContentPane(pan3);
        this.setVisible(true);


    }
}
