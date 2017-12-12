package com.theapprenticewizard.aspectlogging.model.service;

import com.theapprenticewizard.aspectlogging.model.Bird;
import com.theapprenticewizard.aspectlogging.model.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    public BirdServiceImpl(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public List<Bird> findAll() {
        return birdRepository.findAll();
    }
}
