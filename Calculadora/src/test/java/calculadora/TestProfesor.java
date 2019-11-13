package test.java.calculadora;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.calculadora.CalculadoraException;
import main.java.calculadora.CalculadoraMatrices;
import main.java.calculadora.Complejo;
import main.java.calculadora.Matriz;

public class TestProfesor {

	@Test
	public void deberiaSumarVectores() {
		double[][] numeros1 = {{8,3},{-1,-4},{0,-9}};
		double[][] numeros2 = {{8,-3},{2,5},{3,0}};
		try {
			Matriz m1 = new Matriz(3,1,numeros1);
			Matriz m2 = new Matriz(3,1,numeros2);
			double[][] respuesta = {{16,0},{1,1},{3,-9}};
			assertEquals(CalculadoraMatrices.sumaMatriz(m1, m2),new Matriz(3,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaVector() {
		double[][] numeros = {{-5,2},{3,0},{0,-1}};
		try {
			Matriz m = new Matriz(3,1,numeros);
			double[][] respuesta = {{5,-2},{-3,0},{0,1}};
			assertEquals(CalculadoraMatrices.inversaVectores(m),new Matriz(3,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMultiplicarPorEscalarVector() {
		double[][] numeros ={{-2,5},{-1,-1},{2,-9}};
		double[] escalar = {-1,1};
		try {
			Matriz m = new Matriz(3,1,numeros);
			double[][] respuesta = {{-3,-7},{2,0},{7,11}};
			assertEquals(CalculadoraMatrices.multiplicacionEscalarVector(escalar, m),new Matriz(3,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deberiaSumarMatriz() {
		double[][] numeros1 = {{-7 ,-2},{-4,-2},{7,7},{5 ,9},{0,3},{6,-5},{1,5},{-6,-6},{5,8}};
		double[][] numeros2 = {{-8 ,-3},{-6,-4},{0,-4},{-1 ,8},{6,-10},{8,-5},{4 ,0},{8, 5},{-7,-9}};
		try {
			Matriz m1 = new Matriz(2,2,numeros1);
			Matriz m2 = new Matriz(2,2,numeros2);
			double[][] respuesta = {{-15 ,-5},{-10,-6},{7,3},{4 ,17},{6,-7},{14,-10},{5 ,5},{2, -1},{-2,-1}};
			assertEquals(CalculadoraMatrices.sumaMatriz(m1, m2),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaMatriz() {
		double[][] numeros = {{7,3},{-1,7},{-9,-4},{-7,-9}};
		try {
			Matriz m = new Matriz(3,1,numeros);
			double[][] respuesta = {{-7,-3},{1,-7},{9,4},{7,9}};
			assertEquals(CalculadoraMatrices.inversaVectores(m),new Matriz(3,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMultiplicarPorEscalarMatriz() {
		double[][] numeros ={{3,-2},{8,-4},{4,-10},{-2,-8}};
		double[] escalar = {-2,3};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{0,13},{-4,32},{22,32},{28,10}};
			assertEquals(CalculadoraMatrices.multiplicacionEscalarMatriz(escalar, m),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaTranspuesta() {
		double[][] numeros = {{5,9},{-7,-5},{-1,-4},{8,2},{-3,-7},{7,-8}};
		try {
			Matriz m = new Matriz(2,3,numeros);
			double[][] respuesta = {{5,9},{8,2},{-7,-5},{-3,-7},{-1,-4},{7,-8}};
			assertEquals(CalculadoraMatrices.matrizTranspuesta(m),new Matriz(3,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaConjugada() {
		double[][] numeros ={{-6,1},{3,8},{2,-6},{3,0}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{-6,-1},{3,-8},{2,6},{3,0}};
			assertEquals(CalculadoraMatrices.matrizConjugada(m),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaAdjunta() {
		double[][] numeros ={{7,7},{3,8},{8,4},{5,0},{8,6},{-10,-1}};
		try {
			Matriz m = new Matriz(2,3,numeros);
			double[][] respuesta = {{7,-7},{5,0},{3,-8},{8,-6},{8,-4},{-10,1}};
			assertEquals(CalculadoraMatrices.matrizAdjunta(m),new Matriz(3,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizporMatriz() {
		double[][] numeros1 = {{-6,2},{0,6},{7,2},{6,9},{7,7},{-6,-6},{5,8},{-6,8},{6,9}};
		double[][] numeros2 = {{9,-6},{-3,-4},{5,-2},{3,6},{-1,-5},{0,-5},{9,9},{8,-4},{-8,-4}};
		try {
			Matriz m1 = new Matriz(3,3,numeros1);
			Matriz m2 = new Matriz(3,3,numeros2);
			double[][] respuesta = {{-33,153},{120,0},{-44,-22},{87,0},{-26,-117},{107,70},{0,165},{147,26},{69,-36}};
			assertEquals(CalculadoraMatrices.matrizPorMatriz(m1, m2),new Matriz(3,3,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void noDeberiaMatrizporMatriz() {
		double[][] numeros1 = {{2,1},{3,0},{1,-1},{0,0},{0,-2},{7,-3},{3,0},{0,0},{1,-2}};
		double[][] numeros2 = {{0,-1},{1,0},{0,0},{0,1}};
		try {
			Matriz m1 = new Matriz(3,3,numeros1);
			Matriz m2 = new Matriz(2,2,numeros2);
			CalculadoraMatrices.matrizPorMatriz(m1, m2);
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.SUMA_MATRICES);
		}
	}
	
	@Test
	public void deberiaMatrizSobreVector() {
		double[][] numeros = {{-1,5},{1,-7},{-6,3},{-3,-9},{2,-5},{1,-10},{-6,5},{6,-5},{3,-2}};
		double[][] numeros2 = {{1,-3},{4,3},{-3,1}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			Matriz m2 = new Matriz(3,1,numeros2);
			double[][] respuesta = {{54,-32},{0,17},{41,30}};
			assertEquals(CalculadoraMatrices.matrizPorVector(m, m2),new Matriz(3,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaProductoInternoVectores() {
		double[][] numeros = {{2,-1},{-8,-5},{-2,-6}};
		double[][] numeros2 = {{6,-3},{5,-1},{-6,-2}};
		try {
			Matriz m = new Matriz(3,1,numeros);
			Matriz m2 = new Matriz(3,1,numeros2);
			assertEquals(CalculadoraMatrices.productoInterno(m, m2),new Complejo(4,1));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deberiaNormaVector() {
		double[][] numeros = {{4,5},{3,1},{0,-7}};
		try {
			Matriz m = new Matriz(3,1,numeros);
			assertTrue(CalculadoraMatrices.normaDeUnVector(m) == 10);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaDistanciaVectores() {
		double[][] numeros ={{2,7},{4,-1},{2,-4}};
		double[][] numeros2 = {{7,8},{2,-8},{1,4}};
		try {
			Matriz m = new Matriz(3,1,numeros);
			Matriz m2 = new Matriz(3,1,numeros2);
			assertTrue(CalculadoraMatrices.distanciaEntreVectores(m, m2) == 12);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaDistanciaVectores2() {
		double[][] numeros ={{9,-7},{-1,-6}};
		double[][] numeros2 = {{7,-8},{5,-9}};
		try {
			Matriz m = new Matriz(2,1,numeros);
			Matriz m2 = new Matriz(2,1,numeros2);
			assertTrue(CalculadoraMatrices.distanciaEntreVectores(m, m2) == Math.sqrt(50));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deberiaMatrizUnitaria() {
		double[][] numeros ={{1/Math.sqrt(2),0},{0,1/Math.sqrt(2)},{0,1/Math.sqrt(2)},{1/Math.sqrt(2),0}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			assertTrue(CalculadoraMatrices.esUnitaria(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void noDeberiaMatrizUnitaria() {
		double[][] numeros ={{0,1},{1,0},{0,0},{0,0},{0,1},{1,0},{1,0},{0,0},{0,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			assertFalse(CalculadoraMatrices.esUnitaria(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaHermitania() {
		double[][] numeros ={{3,0},{2,-1},{0,-3},{2,1},{0,0},{1,-1},{0,3},{1,1},{0,0}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			assertTrue(CalculadoraMatrices.esHermitania(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void noDeberiaHermitania() {
		double[][] numeros ={{1,0},{3,-1},{3,1},{0,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			assertFalse(CalculadoraMatrices.esHermitania(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaProductoTensorial() {
		double[][] numeros ={{1,1},{0,0},{1,0},{0,1}};
		double[][] numeros2 ={{-1,2},{-2,-2},{0,2},{2,3},{3,1},{2,2},{-2,1},{1,-1},{2,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Matriz m2 = new Matriz(3,3,numeros2);
			double[][] respuesta ={{-3,1},{0,-4},{-2,2},{0,0},{0,0},{0,0},
									{-1,5},{2,4},{0,4},{0,0},{0,0},{0,0},
									{-3,-1},{2,0},{1,3},{0,0},{0,0},{0,0},
									{-1,2},{-2,-2},{0,2},{-2,-1},{2,-2},{-2,0},
									{2,3},{3,1},{2,2},{-3,2},{-1,3},{-2,2},
									{-2,1},{1,-1},{2,1},{-1,-2},{1,1},{-1,2}};
			assertEquals(CalculadoraMatrices.productoTensorial(m, m2), new Matriz(6,6,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
}