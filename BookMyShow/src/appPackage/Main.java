package appPackage;

import java.util.ArrayList;
import java.util.*;

public class Main {
	MovieController movieController;
	TheatreController theatreController;
	
	Main(){
		movieController = new MovieController();
		theatreController = new TheatreController();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.createBooking("BAHUBALI", City.Bengaluru);
	}
	
	void initialize() {
		createMovies();
		createTheatres();
	}
	
	void createBooking(String movieName, City userCity) {
		List<Movie> movies = movieController.getMoviesByCity(userCity);
		
		Movie interestedMovie = null;
		for(Movie movie: movies) {
			if(movie.movieName.equals(movieName))
				interestedMovie = movie;
		}
		
		Map<Theatre, List<Show>> showsTheatrewise = theatreController.getAllShow(interestedMovie, userCity);
		
		
		Map.Entry<Theatre, List<Show>> entry = showsTheatrewise.entrySet().iterator().next();
		List<Show> runningShows = entry.getValue();
		Show interestedShow = runningShows.get(0);
		
		
		int seatNo = 30;
		List<Integer> bookedSeats = interestedShow.getBookedSeats();
		if(!bookedSeats.contains(seatNo)) {
			bookedSeats.add(seatNo);
			Booking booking = new Booking();
			List<Seat> myBookedSeats = new ArrayList<>();
			for(Seat screenSeat: interestedShow.getScreen().getSeats()) {
				if(screenSeat.getSeatId() == seatNo) {
					myBookedSeats.add(screenSeat);
				}
			}
			booking.setBookeadSeats(myBookedSeats);
			booking.setShow(interestedShow);
		}
		else {
			System.out.println("This Seat is already booked");
			return;
		}
		System.out.println("Booking Confirmed!!");
	}
	
	
	
	void createMovies() {
		Movie avengers = new Movie();
		avengers.setMovieId(1);
		avengers.setMovieName("AVENGERS");
		avengers.setMovieDuration(300);
		
		Movie bahubali = new Movie();
		bahubali.setMovieId(1);
		bahubali.setMovieName("BAHUBALI");
		bahubali.setMovieDuration(280);
		
		movieController.addMovie(bahubali, City.Bengaluru);
		movieController.addMovie(avengers, City.Bengaluru);
		movieController.addMovie(bahubali, City.Delhi);
		movieController.addMovie(avengers, City.Delhi);
	}
	
	
	void createTheatres() {
		Movie avengers = movieController.getMovieByName("AVENGERS");
		Movie bahubali = movieController.getMovieByName("BAHUBALI");
		
		Theatre inox = new Theatre();
		inox.setTheatreId(1);;
		inox.setCity(City.Bengaluru);
		inox.setScreens(createScreen());
		List<Show> inoxShow = new ArrayList<>();
		Show inoxMorningShow = createShow(3, inox.getScreens().get(0), avengers, 8);
		Show inoxEveningShow = createShow(2, inox.getScreens().get(0), bahubali, 16);
		inoxShow.add(inoxMorningShow);
		inoxShow.add(inoxEveningShow);
		inox.setShows(inoxShow);
		
		Theatre pvr = new Theatre();
		pvr.setTheatreId(2);;
		pvr.setCity(City.Delhi);
		pvr.setScreens(createScreen());
		List<Show> pvrShow = new ArrayList<>();
		Show pvrMorningShow = createShow(3, pvr.getScreens().get(0), avengers, 13);
		Show pvrEveningShow = createShow(4, pvr.getScreens().get(0), bahubali, 20);
		pvrShow.add(pvrMorningShow);
		pvrShow.add(pvrEveningShow);
		pvr.setShows(pvrShow);
		
		theatreController.addTheatre(inox, City.Bengaluru);
		theatreController.addTheatre(pvr, City.Delhi);
	}
	
	List<Screen> createScreen(){
		List<Screen> screens = new ArrayList<>();
		Screen screen1 = new Screen();
		screen1.setSeats(createSeats());
		screen1.setScreenId(1);
		screens.add(screen1);
		
		return screens;
	}
	
	
	
	List<Seat> createSeats(){
		List<Seat> seats = new ArrayList<>();
		
		for(int i=1;i<=40;i++) {
			Seat seat = new Seat();
			seat.setSeatId(i);
			seat.setSeatCategory(SeatCategory.SILVER);
			seats.add(seat);
		}
		
		for(int i=41;i<=70;i++) {
			Seat seat = new Seat();
			seat.setSeatId(i);
			seat.setSeatCategory(SeatCategory.GOLD);
			seats.add(seat);
		}
		
		for(int i=71;i<=100;i++) {
			Seat seat = new Seat();
			seat.setSeatId(i);
			seat.setSeatCategory(SeatCategory.PLATINUM);
			seats.add(seat);
		}
		
		return seats;
	}
	
	
	
	Show createShow(int id, Screen screen, Movie movie, int showStartTime) {
		Show show = new Show();
		show.setShowId(id);
		show.setScreen(screen);
		show.setMovie(movie);
		show.setShowStartTime(showStartTime);
		return show;
	}
}
