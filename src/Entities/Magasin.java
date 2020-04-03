/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Magasin {
     private int id;
   private String name_M;
   private String adresse;
   private int tel;
   private int id_region;

    public Magasin(int id, String name_M, String adresse, int tel, int id_region) {
        this.id = id;
        this.name_M = name_M;
        this.adresse = adresse;
        this.tel = tel;
        this.id_region = id_region;
    }

    public Magasin(String name_M, String adresse, int tel, int id_region) {
        this.name_M = name_M;
        this.adresse = adresse;
        this.tel = tel;
        this.id_region = id_region;
    }

    public Magasin() {
    }

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", name_M=" + name_M + ", adresse=" + adresse + ", tel=" + tel + ", id_region=" + id_region + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.name_M);
        hash = 73 * hash + Objects.hashCode(this.adresse);
        hash = 73 * hash + this.tel;
        hash = 73 * hash + this.id_region;
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
        final Magasin other = (Magasin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (this.id_region != other.id_region) {
            return false;
        }
        if (!Objects.equals(this.name_M, other.name_M)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_M() {
        return name_M;
    }

    public void setName_M(String name_M) {
        this.name_M = name_M;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
   
   
    
}
