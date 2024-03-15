import java.util.List;

public class CaseIntelligente extends Case{
    private List<Case> lesVoisines;

    public CaseIntelligente(){
        super();
    }
    public void ajouteVoisine(Case uneCase){
        lesVoisines.add(uneCase);
    }
    public int nbBombesVoisines(){
        int res = 0;
        for(Case elt:lesVoisines){
            if(elt.contientBombe){res+=1;}}
        return res;
    }
    public String toString(){
        if(this.estDecouverte()==false && this.estMarque()==false){return " ";}
        else if(this.estMarque()){return "?";}
        else if(this.contientBombe()){return "@";}
        else{return String.valueOf(this.nbBombesVoisines());}}
}
