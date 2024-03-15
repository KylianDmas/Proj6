import java.util.List;

public class Case {
    protected boolean contientBombe;
    protected boolean estDecouverte;
    protected boolean estMarque;
    private List<CaseIntelligente> lesVoisines;

    public Case(){
        this.contientBombe = false;
        this.estDecouverte = false;
        this.estMarque = false;
    }
    public void reset(){
        this.contientBombe = false;
        this.estDecouverte = false;
        this.estMarque = false;
    }
    public void poseBombe(){this.contientBombe = true;}

    public boolean contientBombe(){return this.contientBombe;}

    public boolean estDecouverte(){return this.estDecouverte;}

    public boolean estMarque(){return this.estMarque;}

    public boolean reveler(){return true;}

    public void marquer(){this.estMarque=true;}

}
