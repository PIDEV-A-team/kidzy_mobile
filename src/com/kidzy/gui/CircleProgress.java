/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.gui;

/**
 *
 * @author Youssef Mimouni
 */
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Slider;
import com.codename1.ui.Stroke;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.plaf.Style;


public class CircleProgress extends BaseRoundProgress {

    private int arcWidth = 20;
    
    private boolean clockwise = false;
    
    private int startAngle = START_12_OCLOCK;

    public static final int START_12_OCLOCK = 0;

    public static final int START_3_OCLOCK = 1;

    public static final int START_6_OCLOCK = 2;

    public static final int START_9_OCLOCK = 3;

    public CircleProgress() {
        setRenderPercentageOnTop(true);
    }

    public void setArcWidth(int arcWidth){
        this.arcWidth = arcWidth;
    }

    public void setClockwise(boolean clockwise){
        this.clockwise = clockwise;
    }
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    @Override
    public void paint(Graphics g) {
        Style style = getStyle();
        int wPadding = style.getPadding(isRTL(), Component.RIGHT) + style.getPadding(isRTL(), Component.LEFT);
        int hPadding = style.getPadding(Component.TOP) + style.getPadding(Component.BOTTOM);
        GeneralPath path = new GeneralPath();
        int size = Math.min(getWidth() - wPadding, getHeight() - hPadding);
        size = size - arcWidth;
        int x = getX() + style.getPadding(isRTL(), Component.LEFT) + arcWidth/2;
        int y = getY() + style.getPadding(Component.TOP) + arcWidth/2;
        if(style.getAlignment() == CENTER){
            x = getX() + (getWidth() - size)/2;
        }else if(style.getAlignment() == RIGHT){
            x = getX() + getWidth() - (style.getPadding(isRTL(), Component.RIGHT) + arcWidth/2);           
        }

        path.arc(x, y, size, size, 0, 2*Math.PI);
        
        Stroke stroke1 = new Stroke(arcWidth, Stroke.CAP_ROUND, Stroke.JOIN_ROUND, 4);
        g.setAntiAliased(true);
        g.setColor(getStyle().getBgColor());
        g.drawShape(path, stroke1);        
        int p = getProgress();
        GeneralPath path1 = new GeneralPath();
        double angle = 0;
        switch(startAngle){
            case START_12_OCLOCK:
                angle = Math.PI/2;
                break;
            case START_3_OCLOCK:
                angle = 0;
                break;
            case START_6_OCLOCK:
                angle = -Math.PI/2;
                break;
            case START_9_OCLOCK:
                angle = Math.PI;
                break;                
        }
        if(clockwise){
            path1.arc(x, y, size, size, angle, -(Math.PI*2)*p/getMaxValue());
        }else{
            path1.arc(x, y, size, size, angle, (Math.PI*2)*p/getMaxValue());
        }
        g.setColor(getStyle().getFgColor());
        g.drawShape(path1, stroke1);        
        
        if(isRenderPercentageOnTop()){
            String val = formattedValue(p);
            
            
            //g.drawString(val, x + (size + arcWidth - style.getFont().stringWidth(val))/2, y + (size - style.getFont().getHeight())/2);
            
        }
    }


}