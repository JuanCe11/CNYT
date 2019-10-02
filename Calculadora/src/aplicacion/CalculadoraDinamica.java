package aplicacion;

public class CalculadoraDinamica {
	
	/**
	 * Calcula es estado del sistema partendo del tipo de sistema, la matriz del sistema, el estado incial y el numero de clicks
	 * @param tipoDinamica 0 para clasica, 1 para probabilistico y 2 para cuantico 
	 * @param dinamica la matriz dinamica del sistema 
	 * @param estadoInicial el estado incial del sistema 
	 * @param clicks cantidad de estados a avanzar
	 * @return una Respuesta que contiene la validacion de la matriz, la matriz potencia del sistema y el estado final del sistema 
	 * @throws CalculadoraException cualquier excepcion en los calculos del estado final
	 */
	public static Respuesta calcularEstado(int tipoDinamica,Matriz dinamica, Matriz estadoInicial, int clicks) throws CalculadoraException {
		if (tipoDinamica < 0 || tipoDinamica>2) {
			throw new CalculadoraException(CalculadoraException.TIPO_INVALIDO);
		}
		return new Respuesta(validarMatriz(dinamica,tipoDinamica),calcularPotencia(dinamica,clicks),calcularEstadoFinal(dinamica,estadoInicial,clicks));
	}
	
	/**
	 * Valida si una matriz dinamica esta bien para si tipo 
	 * @param dinamica la matriz dinamica del sistema 
	 * @param tipoDinamica  0 para clasica, 1 para probabilistico y 2 para cuantico 
	 * @return si la matriz es valida para su tipo 
	 * @throws CalculadoraException excepciones en la verificacion de unitaria. 
	 */
	private static boolean validarMatriz(Matriz dinamica, int tipoDinamica) throws CalculadoraException {
		boolean respuesta = false;
		switch(tipoDinamica) {
			case 0: respuesta = validarClasico(dinamica);
					break;
			case 1: respuesta = validarProbabilistico(dinamica);
					break;
			case 2: respuesta = validarCuantico(dinamica);
					break;
			default: break; 			
		}
		return respuesta;
	}
	
	/**
	 * Valida que la matriz del sistema cumpla con la de un sistema determinista
	 * @param m1 la matriz a validar
	 * @return si es una matriz valida para un sisema determinista 
	 */
	private static boolean validarClasico(Matriz m1) {
		boolean valida = true;
		Complejo zero = new Complejo(0,0), uno = new  Complejo(1.0,0);
		int cantidadUnos ; 
		for (int i = 0; i < m1.getNumeros()[0].length; i++) {
			cantidadUnos = 0;
			for (int j = 0; j < m1.getNumeros().length; j++) {
				valida = (!m1.getNumeros()[j][i].equals(zero) && !m1.getNumeros()[j][i].equals(uno))?false:valida;
				cantidadUnos = (m1.getNumeros()[j][i].equals(uno))?cantidadUnos+1:cantidadUnos;
			}
			valida = (cantidadUnos>1)?false:valida;
		}
		return valida;
	}
	
	/**
	 * Valida que la matriz del sistema cumpla con la de un sistema determinista
	 * @param m1 la matriz a validar
	 * @return si es una matriz valida para un sisema determinista 
	 */
	private static boolean validarProbabilistico(Matriz m1) {
		boolean valida = true;
		Complejo suma, uno = new  Complejo(1.0,0);
		for (int i = 0; i < m1.getNumeros().length; i++) {
			suma = new Complejo(0,0);
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				suma = Calculadora.suma(suma, m1.getNumeros()[i][j]);
			}
			valida = (!suma.equals(uno))?false:valida;
		}
		for (int i = 0; i < m1.getNumeros()[0].length; i++) {
			suma = new Complejo(0,0);
			for (int j = 0; j < m1.getNumeros().length; j++) {
				suma = Calculadora.suma(suma, m1.getNumeros()[j][i]);
			}
			valida = (!suma.equals(uno))?false:valida;
		}
		return valida;
	}
	
	/**
	 * Valida que la matriz del sistema cumpla con la de un sistema determinista
	 * @param m1 la matriz a validar
	 * @return si es una matriz valida para un sisema determinista 
	 * @throws CalculadoraException 
	 */
	private static boolean validarCuantico(Matriz m1) throws CalculadoraException {
		return CalculadoraMatrices.esUnitaria(m1);
	}
	
	/**
	 * Calcula la potencia de una matriz dinamica
	 * @param dinamica la matriz dinamica del sistema 
	 * @param potencia exponente al que se multiplica la matriz
	 * @return una matriz ocn el resultado de la potencia 
	 * @throws CalculadoraException excepciones en el calculo de la multiplicacion
	 */
	private static Matriz calcularPotencia(Matriz dinamica, int potencia) throws CalculadoraException {
		for (int i = 0; i < potencia; i++) {
			dinamica = CalculadoraMatrices.matrizPorMatriz(dinamica, dinamica);
		}
		return dinamica;
	} 
	
	/**
	 * Calcula el estado del sistema a partir de la matriz dinamica, un estado inicial y la cantidad de estados 
	 * @param m1 matriz dinamica
	 * @param estadoInicial estado inicial del sistema
	 * @param clicks cantidad de estados a avanzar
	 * @return Una matriz con el estado final del sistema
	 * @throws CalculadoraException cuando el estado inicial no es un vector
	 */
	public static Matriz calcularEstadoFinal(Matriz m1, Matriz estadoInicial, int clicks) throws CalculadoraException {
		if(estadoInicial.getNumeros()[0].length!=1) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
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
	 * Calcula el estado del sistema a partir de la matriz dinamica, un estado inicial y la cantidad de estados 
	 * @param m1 matriz dinamica
	 * @param estadoInicial estado inicial del sistema
	 * @param clicks cantidad de estados a avanzar
	 * @return Una matriz con el estado final del sistema
	 * @throws CalculadoraException cuando el estado inicial no es un vector o que la matriz del sistema sea invalida.
	 */
	public static Matriz sistemaDinamicoDeterminista(Matriz m1, Matriz estadoInicial, int clicks) throws CalculadoraException {
		if(!validarClasico(m1)) {
			throw new CalculadoraException(CalculadoraException.MATRIZ_INVALIDA);
		}
		return calcularEstadoFinal(m1, estadoInicial, clicks);
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
	public static Matriz sistemaDinamicoconEnsamble(Matriz m1, Matriz m2,Matriz estadoInicial, int clicks) throws CalculadoraException {
		if (m1.getNumeros().length != m1.getNumeros()[0].length||m2.getNumeros().length != m2.getNumeros()[0].length) {
			throw new CalculadoraException(CalculadoraException.NO_ES_CUADRADA);		
		}
		Matriz ensamble = CalculadoraMatrices.productoTensorial(m1, m2);
		if (estadoInicial.getNumeros().length != ensamble.getNumeros().length) {
			throw new CalculadoraException(CalculadoraException.IMPOSIBLE_CALCULAR+"Estado inicial no corresponde al sistema.");
		}
		return calcularEstadoFinal(ensamble, estadoInicial, clicks);
	}
	
	/**
	 * Calcula el estado del sistema ensamblado a partir de las matrices dinamicas, los estados iniciales de los sistemas y la cantidad de estados 
	 * @param m1 primera matriz dinamica
	 * @param m2 segunda matriz dinamica
	 * @param estadoInicial1 estado inicial del sistema 1
	 * @param estadoInicial2 estado inicial del sistema 2
	 * @param clicks cantidad de estados para avanzar
	 * @return Una matriz con el estado final del sistema
	 * @throws CalculadoraException Caundo los estados no corresponden a las matrices y todas las excepciones de calcular los estados 
	 */
	public static Matriz sistemaDinamicoconEnsamble(Matriz m1, Matriz m2,Matriz estadoInicial1,Matriz estadoInicial2, int clicks) throws CalculadoraException {
		if(estadoInicial1.getNumeros().length != m1.getNumeros().length||estadoInicial2.getNumeros().length != m2.getNumeros().length) {
			throw new CalculadoraException(CalculadoraException.IMPOSIBLE_CALCULAR+"Estado inicial no corresponde al sistema.");
		}
		return sistemaDinamicoconEnsamble(m1,m2,CalculadoraMatrices.productoTensorial(estadoInicial1, estadoInicial2), clicks);
	}
	
	/**
	 * Da una respuesta con la potencia de la matriz y el estado final del sistema despues de un click 
	 * @param rendijas cantidad de rendijas en el sistema 
	 * @param blancosPared blancos que hay detras de cada pared 
	 * @param probabilidades vector con las probabilidades de llegar a los blancos
	 * @return la potencia de la matriz y el estado final del sistema despues de un click 
	 * @throws CalculadoraException cualquier excepcion en los calculos del estado final
	 */
	public static Respuesta experimentoRendijas(int rendijas, int blancosPared,double[][] probabilidades) throws CalculadoraException {
		Matriz dinamica = new Matriz(valoresBlancos(quedarseEnBlanco(valoresRendijas(mapACero(new Complejo[rendijas*2 + blancosPared*(rendijas+1)+1][rendijas*2 + blancosPared*(rendijas+1)+1]),rendijas),rendijas),probabilidades,rendijas,blancosPared));
		return new Respuesta(true,calcularPotencia(dinamica,1),convertirCuanticoaProbabilistico(calcularEstadoFinal(dinamica,estadoInicial(rendijas*2 + blancosPared*(rendijas+1)+1),2)));	
	}
	
	private static Matriz convertirCuanticoaProbabilistico(Matriz estadoFinal) {
		Complejo[][] probabilidades = new Complejo[estadoFinal.getNumeros().length][1];
		for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
			probabilidades[i][0] = new Complejo(Math.pow(estadoFinal.getNumeros()[i][0].getModulo(),2),0);
		}
		return new Matriz(probabilidades);
	}

	/**
	 * Da el estado inicial del sistema dependidendo de la longitud de la matriz del sistema 
	 * @param logitud la longitud de la matriz del sistema 
	 * @return el estado inicial del sistema
	 */
	private static Matriz estadoInicial(int logitud) {
		Complejo[][] estadoInicial = mapACero(new Complejo[logitud][1]);
		estadoInicial[0][0] = new Complejo(1,0);
		return new Matriz(estadoInicial);
	}
	
	/**
	 * Asigna los valores de probabilidad de quedarse en el banco.
	 * @param dinamica el arreglo de la matriz del sistema
	 * @param rendijas cantidad de rendijas en el sistema 
	 * @returnel arreglo con los valores de la probabilidad de quedarse en el banco.
	 */
	private static Complejo[][] quedarseEnBlanco(Complejo[][] dinamica,int rendijas) {
		for (int i = rendijas+1; i < dinamica.length; i++) {
			dinamica[i][i] = new Complejo(1,0);
		}
		return dinamica;
	}
	
	
	/**
	 * Asigna los valores de la probabilidad de las rendijas a los blancos
	 * @param dinamica el arreglo de la matriz del sistema
	 * @param probabilidades vector con las probabilidades de llegar a los blancos
	 * @param rendijas cantidad de rendijas en el sistema 
	 * @param blancosPared blancos que hay detras de cada pared 
	 * @return el arreglo con los valores de la probabilidad de las rendijas a los blancos
	 */
	private static Complejo[][] valoresBlancos(Complejo[][] dinamica, double[][] probabilidades,int rendijas,int blancosPared) {
		int posicion = rendijas+1,blancosPorRendija = blancosPared*2 + 1,probabilidad = 0;
		for (int i = 0; i < rendijas; i++) {
			for (int j = 0; j < blancosPorRendija  ; j++) {
				dinamica[posicion][i+1] = new Complejo(probabilidades[probabilidad][0],probabilidades[probabilidad][1]);
				probabilidad++;
				posicion++;
			}			
			probabilidad = 0;
			posicion -= blancosPared;
		}
		return dinamica;
	}
	
	/**
	 * Asigna los valores de la probabilidad a las rendijas
	 * @param dinamica el arreglo de la matriz del sistema
	 * @param rendijas cantidad de rendijas del sistema 
	 * @return el arreglo con los valores de la probabilidad a las rendijas
	 */
	private static Complejo[][] valoresRendijas(Complejo[][] dinamica,int rendijas) {
		for (int i = 0; i < rendijas; i++) {
			dinamica[i+1][0] = new Complejo((double)1/Math.sqrt(rendijas),0); 			
		}
		return dinamica;
	}

	/**
	 * Asigna una arrego de complejos el valor 0  
	 * @param dinamica arreglo de complejos a dar valores
	 * @return el arreglo con los valores en 0
	 */
	private static Complejo[][] mapACero(Complejo[][] dinamica) {
		for (int i = 0; i < dinamica.length; i++) {
			for (int j = 0; j < dinamica[0].length; j++) {
				dinamica[i][j] = new Complejo(0,0);
			}
		}
		return dinamica;
	}
}