package test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import aplicacion.*;

public class TeoriaCuanticaTest {
	
	@Test
	public void calcularProbabilidad1() {
		double[][] psi = {{2,1},{-1,2},{0,1},{1,0},{3,-1},{2,0},{0,-2},{-2,1},{1,-3},{0,-1}};
		try {
			Matriz m = new Matriz(10,1,psi);
			CalculadoraCuantica.calcularProbabilidad(m);
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
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
			Assert.assertEquals(CalculadoraCuantica.calcularAmplitud(psim, phim),new Complejo(-0.020556626417313713,-0.13019196730965366));
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
	
	@Test
	public void calcularAmplitud2() {
		double[][] psi = {{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		double[][] phi = {{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
		try {
			Matriz psim = new Matriz(10,1,psi);
			Matriz phim = new Matriz(10,1,phi);
			Assert.assertEquals(CalculadoraCuantica.calcularAmplitud(psim, phim),new Complejo(0,0));
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
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
			Assert.assertEquals(CalculadoraCuantica.calcularValorEsperado(omegaM, psiM),new Complejo(1.4999999999999996,0));
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
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
			Assert.assertEquals(CalculadoraCuantica.calcularVarianza(omegaM, psiM),new Complejo(1.2500000000000002,0));
		} catch (CalculadoraException e) {
			Assert.assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
}