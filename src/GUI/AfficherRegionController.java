/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Region;
import Services.ServiceRegion;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherRegionController implements Initializable {

    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TableColumn<?, ?> t_nom;
    @FXML
    private TableView<Region> table;
    @FXML
    private JFXButton btn_acceuil;
    @FXML
    private JFXButton btn_location;
    @FXML
    private JFXButton btn_magasin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<Region> listu  = FXCollections.observableArrayList();
     
        
         ServiceRegion sc = new ServiceRegion();
         for(Region c: sc.afficheRegion()) {
             listu.add(c);
         }
    

         //mettre les données dans la table view:    
         t_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
         
        //load dummy data
        table.setItems(listu);
        // TODO
    }    

    @FXML
    private void SupprimerRegion(ActionEvent event) {
        
        ObservableList<Region> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(Region c:SelectedRows){
       allpeople.remove(c);
       ServiceRegion sc = new ServiceRegion();
       sc.supprimerparID(c.getId_reg());
    }
    }

    @FXML
    private void ModifierRegion(ActionEvent event) throws IOException {
        Region c = table.getSelectionModel().getSelectedItem();
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierRegion.fxml"));
            Parent root = loader.load();
           ModifierRegionController scene2Controller = loader.getController();
               
            //Get controller of scene2
            //Pass whatever data you want. You can have multiple method calls here
//                        scene2Controller.setSort_id(s.getSort_id()+"");
              scene2Controller.setNom(c.getNom());
              scene2Controller.setid_reg(c.getId_reg());

                Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hello World");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void ajouterregion(ActionEvent event) {
        try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AjouterRegion.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
      @FXML
    private void handleButtonAction(ActionEvent event) {
        
             if ((event.getSource() == btn_magasin) ) {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherMagasin.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        } else if (event.getSource() == btn_location) {
            try {
            javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("/GUI/AjouterLocation.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
        } else if (event.getSource() == btn_acceuil) {
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
    
}
