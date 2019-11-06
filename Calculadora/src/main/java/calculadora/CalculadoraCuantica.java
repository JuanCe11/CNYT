package main.java.calculadora;

public class CalculadoraCuantica {
	
	/**
	 * Calcula la probabilidad de pasar a cualquier estado, dado su estado inicial
	 * @param estadoInicial Estado inicial del sistema
	 * @return la probabilidad de estar en cualquier estado 
	 * @throws CalculadoraException Cuando el estado inicial no es un vector
	 */
	public static double[] calcularProbabilidad(main.java.calculadora.Matriz estadoInicial) throws main.java.calculadora.CalculadoraException {
		if (!estadoInicial.isVector()) {
			throw new main.java.calculadora.CalculadoraException(main.java.calculadora.CalculadoraException.NO_ES_VECTOR);
		}
		double[] probabilidades = new double[estadoInicial.getNumeros().length];
		for (int i = 0; i < estadoInicial.getNumeros().length; i++) {
			probabilidades[i] = Math.pow(estadoInicial.getNumeros()[i][0].getModulo(),2)/Math.pow(CalculadoraMatrices.normaDeUnVector(estadoInicial),2);		
		}		
		return probabilidades;
	}
	
	/**
	 * Dados dos vectores (psi y phi) calcula la probabilidad (amplitud) de llegar de psi a phi
	 * @param psi el estado inicial
	 * @param phi el estado final 
	 * @return la probabilidad de ir de psi a phi 
	 * @throws CalculadoraException cuando los psi o phi no son vectores.
	 */
	public static Complejo calcularAmplitud(Matriz psi,Matriz phi) throws CalculadoraException {
		if (!psi.isVector() || !phi.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		double[] escalarPsi = {(double)1/CalculadoraMatrices.normaDeUnVector(psi),0};
		Matriz psiM = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPsi, psi);
		double[] escalarPhi = {(double)1/CalculadoraMatrices.normaDeUnVector(phi),0};
		psiM = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPhi, psi);
		return CalculadoraMatrices.productoInterno(phi,psiM);
	}
	
	/**
	 * Calcula la probabilidad de que psi colapse en phi 
	 * @param psi primer estado
	 * @param phi segundo estado
	 * @return la probabilidad de que psi colapse en phi 
	 * @throws CalculadoraException cualquier excepcion al calcular el valor esperado al calular la amplitud
	 */
	public static double calcularProbabilidadColapsar(Matriz psi,Matriz phi) throws CalculadoraException {
		Complejo amplitud = calcularAmplitud(psi,phi);
		return Math.pow(amplitud.getModulo(),2);
	}
	
	/**
	 * Calcula el valor esperado partiendo de un observador omega y un estado inicial psi 
	 * @param omega el observable
	 * @param psi el estado inicial 
	 * @return el valor esperado 
	 * @throws CalculadoraException cuando el estado inicial no es un vector u omega no es una matriz hermitania
	 */
	public static Complejo calcularValorEsperado(Matriz omega,Matriz psi) throws CalculadoraException {
		if (!psi.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		if (!CalculadoraMatrices.esHermitania(omega)) {
			throw new CalculadoraException("La matriz no es hermitania");
		}
		return calcular(omega,psi);
	}
	
	/**
	 * Realiza los caluculos del valor esperado suponinendo la validez de sus parametros
	 * @param omega el observable
	 * @param psi el estado inicial 
 	 * @return el valor esperado 
	 * @throws CalculadoraException Excepciones de los caluculos en CalculadoraMatrices
	 */
	public static Complejo calcular(Matriz omega,Matriz psi) throws CalculadoraException {
		double[] escalarPsi = {(double)1/CalculadoraMatrices.normaDeUnVector(psi),0};
		Matriz psiNormalizado = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPsi, psi);
		Matriz res = CalculadoraMatrices.matrizPorMatriz(omega, psiNormalizado);
		return CalculadoraMatrices.productoInterno(res,psiNormalizado);
	}
	
	/**
	 * Calcula el la varianza partiendo de un observador omega y un estado inicial psi 
	 * @param omega el observador
	 * @param psi el estado inicial 
	 * @return la varianza
	 * @throws CalculadoraException cualquier excepcion al calcular el valor esperado
	 */
	public static Complejo calcularVarianza(Matriz omega,Matriz psi) throws CalculadoraException {
		double[] escalarPsi = {(double)1/CalculadoraMatrices.normaDeUnVector(psi),0};
		Matriz psiNormalizado = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPsi, psi);
		Matriz delta = delta(omega,psiNormalizado);
		return calcular(CalculadoraMatrices.matrizPorMatriz(delta, delta),psi);
	}

	private static Matriz delta(Matriz omega, Matriz psi) throws CalculadoraException {
		double[] valorEsperado = {calcularValorEsperado(omega,psi).getReal(),calcularValorEsperado(omega,psi).getImaginaria()};
		double[] menosUno = {-1,0};
		return CalculadoraMatrices.sumaMatriz(omega, CalculadoraMatrices.multiplicacionEscalarMatriz(menosUno,CalculadoraMatrices.multiplicacionEscalarMatriz(valorEsperado, CalculadoraMatrices.identidad(omega))));
	}
	
	/**
	 * Calcula el la varianza partiendo de un observador omega y un estado inicial psi 
	 * @param omega el observador
	 * @param psi el estado inicial 
	 * @return la varianza
	 * @throws CalculadoraException cualquier excepcion al calcular el valor esperado
	 */
	public static double[] esferaBloch(Matriz ket) throws CalculadoraException {
		if (!ket.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		double primeraComponente = ket.getNumeros()[0][0].getModulo();
		double primerExponente = ket.getNumeros()[0][0].getFase();
		double segundaComponente = ket.getNumeros()[1][0].getModulo();
		double segundoExponente = ket.getNumeros()[0][1].getFase();
		double angulo = Math.toDegrees(Math.acos(primeraComponente));
		double angulo2 = Math.toDegrees(Math.asin(segundaComponente));
		System.out.println(angulo);
		System.out.println(angulo2);
		return null;
	}
	
}
