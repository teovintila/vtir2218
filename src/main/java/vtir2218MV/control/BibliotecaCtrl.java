package vtir2218MV.control;


import vtir2218MV.model.Carte;
import vtir2218MV.repository.repoInterfaces.CartiRepoInterface;
import vtir2218MV.util.Validator;

import java.util.List;

public class BibliotecaCtrl {

    private CartiRepoInterface cr;

    public BibliotecaCtrl(CartiRepoInterface cr){
        this.cr = cr;
    }

    public void adaugaCarte(Carte c) throws Exception{
        Validator.validateCarte(c);
        cr.adaugaCarte(c);
    }

    public List<Carte> cautaCarte(String autor) throws Exception{
        Validator.isStringOK(autor);
        return cr.cautaCarte(autor);
    }

    public List<Carte> getCarti() throws Exception{
        return cr.getCarti();
    }

    public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
        if(!Validator.isNumber(an))
            throw new Exception("Nu e numar!");
        return cr.getCartiOrdonateDinAnul(an);
    }

    public List<Carte> getCartiByEditura(String editura,String fisier) throws Exception {
        return cr.getCartiByEditura(editura,"cartiBD.dat");
    }


}
