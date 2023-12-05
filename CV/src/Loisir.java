import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
public class Loisir extends JFrame {
    JTextArea desc1=new JTextArea();
    JTextArea desc2=new JTextArea();
    public JPanel createLoisirPanel() {
        JPanel LoisirPanel =new JPanel();
        LoisirPanel.setLayout(new BorderLayout());
        JPanel ContentLoisirPanel =new JPanel();
        ContentLoisirPanel.setLayout(new GridLayout(4,2));
        JLabel Loisir1Label=new JLabel("Loisir 1:");
        Loisir1Label.setForeground(Color.ORANGE);
        Loisir1Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentLoisirPanel.add(Loisir1Label);
        ContentLoisirPanel.add(new JLabel(""));
        ContentLoisirPanel.add(new JLabel("Description :"));
        ContentLoisirPanel.add(desc1);
        JLabel Loisir2Label=new JLabel("Loisir 2:");
        Loisir2Label.setForeground(Color.ORANGE);
        Loisir2Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentLoisirPanel.add(Loisir2Label);
        ContentLoisirPanel.add(new JLabel(""));
        ContentLoisirPanel.add(new JLabel("Description :"));
        ContentLoisirPanel.add(desc2);
        JLabel StageTitle=new JLabel("Loisir");
        StageTitle.setForeground(Color.RED);
        StageTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        StageTitle.setPreferredSize(new Dimension(500, 20));
        LoisirPanel.add(StageTitle ,BorderLayout.NORTH);
        LoisirPanel.add(ContentLoisirPanel,BorderLayout.CENTER);
        return LoisirPanel;
    }
    public void resetData() {
        desc1.setText("");
        desc2.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into loisir values(?,?);");
            st.setString(1, desc1.getText());
            st.setString(2, desc2.getText());
            int res=st.executeUpdate();
            if(res!=0) {
                System.out.println("ligne insérée");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList loadData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("select*from loisir");
            ResultSet res=st.executeQuery();
            res.next();
            ArrayList<String> list=new ArrayList<>();
            for(int i=1;i<=2;i++)
                list.add(res.getString(i));
            return list;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
