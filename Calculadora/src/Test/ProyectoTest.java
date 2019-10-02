package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import aplicacion.*;

public class ProyectoTest {

	@Test
	public void deberiaCalcularEstadoClasico() {
							  //0     1     2     3     4     5     6    7      8     9     10   11     12
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
			double[][] numeros3 = {{0,0},{0,0},{1,0},{7,0},{2,0},{21,0},{5,0},{0,0},{4,0},{0,0},{3,0},{5,0},{0,0}};
			Matriz m3 = new Matriz(13,1,numeros3);
			Assert.assertTrue(r.isMatrizValida());
			//System.out.println(r.getEstadoFinal());
			Assert.assertEquals(m3, r.getEstadoFinal());
		} catch (CalculadoraException e) {
			System.out.println("Algo fallo.");
			Assert.fail();
		}
	}
	
	@Test
	public void deberiaCalcularProbabilistico() {
							  //0      1       2       3    
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
			System.out.println(CalculadoraDinamica.sistemaDinamicoconEnsamble(m, m2, m3, m4, 5));
		} catch (CalculadoraException e) {
			System.out.println("Algo fallo.");
			Assert.fail();
		}
	}
	
	@Test
	public void deberiaCalcularRendijas() {
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
			System.out.println(res.getEstadoFinal());
		} catch (CalculadoraException e) {
			System.out.println("Algo fallo.");
			Assert.fail();
		}
	}
}