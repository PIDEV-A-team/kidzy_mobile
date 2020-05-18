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
import com.kidzy.entities.Pack;
import com.kidzy.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServicePack {

    public ArrayList<Pack> Packs;
    
    public static ServicePack instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePack() {
         req = new ConnectionRequest();
    }

    public static ServicePack getInstance() {
        if (instance == null) {
            instance = new ServicePack();
        }
        return instance;
    }

    public boolean addPack(Pack t) {
        /*String url = Statics.BASE_URL + "/tasks/" + t.getName() + "/" + t.getStatus();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);*/
        return resultOK;
    }

    public ArrayList<Pack> parsePacks(String jsonText){
        try {
            Packs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Pack t = new Pack();
                float id = Float.parseFloat(obj.get("idpack").toString());
                t.setId((int)id);
                t.setNom_pack(obj.get("nom_pack").toString());
                t.setDescription_pack(obj.get("description").toString());
                t.setPrix_pack(Float.parseFloat(obj.get("prix_pack").toString()));
                t.setPrix_pack_year(Float.parseFloat(obj.get("prix_pack_year").toString()));
                Packs.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return Packs;
    }
    
    public ArrayList<Pack> getAllPacks(){
        String url = Statics.BASE_URL+"/packs/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Packs = parsePacks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Packs;
    }
        public String Packs(){
        String url = Statics.BASE_URL+"/packs/all";
        req.setUrl(url);
        req.setPost(false);
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return (new String(req.getResponseData()));
    }
}
