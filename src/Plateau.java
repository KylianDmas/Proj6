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
            this.lePlateau.add(cpt, val);
        }
    }
    private void rendLesCasesIntelligentes(){
        for(int cpt=0;cpt<this.nbColonnes*this.nbLignes;++cpt){
            Case asec = lePlateau.get(cpt);
            CaseIntelligente casei = new CaseIntelligente();
            casei.contientBombe = asec.contientBombe;
            casei.estDecouverte = asec.estDecouverte;
            casei.estMarque = asec.estMarque;

            for(int i=0; i<this.nbLignes;i++){
                for(int j=0; j<this.nbColonnes;j++){
                    if(this.estVoisine(i-1, j-1)){casei.ajouteVoisine(getCase(i-1, j-1));}
                    if(this.estVoisine(i-1, j)){casei.ajouteVoisine(getCase(i-1, j));}
                    if(this.estVoisine(i-1, j+1)){casei.ajouteVoisine(getCase(i-1, j+1));}
                    if(this.estVoisine(i, j-1)){casei.ajouteVoisine(getCase(i, j-1));}
                    if(this.estVoisine(i, j+1)){casei.ajouteVoisine(getCase(i, j+1));}
                    if(this.estVoisine(i+1, j-1)){casei.ajouteVoisine(getCase(i+1, j-1));}
                    if(this.estVoisine(i+1, j)){casei.ajouteVoisine(getCase(i+1, j));}
                    if(this.estVoisine(i+1, j+1)){casei.ajouteVoisine(getCase(i+1, j+1));}
                }
            }
            this.lePlateau.add(cpt, casei);
        }
    }

    public boolean estVoisine(int i, int j){
        if(i>nbLignes || j>nbColonnes){return false;}
        return true;
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
        creerLesCasesVides();
    }
}