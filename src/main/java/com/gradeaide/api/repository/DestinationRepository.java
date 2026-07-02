package com.gradeaide.api.repository;

import com.gradeaide.api.entity.Destination;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findAllByOrderByDisplayOrderAsc();

    Optional<Destination> findByName(String name);
}
