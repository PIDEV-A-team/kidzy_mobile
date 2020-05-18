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
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;
        
        Image statsImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image ClubImage = null;
        if(isCurrentClub()) ClubImage = selection;
        
        Image AvisImage = null;
        if(isCurrentAvis()) AvisImage = selection;
        
        Image RéclamationImage = null;
        if(isCurrentReclamation()) RéclamationImage = selection;
        
        Image GardeImage = null;
        if(isCurrentGarde()) GardeImage = selection;
        
        Image EnfantImage = null;
        if(isCurrentEnfant()) inboxImage = selection;
        
        Image PricingImage = null;
        if(isCurrentPricing()) PricingImage = selection;
        
        Image EvénementImage = null;
        if(isCurrentEvenement()) EvénementImage = selection;
        
        Image ProfileImage = null;
        if(isCurrentProfile()) ProfileImage = selection;
        
        Image DéconnecterImage = null;
        if(isCurrentDéconnecter()) DéconnecterImage = selection;
        
       
        
         // spacer
        
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        
        Button inboxButton = new Button("Accueil", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton);
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new InboxForm().show());
        getToolbar().addComponentToSideMenu(inbox);
        
       // getToolbar().addCommandToSideMenu("Stat", statsImage, e -> new PricingForm(res).show());
        //getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
         
        getToolbar().addCommandToSideMenu("Club", null, e -> {});
        getToolbar().addCommandToSideMenu("Classe", null, e -> new ClasseForm().show());
         getToolbar().addCommandToSideMenu("Avis", null, e -> {});
          getToolbar().addCommandToSideMenu("Réclamation", null, e -> {});
           getToolbar().addCommandToSideMenu("Enfant", null, e -> new EnfantForm().show());
            getToolbar().addCommandToSideMenu("Garde", null, e -> new GardeForm().show());
             getToolbar().addCommandToSideMenu("Pricing", statsImage, e -> new SelectchildForm(res).show());
              getToolbar().addCommandToSideMenu("Evénement", null, e -> {});
        
        getToolbar().addCommandToSideMenu("Profile", null, e -> {});
        getToolbar().addCommandToSideMenu("Déconnecter", null, e -> {});
        
       
        
    }
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentClub() {
        return false;
    }

    protected boolean isCurrentAvis() {
        return false;
    }

    protected boolean isCurrentReclamation() {
        return false;
    }
    
     protected boolean isCurrentEnfant() {
        return false;
    }
     
      protected boolean isCurrentGarde() {
        return false;
    }
       protected boolean isCurrentPricing() {
        return false;
    }
        protected boolean isCurrentStats() {
        return false;
    }
        protected boolean isCurrentEvenement() {
        return false;
    }
         protected boolean isCurrentProfile() {
        return false;
    }
          protected boolean isCurrentDéconnecter() {
        return false;
    }
          
     
}
