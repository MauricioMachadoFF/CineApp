/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import control.*;

import org.junit.jupiter.api.Test;

/**
 * @author Clara
 *
 */
class addEditSnackTest {
	DataControl snack = new DataControl();

	/**
	 * Test method for {@link control.DataControl#editSnack(java.lang.String[])}.
	 */
	@Test
	final void testEditSnack() {
		String[] s = new String[6];
		s[0] = "1";
		s[1] = "nome";
		s[2] = "3.75";
		s[3] = "5";
		s[4] = "85461";
		s[5] = "true";
		assertTrue(snack.editSnack(s));
		
		s[0] = "1";
		s[1] = "nome";
		s[2] = "preco";
		s[3] = "5";
		s[4] = "85461";
		s[5] = "true";
		assertFalse(snack.editSnack(s));
		
		s[0] = "1";
		s[1] = "nome";
		s[2] = "3.75";
		s[3] = "1.5";
		s[4] = "85461";
		s[5] = "true";
		assertFalse(snack.editSnack(s));
	}

	/**
	 * Test method for {@link control.DataControl#addSnack(java.lang.String[])}.
	 */
	@Test
	final void testAddSnack() {
		String[] s = new String[5];
		s[0] = "nome";
		s[1] = "3.75";
		s[2] = "5";
		s[3] = "85461";
		s[4] = "true";
		assertTrue(snack.addSnack(s));
		
		s[0] = "nome";
		s[1] = "preco";
		s[2] = "5";
		s[3] = "85461";
		s[4] = "true";
		assertFalse(snack.addSnack(s));
		
		s[0] = "nome";
		s[1] = "3.75";
		s[2] = "1.5";
		s[3] = "85461";
		s[4] = "true";
		assertFalse(snack.addSnack(s));
	}

}
