/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Utils.Mycnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceProduit {
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ServiceProduit() {
       cnx = Mycnx.getInstance().getCnx();
    }
    
     
     
     public List<Produit> afficheProduit() {

        List<Produit> listP = new ArrayList<>();

        try {

            String req = "SELECT * FROM produit";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Produit p = new Produit();

                p.setId(res.getInt("id"));
                p.setRef_produit(res.getString("Ref_produit"));
                p.setDesignation(res.getString("Designation"));
                p.setDescription(res.getString("Description"));
                p.setDisponible(res.getBoolean("Disponible"));
                p.setPrix(res.getDouble("Prix"));
                p.setImage(res.getString("image"));
                p.setStatut(res.getBoolean("Statut"));
                p.setId_Magasin(res.getInt("id_Magasin"));
                p.setPrix_heure(res.getDouble("prix_heure"));
                   
                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }

    
     public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM produit WHERE id="+id ; 
            Statement st=cnx.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("le produit de l id = "+id+ " a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
     
    
 public List<Produit> rechercheparmagasin(int id_magasin) {

       List<Produit> listP = new ArrayList<>();

        try {
            

            String req = "SELECT *from produit WHERE id_Magasin='"+id_magasin+"'AND Disponible='1'" ;

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Produit p = new Produit();

                p.setId(res.getInt("id"));
                p.setRef_produit(res.getString("Ref_produit"));
                p.setDesignation(res.getString("Designation"));
                p.setDescription(res.getString("Description"));
                p.setDisponible(res.getBoolean("Disponible"));
                p.setPrix(res.getDouble("Prix"));
                p.setImage(res.getString("image"));
                p.setStatut(res.getBoolean("Statut"));
                p.setId_Magasin(res.getInt("id_Magasin"));
                p.setPrix_heure(res.getDouble("prix_heure"));
                   
                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
      
 public Produit lectureProduitparref(String  nom)
             
{ 
    Produit p = new Produit();
    
    try { 
        
        
        
        
            String query ="SELECT * from produit WHERE Ref_produit='"+nom+"'" ; 
            
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
          int nbr =res.getRow() ;  
          if (nbr!=0)
          {
              
                p.setId(res.getInt("id"));
                p.setRef_produit(res.getString("Ref_produit"));
                p.setDesignation(res.getString("Designation"));
                p.setDescription(res.getString("Description"));
                p.setDisponible(res.getBoolean("Disponible"));
                p.setPrix(res.getDouble("Prix"));
                p.setImage(res.getString("image"));
                p.setStatut(res.getBoolean("Statut"));
                p.setId_Magasin(res.getInt("id_Magasin"));
                p.setPrix_heure(res.getDouble("prix_heure"));
                
             
          } else {
                  System.out.println("le produit est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
      
       return p;  
}
    
    
}
