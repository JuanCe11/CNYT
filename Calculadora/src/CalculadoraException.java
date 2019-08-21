
public class CalculadoraException extends Exception {
	public static final String DIVISION_CERO = "No se puede dividir entre 0.";
	
	public CalculadoraException(String message) {
		super(message);
	}

}
