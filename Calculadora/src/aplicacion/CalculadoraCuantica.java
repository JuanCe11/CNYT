package aplicacion;

public class CalculadoraCuantica {
	
	public static double[] calcularProbabilidad(Matriz estadoInicial) throws CalculadoraException {
		if (!estadoInicial.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		double[] probabilidades = new double[estadoInicial.getNumeros().length];
		for (int i = 0; i < estadoInicial.getNumeros().length; i++) {
			probabilidades[i] = Math.pow(estadoInicial.getNumeros()[i][0].getModulo(),2)/Math.pow(CalculadoraMatrices.normaDeUnVector(estadoInicial),2);		
		}		
		return probabilidades;
	}
	
	public static Complejo calcularAmplitud(Matriz psi,Matriz phi) throws CalculadoraException {
		if (!psi.isVector() || !phi.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		double[] escalarPsi = {(double)1/CalculadoraMatrices.normaDeUnVector(psi),0};
		psi = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPsi, psi);
		double[] escalarPhi = {(double)1/CalculadoraMatrices.normaDeUnVector(phi),0};
		psi = CalculadoraMatrices.multiplicacionEscalarMatriz(escalarPhi, psi);
		return CalculadoraMatrices.productoInterno(phi,psi);
	}
	
	public static Complejo calcularValorEsperado(Matriz omega,Matriz psi) throws CalculadoraException {
		if (!psi.isVector()) {
			throw new CalculadoraException(CalculadoraException.NO_ES_VECTOR);
		}
		if (!CalculadoraMatrices.esHermitania(omega)) {
			throw new CalculadoraException("La matriz no es hermitania");
		}
		Matriz res = CalculadoraMatrices.matrizPorMatriz(omega, psi);
		return CalculadoraMatrices.productoInterno(res,psi);
	}
	
	public static Complejo calcularVarianza(Matriz omega,Matriz psi) throws CalculadoraException {
		Matriz delta = delta(omega,psi);
		return calcularValorEsperado(CalculadoraMatrices.matrizPorMatriz(delta, delta),psi);
	}

	private static Matriz delta(Matriz omega, Matriz psi) throws CalculadoraException {
		double[] valorEsperado = {calcularValorEsperado(omega,psi).getReal(),calcularValorEsperado(omega,psi).getImaginaria()},menosUno = {-1,0};
		return CalculadoraMatrices.sumaMatriz(omega, CalculadoraMatrices.multiplicacionEscalarMatriz(menosUno,CalculadoraMatrices.multiplicacionEscalarMatriz(valorEsperado, CalculadoraMatrices.identidad(omega))));
	}
}
