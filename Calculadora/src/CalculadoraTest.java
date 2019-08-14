import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora calc = Calculadora.getCalculadora();
	
	@Test
	public void deberiaSumar() {
		int[] c1 = {0,1};
		int[] c2 = {1,0};		
		Complejo respuesta = calc.suma(c1,c2);
		Assert.assertEquals(respuesta,new Complejo(1,1));
	}
	
	@Test
	public void deberiaMultiplicar() {
		int[] c1 = {3,-2};
		int[] c2 = {6,8};		
		Complejo respuesta = calc.multiplicacion(c1, c2);
		Assert.assertEquals(respuesta,new Complejo(34,12));
	}
	
	@Test
	public void deberiaMultiplicar1() {
		int[] c1 = {-3,-1};
		int[] c2 = {1,-2};		
		Complejo respuesta = calc.multiplicacion(c1, c2);
		Assert.assertEquals(respuesta,new Complejo(-5,5));
	}
	
	@Test
	public void deberiaDividir() {
		int[] c1 = {-2,1};
		int[] c2 = {1,2};		
		Complejo respuesta = calc.division(c1, c2);
		Assert.assertEquals(respuesta,new Complejo(0,1));
	}
	
	@Test
	public void deberiaDividir1() {
		int[] c1 = {0,3};
		int[] c2 = {-1,-1};		
		Complejo respuesta = calc.division(c1, c2);
		Assert.assertEquals(respuesta,new Complejo((double)-3/2,(double)-3/2));
	}
	
	@Test
	public void deberiaDividir2() {
		int[] c1 = {2,-3};
		int[] c2 = {4,-5};		
		Complejo respuesta = calc.division(c1, c2);
		//System.out.println(respuesta);
		//Assert.assertEquals(respuesta,new Complejo(-3/2,-3/2));
	}
	
	@Test
	public void deberiaDividir3() {
		int[] c1 = {-3,-1};
		int[] c2 = {1,-2};		
		Complejo respuesta = calc.division(c1, c2);
		//System.out.println(respuesta);
		//Assert.assertEquals(respuesta,new Complejo(-3/2,-3/2));
	}

}
