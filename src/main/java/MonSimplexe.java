import java.util.Arrays;
import java.util.HashMap;

public class MonSimplexe {



    public static void calcule(double x1, double x2, double x3, double x4, double x5){
        double[][] simplexTableau = new double[7][12];
        for (int i = 0; i < 5;i++){
            simplexTableau[i][i] = 1;
            //simplexTableau[i][i+5] = 1;
        }

        for (int i = 0;i  < 6; i++){
            simplexTableau[i][i+5] = 1;
        }

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
            //case TERRINE ->


        }





        return 1d;

    }






}
