package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    private Date bookedAt;

    @OneToMany
    private List<ShowSeat> showSeat;

    @Enumerated(EnumType.ORDINAL)//saves the enums in numeric values eg: 0,1,2
    private BookingStatus bookingStatus;
    private int amount;

    @OneToMany
    private List<Payment> payments;
}
