
public class Calculadora {
	private static Calculadora calculadora = null;
	
	 
	
	private Calculadora(){
		
	}
	
	public static Calculadora getCalculadora(){
		if(calculadora == null)
			calculadora = new Calculadora();
		return calculadora;
	}
	
	public Complejo suma(int[] com1, int[] com2) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		Complejo res = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginaria() + c2.getImaginaria());
		return res;
	}
	
	public Complejo resta(int[] com1, int[] com2) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		Complejo res = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginaria() - c2.getImaginaria());
		return res;	
	}
	
	public Complejo multiplicacion(int[] com1, int[] com2) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		double real = (c1.getReal() * c2.getReal()) + (-1 * c1.getImaginaria() * c2.getImaginaria());
		double imaginaria = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria() * c2.getReal());
		Complejo res = new Complejo(real, imaginaria);
		return res;	
	}
	
	public Complejo multiplicacion(Complejo c1, Complejo c2) {
		double real = (c1.getReal() * c2.getReal()) + (-1 * c1.getImaginaria() * c2.getImaginaria());
		double imaginaria = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria() * c2.getReal());
		Complejo res = new Complejo(real, imaginaria);
		return res;	
	}
	
	public Complejo division(int[] com1, int[] com2) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		Complejo c3 = c2.conjugado();
		Complejo numerador = multiplicacion(c1,c3);
		float real =  (float) (numerador.getReal() / Math.pow(c2.getModulo(), 2));
		float imaginaria =  (float) (numerador.getImaginaria() / Math.pow(c2.getModulo(), 2));
		Complejo res = new Complejo(real, imaginaria);
		return res;
	}
}
