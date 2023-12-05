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
public class Stages extends JFrame implements ActionListener {
    JTextField Periode1=new JTextField(20);
    JTextField Periode2=new JTextField(20);
    JTextField Societe1=new JTextField(20);
    JTextField Societe2=new JTextField(20);
    JTextArea desc1=new JTextArea();
    JTextArea desc2=new JTextArea();
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
    }
    public JPanel createStagePanel() {
        JPanel StagesPanel =new JPanel();
        StagesPanel.setLayout(new BorderLayout());
        JPanel ContentStagePanel =new JPanel();
        ContentStagePanel.setLayout(new GridLayout(8,2));
        JLabel stage1Label=new JLabel("Stage1:");
        stage1Label.setForeground(Color.ORANGE);
        stage1Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentStagePanel.add(stage1Label);
        ContentStagePanel.add(new JLabel(""));
        ContentStagePanel.add(new JLabel("Période :"));
        ContentStagePanel.add(Periode1);
        ContentStagePanel.add(new JLabel("Sociéte :"));
        ContentStagePanel.add(Societe1);
        ContentStagePanel.add(new JLabel("Description du stage :"));
        ContentStagePanel.add(desc1);
        JLabel stage2Label=new JLabel("Stage2");
        stage2Label.setForeground(Color.ORANGE);
        stage2Label.setFont(new Font("Verdana", Font.BOLD, 12));
        ContentStagePanel.add(stage2Label);
        ContentStagePanel.add(new JLabel(""));
        ContentStagePanel.add(new JLabel("Période :"));
        ContentStagePanel.add(Periode2);
        ContentStagePanel.add(new JLabel("Sociéte :"));
        ContentStagePanel.add(Societe2);
        ContentStagePanel.add(new JLabel("Description du stage :"));
        ContentStagePanel.add(desc2);
        JLabel StageTitle=new JLabel("Stages");
        StageTitle.setForeground(Color.RED);
        StageTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        StageTitle.setPreferredSize(new Dimension(500, 20));
        StagesPanel.add(StageTitle ,BorderLayout.NORTH);
        StagesPanel.add(ContentStagePanel,BorderLayout.CENTER);
        return StagesPanel;
    }
    public void resetData() {
        Periode1.setText("");
        Societe1.setText("");
        desc1.setText("");
        Periode2.setText("");
        Societe2.setText("");
        desc2.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into stages values(?,?,?,?,?,?);");
            st.setString(1, Periode1.getText());
            st.setString(2, Societe1.getText());
            st.setString(3, desc1.getText());
            st.setString(4, Periode2.getText());
            st.setString(5, Societe2.getText());
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
                    st=Connections.getConnection().prepareStatement("select*from stages");
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
