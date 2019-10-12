package main.java.calculadora;
public class Calculadora {
	private static Calculadora calculadora = null;
	
	 
	
	private Calculadora(){
		
	}
	/**
	 * Da la calculadora creada 
	 * @return La calculadora a usar.
	 */
	public static Calculadora getCalculadora(){
		if(calculadora == null)
			calculadora = new Calculadora();
		return calculadora;
	}
	/**
	 * Calcula la suma de dos numeros complejos
	 * @param complejo1 las componentes rectangulares del numero 1
	 * @param complejo2 las componentes rectangulares del numero 1
	 * @return un numero complejo con la suma de complejo1 y complejo2
	 */
	public static Complejo suma(int[] complejo1, int[] complejo2){
		Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
		Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
		Complejo res = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginaria() + c2.getImaginaria());
		return res;
	}
	
	/**
	 * Calcula la suma de dos numeros complejos
	 * @param complejo1 el primer numero complejo
	 * @param complejo2 el segundo numero complejo
	 * @return un numero complejo con la suma de complejo1 y complejo2
	 */
	public static Complejo suma(Complejo complejo1, Complejo complejo2){
		Complejo res = new Complejo(complejo1.getReal() + complejo2.getReal(), complejo1.getImaginaria() + complejo2.getImaginaria());
		return res;
	}
	
	/**
	 * Calcula la resta de dos numeros complejos
	 * @param complejo1 las componentes rectangulares del numero 1
	 * @param complejo2 las componentes rectangulares del numero 1
	 * @return un numero complejo con la resta de complejo1 y complejo2
	 */
	public static Complejo resta(int[] complejo1, int[] complejo2){
		Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
		Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
		Complejo res = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginaria() - c2.getImaginaria());
		return res;	
	}
	
	/**
	 * Calcula la suma de dos numeros complejos
	 * @param complejo1 el primer numero complejo
	 * @param complejo2 el segundo numero complejo
	 * @return un numero complejo con la resta de complejo1 y complejo2
	 */
	public static Complejo resta(Complejo complejo1, Complejo complejo2){
		Complejo res = new Complejo(complejo1.getReal() - complejo2.getReal(), complejo1.getImaginaria() - complejo2.getImaginaria());
		return res;	
	}
	
	/**
	 * Calcula la multiplicacion de dos numeros complejos
	 * @param complejo1 las componentes rectangulares del numero 1
	 * @param complejo2 las componentes rectangulares del numero 1
	 * @return un numero complejo con la multiplicacion de complejo1 y complejo2
	 */
	public static Complejo multiplicacion(int[] complejo1, int[] complejo2){
		Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
		Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
		double real = c1.getReal() * c2.getReal() + (-1 * c1.getImaginaria() * c2.getImaginaria());
		double imaginaria = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria() * c2.getReal());
		Complejo res = new Complejo(real, imaginaria);
		return res;
		//double parteReal = ((double)Math.round((a.getParteReal()*b.getParteReal()) * 100d) / 100d)  -  ((double)Math.round((a.getParteImaginaria()*b.getParteImaginaria()) * 100d) / 100d);
	}
	
	/**
	 * Calcula la multiplicacion de dos numeros complejos
	 * @param c1 el primer numero complejo
	 * @param c2 el segundo numero complejo
	 * @return un numero complejo con la multiplicacion de complejo1 y complejo2
	 */
	public static Complejo multiplicacion(Complejo c1, Complejo c2) {
		double real = (c1.getReal() * c2.getReal()) + (-1 * c1.getImaginaria() * c2.getImaginaria());
		double imaginaria = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria() * c2.getReal());
		Complejo res = new Complejo(real, imaginaria);
		return res;	
	}
	
	/**
	 * Calcula la multiplicacion de dos numeros complejos
	 * @param complejo1 las componentes rectangulares del numero 1
	 * @param complejo2 las componentes rectangulares del numero 1
	 * @return un numero complejo con la resta de complejo1 y complejo2
	 * @throws CalculadoraException cuando el divisor es 0
	 */
	public static Complejo division(int[] complejo1, int[] complejo2) throws CalculadoraException {
		Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
		Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
		if (c2.equals(new Complejo(0,0))) {
			throw new CalculadoraException(CalculadoraException.DIVISION_CERO);
		}
		Complejo c3 = c2.conjugado();
		Complejo numerador = multiplicacion(c1,c3);
		double modulo = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginaria(), 2);
		double real =  (numerador.getReal() / modulo);
		double imaginaria =  (numerador.getImaginaria() / modulo);
		Complejo res = new Complejo(real, imaginaria);
		return res;
	}
	
	/**
	 * Calcula la division de dos numeros complejos
	 * @param c1 el primer numero complejo
	 * @param c2 el segundo numero complejo
	 * @return un numero complejo con la division de complejo1 y complejo2
	 * @throws CalculadoraException cuando el divisor es 0
	 */
	public static Complejo division(Complejo c1, Complejo c2) throws CalculadoraException {
		if (c2.equals(new Complejo(0,0))) {
			throw new CalculadoraException(CalculadoraException.DIVISION_CERO);
		}	
		Complejo c3 = c2.conjugado();
		Complejo numerador = multiplicacion(c1,c3);
		double modulo = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginaria(), 2);
		double real =  (numerador.getReal() / modulo);
		double imaginaria =  (numerador.getImaginaria() / modulo);
		Complejo res = new Complejo(real, imaginaria);
		return res;
	}
	/**
	 * Calcula el modulo de un numero complejo
	 * @param com1 las componentes rectangulares del numero
	 * @return un double con el valor del modulo
	 */
	public static double modulo(int[] com1){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		return c1.getModulo();
	}
	
	/**
	 * Calcula el modulo de un numero complejo
	 * @param c1 el numero complejo
	 * @return un double con el valor del modulo
	 */
	public static double modulo(Complejo c1){
		return c1.getModulo();
	}
	
	/**
	 * Calcula el conjugado de un numero complejo
	 * @param com1 las componentes rectangulares del numero
	 * @return un Complejo con los valores del conjuado
	 */
	public static Complejo conjugado(int[] com1){
		Complejo c1 = new Complejo(com1[0],com1[1]);
		return c1.conjugado();
	}
	
	/**
	 * Calcula el conjugado de un numero complejo
	 * @param c1 el numero complejo
	 * @return un Complejo con los valores del conjuado
	 */
	public static Complejo conjugado(Complejo c1){
		return c1.conjugado();
	}
	
	/**
	 * Calcula las componentes polares de un numero complejo
	 * @param com1 las componentes rectangulares del numero
	 * @return un vector de double con las componentes polares
	 */
	public static double[] recPol(int[] com1) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		double [] pol = new double[2];
		pol[0] =  c1.getModulo();
		pol[1] = c1.getFase();
		return pol;
	}
	
	/**
	 * Calcula las componentes polares de un numero complejo
	 * @param c1 el numero complejo
	 * @return un vector de double con las componentes polares
	 */
	public static double[] recPol(Complejo c1) {
		double [] pol = new double[2];
		pol[0] =  c1.getModulo();
		pol[1] = c1.getFase();
		return pol;
	}
	
	/**
	 * Calcula las componentes rectangulares de un numero complejo
	 * @param com1 las componentes polares del numero
	 * @return un vector de double con las componentes rectangulares
	 */
	public static double[] polRec(int[] com1) {
		Complejo c1 = new Complejo(com1[0],com1[1],0);
		double [] rec = new double[2];
		rec[0] =  c1.getReal();
		rec[1] = c1.getImaginaria();
		return rec;
	}
	
	/**
	 * Calcula las componentes rectangulares de un numero complejo
	 * @param c1 el numero complejo
	 * @return un vector de double con las componentes rectangulares
	 */
	public static double[] polRec(Complejo c1) {
		double [] rec = new double[2];
		rec[0] =  c1.getReal();
		rec[1] = c1.getImaginaria();
		return rec;
	}
	
	/**
	 * Calcula la fase de un numero complejo
	 * @param com1 las componentes polares del numero
	 * @return la fase del numero
	 */
	public static double fase(int[] com1) {
		Complejo c1 = new Complejo(com1[0],com1[1]);
		double fase;
		fase = c1.getFase();
		return fase;
	}
	
	public static Complejo redondear(Complejo complejo) {
		return new Complejo(Math.round(complejo.getReal()),Math.round(complejo.getImaginaria()));
	}
	
}