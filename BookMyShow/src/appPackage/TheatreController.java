package appPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
	Map<City, List<Theatre>> cityVsTheatre;
	List<Theatre> allTheatre;
	
	public TheatreController(){
		cityVsTheatre = new HashMap<>();
		allTheatre = new ArrayList<>();
	}
	
	void addTheatre(Theatre theatre, City city) {
		allTheatre.add(theatre);
		List<Theatre> list = cityVsTheatre.getOrDefault(city, new ArrayList<>());
		list.add(theatre);
		cityVsTheatre.put(city, list);
	}
	
	Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
		Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
		List<Theatre> theatres = cityVsTheatre.get(city);
		
		for(Theatre theatre: theatres) {
			List<Show> givenMovieShows = new ArrayList<>();
			List<Show> allShows = theatre.getShows();
			for(Show show: allShows) {
				if(show.movie.movieId == movie.movieId) {
					givenMovieShows.add(show);
				}
			}
			if(!givenMovieShows.isEmpty()) {
				theatreVsShows.put(theatre, givenMovieShows);
			}
		}
		
		return theatreVsShows;
	}
}
