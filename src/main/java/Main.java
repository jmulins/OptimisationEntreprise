import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    // Pour la window
    public static final Dimension  FRAME_SIZE = new Dimension(1280,720);
    public static final int[] MP_COUTS = new int[]{};
    public static final JButton[] MENUS_BUTTONS = new JButton[5];
    public static final String[] MP_LABELS = new String[]{"Cours du porc", "Cours du poulet", "Cours du canard", "Cours du plastique","Cours du fer"};

    // Pour le graphe
    static List<Float> listePlastique = new ArrayList<Float>();
    static List<Float> momentumList;
    static List<Float> tciList;

    public static void main(String[] args) {
        /*
        CsvFileHelper helper = new CsvFileHelper();
        try {
            for(String x : helper.readFile(new File(System.getProperty("user.dir") + "\\src\\main\\java\\chart.csv"))){
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
        Utils.donnePoidsEtPrixPourMP(MatieresPremieresEtIntermediaires.PORC, 1000);

        momentumList = Utils.calculateMomentum(listePlastique, 1);
        tciList = Utils.calculateTCI(listePlastique, 2, 4);
        MENUS_BUTTONS[0] = new JButton("Graphe tranches de jambon");
        MENUS_BUTTONS[1] = new JButton("Graphe pâté porc");
        MENUS_BUTTONS[2] = new JButton("Graphe mousse canard");
        MENUS_BUTTONS[3] = new JButton("Graphe terrine de volaille");
        MENUS_BUTTONS[4] = new JButton("Graphe cuisses de poulet");


        Window window = new Window();


        Utils.calculeChaqueEmployeNeeded(1, 1, 1, 1);



        System.out.println(listePlastique);
        System.out.println(momentumList);
        try {
            Utils.calculePrixpourChaquePF();
        } catch (IOException e){
            e.printStackTrace();
        }
        */
        // Le cours des matières premières
        Cours cours = new Cours(1.6605,3.537, 4.6035, 5.4405, 2.214);

        // Les matières premières
        MatierePremiere poulet = new MatierePremiere("Poulet", cours.prixPoulet);
        MatierePremiere porc = new MatierePremiere("Porc", cours.prixPorc);
        MatierePremiere canard = new MatierePremiere("Canard", cours.prixCanard);
        MatierePremiere fer = new MatierePremiere("Fer", cours.prixFer);
        MatierePremiere plastique = new MatierePremiere("Plastique", cours.prixPlastique);

        HashMap<MatierePremiere, Double> poitrailCanardFabrication = new HashMap<MatierePremiere, Double>();
        // Les matieres intermediaires
        MatiereIntermediaire poitrailCanard = new MatiereIntermediaire("Poitrail de canard");
        // Ce qui constitue les produits
        HashMap<MatierePremiere,Integer> terrineVolailleFabrication = new HashMap<MatierePremiere,Integer>();
        HashMap<MatierePremiere,Integer> mousseCanardFabrication = new HashMap<MatierePremiere,Integer>();
        HashMap<MatierePremiere,Integer> patePorcFabrication = new HashMap<MatierePremiere,Integer>();
        HashMap<MatierePremiere,Integer> jambonFabrication = new HashMap<MatierePremiere,Integer>();
        HashMap<MatierePremiere,Integer> cuissePouletFabrication = new HashMap<MatierePremiere,Integer>();

        terrineVolailleFabrication.put();

        // Les produits
        Produit terrineVolaille = new Produit("Terrine de volaille", 10, terrineVolailleFabrication );
        Produit mousseCanard = new Produit("Mousse de canard", 10, terrineVolailleFabrication );
        Produit patePorc = new Produit("Pâté de porc", 10, terrineVolailleFabrication );
        Produit jambon = new Produit("Jambon", 10, terrineVolailleFabrication );
        Produit cuissePoulet = new Produit("Cuisse de poulet", 10, terrineVolailleFabrication );

        // Les machines
        ArrayList<Machine> machines = new ArrayList<Machine>();

        // Ce que produisent les machines
        HashMap<MatierePremiere, Integer> capaciteDecoupage = new HashMap<MatierePremiere, Integer>();
        capaciteDecoupage.put(poulet, 45);
        capaciteDecoupage.put(porc, 60);
        capaciteDecoupage.put(canard, 45);
        capaciteDecoupage.put(canard, 45);
        capaciteDecoupage.put(canard, 45);

        HashMap<Produit, Integer> capaciteBroyage = new HashMap<Produit, Integer>();
        HashMap<Produit, Integer> capaciteCuisson = new HashMap<Produit, Integer>();
        HashMap<Produit, Integer> capaciteEmballage = new HashMap<Produit, Integer>();

        MachineMatierePremiere machineDecoupage = new MachineMatierePremiere("DECOUPAGE", capaciteDecoupage);
        MachineProduitFini machineBroyage = new MachineProduitFini("BROYAGE", capaciteBroyage);
        MachineProduitFini machineCuisson = new MachineProduitFini("CUISSON", capaciteCuisson);
        MachineProduitFini machineEmballage = new MachineProduitFini("EMBALLAGE", capaciteEmballage);

        machines.add(machineDecoupage);
        Entreprise entreprise = new Entreprise(machines);
    }
}