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
		//System.out.println(correcto);
		Assert.assertEquals(respuesta,new Complejo((double)23/41,(double)-2/41));
	}
	
	@Test
	public void deberiaDividir3() {
		int[] c1 = {-3,-1};
		int[] c2 = {1,-2};		
		Complejo respuesta = calc.division(c1, c2);
		Assert.assertEquals(respuesta,new Complejo((double)-1/5,(double)-7/5));
	}
	
	@Test
	public void deberiaModulo() {
		int[] c1 = {-3,4};
		double respuesta = calc.modulo(c1);
		Assert.assertTrue(respuesta==5.0);
	}
	
	@Test
	public void deberiaModulo1() {
		int[] c1 = {0,2};
		double respuesta = calc.modulo(c1);
		Assert.assertTrue(respuesta == 2.0);
	}
	
	@Test
	public void deberiaConjugado() {
		int[] c1 = {0,2};
		Complejo respuesta = calc.conjugado(c1);
		Assert.assertEquals(respuesta,new Complejo(0,(double)-2.0));
	}
	
	@Test
	public void deberiaConjugado1() {
		int[] c1 = {20,-65};
		Complejo respuesta = calc.conjugado(c1);
		Assert.assertEquals(respuesta,new Complejo(20,(double)65));
	}
	
	@Test
	public void deberiaRectangularAPolar() {
		int[] c1 = {4,-3};
		double[] respuesta = calc.recPol(c1);
		System.out.println((double)Math.toDegrees(Math.atan(-3/4)));
		double[] correcta = {5.0,(double)Math.toDegrees(Math.atan(-3/4))};
		System.out.println(respuesta[0]+" "+respuesta[1]);
		System.out.println(correcta[0]+" "+correcta[1]);
		Assert.assertEquals(respuesta,correcta);
	}
}