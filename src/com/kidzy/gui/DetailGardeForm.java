/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.entities.Classe;

/**
 *
 * @author ferja
 */
public class DetailGardeForm extends BaseForm{
    
     public DetailGardeForm(int idGrade, String nomGarde, String dureeGarde) {
         this(com.codename1.ui.util.Resources.getGlobalResources());
         
           //gui_Container_5.addComponent(gui_Label_1_1);
        
        gui_Label_1_1.setText(nomGarde);
         gui_Label_4_1.setText(dureeGarde);
       
             
           
    }
    
      public DetailGardeForm (com.codename1.ui.util.Resources resourceObjectInstance){
         
         
         initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Détail garde", "Title")
                        
                )
        );
        
       // FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
      // getToolbar().addCommandToLeftBar("", mat, e -> new EnfantForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EnfantForm().showBack());
        getToolbar().addCommandToRightBar("",resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
     }
      
      
      
        //-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
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
 private com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
  private com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
   private com.codename1.ui.Container gui_Container_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container gui_Container_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
     private com.codename1.ui.Container gui_Container_9 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
     
     private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
        private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();

       
        private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
  private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
   private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4= new com.codename1.ui.TextField();
   private com.codename1.ui.ComboBox<Classe>  combo = new  com.codename1.ui.ComboBox();

    
   
// <editor-fold defaultstate="collapsed" desc="Generated Code">     
       
    
     
       
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance){
            
            
            
            setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("DetailGardeForm");
        setName("DetailGardeForm");
        
       
        
        
        addComponent(gui_Container_3);
        
        // gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
         
        //  ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
       gui_Container_3.getStyle().setFgColor(0xFFFFFF);
        gui_Container_3.addComponent(gui_Label_1);
      //  gui_Container_3.getStyle().getBgColor();
      
        
        gui_Container_3.addComponent(gui_Label_7);
      
       // gui_Label_7.setText("Image ");
        gui_Label_7.setName("Label_3");
        
     
  
        
        gui_Container_3.addComponent(gui_Container_5);
       gui_Container_5.addComponent(gui_Label_2);
        gui_Label_2.setText(" Libelle :");
        gui_Label_2.setName("nom");
        gui_Label_2.setUIID("BoldLabel");
        
       gui_Container_5.addComponent(gui_Label_1_1);
        
       // gui_Label_1_1.setText(nom_enfant);
        
         gui_Container_3.addComponent(gui_Container_6);
       gui_Container_6.addComponent(gui_Label_4);
        gui_Label_4.setText(" Durée :");
        gui_Label_4.setName("prénom");
        gui_Label_4.setUIID("BoldLabel");
        
       gui_Container_6.addComponent(gui_Label_4_1);
       // gui_Label_4_1.setText("Ferjani");
        
        
       /* gui_Container_3.addComponent(gui_Container_7);
     gui_Container_7.addComponent(gui_Label_6);
        gui_Label_6.setText(" Classe :" );
        gui_Label_6.setName("classe");
        gui_Label_6.setUIID("BoldLabel");
        gui_Container_7.addComponent(gui_Label_3_1);
       //  gui_Label_3_1.setText("");
        
      /* gui_Container_3.addComponent(combo);
        combo.setName("com_classe");
       // combo.setHint("Classe 1");
 
        ////////////////////////////// COMBOBOX
      /*  ComboBox<Map<String, Object>> comboo = new ComboBox<> (
          createListEntry("A Game of Thrones", "1996"),
          createListEntry("A Clash Of Kings", "1998"),
          createListEntry("A Storm Of Swords", "2000"),
          createListEntry("A Feast For Crows", "2005"),
          createListEntry("A Dance With Dragons", "2011"),
          createListEntry("The Winds of Winter", "2016 (please, please, please)"),
          createListEntry("A Dream of Spring", "Ugh"));
  
  combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));
         gui_Container_3.addComponent(comboo);
  
        */
        ///////////////////////////
    /* gui_Container_3.addComponent(gui_Container_8);
     gui_Container_8.addComponent(gui_Label_5);
        gui_Label_5.setText(" Date de naissance :");
        gui_Label_5.setName("date");
        gui_Label_5.setUIID("BoldLabel");
       gui_Container_8.addComponent(gui_Label_2_3);
       // gui_Label_2_3.setText("1020");
        
       
       gui_Container_3.addComponent( gui_Container_9);
        gui_Container_9.addComponent( gui_Label_9);
         gui_Label_9.setText(" Garderie :");
        gui_Label_9.setName("garde");
        gui_Label_9.setUIID("BoldLabel");
       gui_Container_9.addComponent(gui_Label_2_4);
       // gui_Label_2_4.setText("1020"); 
        gui_Label_2_4.setUIID("BoldLabel");
        
         gui_Container_3.addComponent( gui_Container_4);
         
       gui_Container_4.addComponent(gui_Button_2);
       gui_Button_2.setText(" Modifier ");
        gui_Button_2.setName("Button_2");
       
         gui_Button_2.setIcon(resourceObjectInstance.getImage("image"));
       gui_Button_2.setUIID("InboxNumber");
       
        gui_Container_4.addComponent(gui_Button_3);
       gui_Button_3.setText(" Supprimer ");
        gui_Button_3.setName("Button_2");
           
       gui_Button_3.setUIID("InboxNumber3");
        gui_Button_3.setIcon(resourceObjectInstance.getImage("image")); 
    
       
    */
        
          
        }
    
}
