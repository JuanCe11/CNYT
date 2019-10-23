package test.java.calculadora;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import main.java.calculadora.*;

public class TestProfesorCuantica {

	@Test
	public void  deberiaCalcularProbabiliadad() {
		double[][] numeros1 = {{2,-1},{-1.5,2.5},{-3.5,5},{-4,6},{-3.5,2.5},{0,0},{-3.5,2.5},{6,-4},{0,2.5},{-1,1}};
		try {
			Matriz m1 = new Matriz(10,1,numeros1);
			double[] respuesta = {0.025, 0.042499999999999996,
								  0.18624999999999994,0.25999999999999995,
								  0.09249999999999999,0.0,
								  0.09249999999999999,0.25999999999999995,
								  0.031249999999999997,0.01};
			assertTrue(Arrays.equals(CalculadoraCuantica.calcularProbabilidad(m1), respuesta));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void valorCalcularEsperadoyVarianza() {
		double[][] omega = {{0,0},{0,(double)-1/2},{0,-1},{(double)-7/2,0},
		                    {0,(double)1/2},{0,0},{(double)7/2,0},{0,-1},
		                    {0,1},{(double)7/2,0},{0,0},{0,(double)-1/2},
		                    {(double)-7/2,0},{0,1},{0,(double)1/2},{0,0}};
		                   
		double[][] psi = {{-2, 1},{1, 0},{0,-1},{3,2}};
		try {
			Matriz psiM = new Matriz(4,1,psi);
			Matriz omegaM = new Matriz(4,4,omega);
			System.out.println(CalculadoraCuantica.calcularValorEsperado(omegaM, psiM));
			System.out.println(CalculadoraCuantica.calcularVarianza(omegaM, psiM));
		} catch (CalculadoraException e) {
			assertEquals(e.getMessage(), CalculadoraException.MATRIZ_INVALIDA);
		}
	}
}
