package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.service.ShowService;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {

    final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public CreateShowResponseDto createShow(CreateShowRequestDto createShowRequestDto){
        CreateShowResponseDto createShowResponseDto = new CreateShowResponseDto();
        try{
            Show show = showService.createShow(
                    createShowRequestDto.getMovieId(),
                    createShowRequestDto.getScreenId(),
                    createShowRequestDto.getStartTime(),
                    createShowRequestDto.getEndTime(),
                    createShowRequestDto.getFeature(),
                    createShowRequestDto.getUserId()//only for authentication
            );
            createShowResponseDto.setShow(show);
            createShowResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (Exception e){
            createShowResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return createShowResponseDto;
    }

    public GetShowResponseDto getShowResponseDto(GetShowRequestDto getShowRequestDto){
        GetShowResponseDto responseDto = new GetShowResponseDto();
        try{
            Show show = showService.getShow(getShowRequestDto.getShowId());
            responseDto.setShowId(show.getId());
            responseDto.setMovieName(show.getMovie().getTitle());
            responseDto.setStartTime(show.getStartTime());
            responseDto.setEndTime(show.getEndTime());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
