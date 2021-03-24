package Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.*;

import java.util.ArrayList;

import Polinom.Polinom;
import Operatii.OperatiiPolinom;

public class JUnitTest {
	private static Polinom p1;
	private static Polinom p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p1 = new Polinom("2x^4  - 3x ^ 3-15x^2+ 32x-12");
		p2 = new Polinom("-8*x+x^2-12+4x");
	}

	@Test
	public void testAdunare() {
		Polinom rezultat = OperatiiPolinom.adunare(p1, p2);
		assertTrue(rezultat.toString().equals("2x^4-3x^3-14x^2+28x-24"));
	}
	
	@Test
	public void testScadere() {
		Polinom rezultat = OperatiiPolinom.scadere(p1, p2);
		assertTrue(rezultat.toString().equals("2x^4-3x^3-16x^2+36x"));
	}
	
	@Test
	public void testInmultire() {
		Polinom rezultat = OperatiiPolinom.inmultire(p1, p2);
		assertTrue(rezultat.toString().equals("2x^6-11x^5-27x^4+128x^3+40x^2-336x+144"));
	}
	
	@Test
	public void testImpartire1() {
		ArrayList<Polinom> rezultat = OperatiiPolinom.impartire(p1, p2);
		assertTrue(rezultat.get(0).toString().equals("2x^2+5x+29"));
		assertTrue(rezultat.get(1).toString().equals("208x+336"));
	}
	
	@Test
	public void testImpartire2() {
		assertThrows(RuntimeException.class, () -> {OperatiiPolinom.impartire(p1, new Polinom("2x^2-2x^2"));});	
	}
	
	@Test
	public void testDerivare() {
		Polinom rezultat = OperatiiPolinom.derivare(p1);
		assertTrue(rezultat.toString().equals("8x^3-9x^2-30x+32"));
	}
	
	@Test
	public void testIntegrare() {
		Polinom rezultat = OperatiiPolinom.integrare(p1);
		assertTrue(rezultat.toString().equals("0.4x^5-0.75x^4-5x^3+16x^2-12x"));
	}
	
	@Test
	public void testValidarePolinom1() {
		assertThrows(RuntimeException.class, () -> {new Polinom("Ana are mere");});
	}
	
	@Test
	public void testValidarePolinom2() {
		assertThrows(RuntimeException.class, () -> {new Polinom("2x20 + x^2 + 3");});
	}
	
	@Test
	public void testValidarePolinom3() {
		assertThrows(RuntimeException.class, () -> {new Polinom("x^2 + 2x + x^+ 3");});
	}
}
