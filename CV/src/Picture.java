import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
public class Picture extends JFrame implements ActionListener {
    String picture="";
    JTextField imageURL=new JTextField("");
    JButton ChoosePicture=new JButton("Choisir une image");
    public JPanel createPicturePanel() {
        imageURL.setEnabled(false);
        JPanel PicturePanel =new JPanel();
        PicturePanel.setLayout(new BorderLayout());
        ChoosePicture.addActionListener(this);
        JLabel StageTitle=new JLabel("Image");
        StageTitle.setForeground(Color.RED);
        StageTitle.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 15));
        JPanel ContentPicturePanel =new JPanel();
        ContentPicturePanel.setLayout(new GridLayout(6,2));
        JLabel PictureLabel=new JLabel("Choisir une image");
        PictureLabel.setForeground(Color.ORANGE);
        PictureLabel.setFont(new Font("Verdana", Font.BOLD, 12));
//ChoosePicture.setMaximumSize(new Dimension(1,1));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(ChoosePicture);
        ContentPicturePanel.add(imageURL);
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        ContentPicturePanel.add(new JLabel(""));
        StageTitle.setPreferredSize(new Dimension(500, 20));
        PicturePanel.add(StageTitle ,BorderLayout.NORTH);
        PicturePanel.add(ContentPicturePanel,BorderLayout.CENTER);
        PicturePanel.add(PictureLabel,BorderLayout.WEST);
        return PicturePanel;
    }
    public void resetData() {
        imageURL.setText("");
    }
    public void saveData() {
        try {
            PreparedStatement
                    st=Connections.getConnection().prepareStatement("insert into picture values(?);");
            st.setString(1, picture);
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
                    st=Connections.getConnection().prepareStatement("select*from picture");
            ResultSet res=st.executeQuery();
            res.next();
            ArrayList<String> list=new ArrayList<>();
            list.add(res.getString(1));
            return list;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ChoosePicture) {
//JFrame f=new JFrame();
            JDialog d=new JDialog();
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("choose picture");
            d.add(chooser);
            d.setSize(400,400);
            int retour=chooser.showOpenDialog(this);
            if(retour==JFileChooser.APPROVE_OPTION){
                picture=chooser.getSelectedFile().getAbsolutePath();
                imageURL.setText(picture);
            }
        }
    }
}
