/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Mycnx {
     private static Mycnx instance;

    private String url = "jdbc:mysql://localhost:3306/velo";
    private String login = "root";
    private String mdp = "";
    private Connection cnx;

    private Mycnx() {
        try {
            cnx = DriverManager.getConnection(url, login, mdp);
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static Mycnx getInstance(){
        if (instance == null) {
            instance = new Mycnx();
        }
        return instance ;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}
