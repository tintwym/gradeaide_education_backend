package com.gradeaide.api.controller;

import com.gradeaide.api.dto.ConsultationRequestDto;
import com.gradeaide.api.entity.ConsultationRequest;
import com.gradeaide.api.repository.ConsultationRequestRepository;
import jakarta.validation.Valid;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ConsultationRequestRepository consultationRequestRepository;

    public ConsultationController(ConsultationRequestRepository consultationRequestRepository) {
        this.consultationRequestRepository = consultationRequestRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultationRequest create(@Valid @RequestBody ConsultationRequestDto dto) {
        ConsultationRequest request = Objects.requireNonNull(ConsultationRequest.builder()
                .fullName(dto.fullName())
                .email(dto.email())
                .message(dto.message())
                .build());
        return Objects.requireNonNull(consultationRequestRepository.save(request));
    }
}
