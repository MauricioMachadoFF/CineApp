package control;
import java.util.ArrayList;
import model.*;

public class MovieControl {
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	
	public MovieControl(DataControl data) {
		movies = data.getMovies();
	}
	
	public String[] getMoviesName() {
		String[] list = new String[movies.size()];
		for(int n = 0; n < movies.size(); n++) {
			list[n] = movies.get(n).getName();
		}
		
		return list;
	}
}
