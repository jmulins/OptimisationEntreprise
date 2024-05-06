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

    static Entreprise entreprise;


    public static void main(String[] args) {




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
        MatiereIntermediaire poitrailCanard = new MatiereIntermediaire("Poitrail de canard", 0.14);
        MatiereIntermediaire chairCanard = new MatiereIntermediaire("Chair de canard", 0.54);
        MatiereIntermediaire chairPorc = new MatiereIntermediaire("Chair de porc", 0.62);
        MatiereIntermediaire musclesPorc = new MatiereIntermediaire("Muscles de porc", 0.15);
        MatiereIntermediaire chairPoulet = new MatiereIntermediaire("Chair de poulet", 0.31);
        MatiereIntermediaire cuissePouletMI = new MatiereIntermediaire("Cuisse de poulet", 0.32);

        // Ce qui constitue les produits
        HashMap<MatierePremiere,Integer> terrineVolailleFabricationMP = new HashMap<MatierePremiere,Integer>();
        terrineVolailleFabricationMP.put(fer, 80);
        HashMap<MatiereIntermediaire,Integer> terrineVolailleFabrication = new HashMap<MatiereIntermediaire,Integer>();
        terrineVolailleFabrication.put(chairCanard, 20);
        terrineVolailleFabrication.put(chairPorc, 101);
        terrineVolailleFabrication.put(chairPoulet, 30);

        HashMap<MatierePremiere,Integer> mousseCanardFabricationMP = new HashMap<MatierePremiere,Integer>();
        mousseCanardFabricationMP.put(plastique, 56);
        HashMap<MatiereIntermediaire,Integer> mousseCanardFabrication = new HashMap<MatiereIntermediaire,Integer>();
        mousseCanardFabrication.put(chairPorc, 80);
        mousseCanardFabrication.put(poitrailCanard, 45);
        mousseCanardFabrication.put(chairCanard, 40);

        HashMap<MatierePremiere,Integer> patePorcFabricationMP = new HashMap<MatierePremiere,Integer>();
        patePorcFabricationMP.put(fer, 30);
        HashMap<MatiereIntermediaire,Integer> patePorcFabrication = new HashMap<MatiereIntermediaire,Integer>();
        patePorcFabrication.put(chairPorc,94);

        HashMap<MatierePremiere,Integer> jambonFabricationMP = new HashMap<MatierePremiere,Integer>();
        jambonFabricationMP.put(plastique, 73);
        HashMap<MatiereIntermediaire,Integer> jambonFabrication = new HashMap<MatiereIntermediaire,Integer>();
        jambonFabrication.put(musclesPorc, 180);

        HashMap<MatierePremiere,Integer> cuissePouletFabricationMP = new HashMap<MatierePremiere,Integer>();
        cuissePouletFabricationMP.put(plastique,64);
        HashMap<MatiereIntermediaire,Integer> cuissePouletFabrication = new HashMap<MatiereIntermediaire,Integer>();
        cuissePouletFabrication.put(cuissePouletMI, 512);



        // Les produits
        Produit terrineVolaille = new Produit("Terrine de volaille", 10, terrineVolailleFabricationMP, terrineVolailleFabrication);
        Produit mousseCanard = new Produit("Mousse de canard", 180, mousseCanardFabricationMP, mousseCanardFabrication );
        Produit patePorc = new Produit("Pâté de porc", 98, patePorcFabricationMP,patePorcFabrication );
        Produit jambon = new Produit("Jambon", 10, jambonFabricationMP, jambonFabrication );
        Produit cuissePoulet = new Produit("Cuisse de poulet", 512, cuissePouletFabricationMP, cuissePouletFabrication );

        // Ce que produisent les machines
        HashMap<MatierePremiere, Double> capaciteDecoupage = new HashMap<MatierePremiere, Double>();
        capaciteDecoupage.put(poulet, 45d);
        capaciteDecoupage.put(porc, 60d);
        capaciteDecoupage.put(canard, 45d);

        HashMap<Produit, Double> capaciteBroyage = new HashMap<Produit, Double>();
        capaciteBroyage.put(terrineVolaille, 75d);
        capaciteBroyage.put(patePorc, 75d);
        capaciteBroyage.put(mousseCanard, 75d);

        HashMap<Produit, Double> capaciteCuisson = new HashMap<Produit, Double>();
        capaciteCuisson.put(terrineVolaille, 45d);
        capaciteCuisson.put(patePorc, 54d);
        capaciteCuisson.put(mousseCanard, 75d);
        capaciteCuisson.put(jambon, 32.75d);

        HashMap<Produit, Double> capaciteEmballage = new HashMap<Produit, Double>();
        capaciteEmballage.put(terrineVolaille, 40d);
        capaciteEmballage.put(patePorc, 40d);
        capaciteEmballage.put(mousseCanard, 40d);
        capaciteEmballage.put(jambon, 40d);
        capaciteEmballage.put(cuissePoulet, 40d);

        MachineMatierePremiere machineDecoupage = new MachineMatierePremiere("DECOUPAGE", capaciteDecoupage);
        MachineProduitFini machineBroyage = new MachineProduitFini("BROYAGE", capaciteBroyage);
        MachineProduitFini machineCuisson = new MachineProduitFini("CUISSON", capaciteCuisson);
        MachineProduitFini machineEmballage = new MachineProduitFini("EMBALLAGE", capaciteEmballage);

        // Les machines
        HashMap<Machine,Integer>  machines = new HashMap<Machine,Integer> ();
        machines.put(machineDecoupage,7);
        machines.put(machineBroyage,4);
        machines.put(machineCuisson,6);
        machines.put(machineEmballage,7);
        entreprise = new Entreprise(machines);
        try {
            Utils.calculePrixpourChaquePF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //HashMap<Machine, Integer> machinesHashmap = new HashMap<>();





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


        try {
            Utils.calculePrixpourChaquePF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //HashMap<Machines, Integer> machinesHashmap = new HashMap<>();

//        machinesHashmap.put(Machine., 1);
//        machinesHashmap.put(Machine.BROYAGE, 1);
//        machinesHashmap.put(Machine.CUISSON, 1);
//        machinesHashmap.put(Machine.EMBALLAGE, 1);
//
//
        //entreprise = new Entreprise(machines);


        MonSimplexe.calcule(1,1,1,1,1);

    }
}