import java.util.*;

public class MonSimplexe {



    public static void calcule(double x1, double x2, double x3, double x4, double x5){
        double[][] simplexTableau = new double[7][12];

        //AAAAAAAAAAAAAAAAA
//        prixMp.put("PORC", prixPorc);
//        prixMp.put("CANARD", prixCanard);
//        prixMp.put("POULET", prixPoulet);
//        prixMp.put("PLASTIQUE", prixPlastique);
//        prixMp.put("FER", prixFer);


        for (int i = 0; i < 5;i++){
            simplexTableau[i][i] = 1;
            //simplexTableau[i][i+5] = 1;
        }

        for (int i = 0;i  < 6; i++){
            simplexTableau[i][i+5] = 1;
        }


        simplexTableau[0][11] = donneMaxProductionPF(ProduitsFinis.TERRINE);
        simplexTableau[1][11] = donneMaxProductionPF(ProduitsFinis.PATE);
        simplexTableau[2][11] = donneMaxProductionPF(ProduitsFinis.MOUSSE);
        simplexTableau[3][11] = donneMaxProductionPF(ProduitsFinis.JAMBON);
        simplexTableau[4][11] = donneMaxProductionPF(ProduitsFinis.CUISSE);
        simplexTableau[5][11] = 1;

        simplexTableau[5][0] = 1/donneMaxProductionPF(ProduitsFinis.TERRINE);
        simplexTableau[5][1] = 1/donneMaxProductionPF(ProduitsFinis.PATE);
        simplexTableau[5][2] = 1/donneMaxProductionPF(ProduitsFinis.MOUSSE);
        simplexTableau[5][3] = 1/donneMaxProductionPF(ProduitsFinis.JAMBON);
        simplexTableau[5][4] = 1/donneMaxProductionPF(ProduitsFinis.CUISSE);














//        for (int i = 0; i < 11*5;i++){
//            if (simplexTableau[i%5][i%12] !=  1){
//                simplexTableau[i%5][i%12] = 0;
//            }
//
//        }
















        String arrayString = Arrays.deepToString(simplexTableau);
        String[] arrayCut = arrayString.split("],");

        for (String  piece :  arrayCut){
            System.out.println(piece);
        }

        donneMaxProductionPF(ProduitsFinis.JAMBON);




    }



    public static double donneMaxProductionPF(ProduitsFinis pf){
        int nombreMachineDecoupe=0;
        int nombreMachineBroyage=0;
        int nombreMachineCuisson=0;
        int nombreMachineEmballage=0;
        for(Machine machine : Main.entreprise.machines.keySet()){
            switch(machine.nom){
                case "DECOUPAGE":
                    nombreMachineDecoupe=Main.entreprise.machines.get(machine);
                    break;
                case "BROYAGE":
                    nombreMachineBroyage=Main.entreprise.machines.get(machine);
                    break;
                case "CUISSON":
                    nombreMachineCuisson=Main.entreprise.machines.get(machine);
                    break;
                case "EMBALLAGE":
                    nombreMachineEmballage=Main.entreprise.machines.get(machine);
                    break;
                default:
                    break;
            }
        }


//        System.out.println(nombreMachineDecoupe);
//        System.out.println(nombreMachineBroyage);
//        System.out.println(nombreMachineCuisson);
//        System.out.println(nombreMachineEmballage);


        switch (pf){
            case TERRINE:
                return Collections.min(Arrays.asList(nombreMachineDecoupe * 194400, nombreMachineBroyage * 487012, nombreMachineCuisson * 292207, nombreMachineEmballage * 259740));
            case PATE:
                return Collections.min(Arrays.asList(nombreMachineDecoupe * 395744, nombreMachineBroyage * 797872, nombreMachineCuisson * 574468, nombreMachineEmballage * 425531));
            case MOUSSE:
                return Collections.min(Arrays.asList(nombreMachineDecoupe * 116250, nombreMachineBroyage * 454545, nombreMachineCuisson * 606060, nombreMachineEmballage * 242424));
                case JAMBON:
                    Collections.min(Arrays.asList(nombreMachineDecoupe * 50000, nombreMachineCuisson * 181944, nombreMachineEmballage * 218780));
            case CUISSE:
                return Collections.min(Arrays.asList(nombreMachineDecoupe * 37500, nombreMachineEmballage * 78125));


        }



        return 0;

    }






}
