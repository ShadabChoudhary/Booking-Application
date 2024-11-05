package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.ShowNotFoundException;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.BookingRespository;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    BookingRespository bookingRespository;
    PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository, BookingRespository bookingRespository,
                            PriceCalculationService priceCalculationService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRespository = bookingRespository;
        this.priceCalculationService = priceCalculationService;
    }

    //This method going to be used at different classes across this application
    //passing individual values making this method loosely coupled and easy to accessible
    public Booking Book(Long userId, Long showId, List<Long> seatIds) throws UserNotFoundException,
            ShowNotFoundException, ShowSeatNotAvailableException {

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        //if available get the user
        User user = userOptional.get();

        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new ShowNotFoundException("Show not found");
        }
        //if show is available get the show
        Show show = showOptional.get();
        Booking booking = new Booking();

        synchronized (this){
            List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);
            for(ShowSeat showSeat : showSeats){
                if(!showSeat.getSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                    throw new ShowSeatNotAvailableException("Seat is not Available");
                }
            }
            //changing the status as blocked if seats are available
            for(ShowSeat showSeat : showSeats){
                showSeat.setSeatStatus(ShowSeatStatus.BLOCKED);
            }

            booking.setUser(user);
            booking.setCreatedAt(new Date());
            booking.setShowSeat(showSeats);
            booking.setAmount(priceCalculationService.CalculatePrice(showSeats, show));

            bookingRespository.save(booking);

        }
        return booking;
    }
}
