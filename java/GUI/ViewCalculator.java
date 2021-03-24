package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class ViewCalculator extends JFrame{

	private JButton adunareB = new JButton("+");
	private JButton scadereB = new JButton("-");
	private JButton inmultireB = new JButton("*");
	private JButton impartireB = new JButton("/");
	private JButton derivareB = new JButton("`");
	private JButton integrareB = new JButton("\u222B");
	private JButton egalB = new JButton("=");
	private JButton resetB = new JButton("C");
	private JTextField text1 = new JTextField("");
	private JTextField text2 = new JTextField();
	private JTextField text3 = new JTextField("");
	private JTextField text4 = new JTextField("=");
	private JTextField text5 = new JTextField();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private Font myFont = new Font("Arial", Font.PLAIN, 18);

	public ViewCalculator() {
		initUI();
	}

	private void initUI() {
		createMenu();

		this.setTitle("Calculator");
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenu() {

		panel1 = createPanel1();
		panel2 = createPanel2();
		panel3 = createPanel3();
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		
		c.gridx = 0; c.gridy = 0;
		JLabel label = new JLabel("Exemplu polinom valid: 2x^4-3*x^3-15x^2+32*x-12");
		label.setFont(myFont);
		panel.add(label, c);
		
		c.gridx = 0; c.gridy = 1;
		panel.add(panel1, c);
		
		c.gridx = 0; c.gridy = 2;
		panel.add(panel2, c);
		
		c.gridx = 0; c.gridy = 3;
		panel.add(panel3, c);

		this.add(panel);
		this.pack();
	}

	private JPanel createPanel1() {
		this.styleButton(adunareB);
		this.styleButton(scadereB);
		this.styleButton(inmultireB);
		this.styleButton(impartireB);
		this.styleButton(derivareB);
		this.styleButton(integrareB);
		this.styleButton(egalB);
		this.styleButton(resetB);

		JPanel panel = new JPanel();

		stylePanel1(panel);
		return panel;
	}

	private void styleButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setPreferredSize(new Dimension(60, 50));
	}

	private void stylePanel1(JPanel panel) {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 0;  c.gridy = 0;
		panel.add(adunareB, c);
		c.gridx = 1; c.gridy = 0;
		panel.add(scadereB, c);
		c.gridx = 2; c.gridy = 0;
		panel.add(inmultireB, c);
		c.gridx = 3; c.gridy = 0;
		panel.add(impartireB, c);
		c.gridx = 0; c.gridy = 1;
		panel.add(derivareB, c);
		c.gridx = 1; c.gridy = 1;
		panel.add(integrareB, c);
		c.gridx = 2; c.gridy = 1;
		panel.add(egalB, c);
		c.gridx = 3; c.gridy = 1;
		panel.add(resetB, c);

		c.insets = new Insets(20, 10, 10, 10);
		c.gridx = 0;  c.gridy = 2; c.gridwidth = 4;
		text1.setFont(myFont);
		text1.setHorizontalAlignment(JTextField.CENTER);
		text1.setPreferredSize(new Dimension(300, 30));
		panel.add(text1, c);
	}

	private JPanel createPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 0;  c.gridy = 0;
		text2.setFont(myFont);
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setPreferredSize(new Dimension(20, 20));
		text2.setEditable(false);
		panel.add(text2, c);

		c.gridx = 0;  c.gridy = 1;
		text3.setFont(myFont);
		text3.setHorizontalAlignment(JTextField.CENTER);
		text3.setPreferredSize(new Dimension(300, 30));
		panel.add(text3, c);

		panel.setVisible(false);

		return panel;
	}

	private JPanel createPanel3() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 0;  c.gridy = 0;
		text4.setFont(myFont);
		text4.setHorizontalAlignment(JTextField.CENTER);
		text4.setPreferredSize(new Dimension(20, 20));
		text4.setEditable(false);
		panel.add(text4, c);

		c.gridx = 0;  c.gridy = 1;
		text5.setFont(myFont);
		text5.setHorizontalAlignment(JTextField.CENTER);
		text5.setPreferredSize(new Dimension(500, 70));
		text5.setEditable(false);
		panel.add(text5, c);

		panel.setVisible(false);

		return panel;
	}
	
	public void addAdunareListener(ActionListener a) {
		adunareB.addActionListener(a);
	}

	public void addScadereListener(ActionListener a) {
		scadereB.addActionListener(a);
	}

	public void addInmultireListener(ActionListener a) {
		inmultireB.addActionListener(a);
	}

	public void addImpartireListener(ActionListener a) {
		impartireB.addActionListener(a);
	}

	public void addDerivareListener(ActionListener a) {
		derivareB.addActionListener(a);
	}

	public void addIntegrareListener(ActionListener a) {
		integrareB.addActionListener(a);
	}
	
	public void addEgalListener(ActionListener a) {
		egalB.addActionListener(a);
	}
	
	public void addResetListener(ActionListener a) {
		resetB.addActionListener(a);
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public String getText1() {
		return text1.getText();
	}

	public String getText3() {
		return text3.getText();
	}
	
	public void setText5(String s) {
		text5.setText(s);
	}

	public void setText2(char c) {
		text2.setText(c  + "");
	}
	
	public void setText3(String s) {
		text3.setText(s);
	}
	
	public void reset() {
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text5.setText("");
	}
}
