package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel{
    //Can make this class enum if we know all the seat type
    private String value;
}
