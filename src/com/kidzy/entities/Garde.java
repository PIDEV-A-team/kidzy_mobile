/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.entities;

/**
 *
 * @author ferja
 */
public class Garde {
     private int id_garde;
    private String nom_garde;
    private String duree_garde;

    public Garde() {
    }
    
    

    public Garde(int id_garde, String nom_garde, String duree_garde) {
        this.id_garde = id_garde;
        this.nom_garde = nom_garde;
        this.duree_garde = duree_garde;
    }

    public Garde(String nom_garde, String duree_garde) {
        this.nom_garde = nom_garde;
        this.duree_garde = duree_garde;
    }

    public int getId_garde() {
        return id_garde;
    }

    public void setId_garde(int id_garde) {
        this.id_garde = id_garde;
    }

    public String getNom_garde() {
        return nom_garde;
    }

    public void setNom_garde(String nom_garde) {
        this.nom_garde = nom_garde;
    }

    public String getDuree_garde() {
        return duree_garde;
    }

    public void setDuree_garde(String duree_garde) {
        this.duree_garde = duree_garde;
    }

    @Override
    public String toString() {
        return "Garde{" + "id_garde=" + id_garde + ", nom_garde=" + nom_garde + ", duree_garde=" + duree_garde + '}';
    }
}
