/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Location;
import Utils.Mycnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceLocation {
    
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ServiceLocation() {
       cnx = Mycnx.getInstance().getCnx();
    }
    
     public void ajouterLocation(Location L) {

        try {
            String req = "INSERT INTO location (id_Produit,id_client,montant,start_l,end_l) VALUES (?,?,?,?,?)";

            pre = cnx.prepareStatement(req);

            pre.setInt(1, L.getId_Produit());
            pre.setInt(2, L.getId_client());
            pre.setDouble(3,L.getMontant());
            pre.setDate(4, (java.sql.Date) (Date) L.getStart_l());
            pre.setDate(5, (java.sql.Date) (Date) L.getEnd_l());
           

            pre.executeUpdate();

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
     
     public void ajouterlocation2( Location L){
            double diff =0;
            double prix_location = 0;  
            
          try {
            
            diff = difference(L.getStart_l(),L.getEnd_l());
              prix_location = calculprixloc(L.getId_Produit(), diff);
            System.out.println(prix_location);
            String req = "INSERT INTO location (id_Produit,id_client,montant,start_l,end_l) VALUES (?,?,?,?,?)";

            pre = cnx.prepareStatement(req);

            pre.setInt(1, L.getId_Produit());
            pre.setInt(2, L.getId_client());
            pre.setDouble(3,prix_location);
            pre.setDate(4, (java.sql.Date) (java.util.Date) L.getStart_l());
            pre.setDate(5, (java.sql.Date) (java.util.Date) L.getEnd_l());
           


            pre.executeUpdate();

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
         
             
     }
     
     
     
     public List<Location> afficheLocation() {

        List<Location> listl = new ArrayList<>();

        try {

            String req = "SELECT * FROM location";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Location l = new Location();

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
     
     public void modifierLocation( int id,  Date start ,Date end, int id_produit, int id_client )
{ 
            double diff =0;
            double prix_location = 0;  
            
          try {
            
            diff = difference(start,end);
              prix_location = calculprixloc(id_produit, diff);
            System.out.println(prix_location);
     String query ="UPDATE location SET id_Produit='"+id_produit+"',id_client='"+id_client+"',montant='"+prix_location+"',start_l='"+start+"',end_l='"+end+"' WHERE id_loc='"+id+"'" ;
     
  
     Statement st=cnx.createStatement();
      st.executeUpdate(query) ;
      System.out.println("location  bien modifiée");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
              
}
     
   
             
} 
     public void Chercherlocation( int id_location)
     {
    try { 
            String query ="SELECT * from location WHERE id_loc='"+id_location+"'" ; 
            Statement st=cnx.createStatement();
    ResultSet rst = st.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("la reservation est trouver ") ; 
          } else {
                  System.out.println("la reservation est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    

}
     public Location lecturelocation( int id_location)
             
{ Location l = new Location();
    try { 
            String query ="SELECT * from location WHERE id_loc='"+id_location+"'" ; 
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
          int nbr =res.getRow() ;  
          if (nbr!=0)
          {
              
                l.setId_loc(res.getInt("id_loc"));
                l.setId_Produit(res.getInt("id_Produit"));
                l.setId_client(res.getInt("id_client"));
                l.setMontant(res.getDouble("montant"));
                l.setStart_l(res.getDate("start_l"));
                l.setEnd_l(res.getDate("end_l"));
                   
          } else {
                  System.out.println("la reservation est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
      return l;
}
     public double difference(Date start,Date end){
         
        double  diffheure=0;          
         try{
             
          long diff = end.getTime() - start.getTime();

           
           diffheure= (double) diff/3600000;
            
            System.out.println("Total heures : " +diffheure) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
          
      return  diffheure;
     }
     
         public double calculprixloc(int id_produit ,double diff)
                 
         {
             double prix = 0 ;
             double prixlocation = 0;
              try {
            String query ="SELECT prix_heure from produit WHERE id='"+id_produit+"'" ; 
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
         
            prix=res.getDouble(1);
            
             
            prixlocation= diff*prix ;
             System.out.println("Prix heure location : "+prix);
            System.out.println("Prix TOTAL : "+prixlocation);
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()) ;
        }
     return prixlocation ;
         }
             
    
    
}
