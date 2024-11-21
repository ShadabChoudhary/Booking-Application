package com.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetShowResponseDto {
    private Long showId;
    private String movieName;
    private int startTime;
    private int endTime;
    private ResponseStatus responseStatus;
}
