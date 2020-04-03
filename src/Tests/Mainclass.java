/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Entities.Location;
import Entities.Magasin;
import Entities.Region;
import Services.ServiceLocation;
import Services.ServiceMagasin;
import Services.ServiceProduit;
import Services.ServiceRegion;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceMagasin m = new ServiceMagasin();
        ServiceLocation h= new ServiceLocation();
       
       String start = "2021-03-31";
       String end = "2022-03-31";
      Date date1 = Date.valueOf(start);
      Date date2 = Date.valueOf(end);
      Location lo = new Location(date1,date2,555555,2,4);
      ServiceMagasin a = new ServiceMagasin();
    
      Magasin k = a.lectureMagasin(6);
      System.out.println(k.getAdresse());
      //L.ajouterLocation(lo);
      ServiceRegion  sreg = new ServiceRegion();
      Region REG = sreg.lectureRegion(6);
      System.out.println(REG.getNom());
      
      m.afficheMagasin();
      
     Location y = new Location(date1,date2,2,4);
     
     a.rechercheparregion(10);
     ServiceProduit lh = new ServiceProduit();
     lh.rechercheparmagasin(2);
    
     h.afficheLocation();
     a.rechercheparregion(6);
     a.afficheMagasin();
     h.ajouterlocation2(y);
     sreg.afficheRegion();
    }
    
}
