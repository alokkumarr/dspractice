package systemdesign.bookmyshow;

import java.util.Date;
import java.util.List;

public interface BMSService {
    public List<CinemaHall> cinemaHallList();

    public List<Movies> getMovies(Date date, City city);
    public List<CinemaHall> getCinemaHall(City city);
}
