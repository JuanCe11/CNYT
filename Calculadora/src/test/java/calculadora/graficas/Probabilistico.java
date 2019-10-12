package test.java.calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;
import org.junit.Assert;

import main.java.calculadora.*;

public class Probabilistico {
	public static void main(String[] args) {
		double[][] numeros = {{0,0},{0.2,0},{0.3,0},{0.5,0},
		                {0.3,0},{0.2,0},{0.1,0},{0.4,0},
		                {0.4,0},{0.3,0},{0.2,0},{0.1,0},
		                {0.3,0},{0.3,0},{0.4,0},{0,0}};
		double[][] numeros2 = {{0,0},{(double)1/6,0},{(double)5/6,0},
						   {(double)1/3,0},{(double)1/2,0},{(double)1/6,0},
						   {(double)2/3,0},{(double)1/3,0},{0,0}}; 
		double[][] numeros3 = {{0.2,0},{0.1,0},{0.6,0},{0.1,0}};
		double[][] numeros4 = {{0.7,0},{0.15,0},{0.15,0}};
		try {
			Matriz m = new Matriz(4,4,numeros);
			Matriz m2 = new Matriz(3,3,numeros2);
			Matriz m3 = new Matriz(4,1,numeros3);
			Matriz m4 = new Matriz(3,1,numeros4);
			graficar(CalculadoraDinamica.sistemaDinamicoconEnsamble(m, m2, m3, m4, 5));
		} catch (CalculadoraException e) {
			System.out.println("Algo fallo.");
			Assert.fail();
		}
		
	}

	private static void graficar(Matriz estadoFinal) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		String sitio1 = "Probabilidad";
		for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
			data.setValue(estadoFinal.getNumeros()[i][0].getReal(),sitio1,Integer.toString(i));			
		}
		JFreeChart chart = ChartFactory.createBarChart("Probabilistico","Estados","Probabilidad",data,PlotOrientation.VERTICAL,true,false,false);
		ChartFrame frame = new ChartFrame("Probabilistico",chart);
        frame.pack();
        frame.setVisible(true);
	}

}