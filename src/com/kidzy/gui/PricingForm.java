/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.kidzy.gui;


import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Facture;
import com.kidzy.entities.Pack;
import com.kidzy.services.ServiceFacture;
import com.kidzy.services.ServicePack;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.Date;
import org.joda.time.DateTime;


/**
 * 
 *
 * @author Shai Almog
 */
public class PricingForm extends BaseForm {
    public PricingForm(Resources res , Enfant idenfant) {
        setLayout(new BorderLayout());
        setUIID("StatsForm");
        installSidemenu(res);
        float total = 0;
        String enddate= null ;
        getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {
           
        });
        
        getToolbar().addCommandToOverflowMenu("Changer d'enfant",null, (ActionListener) (ActionEvent evt1) -> {new SelectchildForm(res).show();});
        
        Button toggle = new Button("");
        toggle.setUIID("CenterWhite");
        FontImage.setMaterialIcon(toggle, FontImage.MATERIAL_ACCESS_TIME);
        toggle.getAllStyles().setMargin(0, 0, 0, 0);
        toggle.getAllStyles().setBorder(RoundBorder.create().
                rectangle(true).
                color(0x9b4c3f));
        Button placeholder = new Button("");
        placeholder.setUIID("CenterWhite");
        Container buttonGrid = GridLayout.encloseIn(2, toggle, placeholder);
        Label leftLabel = new Label("", "CenterWhite");
        FontImage.setMaterialIcon(leftLabel, FontImage.MATERIAL_ACCESS_TIME);
        Label rightLabel = new Label("", "CenterWhite");
        FontImage.setMaterialIcon(rightLabel, FontImage.MATERIAL_DIRECTIONS_RUN);
        Container labelGrid = GridLayout.encloseIn(2, leftLabel, rightLabel);
        labelGrid.getAllStyles().setBorder(RoundBorder.create().
                rectangle(true).
                color(0xd27d61));
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                    LayeredLayout.encloseIn(labelGrid, buttonGrid)
                )
        );
        
        ActionListener al = e -> {
            if(buttonGrid.getComponentAt(0) == toggle) {
                toggle.remove();
                buttonGrid.add(toggle);
                buttonGrid.animateLayoutAndWait(150);
                FontImage.setMaterialIcon(toggle, FontImage.MATERIAL_DIRECTIONS_RUN);
                
            } else {
                placeholder.remove();
                buttonGrid.add(placeholder);
                buttonGrid.animateLayoutAndWait(150);
                FontImage.setMaterialIcon(toggle, FontImage.MATERIAL_ACCESS_TIME);
            }
        };
        toggle.addActionListener(al);
        placeholder.addActionListener(al);
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        
        ArrayList<Pack> listpacks = ServicePack.getInstance().getAllPacks();
        
        ArrayList<Container> p = new ArrayList<Container>();
        for (int i = 0; i < listpacks.size(); i++) {
        p.add(new Container(new BoxLayout(BoxLayout.Y_AXIS)));
        }
        int i =0;
        for (Pack obj : listpacks) { 	 
            
            String nom_pack = obj.getNom_pack();
            String prix = obj.getPrix_pack()+"DT";
            String prixyear = obj.getPrix_pack_year()+"DT";
            String desc = obj.getDescription_pack();
            p.get(i).add( createTop(res, nom_pack)).add(createTopGrid(res,prix,prixyear,desc)); 
            
            if (i ==0){
                p.get(i).setUIID("packpremuim");
                p.get(i).getStyle().setBgTransparency(255);
                
            }
           
            if (i ==1){
                p.get(i).setUIID("packstandard");
                p.get(i).getStyle().setBgTransparency(255);

            }
            if (i ==2){
                p.get(i).setUIID("packbasic");
                p.get(i).getStyle().setBgTransparency(255);
            }
                
            c.add(new Label("separator", "separatorpack")).add(p.get(i)).add(new Label("separator", "separatorpack"));
            final int k = i;
            Button myBtn = new Button();
                myBtn.addActionListener(e -> {
                    Facture f = new Facture();
                    f.setIdEnf(idenfant);
                    f.setIdParent(idenfant.getIdParent());
                    f.setPack(obj);
                    
                    f.setTotal(obj.getPrix_pack());
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    String end  =dateFormat.format(new DateTime().plusMonths(1).toDate());
                
                    f.setDue_date_facture(end);
                    
                         if (Dialog.show("Confirm", "Do you want to proceed?", "OK", "Cancel")) {
                             ServiceFacture.getInstance().addFacture(f);
                             System.out.println("");
                             new PaymentSuccessForm(res, f).show();
                          }
                         else{}
                         
                        
                    
                    
                });

                
                p.get(i).setLeadComponent(myBtn);
        i++;
        }
 
        
          
        Label l = new Label("Nos Tarifs", "LargeWhileLabel");
        l.getAllStyles().setAlignment(LEFT);
        
        l.getAllStyles().setPaddingLeft(3);
        
        add(BorderLayout.NORTH ,l);
        add(BorderLayout.CENTER, c);
        
        
    }

    Container gridElement(Resources res, String prix, String label, boolean last) {
         Container c ;
        if (prix.contains("DT")){
           int index = prix.indexOf("DT");
            String rep =prix.substring(0, index);
             
             c = BorderLayout.centerAbsolute(
                
                BoxLayout.encloseY(
                    FlowLayout.encloseCenter(new Label(rep, "packLargeWhileLabelprix"),
                            
                            new Label("DT", "Smallpacklabel")
                    ),
                    new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"),
                    new Label(label, "packStatsLabel")
                )
        );
        /*if(last) {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, 0x5b636b), null, null));
        } else {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, 0x5b636b), null, 
                    Border.createLineBorder(2, 0x5b636b)));
        }*/
        return c;
        }
        else {
             c = BorderLayout.centerAbsolute(
                
                BoxLayout.encloseY(
                    FlowLayout.encloseCenter(new Label(prix, "packLargeWhileLabelprix")
            ),
                    new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"),
                    new Label(label, "packStatsLabel")
                )
        );
        /*if(last) {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, 0x5b636b), null, null));
        } else {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, 0x5b636b), null, 
                    Border.createLineBorder(2, 0x5b636b)));
        }*/
        return c;
        }
    
    }
        
    
    
    
    Container createTopGrid(Resources res,String prix,String prix_year,String desc) { 
        
        return  
                GridLayout.encloseIn(3, 
                gridElement(res, prix, "Par mois", false),
                gridElement(res, prix_year, "Yearly", false),
                gridElement(res, desc, "Description", true));
        
    }
    
     Container createTop(Resources res, String nom_pack) {
        Container c = new Container(new BorderLayout());
     
        Label l = new Label(nom_pack, "packLargeWhileLabel");
        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c2.add(l).add(new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"));
        c.add(BorderLayout.NORTH,c2);
        //c.add(BorderLayout.NORTH,new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"));
        return c;
        }
    
    @Override
    protected boolean isCurrentStats() {
        return true;
    }
}
