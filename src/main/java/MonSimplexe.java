import java.util.*;

public class MonSimplexe {



    public static void calcule(double x1, double x2, double x3, double x4, double x5){
        double[][] simplexTableau = new double[7][12];
        Entreprise entreprise = Main.entreprise;
        double caTerrine = entreprise.terrineVolaille.prixVente - (entreprise.porc.prix * 0.162 + entreprise.poulet.prix * 0.097 + entreprise.canard.prix * 0.037 + entreprise.fer.prix * 0.08);
        double caPate = entreprise.patePorc.prixVente - (entreprise.porc.prix * 0.094 + entreprise.fer.prix * 0.03);
        double caMousse = entreprise.mousseCanard.prixVente - (entreprise.porc.prix * 0.129 + entreprise.canard.prix * 0.394 + entreprise.plastique.prix * 0.056);
        double caJambon = entreprise.jambon.prixVente - (entreprise.porc.prix * 1.2 + entreprise.plastique.prix * 0.073);
        double caCuisses = entreprise.cuissePoulet.prixVente - (entreprise.cuissePoulet.prixVente * 1.6 + entreprise.plastique.prix * 0.064);





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

        simplexTableau[6][0] = caTerrine;
        simplexTableau[6][1] = caPate;
        simplexTableau[6][2] = caMousse;
        simplexTableau[6][3] = caJambon;
        simplexTableau[6][4] = caCuisses;




        while (simplexTableau[6][0] > 0 || simplexTableau[6][1] > 0 || simplexTableau[6][2] > 0 || simplexTableau[6][3] > 0 || simplexTableau[6][4] > 0){
            afficheTableau(simplexTableau);
            System.out.println("----------------------------------------------------------------------");
            double maxCA = 0;
            int lignePivot = 0;
            int colonnePivot = 0;
            double maxCoef = Integer.MAX_VALUE;
            double nombrePivot;


            //Donne la colonne du pivot
            for (int i = 0; i <=4; i++){

                if (simplexTableau[6][i] > maxCA){
                    maxCA = simplexTableau[6][i];
                    colonnePivot = i;
                }
            }

            //Donne la ligne du pivot
            for (int i = 0; i <=5; i++){

                if (simplexTableau[i][colonnePivot] != 0) {
                if (simplexTableau[i][11]/simplexTableau[i][colonnePivot] < maxCoef){


                        maxCoef = simplexTableau[i][11] / simplexTableau[i][colonnePivot];
                        lignePivot = i;
                    }
                }
            }

            //Donne le nombre du pivot
            nombrePivot = simplexTableau[lignePivot][colonnePivot];

            //Clone le tableau
            //double[][] tableauSuivant = Arrays.copyOf(simplexTableau, 7);
            double[][] tableauSuivant = new double[7][12];
            for (int i = 0; i <= 6; i++){
                System.arraycopy(simplexTableau[i], 0, tableauSuivant[i], 0, 12);


            }

            //afficheTableau(tableauSuivant);


            //Met des 0 dans la colonne du pivot excepté le nombre du pivot
            for (int i = 0; i <=6; i++){
                if (i != lignePivot){
                    tableauSuivant[i][colonnePivot] = 0;
                }

            }

            for (int i = 0; i <=11; i++){
                tableauSuivant[lignePivot][i] = simplexTableau[lignePivot][i]/nombrePivot;
            }


            for (int i = 0; i<= 6; i++){
                for (int j = 0; j<= 11; j++){

                    if (i != lignePivot && j != colonnePivot){
                        /*
                        System.out.println(simplexTableau[i][j] - ((simplexTableau[lignePivot][i]*simplexTableau[i][colonnePivot])/nombrePivot));
                        System.out.println("truc à modifier : " + simplexTableau[i][j]);
                        System.out.println("pivot du haut : " + simplexTableau[lignePivot][i]);
                        System.out.println("pivot du côté : " + simplexTableau[i][colonnePivot]);

                         */


                        tableauSuivant[i][j] = simplexTableau[i][j] - ((simplexTableau[lignePivot][j]*simplexTableau[i][colonnePivot])/nombrePivot);
                    }


                }

            }


            //simplexTableau = Arrays.copyOf(tableauSuivant, 7);

            for (int i = 0; i <= 6; i++){
                System.arraycopy(tableauSuivant[i], 0, simplexTableau[i], 0, 12);


            }


        }











//        for (int i = 0; i < 11*5;i++){
//            if (simplexTableau[i%5][i%12] !=  1){
//                simplexTableau[i%5][i%12] = 0;
//            }
//
//        }












        afficheTableau(simplexTableau);


        //System.out.println(simplexTableau);

        //donneMaxProductionPF(ProduitsFinis.JAMBON);




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

    public static void afficheTableau(double[][] simplexTableau){
        String arrayString = Arrays.deepToString(simplexTableau);
        String[] arrayCut = arrayString.split("],");

        for (String  piece :  arrayCut){
            System.out.println(piece);
        }
    }






}
