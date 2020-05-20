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

import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Painter;
import com.codename1.ui.RadioButton;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Facture;
import com.kidzy.services.ServiceFacture;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class SelectchildForm extends com.codename1.ui.Form {

    public SelectchildForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    class BgPainter implements Painter {
        private Container parent;
        private Image pic;
        private int textHeight;
        
        public BgPainter(Container parent, Image pic, int textHeight) {
            this.parent = parent;
            this.pic = pic;
            this.textHeight = textHeight;
        }

        
        @Override
        public void paint(Graphics g, Rectangle rect) {
            int mm1 = Display.getInstance().convertToPixels(2);
                
            GeneralPath gp = new GeneralPath();
            float x = parent.getX() + mm1;
            float radius = mm1;
            float y = parent.getY() + mm1;
            float widthF = parent.getWidth() - (2 * mm1);
            float heightF = parent.getHeight()- (2 * mm1);
            gp.moveTo(x + radius, y);
            gp.lineTo(x + widthF - radius, y);
            gp.quadTo(x + widthF, y, x + widthF, y + radius);
            gp.lineTo(x + widthF, y + heightF - radius);
            gp.quadTo(x + widthF, y + heightF, x + widthF - radius, y + heightF);
            gp.lineTo(x + radius, y + heightF);
            gp.quadTo(x, y + heightF, x, y + heightF - radius);
            gp.lineTo(x, y + radius);
            gp.quadTo(x, y, x + radius, y);
            gp.closePath();            

            g.setColor(0xffffff);
            g.setAntiAliased(true);
            int [] clip = g.getClip();
            if(g.isShapeClipSupported()) {
                g.setClip(gp);
            } else {
                // we won't have a round rect but at least we will respect its bounds
                Rectangle r = gp.getBounds();
                g.setClip(r.getX(), r.getY(), r.getWidth(), r.getHeight());
            }
            int pw = pic.getWidth();
            float ratio = ((float)pw) / ((float)pic.getHeight());
            int width = parent.getWidth();
            float height = ((float)width) * ratio;
            int hh = (mm1 * 2) + textHeight;
            if(height < parent.getHeight() - hh) {
                hh = (int)(parent.getHeight() - height);
            }
            
            g.drawImage(pic, parent.getX(), parent.getY(), width, (int)height);
            g.setColor(0xffffff);
            g.setAlpha(255);
            g.fillRect(parent.getX(), parent.getY() + parent.getHeight() - hh, parent.getWidth(), hh);
            g.fillTriangle(parent.getX(), parent.getY() + parent.getHeight() - hh, 
                    parent.getX() + parent.getWidth(), parent.getY() + parent.getHeight() - hh,
                    parent.getX() + parent.getWidth(), parent.getY() + parent.getHeight() - hh - (mm1 * 2));
            g.setClip(clip);
        }
        
    }
    
    public SelectchildForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setUIID("Welcome");
        setTitle("");
        getTitleArea().setUIID("Container");
        ButtonGroup bg = new ButtonGroup();

        int j=0;
        //for (Enfant obj : listpacks) {
          for (int i = 0; i < listpacks.size(); i++) 
          {
            if(ServiceFacture.getInstance().getpayed().contains(listpacks.get(i))){
                   
               }
            gui_tab.get(j).setToggle(true);
            gui_tab.get(j).setUIID("Label");
            
            bg.add(gui_tab.get(j));
            if (j==0){gui_tab.get(j).setSelected(true);}
            
            Image bla = resourceObjectInstance.getImage("user-3.jpg");
            
            gui_tabRoot.get(j).setLayout(new BorderLayout());
            content.get(j).add(new Label(listpacks.get(i).getNom_enfant()+" "+listpacks.get(i).getPrenom_enfant(), "WelcomeTitle")).add(new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle"));
            content.get(j).setUIID("WelcomeContent");
                
                gui_tabRoot.get(j).add(BorderLayout.SOUTH, content.get(j));
               
                gui_tabRoot.get(j).getUnselectedStyle().setBgPainter(new BgPainter(gui_tabRoot.get(j), bla, content.get(j).getPreferredH() +
                content.get(j).getUnselectedStyle().getPaddingTop() + 
                content.get(j).getUnselectedStyle().getPaddingBottom() + 
                content.get(j).getUnselectedStyle().getMarginTop() + 
                content.get(j).getUnselectedStyle().getMarginBottom()));

                    if(gui_tab.get(j).isSelected()) {
                         gui_tab.get(j).setSelected(true);
                         
                    }
                j++;
                
                
                //gui_Tabs_1.hideTabs();
                gui_Tabs_1.getContentPane().setUIID("Container");
        
          }
          idenfant = listpacks.get(0);
        gui_Tabs_1.addSelectionListener(new SelectionListener() {

                @Override
                public void selectionChanged(int oldSelected, int newSelected) {
                    //System.out.println(newSelected+1);
                    idenfant =listpacks.get(newSelected);
                    //System.out.println(idenfant);
                }
            });
        
        
        
             
        
        
        
        /*String line1 =  "The rule of thirds states that an image is\nmost pleasing when its subjects or\nregions are ...";
        if(!Display.getInstance().isTablet()) {
            line1 = line1.replace('\n', ' ');
        }*/

        
        

        /*Container content2 = BoxLayout.encloseY(
                new Label("Rule of Page 2", "WelcomeTitle"),
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
                //new SpanLabel(line2, "WelcomeBody")
        );*/

        

        
        
        
        

        
       /* gui_Tabs_1.addSelectionListener((i, ii) -> {
            switch(ii) {
                
                case 0:
                    gui_tab1.setSelected(true);
                    break;
                case 1:
                    gui_tab2.setSelected(true);
                    break;
                default:
                    gui_tab3.setSelected(true);
                    break;
            }
        });*/

        /*gui_Tabs_1.hideTabs();
        gui_Tabs_1.getContentPane().setUIID("Container");*/
        //gui_slide1Image
    }

    @Override
    protected Component createStatusBar() {
        Component c = super.createStatusBar();
        c.getUnselectedStyle().setPadding(0, 0, 0, 0);
        return c;
    }

    
    
//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Tabs gui_Tabs_1 = new com.codename1.ui.Tabs();
    private com.codename1.ui.Container gui_tab1Root = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_tab2Root = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Container gui_tab3Root = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.RadioButton gui_tab1 = new com.codename1.ui.RadioButton();
    private com.codename1.ui.RadioButton gui_tab2 = new com.codename1.ui.RadioButton();
    private com.codename1.ui.RadioButton gui_tab3 = new com.codename1.ui.RadioButton();
    private com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    ArrayList<RadioButton> gui_tab = new ArrayList<RadioButton>();
        ArrayList<Enfant> listpacks = ServiceFacture.getInstance().getenfantsp(7);
       ArrayList<Container> gui_tabRoot = new ArrayList<Container>();
        ArrayList<Container> content = new ArrayList<Container>();
        Enfant idenfant = null;


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_tab3.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_tab3) {
                ontab3ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setUIID("Welcome");
        setTitle("");
        setName("WalkthruForm");
        for (int i = 0; i < listpacks.size(); i++) {
        content.add(BoxLayout.encloseY());
        gui_tabRoot.add(new Container(new BoxLayout(BoxLayout.Y_AXIS)));
        gui_tab.add(new RadioButton());
        }
        
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Tabs_1);
        gui_Tabs_1.setName("Tabs_1");
        
        for (int i = 0; i<gui_tabRoot.size(); i++) {
            int k = i+1 ;
        gui_Tabs_1.addTab(" "+k+" " ,gui_tabRoot.get(i));
        //gui_Tabs_1.addT
        
        
        
        gui_tabRoot.get(i).setUIID("Card");
        gui_tabRoot.get(i).setName("tab"+i+"Root");
        }
        
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_4);
        gui_Container_4.setName("Container_4");
        gui_Container_4.addComponent(gui_Container_3);
        gui_Container_3.setName("Container_3");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        for (int i = 0; i<gui_tab.size(); i++) {
        gui_Container_3.addComponent(gui_tab.get(i));
       
        
        gui_tab.get(i).setSelected(false);
        gui_tab.get(i).setUIID("Label");
        gui_tab.get(i).setName("tab"+i);
            
        gui_tab.get(i).setIcon(resourceObjectInstance.getImage("walthru-radio-unselected.png"));
        gui_tab.get(i).setPressedIcon(resourceObjectInstance.getImage("walthru-radio-selected.png"));
        }
        
        
         gui_Container_4.addComponent(gui_Container_6);
        gui_Container_6.setUIID("GetStartedButton");
        gui_Container_6.setName("Container_6");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.addComponent(gui_Button_1);
        gui_Container_6.addComponent(gui_Label_1);
        gui_Button_1.setText("Get Started");
        gui_Button_1.setUIID("GetStartedButton");
        gui_Button_1.setName("Button_1");
        /*ArrayList<String> p = new ArrayList<String>();
        for (Enfant obj : ServiceFacture.getInstance().getpayed())
        {
                p.add(obj.getPrenom_enfant());
        }
        if (p.contains(idenfant.getPrenom_enfant())){ gui_Button_1.addActionListener(alreadypayed); }
        else { gui_Button_1.addActionListener(notpayed); }*/
        //gui_Button_1.addActionListener(null);
        gui_Button_1.setTextPosition(com.codename1.ui.Component.LEFT);
        gui_Label_1.setUIID("GetStartedRedArrow");
        gui_Label_1.setName("Label_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1,"".charAt(0));
        gui_Container_3.setName("Container_3");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.setUIID("GetStartedButton");
        gui_Container_6.setName("Container_6");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Tabs_1.setName("Tabs_1");
        gui_Container_4.setName("Container_4");
    }//}// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void ontab3ActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        ArrayList<String> p = new ArrayList<String>();
        for (Enfant obj : ServiceFacture.getInstance().getpayed())
        {
                p.add(obj.getPrenom_enfant());
        }
        
        if (p.contains(idenfant.getPrenom_enfant())){ 
                ArrayList<Facture> listf = ServiceFacture.getInstance().getFacturesbyenfant(idenfant.getId_enfant());
                Facture f = listf.get(0);
                new PaymentSuccessForm(com.codename1.ui.util.Resources.getGlobalResources(), f).show();
        }
        else{ new PricingForm(com.codename1.ui.util.Resources.getGlobalResources(), idenfant).show();}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ActionListener<ActionEvent> alreadypayed = new ActionListener<ActionEvent>() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ArrayList<Facture> listf = ServiceFacture.getInstance().getFacturesbyenfant(idenfant.getId_enfant());
                Facture f = listf.get(0);
                new PaymentSuccessForm(com.codename1.ui.util.Resources.getGlobalResources(), f).show();
        }
    };
    
    
    
    ActionListener<ActionEvent> notpayed = new ActionListener<ActionEvent>() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            new PricingForm(com.codename1.ui.util.Resources.getGlobalResources(), idenfant).show();
        }
    };


}
