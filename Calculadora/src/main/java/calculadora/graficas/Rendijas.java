package main.java.calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import main.java.calculadora.Matriz;
import main.java.calculadora.Respuesta;
import main.java.calculadora.CalculadoraDinamica;
import main.java.calculadora.CalculadoraException;

public class Rendijas {
	public static void main(String[] args) {
		double r = 1/Math.sqrt(22);
		double[][] probabilidades = {{r,r},   
		                             {-r,-r}, 
		                             {-r,r},  
		                             {-r,-r}, 
		                             {r,-r},  
		                             {-r,-r}, 
		                             {-r,-r}, 
		                             {-r,-r}, 
		                             {r,-r},  
		                             {r,-r},  
		                             {-r,r}}; 
		try {	
			Respuesta res = CalculadoraDinamica.experimentoRendijas(2, 5, probabilidades);
			graficar(res.getEstadoFinal());
		} catch (CalculadoraException e) {
			System.out.println("Algo fallo.");
		}
	}

	private static void graficar(Matriz estadoFinal) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		String sitio1 = "Probabilidad";
		for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
			data.setValue(estadoFinal.getNumeros()[i][0].getReal(),sitio1,Integer.toString(i));			
		}
		JFreeChart chart = ChartFactory.createBarChart("Rendijas","Estados","Probabilidad",data);
		ChartFrame frame = new ChartFrame("Rendijas",chart);
        frame.pack();
        frame.setVisible(true);
	}
}