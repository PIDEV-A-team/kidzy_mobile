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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.kidzy.entities.Classe;
import com.kidzy.entities.Club;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Garde;
import com.kidzy.entities.Inscription;
import com.kidzy.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceInscription {

    public ArrayList<Inscription> Inscriptions;
    public Inscription Inscription;
    
    public ArrayList<Enfant> enfants;
    public Enfant enfant;
    
    public static ServiceInscription instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
       public String result = "";

    private ServiceInscription() {
         req = new ConnectionRequest();
    }

    public static ServiceInscription getInstance() {
        if (instance == null) {
            instance = new ServiceInscription();
        }
        return instance;
    }

    public boolean InscriptionEnfant( String des , int idE,int idC ) {
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/New?descriptionInscrit="+des+"&idEnfant="+idE+"&idClub="+idC;
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
                float id = Float.parseFloat(obj.get("idEnfant").toString());
                e.setId_enfant((int)id);

                e.setNom_enfant(obj.get("nomEnfant").toString());
                e.setPrenom_enfant(obj.get("prenomEnfant").toString());
                
                
                enfants.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfants;
    }
    public ArrayList<Enfant> ListEnfant(int idParent){
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/enfant/"+idParent;
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
    
    
 public ArrayList<Inscription> parseClubs(String jsonText){
        try {
            Inscriptions=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            for(Map<String,Object> obj : list){
                Club club = new Club();
            Enfant Enfant = new Enfant();
                Inscription t = new Inscription();
                float id = Float.parseFloat(obj.get("idInscrit").toString());
                t.setIdInscrit((int)id);
               // t.setDescInscrit(obj.get("descriptionInscrit").toString());
//                t.setDateInscrit(obj.get("dateInscrit").toString());
                       club.setNomClub(obj.get("nomClub").toString());
                float idC = Float.parseFloat(obj.get("idClub").toString());

                       club.setIdClub((int)idC);
                t.setClub(club);
                                float idE = Float.parseFloat(obj.get("idEnfant").toString());
                       Enfant.setId_enfant((int)idE);

                Enfant.setNom_enfant(obj.get("nomEnfant").toString());
                Enfant.setPrenom_enfant(obj.get("prenomEnfant").toString());
                t.setEnfant(Enfant);
                Inscriptions.add(t);
            }
            
            
            
        } catch (IOException ex) {
            
        }
        return Inscriptions;
    }
  
    public ArrayList<Inscription> parseDetailsClubs(String jsonText){
       
//                Inscription t = new Inscription();
//        try {
////            Inscriptions=new ArrayList<>();
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> obj = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));            
//            
//                 Club club = new Club();
//            Enfant Enfant = new Enfant();
////                float id = Float.parseFloat(obj.get("idInscrit").toString());
////                t.setIdInscrit((int)id);
////                t.setDescInscrit(obj.get("descriptionClub").toString());
//              //t.setDateInscrit(obj.get("dateInscrit").toString());
//               //  club.setNomClub(obj.get("nomClub").toString());
//                       club.setAdresseClub(obj.get("adresseClub").toString());
//                t.setClub(club);
//                Enfant.setNom_enfant(obj.get("nomEnfant").toString());
//                Enfant.setPrenom_enfant(obj.get("prenomEnfant").toString());
//                t.setEnfant(Enfant);
//            
//            
//            
//            
//        } catch (IOException ex) {
//            
//        }
//        return t;
try{
               Inscriptions=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            for(Map<String,Object> obj : list){
                                Inscription t = new Inscription();

                 Club club = new Club();
            Enfant Enfant = new Enfant();
               club.setNomClub(obj.get("nomClub").toString());
                       club.setAdresseClub(obj.get("adresseClub").toString());
                t.setClub(club);
                Enfant.setNom_enfant(obj.get("nomEnfant").toString());
                Enfant.setPrenom_enfant(obj.get("prenomEnfant").toString());
                t.setEnfant(Enfant);  
                t.setDescInscrit(obj.get("descriptionInscrit").toString());
               // t.setDateInscrit((Date) obj.get("dateInscrit"));
                       
Inscriptions.add(t);
            }
            
            
            
} catch (IOException ex) {
            
        }
        return Inscriptions;
    }
  
    public ArrayList<Inscription> getMesClubs(int idUser){
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/MesClubs/"+idUser;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Inscriptions= parseClubs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Inscriptions;
    }
    public ArrayList<Inscription> getDetailsClubs(int idI,int idC,int idE){
     String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/Details/"+idI+"/"+idC+"/"+idE;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Inscriptions= parseDetailsClubs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        return Inscriptions;
    }
    public String DeleteClub(int idInscrit) {
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/Quitter/"+idInscrit;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        System.out.println(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    String data = new String(req.getResponseData());
                    JSONParser j = new JSONParser();
                    Map<String, Object> tasksListJson;
                    tasksListJson = j.parseJSON(new CharArrayReader(data.toCharArray()));
                    result = (String) tasksListJson.get("body");

                } catch (IOException ex) {
                    ex.getMessage();
                }
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
       public String PrintClub(int idInscrit,int idClub , int idEnfant) {
        String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/club/print/"+idInscrit+"/"+idClub+"/"+idEnfant;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        System.out.println(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    String data = new String(req.getResponseData());
                    JSONParser j = new JSONParser();
                    Map<String, Object> tasksListJson;
                    tasksListJson = j.parseJSON(new CharArrayReader(data.toCharArray()));
                    result = (String) tasksListJson.get("body");

                } catch (IOException ex) {
                    ex.getMessage();
                }
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
 
}
