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
import com.kidzy.entities.Classe;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Garde;
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
public class ServiceEnfant {
      public ArrayList<Enfant> enfants;
      public ArrayList<user> users;
      
      public int idParent;
      user User =Session.getCurrentSession();
    
    public static ServiceEnfant instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEnfant() {
         req = new ConnectionRequest();
    }

    public static ServiceEnfant getInstance() {
        if (instance == null) {
            instance = new ServiceEnfant();
        }
        return instance;
    }

    public boolean addEnfant(Enfant t) {
       
        String url = Statics.BASE_URL2+"/kidzy/enfant/enfants/new?nomEnfant="+t.getNom_enfant()+"&prenomEnfant="+t.getPrenom_enfant()+"&imageEnfant="+t.getImage_enfant()+"&datenEnfant="+t.getDateN_enfant();
        req.setUrl(url);               // http://localhost:8080/kidzy_web/web/app_dev.php/kidzy/enfant/enfants/new?nomEnfant=dalii%20&prenomEnfant=dali&datenEnfant=20-10-2005&imageEnfant=img     
         System.out.println(idParent);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        System.out.println(enfants);
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
                Classe c = new Classe();
                Garde g = new Garde();
                
                float id = Float.parseFloat(obj.get("idEnfant").toString());
               
                e.setId_enfant((int)id);

                e.setNom_enfant(obj.get("nomEnfant").toString());
                e.setPrenom_enfant(obj.get("prenomEnfant").toString());
                e.setImage_enfant(obj.get("imageEnfant").toString());
                e.setDateN_enfant(obj.get("datenEnfant").toString());
                
        /*  if (e.getIdClasse() == ""){
               System.out.println("---");
               // e.setIdClasse(obj.get("").toString());
           }else {
                c.setLibelle_cla(obj.get("libelleCla").toString());  
           }
*/
               // System.out.println( c.setLibelle_cla(obj.get("libelleCla").toString())  );
              //  float idd = Float.parseFloat(obj.get("idClasse").toString());
              // c.setId_classe((int)idd);
               
               // System.out.println(idd);
               
               float idd = Float.parseFloat(obj.get("idClasse").toString());
                   c.setId_classe((int)idd);  
              //  e.setIdClasse(c);
                c.setLibelle_cla(obj.get("libelleCla").toString());  
//                c.setDescription(obj.get("description").toString());
              e.setIdClasse(c);
                
               float iddd = Float.parseFloat(obj.get("idGarde").toString());
                   g.setId_garde((int)iddd); 
                   g.setNom_garde(obj.get("nomGarde").toString());
              //  e.setIdClasse(c);
                
              e.setIdGarde(g);
              
               // g.setNom_garde(obj.get("nomGarde").toString());
               // e.setIdGarde(g);
               user useer = new user();
               // e.setNom(obj.get("nom").toString());
               
               
              // useer.setId((int)idd);
                // user User =Session.getCurrentSession();
                
                //float idd = Float.parseFloat(obj.get("idParent").toString());
                // useer.setId((int)idd);
                // e.setIdParent((int)idd);
               
              // System.out.println( (idd));
                enfants.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfants;
    }
    
    public ArrayList<Enfant> getAllEnfants(int idParent){
        String url = Statics.BASE_URL2+"/kidzy/enfant/enfants/all/"+idParent;
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
        System.out.println(enfants);
        return enfants;
    }
    
     public boolean updateEnfant(int idEnfant, String nomEnfant , String prenomEnfant ,String datenEnfant,String imageEnfant) {
        String url = Statics.BASE_URL2 + "/kidzy/enfant/enfants/update/" + idEnfant + "?nomEnfant="+ nomEnfant + "&prenomEnfant=" + prenomEnfant+ "&datenEnfant=" + datenEnfant+ "&imageEnfant=" + imageEnfant;
        req.setUrl(url);                // /kidzy/enfant/enfants/update/37?nomEnfant=ferjani%20&prenomEnfant=sonia&datenEnfant=20-10-2005&imageEnfant=img  
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
         user User =Session.getCurrentSession();
        
        getAllEnfants(User.getId());
        System.out.println(enfants);
        return resultOK;
    }
    
      public boolean deleteEnfant(int idEnfant) {
        String url = Statics.BASE_URL2 + "/kidzy/enfant/enfants/delete/" + idEnfant  ;
        req.setUrl(url);
        if(Dialog.show("Suppression", "Vous êtes sûr ?", "Ok", "Retour")){
             req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                user User =Session.getCurrentSession();
                getAllEnfants(User.getId());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        } else {
             System.out.println("annuler la suppression");
        }
       return resultOK;
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
  /*  
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
    }*/
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
