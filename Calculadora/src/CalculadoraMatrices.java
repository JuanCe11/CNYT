

public class CalculadoraMatrices {
	
	/**
	 * Suma dos matrices
	 * @param m1 la primera matriz
	 * @param m2 la segunda matriz
	 * @return una matriz que contiene la suma de las dos matrices
	 * @throws CalculadoraException cuando es imposible sumar las matrices por dimensiones 
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
	
	public static Matriz multiplicacionEscalarVector(double escalar,Matriz m1) throws CalculadoraException{
		if (!m1.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
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
	
	public static Matriz inversaMatriz(Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(-1,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
	public static Matriz multiplicacionEscalarMatriz(double[] escalar,Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar[0],escalar[1]),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
	public static Matriz multiplicacionEscalarMatriz(double escalar,Matriz m1){
		
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}	
	
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
	
	public static Matriz matrizConjugada(Matriz m1){
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length]; 
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; j++) {
				respuesta[i][j] = Calculadora.conjugado(m1.getNumeros()[i][j]);
			}
		}
		return new Matriz(respuesta);
	}	
	
	public static Matriz matrizAdjunta(Matriz m1){
		return matrizTranspuesta(matrizConjugada(m1));
	}
	
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
	
	public static Complejo productoInterno(Matriz m1, Matriz m2) throws CalculadoraException {
		return CalculadoraMatrices.matrizPorMatriz(CalculadoraMatrices.matrizAdjunta(m1),m2).getNumeros()[0][0];
	}
	
	public static double normaDeUnVector(Matriz m1) throws CalculadoraException {
		return Math.sqrt(CalculadoraMatrices.productoInterno(m1, m1).getReal());
	}
	
	public static double distanciaEntreVectores(Matriz m1,Matriz m2) throws CalculadoraException {
		return CalculadoraMatrices.normaDeUnVector(CalculadoraMatrices.sumaVectores(m1, CalculadoraMatrices.inversaVectores(m2)));
	}
	
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
	
	public static boolean esHermitania(Matriz m) {
		return m.equals(CalculadoraMatrices.matrizAdjunta(m));
	}
	
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
	
	private static Matriz redondear(Matriz m) {
		Complejo redondear[][] = new Complejo[m.getNumeros().length][m.getNumeros()[0].length];
		for (int i = 0; i < redondear.length; i++) {
			for (int j = 0; j < redondear[0].length; j++) {
				redondear[i][j] = Calculadora.redondear(m.getNumeros()[i][j]);
			}
		}
		return new Matriz(redondear);
	}
	
	public static boolean esUnitaria(Matriz m) throws CalculadoraException {
		return CalculadoraMatrices.redondear(CalculadoraMatrices.matrizPorMatriz(m, CalculadoraMatrices.matrizAdjunta(m))).equals(CalculadoraMatrices.identidad(m));
	}
	
	public static Matriz productoTensorial(Matriz m,Matriz m2) {
		Complejo[][] respuesta = new Complejo[m.getNumeros().length * m2.getNumeros().length][m.getNumeros()[0].length * m2.getNumeros()[0].length];
		int p = m2.getNumeros().length,q = m2.getNumeros()[0].length;
		for (int i = 0; i < respuesta.length; i++) {
			for (int j = 0; j < respuesta[0].length; j++) {
				respuesta[i][j] = Calculadora.multiplicacion(m.getNumeros()[i/p][j/q],m2.getNumeros()[i%p][j%q]);
			}	
		}
		return new Matriz(respuesta);
	}
}