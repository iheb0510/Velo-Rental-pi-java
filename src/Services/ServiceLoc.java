/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Loc;
import Entities.Location;
import Entities.Produit;
import Entities.User;
import Utils.Mycnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceLoc {
      private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ServiceLoc() {
       cnx = Mycnx.getInstance().getCnx();
    }
    
    
     
     
     public List<Loc> afficheLocation() {

        List<Loc> listl = new ArrayList<>();

        try {

            String req = "SELECT * FROM location,fos_user,produit WHERE( produit.id = location.id_Produit AND location.id_client = fos_user.id AND produit.Disponible ='0')";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
               
                
                Loc l = new Loc();
                
             
                l.setTel(res.getInt("tel"));
                l.setUsername(res.getString("username"));
                l.setEmail(res.getString("email"));
                l.setRefp(res.getString("Ref_produit"));
                l.setId_loc(res.getInt("id_loc"));
                l.setId_Produit(res.getInt("id_Produit"));
                
                l.setId_client(res.getInt("id_client"));
                l.setMontant(res.getDouble("montant"));
                l.setStart_l(res.getDate("start_l"));
                l.setEnd_l(res.getDate("end_l"));
              
                listl.add(l);
            }
            
            System.out.println(listl);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listl;
    }

    
     
             
     public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM location WHERE id_loc="+id ; 
            Statement st=cnx.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("la location de l id = "+id+ " a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
    

public void Disponible(int id_produit) {

       

        
            
              LocalDate localDate = LocalDate.now();
              java.sql.Date datenow = java.sql.Date.valueOf(localDate.toString());
        
          String q ="UPDATE produit SET produit.Disponible='1'  WHERE (produit.id = '"+id_produit+"')" ;

                
                try {
                    st = cnx.createStatement();
                     st.executeUpdate(q) ;
                     System.out.println("Vélo disponible");
                } catch (SQLException ex) {
                   
                }
                
}
}