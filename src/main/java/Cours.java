import java.util.HashMap;

public class Cours {
    public double prixPoulet;
    public double prixPorc;
    public double prixCanard;
    public double prixPlastique;
    public double prixFer;
    public static HashMap<String, Double> prixMp = new HashMap<String, Double>();
    public Cours(double prixPorc, double prixPoulet, double prixCanard, double prixPlastique, double prixFer){
        this.prixCanard=prixCanard;
        this.prixPoulet=prixPoulet;
        this.prixPorc=prixPorc;
        this.prixPlastique=prixPlastique;
        this.prixFer=prixFer;
        prixMp.put("PORC", prixPorc);
        prixMp.put("CANARD", prixCanard);
        prixMp.put("POULET", prixPoulet);
        prixMp.put("PLASTIQUE", prixPlastique);
        prixMp.put("FER", prixFer);

    }
    public void ActualiseCours(double prixPorc, double prixPoulet, double prixCanard, double prixPlastique, double prixFer){
        this.prixCanard=prixCanard;
        this.prixPoulet=prixPoulet;
        this.prixPorc=prixPorc;
        this.prixPlastique=prixPlastique;
        this.prixFer=prixFer;
        prixMp.put("PORC", prixPorc);
        prixMp.put("CANARD", prixCanard);
        prixMp.put("POULET", prixPoulet);
        prixMp.put("PLASTIQUE", prixPlastique);
        prixMp.put("FER", prixFer);

    }
}