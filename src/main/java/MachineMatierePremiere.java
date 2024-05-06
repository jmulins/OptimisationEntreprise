import java.util.HashMap;

public class MachineMatierePremiere extends Machine{
    public HashMap<MatierePremiere, Double> capacite;

    public MachineMatierePremiere(String nom,HashMap<MatierePremiere, Double> capacite) {
        super(nom);
        this.capacite=capacite;
    }
}
