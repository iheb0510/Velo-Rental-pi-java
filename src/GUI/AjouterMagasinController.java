/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Magasin;
import Entities.Region;
import Services.ServiceMagasin;
import Services.ServiceRegion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterMagasinController implements Initializable {

    @FXML
    private Button btn_annuler;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField tel;
    @FXML
    private ComboBox<String> cmb_region;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> listu  = FXCollections.observableArrayList();
     
        
         ServiceRegion sc = new ServiceRegion();
         for(Region c: sc.afficheRegion()) {
             listu.add(c.getNom());
            
         }
             cmb_region.setItems(listu);
         }
    

         //mettre les données dans la table view:    
         
        
         
        //load dummy data
          
        // TODO
       

    @FXML
    private void close(ActionEvent event) {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherMagasin.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void ajoutermagasin(ActionEvent event) {
        if(nom.getText().length() >0 && adresse.getText().length()>0 && tel.getText().length() >0 ) {
        ServiceRegion sr = new ServiceRegion();
        Region R = sr.lectureRegionparnom(cmb_region.getValue());
        System.out.println(R.getId_reg());
        int jml = Integer.parseInt(tel.getText());
        Magasin a = new Magasin(nom.getText(),adresse.getText(),jml,R.getId_reg());
        ServiceMagasin ma = new ServiceMagasin();
       
       
        ma.ajouuterMagasin(a);
        
    }else{
          Alert s = new Alert(Alert.AlertType.INFORMATION);
          s.setTitle("information");
          s.setContentText("champ vide");
          s.showAndWait();
       }  
    
    }
}