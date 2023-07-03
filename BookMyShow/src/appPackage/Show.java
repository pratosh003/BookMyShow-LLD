package appPackage;

import java.util.ArrayList;
import java.util.List;

public class Show {
	int showId;
	Movie movie;
	Screen screen;
	int showStartTime;
	List<Integer> bookedSeats = new ArrayList<>();
	
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public int getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(int showStartTime) {
		this.showStartTime = showStartTime;
	}
	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	
	
	
}
