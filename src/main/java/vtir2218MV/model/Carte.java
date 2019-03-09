package vtir2218MV.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carte {

    private String titlu;
    private List<String> referenti;
    private String anAparitie;
    private String editura;
    private List<String> cuvinteCheie;

    public Carte(){
        titlu = "";
        referenti = new ArrayList<String>();
        anAparitie = "";
        editura = "";
        cuvinteCheie = new ArrayList<String>();
    }

    public String getTitlu() { return titlu; }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public List<String> getReferenti() {
        return referenti;
    }

    public void setReferenti(List<String> ref) {
        this.referenti = ref;
    }

    public String getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(String anAparitie) {
        this.anAparitie = anAparitie;
    }

    public List<String> getCuvinteCheie() {
        return cuvinteCheie;
    }

    public void setCuvinteCheie(List<String> cuvinteCheie) {
        this.cuvinteCheie = cuvinteCheie;
    }

    public String getEditura(){return editura;}

    public void setEditura(String editura){this.editura=editura;}


    @Override
    public String toString(){
        String ref = "";
        String cuvCheie = "";

        for(int i=0;i<referenti.size();i++){
            if(i==referenti.size()-1)
                ref+=referenti.get(i);
            else
                ref+=referenti.get(i)+",";
        }

        for(int i=0;i<cuvinteCheie.size();i++){
            if(i==cuvinteCheie.size()-1)
                cuvCheie+=cuvinteCheie.get(i);
            else
                cuvCheie+=cuvinteCheie.get(i)+",";
        }

        return titlu+";"+ref+";"+anAparitie+";"+editura+";"+cuvCheie;
    }

    public static Carte getCarteFromString(String carte){
        Carte c = new Carte();
        String []atr = carte.split(";");
        String []referenti = atr[1].split(",");
        String []cuvCheie = atr[4].split(",");

        c.titlu=atr[0];
        c.referenti.addAll(Arrays.asList(referenti));
        c.anAparitie = atr[2];
        c.editura=atr[3];
        c.cuvinteCheie.addAll(Arrays.asList(cuvCheie));

        return c;
    }

}
