package calculadora;


public class CalculadoraMatrices{
	
	/**
	 * Suma dos vectores
	 * @param m1 el primer vector
	 * @param m2 el segundo vector
	 * @return una matriz que contiene la suma de los dos vectores
	 * @throws CalculadoraException cuando es imposible sumar los vectores por dimensiones 
	 */
	public static Matriz sumaVectores(Matriz m1, Matriz m2) throws CalculadoraException {
		if(m1.getNumeros().length!=m2.getNumeros().length || m1.getNumeros()[0].length!=m2.getNumeros()[0].length ) {
			throw new CalculadoraException(CalculadoraException.SUMA_MATRICES);
		}
		if (!m1.isVector() && !m2.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length];
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				respuesta[i][j] = Calculadora.suma(m1.getNumeros()[i][j], m2.getNumeros()[i][j]);
			}
		}
		return new Matriz(respuesta);
	}
	/**
	 * Da la inversa de un vector
	 * @param m1 el vector
	 * @return un vector con la inversa de m1
	 * @throws CalculadoraException cuando la matriz ingresada no es un vector
	 */
	public static Matriz inversaVectores(Matriz m1) throws CalculadoraException{
		if (!m1.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(-1,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	/**
	 * Multiplica un vector por un escalar
	 * @param escalar escalar a mutiplicar
	 * @param m1 el vector para multiplicar
	 * @return un vector con el resltado del escalar por el vector
	 * @throws CalculadoraException cuando la matriz ingresada no es un vector
	 */
	public static Matriz multiplicacionEscalarVector(double[] escalar,Matriz m1) throws CalculadoraException{
		if (!m1.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar[0],escalar[1]),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
	/**
	 * Suma dos matrices
	 * @param m1 matriz a sumar
	 * @param m2 matriz a sumar
	 * @return una matriz con el resultado de m1 + m2
	 * @throws CalculadoraException cuando es imposible sumar las martices por as dimensiones 
	 */
	public static Matriz sumaMatriz(Matriz m1, Matriz m2) throws CalculadoraException {
		if(m1.getNumeros().length!=m2.getNumeros().length || m1.getNumeros()[0].length!=m2.getNumeros()[0].length ) {
			throw new CalculadoraException(CalculadoraException.SUMA_MATRICES);
		}
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length];
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				respuesta[i][j] = Calculadora.suma(m1.getNumeros()[i][j], m2.getNumeros()[i][j]);
			}
		}
		return new Matriz(respuesta);
	}
	
	/**
	 * Da la inversa de una matriz
	 * @param m1 la matriz
	 * @return un matriz con la inversa de m1
	 */
	public static Matriz inversaMatriz(Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(-1,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	/**
	 * Multiplica una matriz por un escalar
	 * @param escalar escalar a mutiplicar
	 * @param m1 la matriz para multiplicar
	 * @return una matriz con el resltado del escalar por la matriz
	 */
	public static Matriz multiplicacionEscalarMatriz(double[] escalar,Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar[0],escalar[1]),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
	/**
	 * Da a matriz transpuesta de m1 
	 * @param m1 la matriz a transponer 
	 * @return una matriz con el resultado de transponer m1
	 */
	public static Matriz matrizTranspuesta(Matriz m1){
		Complejo respuesta[][] = new Complejo[m1.getNumeros()[0].length][m1.getNumeros().length]; 
		for (int i = 0; i < m1.getNumeros()[0].length; i++) {
			for (int j = 0; j < m1.getNumeros().length; j++) {
				respuesta[i][j] = m1.getNumeros()[j][i];
			}
		}
		Matriz respuestaM = new Matriz(respuesta);
		return respuestaM;
	}	
	
	/**
	 * Da a matriz conjugada de m1 
	 * @param m1 la matriz a conjugar 
	 * @return una matriz con el resultado de conjugar m1
	 */
	public static Matriz matrizConjugada(Matriz m1){
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length]; 
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				respuesta[i][j] = Calculadora.conjugado(m1.getNumeros()[i][j]);
			}
		}
		return new Matriz(respuesta);
	}	
	
	/**
	 * Da a matriz adjunta de m1 
	 * @param m1 la matriz  
	 * @return una matriz con el resultado de sacar la daga de m1
	 */
	public static Matriz matrizAdjunta(Matriz m1){
		return matrizTranspuesta(matrizConjugada(m1));
	}
	
	/**
	 * Calcula la accion de una matriz sobre un vector 
	 * @param m1 la matriz 
	 * @param m2 el vector 
	 * @return Una matriz con el resultado de mutiplicar la matriz por el vector
	 * @throws CalculadoraException cuando m2 no es un vector o es imposible multiplicar por dimensiones 
	 */
	public static Matriz matrizPorVector(Matriz m1, Matriz m2) throws CalculadoraException {
		if(m1.getNumeros()[0].length != m2.getNumeros().length) {
			throw new CalculadoraException(CalculadoraException.SUMA_MATRICES);
		}
		if(m2.getNumeros()[0].length != 1) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		Complejo[][] respuesta = new Complejo[m1.getNumeros().length][1];
		for (int i = 0; i < m1.getNumeros().length; i++) {
			Complejo suma = new Complejo(0,0); 
			for (int j = 0; j < m2.getNumeros().length; j++) {
				suma = Calculadora.suma(Calculadora.multiplicacion(m1.getNumeros()[i][j], m2.getNumeros()[j][0]),suma);
			}
			respuesta[i][0] = suma;
		}
		return new Matriz(respuesta);
	}
	
	/**
	 * Calcula el producto interno entre dos matrices
	 * @param m1 la primera matriz
	 * @param m2 la segunda matriz
	 * @return Un complejo con el resultado del producto interno 
	 * @throws CalculadoraException excepciones de la multiplicacion de matrices.
	 */
	public static Complejo productoInterno(Matriz m1, Matriz m2) throws CalculadoraException {
		return CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.matrizAdjunta(m1),m2).getNumeros()[0][0];
	}
	
	/**
	 * Calcula la norma de un vector 
	 * @param m1 el vector 
	 * @return un double con el resultado de la norma del vector
	 * @throws CalculadoraException excepciones del producto interno 
	 */
	public static double normaDeUnVector(Matriz m1) throws CalculadoraException {
		return Math.sqrt(CalculadoraMatrices.productoInterno(m1, m1).getReal());
	}
	
	/**
	 * Calcula la dstancia entre dos vectores
	 * @param m1 el primer vector 
	 * @param m2 el segundo vector 
	 * @return un double con la respuesta de la distanca entre los vectores
	 * @throws CalculadoraException excepciones de calcular la norma, la suma de los vectores y el inverso del vector.
	 */
	public static double distanciaEntreVectores(Matriz m1,Matriz m2) throws CalculadoraException {
		return CalculadoraMatrices.normaDeUnVector(CalculadoraMatrices.sumaVectores(m1, CalculadoraMatrices.inversaVectores(m2)));
	}
	
	/**
	 * Multiplica dos matrices 
	 * @param m1 la primera matriz
	 * @param m2 la segunda matriz
	 * @return una matriz con el resultado de mutiplicar las matrices
	 * @throws CalculadoraException cuando es imposible multipicar las matrices por dimensiones 
	 */
	public static Matriz matrizPorMatriz(Matriz m1, Matriz m2) throws CalculadoraException {
		if(m1.getNumeros()[0].length != m2.getNumeros().length) {
			throw new CalculadoraException(CalculadoraException.SUMA_MATRICES);
		}
		Complejo[][] respuesta = new Complejo[m1.getNumeros().length][m2.getNumeros()[0].length];
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for(int k = 0; k < m2.getNumeros()[0].length; k++){
				Complejo suma = new Complejo(0,0);
				for (int j = 0; j < m2.getNumeros().length; j++) {
					suma = Calculadora.suma(Calculadora.multiplicacion(m1.getNumeros()[i][j], m2.getNumeros()[j][k]),suma);
				}
				respuesta[i][k] = suma;
			}
		}
		return new Matriz(respuesta);
	}
	
	/**
	 * Dice si una matriz es Hermitania 
	 * @param m la matriz
	 * @return si la matriz es hermitania o no 
	 */
	public static boolean esHermitania(Matriz m) {
		return m.equals(CalculadoraMatrices.matrizAdjunta(m));
	}
	
	/**
	 * Calcula la matriz identidad de una matriz
	 * @param m la matriz
	 * @return la identidad de esa matriz
	 * @throws CalculadoraException Cuando la matriz dada no es cuadrada
	 */
	public static Matriz identidad(Matriz m) throws CalculadoraException {
		if(m.getNumeros().length != m.getNumeros()[0].length) {
			throw new CalculadoraException(CalculadoraException.NO_ES_CUADRADA);
		}
		Complejo identidad[][] = new Complejo[m.getNumeros().length][m.getNumeros()[0].length];
		for (int i = 0; i < identidad.length; i++) {
			for (int j = 0; j < identidad[0].length; j++) {
				if (i==j) {
					identidad[i][j] = new Complejo(1,0);
				}else {
					identidad[i][j] = new Complejo(0,0);
				}
			}
		}
		return new Matriz(identidad);
	}
	
	/**
	 * Redondea los valores de una matriz
	 * @param m la matriz a redondear
	 * @return una matriz con sus valores redondeados
	 */
	private static Matriz redondear(Matriz m) {
		Complejo redondear[][] = new Complejo[m.getNumeros().length][m.getNumeros()[0].length];
		for (int i = 0; i < redondear.length; i++) {
			for (int j = 0; j < redondear[0].length; j++) {
				redondear[i][j] = Calculadora.redondear(m.getNumeros()[i][j]);
			}
		}
		return new Matriz(redondear);
	}
	
	/**
	 * Dice si una matriz es unitaria 
	 * @param m la matriz
	 * @return si la matriz es unitaria o no 
	 * @throws CalculadoraException excepciones de la multiplicacion de matrices y de la identidad.
	 */
	public static boolean esUnitaria(Matriz m) throws CalculadoraException {
		return CalculadoraMatrices.redondear(CalculadoraMatrices.matrizPorMatriz(m, CalculadoraMatrices.matrizAdjunta(m))).equals(CalculadoraMatrices.identidad(m));
	}
	
	/**
	 * Calcula el producto tensorial de dos matrices
	 * @param m la primera matriz
	 * @param m2 la segunda matriz
	 * @return Una matriz con el resutado de producto tensorial entre as matrices.
	 */
	public static Matriz productoTensorial(Matriz m,Matriz m2) {
		Complejo[][] respuesta = new Complejo[m.getNumeros().length * m2.getNumeros().length][m.getNumeros()[0].length * m2.getNumeros()[0].length];
		int p = m2.getNumeros().length;
		int q = m2.getNumeros()[0].length;
		for (int i = 0; i < respuesta.length; i++) {
			for (int j = 0; j < respuesta[0].length; j++) {
				respuesta[i][j] = Calculadora.multiplicacion(m.getNumeros()[i/p][j/q],m2.getNumeros()[i%p][j%q]);
			}	
		}
		return new Matriz(respuesta);
	}
	/**
	 * Da el moduo al cuadrado de una matriz
	 * @param m la matriz
	 * @return el moduo al cuadrado de una matriz
	 */
	public static Matriz moduloAlCuadrado(Matriz m) {
		Matriz nueva = new Matriz(m.getNumeros());
		for (int i = 0; i < m.getNumeros().length; i++) {
			for (int j = 0; j < m.getNumeros()[0].length; j++) {
				double modulo = Math.pow(m.getNumeros()[i][j].getReal(),2)+Math.pow(m.getNumeros()[i][j].getImaginaria(),2);
				nueva.getNumeros()[i][j] = new Complejo(modulo,0);
			}
		}
		return nueva;
	}

	/**
	 * Calcula la potencia de una matriz
	 * @param matriz la matriz a mutiplicar
	 * @param potencia exponente al que se multiplica la matriz
	 * @return una matriz con el resultado de la potencia
	 * @throws CalculadoraException excepciones en el calculo de la multiplicacion
	 */
	private static Matriz calcularPotencia(Matriz matriz, int potencia) throws CalculadoraException {
		Matriz potenciaM = matriz;
		for (int i = 0; i < potencia; i++) {
			potenciaM = CalculadoraMatrices.matrizPorMatriz(potenciaM, potenciaM);
		}
		return matriz;
	}
}