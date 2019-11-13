package main.java.calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import main.java.calculadora.Matriz;
import main.java.calculadora.CalculadoraDinamica;
import main.java.calculadora.CalculadoraException;
import main.java.calculadora.Deutsch;

public class SimulacionDeutsch {
	public static void main(String[] args) {
		try {
			graficar(Deutsch.simulacionU0());
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}

	private static void graficar(Matriz estadoFinal) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		String sitio1 = "Probabilidad";
		String[] nombres = {"00","01","10","11"};
		for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
			data.setValue(estadoFinal.getNumeros()[i][0].getReal(),sitio1,nombres[i]);			
		}
		JFreeChart chart = ChartFactory.createBarChart("Simulacion Algoritmo Deutsch","Estados","Probabilidad",data);
		ChartFrame frame = new ChartFrame("Simulacion Deutsch",chart);
        frame.pack();
        frame.setVisible(true);
	}
}