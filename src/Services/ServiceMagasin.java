/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Magasin;
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
public class ServiceMagasin {
    
    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ServiceMagasin() {
       cnx = Mycnx.getInstance().getCnx();
    }
    
     public void ajouuterMagasin(Magasin M) {

        try {
            String req = "INSERT INTO magasin (name_M,Adresse,tel,id_region) VALUES (?,?,?,?)";

            pre = cnx.prepareStatement(req);

            pre.setString(1, M.getName_M());
            pre.setString(2, M.getAdresse());
            pre.setInt(3, M.getTel());
            pre.setInt(4, M.getId_region());
           

            pre.executeUpdate();

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
     
     public List<Magasin> afficheMagasin() {

        List<Magasin> listM = new ArrayList<>();

        try {

            String req = "SELECT * FROM magasin";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Magasin p = new Magasin();

                p.setId(res.getInt("id"));
                p.setName_M(res.getString("name_M"));
                p.setAdresse(res.getString("Adresse"));
                p.setTel(res.getInt("tel"));
                p.setId_region(res.getInt("id_region"));
              
                listM.add(p);
            }
            
            System.out.println(listM);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listM;
    }

    
     public void supprimerparID (int id) {
        
        try { 
            String query ="DElETE FROM magasin WHERE id="+id ; 
            Statement st=cnx.createStatement();
            st.executeUpdate(query) ; 
            System.out.println("la magasin de l id = "+id+ " a ete bien supprimer ") ; 
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    }
     
     public void modifierMagasin( int id, String name_M, String adresse, int tel, int id_region )
{ 
    try {
     String query ="UPDATE magasin SET name_M='"+name_M+"',Adresse='"+adresse+"',tel='"+tel+"',id_region='"+id_region+"' WHERE id='"+id+"'" ;
     
  
     Statement st=cnx.createStatement();
      st.executeUpdate(query) ;
      System.out.println("Magasin bien modifiée");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }

    
    
}
     
public Magasin lectureMagasin(int  id_magasin)
             
{ 
    Magasin A = new Magasin();
    
    try { 
        
            String query ="SELECT * from magasin WHERE id='"+id_magasin+"'" ; 
            
            Statement st=cnx.createStatement();
    ResultSet res = st.executeQuery(query);
         res.last();
          int nbr =res.getRow() ;  
          if (nbr!=0)
          {
              
                A.setId(res.getInt("id"));
                A.setName_M(res.getString("name_M"));
                A.setAdresse(res.getString("Adresse"));
                A.setTel(res.getInt("tel"));
                A.setId_region(res.getInt("id_region"));
                
             
          } else {
                  System.out.println("la magasin est non trouver ") ; 
          }   
    
       }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
      
       return A;  
}

public void frrfrfrf (int a){
    System.out.println(a);
}

 public List<Magasin> rechercheparregion(int id_reg) {

        List<Magasin> listM = new ArrayList<>();

        try {

            String req = "SELECT * from magasin WHERE id_region='"+id_reg+"'" ;

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Magasin p = new Magasin();

                p.setId(res.getInt("id"));
                p.setName_M(res.getString("name_M"));
                p.setAdresse(res.getString("Adresse"));
                p.setTel(res.getInt("tel"));
                p.setId_region(res.getInt("id_region"));
              
                listM.add(p);
            }
            
            System.out.println(listM);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listM;
    }
    
    
}
