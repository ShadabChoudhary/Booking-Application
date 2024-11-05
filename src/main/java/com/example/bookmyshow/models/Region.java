package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;
//    private List<Theater> theaters; //removing list of theaters we can also get all the theaters from theater table

}
