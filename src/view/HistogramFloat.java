/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import view.*;
import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.ArtefatoFrequencia;
import model.StringFloat;
import model.TDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author thiago
 */
public class HistogramFloat extends JFrame{

    private static final long serialVersionUID = 1L;

    public HistogramFloat(String applicationTitle, String TituloGrafico, List<StringFloat> Lista) {   
        super(applicationTitle);
        
        String legenda = Lista.get(Lista.size()-1).getDescricao();
        DefaultCategoryDataset DatasetGrafico = new DefaultCategoryDataset();
        int i;
        for (i = 0; i < Lista.size()-1; i++ )
        {
            DatasetGrafico.addValue(Lista.get(i).getValor(), legenda, Lista.get(i).getDescricao());
            
        }
        
        //JFreeChart grafico = ChartFactory.createBarChart(TituloGrafico, "Legends", "Value of Quality Index using "+legenda, DatasetGrafico);
        
        JFreeChart grafico = ChartFactory.createLineChart(TituloGrafico, "Number of Clusters", "Index of Quality", DatasetGrafico, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot plot = grafico.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);
        
                //createBarChart(TituloGrafico, "Legends", "Value of Quality Index using "+legenda, DatasetGrafico);
        
        
        
        this.add(new ChartPanel (grafico));
        this.pack();
 }
    
}