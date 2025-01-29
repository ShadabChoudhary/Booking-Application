package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.ResponseStatus;
import com.example.bookmyshow.dto.ScreenRequestDto;
import com.example.bookmyshow.dto.ScreenResponseDto;
import com.example.bookmyshow.models.Screen;
import com.example.bookmyshow.service.ScreenService;
import org.springframework.stereotype.Controller;

@Controller
public class ScreenController {
    private ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    public ScreenResponseDto addScreenDto(ScreenRequestDto screenRequestDto) {
        ScreenResponseDto responseDto = new ScreenResponseDto();
        try {
            Screen screen = screenService.addScreen(
                    screenRequestDto.getTitle(),
                    screenRequestDto.getFeatures(),
                    screenRequestDto.getRow(),
                    screenRequestDto.getColumn()
            );

            responseDto.setScreenId(screen.getId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Successfully added screen");
        }catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }
}
