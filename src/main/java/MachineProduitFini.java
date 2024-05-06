import javax.crypto.Mac;
import java.util.HashMap;

public class MachineProduitFini extends Machine {
    public HashMap<Produit, Double> capacite;
    public MachineProduitFini(String nom, HashMap<Produit, Double> capacite){
        super(nom);
        this.capacite=capacite;

    }
}
