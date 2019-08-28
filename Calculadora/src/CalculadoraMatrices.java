
public class CalculadoraMatrices {
	
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
		Matriz respuestaM = new Matriz(respuesta);
		return respuestaM;
	}	
	
	public static Matriz matrizAdjunta(Matriz m1){
		return matrizTranspuesta(matrizConjugada(m1));
	}	
	

}
