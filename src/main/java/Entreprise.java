import java.util.ArrayList;
import java.util.HashMap;

public class Entreprise {
    public HashMap<Machine,Integer> machines = new HashMap<Machine,Integer>();

    public Entreprise(HashMap<Machine,Integer>  machines){
        this.machines=machines;

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
}
