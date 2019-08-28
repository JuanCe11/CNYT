
public class CalculadoraException extends Exception {
	public static final String DIVISION_CERO = "No se puede dividir entre 0.";
	public static final String SUMA_MATRICES = "No se pueden sumar las matrices, deben ser de la misma dimensión.";
	public static final String FALTAN_NUMEROS = "El arreglo ingresado no tiene los numero suficientes.";
	public static final String NO_ES_VECTOR = "No se tiene(n) vector(es).";
	
	public CalculadoraException(String message) {
		super(message);
	}

}