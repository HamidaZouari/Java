import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;

public class CV extends JFrame implements ActionListener, ItemListener {
    JLabel title, nom, prenom, age, gender, nationalite, loisir, adress;
    JTextField txtNom, txtprenom, txtage;
    JTextArea txtAddress, tout;
    Checkbox checkMale, checkFemale, sport, music, dance;
    CheckboxGroup genderCheckbox;
    Choice nationchoices;
    JButton ok, Annuler;
    String result="";
    JTable table=new JTable();
    String[]Titre={"Lieu","Periode","Tache"};
    String[][]donnee={};
    DefaultTableModel model=new DefaultTableModel(donnee,Titre);
    JScrollPane tpan=new JScrollPane(table);

    JTable table2=new JTable();
    String[]Titre2={"Competence"};
    String[][]donnee2={};
    DefaultTableModel model2=new DefaultTableModel(donnee2,Titre2);
    JScrollPane tpan2=new JScrollPane(table2);

    public CV() {


        setTitle("Ex4");
        setSize(1050, 700);
        setLayout(null);
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();

        p1.setLayout(null);
        p2.setLayout(null);

        JTabbedPane onglets=new JTabbedPane();
        onglets.setBounds(0, 0, 1050, 700);
        this.add(onglets);

        Font titleFont = new Font("arial", Font.BOLD, 25);
        Font labelFont = new Font("arial", Font.PLAIN, 18);
        Font textFont = new Font("arial", Font.PLAIN, 15);

        title = new JLabel("Formulaire");
        title.setBounds(525, 40, 300, 50);
        title.setFont(titleFont);
        title.setForeground(Color.BLUE);
        p1.add(title);

        nom = new JLabel("Nom");
        nom.setBounds(250, 100, 150, 30);
        nom.setFont(labelFont);
        nom.setForeground(Color.BLACK);
        p1.add(nom);

        txtNom = new JTextField();
        txtNom.setBounds(400, 100, 400, 30);
        txtNom.setFont(textFont);
        p1.add(txtNom);

        prenom = new JLabel("Prenom");
        prenom.setBounds(250, 150, 150, 30);
        prenom.setFont(labelFont);
        prenom.setForeground(Color.BLACK);
        p1.add(prenom);

        txtprenom = new JTextField();
        txtprenom.setBounds(400, 150, 400, 30);
        txtprenom.setFont(textFont);
        p1.add(txtprenom);

        age = new JLabel("Age");
        age.setBounds(250, 200, 150, 30);
        age.setFont(labelFont);
        age.setForeground(Color.BLACK);
        p1.add(age);

        txtage = new JTextField();
        txtage.setBounds(400, 200, 400, 30);
        txtage.setFont(textFont);
        p1.add(txtage);

        gender = new JLabel("Gender");
        gender.setBounds(250, 250, 150, 30);
        gender.setFont(labelFont);
        gender.setForeground(Color.BLACK);
        p1.add(gender);

        genderCheckbox = new CheckboxGroup();

        checkMale = new Checkbox("Male", genderCheckbox, true);
        checkMale.setBounds(400, 250, 100, 30);
        checkMale.setFont(labelFont);
        checkMale.setForeground(Color.BLACK);
        p1.add(checkMale);

        checkFemale = new Checkbox("Female", genderCheckbox, false);
        checkFemale.setBounds(500, 250, 100, 30);
        checkFemale.setFont(labelFont);
        checkFemale.setForeground(Color.BLACK);
        p1.add(checkFemale);

        nationalite = new JLabel("Nationalite");
        nationalite.setBounds(250, 300, 150, 30);
        nationalite.setFont(labelFont);
        nationalite.setForeground(Color.BLACK);
        p1.add(nationalite);

        nationchoices = new Choice();
        nationchoices.setFont(labelFont);
        nationchoices.setBounds(400, 300, 400, 50);
        nationchoices.add("Tunisien");
        nationchoices.add("Algerien");
        nationchoices.add("Marocain");
        nationchoices.add("Libye");
        nationchoices.add("Mauritanien");
        nationchoices.addItemListener(this);
        p1.add(nationchoices);

        loisir = new JLabel("Loisir");
        loisir.setBounds(250, 350, 150, 30);
        loisir.setFont(labelFont);
        loisir.setForeground(Color.BLACK);
        p1.add(loisir);

        sport = new Checkbox("Sport");
        sport.setBounds(400, 350, 100, 50);
        sport.setFont(labelFont);
        sport.setForeground(Color.BLACK);
        p1.add(sport);

        music = new Checkbox("Music");
        music.setBounds(500, 350, 100, 50);
        music.setFont(labelFont);
        music.setForeground(Color.BLACK);
        p1.add(music);

        dance = new Checkbox("Dance");
        dance.setBounds(600, 350, 100, 50);
        dance.setFont(labelFont);
        dance.setForeground(Color.BLACK);
        p1.add(dance);

        adress = new JLabel("Address");
        adress.setBounds(250, 400, 150, 30);
        adress.setFont(labelFont);
        adress.setForeground(Color.BLACK);
        p1.add(adress);

        txtAddress = new JTextArea(10, 30);
        txtAddress.setBounds(400, 400, 400, 100);
        txtAddress.setFont(labelFont);
        p1.add(txtAddress);

        ok = new JButton("Envoyer");
        ok.setBounds(400, 550, 150, 30);
        ok.setFont(labelFont);
        ok.setBackground(Color.GREEN);
        ok.setForeground(Color.BLACK);
        p1.add(ok);

        Annuler = new JButton("Annuler");
        Annuler.setBounds(560, 550, 150, 30);
        Annuler.setFont(labelFont);
        Annuler.setBackground(Color.RED);
        Annuler.setForeground(Color.BLACK);

        p1.add(Annuler);
        onglets.add("Main", p1);
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                result += "Nom : " + txtNom.getText() + "\n" + "Prenom : " + txtprenom.getText() + "\n" + "Age : "
                        + txtage.getText() + "\n";
                if (checkMale.getState() == true)
                    result+= "Gender : Male" + "\n";
                else
                    result+= "Gender : Female" + "\n";
                result+= "Nationalite : " + nationchoices.getSelectedItem() + "\n";
                String loisir= "Loisir : ";
                if (sport.getState() == true)
                    loisir= loisir+ sport.getSelectedObjects()[0] + "\t";
                if (music.getState() == true)
                    loisir= loisir+ music.getSelectedObjects()[0] + "\t";
                if (dance.getState() == true)
                    loisir= loisir+ dance.getSelectedObjects()[0] + "\t";
                loisir= loisir+ "\n";
                result+=loisir;
                result+= "Address : " + txtAddress.getText()+"\nProjets realisées: \n";
            }
        });
        //second onglets

        JLabel title=new JLabel("Title");
        p2.add(title);
        title.setBounds(250, 100, 150, 30);
        JTextField titleset=new JTextField();
        p2.add(titleset);
        titleset.setBounds(400, 100, 400, 30);


        JLabel lang = new JLabel("Languages");
        lang.setBounds(250, 150, 150, 30);
        p2.add(lang);

        JTextField language= new JTextField();
        language.setBounds(400, 150, 400, 30);
        p2.add(language);

        JButton add = new JButton("Add");
        add.setBounds(400, 250, 150, 30);
        p2.add(add);

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                result+=titleset.getText()+" "+language.getText()+"\n";
                titleset.setText("");
                language.setText("");
            }
        });

        onglets.add("Projects",p2);

        //ONGLETS 2

        JPanel p3=new JPanel();
        p3.setLayout(null);
        onglets.add("Stages",p3);
        JLabel lieu = new JLabel("Lieu");
        lieu.setBounds(250, 100, 150, 30);
        p3.add(lieu);

        JTextField lieuset = new JTextField();
        lieuset.setBounds(400, 100, 400, 30);
        p3.add(lieuset);

        JLabel periode = new JLabel("Periode");
        periode.setBounds(250, 150, 150, 30);
        p3.add(periode);

        JTextField periodeset = new JTextField();
        periodeset.setBounds(400, 150, 400, 30);
        p3.add(periodeset);

        JLabel tache = new JLabel("Tache");
        tache.setBounds(250, 200, 150, 30);
        p3.add(tache);

        JTextField tacheset = new JTextField();
        tacheset.setBounds(400, 200, 400, 30);
        p3.add(tacheset);

        JButton add1 = new JButton("Add");
        add1.setBounds(400, 250, 150, 30);
        p3.add(add1);


        model=new DefaultTableModel();
        model.setColumnIdentifiers(Titre);
        table.setModel(model);
        tpan.setBounds(250, 300, 500, 200);
        p3.add(tpan);

        add1.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                result+="Stage Lieu:"+lieuset.getText()+"\t"+"Stage Periode:"+periodeset.getText()+"\t"+"Stage Tache:"+tacheset.getText()+"\n";
                model.addRow(new String[]{lieuset.getText(),periodeset.getText(),tacheset.getText()});
                table.setModel(model);
                lieuset.setText("");
                periodeset.setText("");
                tacheset.setText("");

            }

        });


        //ONGLETS 3

        JPanel p4=new JPanel();
        p4.setLayout(null);
        onglets.add("Competences",p4);
        JLabel comp = new JLabel("Competence");
        comp.setBounds(250, 100, 150, 30);
        p4.add(comp);

        JTextField compset = new JTextField();
        compset.setBounds(400, 100, 400, 30);
        p4.add(compset);

        JButton add2 = new JButton("Add");
        add2.setBounds(400, 250, 150, 30);
        p4.add(add2);

        JButton submite = new JButton("Submite");
        submite.setBounds(500, 600, 150, 30);
        p4.add(submite);

        model2=new DefaultTableModel();
        model2.setColumnIdentifiers(Titre2);
        table2.setModel(model2);
        tpan2.setBounds(250, 300, 500, 200);
        p4.add(tpan2);
        add2.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                result+=compset.getText()+"\t";
                model2.addRow(new String[]{compset.getText()});
                table2.setModel(model2);
                compset.setText("");

            }

        });
        submite.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(result);

            }

        });
        setVisible(true);

    }







    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }







    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub

    }
    public String getResult(){
        return result;
    }

}