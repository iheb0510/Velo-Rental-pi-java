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
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherMagasinController implements Initializable {

    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TableView<Magasin> table;
    @FXML
    private TableColumn<?, ?> t_nom;
    @FXML
    private TableColumn<?, ?> t_adresse;
    @FXML
    private TableColumn<?, ?> t_telephone;
    @FXML
    private TableColumn<?, ?> t_region;
    @FXML
    private JFXButton btn_acceuil;
    @FXML
    private JFXButton btn_region;
    @FXML
    private JFXButton btn_location;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Magasin> listu  = FXCollections.observableArrayList();
     
        
         ServiceMagasin sc = new ServiceMagasin();
         for(Magasin c: sc.afficheMagasin()) {
             listu.add(c);
         }
    

         //mettre les données dans la table view:    
         t_nom.setCellValueFactory(new PropertyValueFactory<>("name_M"));
         t_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         t_telephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        
         
         
         t_region.setCellValueFactory(new PropertyValueFactory<>("id_region"));
         
        //load dummy data
        table.setItems(listu);
        // TODO
    }    

    @FXML
    private void SupprimerRegion(ActionEvent event) {
          ObservableList<Magasin> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(Magasin c:SelectedRows){
       allpeople.remove(c);
       ServiceMagasin sc = new ServiceMagasin();
       sc.supprimerparID(c.getId());
    }
    }

    @FXML
    private void ModifierRegion(ActionEvent event) throws IOException {
        
         Magasin M = table.getSelectionModel().getSelectedItem();
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierMagasin.fxml"));
            Parent root = loader.load();
           ModifierMagasinController scene2Controller = loader.getController();
               
            //Get controller of scene2
            //Pass whatever data you want. You can have multiple method calls here
//                        scene2Controller.setSort_id(s.getSort_id()+"");
              scene2Controller.setNom(M.getName_M());
              scene2Controller.setadresse(M.getAdresse());
              scene2Controller.settel(M.getTel());
              scene2Controller.setid_reg(M.getId_region());
              scene2Controller.setid(M.getId());
                Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hello World");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void ajouterregion(ActionEvent event) {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("Ajoutermagasin.fxml"));
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
        
             if ((event.getSource() == btn_region) ) {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherRegion.fxml"));
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
