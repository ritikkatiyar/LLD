import Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    private Map<City, List<Theatre>> cityTheatreMap;
    private List<Theatre> theatres;

    public TheatreController(){
        cityTheatreMap=new HashMap<>();
        theatres=new ArrayList<>();
    }
    public void addTheatre(Theatre theatre,City city){
        theatres.add(theatre);
        cityTheatreMap.computeIfAbsent(city,k->new ArrayList<>())
                .add(theatre);
    }
    public Map<Theatre,List<Show>> getAllShows(Movie movie,City city){
        Map<Theatre,List<Show>> theatreShowMap=new HashMap<>();

        List<Theatre> theatreList=new ArrayList<>();
        for(Theatre theatre:theatreList){
            List<Show> givenMovieShows=new ArrayList<>();
            List<Show> show=theatre.getShows();

            for(Show show1:show){
                if(show1.getMovie().getMovieId()== movie.getMovieId()){
                    givenMovieShows.add(show1);
                }
            }
            if(!givenMovieShows.isEmpty()){
                theatreShowMap.put(theatre,givenMovieShows);
            }
        }
        return theatreShowMap;
    }
}
