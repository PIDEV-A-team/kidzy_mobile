/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.kidzy.entities.Club;
import com.kidzy.services.ServiceClub;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListClubForm extends Form{

    public ListClubForm() {
        setTitle("Liste clubs");
        ArrayList<Club> club = ServiceClub.getInstance().getAllClubs();
        Container ct =new Container(BoxLayout.y());
        for (int i=0 ;i<club.size();i++){
        Label nom = new Label(club.get(i).getNomClub());
        Label desc = new Label(club.get(i).getDescriptionClub());
        
        
        Slider s =new Slider();
        ct.add(s).add(nom).add(desc);
//        ct.getStyle().setBgColor(0x99CCCC);
//        ct.getStyle().setBgTransparency(255);


        }
        
        add(ct);
    }
    
    
}
