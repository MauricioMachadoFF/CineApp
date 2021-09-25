package control;
import java.util.ArrayList;
import model.*;

public class EmployeeControl
{
	private ArrayList<Movie> employees = new ArrayList<Movie>();
	
	public EmployeeControl(DataControl data) {
		employees = data.getMovies();
	}
	
	public String[] getEmployeesName() {
		String[] list = new String[employees.size()];
		for(int n = 0; n < employees.size(); n++) {
			list[n] = employees.get(n).getName();
		}
		
		return list;
	}
}
