/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.ArtefatoFrequencia;
import model.TDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author thiago
 */
public class Histogram extends JFrame{

    private static final long serialVersionUID = 1L;

    public Histogram(String applicationTitle, String TituloGrafico, List<ArtefatoFrequencia> Lista) {   
        super(applicationTitle);
        
        
        DefaultCategoryDataset DatasetGrafico = new DefaultCategoryDataset();
        int quantidade = 0;
        int i;
        for (i = 0; i < Lista.size()-1; i++ )
        {
            quantidade = quantidade + Lista.get(i).getQuantidade();
            DatasetGrafico.addValue(Lista.get(i).getQuantidade(), Lista.get(i).getAtributo(), "Number of artefacts affected by review accumulated");            
        }
        //DatasetGrafico.addValue(101, "Frequencia", "termo b");
        //DatasetGrafico.addValue(150, "termc1", "termo c2");*/
        //for (ArtefatoFrequencia c:Lista2)
          //  DatasetGrafico.addValue(c.getQuantidade(), c.getAtributo(), "Number of artefacts affected by review");

        
        JFreeChart grafico = ChartFactory.createBarChart(TituloGrafico, "Legends", "Accumulation of Number of Review", DatasetGrafico);
        
        
        
        
        this.add(new ChartPanel (grafico));
        this.pack();
 }
    
}