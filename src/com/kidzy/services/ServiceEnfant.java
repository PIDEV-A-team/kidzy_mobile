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
import com.kidzy.entities.Classe;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Garde;
import com.kidzy.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ferja
 */
public class ServiceEnfant {
     public ArrayList<Enfant> enfants;
    
    public static ServiceEnfant instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEnfant() {
         req = new ConnectionRequest();
    }

    public static ServiceEnfant getInstance() {
        if (instance == null) {
            instance = new ServiceEnfant();
        }
        return instance;
    }

    public boolean addTask(Enfant t) {
        String url = Statics.BASE_URL+"";
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

    public ArrayList<Enfant> parseEnfants(String jsonText){
        try {
            enfants=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> enfantListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)enfantListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Enfant e = new Enfant();
                float id = Float.parseFloat(obj.get("id_enfant").toString());
                e.setId_enfant((int)id);

                e.setNom_enfant(obj.get("nom_enfant").toString());
                e.setPrenom_enfant(obj.get("prenom_enfant").toString());
                e.setImage_enfant(obj.get("image_enfant").toString());
                e.setDateN_enfant(obj.get("dateN_enfant").toString());
                Classe cl = new Classe();
               
                cl.setLibelle_cla(obj.get("libelle_cla").toString());
             //  e.setId_Classe(obj.get("libelle_cla").toString());
               // e.setGarde(obj.get("nom_garde").toString());
               Garde gar = new Garde();
               
                gar.setNom_garde(obj.get("nom_garde").toString());
                
                enfants.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfants;
    }
        public ArrayList<Enfant> parseEnfants1(String jsonText){
        try {
            enfants=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> enfantListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)enfantListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Enfant e = new Enfant();


                e.setNom_enfant(obj.get("nomEnfant").toString());

                
                enfants.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfants;
    }
    
    public ArrayList<Enfant> getAllEnfants(){
        String url = Statics.BASE_URL+"/kidzy/enfant/enfants/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                enfants = parseEnfants(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return enfants;
    }
        public ArrayList<Enfant> getAllEnfants1(int id){
        String url = Statics.BASE_URL1+"/alle/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                enfants = parseEnfants1(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return enfants;
    }
    
    
}
