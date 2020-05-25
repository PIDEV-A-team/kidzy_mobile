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
public class Avis {
        private int id_avis;
    private String date_avis;
    private String description_avis;
private user User ;
//    public Avis(String description_avis) {
//        this.description_avis = description_avis;
//    }

    public user getUser() {
        return User;
    }

    public void setUser(user User) {
        this.User = User;
    }



    public void setDate_avis(String date_avis) {
        this.date_avis = date_avis;
    }

    public String getDate_avis() {
        return date_avis;
    }

    public Avis() {
    }
    



    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", date_avis=" + date_avis + ", description_avis=" + description_avis + '}';
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

 

    public void setDescription_avis(String description_avis) {
        this.description_avis = description_avis;
    }

    public int getId_avis() {
        return id_avis;
    }


    public String getDescription_avis() {
        return description_avis;
    }

//    public Avis(int id_avis, String date_avis, String description_avis) {
//        this.id_avis = id_avis;
//        this.date_avis = date_avis;
//        this.description_avis = description_avis;
//    }
    


   
}

