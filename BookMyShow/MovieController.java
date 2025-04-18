import Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovieMap;
    List<Movie> allMovies;

    MovieController(){
        cityMovieMap=new HashMap<>();
        allMovies=new ArrayList<>();
    }
    void addMovie(Movie movie,City city){
        allMovies.add(movie);
        cityMovieMap.computeIfAbsent(city,k->new ArrayList<>()).add(movie);
    }
    Movie getMovieByName(String movieName){
        for(Movie movie:allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }
}

