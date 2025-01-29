package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.ScreenAlreadyExistException;
import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public SeatService

    public List<Seat> addSeat(long screenId, int row, int col) throws ScreenAlreadyExistException {
        List<Seat> seats = new ArrayList<Seat>();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                //generating seat number and checking if its already present in the screen or not
                String seatNumber = (char)('A'+ i) + String.valueOf(j + 1);
                Optional<Seat> seatNoOptional = seatRepository.findBySeatNumberAndId(seatNumber, screenId);
                if(seatNoOptional.isPresent()){
                    throw new ScreenAlreadyExistException("SeatNumber: "+ seatNumber + " already exist");
                }

                Seat seat = new Seat();
                seat.setRowVal(i);
                seat.setColVal(j);
                seat.setSeatNumber(seatNumber);//generating seat number eg: A1, 2, 3; B1, 2, 3
                seat.setSeatType(SeatType.SILVER);

                seats.add(seat);
            }
        }
        seatRepository.saveAll(seats);

        return seats;
    }
}
