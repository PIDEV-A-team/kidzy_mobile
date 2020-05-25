/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.events.ActionListener;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Facture;
import com.kidzy.entities.Pack;
import com.kidzy.entities.user;

import com.kidzy.utils.Statics;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.*;
import java.text.SimpleDateFormat;



/**
 *
 * 
 * @author Youssef Mimouni
 */


public class ServiceFacture {
    public ArrayList<Facture> Factures;
    public ArrayList<Enfant> enfantsp;
    public ArrayList<Facture> payed;
    public Facture lastfact;
    public static ServiceFacture instance=null;
    public boolean resultOK;
    public static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
    private static SimpleDateFormat inSDF = new SimpleDateFormat("yyyy/mm/dd");
    private ConnectionRequest req;
    
    
    public static String formatDate(String inDate) {
    String outDate = "";
    if (inDate != null) {
        try {
            Date date = inSDF.parse(inDate);
            outDate = outSDF.format(date);
        } catch (ParseException ex){ 
        }
    }
    return outDate;
  }
    
    public static Date formatDate222(String inDate) {
    Date date = null ;
    if (inDate != null) {
        try {
           date = inSDF.parse(inDate);
           
        } catch (ParseException ex){ 
        }
    }
    return date;
  }
    private ServiceFacture() {
         req = new ConnectionRequest();
    }

    public static ServiceFacture getInstance() {
        if (instance == null) {
            instance = new ServiceFacture();
        }
        return instance;
    }
    public boolean addFacture(Facture t) {
        String all = "?idPack=" + t.getPack().getId()+ "&idparent=" + t.getIdParent().getId()+ "&idEnfant=" + t.getIdEnf().getId_enfant()+ "&prix=" + t.getTotal()+ "&end=" + t.getDue_date_facture();
        String url = Statics.BASE_URL + "/factures/new"+all;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public Facture addFacture222(Facture t) {
        
        String due = formatDate(t.getDue_date_facture());
        System.out.println(t.getDue_date_facture());
        System.out.println("");
        System.out.println(due);
        String all = t.getPack().getId()+ "/" + t.getIdParent().getId()+ "/" + t.getIdEnf().getId_enfant()+ "/" + t.getTotal()+ "/" + due;
        String url = Statics.BASE_URL + "/factures/create/new/"+all;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
               
                lastfact = parseFactures222(new String(req.getResponseData()));
                System.out.println(lastfact);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return lastfact;
    }
    public boolean updateFacture(int id , String d) {
        
        String all =id+"/" + d;
        String url = Statics.BASE_URL + "/factures/update/"+all;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
            public Facture parseFactures222(String jsonText){
                    Facture t = new Facture();
            JSONObject result1 = new JSONObject(jsonText);
            float id = Float.parseFloat(result1.get("id").toString());
            t.setIdFacture((int)id);                
                t.setTotal(Float.parseFloat(result1.get("total").toString()));
            /* ************** Reading nested start date************************************** */
                JSONObject start = result1.getJSONObject("start date facture");
               // System.out.println(start);
                Date startdate = new Date();
                try {  
                  startdate=new SimpleDateFormat("yyyy-MM-dd").parse(start.get("date").toString());
                } catch (ParseException ex) {}
                t.setDate_facture(startdate);
               // System.out.println("******************date aded");
                /* ********************Parent**************************** */
                
                JSONObject parent = result1.getJSONObject("parent");
               // System.out.println(parent);
                user u = new user();
                u.setId(parent.getInt("id_parent"));
                u.setNom(parent.get("nom_parent").toString());
                u.setPrenom(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                t.setIdParent(u);
                /* *******************Pack********************** */
                  
                JSONObject pack = result1.getJSONObject("pack");
                //System.out.println(pack);
                Pack p = new Pack();
                p.setId(pack.getInt("idpack"));
                p.setNom_pack(pack.getString("nom_pack"));
                p.setDescription_pack(pack.getString("description"));
                t.setPack(p);
                /* *********************Enfant************************** */
                
                JSONObject enfant = result1.getJSONObject("enfant");
                //System.out.println(enfant);
                Enfant f = new Enfant();
                f.setId_enfant(enfant.getInt("IdEnfant"));
                f.setNom_enfant(enfant.getString("NomEnfant"));
                f.setPrenom_enfant(enfant.getString("PrenomEnfant"));
                f.setIdParent(u);
                t.setIdEnf(f);
                /* **************************************************** */
                String End = null;
                End=result1.get("End date facture").toString();
                t.setDue_date_facture(End);
                /* **************************************************** */
                t.setPaye(Boolean.parseBoolean(result1.get("paye").toString())); 
                float status= Float.parseFloat(result1.get("status").toString());
                t.setStatus((int)status);   
                lastfact = t ;
            return lastfact;
    }
        public ArrayList<Facture> parseFactures(String jsonText){
        try {
            Factures=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            int i =0 ;
            System.out.println(list);
            for(Map<String,Object> obj : list){
                Facture t = new Facture();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setIdFacture((int)id);                
                t.setTotal(Float.parseFloat(obj.get("total").toString()));
                /* ************** Reading nested Objects************************************** */
               
                JSONObject jsonObject = new JSONObject(tasksListJson);
                JSONArray result = jsonObject.getJSONArray("root");
             
                JSONObject result1 = result.getJSONObject(i);
                /* ************** Reading nested start date************************************** */
                JSONObject start = result1.getJSONObject("start date facture");
               // System.out.println(start);
                Date startdate = new Date();
                try {  
                  startdate=new SimpleDateFormat("yyyy-MM-dd").parse(start.get("date").toString());
                } catch (ParseException ex) {}
                t.setDate_facture(startdate);
               // System.out.println("******************date aded");
                
                /* ********************Parent**************************** */
                
                JSONObject parent = result1.getJSONObject("parent");
               // System.out.println(parent);
                user u = new user();
                u.setNom(parent.get("nom_parent").toString());
                u.setPrenom(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                t.setIdParent(u);
                /* *******************Pack********************** */
                  
                JSONObject pack = result1.getJSONObject("pack");
                //System.out.println(pack);
                Pack p = new Pack();
                p.setId(pack.getInt("idpack"));
                p.setNom_pack(pack.getString("nom_pack"));
                p.setDescription_pack(pack.getString("description"));
                t.setPack(p);
                /* *********************Enfant************************** */
                
                JSONObject enfant = result1.getJSONObject("enfant");
                //System.out.println(enfant);
                Enfant f = new Enfant();
                f.setId_enfant(enfant.getInt("IdEnfant"));
                f.setNom_enfant(enfant.getString("NomEnfant"));
                f.setPrenom_enfant(enfant.getString("PrenomEnfant"));
                f.setIdParent(u);
                t.setIdEnf(f);
                /* **************************************************** */
                String End = null;
                End=obj.get("End date facture").toString();
                t.setDue_date_facture(End);
                /* **************************************************** */
                t.setPaye(Boolean.parseBoolean(obj.get("paye").toString())); 
                float status= Float.parseFloat(obj.get("status").toString());
                t.setStatus((int)status);      
              
                Factures.add(t);
                //System.out.println("**************");
                i++;
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return Factures;

    }
        

        public ArrayList<Facture> getAllFactures(){
        String url = Statics.BASE_URL+"/factures/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Factures = parseFactures(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Factures;
    }
        public ArrayList<Facture> getFacturesbyenfant(int idenfant){
        String url = Statics.BASE_URL+"/factures/enfant/find/"+idenfant;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Factures = parseFactures(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Factures;
    }
        
        
        
        
        public String factures(){
        String url = Statics.BASE_URL+"/factures/all";
        req.setUrl(url);
        req.setPost(false);
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return (new String(req.getResponseData()));
    }
        
        public ArrayList<Enfant> parseenfp(String jsonText){
        try {
            enfantsp=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            int i =0 ;
            for(Map<String,Object> obj : list){
                Enfant t = new Enfant();
                float id = Float.parseFloat(obj.get("IdEnfant").toString());
                t.setId_enfant((int)id);                
                t.setNom_enfant(obj.get("NomEnfant").toString());
                t.setPrenom_enfant(obj.get("PrenomEnfant").toString());
                t.setImage_enfant(obj.get("ImageEnfant").toString());
               
                JSONObject jsonObject = new JSONObject(tasksListJson);
                JSONArray result = jsonObject.getJSONArray("root");
                JSONObject result1 = result.getJSONObject(i);
                JSONObject parent = result1.getJSONObject("IdParent");
                
                user u = new user();
                u.setId(parent.getInt("id_parent"));
                u.setNom(parent.get("nom_parent").toString());
                u.setPrenom(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                t.setIdParent(u);
               /*if(getpayed().contains(t)){
                   
               }*/
               enfantsp.add(t);            
                i++;
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfantsp;
    }
        public ArrayList<Enfant> getenfantsp(int iduser){
        String url = Statics.BASE_URL+"/packs/parent/find/"+iduser;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                enfantsp = parseenfp(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return enfantsp;
    }
        
        public ArrayList<Facture> parsepayed(String jsonText){
        try {
            payed=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            int i =0 ;
            for(Map<String,Object> obj : list){
                
               
               Facture y = new Facture();
                /* ************** Reading nested Objects************************************** */
               
                JSONObject jsonObject = new JSONObject(tasksListJson);
                JSONArray result = jsonObject.getJSONArray("root");
             
                JSONObject result1 = result.getJSONObject(i);
                
                /* ************** Reading nested start date************************************** */
                JSONObject start = result1.getJSONObject("paydate");
               // System.out.println(start);
                Date payedate = new Date();
                try {  
                  payedate=new SimpleDateFormat("yyyy-MM-dd").parse(start.get("date").toString());
                } catch (ParseException ex) {}
                y.setPayedate(payedate);
               // System.out.println("******************date aded");
                /* ********************Parent**************************** */
                
                JSONObject parent = result1.getJSONObject("parent");
                
                user u = new user();
                u.setId(parent.getInt("id_parent"));
                u.setNom(parent.get("nom_parent").toString());
                u.setPrenom(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                y.setIdParent(u);
                /* *********************Enfant************************** */
                
                JSONObject enfant = result1.getJSONObject("enfant");
                
                Enfant f = new Enfant();
                f.setId_enfant(enfant.getInt("IdEnfant"));
                f.setNom_enfant(enfant.getString("NomEnfant"));
                f.setPrenom_enfant(enfant.getString("PrenomEnfant"));
                f.setIdParent(u);
                y.setIdEnf(f);
                /* **************************************************** */
                System.out.println("aaaaaaaaaaaa");
                System.out.println(y);
                
              
                payed.add(y);
                
                i++;
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return payed;
    }
        public ArrayList<Facture> getpayed(){
        String url = Statics.BASE_URL+"/factures/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                payed = parsepayed(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return payed;
    }
        public void getinvoicepdf() throws IOException{
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/packs/print/5/1/7/40/320/2020-06-18";
        
       
        
        Util.downloadUrlToFile(url, "pdf", true);
         Storage.getInstance().createInputStream(url);
    }
        
        public boolean sendmail(Facture t) {
        String url = Statics.BASE_URL + "/factures/payment/"+t.getIdFacture()+"/"+t.getIdParent().getId();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
