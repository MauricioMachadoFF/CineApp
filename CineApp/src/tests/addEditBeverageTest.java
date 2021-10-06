/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import control.*;

import org.junit.jupiter.api.Test;

import control.DataControl;

/**
 * @author Clara
 *
 */
class addEditBeverageTest {
	DataControl beverages = new DataControl();
	/**
	 * Test method for {@link control.DataControl#editBeverage(java.lang.String[])}.
	 */
	@Test
	final void testEditBeverage() {
		String[] s = new String[8];
		s[0] = "1";
		s[1] = "nome";
		s[2] = "0.75";
		s[3] = "5";
		s[4] = "852";
		s[5] = "true";
		s[6] = "false";
		s[7] = "true";
		
		assertTrue(beverages.editBeverage(s));
		
		s[2] = "a";
		assertFalse(beverages.editBeverage(s));
		
		s[3] = "a";
		assertFalse(beverages.editBeverage(s));
		
		s[4] = "a";
		assertFalse(beverages.editBeverage(s));
	}

	/**
	 * Test method for {@link control.DataControl#addBeverage(java.lang.String[])}.
	 */
	@Test
	final void testAddBeverage() {
		String[] s = new String[7];
		s[0] = "nome";
		s[1] = "0.75";
		s[2] = "5";
		s[3] = "852";
		s[4] = "false";
		s[5] = "false";
		s[6] = "false";
		
		assertTrue(beverages.addBeverage(s));
		
		s[1] = "a";
		assertFalse(beverages.editBeverage(s));
		
		s[2] = "a";
		assertFalse(beverages.editBeverage(s));
		
		s[3] = "a";
		assertFalse(beverages.editBeverage(s));
	}
}
