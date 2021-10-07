/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.DataControl;

/**
 * @author clara
 *
 */
class addEditMovieTest {
	DataControl movies = new DataControl();
	/**
	 * Test method for {@link control.DataControl#editMovie(java.lang.String[])}.
	 */
	@Test
	final void testEditMovie() {
		String[] s = new String[6];
		s[0] = "1";
		s[1] = "Nome";
		s[2] = "2000";
		s[3] = "Comedia";
		s[4] = "Sinopse...";
		assertTrue(movies.editMovie(s));
		
		s[5] = "96332";
		assertTrue(movies.editMovie(s));
		
		s[2] = "a";
		assertFalse(movies.editMovie(s));
		
	}

	/**
	 * Test method for {@link control.DataControl#addMovie(java.lang.String[])}.
	 */
	@Test
	final void testAddMovie() {
		String[] s = new String[6];
		s[0] = "Nome";
		s[1] = "2000";
		s[2] = "Comedia";
		s[3] = "Sinopse...";
		assertTrue(movies.addMovie(s));
		
		s[4] = "96332";
		assertTrue(movies.addMovie(s));
		
		s[1] = "a";
		assertFalse(movies.addMovie(s));
	}

}
