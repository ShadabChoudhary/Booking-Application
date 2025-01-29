package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.MovieNotFoundException;
import com.example.bookmyshow.exceptions.ScreenNotFoundException;
import com.example.bookmyshow.exceptions.ShowNotFoundException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.MovieRepository;
import com.example.bookmyshow.repositories.ScreenRepository;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ShowService {
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;
    private ScreenRepository screenRepository;

    public ShowService(ShowRepository showRepository, UserRepository userRepository, MovieRepository movieRepository,
                       ScreenRepository screenRepository) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
    }

    public Show createShow(Long movieId, Long screenId, int startTime, int endTime, Feature feature, Long userId)
                            throws UserNotFoundException, MovieNotFoundException, ScreenNotFoundException {

        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));

        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new MovieNotFoundException("Movie Not Found"));

        Screen screen = screenRepository.findById(screenId).orElseThrow(()-> new ScreenNotFoundException("Screen Not Found"));
//        Show show = showRepository.findExistShow(movieId, screenId, startTime).orElseThrow()
        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setFeature(feature);

        return showRepository.save(show);
    }

    public Show getShow(Long showId) throws ShowNotFoundException {
        return showRepository.findById(showId).orElseThrow(()-> new ShowNotFoundException("Movie Not Found"));
    }
}
