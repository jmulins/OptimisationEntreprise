import java.io.File;
import java.io.IOException;
import java.util.*;

enum Machines{
    DECOUPE,
    BROYAGE,
    CUISSON,
    EMBALLAGE
}

enum ProduitsFinis{
    TERRINE,
    PATE,
    MOUSSE,
    JAMBON,
    CUISSE
}

enum MatieresPremieresEtIntermediaires {
    PORC,
    POULET,
    CANARD,
    PLASTIQUE,
    FER,
    MUSCLES,
    CHAIR_PORC,
    CUISSE,
    CHAIR_POULET,
    POITRAIL_CANARD,
    CHAIR_CANARD,
    TERRINE,
    PATE,
    MOUSSE,
    JAMBON
}

public class Utils {

    static final HashMap<Machines, MatieresPremieresEtIntermediaires> machinesMP = new HashMap<Machines, MatieresPremieresEtIntermediaires>();





    public void Utils(){








    }


    public static List<Float> calculateMomentum(List<Float> precedentValues, int n){

        List<Float> listWithoutFirstValues = precedentValues.subList(n, precedentValues.size());
        List<Float> momentumList = new ArrayList<Float>();

        for (int i = 0; i < n; i++) {
            momentumList.add(0f);
        }

        for (int i = n; i <= listWithoutFirstValues.size(); i++){

            momentumList.add(1 * (precedentValues.get(i) / precedentValues.get(i - 1)));

        }

        return momentumList;
    }

    public static List<Float> calculateTCI(List<Float> precedentValues, int n, int m){
        if (n>m){ throw new IllegalArgumentException("m doit être plus grand que n. ");}

        List<Float> listToCut = new ArrayList<>(precedentValues.subList(0, precedentValues.size()).stream().toList());
        List<Float> unorderedResult = new ArrayList<Float>();
        List<Float> result = new ArrayList<Float>();

        while (listToCut.size() > m) {

            List<Float> nList = listToCut.subList(listToCut.size() - n - 1, listToCut.size() - 1);
            System.out.println(nList);
            List<Float> mList = listToCut.subList(listToCut.size() - m - 1, listToCut.size() - 1);



            double numerator = 0;
            int denominator = 0;

            for (float fl : nList) {
                numerator += fl;
                denominator++;
            }
            float avgN = (float) (numerator / denominator);
            numerator = 0;
            denominator = 0;

            for (float fl : mList) {
                numerator += fl;
                denominator++;
            }
            float avgM = (float) (numerator / denominator);

            unorderedResult.add((avgN / avgM) * 1);
            listToCut.remove(listToCut.size() - 1);

        }

        for (int i = 0; i <= m; i++){
            result.add(0f);
        }


        for (int i = unorderedResult.size() - 1; i > 0; i--){
            result.add(unorderedResult.get(i));
        }

        return result;

    }


    public static <T> List<Integer> generateXForList(List<T> list){
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            result.add(i);
        }
        return result;
    }


    public static HashMap<MatieresPremieresEtIntermediaires, Double> calculeMatierePremierePourMachine(Machines machine, int nombreMachine){
        List<MatieresPremieresEtIntermediaires> listeMatierePremiere = new ArrayList<MatieresPremieresEtIntermediaires>();
        HashMap<MatieresPremieresEtIntermediaires, Double> matieresNecessaires = new HashMap<>();




        switch (machine){
            case BROYAGE:
                double result = 0;
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_PORC);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_POULET);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_CANARD);


                matieresNecessaires.put(MatieresPremieresEtIntermediaires.PORC, 60000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.POULET, 45000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.CANARD, 45000d * nombreMachine);



                break;
            case DECOUPE:
                    listeMatierePremiere.add(MatieresPremieresEtIntermediaires.POULET);
                    listeMatierePremiere.add(MatieresPremieresEtIntermediaires.PORC);
                    listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CANARD);
                    listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CUISSE);


                matieresNecessaires.put(MatieresPremieresEtIntermediaires.CHAIR_PORC, 60000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.CHAIR_POULET, 45000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.CHAIR_CANARD, 45000d * nombreMachine);

                    break;
            case CUISSON:
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.MUSCLES);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_PORC);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_POULET);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_CANARD);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.POITRAIL_CANARD);

                matieresNecessaires.put(MatieresPremieresEtIntermediaires.JAMBON, 32750d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.PATE, 54000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.TERRINE, 45000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.MOUSSE, 100000d * nombreMachine);


                break;
            case EMBALLAGE:
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_PORC);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_POULET);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CHAIR_CANARD);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.MUSCLES);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.POITRAIL_CANARD);
                listeMatierePremiere.add(MatieresPremieresEtIntermediaires.CUISSE);



                matieresNecessaires.put(MatieresPremieresEtIntermediaires.CUISSE, 40000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.JAMBON, 40000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.PATE, 40000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.TERRINE, 40000d * nombreMachine);
                matieresNecessaires.put(MatieresPremieresEtIntermediaires.MOUSSE, 40000d * nombreMachine);
                break;
        }


        return matieresNecessaires;

    }

    public static void donnePoidsEtPrixPourMP(MatieresPremieresEtIntermediaires mp, double quantite){

        double nombreACommander;
        double prixUnitaire;


        switch (mp){
            case PORC:
                nombreACommander = Math.ceil(quantite/100);
                prixUnitaire = 6.5;
                break;
            case POULET:
                nombreACommander = Math.ceil(quantite/2);
                prixUnitaire = 1;
                break;
            case CANARD:
                nombreACommander = Math.ceil(quantite/3);
                prixUnitaire = 1;
                break;
            case PLASTIQUE:
                nombreACommander = Math.ceil(quantite/50);
                prixUnitaire = 3;
                break;
            case FER:
                nombreACommander = Math.ceil(quantite/60);
                prixUnitaire = 3.5;
                break;
            default:
                throw new IllegalArgumentException("La matière première doit être une matière première. ");
        }

        System.out.println("nombre à commander : " + nombreACommander);
        System.out.println("prix : " + prixUnitaire * nombreACommander);




    }


    public static void calculeChaqueEmployeNeeded(int nombreMachineDecoupe, int nombreMachineBroyage, int nombreMachineCuissoon, int nombreMachineEmballage){

        int nombreOuvriersNecessaires = nombreMachineDecoupe*2 + nombreMachineBroyage + nombreMachineCuissoon*3 + nombreMachineEmballage*3;
        int nombreAgentMaitrise = (int) Math.ceil(nombreOuvriersNecessaires/5d);
        int nombreCadreMoyen = (int) Math.ceil((nombreAgentMaitrise + nombreOuvriersNecessaires)/18d);
        int nombreEmploye = (int) Math.ceil((nombreCadreMoyen + nombreAgentMaitrise + nombreOuvriersNecessaires)/15d);

        System.out.println("il faudra : " + nombreOuvriersNecessaires + " ouvriers. ");
        System.out.println("il faudra : " + nombreAgentMaitrise + " agent maitrise. ");
        System.out.println("il faudra : " + nombreCadreMoyen + " cadres moyens. ");
        System.out.println("il faudra : " + nombreEmploye + " employés. ");
        System.out.println("cela coûtera : " + (nombreAgentMaitrise * 2100 + nombreCadreMoyen * 3600 + nombreEmploye * 1800 + nombreOuvriersNecessaires * 1600) + " €");


    }

    public static void calculePrixpourChaquePF() throws IOException {


        List<String> csvString = CsvFileHelper.readFile(new File(System.getProperty("user.dir") + "\\src\\main\\java\\force_vente.csv"));
        csvString.remove(0);
        List<Double> attractionCuisseListe = new ArrayList<Double>();
        List<Double> attractionTrancheListe = new ArrayList<Double>();
        List<Double> attractionPateListe = new ArrayList<Double>();
        List<Double> attractionTerrineListe = new ArrayList<Double>();
        List<Double> attractionMouseListe = new ArrayList<Double>();

        HashMap<ProduitsFinis, Double> prixPF = new HashMap<>();
       HashMap<ProduitsFinis, Double> best = new HashMap<>();
        best.put(ProduitsFinis.CUISSE, 0d);
        ProduitsFinis currentBestProduct = ProduitsFinis.CUISSE;
        double bestPrix = 0;



        for (String str : csvString){
            String fixedStr = str.replaceAll(",", ".");

            String[] splitString = fixedStr.split(";", -1);
            List<String> splitStringList = Arrays.asList(splitString);


            for (int i = 1; i<=5; i++){
                if (splitString[i] == ""){
                    splitString[i] = "0";
                }
            }

            attractionCuisseListe.add(Double.parseDouble(splitString[1]));
            attractionTrancheListe.add(Double.parseDouble(splitString[2]));
            attractionPateListe.add(Double.parseDouble(splitString[3]));
            attractionTerrineListe.add(Double.parseDouble(splitString[4]));
            attractionMouseListe.add(Double.parseDouble(splitString[5]));
        }

        for (int i = 0; i<csvString.size();i++){
            boolean enleverValeur = false;
            //HashMap<ProduitsFinis, Double> best;

            prixPF.clear();
            prixPF.put(ProduitsFinis.CUISSE, attractionCuisseListe.get(i));
            prixPF.put(ProduitsFinis.JAMBON, attractionTrancheListe.get(i));
            prixPF.put(ProduitsFinis.PATE, attractionPateListe.get(i));
            prixPF.put(ProduitsFinis.TERRINE, attractionTerrineListe.get(i));
            prixPF.put(ProduitsFinis.MOUSSE, attractionMouseListe.get(i));

            for (Map.Entry<ProduitsFinis, Double> keyValuePair : prixPF.entrySet()){
//                System.out.println(keyValuePair.getValue() + " * " + (i * 0.1));
                if (keyValuePair.getValue() * i* 0.1 > best.get(currentBestProduct)){
//                    System.out.println(best + " pour un prix : " + bestPrix);
//                    System.out.println("ratio : " + keyValuePair.getValue() * i* 0.1);
//                    System.out.println("new best : " + keyValuePair.getValue() + " * " + (i * 0.1));
                    currentBestProduct = keyValuePair.getKey();
                    best.clear();
                    best.put(keyValuePair.getKey(), keyValuePair.getValue() * i* 0.1);
                    bestPrix = i*0.1;
                }


            }


        }

        System.out.println(best + " pour un prix de : " + bestPrix);

    }






    public static void machinesPourProduction(){




    }

    public static void simplexPasSimplex(){ //BUT : maximiser le bénéfice
        //Calculer toutes les  limites des matières premières
        // pour pouvoir les mettre dans les 5 for




    }



}
