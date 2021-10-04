package control;
import java.util.ArrayList;
import model.*;

/**
 * Controle das informações acerca da classe Movie
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class MovieControl {
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	
	/**
	 * Preencher a ArrayList movies com todos os filmes existentes até o momento
	 * 
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public MovieControl(DataControl data) {
		movies = data.getMovies();
	}
	
	
	/**
	 * Gera uma lista com o nome de todos os filmes existentes
	 * 
	 * @return list - Um Array de Strings onde cada String é o nome de um filme
	 */
	public String[] getMoviesName() {
		String[] list = new String[movies.size()];
		for(int n = 0; n < movies.size(); n++) {
			list[n] = movies.get(n).getName();
		}
		return list;
	}
	
	/**
	 * Gera uma lista de todos os filmes classificando-os por seu gênero
	 * 
	 * @return list - Um Array de Strings onde cada String é o gênero do filme na posição n
	 */
	public String[] getMoviesGenre() {
		String[] list = new String[movies.size()];
		for(int n = 0; n < movies.size(); n++) {
			list[n] = movies.get(n).getGenre();
		}
		return list;
	}
}
