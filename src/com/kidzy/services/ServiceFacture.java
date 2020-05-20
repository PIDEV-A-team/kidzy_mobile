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
import com.codename1.ui.events.ActionListener;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Facture;
import com.kidzy.entities.Pack;
import com.kidzy.entities.youssef_user;
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
    public ArrayList<Enfant> payed;
    
    public static ServiceFacture instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

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
        String all = "?idPack=" + t.getPack().getId()+ "&idparent=" + t.getIdParent().getIduser()+ "&idEnfant=" + t.getIdEnf().getId_enfant()+ "&prix=" + t.getTotal()+ "&end=" + t.getDue_date_facture();
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
        public ArrayList<Facture> parseFactures(String jsonText){
        try {
            Factures=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            int i =0 ;
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
                youssef_user u = new youssef_user();
                u.setNom_parent(parent.get("nom_parent").toString());
                u.setPrenom_parent(parent.get("prenom_parent").toString());
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
                f.setId_enfant(enfant.getInt("id"));
                f.setNom_enfant(enfant.getString("nom"));
                f.setPrenom_enfant(enfant.getString("prenom"));
                f.setParent(u);
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
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId_enfant((int)id);                
                t.setNom_enfant(obj.get("nom").toString());
                t.setPrenom_enfant(obj.get("prenom").toString());
               
                JSONObject jsonObject = new JSONObject(tasksListJson);
                JSONArray result = jsonObject.getJSONArray("root");
                JSONObject result1 = result.getJSONObject(i);
                JSONObject parent = result1.getJSONObject("parent");
                
                youssef_user u = new youssef_user();
                u.setIduser(parent.getInt("id_parent"));
                u.setNom_parent(parent.get("nom_parent").toString());
                u.setPrenom_parent(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                t.setParent(u);
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
        
        public ArrayList<Enfant> parsepayed(String jsonText){
        try {
            payed=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            int i =0 ;
            for(Map<String,Object> obj : list){
                
               
               
                /* ************** Reading nested Objects************************************** */
               
                JSONObject jsonObject = new JSONObject(tasksListJson);
                JSONArray result = jsonObject.getJSONArray("root");
             
                JSONObject result1 = result.getJSONObject(i);
                
                
                /* ********************Parent**************************** */
                
                JSONObject parent = result1.getJSONObject("parent");
                
                youssef_user u = new youssef_user();
                u.setIduser(parent.getInt("id_parent"));
                u.setNom_parent(parent.get("nom_parent").toString());
                u.setPrenom_parent(parent.get("prenom_parent").toString());
                u.setEmail(parent.getString("email"));
                
                /* *********************Enfant************************** */
                
                JSONObject enfant = result1.getJSONObject("enfant");
                
                Enfant f = new Enfant();
                f.setId_enfant(enfant.getInt("id"));
                f.setNom_enfant(enfant.getString("nom"));
                f.setPrenom_enfant(enfant.getString("prenom"));
                f.setParent(u);
                
                /* **************************************************** */
                
              
                payed.add(f);
                
                i++;
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return payed;
    }
        public ArrayList<Enfant> getpayed(){
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
}
