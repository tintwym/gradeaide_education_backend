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
@Table(name = "scholarships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String title;

    @Column(name = "funding_amount", nullable = false)
    private String fundingAmount;

    @Column(nullable = false)
    private String deadline;

    @Column(name = "apply_url", length = 500)
    private String applyUrl;

    @Column(name = "display_order")
    private Integer displayOrder;
}
