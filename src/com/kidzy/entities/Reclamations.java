/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ferja
 */
public class Reclamations {
        private int id_rec;
        private String description_rec;
    private String date_rec;
    private String reponse_rec;

    public void setReponse_rec(String reponse_rec) {
        this.reponse_rec = reponse_rec;
    }

    public Reclamations(int id_rec, String description_rec, String date_rec, String reponse_rec) {
        this.id_rec = id_rec;
        this.description_rec = description_rec;
        this.date_rec = date_rec;
        this.reponse_rec = reponse_rec;
    }

    public String getReponse_rec() {
        return reponse_rec;
    }

    public Reclamations(int id_rec, String description_rec, String date_rec) {
        this.id_rec = id_rec;
        this.description_rec = description_rec;
        this.date_rec = date_rec;
    }

    public Reclamations() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_rec;
        hash = 29 * hash + Objects.hashCode(this.description_rec);
        hash = 29 * hash + Objects.hashCode(this.date_rec);
        return hash;
    }

    @Override
    public String toString() {
        return "Reclamations{" + "id_rec=" + id_rec + ", description_rec=" + description_rec + ", date_rec=" + date_rec + '}';
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
        final Reclamations other = (Reclamations) obj;
        if (this.id_rec != other.id_rec) {
            return false;
        }
        if (!Objects.equals(this.description_rec, other.description_rec)) {
            return false;
        }
        if (!Objects.equals(this.date_rec, other.date_rec)) {
            return false;
        }
        return true;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setDescription_rec(String description_rec) {
        this.description_rec = description_rec;
    }

    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

    public int getId_rec() {
        return id_rec;
    }

    public String getDescription_rec() {
        return description_rec;
    }

    public String getDate_rec() {
        return date_rec;
    }

  


   
}
