/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevv;

import Entities.Location;
import Entities.Magasin;
import Entities.Region;
import GUI.AjouterRegionController;
import Services.ServiceLocation;
import Services.ServiceMagasin;
import Services.ServiceProduit;
import Services.ServiceRegion;
import java.io.IOException;
import java.sql.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Pidevv extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Backend.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("T-HUNT");
            stage.setScene(scene);
            stage.show();
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          launch (args);
          
        // TODO code application logic here
        
    }
    }

    /**
     * @param args the command line arguments
     */
   /** public static void main(String[] args) {
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
      Region r= new Region("gabes");
      m.afficheMagasin();
      
     Location y = new Location(date1,date2,2,4);
     
     a.rechercheparregion(10);
     ServiceProduit lh = new ServiceProduit();
     lh.rechercheparmagasin(2);
    
     h.afficheLocation();
     a.rechercheparregion(6);
     a.afficheMagasin();
    
     sreg.afficheRegion();
    
     
    }
    }
    */

