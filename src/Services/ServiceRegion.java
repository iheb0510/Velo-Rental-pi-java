/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Region;
import Utils.Mycnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceRegion {
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ServiceRegion() {
       cnx = Mycnx.getInstance().getCnx();
    }
    
     public void ajouuterRegion(Region R) {

        try {
            String req = "INSERT INTO region (nom) VALUES (?)";

            pre = cnx.prepareStatement(req);

            pre.setString(1, R.getNom());
           

            pre.executeUpdate();

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
     
     public List<Region> afficheRegion() {

        List<Region> listP = new ArrayList<>();

        try {

            String req = "SELECT * FROM region";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Region p = new Region();

                p.setId_reg(res.getInt("id_reg"));
                p.setNom(res.getString("nom"));
                

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
            String query ="DElETE FROM region WHERE id_reg="+id ; 
            Statement st=cnx.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("la region de l id = "+id+ "a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
     
     public void modifierRegion(  int id , String nom  )
{ 
    try {
     String query ="UPDATE region SET nom='"+nom+"' WHERE id_reg='"+id+"'" ;
     
  
     Statement st=cnx.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Region bien modifiée");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }

    
    
}
     
     
  public Region lectureRegion( int id_region)
             
{ 
        Region p = new Region();
    try { 
            String query ="SELECT * from region WHERE id_reg='"+id_region+"'" ; 
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
          int nbr =res.getRow() ;  
          if (nbr!=0)
          {
              
                p.setId_reg(res.getInt("id_reg"));
                p.setNom(res.getString("nom"));
                
                   
          } else {
                  System.out.println("la reservation est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
      return p;
}
  public boolean chercherregionparnom( String nom)
        
{  
    try { 
                
            String query ="SELECT * from region WHERE nom='"+nom+"'"  ; 
            Statement st=cnx.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  return true ; 
       
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
 return false;
}
  
  public Region lectureRegionparnom( String nom)
             
{ 
        Region p = new Region();
    try { 
            String query ="SELECT * from region WHERE nom='"+nom+"'" ; 
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
          int nbr =res.getRow() ;  
          if (nbr!=0)
          {
              
                p.setId_reg(res.getInt("id_reg"));
                p.setNom(res.getString("nom"));
                
                   
          } else {
                  System.out.println("la reservation est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
      return p;
}


}
