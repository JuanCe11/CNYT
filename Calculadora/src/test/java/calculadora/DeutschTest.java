package test.java.calculadora;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import main.java.calculadora.CalculadoraException;
import main.java.calculadora.Matriz;
import main.java.calculadora.Deutsch;

public class DeutschTest {
	
	@Test
	public void simulacionU0() {
		try {
			double[][] ans = {{0.4999999999999998,0},{0.4999999999999998,0},{0,0},{0,0}};
			Matriz ansM = new Matriz(4,1,ans);
			assertEquals(Deutsch.simulacionU0(), ansM);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void simulacionU1() {
		try {
			double[][] ans = {{0.4999999999999998,0},{0.4999999999999998,0},{0,0},{0,0}};
			Matriz ansM = new Matriz(4,1,ans);
			assertEquals(Deutsch.simulacionU1(), ansM);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void simulacionUi() {
		try {
			double[][] ans = {{0,0},{0,0},{0.4999999999999998,0},{0.4999999999999998,0}};
			Matriz ansM = new Matriz(4,1,ans);
			assertEquals(Deutsch.simulacionUi(), ansM);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void simulacionUc() {
		try {
			double[][] ans = {{0,0},{0,0},{0.4999999999999998,0},{0.4999999999999998,0}};
			Matriz ansM = new Matriz(4,1,ans);
			assertEquals(Deutsch.simulacionUc(), ansM);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
}