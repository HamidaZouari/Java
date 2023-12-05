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
public class Competence extends JFrame {
    JTextArea desc1=new JTextArea();
    JTextArea desc2=new JTextArea();
    JTextArea desc3=new JTextArea();
    public JPanel createCompetencePanel() {
        JPanel CompPanel =new JPanel();
        CompPanel.setLayout(new BorderLayout());
        JPanel ContentCompPanel =new JPanel();
        ContentCompPanel.setLayout(new GridLayout(6,2));
        JLabel Comp1Label=new JLabel("Competence 1:");
        Comp1Label.setForeground(Color.ORANGE);
        Comp1Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentCompPanel.add(Comp1Label);
        ContentCompPanel.add(new JLabel(""));
        ContentCompPanel.add(new JLabel("Description :"));
        ContentCompPanel.add(desc1);
        JLabel Comp2Label=new JLabel("Competence 2:");
        Comp2Label.setForeground(Color.ORANGE);
        Comp2Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentCompPanel.add(Comp2Label);
        ContentCompPanel.add(new JLabel(""));
        ContentCompPanel.add(new JLabel("Description :"));
        ContentCompPanel.add(desc2);
        JLabel Comp3Label=new JLabel("Competence 3:");
        Comp3Label.setForeground(Color.ORANGE);
        Comp3Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentCompPanel.add(Comp3Label);
        ContentCompPanel.add(new JLabel(""));
        ContentCompPanel.add(new JLabel("Description :"));
        ContentCompPanel.add(desc3);
        JLabel StageTitle=new JLabel("Projets");
        StageTitle.setForeground(Color.RED);
        StageTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        StageTitle.setPreferredSize(new Dimension(500, 20));
        CompPanel.add(StageTitle ,BorderLayout.NORTH);
        CompPanel.add(ContentCompPanel,BorderLayout.CENTER);
        return CompPanel;
    }
    public void resetData() {
        desc1.setText("");
        desc2.setText("");
        desc3.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into competence values(?,?,?);");
            st.setString(1, desc1.getText());
            st.setString(2, desc2.getText());
            st.setString(3, desc3.getText());
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
                    st=Connections.getConnection().prepareStatement("select*from competence");
            ResultSet res=st.executeQuery();
            res.next();
            ArrayList<String> list=new ArrayList<>();
            for(int i=1;i<=3;i++)
                list.add(res.getString(i));
            return list;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}