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
public class Club {
    
     private int idClub;
    private String nomClub,descriptionClub,adresseClub;

    public Club(int idClub, String nomClub, String descriptionClub, String adresseClub) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.descriptionClub = descriptionClub;
        this.adresseClub = adresseClub;
    }
    public Club( String nomClub, String descriptionClub, String adresseClub) {
        this.nomClub = nomClub;
        this.descriptionClub = descriptionClub;
        this.adresseClub = adresseClub;
    }
    
    
    public Club() {
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getDescriptionClub() {
        return descriptionClub;
    }

    public void setDescriptionClub(String descriptionClub) {
        this.descriptionClub = descriptionClub;
    }

    public String getAdresseClub() {
        return adresseClub;
    }

    public void setAdresseClub(String adresseClub) {
        this.adresseClub = adresseClub;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nomClub=" + nomClub + ", descriptionClub=" + descriptionClub + ", adresseClub=" + adresseClub + '}';
    }
    
    
}
