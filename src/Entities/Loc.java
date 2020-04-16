/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Loc {
    
     private int id_loc;
    private Date start_l;
   private  Date end_l;
    private double montant;
    private int id_Produit;
    private int id_client;
    private String email;
    private String refp;
    private int tel;
    private String username;

    public Loc(int id_loc, Date start_l, Date end_l, double montant, int id_Produit, int id_client, String email, String refp, int tel, String username) {
        this.id_loc = id_loc;
        this.start_l = start_l;
        this.end_l = end_l;
        this.montant = montant;
        this.id_Produit = id_Produit;
        this.id_client = id_client;
        this.email = email;
        this.refp = refp;
        this.tel = tel;
        this.username = username;
    }

    public Loc(Date start_l, Date end_l, double montant, int id_Produit, int id_client, String email, String refp, int tel, String username) {
        this.start_l = start_l;
        this.end_l = end_l;
        this.montant = montant;
        this.id_Produit = id_Produit;
        this.id_client = id_client;
        this.email = email;
        this.refp = refp;
        this.tel = tel;
        this.username = username;
    }

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public Date getStart_l() {
        return start_l;
    }

    public void setStart_l(Date start_l) {
        this.start_l = start_l;
    }

    public Date getEnd_l() {
        return end_l;
    }

    public void setEnd_l(Date end_l) {
        this.end_l = end_l;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(int id_Produit) {
        this.id_Produit = id_Produit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefp() {
        return refp;
    }

    public void setRefp(String refp) {
        this.refp = refp;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_loc;
        hash = 37 * hash + Objects.hashCode(this.start_l);
        hash = 37 * hash + Objects.hashCode(this.end_l);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.montant) ^ (Double.doubleToLongBits(this.montant) >>> 32));
        hash = 37 * hash + this.id_Produit;
        hash = 37 * hash + this.id_client;
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.refp);
        hash = 37 * hash + this.tel;
        hash = 37 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loc other = (Loc) obj;
        if (this.id_loc != other.id_loc) {
            return false;
        }
        if (Double.doubleToLongBits(this.montant) != Double.doubleToLongBits(other.montant)) {
            return false;
        }
        if (this.id_Produit != other.id_Produit) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.refp, other.refp)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.start_l, other.start_l)) {
            return false;
        }
        if (!Objects.equals(this.end_l, other.end_l)) {
            return false;
        }
        return true;
    }

    public Loc() {
    }
    
    
}
