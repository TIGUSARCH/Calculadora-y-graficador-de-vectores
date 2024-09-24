
package grafica_de_un;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Grafica {
  JFreeChart grafica;
  public static double ax=0, ay=0,p;
   XYSeriesCollection datos = new XYSeriesCollection();

  
   String titulo, x, y;
    public Grafica(String t, String ex, String ey){
        titulo = t;
        x = ex;
        y = ex;
        
            grafica= ChartFactory.createXYLineChart(titulo, ey, ex, datos, PlotOrientation.VERTICAL, true, true, true);
        
                XYPlot plot = grafica.getXYPlot();
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
               
                renderer.setSeriesPaint(0, Color.RED);
                renderer.setSeriesPaint(1, Color.BLUE);
                renderer.setSeriesPaint(2, Color.BLUE);

                renderer.setSeriesStroke(0, new BasicStroke(2.0f));
                renderer.setSeriesStroke(1, new BasicStroke(1.0f));
                renderer.setSeriesStroke(1, new BasicStroke(1.0f));
                plot.setRenderer(renderer);
               
                
    }
    public Grafica(){
        this("sin titulo","x","y");   
    }
    public void agregarGrafica(){
        
                XYSeries VA = new XYSeries("VECTOR");
                VA.add(p, p);
                VA.add(ax, ay);
                
                XYSeries x = new XYSeries("x");
                
                x.add(0,11 );
                x.add(0,-2);
                 
                XYSeries y = new XYSeries("y");
                
                y.add(-11,0 );
                y.add(2,0);
                

                datos.addSeries(VA);
                datos.addSeries(x);
                datos.addSeries(y);
                
    }
    public void creargrafica(){
    datos.removeAllSeries();
    agregarGrafica();
    }
    public JPanel obtieneGrafica(){
    return new ChartPanel(grafica);
    
    }
}
