import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final Dimension  FRAME_SIZE = new Dimension(1280,720);
    public static final int[] MP_COUTS = new int[]{};
    public static final JButton[] MENUS_BUTTONS = new JButton[5];

    public static final String[] MP_LABELS = new String[]{"Cours du porc", "Cours du poulet", "Cours du canard", "Cours du plastique","Cours du fer"};
    static List<Float> listePlastique = new ArrayList<Float>();
    static List<Float> momentumList;
    static List<Float> tciList;

    public static void main(String[] args) {
        CsvFileHelper helper = new CsvFileHelper();
        try {
            for(String x : helper.readFile(new File("C:\\Users\\gontaluk\\IdeaProjects\\OptimisationEntreprise\\src\\main\\java\\chart.csv"))){
                System.out.println(x);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        listePlastique.add(4.2f);
        listePlastique.add(4.11f);
        listePlastique.add(4f);
        listePlastique.add(3.9f);
        listePlastique.add(3.65f);
        listePlastique.add(3.4f);
        listePlastique.add(3.7f);
        listePlastique.add(3.45f);
        listePlastique.add(3.52f);
        listePlastique.add(3.69f);
        listePlastique.add(3.89f);
        listePlastique.add(3.96f);
        listePlastique.add(5.427f);
        listePlastique.add(5.319f);
        listePlastique.add(5.427f);

        momentumList = Utils.calculateMomentum(listePlastique, 1);
        tciList = Utils.calculateTCI(listePlastique, 2, 4);
        MENUS_BUTTONS[0] = new JButton("Graphe tranches de jambon");
        MENUS_BUTTONS[1] = new JButton("Graphe pâté porc");
        MENUS_BUTTONS[2] = new JButton("Graphe mousse canard");
        MENUS_BUTTONS[3] = new JButton("Graphe terrine de volaille");
        MENUS_BUTTONS[4] = new JButton("Graphe cuisses de poulet");


        Window window = new Window();







        System.out.println(listePlastique);
        System.out.println(momentumList);


    }
}