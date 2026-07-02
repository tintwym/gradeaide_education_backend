package com.gradeaide.api.controller;

import com.gradeaide.api.entity.Testimonial;
import com.gradeaide.api.repository.TestimonialRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    private final TestimonialRepository testimonialRepository;

    public TestimonialController(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @GetMapping
    public List<Testimonial> list() {
        return testimonialRepository.findAllByOrderByDisplayOrderAsc();
    }
}
