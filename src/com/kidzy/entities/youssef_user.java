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
public class youssef_user {
    private int iduser;
    private String nom_parent ;
    private String prenom_parent;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public youssef_user(String nom_parent, String prenom_parent) {
        this.nom_parent = nom_parent;
        this.prenom_parent = prenom_parent;
    }

    public youssef_user() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNom_parent() {
        return nom_parent;
    }

    public void setNom_parent(String nom_parent) {
        this.nom_parent = nom_parent;
    }

    public String getPrenom_parent() {
        return prenom_parent;
    }

    public void setPrenom_parent(String prenom_parent) {
        this.prenom_parent = prenom_parent;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nom_parent);
        hash = 71 * hash + Objects.hashCode(this.prenom_parent);
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
        final youssef_user other = (youssef_user) obj;
        if (!Objects.equals(this.nom_parent, other.nom_parent)) {
            return false;
        }
        if (!Objects.equals(this.prenom_parent, other.prenom_parent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "iduser=" + iduser + ", nom_parent=" + nom_parent + ", prenom_parent=" + prenom_parent + ", email=" + email + '}';
    }

    

    
    
}
