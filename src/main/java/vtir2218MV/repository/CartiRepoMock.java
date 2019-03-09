package vtir2218MV.repository;


import vtir2218MV.model.Carte;
import vtir2218MV.repository.repoInterfaces.CartiRepoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepoMock implements CartiRepoInterface {

    private List<Carte> carti;

    public CartiRepoMock(){
        carti = new ArrayList<Carte>();

        carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
        carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
        carti.add(Carte.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
        carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
        carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));

    }

    @Override
    public void adaugaCarte(Carte c) {
        carti.add(c);
    }

    @Override
    public List<Carte> cautaCarte(String ref) {
        List<Carte> carti = getCarti();
        List<Carte> cartiGasite = new ArrayList<Carte>();
        int i=0;
        while (i<carti.size()){
            boolean flag = false;
            List<String> lref = carti.get(i).getReferenti();
            int j = 0;
            while(j<lref.size()){
                if(lref.get(j).toLowerCase().contains(ref.toLowerCase())){
                    flag = true;
                    break;
                }
                j++;
            }
            if(flag){
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
        return cartiGasite;
    }

    @Override
    public List<Carte> getCarti() {
        return carti;
    }

    @Override
    public List<Carte> getCartiOrdonateDinAnul(String an) {
        List<Carte> lc = getCarti();
        List<Carte> lca = new ArrayList<Carte>();
        for(Carte c:lc){
            if(c.getAnAparitie().equals(an)){
                lca.add(c);
            }
        }

        Collections.sort(lca,new Comparator<Carte>(){

            @Override
            public int compare(Carte a, Carte b) {
                if(a.getTitlu().compareTo(b.getTitlu())==0){
                    return a.getReferenti().get(0).compareTo(b.getReferenti().get(0));
                }

                return a.getTitlu().compareTo(b.getTitlu());
            }

        });

        return lca;
    }

}
