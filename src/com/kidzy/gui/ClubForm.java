/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.charts.ClubPieChart;
import com.kidzy.entities.Club;
import com.kidzy.entities.Inscription;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;
import com.kidzy.services.ServiceClub;
import com.kidzy.services.ServiceInscription;
import java.util.ArrayList;


public class ClubForm extends BaseForm{
    
    public ClubForm(){
        
     this(com.codename1.ui.util.Resources.getGlobalResources());
     
    }
      public Form StatClub(com.codename1.ui.util.Resources theme) {

        ClubPieChart a = new ClubPieChart();
        Form stats_Form = a.execute();
        stats_Form.getToolbar().addMaterialCommandToLeftBar("back", FontImage.MATERIAL_ARROW_BACK, ev -> {
            new ClubForm().show();
        });

        return stats_Form;
    }

    @Override
    protected boolean isCurrentClub() {
        return super.isCurrentClub(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ClubForm (com.codename1.ui.util.Resources resourceObjectInstance) {
        
         initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Mes Club", "Title")
                        
                )
        );
        
        
        installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        getToolbar().addCommandToOverflowMenu("Stat Club", null, ev -> {
            StatClub(resourceObjectInstance).show();
        });
        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);
        
    }
    
    
    //-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_100 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_101 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
     private com.codename1.ui.Label gui_Label_10 = new com.codename1.ui.Label();
      private com.codename1.ui.Label gui_Label_11 = new com.codename1.ui.Label();
       private com.codename1.ui.Label gui_Label_12 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();

     private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
        private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();
// <editor-fold defaultstate="collapsed" desc="Generated Code">     
       
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance){
            
            
             setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("ClubForm");
        setName("ClubForm");
        
        addComponent(gui_Container_1);
        
        gui_Container_1.setName("Container_1");
          gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.setName("Container_2");
       gui_Button_2.setText(" + Autres Clubs ");
        gui_Button_2.setName("Button_2");
        gui_Button_2.addActionListener(e -> new AutresClubsForm().show());
         user User =Session.getCurrentSession();
         ArrayList<Inscription> club = ServiceInscription.getInstance().getMesClubs(User.getId());
       
        
       
       gui_Button_2.setUIID("InboxNumber");
       gui_Button_2.setIcon(resourceObjectInstance.getImage("image"));
     
      /* gui_Button_3.setText(" Label 2");
        gui_Button_3.setName("Button_2");
        gui_Button_3.setUIID("InboxNumber4");
        gui_Button_3.setIcon(resourceObjectInstance.getImage("image"));
        */
      
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
        gui_Container_4.setName("Container_4");
        
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
     
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_5);
        gui_Container_3.setName("Container_3");
        gui_Container_5.setName("Container_5");
         Container mariem =new Container(new FlowLayout(Component.CENTER));
        Container ma = new Container(BoxLayout.y());

        gui_Container_3.addComponent(gui_Label_3);
        
      gui_Container_3.addComponent(gui_Label_2);
        gui_Label_3.setText(" > Liste des clubs ");
        gui_Label_3.setName("Label_3");
        gui_Label_3.setUIID("BoldLabel");
       gui_Container_5.addComponent(mariem);
         
         for (int i=0 ;i<club.size();i++){ 

        Label clubN = new Label(club.get(i).getClub().getNomClub());
               Label nom = new Label(club.get(i).getEnfant().getNom_enfant()+" "+club.get(i).getEnfant().getPrenom_enfant());
                int  idC=club.get(i).getClub().getIdClub();
                int  idE=club.get(i).getEnfant().getId_enfant();
                int  idI=club.get(i).getIdInscrit();
               
             clubN.setUIID("BoldLabel");

               Button btn = new Button("Details");
               btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    System.out.println(idI);
                    System.out.println(idC);
                    System.out.println(idE);

                 DetailstForm details;
//                 
                details = new DetailstForm(idI,idC,idE);
//// ArrayList<Inscription> club = ServiceInscription.getInstance().getDetailsClubs(idI, idC, idE);
//   Label nomClub = new Label(club.get(0).getClub().getNomClub());
//   Label nomClub = new Label(club.getClub().getNomClub());
//       Form details = new Form();
//       details.add(nomClub);
                 details.show();
            }
        });

        ma.add(clubN).add(nom).add(btn);

        }
                 mariem.add(ma);
                  

        ((com.codename1
                .ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
      
        addComponent(gui_Container_1_1);
        gui_Container_1_1.setName("Container_1_1");
        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_1);
        gui_Container_2_1.setName("Container_2_1");
        gui_Container_2_1.setName("Container_2_1");
        gui_Container_2_1.addComponent(gui_Button_3);
        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_1);
        gui_Container_4_1.setName("Container_4_1");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
         gui_Container_4_1.addComponent(gui_Button_2);
      
        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_1);
        gui_Container_3_1.setName("Container_3_1");
    
       
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3_1.setName("Container_3_1");
       
        addComponent(gui_Container_1_2);
        gui_Container_1_2.setName("Container_1_2");
        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_2);
        gui_Container_2_2.setName("Container_2_2");
    /*
       gui_Button_4.setText(" Label 4 ");
        gui_Button_4.setName("Button_4");
        gui_Button_4.setUIID("InboxNumber3");
        gui_Button_4.setIcon(resourceObjectInstance.getImage("image"));
        gui_Container_2_2.addComponent(gui_Button_4);
        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_2);
        gui_Container_4_2.setName("Container_4_2");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
  
        gui_Button_5.setText(" Label 5");
        gui_Button_5.setName("Button_5");
        gui_Button_5.setUIID("InboxNumber2");
        gui_Button_5.setIcon(resourceObjectInstance.getImage("image"));
        gui_Container_4_2.addComponent(gui_Button_5);
       
        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_2);
        gui_Container_3_2.setName("Container_3_2");
     
      */
     /*   ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3_2.setName("Container_3_2");
        
        addComponent(gui_Container_1_3);
        gui_Container_1_3.setName("Container_1_3");
  gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_3);
        gui_Container_2_3.setName("Container_2_3");
        
        gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_3);
        gui_Container_4_3.setName("Container_4_3");
       
    
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
      
        gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_3);
        gui_Container_3_3.setName("Container_3_3");
      gui_Container_3_3.addComponent(gui_Label_5);
        gui_Label_5.setText("Label 6");
        gui_Label_5.setName("Label_5");
        gui_Label_5.setUIID("BoldLabel");
      
     */   
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3_3.setName("Container_3_3");
         gui_Label_6.setIcon(resourceObjectInstance.getImage("image"));
          gui_Label_6.setUIID("CenterLabel");
       gui_Container_3_3.addComponent(gui_Label_6);
       Container ct = new Container(BoxLayout.xCenter());
       Container ct2 = new Container(BoxLayout.yCenter());
        Container ct3 = new Container(BoxLayout.yCenter());
         Container ct4 = new Container(BoxLayout.yCenter());
         Container ct5 = new Container(BoxLayout.yCenter());
          
       
       gui_Label_7.setText("224");
       gui_Label_7.setName("Label_7");
       gui_Label_7.setUIID("CenterLabelCmp");
       gui_Label_8.setText("Label");
       gui_Label_8.setName("Label_8");
       gui_Label_8.setUIID("CenterLabelCmp");
       ct2.add(gui_Label_7).add(gui_Label_8);
       gui_Label_9.setText("Label");
       gui_Label_9.setName("Label_9");
       gui_Label_9.setUIID("CenterLabelCmp");
       gui_Label_10.setText("Label");
       gui_Label_10.setName("Label_10");
       gui_Label_10.setUIID("CenterLabelCmp");
       ct3.add(gui_Label_9).add(gui_Label_10);
       gui_Label_11.setText("Label");
       gui_Label_11.setName("Label_10");
       gui_Label_11.setUIID("CenterLabelCmp");
       gui_Label_12.setText("Label");
       gui_Label_12.setName("Label_12");
       gui_Label_12.setUIID("CenterLabelCmp");
        ct4.add(gui_Label_11).add(gui_Label_12);
        ct.add(ct5).add(ct2).add(ct3).add(ct4);
       
          gui_Container_3_3.addComponent(ct);
        gui_Container_1_4.setName("Container_1_4");
         gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_4);
        gui_Container_2_4.setName("Container_2_4");
      

        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_4);
        gui_Container_4_4.setName("Container_4_4");
      
       
        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_4);
        gui_Container_3_4.setName("Container_3_4");
      
        gui_Container_1.setName("Container_1");
       
        gui_Container_1_1.setName("Container_1_1");
      
        gui_Container_1_2.setName("Container_1_2");
       
        gui_Container_1_3.setName("Container_1_3");
        
        gui_Container_1_4.setName("Container_1_4");
        
    }// </editor-fold>
        
    
}
