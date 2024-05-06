import javax.crypto.Mac;
import java.util.HashMap;

public class MachineProduitFini extends Machine {
    public HashMap<Produit, Integer> capacite;
    public MachineProduitFini(String nom, HashMap<Produit, Integer> capacite){
        super(nom);
        this.capacite=capacite;

    }
}
