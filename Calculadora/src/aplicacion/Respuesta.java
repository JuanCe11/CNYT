package aplicacion;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Respuesta {
	private boolean matrizValida;
	private Matriz potencia;
	private Matriz estadoFinal;
	
	public Respuesta(boolean matrizValida,Matriz potencia, Matriz estadoFinal) {
		this.matrizValida = matrizValida;
		this.potencia = potencia;
		this.estadoFinal = estadoFinal;
	}
	
	public void imprimirEstadoFinal() {
		Grafica g = new Grafica();
		g.init(estadoFinal);
	}

	public boolean isMatrizValida() {
		return matrizValida;
	}

	public void setMatrizValida(boolean matrizValida) {
		this.matrizValida = matrizValida;
	}

	public Matriz getPotencia() {
		return potencia;
	}

	public void setPotencia(Matriz potencia) {
		this.potencia = potencia;
	}

	public Matriz getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(Matriz estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
}
