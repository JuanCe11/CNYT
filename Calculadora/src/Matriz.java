import java.util.Arrays;

public class Matriz {
	private Complejo[][] numeros;
	
	public Matriz(int filas, int columnas,Complejo[] numeros){
		this.numeros = new Complejo[filas][columnas];
		añadirNumeros(numeros);
	}
	
	public Matriz(Complejo[][] numeros){
		this.numeros = numeros;
	}
	
	public Matriz(int filas, int columnas,int[][] numeros){
		this.numeros = new Complejo[filas][columnas];
		añadirNumeros(crearComplejos(numeros));
	}

	private void añadirNumeros(Complejo[] numeros) {
		int contador = 0;
		for (int i  = 0; i < this.numeros.length;i++) {
			for (int j  = 0; j < this.numeros[0].length;j++) {
				this.numeros[i][j] = numeros[contador];
				contador++;
			}
		}
	}
	
	private Complejo[] crearComplejos(int[][] numeros) {
		Complejo[] complejos = new Complejo[numeros.length];
		for (int i  = 0; i < numeros.length;i++) {
			complejos[i] = new Complejo(numeros[i][0],numeros[i][1]);
		}
		return complejos;
	}
	
	public Complejo[][] getNumeros(){
		return numeros;
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