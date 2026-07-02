package com.gradeaide.api.repository;

import com.gradeaide.api.entity.Testimonial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    List<Testimonial> findAllByOrderByDisplayOrderAsc();
}
