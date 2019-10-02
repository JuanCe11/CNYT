package test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import aplicacion.*;

public class MatricesTest {

	Calculadora calc = Calculadora.getCalculadora();
	
	@Test
	public void deberiaSumarMatriz() {
		double[][] numeros2 = {{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros = {{0,1},{1,1},{2,1},{3,1}};
		try {
			Matriz m2 = new Matriz(2,2,numeros2);
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{0,1},{1,1},{2,1},{3,1}};
			Assert.assertEquals(CalculadoraMatrices.sumaMatriz(m, m2),new Matriz(2,2,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaSumarMatriz1() {
		double[][] numeros2 = {{1,1},{2,2},{3,3},{4,4}};
		double[][] numeros = {{1,1},{1,1},{1,1},{1,1}};
		try {
			Matriz m2 = new Matriz(2,2,numeros2);
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{2,2},{3,3},{4,4},{5,5}};
			Assert.assertEquals(CalculadoraMatrices.sumaMatriz(m, m2),new Matriz(2,2,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaSumarVector() {
		double[][] numeros2 = {{0,0},{0,0},{0,0},{0,0}};
		double[][] numeros = {{0,1},{1,1},{2,1},{3,1}};
		try {
			Matriz m2 = new Matriz(4,1,numeros2);
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{0,1},{1,1},{2,1},{3,1}};
			Assert.assertEquals(CalculadoraMatrices.sumaVectores(m, m2),new Matriz(4,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaSumarVector1() {
		double[][] numeros2 = {{1,1},{2,2},{3,3},{4,4}};
		double[][] numeros = {{1,1},{1,1},{1,1},{1,1}};
		try {
			Matriz m2 = new Matriz(4,1,numeros2);
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{2,2},{3,3},{4,4},{5,5}};
			Assert.assertEquals(CalculadoraMatrices.sumaVectores(m, m2),new Matriz(4,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaMatriz() {
		double[][] numeros = {{1,1},{2,2},{3,3},{4,4}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{-1,-1},{-2,-2},{-3,-3},{-4,-4}};
			Assert.assertEquals(CalculadoraMatrices.inversaMatriz(m),new Matriz(2,2,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaMatriz2() {
		double[][] numeros ={{-1,-1},{-2,-2},{-3,-3},{-4,-4}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{1,1},{2,2},{3,3},{4,4}};
			Assert.assertEquals(CalculadoraMatrices.inversaMatriz(m),new Matriz(2,2,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaMatriz3() {
		double[][] numeros ={{0,0},{-2,-2},{-3,-3},{-4,-4}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{0,0},{2,2},{3,3},{4,4}};
			Assert.assertEquals(CalculadoraMatrices.inversaMatriz(m),new Matriz(2,2,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaVector() {
		double[][] numeros = {{1,1},{2,2},{3,3},{4,4}};
		try {
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{-1,-1},{-2,-2},{-3,-3},{-4,-4}};
			Assert.assertEquals(CalculadoraMatrices.inversaVectores(m),new Matriz(4,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaVector2() {
		double[][] numeros ={{-1,-1},{-2,-2},{-3,-3},{-4,-4}};
		try {
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{1,1},{2,2},{3,3},{4,4}};
			Assert.assertEquals(CalculadoraMatrices.inversaVectores(m),new Matriz(4,1,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaInversaVector3() {
		double[][] numeros ={{0,0},{-2,-2},{-3,-3},{-4,-4}};
		try {
			Matriz m = new Matriz(1,4,numeros);
			double[][] respuesta = {{0,0},{2,2},{3,3},{4,4}};
			Assert.assertEquals(CalculadoraMatrices.inversaVectores(m),new Matriz(1,4,respuesta) );
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deberiaMultiplicarPorEscalarVector1() {
		double[][] numeros ={{6,3},{0,0},{5,1},{4,0}};
		double[] escalar = {3,2};
		try {
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{12,21},{0,0},{13,13},{12,8}};
			Assert.assertEquals(CalculadoraMatrices.multiplicacionEscalarVector(escalar, m),new Matriz(4,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMultiplicarPorEscalar() {
		double[][] numeros ={{0,0},{2,2},{3,3},{4,4}};
		double[] escalar = {10,0};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{0,0},{20,20},{30,30},{40,40}};
			Assert.assertEquals(CalculadoraMatrices.multiplicacionEscalarMatriz(escalar, m),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMultiplicarPorEscalar1() {
		double[][] numeros ={{6,3},{0,0},{5,1},{4,0}};
		double[] escalar = {3,2};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{12,21},{0,0},{13,13},{12,8}};
			Assert.assertEquals(CalculadoraMatrices.multiplicacionEscalarMatriz(escalar, m),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaTranspuestaVector() {
		double[][] numeros = {{0,0},{1,1},{2,2},{3,3}};
		try {
			Matriz m = new Matriz(4,1,numeros);
			double[][] respuesta = {{0,0},{1,1},{2,2},{3,3}};
			Assert.assertEquals(CalculadoraMatrices.matrizTranspuesta(m),new Matriz(1,4,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaConjugadaVector() {
		double[][] numeros ={{6,-3},{2,12},{0,-19},{0,0},{5,2.1},{17,0},{1,0},{2,5},{3,-4.5}};
		try {
			Matriz m = new Matriz(9,1,numeros);
			double[][] respuesta = {{6,3},{2,-12},{0,19},{0,0},{5,-2.1},{17,0},{1,0},{2,-5},{3,4.5}};
			Assert.assertEquals(CalculadoraMatrices.matrizConjugada(m),new Matriz(9,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaAdjuntaVector() {
		double[][] numeros ={{6,-3},{2,12},{0,-19},{0,0},{5,2.1},{17,0},{1,0},{2,5},{3,-4.5}};
		try {
			Matriz m = new Matriz(9,1,numeros);
			double[][] respuesta =  {{6,3},{2,-12},{0,19},{0,0},{5,-2.1},{17,0},{1,0},{2,-5},{3,4.5}};
			Assert.assertEquals(CalculadoraMatrices.matrizAdjunta(m),new Matriz(1,9,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaTranspuestaMatriz() {
		double[][] numeros ={{6,-3},{2,12},{0,-19},{0,0},{5,2.1},{17,0},{1,0},{2,5},{3,-4.5}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			double[][] respuesta = {{6,-3},{0,0},{1,0},{2,12},{5,2.1},{2,5},{0,-19},{17,0},{3,-4.5}};
			Assert.assertEquals(CalculadoraMatrices.matrizTranspuesta(m),new Matriz(3,3,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaConjugadaMatriz() {
		double[][] numeros ={{6,-3},{2,12},{0,-19},{0,0},{5,2.1},{17,0},{1,0},{2,5},{3,-4.5}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			double[][] respuesta = {{6,3},{2,-12},{0,19},{0,0},{5,-2.1},{17,0},{1,0},{2,-5},{3,4.5}};
			Assert.assertEquals(CalculadoraMatrices.matrizConjugada(m),new Matriz(3,3,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaAdjuntaMatriz() {
		double[][] numeros ={{6,-3},{2,12},{0,-19},{0,0},{5,2.1},{17,0},{1,0},{2,5},{3,-4.5}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			double[][] respuesta = {{6,3},{0,0},{1,0},{2,-12},{5,-2.1},{2,-5},{0,19},{17,0},{3,4.5}};
			Assert.assertEquals(CalculadoraMatrices.matrizAdjunta(m),new Matriz(3,3,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizSobreVector() {
		double[][] numeros ={{1,0},{1,0},{1,0},{1,0},{1,0},{0,1}};
		double[][] numeros2 ={{0,1},{1,0}};
		try {
			Matriz m = new Matriz(3,2,numeros);
			Matriz m2 = new Matriz(2,1,numeros2);
			double[][] respuesta = {{1,1},{1,1},{0,2}};
			Assert.assertEquals(CalculadoraMatrices.matrizPorVector(m, m2),new Matriz(3,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizSobreVector2() {
		double[][] numeros ={{0,0},{0,-2},{0,2},{0,0}};
		double[][] numeros2 ={{0,1},{1,0}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Matriz m2 = new Matriz(2,1,numeros2);
			double[][] respuesta = {{0,-2},{-2,0}};
			Assert.assertEquals(CalculadoraMatrices.matrizPorVector(m, m2),new Matriz(2,1,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaHermitania() {
		double[][] numeros ={{2,0},{3,-1},{3,1},{-1,0}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Assert.assertTrue(CalculadoraMatrices.esHermitania(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizporMatriz() {
		double[][] numeros ={{2,0},{3,-1},{3,1},{-1,0}};
		double[][] numeros2 ={{1,0},{1,0},{1,0},{0,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Matriz m2 = new Matriz(2,2,numeros2);
			double[][] respuesta = {{5,-1},{3,3},{2,1},{3,0}};
			Assert.assertEquals(CalculadoraMatrices.matrizPorMatriz(m, m2),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizporMatriz1() {
		double[][] numeros ={{0,0},{0,-2},{0,2},{0,0}};
		double[][] numeros2 ={{1,0},{1,0},{1,0},{0,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Matriz m2 = new Matriz(2,2,numeros2);
			double[][] respuesta = {{0,-2},{2,0},{0,2},{0,2}};
			Assert.assertEquals(CalculadoraMatrices.matrizPorMatriz(m, m2),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizpoIdentidad() {
		double[][] numeros ={{0,0},{0,-2},{0,2},{0,0}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			double[][] respuesta = {{1,0},{0,0},{0,0},{1,0}};
			Assert.assertEquals(CalculadoraMatrices.identidad(m),new Matriz(2,2,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deberiaMatrizpoIdentidad2() {
		double[][] numeros ={{0,0},{0,-2},{0,2},{0,0},{0,2},{0,0},{0,2},{0,0},{0,2}};
		try {
			Matriz m = new Matriz(3,3,numeros);
			double[][] respuesta = {{1,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{1,0}};
			Assert.assertEquals(CalculadoraMatrices.identidad(m),new Matriz(3,3,respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deberiaMatrizUnitaria() {
		double[][] numeros ={{0,1},{0,0},{0,0},{0,1}};
		try {
			Matriz m = new Matriz(2,2,numeros);
			Assert.assertTrue(CalculadoraMatrices.esUnitaria(m));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
}