/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Loc;
import Entities.Magasin;
import Entities.User;
import Services.MailUtils;
import Services.ServiceLoc;
import Services.ServiceMagasin;
import com.jfoenix.controls.JFXButton;
import com.teknikindustries.bulksms.SMS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherlocationController implements Initializable {

    @FXML
    private JFXButton btn_acceuil;
    @FXML
    private JFXButton btn_region;
    @FXML
    private Button btn_supprimer;
    @FXML
    private TableView<Loc> table;
    @FXML
    private TableColumn<Loc, User> t_user;
    @FXML
    private TableColumn<?, ?> t_debut;
    @FXML
    private TableColumn<?, ?> t_fin;
   
    @FXML
    private TableColumn<?, ?> t_velo;
    @FXML
    private Button btn_retour;
    @FXML
    private TableColumn<?, ?> t_email;
    @FXML
    private JFXButton btn_magasin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<Loc> listu  = FXCollections.observableArrayList();
     
        
         ServiceLoc sc = new ServiceLoc();
         for(Loc c: sc.afficheLocation()) {
             listu.add(c);
         }
    
         
         //mettre les données dans la table view:   
         t_email.setCellValueFactory(new PropertyValueFactory<>("email"));
         t_user.setCellValueFactory(new PropertyValueFactory<>("username"));
         t_debut.setCellValueFactory(new PropertyValueFactory<>("start_l"));
         t_fin.setCellValueFactory(new PropertyValueFactory<>("end_l"));
         t_velo.setCellValueFactory(new PropertyValueFactory<>("refp"));
        
         
         
         
         
        //load dummy data
        table.setItems(listu);
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
        } else if (event.getSource() == btn_magasin) {
            try {
            javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("/GUI/AfficherMagasin.fxml"));
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

    @FXML
    private void SupprimerRegion(ActionEvent event) throws IOException, Exception {
        ObservableList<Loc> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(Loc c:SelectedRows){
       
   
      
       
      MailUtils.sendMail(c.getEmail(), "tu dépasse la date fin de retour du velo "+c.getRefp());
  }
       
    }
        
        
    

    @FXML
    private void Retourvelo(ActionEvent event) {
         ObservableList<Loc> SelectedRows, allpeople;
     
     allpeople = table.getItems();
     // il donne les ligne qui vous avez déja séléctionner
     SelectedRows =table.getSelectionModel().getSelectedItems();
     
     for(Loc c:SelectedRows){
       allpeople.remove(c);
       ServiceLoc sc = new ServiceLoc();
       sc.Disponible(c.getId_Produit());
       sc.supprimerparID(c.getId_loc());
    }
        
    }
    
}
