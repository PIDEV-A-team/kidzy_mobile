/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.services.ServicePack;


/**
 *
 * @author bhk
 */
public class Efef extends BaseForm{

    public Efef(Form previous,com.codename1.ui.util.Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Pricing", "Title")
                        
                )
        );
        getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {});
        installSidemenu(res);
        SpanLabel sp = new SpanLabel();
        sp.setText(ServicePack.getInstance().getAllPacks().toString());
        /*add(sp);*/
        Container pack = new Container(new BorderLayout(),"packcontainer");
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label l = new Label("Nos Tarifs");
        l.setUIID("tarif");    
        c.add(l);        
        
        Label l2 = new Label("Premuim Pack");
        l2.setUIID("packlabel");
        pack.add(BorderLayout.NORTH,l2);
        c.add(pack);
        add(c);
    }
    
    
}
