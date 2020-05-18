/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.entities;

import java.util.Date;

/**
 *
 * @author ferja
 */
public class Enfant {
    private int id_enfant;
   
    private Classe classe;
    private Garde garde;
    private String nom_enfant;
    private String prenom_enfant;
    
    private String image_enfant;
    private String dateN_enfant;
    private Date updated_at;
    /*******/
    private User parent ;

    @Override
    public String toString() {
        return "Enfant{" + "id_enfant=" + id_enfant + ", classe=" + classe + ", garde=" + garde + ", nom_enfant=" + nom_enfant + ", prenom_enfant=" + prenom_enfant + ", image_enfant=" + image_enfant + ", dateN_enfant=" + dateN_enfant + ", updated_at=" + updated_at + ", parent=" + parent + '}';
    }

    public Enfant() {
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
    
      public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public String getImage_enfant() {
        return image_enfant;
    }

    public void setImage_enfant(String image_enfant) {
        this.image_enfant = image_enfant;
    }

    public String getDateN_enfant() {
        return dateN_enfant;
    }

    public void setDateN_enfant(String dateN_enfant) {
        this.dateN_enfant = dateN_enfant;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

   
}
