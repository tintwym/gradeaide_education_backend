package com.gradeaide.api.repository;

import com.gradeaide.api.entity.ServiceOffering;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {
    List<ServiceOffering> findAllByOrderByDisplayOrderAsc();
}
