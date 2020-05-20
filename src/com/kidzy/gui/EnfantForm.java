/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.kidzy.entities.Classe;
import com.kidzy.entities.Enfant;
import com.kidzy.entities.Session;
import com.kidzy.entities.user;
import com.kidzy.services.ServiceEnfant;
import java.util.ArrayList;

/**
 *
 * @author ferja
 */
public class EnfantForm extends BaseForm{
    
   ServiceEnfant servEnf = new ServiceEnfant();
        user User =Session.getCurrentSession();
         ArrayList<Enfant> listEnfant = ServiceEnfant.getInstance().getAllEnfants(User.getId());
       ArrayList<Classe> Cla=new ArrayList<Classe>();

    public EnfantForm() {

        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    @Override
    protected boolean isCurrentEnfant() {
        return super.isCurrentEnfant(); //To change body of generated methods, choose Tools | Templates.
    }

    public EnfantForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Enfant", "Title")
                )
        );
        
        installSidemenu(resourceObjectInstance);

        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
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
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
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
   private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    // private com.codename1.ui.Container ct1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    //  private com.codename1.ui.Container ct2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();
// <editor-fold defaultstate="collapsed" desc="Generated Code">     

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {

        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("EnfantForm");
        setName("EnfantForm");

        addComponent(gui_Container_1);

        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Container_2);

        gui_Container_2.setName("Container_2");

        gui_Container_2.addComponent(gui_Label_3);

        gui_Label_3.setText(" > Liste des enfants ");
        gui_Label_3.setName("Label_3");
        gui_Label_3.setUIID("BoldLabel");

        gui_Container_2.addComponent(gui_Button_2);
        gui_Button_2.setText(" + Ajouter enfant ");
        gui_Button_2.setName("Button_2");
        gui_Button_2.addActionListener(e -> new AddEnfantForm().show());
        gui_Button_2.setUIID("InboxNumber");
        gui_Button_2.setIcon(resourceObjectInstance.getImage("image"));

        // gui_Container_2.addComponent(gui_Text_Area_1_4);
        // gui_Text_Area_1_4.setText(ServiceEnfant.getInstance().getAllEnfants().toString());
        // Form f2 = new Form(BoxLayout.y());
        gui_Container_1.addComponent(gui_Container_3);
        //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_3);
       // ServiceEnfant servEnf = new ServiceEnfant();
       // user User =Session.getCurrentSession();
       // for (Enfant e : listEnfant) {
         for(int i=0;i<listEnfant.size();i++){
             
            Container ct1 = new Container(BoxLayout.y());
            ct1.getStyle().setBgColor(0x99CCCC);
            //ct1.getStyle().setFgColor(0xFFFFFF);
            // gui_Container_3.addComponent(ct1);

            Label nom = new Label(listEnfant.get(i).getPrenom_enfant() + " " + listEnfant.get(i).getNom_enfant());
            //Classe c = new Classe();
            Label classe = new Label();
             System.out.println(classe);
             
           // Enfant e = new Enfant();
            if (listEnfant.get(i).getIdClasse().getLibelle_cla() == "" ) {
               /// classe.setText(listEnfant.get(i).getIdClasse().getLibelle_cla());
                 classe.setText("--------");
            } else {
                // gui_Text_Area_2 = new com.codename1.ui.TextArea();
               /// classe.setText("--------");
                 classe.setText(listEnfant.get(i).getIdClasse().getLibelle_cla());
            }
 
            ct1.addAll(nom, classe);
            Container ctt2 = new Container(BoxLayout.x());
            // ctt2.getStyle().setFgColor(0xFFFFFF);
            gui_Container_3.addComponent(ctt2);
            // Label img = new Label("img");

            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(300, 300, 0xffff0000), true);
            URLImage logo = URLImage.createToStorage(placeholder, listEnfant.get(i).getImage_enfant() + ".cache",
                    "http://localhost:8080/kidzy_web/web/images/enfants/" + listEnfant.get(i).getImage_enfant());

            ImageViewer ivLogo = new ImageViewer();
            ivLogo.setImage(logo);

            ctt2.add(ivLogo);
            ctt2.add(ct1);
            
            int idEnfant = listEnfant.get(i).getId_enfant();
            String nomE = listEnfant.get(i).getNom_enfant();
            String prenom = listEnfant.get(i).getPrenom_enfant();
            String cla = listEnfant.get(i).getIdClasse().getLibelle_cla();
            String garde = listEnfant.get(i).getIdGarde().getNom_garde() ;
            String image = listEnfant.get(i).getImage_enfant();
            String date = listEnfant.get(i).getDateN_enfant();

            nom.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    // Dialog.show("Confirmation",e.getPrenom_enfant(),"OK",null);
                    new DetailEnfantForm(idEnfant,nomE ,prenom ,cla , garde,image ,date ).show();

                }
            });
        }

        Container ct = new Container(BoxLayout.xCenter());
        Container ct2 = new Container(BoxLayout.yCenter());
        Container ct3 = new Container(BoxLayout.yCenter());
        Container ct4 = new Container(BoxLayout.yCenter());

        ct4.add(gui_Label_11).add(gui_Label_12);
        ct.add(ct2).add(ct3).add(ct4);

    }// </editor-fold>

    
}
