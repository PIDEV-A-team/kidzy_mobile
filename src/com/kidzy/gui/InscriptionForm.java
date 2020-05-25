/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.capture.Capture;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.entities.Classe;
import com.kidzy.entities.Club;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Inscription;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;
import com.kidzy.services.ServiceInscription;
import java.io.IOException;
import java.util.ArrayList;


//import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author ferja
 */
public class InscriptionForm extends BaseForm {
    
     //private FileUploader file ;
      String fileNameInServer;
    
    public InscriptionForm(String nom , int id) {
                 this(com.codename1.ui.util.Resources.getGlobalResources());

        gui_Label_1.setText(" > Formulaire d'inscription ");
        gui_Label_1.setName("Label_3");
        gui_Label_1.setUIID("BoldLabel");
//        
//        
        
                 user User =Session.getCurrentSession();

               ArrayList<Enfant> listEnfant = ServiceInscription.getInstance().ListEnfant(User.getId());
  
       
//         gui_Container_3.addComponent(gui_Button_4);
//        gui_Button_4.setName("Button_2");
//        gui_Button_4.setText("importer image");
//        gui_Button_4.setUIID("InboxNumber4");
//        gui_Button_4.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
//        gui_Button_4.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    
////                    try{
////                        imgPath = Capture.capturePhoto();
////                        System.out.println(imgPath);
////                        String link = imgPath.toString();
////                        int pod = link.indexOf("/",2);
////                        String news = link.substring(pod +2, link.length());
////                        System.out.println(""+news);
////                        
////                      //  FileUploader fu = new FileUploader("http://localhost:8080/kidzy_web/web");
////                      //  fileNameInServer = fu.upload(news);
////                      // path.setText(fileNameInServer);
////                    }
////                    catch (IOException ex) {
////                        ex.printStackTrace();
////                    } catch (Exception ex) {
////                       
////                    }
//                }
//            });
//        
//        
        
        gui_Container_3.addComponent(gui_Label_2);
     
        gui_Label_2.setText(" Club ");
        gui_Label_2.setName("nom");
        gui_Label_2.setUIID("Label");
       gui_Container_3.addComponent(gui_Text_Field_1);
        
        gui_Text_Field_1.setName("txt_nom");
        gui_Text_Field_1.setText(nom);
        gui_Text_Field_1.setEditable(false);
        
        
         gui_Container_3.addComponent(gui_Label_4);
     
       
        
        gui_Container_3.addComponent(gui_Label_6);
     
        gui_Label_6.setText(" Enfant");
        gui_Label_6.setName("Enfant");
        gui_Label_6.setUIID("Label");
               gui_Container_3.addComponent(combo);

                 for (int i=0 ;i<listEnfant.size();i++){ 
String nomEnfant =listEnfant.get(i).getNom_enfant();
String prenomEnfant =listEnfant.get(i).getPrenom_enfant();
// idEnfant =listEnfant.get(i).getId_enfant();
        combo.setName("com_Enfant");
        combo.setHint("Classe 1");
        combo.addItem(nomEnfant +" "+prenomEnfant );
                 }
        gui_Container_3.addComponent(gui_Label_5);
     
         gui_Container_3.addComponent(gui_Label_7);
      
        gui_Label_7.setText("Description ");
        gui_Label_7.setName("Label_3");
     gui_Container_3.addComponent(gui_Text_Field_2);
        
        gui_Text_Field_2.setName("txt_nom");
        
     
     System.out.println(id);
  
                                                                                                                                                                       
     
     
                 
         gui_Container_3.addComponent( gui_Container_4);
         
       gui_Container_4.addComponent(gui_Button_2);
       gui_Button_2.setText(" Enregistrer ");
        gui_Button_2.setName("Button_2");
        gui_Button_2.addActionListener((ActionEvent e) -> {
                 int idEnfant =combo.getSelectedIndex();
                 int idEn =listEnfant.get(idEnfant).getId_enfant();
     System.out.println(idEnfant);




        if (ServiceInscription.getInstance().InscriptionEnfant(gui_Text_Field_2.getText(),idEn,id)){
        Dialog.show("Super", "Inscription avec succés", new Command("OK"));
        new AutresClubsForm().show();
//                 
        
        }
        else
             Dialog.show("Erreur", "Inscrit deja !!!", new Command("OK"));
}
        );
       gui_Button_2.setUIID("InboxNumber");
       
//                
gui_Container_4.addComponent(gui_Button_3);
       gui_Button_3.setText(" Annuler ");
        gui_Button_3.setName("Button_2");
        gui_Button_3.addActionListener(e -> new AutresClubsForm().show());       
       gui_Button_3.setUIID("InboxNumber4");
//        gui_Button_3.setIcon(resourceObjectInstance.getImage("image")); 
    
       
    }
    
     public InscriptionForm (com.codename1.ui.util.Resources resourceObjectInstance){
         
         
         initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inscription", "Title")
                        
                )
        );
        
       // FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
      // getToolbar().addCommandToLeftBar("", mat, e -> new EnfantForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AutresClubsForm().showBack());
       // getToolbar().addCommandToRightBar("",resourceObjectInstance.getImage("toolbar-profile-pic.png"), e ->{});
        
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

     private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
        private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();
       
       
        private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
  private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
   private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
   private com.codename1.ui.ComboBox<String>  combo = new  com.codename1.ui.ComboBox();
  
   
// <editor-fold defaultstate="collapsed" desc="Generated Code">     
       
       
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance){
            
            
            
            setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("EnfantForm");
        setName("EnfantForm");
        
       
        
        
        addComponent(gui_Container_3);
        
        // gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
         
        //  ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
      
        gui_Container_3.addComponent(gui_Label_1);
      
        
    
        
          
        }

   
}
