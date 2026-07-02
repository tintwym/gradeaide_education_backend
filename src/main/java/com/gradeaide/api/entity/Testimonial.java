package com.gradeaide.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "testimonials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String university;

    @Column(nullable = false, length = 1000)
    private String quote;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Column(name = "display_order")
    private Integer displayOrder;
}
