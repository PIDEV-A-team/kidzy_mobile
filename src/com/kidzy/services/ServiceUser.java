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
import com.kidzy.entities.user;
import com.kidzy.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ferja
 */
public class ServiceUser {
    
     public ArrayList<user> userList;
    public user user;
    
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
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

     public user parseUser(String jsonText) {
   
        user UserL = new user();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            if (UserListJson.get("type").equals("Login succeed")) {
                
                UserL.setUsername(UserListJson.get("username").toString());
                UserL.setPassword(UserListJson.get("id").toString());
                float id = Float.parseFloat(UserListJson.get("id").toString());
                UserL.setId((int)id);               
                if (UserListJson.get("role").toString().equals("[ROLE_PARENT]")) {
                    UserL.setRole("parent");
                } else if (UserListJson.get("role").toString().equals("[ROLE_ADMIN]")) {

                    UserL.setRole("maitresse");
                

            } else {
                    UserL.setRole("admin");
            }
                
            }else {
            return null ;}
        } catch (IOException ex) {
                ex.getMessage();
        }

        return UserL;
    }
  public user Login(String username,String password) {
       // String url = "http://localhost/kidzy_web/web/app_dev.php/user/all/"+username+"/"+password;
        String url = Statics.BASE_URL2+"/user/all/"+username+"/"+password;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                user = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return user;
    }
    
}
