package calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import calculadora.Matriz;
import calculadora.CalculadoraException;
import calculadora.Deutsch;

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