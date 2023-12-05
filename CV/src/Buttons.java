import javax.swing.*;
import java.awt.event.*;
public class Buttons extends JFrame implements ActionListener {
    PersonalInfos personalInfos;
    Stages stages;
    Project project;
    Competence competence;
    Loisir loisir;
    Picture picture;
    public Buttons(PersonalInfos personalInfos,Stages stages,Project
            project,Competence competence,Loisir loisir,Picture picture) {
        this.personalInfos=personalInfos;
        this.stages=stages;
        this.project=project;
        this.competence=competence;
        this.loisir=loisir;
        this.picture=picture;
    }
    JButton save=new JButton("Sauvegarder");
    JButton reset=new JButton("Réinitialiser");
    JButton leave=new JButton("Quitter");
    public JPanel createButtonsPanel() {
        JPanel ButtonsPanel=new JPanel();
        ButtonsPanel.add(save);
        ButtonsPanel.add(reset);
        ButtonsPanel.add(leave);
        save.addActionListener(this);
        reset.addActionListener(this);
        leave.addActionListener(this);
        return ButtonsPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==save) {
            personalInfos.saveData();
            stages.saveData();
            project.saveData();
            competence.saveData();
            loisir.saveData();
            picture.saveData();
            JDialog d=new JDialog();
            LoadFormulaire loadFormulaire=new
                    LoadFormulaire(personalInfos,stages,project,competence,loisir,picture);
            d.add(loadFormulaire.createCVPanel());
            d.setSize(600,600);
            d.setVisible(true);
        }else if(source==reset) {
            personalInfos.resetData();
            stages.resetData();
            project.resetData();
            competence.resetData();
            loisir.resetData();
            picture.resetData();
        }
        else if(source==leave) {
            System.exit(0);
        }
    }
}
