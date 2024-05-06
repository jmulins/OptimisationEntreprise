import javax.crypto.Mac;
import java.util.HashMap;

public class MachineProduitFini extends Machine {
    public HashMap<MatiereIntermediaire, Integer> capacite;
    public MachineProduitFini(String nom, HashMap<MatiereIntermediaire, Integer> capacite){
        super(nom);
        this.capacite=capacite;

    }
}
