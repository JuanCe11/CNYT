import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MatricesTest {

	Calculadora calc = Calculadora.getCalculadora();
	
	@Test
	public void deberiaSumar() {
		int[][] numeros = {{0,1},{1,1},{2,1},{3,1}};
		Matriz m = new Matriz(2,2,numeros);
		
	}
}
