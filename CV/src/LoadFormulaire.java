import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class LoadFormulaire extends JFrame implements ActionListener {
    ArrayList<String> personalInfos;
    ArrayList<String> stages;
    ArrayList<String> project;
    ArrayList<String> competence;
    ArrayList<String> loisir;
    ArrayList<String> picture;
    public LoadFormulaire(PersonalInfos personalInfos,Stages
            stages,Project project,Competence competence,Loisir loisir,Picture picture) {
        this.personalInfos=personalInfos.loadData();
        this.stages=stages.loadData();
        this.project=project.loadData();
        this.competence=competence.loadData();
        this.loisir=loisir.loadData();
        this.picture=picture.loadData();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
    }
    public JPanel createCVPanel(){
        JPanel CVPanel =new JPanel();
        CVPanel.setLayout(new BorderLayout());
        JPanel HeadPanel =new JPanel();
        HeadPanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon();
        JPanel nom=new JPanel();
        nom.add(new JLabel(personalInfos.get(0)+" "+personalInfos.get(1)));
        HeadPanel.add( nom,BorderLayout.CENTER);
        JPanel coordonne=new JPanel();
        coordonne.setLayout(new GridLayout(5,0));
        coordonne.add(new JLabel("adresse: "+personalInfos.get(2)));
        coordonne.add(new JLabel("mail: "+personalInfos.get(3)));
        coordonne.add(new JLabel("téléphone: "+personalInfos.get(4)));
        coordonne.add(new JLabel("situation: "+personalInfos.get(5)));
        coordonne.add(new JLabel("nationalité "+personalInfos.get(6)));
        HeadPanel.add(coordonne,BorderLayout.EAST);
        JPanel EastPanel =new JPanel();
        EastPanel.setLayout(new GridLayout(7,0));
        EastPanel.add(new JLabel("Loisir:"));
        EastPanel.add(new JLabel(loisir.get(0)));
        EastPanel.add(new JLabel(loisir.get(1)));
        EastPanel.add(new JLabel("Competence:"));
        EastPanel.add(new JLabel(competence.get(0)));
        EastPanel.add(new JLabel(competence.get(1)));
        EastPanel.add(new JLabel(competence.get(2)));
        JPanel ContentPanel=new JPanel();
        ContentPanel.setLayout(new GridLayout(14,0));
        ContentPanel.add(new JLabel("Stages:"));
        ContentPanel.add(new JLabel("Periode : "+stages.get(0)));
        ContentPanel.add(new JLabel("Societe : "+stages.get(1)));
        ContentPanel.add(new JLabel("Description du stage : "+stages.get(2)));
                ContentPanel.add(new JLabel("Periode : "+stages.get(3)));
        ContentPanel.add(new JLabel("Societe : "+stages.get(4)));
        ContentPanel.add(new JLabel("Description du stage : "+stages.get(5)));
                ContentPanel.add(new JLabel("Projects:"));
        ContentPanel.add(new JLabel("type de projet : "+project.get(0)));
        ContentPanel.add(new JLabel("titre de projet : "+project.get(1)));
        ContentPanel.add(new JLabel("description de projet : "+project.get(2)));
                ContentPanel.add(new JLabel("type de projet: "+project.get(3)));
        ContentPanel.add(new JLabel("titre de projet : "+project.get(4)));
        ContentPanel.add(new JLabel("description de projet : "+project.get(5)));
        try {
            BufferedImage myPicture = ImageIO.read(new File("path-tofile"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);
            HeadPanel.add( picLabel,BorderLayout.WEST);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        CVPanel.add(HeadPanel,BorderLayout.NORTH);
        CVPanel.add(EastPanel,BorderLayout.WEST);
        CVPanel.add(ContentPanel,BorderLayout.CENTER);
        return CVPanel;
    }
}