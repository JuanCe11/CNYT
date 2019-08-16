
public class Complejo {
	private double real;
	private double imaginaria;
	private double modulo;
	private double fase;
	
	public Complejo(double real,double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
		setFase();
		setModulo();
	}
	
	public Complejo(double modulo, float fase,int polar) {
		this.fase = fase;
		this.modulo = modulo;
		setRectangular();
	}

	private void setRectangular() {
		real = Math.cos(Math.toRadians(fase))*modulo;
		imaginaria = Math.sin(Math.toRadians(fase))*modulo;
		if (fase%90 == 0)real = 0.0;
	}

	public double getReal() {
		return real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(float imaginaria) {
		this.imaginaria = imaginaria;
	}

	public double getModulo() {
		return modulo;
	}
	
	private void setFase() {
		fase = (double) Math.toDegrees(Math.atan(imaginaria/real));
		if(real<0 && imaginaria<0 || real<0 && imaginaria>0) {
			fase+=180;
		}else if (real>0 && imaginaria<0) {
			fase+=360;
		}
	}
	
	public double getFase() {
		return fase;
	}
	
	public void setModulo() {
		this.modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginaria, 2));		
	}
	
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
			s += " " +Double.toString(imaginaria)+"i)";
		}
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