import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NumerosComplejosTest {
	
	
	
	@Test
	public void deberiaSumar() {
		int[] c1 = {0,1};
		int[] c2 = {1,0};		
		Complejo respuesta = Calculadora.suma(c1,c2);
		Assert.assertEquals(respuesta,new Complejo(1,1));
	}
	
	@Test
	public void deberiaMultiplicar() {
		int[] c1 = {3,-2};
		int[] c2 = {6,8};		
		Complejo respuesta = Calculadora.multiplicacion(c1, c2);
		Assert.assertEquals(respuesta,new Complejo(34,12));
	}
	
	@Test
	public void deberiaMultiplicar1() {
		int[] c1 = {-3,-1};
		int[] c2 = {1,-2};		
		Complejo respuesta = Calculadora.multiplicacion(c1, c2);
		Assert.assertEquals(respuesta,new Complejo(-5,5));
	}
	
	@Test
	public void deberiaDividir() {
		int[] c1 = {-2,1};
		int[] c2 = {1,2};
		Complejo respuesta = null;
		try {
			respuesta = Calculadora.division(c1, c2);
		}catch(CalculadoraException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(respuesta,new Complejo(0,1));
	}
	
	@Test
	public void deberiaDividir1() {
		int[] c1 = {0,3};
		int[] c2 = {-1,-1};		
		Complejo respuesta = null;
		try {
			respuesta = Calculadora.division(c1, c2);
		}catch(CalculadoraException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(respuesta,new Complejo((double)-3/2,(double)-3/2));
	}
	
	@Test
	public void deberiaDividir2() {
		int[] c1 = {2,-3};
		int[] c2 = {4,-5};		
		Complejo respuesta = null;
		try {
			respuesta = Calculadora.division(c1, c2);
		}catch(CalculadoraException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(respuesta,new Complejo((double)23/41,(double)-2/41));
	}
	
	@Test
	public void deberiaDividir3() {
		int[] c1 = {-3,-1};
		int[] c2 = {1,-2};		
		Complejo respuesta = null;
		try {
			respuesta = Calculadora.division(c1, c2);
		}catch(CalculadoraException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(respuesta,new Complejo((double)-1/5,(double)-7/5));
	}
	
	@Test
	public void deberiaDividir4() {
		int[] c1 = {-3,-1};
		int[] c2 = {0,0};		
		try {
			Calculadora.division(c1, c2);
		}catch(CalculadoraException e) {
			Assert.assertEquals(e.getMessage(),CalculadoraException.DIVISION_CERO);
		}
	}
	
	@Test
	public void deberiaModulo() {
		int[] c1 = {-3,4};
		double respuesta = Calculadora.modulo(c1);
		Assert.assertTrue(respuesta==5.0);
	}
	
	@Test
	public void deberiaModulo1() {
		int[] c1 = {0,2};
		double respuesta = Calculadora.modulo(c1);
		Assert.assertTrue(respuesta == 2.0);
	}
	
	@Test
	public void deberiaConjugado() {
		int[] c1 = {0,2};
		Complejo respuesta = Calculadora.conjugado(c1);
		Assert.assertEquals(respuesta,new Complejo(0,(double)-2.0));
	}
	
	@Test
	public void deberiaConjugado1() {
		int[] c1 = {20,-65};
		Complejo respuesta = Calculadora.conjugado(c1);
		Assert.assertEquals(respuesta,new Complejo(20,(double)65));
	}
	
	@Test
	public void deberiaRectangularAPolar() {
		int[] c1 = {4,-3};
		double[] respuesta = Calculadora.recPol(c1);
		double[] correcta = {5.0,convertirAngulo(Math.toDegrees(Math.atan((double)-3/4)),4,-3)};
		Assert.assertTrue(respuesta[0]==correcta[0]&&respuesta[1]==correcta[1]);
	}
	
	@Test
	public void deberiaPolarARectangular() {
		int[] c1 = {1,90};
		double[] respuesta = Calculadora.polRec(c1);
		double[] correcta = {0.0,1.0};
		Assert.assertTrue(respuesta[0]==correcta[0]&&respuesta[1]==correcta[1]);
	}
	
	@Test
	public void deberiadarFase() {
		int[] c1 = {-3,4};
		double respuesta = Calculadora.fase(c1);
		double correcta = convertirAngulo(Math.toDegrees(Math.atan((double)-4/3)),-3,4);
		Assert.assertTrue(respuesta == correcta);
	}
	
	@Test
	public void deberiadarFase1() {
		int[] c1 = {3,4};
		double respuesta = Calculadora.fase(c1);
		double correcta = convertirAngulo(Math.toDegrees(Math.atan((double)4/3)),3,4);
		Assert.assertTrue(respuesta == correcta);
	}
	
	@Test
	public void deberiadarFase2() {
		int[] c1 = {3,-4};
		double respuesta = Calculadora.fase(c1);
		double correcta = convertirAngulo(Math.toDegrees(Math.atan((double)-4/3)),3,-4);
		Assert.assertTrue(respuesta == correcta);
	}
	
	@Test
	public void deberiadarFase3() {
		int[] c1 = {-3,-4};
		double respuesta = Calculadora.fase(c1);
		double correcta = convertirAngulo(Math.toDegrees(Math.atan((double)4/3)),-3,-4);
		Assert.assertTrue(respuesta == correcta);
	}
	
	private double convertirAngulo(double angulo,double real,double imaginaria) {
		double fase;
		fase = (double) Math.toDegrees(Math.atan(imaginaria/real));
		if(real<0 && imaginaria<0 || real<0 && imaginaria>0) {
			fase+=180;
		}else if (real>0 && imaginaria<0) {
			fase+=360;
		}
		return fase;
	}
}