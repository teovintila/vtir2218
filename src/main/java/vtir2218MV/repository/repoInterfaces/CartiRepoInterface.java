package vtir2218MV.repository.repoInterfaces;


import vtir2218MV.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
    void adaugaCarte(Carte c);
    List<Carte> cautaCarte(String ref);
    List<Carte> getCarti();
    List<Carte> getCartiOrdonateDinAnul(String an);
    List<Carte> getCartiByEditura(String editura,String fisier) throws Exception;
    List<Carte> loadCarti(String fisier);
}
