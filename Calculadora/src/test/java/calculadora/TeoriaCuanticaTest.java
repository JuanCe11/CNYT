package test.java.calculadora;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import main.java.calculadora.CalculadoraCuantica;
import main.java.calculadora.CalculadoraException;
import main.java.calculadora.Complejo;
import main.java.calculadora.Matriz;

public class TeoriaCuanticaTest {
	
	@Test
	public void calcularProbabilidad1() {
		double[][] psi = {{2,1},{-1,2},{0,1},{1,0},{3,-1},{2,0},{0,-2},{-2,1},{1,-3},{0,-1}};
		try {
			Matriz m = new Matriz(10,1,psi);
			CalculadoraCuantica.calcularProbabilidad(m);
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void calcularAmplitud() {
		double[][] psi = {{2,1},{-1,2},{0,1},{1,0},{3,-1},{2,0},{0,-2},{-2,1},{1,-3},{0,-1}};
		double[][] phi = {{-1,-4},{2,-3},{-7,6},{-1,1},{-5,-3},{5,0},{5,8},{4,-4},{8,-7},{2,-7}};
		try {
			Matriz psim = new Matriz(10,1,psi);
			Matriz phim = new Matriz(10,1,phi);
			CalculadoraCuantica.calcularAmplitud(psim, phim);
			assertEquals(CalculadoraCuantica.calcularAmplitud(psim, phim),new Complejo(-0.020556626417313713,-0.13019196730965366));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void calcularAmplitud2() {
		double[][] psi = {{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] phi = {{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		try {
			Matriz psim = new Matriz(10,1,psi);
			Matriz phim = new Matriz(10,1,phi);
			assertEquals(CalculadoraCuantica.calcularAmplitud(psim, phim),new Complejo(0,0));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void valorEsperado() {
		double[][] omega = {{2,0},{1,1},{1,-1},{3,0}};
		double raiz = (double)1/Math.sqrt(2);
		double[][] psi = {{raiz,0},{0,raiz}};
		try {
			Matriz psiM = new Matriz(2,1,psi);
			Matriz omegaM = new Matriz(2,2,omega);
			assertEquals(CalculadoraCuantica.calcularValorEsperado(omegaM, psiM),new Complejo(1.5000000000000004,0));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}	
	
	@Test
	public void calcularVarianza() {
		double[][] omega = {{2,0},{1,1},{1,-1},{3,0}};
		double raiz = (double)1/Math.sqrt(2);
		double[][] psi = {{raiz,0},{0,raiz}};
		try {
			Matriz psiM = new Matriz(2,1,psi);
			Matriz omegaM = new Matriz(2,2,omega);
			assertEquals(CalculadoraCuantica.calcularVarianza(omegaM, psiM),new Complejo(1.25,0));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	
	@Test
	public void quiz6ValorEsperado() {
		double[][] omega = {{0,0},{0,-1},{0,1},{0,0}};
		double raiz = (double)1/Math.sqrt(2);
		double[][] psi = {{raiz,0},{0,raiz}};
		try {
			Matriz psiM = new Matriz(2,1,psi);
			Matriz omegaM = new Matriz(2,2,omega);
			assertEquals(CalculadoraCuantica.calcularValorEsperado(omegaM, psiM),new Complejo(1.0000000000000002,0));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void quiz6Varianza() {
		double[][] omega = {{0,0},{0,-1},{0,1},{0,0}};
		double raiz = (double)1/Math.sqrt(2);
		double[][] psi = {{raiz,0},{0,raiz}};
		try {
			Matriz psiM = new Matriz(2,1,psi);
			Matriz omegaM = new Matriz(2,2,omega);
			assertEquals(CalculadoraCuantica.calcularVarianza(omegaM, psiM),new Complejo(0,0));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void calcularEsferaBloch() {
		double raiz = (double)(2*Math.sqrt(2));
		double[][] ket = {{(double)Math.sqrt(3)/raiz,(double)Math.sqrt(3)/raiz},{(double)-1/4,(double)Math.sqrt(3)/4}};
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {29.999999999999993, 255.0};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ket0() {
		double[][] ket = {{1,0},{0,0}};
		
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {0,0};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ket1() {
		double[][] ket = {{0,0},{1,0}};
			
		try {
			Matriz ketM = new Matriz(2,1,ket);

			double[] ans = {90,0};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
			
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ketIn() {
		double raiz = (double)(Math.sqrt(2));
		double[][] ket = {{(double)1/raiz,0},{0,(double)1/raiz}};
		
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {45,90};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ketOut() {
		double raiz = (double)(Math.sqrt(2));
		double[][] ket = {{0,(double)1/raiz},{(double)1/raiz,0}};
		
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {45,-90};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
			
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ketPlus() {
		double raiz = (double)(Math.sqrt(2));
		double[][] ket = {{(double)1/raiz,0},{(double)1/raiz,0}};
		
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {45,0};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
			
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void ketMenos() {
		double raiz = (double)(Math.sqrt(2));
		double[][] ket = {{(double)1/raiz,0},{(double)-1/raiz,0}};
		
		try {
			Matriz ketM = new Matriz(2,1,ket);
			double[] ans = {45,180};
			assertTrue(Arrays.equals(CalculadoraCuantica.esferaBloch(ketM), ans));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
}