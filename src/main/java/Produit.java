import java.lang.reflect.Array;
import java.util.HashMap;

public class Produit {
    public String nom;
    public double prixVente;
    public HashMap<MatierePremiere, Integer> matierePremiereFabrication;
    public Produit(String nom, double prixVente, HashMap<MatierePremiere, Integer> matierePremiereFabrication){
        this.nom=nom;
        this.prixVente=prixVente;
        this.matierePremiereFabrication=matierePremiereFabrication;
    }
}
