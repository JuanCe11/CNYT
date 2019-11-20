package calculadora;
import java.util.Arrays;

public class Matriz {
	private Complejo[][] numeros;
	
	/**
	 * Crea la matriz partiendo del numero de filas, columnas y un arreglo de los numeros complejos.
	 * @param filas de la matriz
	 * @param columnas de la matriz
	 * @param numeros de la matriz
	 * @throws CalculadoraException cuando la cantidad de numeros no llena la matriz 
	 */
	public Matriz(int filas, int columnas,Complejo[] numeros) throws CalculadoraException{
		if(numeros.length < filas*columnas) {
			throw new CalculadoraException(CalculadoraException.FALTAN_NUMEROS);
		}
		this.numeros = new Complejo[filas][columnas];
		addNumeros(numeros);
	}
	
	/**
	 * Crea una matriz dado un arreglo de numeros complejos
	 * @param numeros complejos de la matriz
	 */
	public Matriz(Complejo[][] numeros){
		this.numeros = numeros;
	}
	
	/**
	 * Crea una matriz partiendo del numero de filas, columnas y un arreglo de los numeros en coordenadas.
	 * @param filas de la matriz
	 * @param columnas de la matriz
	 * @param numeros de la matriz
	 * @throws CalculadoraException cuando la cantidad de numeros no llena la matriz 
	 */
	public Matriz(int filas, int columnas,double[][] numeros) throws CalculadoraException{
		if(numeros.length < filas*columnas) {
			throw new CalculadoraException(CalculadoraException.FALTAN_NUMEROS);
		}
		this.numeros = new Complejo[filas][columnas];
		addNumeros(crearComplejos(numeros));
	}

	/**
	 * A�ade los numeros a la matriz
	 * @param numeros numeros para a�adir
	 */
	private void addNumeros(Complejo[] numeros) {
		int contador = 0;
		for (int i  = 0; i < this.numeros.length;i++) {
			for (int j  = 0; j < this.numeros[0].length;j++) {
				this.numeros[i][j] = numeros[contador];
				contador++;
			}
		}
	}
	
	/**
	 * Crea un arreglo de complejos dados sus partes reales e imaginarias 
	 * @param numeros las partes reales e imaginarias de los numeros
	 * @return el arrego de los numeros complejos .
	 */
	private Complejo[] crearComplejos(double[][] numeros) {
		Complejo[] complejos = new Complejo[numeros.length];
		for (int i  = 0; i < numeros.length;i++) {
			complejos[i] = new Complejo(numeros[i][0],numeros[i][1]);
		}
		return complejos;
	}
	
	/**
	 * Da los numeros de la matriz 
	 * @return un arreglo de los numero que tiene la matriz
	 */
	public Complejo[][] getNumeros(){
		return numeros;
	}
	
	/**
	 * Dice si la matriz es un vector 
	 * @return si la matriz es un vector
	 */
	public boolean isVector() {
		return numeros.length == 1 || numeros[0].length == 1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(numeros);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matriz other = (Matriz) obj;
		if (!Arrays.deepEquals(numeros, other.numeros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s  = "";
		for (int i  = 0; i < this.numeros.length;i++) {
			for (int j  = 0; j < this.numeros[0].length;j++) {
				s += this.numeros[i][j].toString() + " ";
			}
			s += "\n";
		}
		return s;
	}
}