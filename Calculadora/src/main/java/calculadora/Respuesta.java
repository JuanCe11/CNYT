package calculadora;


public class Respuesta {
	private boolean matrizValida;
	private Matriz potencia;
	private Matriz estadoFinal;
	
	public Respuesta(boolean matrizValida,Matriz potencia, Matriz estadoFinal) {
		this.matrizValida = matrizValida;
		this.potencia = potencia;
		this.estadoFinal = estadoFinal;
	}

	public boolean isMatrizValida() {
		return matrizValida;
	}

	public void setMatrizValida(boolean matrizValida) {
		this.matrizValida = matrizValida;
	}

	public Matriz getPotencia() {
		return potencia;
	}

	public void setPotencia(Matriz potencia) {
		this.potencia = potencia;
	}

	public Matriz getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(Matriz estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
}
