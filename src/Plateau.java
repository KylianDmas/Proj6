import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau{
    protected int nbLignes;
    protected int nbColonnes;
    protected int percentBombe;
    protected int nbBombes;
    private List<Case> lePlateau;

    public Plateau(int nbLigne, int nbColonne, int pourcent){
        this.nbLignes = nbLigne;
        this.nbColonnes = nbColonne;
        this.percentBombe = pourcent;
    }

    private void creerLesCasesVides(){
        for(int cpt=0;cpt<this.nbColonnes*this.nbLignes;++cpt){
            Case val = new Case();
            this.lePlateau.add(val);
        }
    }

    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }

}
