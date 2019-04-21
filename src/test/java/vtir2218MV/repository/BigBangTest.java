package vtir2218MV.repository;

import org.junit.Before;
import org.junit.Test;
import vtir2218MV.model.Carte;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BigBangTest {
    private CartiRepo cartiRepository;

    @Before
    public void setUp(){
        cartiRepository=new CartiRepo();
    }

    @Test
    public void testCreareCarte(){

        Carte carte = new Carte();
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

        assertEquals("Carte",carte.getTitlu());
        assertEquals(autori,carte.getReferenti());
        assertEquals("2013",carte.getAnAparitie());
        assertEquals("EdituraUnu",carte.getEditura());
        assertEquals(cuvinte,carte.getCuvinteCheie());
    }

    @Test
    public void testAdaugaCarte(){
        Carte carte = new Carte();
        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorUnu");
        autori.add("AutorDoi");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");
        cuvinte.add("nu");

        carte.setTitlu("Carte pierduta");
        carte.setReferenti(autori);
        carte.setAnAparitie("2013");
        carte.setEditura("EdituraUnu");
        carte.setCuvinteCheie(cuvinte);

        int size=cartiRepository.getCarti().size();
        cartiRepository.adaugaCarte(carte);
        assertEquals(size+1,cartiRepository.getCarti().size());
    }

    @Test
    public void testOrdonare(){
        List<Carte> cartiOrdonate = cartiRepository.getCartiOrdonateDinAnul("2000");
        assertEquals(4,cartiOrdonate.size());

        int ok=1;
        for(int i=0;i<cartiOrdonate.size()-1;i++){
            ok=1;
            Carte c1=cartiOrdonate.get(i);
            Carte c2=cartiOrdonate.get(i+1);

            if(c1.getTitlu().charAt(0)>c2.getTitlu().charAt(0)){
                ok=0;
                break;
            }

            if(c1.getTitlu().equals(c2.getTitlu())){
                List<String> autori1=c1.getReferenti();
                List<String> autori2=c2.getReferenti();

                String autor1 = autori1.get(0);
                String autor2 =autori2.get(0);

                if(autor1.charAt(0)>autor2.charAt(0)){
                    System.out.println("intra");
                    ok=0;
                    break;
                }
            }
        }

        assertEquals(ok,1);
    }

    @Test
    public void testIntegrare(){
        Carte carte = new Carte();
        ArrayList<String> autori = new ArrayList<>();
        autori.add("AutorUnu");
        autori.add("AutorDoi");

        ArrayList<String> cuvinte = new ArrayList<>();
        cuvinte.add("da");
        cuvinte.add("nu");

        carte.setTitlu("Carte");
        carte.setReferenti(autori);
        carte.setAnAparitie("2000");
        carte.setEditura("EdituraUnu");
        carte.setCuvinteCheie(cuvinte);

        assertEquals("Carte",carte.getTitlu());
        assertEquals(autori,carte.getReferenti());
        assertEquals("2000",carte.getAnAparitie());
        assertEquals("EdituraUnu",carte.getEditura());
        assertEquals(cuvinte,carte.getCuvinteCheie());

        int size=cartiRepository.getCarti().size();
        cartiRepository.adaugaCarte(carte);
        assertEquals(size+1,cartiRepository.getCarti().size());

        List<Carte> cartiOrdonate = cartiRepository.getCartiOrdonateDinAnul("2000");
        assertEquals(4,cartiOrdonate.size());

        int ok=1;
        for(int i=0;i<cartiOrdonate.size()-1;i++){
            ok=1;
            Carte c1=cartiOrdonate.get(i);
            Carte c2=cartiOrdonate.get(i+1);

            if(c1.getTitlu().charAt(0)>c2.getTitlu().charAt(0)){
                ok=0;
                break;
            }

            if(c1.getTitlu().equals(c2.getTitlu())){
                List<String> autori1=c1.getReferenti();
                List<String> autori2=c2.getReferenti();

                String autor1 = autori1.get(0);
                String autor2 =autori2.get(0);

                if(autor1.charAt(0)>autor2.charAt(0)){
                    System.out.println("intra");
                    ok=0;
                    break;
                }
            }
        }

        assertEquals(ok,1);
    }

}
