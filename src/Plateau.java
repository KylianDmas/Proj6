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
    private void rendLesCasesIntelligentes(){
        for(int cpt=0;cpt<this.nbColonnes*this.nbLignes;++cpt){
            CaseIntelligente val = new CaseIntelligente();
            this.lePlateau.add(val);
        }
    }


    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.percentBombe){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }
    public int getNbLignes(){
        return this.nbLignes;
    }
    public int getNbColonnes(){
        return this.nbColonnes;
    }
    public int getNbTotalBombes(){
        return this.nbBombes;
    }
    public Case getCase(int l, int c){
        return this.lePlateau.get(l*c);
    }
    public int getNbCasesMarquees(){
        int nb = 0;
        for(int cpt = 0; cpt < this.nbColonnes*this.nbLignes;++cpt){
            if(lePlateau.get(cpt).estMarque()){nb++;}}
        return nb;
    }

    public void poseBombe(int x, int y){
        this.getCase(x, y).poseBombe();}

    public void reset(){
        
    }
}