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
public class PersonalInfos extends JFrame implements ActionListener,ItemListener
{
    String selectedSituation="Célibataire";
    JTextField nom=new JTextField(20);
    JTextField prenom=new JTextField(20);
    JTextField adresse=new JTextField(20);
    JTextField adresseMail=new JTextField(20);
    JTextField tel=new JTextField(20);
    Choice nationalite=new Choice();
    JCheckBox marie = new JCheckBox("Marié");
    JCheckBox divorce = new JCheckBox("Divorcé");
    JCheckBox celib = new JCheckBox("Célibataire");
    JCheckBox veuf = new JCheckBox("Veuf");
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
    }
    public void itemStateChanged(ItemEvent e) {
        Object source=e.getSource();
        if(e.getStateChange()==1) {
            if(source==marie) {

                divorce.setSelected(false);celib.setSelected(false);veuf.setSelected(false)
                ;
            }
            else if(source==divorce){

                marie.setSelected(false);celib.setSelected(false);veuf.setSelected(false);
            }
            else if(source==celib){

                marie.setSelected(false);divorce.setSelected(false);veuf.setSelected(false)
                ;
            }
            else if(source==veuf){

                marie.setSelected(false);celib.setSelected(false);divorce.setSelected(false
                );
            }
            selectedSituation=((JCheckBox)source).getText();
        }
    }
    public JPanel createPersonelInfoPanel() {
        JPanel SituationPanel=new JPanel();

        //checkbox2.setBounds(150,150, 50,50);
        SituationPanel.add(marie); SituationPanel.add(divorce);
        SituationPanel.add(celib); SituationPanel.add(veuf);
        celib.setSelected(true);
        marie.addItemListener(this);divorce.addItemListener(this);
        celib.addItemListener(this);veuf.addItemListener(this);
        JPanel PersonelInfoPanel =new JPanel();
        PersonelInfoPanel.setLayout(new BorderLayout());
        JPanel ContentPersonePanel =new JPanel();
        ContentPersonePanel.setLayout(new GridLayout(7,2));
        ContentPersonePanel.add(new JLabel("Nom"));
        ContentPersonePanel.add(nom);
        ContentPersonePanel.add(new JLabel("Prénom"));
        ContentPersonePanel.add(prenom);
        ContentPersonePanel.add(new JLabel("Nationalité"));
        nationalite.addItem("Tunisie");
        nationalite.addItem("Algerie");
        nationalite.addItem("Maroc");
        nationalite.addItem("France");
        nationalite.addItem("Belgique");
        ContentPersonePanel.add(nationalite);
        ContentPersonePanel.add(new JLabel("Adresse Mail"));
        ContentPersonePanel.add(adresseMail);
        ContentPersonePanel.add(new JLabel("Adresse"));
        ContentPersonePanel.add(adresse);
        ContentPersonePanel.add(new JLabel("Télephone"));
        ContentPersonePanel.add(tel);
        ContentPersonePanel.add(new JLabel("Situation :"));
        ContentPersonePanel.add(SituationPanel);
        JLabel InfosTitle=new JLabel("Coordonnées Personnelles");
        InfosTitle.setForeground(Color.RED);
        InfosTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        InfosTitle.setPreferredSize(new Dimension(500, 20));
        PersonelInfoPanel.add(InfosTitle ,BorderLayout.NORTH);
        PersonelInfoPanel.add(ContentPersonePanel,BorderLayout.CENTER);
        return PersonelInfoPanel;
    }
    public void resetData() {
        nom.setText("");
        prenom.setText("");
        adresse.setText("");
        adresseMail.setText("");
        tel.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into personalinfos values(?,?,?,?,?,?,?);");
            st.setString(1, nom.getText());
            st.setString(2, prenom.getText());
            st.setString(3, adresse.getText());
            st.setString(4, adresseMail.getText());
            st.setString(5, tel.getText());
            st.setString(6, selectedSituation);
            st.setString(7, nationalite.getSelectedItem());
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
                    st=Connections.getConnection().prepareStatement("select*from personalinfos");
            ResultSet res=st.executeQuery();
            res.next();
            ArrayList<String> list=new ArrayList<>();
            for(int i=1;i<=7;i++)
                list.add(res.getString(i));
            return list;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}