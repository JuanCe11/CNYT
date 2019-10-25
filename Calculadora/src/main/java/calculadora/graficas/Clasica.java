package main.java.calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import main.java.calculadora.Matriz;
import main.java.calculadora.CalculadoraDinamica;
import main.java.calculadora.Respuesta;

public class Clasica {
	public static void main(String[] args) {
		double[][] numeros = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},//0
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},//1
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},//2
				  {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//3
				  {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//4
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//5
				  {0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},//6
				  {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//7
				  {0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//8
				  {1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},//9
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},//10
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},//11
				  {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};//12
		
		double[][] numeros2 = {{10,0},{4,0},{1,0},{7,0},{2,0},{2,0},{11,0},{0,0},{3,0},{1,0},{0,0},{5,0},{2,0}}; 
		try {
			Matriz m = new Matriz(13,13,numeros);
			Matriz m2 = new Matriz(13,1,numeros2);
			Respuesta r = CalculadoraDinamica.calcularEstado(0, m, m2, 25);
			graficar(r.getEstadoFinal());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void graficar(Matriz estadoFinal) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		String sitio1 = "Probabilidad";
		for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
			data.setValue(estadoFinal.getNumeros()[i][0].getReal(),sitio1,Integer.toString(i));			
		}
		JFreeChart chart = ChartFactory.createBarChart("Clásica","Estados","Probabilidad",data);
		ChartFrame frame = new ChartFrame("Clásica",chart);
        frame.pack();
        frame.setVisible(true);
	}
}