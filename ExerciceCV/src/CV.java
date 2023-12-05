import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CV extends JFrame implements ActionListener, ItemListener {
    JLabel title, nom, prenom, age, gender, nationalite, loisir, adress;
    JTextField txtNom, txtprenom, txtage;
    JTextArea txtAddress, tout;
    Checkbox checkMale, checkFemale, sport, music, dance;
    CheckboxGroup genderCheckbox;
    Choice nationchoices;
    JButton ok, Annuler;
    String result="";
    String projet="";
    String stagess="";

    String comppp="";




    public CV() {

        setTitle("CV");
        setSize(1000, 700);
        setLayout(null);
        JPanel pan1=new JPanel();
        JPanel pan2=new JPanel();
        JPanel pan3=new JPanel();
        JPanel pan4=new JPanel();
        pan1.setLayout(null);
        pan3.setLayout(null);
        pan4.setLayout(null);

        JTabbedPane onglets=new JTabbedPane();
        onglets.setBounds(0, 0, 1050, 700);
        this.add(onglets);

        Font titleFont = new Font("tahoma", Font.BOLD, 20);
        Font labelFont = new Font("tahoma", Font.PLAIN, 15);
        Font textFont = new Font("tahoma", Font.PLAIN, 13);

        title = new JLabel("Formulaire");
        title.setBounds(525, 40, 300, 50);
        title.setFont(titleFont);
        title.setForeground(Color.PINK);
        pan1.add(title);

        nom = new JLabel("Nom");
        nom.setBounds(250, 100, 150, 30);
        nom.setFont(labelFont);
        pan1.add(nom);

        txtNom = new JTextField();
        txtNom.setBounds(400, 100, 400, 30);
        txtNom.setFont(textFont);
        pan1.add(txtNom);

        prenom = new JLabel("Prenom");
        prenom.setBounds(250, 150, 150, 30);
        prenom.setFont(labelFont);
        pan1.add(prenom);

        txtprenom = new JTextField();
        txtprenom.setBounds(400, 150, 400, 30);
        txtprenom.setFont(textFont);
        pan1.add(txtprenom);

        age = new JLabel("Age");
        age.setBounds(250, 200, 150, 30);
        age.setFont(labelFont);
        pan1.add(age);

        txtage = new JTextField();
        txtage.setBounds(400, 200, 400, 30);
        txtage.setFont(textFont);
        pan1.add(txtage);

        gender = new JLabel("Gender");
        gender.setBounds(250, 250, 150, 30);
        gender.setFont(labelFont);
        pan1.add(gender);

        genderCheckbox = new CheckboxGroup();

        checkMale = new Checkbox("Male", genderCheckbox, true);
        checkMale.setBounds(400, 250, 100, 30);
        checkMale.setFont(labelFont);
        checkMale.setForeground(Color.BLACK);
        pan1.add(checkMale);

        checkFemale = new Checkbox("Female", genderCheckbox, false);
        checkFemale.setBounds(500, 250, 100, 30);
        checkFemale.setFont(labelFont);
        checkFemale.setForeground(Color.BLACK);
        pan1.add(checkFemale);

        nationalite = new JLabel("Nationalite");
        nationalite.setBounds(250, 300, 150, 30);
        nationalite.setFont(labelFont);
        nationalite.setForeground(Color.BLACK);
        pan1.add(nationalite);

        nationchoices = new Choice();
        nationchoices.setFont(labelFont);
        nationchoices.setBounds(400, 300, 400, 50);
        nationchoices.add("Tunisienne");
        nationchoices.add("Algérienne");
        nationchoices.add("Marocainne");
        nationchoices.add("Mauritanienne");
        nationchoices.addItemListener(this);
        pan1.add(nationchoices);

        loisir = new JLabel("Loisir");
        loisir.setBounds(250, 350, 150, 30);
        loisir.setFont(labelFont);
        pan1.add(loisir);

        sport = new Checkbox("Sport");
        sport.setBounds(400, 350, 100, 50);
        sport.setFont(labelFont);
        pan1.add(sport);

        music = new Checkbox("Music");
        music.setBounds(500, 350, 100, 50);
        music.setFont(labelFont);
        pan1.add(music);
        dance = new Checkbox("Dance");
        dance.setBounds(600, 350, 100, 50);
        dance.setFont(labelFont);
        pan1.add(dance);
        adress = new JLabel("Address");
        adress.setBounds(250, 400, 150, 30);
        adress.setFont(labelFont);
        pan1.add(adress);

        txtAddress = new JTextArea(10, 30);
        txtAddress.setBounds(400, 400, 400, 100);
        txtAddress.setFont(labelFont);
        pan1.add(txtAddress);

        ok = new JButton("Envoyer");
        ok.setBounds(560, 550, 150, 30);
        ok.setFont(labelFont);
        ok.setBackground(Color.lightGray);
        ok.setForeground(Color.BLACK);
        pan1.add(ok);

        Annuler = new JButton("Annuler");
        Annuler.setBounds(400, 550, 150, 30);
        Annuler.setFont(labelFont);
        Annuler.setBackground(Color.MAGENTA);
        Annuler.setForeground(Color.BLACK);

        pan1.add(Annuler);
        onglets.add("Données personnelles", pan1);
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        JLabel title=new JLabel("Title");
        pan2.add(title);
        title.setBounds(250, 100, 150, 30);
        JTextField titleset=new JTextField();
        pan2.add(titleset);
        titleset.setBounds(400, 100, 400, 30);


        JLabel lang = new JLabel("Languages");
        lang.setBounds(250, 150, 150, 30);
        pan2.add(lang);

        JTextField language= new JTextField();
        language.setBounds(400, 150, 400, 30);
        pan2.add(language);

        JButton add = new JButton("Add");
        add.setBounds(400, 250, 120, 50);
        pan2.add(add);

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                projet+=titleset.getText()+" "+language.getText()+"\n";
                titleset.setText("");
                language.setText("");
            }
        });

        onglets.add("Stages",pan3);

        pan2.setLayout(null);
        onglets.add("Projets",pan2);
        JLabel lieu = new JLabel("Lieu");
        lieu.setBounds(250, 100, 150, 30);
        pan3.add(lieu);

        JTextField lieuset = new JTextField();
        lieuset.setBounds(400, 100, 400, 30);
        pan3.add(lieuset);

        JLabel periode = new JLabel("Periode");
        periode.setBounds(250, 150, 150, 30);
        pan3.add(periode);

        JTextField periodeset = new JTextField();
        periodeset.setBounds(400, 150, 400, 30);
        pan3.add(periodeset);

        JLabel tache = new JLabel("Tache");
        tache.setBounds(250, 200, 150, 30);
        pan3.add(tache);

        JTextField tacheset = new JTextField();
        tacheset.setBounds(400, 200, 400, 30);
        pan3.add(tacheset);

        JButton add1 = new JButton("Add");
        add1.setBounds(400, 250, 150, 30);
        pan3.add(add1);

        add1.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                stagess+="Stage Lieu:"+lieuset.getText()+"\t"+"Stage Periode:"+periodeset.getText()+"\t"+"Stage Tache:"+tacheset.getText()+"\n";
                lieuset.setText("");
                periodeset.setText("");
                tacheset.setText("");
            }

        });

        onglets.add("Competences",pan4);
        JLabel comp = new JLabel("Competence");
        comp.setBounds(250, 100, 150, 30);
        pan4.add(comp);

        JTextField compset = new JTextField();
        compset.setBounds(400, 100, 400, 30);
        pan4.add(compset);

        JButton add2 = new JButton("Add");
        add2.setBounds(400, 250, 150, 30);
        pan4.add(add2);

        JButton submit = new JButton("Submite");
        submit.setBounds(500, 600, 150, 30);
        pan4.add(submit);



        add2.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                comppp+=compset.getText()+"\t";
                compset.setText("");

            }
        });
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               JFrame dd = new JFrame();
                dd.setSize(1000, 700);
                JPanel Result=new JPanel();
                Result.add(new JTextField(result));
                JPanel Donne = new JPanel(new GridLayout(15,2));
                Donne.add(new JLabel("Données personnells"));
                Donne.add(new JLabel(""));
                Donne.add(new JLabel("Nom"));
                Donne.add(new JLabel(txtNom.getText()));
                Donne.add(new JLabel("Prenom"));
                Donne.add(new JLabel(txtprenom.getText()));
                Donne.add(new JLabel("Age"));
                Donne.add(new JLabel(txtage.getText()));
                Donne.add(new JLabel("Adresse"));
                Donne.add(new JLabel(txtAddress.getText()));
                Donne.add(new JLabel("Sexe"));
                if (checkMale.getState() == true)
                    Donne.add(new JLabel("Homme"));
                else
                    Donne.add(new JLabel("Femme"));
                Donne.add(new JLabel("Hobbies"));
                if (sport.getState() == true)
                    Donne.add(new JLabel("Sport "));
                if (music.getState() == true)
                    Donne.add(new JLabel("Music "));
                Donne.add(new JLabel("Projets"));
                Donne.add(new JLabel(projet));

                Donne.add(new JLabel("Stages"));
                Donne.add(new JLabel(stagess));
                Donne.add(new JLabel("Compétences"));
                Donne.add(new JLabel(comppp));
                dd.add(Donne);
               // dd.setVisible(true);
                JOptionPane.showMessageDialog(dd,Donne);
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