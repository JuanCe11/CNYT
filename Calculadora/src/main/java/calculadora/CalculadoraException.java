package main.java.calculadora;

public class CalculadoraException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DIVISION_CERO = "No se puede dividir entre 0.";
	public static final String SUMA_MATRICES = "No se pueden sumar las matrices, deben ser de la misma dimensión.";
	public static final String FALTAN_NUMEROS = "El arreglo ingresado no tiene los numeros suficientes.";
	public static final String NO_ES_VECTOR = "No se tiene(n) vector(es).";
	public static final String NO_ES_CUADRADA = "La matriz no es cuadrada.";
	public static final String MATRIZ_INVALIDA = "La matriz del sistema no es válida.";
	public static final String IMPOSIBLE_CALCULAR = "Dados los datos es imosible relizar la operacion.";
	public static final String TIPO_INVALIDO = "El tipo ingresado no es valido. Recuerde 0 para clásico, 1 probabilístico y 2 para cuántico.";
	
	public CalculadoraException(String message) {
		super(message);
	}

}