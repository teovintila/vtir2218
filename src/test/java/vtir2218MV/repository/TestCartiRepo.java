package vtir2218MV.repository;

import org.junit.Before;
import org.junit.Test;
import vtir2218MV.model.Carte;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestCartiRepo {

    private CartiRepo cartiRepository;

    @Before
    public void setUp(){
        cartiRepository=new CartiRepo();
    }

    @Test
    public void testValid(){
        int sizeBefore=cartiRepository.getCarti().size();
        List<Carte> cartiOrdonate=cartiRepository.getCartiOrdonateDinAnul("2000");
        int sizeAfter=cartiRepository.getCarti().size();

        assertEquals(sizeBefore,sizeAfter);
        assertEquals(cartiOrdonate.size(),4);

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
    public void testInvalid(){
        int sizeBefore=cartiRepository.getCarti().size();
        List<Carte> cartiOrdonate=cartiRepository.getCartiOrdonateDinAnul("0000");
        int sizeAfter=cartiRepository.getCarti().size();

        assertEquals(sizeBefore,sizeAfter);
        assertEquals(cartiOrdonate.size(),0);
    }


}