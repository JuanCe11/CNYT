
public class CalculadoraMatrices {
	
	/**
	 * Calcula la fase de un numero complejo
	 * @param com1 el numero complejo
	 * @return la fase del numero
	 */
	public static double fase(Complejo c1) {
		return c1.getFase();
	}
	
	public Matriz sumaMatriz(Matriz m1, Matriz m2) throws CalculadoraException {
		if(m1.getNumeros().length!=m2.getNumeros().length || m1.getNumeros()[0].length!=m2.getNumeros()[0].length ) {
			throw new CalculadoraException(CalculadoraException.SUMA_MATRICES);
		}
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length]; 
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; i++) {
				respuesta[i][j] = Calculadora.suma(m1.getNumeros()[i][j], m2.getNumeros()[i][j]);
			}
		}
		return new Matriz(respuesta);
	}
	
	public Matriz inversaVectores(Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; i++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(-1,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}
	
	public Matriz multiplicacionEscalarVector(double escalar,Matriz m1){
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; i++) {
				m1.getNumeros()[i][j] = Calculadora.multiplicacion(new Complejo(escalar,0),m1.getNumeros()[i][j]);
			}
		}
		return m1;
	}	
	
	public Matriz matrizTranspuesta(Matriz m1){
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length]; 
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; i++) {
				respuesta[i][j] = m1.getNumeros()[j][i];
			}
		}
		return m1;
	}	
	
	public Matriz matrizConjugada(Matriz m1){
		Complejo respuesta[][] = new Complejo[m1.getNumeros().length][m1.getNumeros()[0].length]; 
		for (int i = 0; i < m1.getNumeros().length; i++) {
			for (int j = 0; j < m1.getNumeros()[0].length; i++) {
				respuesta[i][j] = Calculadora.conjugado(m1.getNumeros()[j][i]);
			}
		}
		return m1;
	}	
	
	public Matriz matrizAdjunta(Matriz m1){
		return matrizTranspuesta(matrizConjugada(m1));
	}	
	

}
