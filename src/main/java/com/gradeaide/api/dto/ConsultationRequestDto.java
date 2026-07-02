package com.gradeaide.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ConsultationRequestDto(
        @NotBlank @Size(max = 120) String fullName,
        @NotBlank @Email @Size(max = 255) String email,
        @NotBlank @Size(max = 2000) String message
) {
}
