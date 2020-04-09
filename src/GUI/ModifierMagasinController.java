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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierMagasinController implements Initializable {

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
    @FXML
    private int a;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> listu  = FXCollections.observableArrayList();
     
        
         ServiceRegion sc = new ServiceRegion();
         for(Region c: sc.afficheRegion()) {
             listu.add(c.getNom());
            
         }
             cmb_region.setItems(listu);
        // TODO
    } 
    
     public void setNom(String tf_name) {
        this.nom.setText(tf_name);
    }
      public void setadresse(String tf_name) {
        this.adresse.setText(tf_name);
    }
       public void settel(int tel) {
           String str1 = Integer.toString(tel);
        this.tel.setText(str1);
    }
        public void setid_reg(int id_reg) {
            ServiceRegion sr = new ServiceRegion();
            Region R = sr.lectureRegion(id_reg);
        this.cmb_region.getSelectionModel().select(R.getNom());;
    }
    
    @FXML
    public void setid(int id) {
        this.a = id;
    }

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
        Magasin m = new Magasin();   
        m.setId(a);
           
          
        
        ServiceRegion sr = new ServiceRegion();
        Region R = sr.lectureRegionparnom((String) cmb_region.getValue());
        
        ServiceMagasin sc = new ServiceMagasin();
        int jml = Integer.parseInt(tel.getText());
        sc.modifierMagasin(m.getId(), nom.getText(),adresse.getText(),jml,R.getId_reg());
                
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
    
}
