package Operatii;
import Polinom.*;

import java.util.ArrayList;
import java.util.Collections;

public class OperatiiPolinom{

	public static Polinom adunare(Polinom a, Polinom b) {
		Polinom rezultat = new Polinom();
		ArrayList<Monom> polinomA = a.getPolinom();
		ArrayList<Monom> polinomB = b.getPolinom();

		int i = 0, j = 0;
		while(i < polinomA.size() && j < polinomB.size()) {
			if(polinomA.get(i).getExponent() == polinomB.get(j).getExponent()) {
				Monom mAux = OperatiiMonom.adunare(polinomA.get(i), polinomB.get(j));
				if(mAux.getCoeficient() != 0)
					rezultat.addMonom(mAux);
				i++; j++;
			}
			else
				if(polinomA.get(i).getExponent() > polinomB.get(j).getExponent()) {
					rezultat.addMonom(polinomA.get(i));
					i++;
				}
				else {
					rezultat.addMonom(polinomB.get(j));
					j++;
				}
			}

		while(i < polinomA.size()) {
			rezultat.addMonom(polinomA.get(i));
			i++;}
		while(j < polinomB.size()) {
			rezultat.addMonom(polinomB.get(j));
			j++;
		}
		return rezultat;
	}

	public static Polinom scadere(Polinom a, Polinom b) {
		Polinom rezultat = new Polinom();
		ArrayList<Monom> polinomA = a.getPolinom();
		ArrayList<Monom> polinomB = b.getPolinom();

		int i = 0, j = 0;
		while(i < polinomA.size() && j < polinomB.size()) {
			if(polinomA.get(i).getExponent() == polinomB.get(j).getExponent()) {
				Monom mAux = OperatiiMonom.scadere(polinomA.get(i), polinomB.get(j));
				if(mAux.getCoeficient() != 0)
					rezultat.addMonom(mAux);
				i++; j++;
			}
			else 
				if(polinomA.get(i).getExponent() > polinomB.get(j).getExponent()) {
					rezultat.addMonom(polinomA.get(i));
					i++;
				}
				else {
					rezultat.addMonom(new Monom(-polinomB.get(j).getCoeficient(), polinomB.get(j).getExponent()));
					j++;
				}
		}

		while(i < polinomA.size()) {
			rezultat.addMonom(polinomA.get(i));
			i++;
		}
		while(j < polinomB.size()) {
			rezultat.addMonom(new Monom(-polinomB.get(j).getCoeficient(), polinomB.get(j).getExponent()));
			j++;
		}
		return rezultat;
	}

	public static Polinom inmultire(Polinom a, Polinom b) {
		Polinom rezultat = new Polinom();

		for(Monom m1: a.getPolinom()) {
			for(Monom m2: b.getPolinom()) {
				Monom mAux = OperatiiMonom.inmultire(m1, m2);
				rezultat.addSearchMonom(mAux);
			}
		}

		Collections.sort(rezultat.getPolinom());
		return rezultat;
	}

	public static ArrayList<Polinom> impartire(Polinom a, Polinom b) throws RuntimeException{
		ArrayList<Monom> polinomA = a.getPolinom();
		ArrayList<Monom> polinomB = b.getPolinom();
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		ArrayList<Polinom> rezultat = new ArrayList<Polinom>();

		if(polinomB.isEmpty())
			throw new RuntimeException("Cel de-al doilea polinom trebuie sa fie diferit de 0!!");

		if(polinomA.isEmpty())
			return rezultat;

		if(a.getGradPolinom() < b.getGradPolinom())
			throw new RuntimeException("Gradul polinomului 1 < Gradul polinomului 2!!");

		rest = a;
		while(rest.getGradPolinom() >= b.getGradPolinom()) {
			ArrayList<Monom> polinomR = rest.getPolinom();
			Monom c = OperatiiMonom.impartire(polinomR.get(0), polinomB.get(0));
			cat.addMonom(c);

			Polinom produs = new Polinom();
			for(Monom mB: polinomB)
				produs.addMonom(OperatiiMonom.inmultire(mB, c));

			rest = OperatiiPolinom.scadere(rest, produs);
		}

		rezultat.add(cat);
		rezultat.add(rest);
		return rezultat;
	}

	public static Polinom derivare(Polinom a) {
		Polinom rezultat = new Polinom();

		for(Monom m: a.getPolinom()) {
			Monom mAux = OperatiiMonom.derivare(m);
			if(mAux.getCoeficient() != 0)
				rezultat.addMonom(mAux);
		}

		return rezultat;
	}

	public static Polinom integrare(Polinom a) {
		Polinom rezultat = new Polinom();

		for(Monom m: a.getPolinom()) {
			Monom mAux = OperatiiMonom.integrare(m);
			rezultat.addMonom(mAux);
		}

		return rezultat;
	}
}
