package vtir2218MV.control;

import org.junit.Before;
import org.junit.Test;
import vtir2218MV.model.Carte;
import vtir2218MV.repository.CartiRepo;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {

    private BibliotecaCtrl cartiController;

    @Before
    public void setUp() throws Exception {
        CartiRepo repository=new CartiRepo();
        cartiController=new BibliotecaCtrl(repository);
    }

    @Test
    public void test1() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorUnu");
        autori.add("AutorDoi");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");
        cuvinte.add("nu");

        carte.setTitlu("Carte");
        carte.setReferenti(autori);
        carte.setAnAparitie("2013");
        carte.setEditura("EdituraUnu");
        carte.setCuvinteCheie(cuvinte);

        cartiController.adaugaCarte(carte);
        assertEquals(size+1, cartiController.getCarti().size());
    }

    @Test
    public void test2() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorTrei");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");
        cuvinte.add("sigur");
        cuvinte.add("poate");

        carte.setTitlu("Titlu2");
        carte.setReferenti(autori);
        carte.setAnAparitie("2000");
        carte.setEditura("EdituraDoi");
        carte.setCuvinteCheie(cuvinte);

        try{
            cartiController.adaugaCarte(carte);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(size, cartiController.getCarti().size());
    }

    @Test
    public void test3() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorPatru");
        autori.add("AutorCinci");
        autori.add("AutorSase");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");

        carte.setTitlu("Carticica");
        carte.setReferenti(autori);
        carte.setAnAparitie("201p");
        carte.setEditura("EdituraTrei");
        carte.setCuvinteCheie(cuvinte);

        try{
            cartiController.adaugaCarte(carte);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(size, cartiController.getCarti().size());
    }


    @Test
    public void test4() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorUnu");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");

        carte.setTitlu("");
        carte.setReferenti(autori);
        carte.setAnAparitie("2000");
        carte.setEditura("EdituraUnu");
        carte.setCuvinteCheie(cuvinte);

        try{
            cartiController.adaugaCarte(carte);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(size, cartiController.getCarti().size());
    }

    @Test
    public void test5() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorCinci");
        autori.add("AutorSase");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");
        cuvinte.add("nu");

        carte.setTitlu("Titlu Carte");
        carte.setReferenti(autori);
        carte.setAnAparitie("9");
        carte.setEditura("EdituraPatru");
        carte.setCuvinteCheie(cuvinte);

        cartiController.adaugaCarte(carte);
        assertEquals(size+1, cartiController.getCarti().size());
    }

    @Test
    public void test6() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorUnu");
        autori.add("AutorPatru");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("poate");

        carte.setTitlu("Carte foarte mare");
        carte.setReferenti(autori);
        carte.setAnAparitie("2009");
        carte.setEditura("EdituraTrei");
        carte.setCuvinteCheie(cuvinte);

        try {
            cartiController.adaugaCarte(carte);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(size, cartiController.getCarti().size());
    }

    @Test
    public void test7() throws Exception {
        Carte carte = new Carte();
        int size=cartiController.getCarti().size();

        ArrayList<String> autori = new ArrayList<>();
        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("poate");

        carte.setTitlu("Carte");
        carte.setReferenti(autori);
        carte.setAnAparitie("2009");
        carte.setEditura("EdituraTrei");
        carte.setCuvinteCheie(cuvinte);

        try {
            cartiController.adaugaCarte(carte);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(size+1, cartiController.getCarti().size());
    }

}