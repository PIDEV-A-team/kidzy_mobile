/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidzy.charts;

/**
 *
 * @author ala
 */


import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;

import com.codename1.charts.util.ColorUtil;
import com.kidzy.entities.Club;
import com.kidzy.services.ServiceClub;

import java.util.Random;





/**
 * Budget demo pie chart.
 */
public class ClubPieChart extends AbstractDemoChart {
  /**
   * Returns the chart name.
   * 
   * @return the chart name
   */
  public String getName() {
    return "Budget chart";
  }

  /**
   * Returns the chart description.
   * 
   * @return the chart description
   */
  public String getDesc() {
    return "The budget per project for this year (pie chart)";
  }
  
  public int getRandomColor(){
   Random rnd = new Random();
   return ColorUtil.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
}

  /**
   * Executes the chart demo.
   * 
   * @param context the context
   * @return the built intent
   */
  @Override
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
    int k = 0;
    for (Club c : ServiceClub.getInstance().getStatClubs()) {
  
      series.add( c.getNomClub(), c.getNombreplace());
      
    
    }
    return series;
  }
    
  public Form execute() {
    
     double[] values = new double[30];
      int[] colors = new int[30]; 
        Integer i=0;
        for (Club c : ServiceClub.getInstance().getStatClubs()) {
            values[i] = (double)c.getNombreplace();
            i++;     
        }
        Integer j=0;
        for (Club c : ServiceClub.getInstance().getStatClubs()) {
            colors[j] = getRandomColor();
            j++;     
        }
        
    final DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextFont(largeFont);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    renderer.setBackgroundColor(ColorUtil.rgb(243, 242, 242));
    renderer.setApplyBackgroundColor(true);
    renderer.setLabelsColor(0000);
    final CategorySeries seriesSet = buildCategoryDataset("Project budget", values);
    final PieChart chart = new PieChart(seriesSet, renderer);
    ChartComponent comp = new ChartComponent(chart);
    return wrap("Budget", comp);
    
  }

}

