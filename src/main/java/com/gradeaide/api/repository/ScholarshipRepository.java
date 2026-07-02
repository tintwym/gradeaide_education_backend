package com.gradeaide.api.repository;

import com.gradeaide.api.entity.Scholarship;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
    List<Scholarship> findAllByOrderByDisplayOrderAsc();
}
