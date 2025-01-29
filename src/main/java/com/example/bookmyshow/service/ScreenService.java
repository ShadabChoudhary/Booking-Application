package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.ScreenAlreadyExistException;
import com.example.bookmyshow.models.Feature;
import com.example.bookmyshow.models.Screen;
import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.repositories.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {

    private ScreenRepository screenRepository;
    private SeatService seatService;

    public ScreenService(ScreenRepository screenRepository, SeatService seatService) {
        this.screenRepository = screenRepository;
        this.seatService = seatService;
    }

    public Screen addScreen(String name, List<String> features, int row, int col) throws ScreenAlreadyExistException {
        Optional<Screen> optionalScreen = screenRepository.findByName(name);
        if(optionalScreen.isPresent()){
            throw new ScreenAlreadyExistException("Screen " + name + " already Exist");
        }

        Screen screen = new Screen();
        screen.setName(name);
        List<Feature> featuresList = features.stream().
                                                map(feature -> Feature.valueOf(feature.toUpperCase())).toList();

        screen.setFeatures(featuresList);
        screen = screenRepository.save(screen);

        List<Seat> seat = seatService.addSeat(screen.getId(), row, col);
        screen.setSeats(seat);

        return screenRepository.save(screen);
    }
}
