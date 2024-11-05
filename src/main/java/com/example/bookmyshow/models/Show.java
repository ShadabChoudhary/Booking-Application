package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "shows") // show is a reserved keyword for JPA since using "shows" for table creation
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private int startTime;
    private int endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection//stores the collection of enums creating a separate table
    private List<Feature> features;
}
