import java.lang.reflect.Array;
import java.util.HashMap;

public class Produit {
    public String nom;
    public double prixVente;
    public HashMap<MatierePremiere, Integer> matierePremiereFabrication;
    public HashMap<MatiereIntermediaire, Integer> matiereIntermediaireFabrication;

    public Produit(String nom, double prixVente, HashMap<MatierePremiere, Integer> matierePremiereFabrication, HashMap<MatiereIntermediaire, Integer> matiereIntermediaireFabrication){
        this.nom=nom;
        this.prixVente=prixVente;
        this.matierePremiereFabrication=matierePremiereFabrication;
        this.matiereIntermediaireFabrication=matiereIntermediaireFabrication;

    }
}
