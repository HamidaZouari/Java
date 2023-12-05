import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
class Frame extends JFrame implements ActionListener{
    public Frame() {
        this.setTitle("Ma premiere fenetre Java");
        this.setSize(1500,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel TitelPanel=new JPanel();
        JLabel title=new JLabel("Welcom To Create Cv Application");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 20));
        title.setPreferredSize(new Dimension(500, 100));
        TitelPanel.add(title);
        PersonalInfos personalInfos=new PersonalInfos();
        Stages stages=new Stages();
        Project project =new Project();
        Competence competence=new Competence();
        Loisir loisir=new Loisir();
        Picture picture=new Picture();
        Buttons buttons=new
                Buttons(personalInfos,stages,project,competence,loisir,picture);
        JPanel ContentPanel =new JPanel();
        ContentPanel.setLayout(new GridLayout(3,3));
        ContentPanel.add(personalInfos.createPersonelInfoPanel());
        ContentPanel.add(stages.createStagePanel());
        ContentPanel.add(project.createProjectPanel());
        ContentPanel.add(competence.createCompetencePanel());
        ContentPanel.add(loisir.createLoisirPanel());
        ContentPanel.add(picture.createPicturePanel());
        this.getContentPane().add(TitelPanel,BorderLayout.NORTH);
        this.getContentPane().add(ContentPanel,BorderLayout.CENTER);
        this.getContentPane().add(buttons.createButtonsPanel(),BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
    }
}
