package Polinom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Operatii.OperatiiMonom;

public class Polinom {

	private ArrayList<Monom> polinom = new ArrayList<Monom>();

	public Polinom(String input) throws RuntimeException{
		crearePolinom(input);
	}

	public Polinom() {

	}

	public ArrayList<Monom> getPolinom() {
		return polinom;
	}

	private void crearePolinom(String input) throws RuntimeException{
		input = eliminareSpatii(input);
		extragereMonom(input);
		Collections.sort(polinom);
	}

	private String eliminareSpatii(String s) {
		String newS = "";

		for (char c : s.toCharArray())
			if(c != ' ')
				newS += c;

		return newS;
	}
	
	private static boolean isNumeric(String s) {
		Pattern pattern = Pattern.compile("[+-]?\\d+(\\.\\d+)?");
	    if (s == null) {
	        return false; 
	    }
	    return pattern.matcher(s).matches();
	}

	private void extragereMonom(String input) throws RuntimeException{

		Pattern pattern = Pattern.compile("([-+]?\\d*)\\*?[xX]?\\^?(\\d+)?");
		Matcher m1 = pattern.matcher(input);
		
		int poz = 0;
		while(m1.find() && poz < input.length()) { 
			addSearchMonom(parsareMonom(m1));
			poz = m1.end();
		}
	}
	
	private Monom parsareMonom(Matcher monom) {
		Pattern pattern = Pattern.compile("[xX]");
		Matcher m = pattern.matcher(monom.group());
	
		int coeficient = 0, exponent = 0;
		if(m.find()) {
			if(monom.group(1).equals("") || monom.group(1).equals("+") || monom.group(1).equals("-"))
				coeficient = Integer.parseInt(monom.group(1) + 1);
			else
				coeficient = Integer.parseInt(monom.group(1));

			if(m.start() + 1 < monom.group().length()) {
				if(monom.group(2) != null && monom.group().charAt(m.start() + 1) == '^')
					exponent = Integer.parseInt(monom.group(2));
				else
					throw new RuntimeException("Polinomul este invalid!!");
			}
			else
				exponent = 1;
		}
		else 
		{
			if(isNumeric(monom.group()) == true)
				coeficient = Integer.parseInt(monom.group());
			else
				throw new RuntimeException("Polinomul este invalid!!");
		}
		return new Monom(coeficient, exponent);
	}
	
	public void addMonom(Monom m) {
		polinom.add(m);
	}

	public void addSearchMonom(Monom m) {

		if(m.getCoeficient() != 0 && actualizarePolinom(m) == false) {
			polinom.add(m);
		}
	}
	
	private boolean actualizarePolinom(Monom monom) {
		int i = 0;
		for(Monom m: polinom) {
			if(m.getExponent() == monom.getExponent()) {
				Monom mAux = OperatiiMonom.adunare(m, monom);

				if(mAux.getCoeficient() == 0)
					polinom.remove(m);
				else
					polinom.set(i, mAux);
				return true;
			}
			i++;
		}
		return false;
	}

	public int getGradPolinom() {
		if(!polinom.isEmpty())
			return polinom.get(0).getExponent();
		return -1;
	}

	public String toString() {
		String rez = "";

		int i = 0;
		for(Monom m: polinom) {
			if(i == 0) {
				rez = m.toString();
				i++;
			}
			else {
				if(m.getCoeficient() < 0)
					rez += m.toString();
				else
					if(m.getCoeficient() > 0)
						rez += "+" + m.toString();
			}
		}

		if(rez.equals(""))
			rez += 0;
		return rez;
	}
}

