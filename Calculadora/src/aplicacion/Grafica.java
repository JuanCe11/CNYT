package aplicacion;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class Grafica extends JFrame{
	
	private JPanel panel;
	
	public Grafica() {
        setTitle("Vector de estado final");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public void init(Matriz estadoFinal) {
        panel = new JPanel();
        getContentPane().add(panel);
        
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        
        for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
        	String estado = Integer.toString(i);

        	DecimalFormat df = new DecimalFormat("#.00");
        	
        	String s = df.format(estadoFinal.getNumeros()[i][0].getReal() * 100);
        	estado = "Estado " + estado + " = " + s + "%";
			data.setValue(estado, estadoFinal.getNumeros()[i][0].getReal());
		}

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart("Vector de estado final del experimento de las rendijas:", data, true, true, false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
}