package vtir2218MV.repository;

import org.junit.Before;
import org.junit.Test;
import vtir2218MV.model.Carte;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartiRepoTest {

    private CartiRepo cartiRepository;

    @Before
    public void setUp(){
        cartiRepository=new CartiRepo();
    }

    @Test
    public void getCartiByEditura1() {
        try{
            List<Carte> carti = cartiRepository.getCartiByEditura("","cartiBD.dat");
            assertEquals(carti.size(),0);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void getCartiByEditura2() {
        try{
            List<Carte> carti = cartiRepository.getCartiByEditura("Litera","cartiBD.dat");
            assertEquals(carti.size(),8);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void getCartiByEditura3() {
        try{
            List<Carte> carti = cartiRepository.getCartiByEditura("Litera","cartiBD0.dat");
            assertEquals(carti.size(),0);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void getCartiByEditura4() {
        try{
            List<Carte> carti = cartiRepository.getCartiByEditura("Litera","cartiBD1.dat");
            assertEquals(carti.size(),0);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void getCartiByEditura5() {
        try{
            List<Carte> carti = cartiRepository.getCartiByEditura("Litera","cartiBD2.dat");
            assertEquals(carti.size(),1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}