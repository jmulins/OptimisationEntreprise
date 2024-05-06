import java.util.ArrayList;
import java.util.HashMap;

public class Entreprise {
    public HashMap<Machine,Integer> machines = new HashMap<Machine,Integer>();
    public Produit terrineVolaille;
    public Produit mousseCanard;
    public Produit patePorc;
    public Produit jambon;
    public Produit cuissePoulet;
    public MatierePremiere poulet;
    public MatierePremiere porc;
    public MatierePremiere canard;
    public MatierePremiere fer;
    public MatierePremiere plastique;
    public Cours cours;
    public Entreprise(HashMap<Machine,Integer>  machines){
        InitCours();
        InitMP();
        InitProduits();
        InitMachines();
    }
    private void InitCours(){
        // Le cours des matières premières
        this.cours = new Cours(1.6605,3.537, 4.6035, 5.4405, 2.214);

    }
    private void InitMP(){
        // Les matières premières
        this.poulet = new MatierePremiere("Poulet", cours.prixPoulet);
        this.porc = new MatierePremiere("Porc", cours.prixPorc);
        this.canard = new MatierePremiere("Canard", cours.prixCanard);
        this.fer = new MatierePremiere("Fer", cours.prixFer);
        this.plastique = new MatierePremiere("Plastique", cours.prixPlastique);

    }
    private void InitMachines() {
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
    }

    public double CalculePrixMP(String nomMP, int nombreMP){
        double total=0;
        for(Machine machine : machines.keySet()){
            MachineMatierePremiere machineMP = (MachineMatierePremiere) machine;
            for(MatierePremiere mp : machineMP.capacite.keySet()){
                if(mp.nom==nomMP){
                    total+=mp.prix;
                    break;
                }
            }
        }
        return total;
    }
    private void InitProduits(){

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
        this.terrineVolaille = new Produit("Terrine de volaille", 10, terrineVolailleFabricationMP, terrineVolailleFabrication);
        this.mousseCanard = new Produit("Mousse de canard", 180, mousseCanardFabricationMP, mousseCanardFabrication );
        this.patePorc = new Produit("Pâté de porc", 98, patePorcFabricationMP,patePorcFabrication );
        this.jambon = new Produit("Jambon", 10, jambonFabricationMP, jambonFabrication );
        this.cuissePoulet = new Produit("Cuisse de poulet", 512, cuissePouletFabricationMP, cuissePouletFabrication );

    }
}
