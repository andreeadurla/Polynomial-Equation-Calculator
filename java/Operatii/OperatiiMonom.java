package Operatii;
import Polinom.*;

public class OperatiiMonom{

	public static Monom adunare(Monom a, Monom b) throws NumberFormatException{
		if(a.getExponent() != b.getExponent())
			throw new NumberFormatException("Cele 2 polinoame trebuie sa aiba acelasi grad!");
		
		double coeficient = a.getCoeficient() + b.getCoeficient();
		Monom rez = new Monom(coeficient, a.getExponent());
		return rez;
	}

	public static Monom scadere(Monom a, Monom b) throws NumberFormatException{
		if(a.getExponent() != b.getExponent())
			throw new NumberFormatException("Cele 2 polinoame trebuie sa aiba acelasi grad!");
		
		double coeficient = a.getCoeficient() - b.getCoeficient();
		Monom rez = new Monom(coeficient, a.getExponent());
		return rez;
	}

	public static Monom inmultire(Monom a, Monom b) {
		double coeficient = a.getCoeficient() * b.getCoeficient();
		int exponent = a.getExponent() + b.getExponent();
		Monom rez = new Monom(coeficient, exponent);
		return rez;
	}

	public static Monom impartire(Monom a, Monom b) throws NumberFormatException{
		if(b.getCoeficient() == 0)
			throw new NumberFormatException("Impartitorul trebuie sa fie diferit de 0!");
		
		double coeficient = a.getCoeficient() / b.getCoeficient();
		int exponent = a.getExponent() - b.getExponent();
		Monom rez = new Monom(coeficient, exponent);
		return rez;
	}

	public static Monom derivare(Monom a) {
		if(a.getExponent() == 0)
			return new Monom(0, 0);

		double coeficient = a.getCoeficient() * a.getExponent();
		int exponent = a.getExponent() - 1;
		Monom rez = new Monom(coeficient, exponent);
		return rez;
	}

	public static Monom integrare(Monom a) {
		double coeficient = a.getCoeficient() / (a.getExponent() + 1);
		int exponent = a.getExponent() + 1;
		Monom rez = new Monom(coeficient, exponent);
		return rez;
	}
}
