/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.entities;

import java.util.Objects;

/**
 *
 * @author Youssef Mimouni
 */
public class Pack {
    private int id;
    private String nom_pack,description_pack;
    private float prix_pack,prix_pack_year;

    public Pack(int id, String nom_pack, String description_pack, float prix_pack, float prix_pack_year) {
        this.id = id;
        this.nom_pack = nom_pack;
        this.description_pack = description_pack;
        this.prix_pack = prix_pack;
        this.prix_pack_year = prix_pack_year;
    }
    public Pack(int id, String nom_pack) {
        this.id = id;
        this.nom_pack = nom_pack;
    }
    public Pack() {
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_pack() {
        return nom_pack;
    }

    public void setNom_pack(String nom_pack) {
        this.nom_pack = nom_pack;
    }

    public String getDescription_pack() {
        return description_pack;
    }

    public void setDescription_pack(String description_pack) {
        this.description_pack = description_pack;
    }

    public float getPrix_pack() {
        return prix_pack;
    }

    public void setPrix_pack(float prix_pack) {
        this.prix_pack = prix_pack;
    }

    public float getPrix_pack_year() {
        return prix_pack_year;
    }

    public void setPrix_pack_year(float prix_pack_year) {
        this.prix_pack_year = prix_pack_year;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nom_pack);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pack other = (Pack) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_pack, other.nom_pack)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", nom_pack=" + nom_pack + ", description_pack=" + description_pack + ", prix_pack=" + prix_pack + ", prix_pack_year=" + prix_pack_year + '}';
    }
}
