package Polinom;

public class Monom implements Comparable<Monom>{

	private double coeficient;
	private int exponent;

	public Monom(double coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public double getCoeficient() {
		return coeficient;
	}

	public int getExponent() {
		return exponent;
	}

	public int compareTo(Monom o) {
		return o.exponent - this.exponent;
	}

	public String toString() {

		String s = "";
		
		if(exponent == 0 && (coeficient == 1 || coeficient == -1))
			return s + (int)coeficient;
		
		if(coeficient == -1)
			s += "-";
		else
			if(coeficient != 1) {
				if(coeficient * 10 % 10 == 0)
					s += (int)coeficient;
				else
					if(coeficient * 100 % 10 == 0)
						s += String.format("%.1f", coeficient);
					else
						s += String.format("%.2f", coeficient);
			}
		
		if(exponent == 1)
			s += "x";
		else
			if(exponent != 0)
				s += "x^" + exponent;
		
		return s;
	}
}
