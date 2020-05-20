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




import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;

import com.codename1.ui.Label;
import com.codename1.ui.List;

import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Border;

import com.codename1.ui.util.Resources;
import java.util.Calendar;
import java.util.Date;

import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.spinner.Picker;
import com.kidzy.entities.Facture;
import com.kidzy.services.ServiceFacture;
import com.kidzy.services.ServicePack;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;






public class PaymentSuccessForm extends BaseForm {
    public PaymentSuccessForm(Resources res,Facture f)  {
        setLayout(new FlowLayout());
        setUIID("StatsForm1");
        
        Container white = new Container();
        white.setUIID("prconf");
        getToolbar().hideToolbar();

        Container all = new Container(new BorderLayout());
        Label pay = new Label("PAYMENT COMPLETE", "HugeDarkLabel");
        Label thanks = new Label("Thank you for your transfer", "LargeWhileLabel");
        Container yow = new Container(BoxLayout.yCenter());
        yow.add(new Label("separator", "separatorpackyoussef")).add(pay).add(thanks).add(new Label("separator", "separatorpackyoussef"));
        //yow.setUIID("prconf");
        all.setUIID("prconf");
        Button bt = new Button("Retour");
        bt.setUIID("retourbt");
        Button imprimer = new Button("Imprimer");
        imprimer.setUIID("retourbt");
        Container datechoice = new Container(BoxLayout.yCenter());
        Label selectdate = new Label("please select payment day","retourbt");
        Picker datePicker = new Picker();
        Date enddate = null;
        
        try {
            enddate=new SimpleDateFormat("yyyy/MM/dd").parse(f.getDue_date_facture());
        } catch (ParseException ex) {
           
        }
        datePicker.setEndDate(enddate);
        datePicker.setType(Display.PICKER_TYPE_DATE);
        datePicker.setDate(f.getDate_facture());
        datePicker.setUIID("retourbt");
       datePicker.setStartDate(f.getDate_facture());
       
       datePicker.addActionListener((ActionListener) (ActionEvent evt) -> {
           Date newdate = datePicker.getDate();
           if (newdate != null ) {
               System.out.println(newdate);
               System.out.println(f.getDate_facture());
           }
        });
       
        datechoice.add(datePicker);
        imprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                String url = "http://localhost/kidzy_web/web/app_dev.php/kidzy/packs/print/5/1/7/41/320/2020-06-19";
                FileSystemStorage fs = FileSystemStorage.getInstance();                
                String fileName = fs.getAppHomePath() + "fac.pdf";
                Util.downloadUrlToFile(url, fileName, true);
                Display.getInstance().execute(fileName);
            }
        });
       Container grid = GridLayout.encloseIn(1,gridElement(res, f, false));
        all.add(BorderLayout.CENTER, grid);
       
        all.add(BorderLayout.NORTH,yow );
        all.add(BorderLayout.SOUTH,datechoice );
        
        add(all);
    }

    Container circleContent(Resources res) {
        Label today = new Label("Today", "LargeWhileLabel");
        Label time = new Label("2:56:", "HugeDarkLabel");
        Label seconds = new Label("01", "HugeDarkLabel");
        Label darkRect = new Label(res.getImage("dark-rect.png"), "StatsLabel");
        darkRect.setShowEvenIfBlank(true);
        Label active = new Label("ACTIVE", "StatsLabel");
        
       CircleProgress p = new CircleProgress();
    p.setProgress(100);
    p.setClockwise(true);
    p.setStartAngle(CircleProgress.START_9_OCLOCK);
    
        Container box = BoxLayout.encloseY(
                        today,
                        FlowLayout.encloseCenter(time, seconds),
                        FlowLayout.encloseCenter(darkRect),
                        active
                    );
        box.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        box.getUnselectedStyle().setPadding(4, 4, 4, 4);
        Container scroll = BoxLayout.encloseY(LayeredLayout.encloseIn(
                   p,
                    box
                ));
        scroll.setScrollableY(true);
        return scroll;
        
    }
    
    
    Container gridElement(Resources res,Facture f, boolean last) {
        Container info = new Container(BoxLayout.y());
        info.add(new Label(f.getIdParent().getNom_parent()+" "+f.getIdParent().getPrenom_parent(), "LargeWhileLabelyoussef22")).add(new Label(f.getIdParent().getEmail(), "LargeWhileLabelyoussef"));
        Container detail = new Container(BoxLayout.y());
        detail.add(new Label(f.getPack().getNom_pack(), "LargeWhileLabelyoussef22")).add(new Label(f.getPack().getDescription_pack(), "LargeWhileLabelyoussef"));
        //detail.add(new Label("chauffeur", "LargeWhileLabelyoussef"))
                detail.add(new Label("Enfant", "LargeWhileLabelyoussef22"));
        detail.add(new Label(f.getIdEnf().getPrenom_enfant()+" "+f.getIdEnf().getNom_enfant(), "LargeWhileLabelyoussef"));
        Container image = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
        image.add(res.getImage("invoice.png"));
        Container you = new Container(BoxLayout.x());
             you.add(new Label("sep", "separatorpackyoussef")).add(image).add(new Label("se", "separatorpackyoussef")).add(detail);
        you.setUIID("prconfol");
        Container c = BorderLayout.north(
                BoxLayout.encloseY(
                        
                    FlowLayout.encloseCenter(new Label(res.getImage("person.png")),
                            
                            info,
                            new Label("separator", "separatorpack222")
                            
                    ),
                        
                        FlowLayout.encloseCenter(new Label("   "+f.getTotal(), "HugeDarkLabel"),
                            new Label("DT", "SmallWhileLabel")
                    ),
                        
                    new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"),
                    new Label("      DETAILS ACHAT", "StatsLabelyoussef"),
                    you
                 
                )       
        
        );
        c.setUIID("prconf222");
        /*if(last) {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, null), null, null));
        } else {
            c.getAllStyles().setBorder(Border.createCompoundBorder(null, 
                    Border.createLineBorder(2, null), null, 
                    Border.createLineBorder(2, null)));
        }*/
        
        return c;
    }
    
    Container createTopGrid(Resources res) {
        return null;
                //gridElement(res, "", "youssef.mimouni1@esprit.tn","   320", false));
                //gridElement(res, "0:47", "Running", false));
               /* gridElement(res, "2:56", "Cycling", true));*/
    }
    
    Component createBottomList(Resources res) {
        final int DAY = 24 * 60 * 60000;
        List<Date> dayPicker = new List(new ListModel<Date>() {
            int selection = (int)(System.currentTimeMillis() / DAY);
            @Override
            public Date getItemAt(int index) {
                return new Date(index * DAY);
            }

            @Override
            public int getSize() {
                return 50000;
            }

            @Override
            public int getSelectedIndex() {
                return selection;
            }

            @Override
            public void setSelectedIndex(int index) {
                selection = index;
            }

            @Override
            public void addDataChangedListener(DataChangedListener l) {
            }

            @Override
            public void removeDataChangedListener(DataChangedListener l) {
            }

            @Override
            public void addSelectionListener(SelectionListener l) {
            }

            @Override
            public void removeSelectionListener(SelectionListener l) {
            }

            @Override
            public void addItem(Date item) {
            }

            @Override
            public void removeItem(int index) {
            }            
        });
        final String[] WEEKDAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        dayPicker.setOrientation(List.HORIZONTAL);
        dayPicker.setFixedSelection(List.FIXED_CENTER);
        dayPicker.setRenderingPrototype(new Date());
        dayPicker.setRenderer(new ListCellRenderer() {
            Label focus = new Label();
            Label day;
            Label label;
            Container cnt;
            {
                day = new Label("00", "LargeWhileLabel");
                label = new Label("WED", "StatsLabel");
                cnt = 
                        BoxLayout.encloseY(
                                FlowLayout.encloseCenter(day), 
                                FlowLayout.encloseCenter(label)
                        );
                cnt.setCellRenderer(true);
            }
            
            @Override
            public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {
                Date d = (Date)value;
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                int dd = c.get(Calendar.DAY_OF_MONTH);
                if(dd < 10) {
                    day.setText("0" + dd);
                } else {
                    day.setText("" + dd);
                }
                label.setText(WEEKDAYS[c.get(Calendar.DAY_OF_WEEK) - 1]);
                return cnt;
            }

            @Override
            public Component getListFocusComponent(List list) {
                return focus;
            }
        });
        return BoxLayout.encloseY(
                new Label(res.getImage("welcome-separator.png"), "CenterNoPadd"),
                dayPicker);
    }
    
    @Override
    protected boolean isCurrentStats() {
        return true;
    }
}
