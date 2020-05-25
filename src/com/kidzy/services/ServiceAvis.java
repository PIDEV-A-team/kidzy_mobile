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
import com.kidzy.entities.Avis;
import com.kidzy.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;

/**
 *
 * @author ferja
 */
public class ServiceAvis {
     public ArrayList<Avis> avis;
     public ArrayList<user> users;
     
           public int idParent;
      user User =Session.getCurrentSession();
    
    public static ServiceAvis instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceAvis() {
         req = new ConnectionRequest();
    }

    public static ServiceAvis getInstance() {
        if (instance == null) {
            instance = new ServiceAvis();
        }
        return instance;
    }


        public boolean addAvis(String  t,int id) {
       
        String url = Statics.BASE_URL2+"/kidzy/avis/ajoutAvis?descriptionAvis="+t+"&idUser="+id;
        req.setUrl(url);               // http://localhost:8080/kidzy_web/web/app_dev.php/kidzy/enfant/enfants/new?nomEnfant=dalii%20&prenomEnfant=dali&datenEnfant=20-10-2005&imageEnfant=img     
         System.out.println(idParent);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        System.out.println(avis);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Avis> parseAvis(String jsonText){
        try {
            avis=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> avisListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)avisListJson.get("root");
            for(Map<String,Object> obj : list){
                user u = new user();
                Avis a = new Avis();
                float id = Float.parseFloat(obj.get("idAvis").toString());
                a.setId_avis((int)id);
                                
                a.setDescription_avis(obj.get("descriptionAvis").toString());
                a.setDate_avis(obj.get("dateAvis").toString());
//                 float idU = Float.parseFloat(obj.get("id_parent").toString());
//                u.setId((int)idU); 
//                u.setNom(obj.get("nom_parent").toString());
//                u.setPrenom(obj.get("prenom_parent").toString());
//                a.setUser(u);
                avis.add(a);
            }
            
            
        } catch (IOException ex) {
            
        }
        return avis;
    }
    public ArrayList<Avis> parseMesAvis(String jsonText){
        try {
            avis=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> avisListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)avisListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Avis a = new Avis();
                float id = Float.parseFloat(obj.get("idAvis").toString());
                a.setId_avis((int)id);
                                
                a.setDescription_avis(obj.get("descriptionAvis").toString());
                a.setDate_avis(obj.get("dateAvis").toString());
                
                avis.add(a);
            }
            
            
        } catch (IOException ex) {
            
        }
        return avis;
    }
    
    public ArrayList<Avis> getAllAvis(){
        String url = Statics.BASE_URL2+"/kidzy/avis/allAvis";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                avis = parseAvis(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return avis;
    }
    
        public ArrayList<Avis> getMesAvisMobile(int idUser){
        String url = Statics.BASE_URL2+"/kidzy/avis/MesAvisMobile/"+idUser;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                avis = parseMesAvis(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(avis);
        return avis;
    
        
    }
        
    public boolean updateAvis(String  t,int id,int avis)  {
        
        String url = Statics.BASE_URL2 +"/kidzy/avis/updateAvisMobile/"+avis+"?descriptionAvis="+t+"&idUser="+id;
        req.setUrl(url);                // /kidzy/enfant/enfants/update/37?nomEnfant=ferjani%20&prenomEnfant=sonia&datenEnfant=20-10-2005&imageEnfant=img  
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        getAllAvis();
        System.out.println(avis);
        return resultOK;
    }
    
      public boolean deleteAvis(int idAvis) {
        String url = Statics.BASE_URL2 + "kidzy/avis/suppAvis/" + idAvis  ;
        req.setUrl(url);
        if(Dialog.show("Suppression", "Vous êtes sûr ?", "Ok", "Retour")){
             req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                getAllAvis();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        } else {
             System.out.println("annuler la suppression");
        }
       return resultOK;
    }
   
    
    
}
