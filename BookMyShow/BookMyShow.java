import Enums.City;
import Enums.SeatCategory;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow(){
        movieController=new MovieController();
        theatreController=new TheatreController();
    }
    public static void main(String args[]){
        BookMyShow show=new BookMyShow();
        show.initialize();

        //user 1
        show.createBooking(City.Bangalore,"AVENGERS");
    }

    private void initialize(){
        createMovies();
        createTheatre();

    }
    private void createBooking(City city,String movieName){
        //search movie by my location
        List<Movie> movies=movieController.getMovieByCity(city);

        //select the movie which you want to see
        Movie interestedMovie=null;
        for(Movie movie:movies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie=movie;
            }
        }

        //get all shows of this movie in bangalore location
        Map<Theatre,List<Show>> showTheatreWise=theatreController.getAllShows(interestedMovie,city);

        //select the particular show user interested in
        Map.Entry<Theatre,List<Show>> entry=showTheatreWise.entrySet().iterator().next();
        List<Show> runningShows=entry.getValue();
        Show interestedShow=runningShows.get(0);

        //select the seat
        int seat=30;
        List<Integer> bookedSeats=interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seat)){
            bookedSeats.add(seat);

            Booking booking=new Booking();
            List<Seat> myBookedSeat=new ArrayList<>();
            for(Seat screenSeat:interestedShow.getScreen().getSeats()){
                if(screenSeat.getSeatId()==seat){
                    myBookedSeat.add(screenSeat);
                }
            }
            booking.setSeats(myBookedSeat);
            booking.setShow(interestedShow);
        }else{
            System.out.println("Seat Already Booked Try Again");
            return;
        }
        System.out.println("BOOKING SUCCESSFULL");

    }
    private void createTheatre(){

        Movie avengerMovie=movieController.getMovieByName("AVENGERS");
        Movie bahubliMovie=movieController.getMovieByName("BAHUBALI");

        Theatre inoxTheatre=new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setCity(City.Bangalore);
        inoxTheatre.setScreens(createScreen());
        List<Show> inoxShows=new ArrayList<>();
        Show inoxMorningShow=createShows(1,inoxTheatre.getScreens().get(0),avengerMovie,8);
        Show inoxEveningShow=createShows(2,inoxTheatre.getScreens().get(0),bahubliMovie,16);
        inoxShows.add(inoxEveningShow);
        inoxShows.add(inoxMorningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre=new Theatre();
        pvrTheatre.setTheatreId(1);
        pvrTheatre.setCity(City.Delhi);
        pvrTheatre.setScreens(createScreen());
        List<Show> pvrShows=new ArrayList<>();
        Show pvrMorningShow=createShows(1,inoxTheatre.getScreens().get(0),avengerMovie,8);
        Show pvrEveningShow=createShows(2,inoxTheatre.getScreens().get(0),bahubliMovie,16);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre,City.Bangalore);
        theatreController.addTheatre(pvrTheatre,City.Delhi);
    }

    private List<Screen> createScreen() {
       List<Screen> screens=new ArrayList<>();
       Screen screen1=new Screen();
       screen1.setId(1);
       screen1.setSeats(createSeats());
       screens.add(screen1);

       return screens;
    }
    private Show createShows(int showId,Screen screen,Movie movie,int showStartTime){
        Show show=new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        // Platinum seats: 1 to 30
        for (int i = 1; i <= 30; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(i / 10 + 1); // Grouping by row, optional
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        // Gold seats: 31 to 70
        for (int i = 31; i <= 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(i / 10 + 1);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        // Silver seats: 71 to 100
        for (int i = 71; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(i / 10 + 1);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        return seats;
    }


    private void createMovies(){
        //create movie 1
        Movie avengers=new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDuration(128);

        //create movie 2
        Movie bahubali=new Movie();
        bahubali.setMovieId(2);
        bahubali.setMovieName("BAHUBALI");
        bahubali.setMovieDuration(130);

        //add movie to movie controller
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers,City.Delhi);

        movieController.addMovie(bahubali,City.Bangalore);
        movieController.addMovie(bahubali,City.Delhi);
    }
}
