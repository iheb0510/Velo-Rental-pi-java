/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Region;
import Services.ServiceRegion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierRegionController implements Initializable {

    @FXML
    private Button btn_annuler;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private TextField nom;
    
    private int a ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    } 
    @FXML
    public void setNom(String tf_name) {
        this.nom.setText(tf_name);
    }
    
    @FXML
    public void setid_reg(int id_reg) {
        this.a = id_reg;
    }
    @FXML
   

    
    private void close(ActionEvent event) {
        try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherRegion.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterregion(ActionEvent event) {
         if(nom.getText().length() >0 ) {
         Region c = new Region();   
        c.setId_reg(a);
           
          
        
        
        ServiceRegion sc = new ServiceRegion();
        sc.modifierRegion(c.getId_reg(), nom.getText());
                
        try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherRegion.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }else{
          Alert s = new Alert(Alert.AlertType.INFORMATION);
          s.setTitle("information");
          s.setContentText("champ vide");
          s.showAndWait();
       }  
        
    
    }   
}
