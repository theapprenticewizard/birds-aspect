package com.theapprenticewizard.aspectlogging.application.controller;

import com.theapprenticewizard.aspectlogging.model.Bird;
import com.theapprenticewizard.aspectlogging.model.service.BirdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/v1/birds")
public class BirdController {

    private final BirdService birdService;

    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    @GetMapping
    public List<Bird> findAll() {
        return birdService.findAll();
    }
}
