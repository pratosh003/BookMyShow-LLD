package appPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City, List<Movie>> cityVsMovies;
	List<Movie> allMovies;
	
	public MovieController() {
		cityVsMovies = new HashMap<>();
		allMovies = new ArrayList<>();
	}
	
	void addMovie(Movie movie, City city) {
		allMovies.add(movie);
		List<Movie> list = cityVsMovies.getOrDefault(city, new ArrayList<>());
		list.add(movie);
		cityVsMovies.put(city, list);
	}
	
	Movie getMovieByName(String name) {
		for(Movie m: allMovies) {
			if(m.movieName.equals(name))
				return m;
		}
		return null;
	}
	
	List<Movie> getMoviesByCity(City city){
		return cityVsMovies.get(city);
	}
}
