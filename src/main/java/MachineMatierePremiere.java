import java.util.HashMap;

public class MachineMatierePremiere extends Machine{
    public HashMap<MatierePremiere, Integer> capacite;

    public MachineMatierePremiere(String nom,HashMap<MatierePremiere, Integer> capacite) {
        super(nom);
        this.capacite=capacite;
    }
}
