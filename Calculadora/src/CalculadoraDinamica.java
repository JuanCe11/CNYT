
public class CalculadoraDinamica {
	
	
	public static Matriz determinista(Matriz m1, Matriz estadoInicial, int clicks) throws CalculadoraException {
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
	
	public static Matriz deterministaConEnsamble(Matriz m1, Matriz m2,Matriz estadoInicial, int clicks) throws CalculadoraException {
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
