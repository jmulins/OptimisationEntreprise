public class Cours {
    public double prixPoulet;
    public double prixPorc;
    public double prixCanard;
    public double prixPlastique;
    public double prixFer;
    public Cours(double prixPorc, double prixPoulet, double prixCanard, double prixPlastique, double prixFer){
        this.prixCanard=prixCanard;
        this.prixPoulet=prixPoulet;
        this.prixPorc=prixPorc;
        this.prixPlastique=prixPlastique;
        this.prixFer=prixFer;
    }
    public void ActualiseCours(double prixPorc, double prixPoulet, double prixCanard, double prixPlastique, double prixFer){
        this.prixCanard=prixCanard;
        this.prixPoulet=prixPoulet;
        this.prixPorc=prixPorc;
        this.prixPlastique=prixPlastique;
        this.prixFer=prixFer;
    }
}
