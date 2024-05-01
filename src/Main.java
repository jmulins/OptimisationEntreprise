import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int[] MP_COUTS = new int[]{};
    public static final String[] MP_LABELS = new String[]{"porc", "poulet", "canard", "plastique","fer"};
    static List<Float> listePlastique = new ArrayList<Float>();
    static List<Float> momentumList;

    public static void main(String[] args) {
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

        Window window = new Window();







        System.out.println(listePlastique);
        System.out.println(momentumList);


    }
}