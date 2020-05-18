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
public class ServiceGarde {
    
      public ArrayList<Garde> gardes;
    
    public static ServiceGarde instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceGarde() {
         req = new ConnectionRequest();
    }

    public static ServiceGarde getInstance() {
        if (instance == null) {
            instance = new ServiceGarde();
        }
        return instance;
    }


    public ArrayList<Garde> parseGardes(String jsonText){
        try {
            gardes=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> gardesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)gardesListJson.get("root");
            for(Map<String,Object> obj : list){
                Garde t = new Garde();
              /*  float id = Float.parseFloat(obj.get("id").toString());
                t.setId_garde((int)id);
*/
             float id_garde = Float.parseFloat(obj.get("id_garde").toString());
             System.out.println(id_garde);
             t.setId_garde((int) id_garde);
               t.setNom_garde(obj.get("nom_garde").toString());
               t.setDuree_garde(obj.get("duree_garde").toString());
                
                 System.out.println(t);
                gardes.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return gardes;
    }
    
    public ArrayList<Garde> getAllGardes(){
        String url = Statics.BASE_URL+"/kidzy/garde/gardes/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                gardes = parseGardes(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return gardes;
    }
}
