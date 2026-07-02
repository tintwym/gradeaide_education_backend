package com.gradeaide.api.repository;

import com.gradeaide.api.entity.ConsultationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRequestRepository extends JpaRepository<ConsultationRequest, Long> {
}
