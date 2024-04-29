import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame{
    public ArrayList<JLabel> labels = new ArrayList<JLabel>();
    public ArrayList<JTextField> fields = new ArrayList<JTextField>();
    public Window(){
        this.InitFrame();
        this.InitComponent();

    }
    public void InitFrame(){
        this.setTitle("Progiciel");
        this.setSize(1280,720);
        this.setLayout(new GridLayout(5,2));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setVisible(true);
    }
    public void InitComponent(){
        for(String categorie : Main.MP_LABELS){
            JTextField field = new JTextField();
            JLabel label = new JLabel(categorie);
            label.setVerticalTextPosition(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.set
            label.setBackground(new Color(255,0,0));
            label.setForeground(new Color(255,255,255));
            label.setOpaque(true);

            label.setFont(new Font("Roboto", 0, 30));
            this.add(label);
            this.add(field);
        }
    }
}
