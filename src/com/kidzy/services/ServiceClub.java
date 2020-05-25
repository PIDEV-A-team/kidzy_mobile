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
import com.kidzy.entities.Club;
import com.kidzy.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceClub {

    public ArrayList<Club> clubs;
    public Club club;
    
    public static ServiceClub instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceClub() {
         req = new ConnectionRequest();
    }

    public static ServiceClub getInstance() {
        if (instance == null) {
            instance = new ServiceClub();
        }
        return instance;
    }
      
  
  
    public ArrayList<Club> parseAutresClubs(String jsonText){
       try {
            clubs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Club t = new Club();
                float id = Float.parseFloat(obj.get("idClub").toString());
                t.setIdClub((int)id);
                t.setNomClub(obj.get("nomClub").toString());
                t.setAdresseClub(obj.get("adresseClub").toString());
                t.setDescriptionClub(obj.get("descriptionClub").toString());
                clubs.add(t);
            }
            
        } catch (IOException ex) {
            
        }
        return clubs;
    }
    public ArrayList<Club> parseStatClubs(String jsonText){
       try {
            clubs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Club t = new Club();
                float id = Float.parseFloat(obj.get("NB").toString());
                t.setNombreplace((int)id);
                t.setNomClub(obj.get("nomClub").toString());
                clubs.add(t);
            }
            
        } catch (IOException ex) {
            
        }
        return clubs;
    }
    public ArrayList<Club> getAutresClubs(){
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/AutresClubs/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs= parseAutresClubs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubs;
    }
    public ArrayList<Club> getStatClubs(){
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/stat";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs= parseStatClubs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubs;
    }


//    public boolean addTask(Club t) {
//        String url = Statics.BASE_URL + "/tasks/" + t.getName() + "/" + t.getStatus();
//        req.setUrl(url);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }

    public ArrayList<Club> parseClubs(String jsonText){
        try {
            clubs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Club t = new Club();
                float id = Float.parseFloat(obj.get("idClub").toString());
                t.setIdClub((int)id);
                t.setNomClub(obj.get("nomClub").toString());
                t.setAdresseClub(obj.get("adresseClub").toString());
                t.setDescriptionClub(obj.get("descriptionClub").toString());
                clubs.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return clubs;
    }
  
    
    public ArrayList<Club> getAllClubs(){
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/all/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs = parseClubs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubs;
    }
    
}
