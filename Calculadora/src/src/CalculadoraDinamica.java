package src;

public class CalculadoraDinamica {
	
	/**
	 * Calcula el estado del sistema a partir de la matriz dinamica, un estado inicial y la cantidad de estados 
	 * @param m1 matriz dinamica
	 * @param estadoInicial estado inicial del sistema
	 * @param clicks cantidad de estados a avanzar
	 * @return Una matriz con el estado final del sistema
	 * @throws CalculadoraException cuando el estado inicial no es un vector o que la matriz del sistema sea invalida.
	 */
	public static Matriz sistemaDinamicoDeterminista(Matriz m1, Matriz estadoInicial, int clicks) throws CalculadoraException {
		if(estadoInicial.getNumeros()[0].length!=1) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		if(!validarDeterminista(m1)) {
			throw new CalculadoraException(CalculadoraException.MATRIZ_INVALIDA);
		}
		for (int i = 0; i < clicks; i++) {
			try {
				estadoInicial = CalculadoraMatrices.matrizPorVector(m1, estadoInicial);
			} catch (CalculadoraException e) {
				e.printStackTrace();
			}			
		}
		return estadoInicial;
	}
	

	/**
	 * Valida que la matriz del sistema cumpla con la de un sistema determinista
	 * @param m1 la matriz a validar
	 * @return si es una matriz valida para un sisema determinista 
	 */
	private static boolean validarDeterminista(Matriz m1) {
		boolean valida = true;
		Complejo zero = new Complejo(0,0), uno = new  Complejo(1.0,0);
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				valida = (!m1.getNumeros()[i][j].equals(zero) && !m1.getNumeros()[i][j].equals(uno))?false:valida;
			}
		}
		return valida;
	}


	/**
	 * Calcula el estado del sistema ensamblado a partir de las matrices dinamicas, un estado inicial y la cantidad de estados 
	 * @param m1 primera matriz dinamica
	 * @param m2 segunda matriz dinamica
	 * @param estadoInicial estado inicial del sistema
	 * @param clicks cantidad de estados para avanzar
	 * @return Una matriz con el estado final del sistema
	 * @throws CalculadoraException cuando el estado inicial no es un vector o que la matriz del sistema sea invalida.
	 */
	public static Matriz sistemaDinamicoDeterministaconEnsamble(Matriz m1, Matriz m2,Matriz estadoInicial, int clicks) throws CalculadoraException {
		if(estadoInicial.getNumeros()[0].length!=1) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		Matriz ensamble = CalculadoraMatrices.productoTensorial(m1, m2);
		for (int i = 0; i < clicks; i++) {
			try {
				estadoInicial = CalculadoraMatrices.matrizPorVector(ensamble, estadoInicial);
			} catch (CalculadoraException e) {
				e.printStackTrace();
			}			
		}
		return estadoInicial;
	}

}