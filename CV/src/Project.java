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
public class Project extends JFrame implements ActionListener {
    Choice Type1=new Choice();
    Choice Type2=new Choice();
    JTextField title1=new JTextField(20);
    JTextField title2=new JTextField(20);
    JTextArea desc1=new JTextArea();
    JTextArea desc2=new JTextArea();
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
    }
    public JPanel createProjectPanel() {
        JPanel ProjectPanel =new JPanel();
        ProjectPanel.setLayout(new BorderLayout());
        JPanel ContentProjectPanel =new JPanel();
        ContentProjectPanel.setLayout(new GridLayout(8,2));
        JLabel Project1Label=new JLabel("Projet 1:");
        Project1Label.setForeground(Color.ORANGE);
        Project1Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentProjectPanel.add(Project1Label);
        ContentProjectPanel.add(new JLabel(""));
        Type1.addItem("jeux vidéos");
        Type1.addItem("intelligence artificielle");
        Type1.addItem("machine learning");
        Type1.addItem("application web");
        Type1.addItem("Application mobile");
        ContentProjectPanel.add(new JLabel("Type :"));
        ContentProjectPanel.add(Type1);
        ContentProjectPanel.add(new JLabel("Titre :"));
        ContentProjectPanel.add(title1);
        ContentProjectPanel.add(new JLabel("Description du projet :"));
        ContentProjectPanel.add(desc1);
        JLabel stage2Label=new JLabel("Projet 2 :");
        stage2Label.setForeground(Color.ORANGE);
        stage2Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentProjectPanel.add(stage2Label);
        ContentProjectPanel.add(new JLabel(""));
        Type2.addItem("jeux vidéos");
        Type2.addItem("intelligence artificielle");
        Type2.addItem("machine learning");
        Type2.addItem("application web");
        Type2.addItem("Application mobile");
        ContentProjectPanel.add(new JLabel("Type :"));
        ContentProjectPanel.add(Type2);
        ContentProjectPanel.add(new JLabel("Titre :"));
        ContentProjectPanel.add(title2);
        ContentProjectPanel.add(new JLabel("Description du projet :"));
        ContentProjectPanel.add(desc2);
        JLabel StageTitle=new JLabel("Projets");
        StageTitle.setForeground(Color.RED);
        StageTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        StageTitle.setPreferredSize(new Dimension(500, 20));
        ProjectPanel.add(StageTitle ,BorderLayout.NORTH);
        ProjectPanel.add(ContentProjectPanel,BorderLayout.CENTER);
        return ProjectPanel;
    }
    public void resetData() {
        title1.setText("");
        desc1.setText("");
        title2.setText("");
        desc2.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into projects values(?,?,?,?,?,?);");
            st.setString(1, Type1.getSelectedItem());
            st.setString(2, title1.getText());
            st.setString(3, desc1.getText());
            st.setString(4, Type2.getSelectedItem());
            st.setString(5, title2.getText());
            st.setString(6, desc2.getText());
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
                    st=Connections.getConnection().prepareStatement("select*from projects");
            ResultSet res=st.executeQuery();
            res.next();
            ArrayList<String> list=new ArrayList<>();
            for(int i=1;i<=6;i++)
                list.add(res.getString(i));
            return list;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
