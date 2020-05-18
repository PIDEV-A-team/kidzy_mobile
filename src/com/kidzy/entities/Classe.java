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
public class Classe {
      private int id_classe;
    private String libelle_cla;
    private String description;
    private String image;
    private String nomenfant;
    public Classe() {
    }

    public Classe(int id_classe, String libelle_cla, String description,String image) {
        this.id_classe = id_classe;
        this.libelle_cla = libelle_cla;
        this.description = description;
        this.image = image;
    }

    public Classe(String libelle_cla, String description) {
        this.libelle_cla = libelle_cla;
        this.description = description;
    }
        public Classe(String libelle_cla) {
        this.nomenfant = libelle_cla;
    }
    
    
     public String getEnfant() {
        return nomenfant;
    }

    public void setEnfant(String nomenfant) {
        this.nomenfant = nomenfant;
    }   

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
        public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLibelle_cla() {
        return libelle_cla;
    }

    public void setLibelle_cla(String libelle_cla) {
        this.libelle_cla = libelle_cla;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
