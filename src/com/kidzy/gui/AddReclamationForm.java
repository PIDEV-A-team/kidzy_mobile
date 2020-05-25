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
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.kidzy.entities.Classe;
import com.kidzy.entities.Reclamations;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;
import com.kidzy.services.ServiceReclamation;
import java.io.IOException;


import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author ferja
 */
public class AddReclamationForm extends BaseForm {
    
     private FileUploader file ;
      String fileNameInServer;
      private String imgPath;
                 public user idParent;

    Reclamations a = new Reclamations();
    ServiceReclamation ser = new ServiceReclamation();
    
    public AddReclamationForm() {
         this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
     public AddReclamationForm (com.codename1.ui.util.Resources resourceObjectInstance){
         
         
         initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajouter reclamation", "Title")
                        
                )
        );
        
       // FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
      // getToolbar().addCommandToLeftBar("", mat, e -> new EnfantForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new ReclamationForm().showBack());
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
     private com.codename1.ui.TextComponent description = new com.codename1.ui.TextComponent();
  
   
// <editor-fold defaultstate="collapsed" desc="Generated Code">     
       
       
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance){
            
            
            
            setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("ReclamationForm");
        setName("ReclamationForm");
        
       
        
        
       
        addComponent(gui_Container_3);

        // gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        //  ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
        gui_Container_3.setUIID("Container_uiid_name");
        gui_Container_3.addComponent(gui_Label_1);

        gui_Label_1.setText(" > Entrez votre reclaamtion ");
        gui_Label_1.setName("Label_3");
        gui_Label_1.setUIID("BoldLabel");

        gui_Container_3.addComponent(gui_Label_7);

        //gui_Label_7.setText("Image ");
        //gui_Label_7.setName("Label_3");

        //gui_Container_3.addComponent(gui_Button_4);
        //gui_Button_4.setName("Button_2");
        //gui_Button_4.setText("importer image");
       // gui_Button_4.setUIID("InboxNumber4");
        //gui_Button_4.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
       
        // gui_Button_4.addActionListener(new ActionListener() {
          //  @Override
           // public void actionPerformed(ActionEvent evt) {

                /*  try{
                        imgPath = Capture.capturePhoto();
                        System.out.println(imgPath);
                        String link = imgPath.toString();
                        int pod = link.indexOf("/",2);
                        String news = link.substring(pod +2, link.length());
                        System.out.println(""+news);
                        
                        FileUploader fu = new FileUploader("http://localhost:8080/kidzy_web/web");
                        fileNameInServer = fu.upload(news);
                      // path.setText(fileNameInServer);
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                       
                    }*/
              

                //String i = Capture.capturePhoto().toString();
                //int num = i.indexOf("/", 2);
                //String news = i.substring(num + 2, i.length());
                //System.out.println("" + news);
                //System.out.println("" + i);
                //FileUploader fu = new FileUploader("http://localhost:8080/kidzy_web/web");
                //try {
                  //  fileNameInServer = fu.upload(news);
                    //System.out.println("name " + fileNameInServer);
                    //e.setImage_enfant(fileNameInServer);

                    //} catch (Exception ex) {
                //}
            //}
        //});

        //gui_Container_3.addComponent(gui_Label_2);

        //gui_Label_2.setText(" date_Avis ");
        //gui_Label_2.setName("date_Avis");
        //gui_Label_2.setUIID("Label");
         
       // gui_Container_3.addComponent(gui_Text_Field_1);
        
       // TextComponent name = new TextComponent();
        //gui_Container_3.addComponent(name);
       // gui_Text_Field_1.setName("txt_nom");
        //gui_Text_Field_1.setText("");

        gui_Container_3.addComponent(gui_Label_4);

        gui_Label_4.setText(" description_Rec ");
        gui_Label_4.setName("description_Rec");
        gui_Label_4.setUIID("Label");
       // gui_Container_3.addComponent(gui_Text_Field_2);
       // gui_Text_Field_2.setName("txt_prenom");
       
      
        gui_Container_3.addComponent(description);
        
        
       
        // gui_Container_3.addComponent(gui_Label_5);

        //gui_Label_5.setText(" Date de naissance ");
        //gui_Label_5.setName("date");
        //gui_Label_5.setUIID("Label");
       // gui_Label_5.errorMessage("Input is essential in this field");
       // gui_Container_3.addComponent(gui_Text_Field_3);
        //gui_Text_Field_3.setName("txt_date");
        //gui_Text_Field_3.setText("");

        
       
        //gui_Container_3.addComponent(date);
        
        
        
        Validator val = new Validator();
         val.setShowErrorMessageForFocusedComponent(true);
                val.addConstraint(description, new LengthConstraint(2, "Entrez votre reclamation !"));

        ServiceReclamation ser = new ServiceReclamation();
//        for (int i=0 ;i<listEnfant.size();i++){ 
//String nomEnfant =listEnfant.get(i).getNom_enfant();
//String prenomEnfant =listEnfant.get(i).getPrenom_enfant();
//// idEnfant =listEnfant.get(i).getId_enfant();
//        combo.setName("com_Enfant");
//        combo.setHint("Classe 1");
//        combo.addItem(nomEnfant +" "+prenomEnfant );
//                 }
        gui_Container_3.addComponent(gui_Container_4);

        gui_Container_4.addComponent(gui_Button_2);
        gui_Button_2.setText(" Enregistrer ");
        gui_Button_2.setName("Button_2");
        
        

        gui_Button_2.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                 user User =Session.getCurrentSession();
              //  ArrayList<Avis> listAvis = ServiceAvis.getInstance().getMesAvisMobile(User.getId());
        //user idParent =listAvis.get(idp).getIdParent();
                System.out.println(idParent);
                // System.out.println(gui_Text_Field_1.getText() + gui_Text_Field_2.getText()+ gui_Button_4.getText()+ gui_Text_Field_3.getText());
                // System.out.println(enfant);
//                 ser.addAvis(a);
                //System.out.println("name" + e.getImage_enfant());
                
               //System.out.println(  e.getIdParent().getId());
                if ((description.getText().length() == 0) ) {
                    Dialog.show("Alerte", "Veuillez remplir tous les champs", new Command("OK"));
                    System.out.println(  description.getText() );
                } else {
//                    Avis t = new Avis(description.getText());
                    ServiceReclamation.getInstance().addRec(description.getText(),User.getId()); 
                         Dialog.show("ok", "ok", new Command("OK"));

//                    if (ServiceAvis.getInstance().addAvis(t)) {
//                        Dialog.show("Succès", description.getText() + " a été ajouté avec succès", new Command("OK"));
//                        System.out.println(t);
//                        AvisForm x = new AvisForm();
//                        x.show();
//                    } else {
//                        Dialog.show("ERREUR", "Erreur du serveur", new Command("OK"));
//                        System.out.println(t);
//                    } 
                    ReclamationForm rec= new ReclamationForm();
                   rec.show();
                }
            }
        }
        );

        gui_Button_2.setIcon(resourceObjectInstance.getImage("image"));
        gui_Button_2.setUIID("InboxNumber");

        gui_Container_4.addComponent(gui_Button_3);
        gui_Button_3.setText(" Annuler ");
        gui_Button_3.setName("Button_2");
        gui_Button_3.addActionListener(e -> new AvisForm().show());
        gui_Button_3.setUIID("InboxNumber4");
        gui_Button_3.setIcon(resourceObjectInstance.getImage("image"));

    }

}

        
        

        
        
        