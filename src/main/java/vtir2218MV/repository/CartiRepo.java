package vtir2218MV.repository;


import vtir2218MV.model.Carte;
import vtir2218MV.repository.repoInterfaces.CartiRepoInterface;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepo implements CartiRepoInterface {

    private String file = "cartiBD.dat";

    public CartiRepo(){
        URL location = CartiRepo.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
    }

    @Override
    public void adaugaCarte(Carte c) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(c.toString());
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Carte> getCarti() {
        List<Carte> lc = new ArrayList<Carte>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=br.readLine())!=null){
                lc.add(Carte.getCarteFromString(line));
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lc;
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
            if(flag == true){
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
        return cartiGasite;
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

                String autori1="";
                String autori2="";

                for(String aut:a.getReferenti()){
                    autori1=autori1+aut;
                }

                for(String aut:b.getReferenti()){
                    autori2=autori2+aut;
                }

                if(a.getTitlu().compareTo(b.getTitlu())==0){
                    return autori1.compareTo(autori2);
                }

                return a.getTitlu().compareTo(b.getTitlu());
            }

        });

        return lca;
    }

}
