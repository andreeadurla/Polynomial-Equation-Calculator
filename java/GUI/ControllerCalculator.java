package GUI;
import Polinom.*;
import Operatii.OperatiiPolinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerCalculator {

	private ViewCalculator calcView;
	private char[] operatii = new char[2];
	private boolean panel2 = false;

	public ControllerCalculator(ViewCalculator view) {
		this.calcView = view;
		calcView.addAdunareListener(new AdunareListener());
		calcView.addScadereListener(new ScadereListener());
		calcView.addInmultireListener(new InmultireListener());
		calcView.addImpartireListener(new ImpartireListener());
		calcView.addDerivareListener(new DerivareListener());
		calcView.addIntegrareListener(new IntegrareListener());
		calcView.addEgalListener(new EgalListener());
		calcView.addResetListener(new ResetListener());
	}

	private Polinom validare(String stringPolinom) {
		try {
			Polinom polinom = new Polinom(stringPolinom);
			return polinom;
		}catch(RuntimeException e) {
			calcView.setText5(e.getMessage());
			return null;
		}
	}
	private String afisareImpartire(ArrayList<Polinom> polinoame, Polinom polinom2) {
		String s = "";

		if(polinoame.isEmpty())
			s += "(0)";
		else
			if(polinoame.get(1).getPolinom().isEmpty())
				s += (polinoame.get(0)).toString();
			else
				s += (polinoame.get(0)).toString() + " + (" + (polinoame.get(1)).toString() + ") / (" + polinom2.toString() + ")";

		return s;
	}

	private void efectuareOperatieBinara() {
		Polinom polinom1 = validare(calcView.getText1());
		if(polinom1 == null)
			return ;

		Polinom polinom2 = validare(calcView.getText3());
		if(polinom2 == null)
			return ;

		Polinom rezultat = new Polinom();
		switch(operatii[1]) {
		case '+':
			rezultat = OperatiiPolinom.adunare(polinom1, polinom2);
			break;
		case '-':
			rezultat = OperatiiPolinom.scadere(polinom1, polinom2);
			break;
		case '*':
			rezultat = OperatiiPolinom.inmultire(polinom1, polinom2);
			break;
		case '/':
			try {
				ArrayList<Polinom> rezultatI = OperatiiPolinom.impartire(polinom1, polinom2);
				calcView.setText5(afisareImpartire(rezultatI, polinom2));
			}catch(RuntimeException ex) {
				calcView.setText5(ex.getMessage());
			}
			return ;
		}
		calcView.setText5(rezultat.toString());
	}

	private void efectuareOperatieUnara() {

		Polinom polinom1 = validare(calcView.getText1());
		if(polinom1 == null)
			return ;

		Polinom rezultat = new Polinom();

		switch(operatii[1]) {
		case '`':
			rezultat = OperatiiPolinom.derivare(polinom1);
			break;
		case 'i':
			rezultat = OperatiiPolinom.integrare(polinom1);
			break;
		default:
			rezultat = polinom1;
		}
		calcView.setText5(rezultat.toString());
	}

	class AdunareListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = '+';
			calcView.setText2('+');
			if(operatii[0] == '`' || operatii[0] == 'i')
				calcView.setText3(""); //daca operatia anterioara a fost derivare sau integrare atunci textul din JtextField3 va fi sters 
		}
	}

	class ScadereListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = '-';
			calcView.setText2('-');
			if(operatii[0] == '`' || operatii[0] == 'i')
				calcView.setText3(""); //daca operatia anterioara a fost derivare sau integrare atunci textul din JtextField3 va fi sters 
		}
	}

	class InmultireListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = '*';
			calcView.setText2('*');
			if(operatii[0] == '`' || operatii[0] == 'i')
				calcView.setText3(""); //daca operatia anterioara a fost derivare sau integrare atunci textul din JtextField3 va fi sters 
		}
	}

	class ImpartireListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = '/';
			calcView.setText2('/');
			if(operatii[0] == '`' || operatii[0] == 'i')
				calcView.setText3(""); //daca operatia anterioara a fost derivare sau integrare atunci textul din JtextField3 va fi sters 
		}
	}

	class DerivareListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = '`';
			calcView.setText2('\u2193');
			calcView.setText3("(" + calcView.getText1() + ")`");
		}
	}

	class IntegrareListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(true);
			panel2 = true;
			(calcView.getPanel3()).setVisible(false);

			operatii[0] = operatii[1];
			operatii[1] = 'i';
			calcView.setText2('\u2193');
			calcView.setText3("\u222B(" + calcView.getText1() + ")dx");
		}
	}

	class EgalListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel3()).setVisible(true);

			if(operatii[1] == '`' || operatii[1] == 'i' || panel2 == false)
				efectuareOperatieUnara();
			else
				efectuareOperatieBinara();
		}
	}

	class ResetListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			(calcView.getPanel2()).setVisible(false);
			panel2 = false;
			(calcView.getPanel3()).setVisible(false);
			calcView.reset();
		}
	}
}

