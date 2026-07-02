package com.gradeaide.api.controller;

import com.gradeaide.api.entity.ServiceOffering;
import com.gradeaide.api.repository.ServiceOfferingRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceOfferingRepository serviceOfferingRepository;

    public ServiceController(ServiceOfferingRepository serviceOfferingRepository) {
        this.serviceOfferingRepository = serviceOfferingRepository;
    }

    @GetMapping
    public List<ServiceOffering> list() {
        return serviceOfferingRepository.findAllByOrderByDisplayOrderAsc();
    }
}
