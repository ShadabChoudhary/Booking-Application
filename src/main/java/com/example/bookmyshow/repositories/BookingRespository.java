package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRespository extends JpaRepository<Booking, Long> {

    Booking save(Booking booking);
}
