/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.entities;

import java.util.Date;

/**
 *
 * @author Youssef Mimouni
 */
public class Facture {
    private int idFacture ;
    private float total ;
    
    private Date date_facture , payedate ; 
    private String due_date_facture;
    private Enfant idEnf;
    private user idParent ;
    private Boolean paye ;
    private int status ;
    private Pack pack ;

    public Facture(int idFacture, float total, Date date_facture, String due_date_facture, Enfant idEnf, user idParent, Boolean paye, int status, Pack pack) {
        this.idFacture = idFacture;
        this.total = total;
        this.date_facture = date_facture;
        this.due_date_facture = due_date_facture;
        this.idEnf = idEnf;
        this.idParent = idParent;
        this.paye = paye;
        this.status = status;
        this.pack = pack;
    }

    public Facture() {
    }

    public Date getPayedate() {
        return payedate;
    }

    public void setPayedate(Date payedate) {
        this.payedate = payedate;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public String getDue_date_facture() {
        return due_date_facture;
    }

    public void setDue_date_facture(String due_date_facture) {
        this.due_date_facture = due_date_facture;
    }

    public Enfant getIdEnf() {
        return idEnf;
    }

    public void setIdEnf(Enfant idEnf) {
        this.idEnf = idEnf;
    }

    public user getIdParent() {
        return idParent;
    }

    public void setIdParent(user idParent) {
        this.idParent = idParent;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idFacture;
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
        final Facture other = (Facture) obj;
        if (this.idFacture != other.idFacture) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "idFacture=" + idFacture + ", total=" + total + ", date_facture=" + date_facture + ", payedate=" + payedate + ", due_date_facture=" + due_date_facture + ", idEnf=" + idEnf + ", idParent=" + idParent + ", paye=" + paye + ", status=" + status + ", pack=" + pack + '}';
    }

    
}
