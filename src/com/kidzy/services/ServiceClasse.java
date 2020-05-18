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
import com.kidzy.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ServiceClasse {
  public ArrayList<Classe> classes;
    
    public static ServiceClasse instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
     private ServiceClasse() {
         req = new ConnectionRequest();
    }

    public static ServiceClasse getInstance() {
        if (instance == null) {
            instance = new ServiceClasse();
        }
        return instance;
    }
    public ArrayList<Classe> parseClasses(String jsonText){
        try {
            classes=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> enfantListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)enfantListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Classe e = new Classe();
                float id = Float.parseFloat(obj.get("idClasse").toString());
                e.setId_classe((int)id);
                e.setLibelle_cla(obj.get("libelleCla").toString());
                e.setDescription(obj.get("description").toString());
                e.setImage(obj.get("image").toString());
              
                
                classes.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return classes;
    }
        public ArrayList<Classe> parseClasse(String jsonText){
        try {
            classes=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> enfantListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)enfantListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Classe e = new Classe();
                e.setEnfant(obj.get("nomEnfant").toString());
              
                
                classes.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return classes;
    }
    
    
        public ArrayList<Classe> getAllClasses(){
        String url = Statics.BASE_URL1+"/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                classes = parseClasses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return classes;
    }
                public ArrayList<Classe> getClasse(int id){
        String url = Statics.BASE_URL1+"/findclasse/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(req.getResponseData());
                classes = parseClasses(new String(req.getResponseData()));
                System.out.println(req.getResponseData());
              
                req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(classes);
        return classes;
    }
                public ArrayList<Classe> getEnfant(){
        String url = Statics.BASE_URL1+"/alle";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(req.getResponseData());
                classes = parseClasse(new String(req.getResponseData()));
                System.out.println(req.getResponseData());
              
                req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(classes);
        return classes;
    }
}
