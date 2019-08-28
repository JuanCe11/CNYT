
public class CalculadoraException extends Exception {
	public static final String DIVISION_CERO = "No se puede dividir entre 0.";
	public static final String SUMA_MATRICES = "No se pueden sumar las matrices, deben ser de la misma dimensión.";
	
	public CalculadoraException(String message) {
		super(message);
	}

}
