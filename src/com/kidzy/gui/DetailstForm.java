/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.entities.Classe;
import com.kidzy.entities.Inscription;
import com.kidzy.services.ServiceInscription;
import java.util.ArrayList;

/**
 *
 * @author ferja
 */
public class DetailstForm extends BaseForm{
    
    //private FileUploader file ;
      String fileNameInServer;
    
    public DetailstForm(int idInscrit ,int idClub, int idEnfant ) {
         this(com.codename1.ui.util.Resources.getGlobalResources());
 ArrayList<Inscription> club = ServiceInscription.getInstance().getDetailsClubs(idInscrit, idClub, idEnfant);
   gui_Label_2.setText(" Club :" +" "+club.get(0).getClub().getNomClub());
        gui_Label_2.setName("nom");
        gui_Label_2.setUIID("Label");
                gui_Container_3.addComponent(gui_Label_2);
        gui_Container_3.addComponent(gui_Label_4);

        gui_Label_4.setText(" Enfant :" +" "+club.get(0).getEnfant().getNom_enfant());
        gui_Label_4.setName("Enfant");
        gui_Label_4.setUIID("Label");
//         gui_Container_3.addComponent(combo);
        combo.setName("com_classe");
//        combo.setHint("Classe 1");
        gui_Container_3.addComponent(gui_Label_5);
     
        gui_Label_5.setText(" Adresse :" +" "+club.get(0).getClub().getAdresseClub());
        gui_Label_5.setName("adresse");
        gui_Label_5.setUIID("Label");
//       gui_Container_3.addComponent(gui_Label_7);
//      
//        gui_Label_7.setText(" Date d'inscription :" +" "+club.get(0).getDateInscrit());
//        gui_Label_7.setName("Label_3");
     gui_Container_3.addComponent(gui_Label_8);
      
        gui_Label_8.setText(" Description  :" +" "+club.get(0).getDescInscrit());
        gui_Label_8.setName("Label_3");
             Button btn =new Button("Quitter");

             gui_Container_3.addComponent(btn);
                          gui_Label_4.setUIID("BoldLabel");
                          gui_Label_8.setUIID("BoldLabel");
                          gui_Label_2.setUIID("BoldLabel");
                          gui_Label_5.setUIID("BoldLabel");


 btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                
                  String msg=ServiceInscription.getInstance().DeleteClub(idInscrit);
                  System.err.println(msg);
                 
 Dialog.show( "Inscription Supprimé !! ",null,"ok",null);
        new ClubForm().show();
                  
            }
        });
       }
    
     public DetailstForm (com.codename1.ui.util.Resources resourceObjectInstance){
         
         
         initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Details Club", "Title")
                        
                )
        );
        
       // FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
      // getToolbar().addCommandToLeftBar("", mat, e -> new EnfantForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new ClubForm().showBack());
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

     private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
        private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
       private com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();
       
       
        private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
  private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
   private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
   private com.codename1.ui.ComboBox<Classe>  combo = new  com.codename1.ui.ComboBox();
  
   
// <editor-fold defaultstate="collapsed" desc="Generated Code">     
       
       
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance){
            
            
            
            setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("DetailsForm");
        setName("DetailsForm");
        
       
        
        
        addComponent(gui_Container_3);
        
        // gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
         
        //  ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
      
        gui_Container_3.addComponent(gui_Label_1);
      
        gui_Label_1.setText(" >  détails du club ");
        gui_Label_1.setName("Label_3");
        gui_Label_1.setUIID("BoldLabel");
        
        
        
         
        
       
         gui_Container_3.addComponent(gui_Button_4);
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
        
        
        

//        gui_Label_2.setText();
//        gui_Label_2.setName("nom");
//        gui_Label_2.setUIID("Label");
//       gui_Container_3.addComponent(gui_Text_Field_1);
//        
//        gui_Text_Field_1.setName("txt_nom");
//        
//         gui_Container_3.addComponent(gui_Label_4);
//     
//        gui_Label_4.setText(" Prénom ");
//        gui_Label_4.setName("prénom");
//        gui_Label_4.setUIID("Label");
//       gui_Container_3.addComponent(gui_Text_Field_2);
//        gui_Text_Field_2.setName("txt_prenom");
//        
        
        gui_Container_3.addComponent(gui_Label_6);
     
//        gui_Label_6.setText(" Classe");
//        gui_Label_6.setName("classe");
//        gui_Label_6.setUIID("Label");
//        
//       gui_Container_3.addComponent(combo);
//        combo.setName("com_classe");
//        combo.setHint("Classe 1");
//        gui_Container_3.addComponent(gui_Label_5);
//     
//        gui_Label_5.setText(" Date de naissance ");
//        gui_Label_5.setName("date");
//        gui_Label_5.setUIID("Label");
//       gui_Container_3.addComponent(gui_Text_Field_3);
//        gui_Text_Field_3.setName("txt_date");
//        
//        
//         gui_Container_3.addComponent( gui_Container_4);
//         
//       gui_Container_4.addComponent(gui_Button_2);
//       gui_Button_2.setText(" Enregistrer ");
//        gui_Button_2.setName("Button_2");
//        gui_Button_2.addActionListener(e -> new EnfantForm().show());
//         gui_Button_2.setIcon(resourceObjectInstance.getImage("image"));
//       gui_Button_2.setUIID("InboxNumber");
//       
//        gui_Container_4.addComponent(gui_Button_3);
//       gui_Button_3.setText(" Annuler ");
//        gui_Button_3.setName("Button_2");
//        gui_Button_3.addActionListener(e -> new EnfantForm().show());       
//       gui_Button_3.setUIID("InboxNumber4");
//        gui_Button_3.setIcon(resourceObjectInstance.getImage("image")); 
//    
       
    
        
          
        }
    
}
