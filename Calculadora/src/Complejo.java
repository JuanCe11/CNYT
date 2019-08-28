
public class Complejo {
	private double real;
	private double imaginaria;
	private double modulo;
	private double fase;
	
	/**
	 * Crea un numero complejo dadas sus coordenadas rectangulares
	 * @param real la parte real del numero
	 * @param imaginaria la parte imaginaria del numero
	 */
	public Complejo(double real,double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
		setFase();
		setModulo();
	}
	
	/**
	 * Crea un numero complejo dadas sus coordenadas polares
	 * @param modulo el modulo del numero
	 * @param fase la fase del numero 
	 * @param polar un indicador de que son coordenadas polares
	 */
	public Complejo(double modulo, float fase,int polar) {
		this.fase = fase;
		this.modulo = modulo;
		setRectangular();
	}

	/**
	 * Calcula las cooredenadas rectangulares del numero
	 */
	private void setRectangular() {
		real = Math.cos(Math.toRadians(fase))*modulo;
		imaginaria = Math.sin(Math.toRadians(fase))*modulo;
		if (fase%90 == 0)real = 0.0;
	}

	/**
	 * Da la parte real del numero
	 * @return la parte real del numero
	 */
	public double getReal() {
		return real;
	}

	/**
	 * Da la parte real del imaginaria
	 * @return la parte imaginaria del numero
	 */
	public double getImaginaria() {
		return imaginaria;
	}
	
	/**
	 * Calcula y asigna el modulo del numero
	 */
	public void setModulo() {
		this.modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginaria, 2));		
	}

	/**
	 * Da le modulo del numero
	 * @return el modulo del numero
	 */
	public double getModulo() {
		return modulo;
	}
	
	/**
	 * Calcula y asigna la fase del numero
	 */
	private void setFase() {
		fase = (double) Math.toDegrees(Math.atan(imaginaria/real));
		if(real<0 && imaginaria<0 || real<0 && imaginaria>0) {
			fase+=180;
		}else if (real>0 && imaginaria<0) {
			fase+=360;
		}
	}
	
	/**
	 * Da la fase del numero
	 * @return la fase del numero
	 */
	public double getFase() {
		return fase;
	}
	
	/**
	 * Calcula y devuelve el conjugado de si mismo 
	 * @return el conjugado de si mismo
	 */
	public Complejo conjugado() {
		return new Complejo(real,imaginaria*-1);
		
	}
	
	public String toString() {
		String s = "(";
		if(real != 0) {
			s += Double.toString(real);
			if (imaginaria > 0) {
				s+=" +";
			}
		}
		if (imaginaria != 0) {
			s += " " +Double.toString(imaginaria)+"i";
		}
		if (real == 0 && imaginaria == 0) {
			s += "0";
		}
		
		s += ")";
		return s;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Complejo other = (Complejo) obj;
		if (imaginaria != other.imaginaria)
			return false;
		if (real != other.real)
			return false;
		return true;
	}
}