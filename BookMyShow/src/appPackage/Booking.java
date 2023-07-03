package appPackage;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	Show show;
	List<Seat> bookeadSeats = new ArrayList<>();
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public List<Seat> getBookeadSeats() {
		return bookeadSeats;
	}
	public void setBookeadSeats(List<Seat> bookeadSeats) {
		this.bookeadSeats = bookeadSeats;
	}
	
	
	
	
}
