package com.gradeaide.api.controller;

import com.gradeaide.api.entity.Destination;
import com.gradeaide.api.repository.DestinationRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationRepository destinationRepository;

    public DestinationController(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @GetMapping
    public List<Destination> list() {
        return destinationRepository.findAllByOrderByDisplayOrderAsc();
    }
}
