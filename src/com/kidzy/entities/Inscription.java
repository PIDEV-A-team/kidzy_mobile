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
public class Inscription {
    
    private Club club;
        private Enfant enfant;
        private int idInscrit;
        private Date dateInscrit;
        private String descInscrit;

    public Inscription() {
    }

    public Inscription(Club club, Enfant enfant, int idInscrit, Date dateInscrit, String descInscrit) {
        this.club = club;
        this.enfant = enfant;
        this.idInscrit = idInscrit;
        this.dateInscrit = dateInscrit;
        this.descInscrit = descInscrit;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club Club) {
        this.club = Club;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant Enfant) {
        this.enfant
                = Enfant;
    }

    public int getIdInscrit() {
        return idInscrit;
    }

    public void setIdInscrit(int idInscrit) {
        this.idInscrit = idInscrit;
    }

    public Date getDateInscrit() {
        return dateInscrit;
    }

    public void setDateInscrit(Date dateInscrit) {
        this.dateInscrit = dateInscrit;
    }

    public String getDescInscrit() {
        return descInscrit;
    }

    public void setDescInscrit(String descInscrit) {
        this.descInscrit = descInscrit;
    }
    
}
