package Test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import src.CalculadoraDinamica;
import src.CalculadoraException;
import src.Matriz;

public class DinamicaTest {
	
	@Test
	public void noDeberiaCalcularEstado() {
		double[][] numeros = {{3,0},{0,0},{0,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
							  {0,0},{1,0},{0,0},{0,0},{0,0},{1,0},
							  {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
							  {1,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros2 = {{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}};
		try {
			Matriz m = new Matriz(6,6,numeros);
			Matriz m2 = new Matriz(6,1,numeros2);
			CalculadoraDinamica.sistemaDinamicoDeterminista(m, m2, 2019);
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}

	@Test
	public void deberiaCalcularEstado() {
		double[][] numeros = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
							  {0,0},{1,0},{0,0},{0,0},{0,0},{1,0},
							  {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
							  {1,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros2 = {{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}};
		try {
			Matriz m = new Matriz(6,6,numeros);
			Matriz m2 = new Matriz(6,1,numeros2);
			double[][] respuesta = {{0,0},{1,0},{0,0},{0,0},{0,0},{0,0}};
			Assert.assertEquals(CalculadoraDinamica.sistemaDinamicoDeterminista(m, m2, 2019),new Matriz(6,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deberiaCalcularEstado1() {
		double[][] numeros = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
							  {0,0},{1,0},{0,0},{0,0},{0,0},{1,0},
							  {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
							  {1,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros2 = {{6,0},{0,0},{3,0},{5,0},{3,0},{8,0}};
		try {
			Matriz m = new Matriz(6,6,numeros);
			Matriz m2 = new Matriz(6,1,numeros2);
			double[][] respuesta = {{0,0},{3,0},{11,0},{8,0},{3,0},{0,0}};
			Assert.assertEquals(CalculadoraDinamica.sistemaDinamicoDeterminista(m, m2, 5000),new Matriz(6,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaCalcularEstado2() {
		double[][] numeros = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
							  {0,0},{1,0},{0,0},{0,0},{0,0},{1,0},
							  {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
							  {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
							  {1,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros2 = {{6,0},{5,0},{4,0},{3,0},{2,0},{1,0}};
		try {
			Matriz m = new Matriz(6,6,numeros);
			Matriz m2 = new Matriz(6,1,numeros2);
			double[][] respuesta = {{0,0},{6,0},{4,0},{9,0},{2,0},{0,0}};
			Assert.assertEquals(CalculadoraDinamica.sistemaDinamicoDeterminista(m, m2, 3000),new Matriz(6,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaCalcularEstadoEnsamble() {
		double[][] numeros = {{0,0},{(double)1/6,0},{(double)5/6,0},
							  {(double)1/3,0},{(double)1/2,0},{(double)1/6,0},
							  {(double)2/3,0},{(double)1/3,0},{0,0}};
		double[][] numeros2 = {{(double)1/3,0},{(double)2/3,0},
							   {(double)2/3,0},{(double)1/3,0}};
		double[][] numeros3 = {{0.8,0},{0.2,0},{0,0},{0,0},{0,0},{0,0}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			Matriz m2 = new Matriz(2,2,numeros2);
			Matriz m3 = new Matriz(6,1,numeros3);
			double[][] respuesta = {{0.8,0},{0.2,0},{0,0},{0,0},{0,0},{0,0}};
			Assert.assertEquals(CalculadoraDinamica.sistemaDinamicoDeterministaconEnsamble(m, m2, m3, 0),new Matriz(6,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
}