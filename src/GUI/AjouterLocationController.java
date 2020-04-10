/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Location;
import Entities.Magasin;
import Entities.Produit;
import Entities.Region;
import Services.ServiceLocation;
import Services.ServiceMagasin;
import Services.ServiceProduit;
import Services.ServiceRegion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;


import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterLocationController implements Initializable {

    @FXML
    private JFXButton btn_acceuil;
    @FXML
    private JFXButton btn_location;
    @FXML
    private JFXComboBox<String> cmb_region;
    @FXML
    private JFXComboBox<String> cmb_magasin;
    @FXML
    private JFXComboBox<String> cmb_velo;
    @FXML
    private Button btn_ajouter;
    @FXML
    private DatePicker start_l;
    @FXML
    private DatePicker end_l;
    @FXML
    private JFXTextField Montant;  
    @FXML
    private JFXTextField prix_h;
    
    ServiceRegion sc = new ServiceRegion();
     ServiceMagasin sm = new ServiceMagasin();
     ServiceProduit sp = new ServiceProduit();
      ServiceLocation sl = new ServiceLocation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> listu  = FXCollections.observableArrayList();
     
        
        
         for(Region c: sc.afficheRegion()) {
             listu.add(c.getNom());
            
         }
             cmb_region.setItems(listu);
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_acceuil) {
           try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("/GUI/Backend.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
    }

    
    @FXML
    private void choisirregion(ActionEvent event) {
        
        ObservableList<String> listu  = FXCollections.observableArrayList();
     
        Region R = sc.lectureRegionparnom(cmb_region.getValue());
         
         for(Magasin M: sm.rechercheparregion(R.getId_reg())) {
             listu.add(M.getName_M());
            
         }
             cmb_magasin.setItems(listu); 
        
    }

    @FXML
    private void choisirMgasin(ActionEvent event) {
        
         ObservableList<String> listu  = FXCollections.observableArrayList();
     
        Magasin R = sm.lectureMagasinparnom(cmb_magasin.getValue());
        System.out.println(R);
         
         for(Produit M: sp.rechercheparmagasin(R.getId())) {
             listu.add(M.getRef_produit());
            
         }
             cmb_velo.setItems(listu); 
    }

    @FXML
    private void choisirvelo(ActionEvent event) {
    }


    @FXML
    private void datedebut(ActionEvent event) {
       if((start_l.getValue().toString()!= "") && (end_l.getValue().toString()!= "")){
        Date date1 = Date.valueOf(start_l.getValue().toString());
        Date date2 = Date.valueOf(end_l.getValue().toString());
        double diffheure = sl.difference(date1, date2);
           if(diffheure>0){
               Produit R = sp.lectureProduitparref(cmb_velo.getValue());
               double calcul = sl.calculprixloc(R.getId(), diffheure);
               String str = Double.toString(calcul);
               String str2 = Double.toString(R.getPrix_heure());
                Montant.setText(str);
                prix_h.setText(str2);
               
    }
    }
    }
    @FXML
    private void datefin(ActionEvent event) {
        if((start_l.getValue().toString()!= "") && (end_l.getValue().toString()!= "")){
        Date date1 = Date.valueOf(start_l.getValue().toString());
        Date date2 = Date.valueOf(end_l.getValue().toString());
        double diffheure = sl.difference(date1, date2);
           if(diffheure>0){
               Produit R = sp.lectureProduitparref(cmb_velo.getValue());
               double calcul = sl.calculprixloc(R.getId(), diffheure);
              String str = Double.toString(calcul);
               String str2 = Double.toString(R.getPrix_heure());
                Montant.setText(str);
                prix_h.setText(str2);
               
    }
    }
    }

    @FXML
    private void louervelo(ActionEvent event) {
        
        
        if(cmb_velo.getValue()!= null){
        Produit R = sp.lectureProduitparref(cmb_velo.getValue());
        ZoneId defaultZoneId = ZoneId.systemDefault();
         if((start_l.getValue()!= null) && (end_l.getValue()!= null)){
        Date date1 = Date.valueOf(start_l.getValue().toString());
        Date date2 = Date.valueOf(end_l.getValue().toString());
        double diffheure = sl.difference(date1, date2);
        LocalDate localDate = LocalDate.now();
        Date datenow = Date.valueOf(localDate.toString());
           if((diffheure>0) && (date1.compareTo(datenow)>0)){
        Location k = new Location(date1,date2,R.getId(),4);
       
        sl.ajouterlocation2(k);
        Image img = new Image("Images/success.png");
        Notifications notificationbuilder = Notifications.create()
                   .title("ajouter location'")
                   .text("ajout réussie")
                   .graphic(new ImageView (img) )
                   .hideAfter(Duration.seconds(5))
                   .position(Pos.BOTTOM_RIGHT)
                   .onAction(new EventHandler<ActionEvent> (){
                      @Override 
                       public void handle(ActionEvent event){
                         System.out.println("clicked on notification");
                       }
                       
                   });
                 notificationbuilder.darkStyle();
                notificationbuilder.showConfirm();
                   
        
    }else{ Alert s = new Alert(Alert.AlertType.INFORMATION);
          s.setTitle("information");
          s.setContentText("erreur date");
          s.showAndWait();
               
           }
    }else{
             Alert s = new Alert(Alert.AlertType.INFORMATION);
          s.setTitle("information");
          s.setContentText("champ date vide");
          s.showAndWait();
         }
    }else{

    
    Alert s = new Alert(Alert.AlertType.INFORMATION);
          s.setTitle("information");
          s.setContentText("champ vide");
          s.showAndWait();
}
}
}