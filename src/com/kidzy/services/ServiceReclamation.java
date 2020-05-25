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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.kidzy.entities.Reclamations;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;
import com.kidzy.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ferja
 */
public class ServiceReclamation {
     public ArrayList<Reclamations> rec;
          public ArrayList<user> users;
                   public int idParent;
      user User =Session.getCurrentSession();
    
    public static ServiceReclamation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceReclamation() {
         req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public boolean addRec(String t, int id) {
        String url = Statics.BASE_URL2+"/kidzy/reclamations/ajoutRec?descriptionRec="+t+"&idUser="+id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        System.out.println(rec);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
        
       

    public ArrayList<Reclamations> parseReclamation(String jsonText){
        try {
            rec=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> recListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)recListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Reclamations r = new Reclamations();
                float id = Float.parseFloat(obj.get("idRec").toString());
                r.setId_rec((int)id);
                                
                r.setDescription_rec(obj.get("descriptionRec").toString());
                r.setDate_rec(obj.get("dateRec").toString());
              //  r.setReponse_rec(obj.get("reponseRec").toString());

                
                rec.add(r);
            }
            
            
        } catch (IOException ex) {
            
        }
        return rec;
    }
     public ArrayList<Reclamations> getMesRecMobile(int idUser){
        String url = Statics.BASE_URL2+"/kidzy/reclamations/MesRecMobile/"+idUser;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                rec = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(rec);
        return rec;
    
        
    
    
//          public ArrayList<Reclamations> getMesRecMobile(int idUser){
//        String url = Statics.BASE_URL2+"/kidzy/reclamations/MesRecMobile/"+idUser;
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                rec = parseReclamation(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        System.out.println(rec);
//        return rec;
//    
//        
//    }
//    public ArrayList<User> getMaitresse(){
//        String url = Statics.BASE_URL2+"/kidzy/reclamations/MaitresseMobile";
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                rec = parseReclamation(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return rec;
//    }

   
    
    
}
}