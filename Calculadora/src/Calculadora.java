
public class Calculadora {
	private static Calculadora calculadora = null;
	
	 
	
	private Calculadora(){
		
	}
	
	public static Calculadora getCalculadora(){
		if(calculadora == null)
			calculadora = new Calculadora();
		return calculadora;
	}
	
	public Complejo suma(int[] com1, int[] com2){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		Complejo res = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginaria() + c2.getImaginaria());
		return res;
	}
	
	public Complejo suma(Complejo c1, Complejo c2){
		Complejo res = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginaria() + c2.getImaginaria());
		return res;
	}
	
	public Complejo resta(int[] com1, int[] com2){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		Complejo c2 = new Complejo(com2[0],com2[1]);
		Complejo res = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginaria() - c2.getImaginaria());
		return res;	
	}
	
	public Complejo resta(Complejo c1, Complejo c2){
		Complejo res = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginaria() - c2.getImaginaria());
		return res;	
	}
	
	public Complejo multiplicacion(int[] com1, int[] com2){
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
		double modulo = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginaria(), 2);
		double real =  (numerador.getReal() / modulo);
		double imaginaria =  (numerador.getImaginaria() / modulo);
		Complejo res = new Complejo(real, imaginaria);
		return res;
	}
	
	public Complejo division(Complejo c1, Complejo c2) {
		Complejo c3 = c2.conjugado();
		Complejo numerador = multiplicacion(c1,c3);
		double modulo = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginaria(), 2);
		double real =  (numerador.getReal() / modulo);
		double imaginaria =  (numerador.getImaginaria() / modulo);
		Complejo res = new Complejo(real, imaginaria);
		return res;
	}
	
	public double modulo(int[] com1){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		return c1.getModulo();
	}
	
	public double modulo(Complejo c1){
		return c1.getModulo();
	}
	
	public Complejo conjugado(Complejo c1){
		return c1.conjugado();
	}
	
	public Complejo conjugado(int[] com1){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		return c1.conjugado();
	}
	
	public double[] recPol(int[] com1) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		double [] pol = new double[2];
		pol[0] =  c1.getModulo();
		pol[1] = c1.getFase();
		return pol;
	}
}