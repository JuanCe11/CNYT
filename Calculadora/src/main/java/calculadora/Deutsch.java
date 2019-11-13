package main.java.calculadora;

public class Deutsch {
	
	static Matriz cero,uno,u0,u1,ui,uc,hadamart;

	/**
	 * Crea las matrices necasarias para la simulación
	 */
	private static void crearMatrices() {
		double[][] u0d = {{1,0},{0,0},{0,0},{0,0},
						 {0,0},{1,0},{0,0},{0,0},
						 {0,0},{0,0},{1,0},{0,0},
						 {0,0},{0,0},{0,0},{1,0}};
		
		double[][] u1d = {{0,0},{1,0},{0,0},{0,0},
				 		 {1,0},{0,0},{0,0},{0,0},
				 		 {0,0},{0,0},{0,0},{1,0},
				 		 {0,0},{0,0},{1,0},{0,0}};
		
		double[][] uid = {{1,0},{0,0},{0,0},{0,0},
						 {0,0},{1,0},{0,0},{0,0},
						 {0,0},{0,0},{0,0},{1,0},
						 {0,0},{0,0},{1,0},{0,0}};
		
		double[][] ucd = {{0,0},{1,0},{0,0},{0,0},
						 {1,0},{0,0},{0,0},{0,0},
						 {0,0},{0,0},{1,0},{0,0},
						 {0,0},{0,0},{0,0},{1,0}};
		double raiz = (double)1/Math.sqrt(2);
		
		double[][] had = {{raiz,0},{raiz,0},
						 {raiz,0},{raiz*-1,0}};
		
		double[][] cerod = {{1,0},{0,0}};
		double[][] unod = {{0,0},{1,0}};
		
		try {
			u0 = new Matriz(4,4,u0d);
			u1 = new Matriz(4,4,u1d);
			ui = new Matriz(4,4,uid);
			uc = new Matriz(4,4,ucd);
			hadamart = new Matriz(2,2,had);
			cero = new Matriz(2,1,cerod);
			uno = new Matriz(2,1,unod);
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}
	
	public static Matriz simulacionU0() throws CalculadoraException {
		crearMatrices();
		Matriz phi0 = CalculadoraMatrices.productoTensorial(cero, uno);
		Matriz phi1 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, hadamart), phi0);
		Matriz phi2 = CalculadoraMatrices.matrizPorMatriz(u0, phi1);
		Matriz phi3 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, CalculadoraMatrices.identidad(hadamart)), phi2);
		return CalculadoraMatrices.moduloAlCuadrado(phi3);
	}
	
	public static Matriz simulacionU1() throws CalculadoraException {
		crearMatrices();
		Matriz phi0 = CalculadoraMatrices.productoTensorial(cero, uno);
		Matriz phi1 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, hadamart), phi0);
		Matriz phi2 = CalculadoraMatrices.matrizPorMatriz(u1, phi1);
		Matriz phi3 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, CalculadoraMatrices.identidad(hadamart)), phi2);
		return CalculadoraMatrices.moduloAlCuadrado(phi3);
	}
	
	public static Matriz simulacionUi() throws CalculadoraException {
		crearMatrices();
		Matriz phi0 = CalculadoraMatrices.productoTensorial(cero, uno);
		Matriz phi1 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, hadamart), phi0);
		Matriz phi2 = CalculadoraMatrices.matrizPorMatriz(ui, phi1);
		Matriz phi3 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, CalculadoraMatrices.identidad(hadamart)), phi2);
		return CalculadoraMatrices.moduloAlCuadrado(phi3);
	}
	
	public static Matriz simulacionUc() throws CalculadoraException {
		crearMatrices();
		Matriz phi0 = CalculadoraMatrices.productoTensorial(cero, uno);
		Matriz phi1 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, hadamart), phi0);
		Matriz phi2 = CalculadoraMatrices.matrizPorMatriz(uc, phi1);
		Matriz phi3 = CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.productoTensorial(hadamart, CalculadoraMatrices.identidad(hadamart)), phi2);
		return CalculadoraMatrices.moduloAlCuadrado(phi3);
	}
}