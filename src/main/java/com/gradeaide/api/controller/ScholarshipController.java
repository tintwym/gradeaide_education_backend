package com.gradeaide.api.controller;

import com.gradeaide.api.entity.Scholarship;
import com.gradeaide.api.repository.ScholarshipRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scholarships")
public class ScholarshipController {

    private final ScholarshipRepository scholarshipRepository;

    public ScholarshipController(ScholarshipRepository scholarshipRepository) {
        this.scholarshipRepository = scholarshipRepository;
    }

    @GetMapping
    public List<Scholarship> list() {
        return scholarshipRepository.findAllByOrderByDisplayOrderAsc();
    }
}
