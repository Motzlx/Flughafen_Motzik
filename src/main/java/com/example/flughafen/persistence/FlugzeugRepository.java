package com.example.flughafen.persistence;

import com.example.flughafen.model.Flugzeug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Save airplanes
@Repository
public interface FlugzeugRepository extends JpaRepository<Flugzeug, Long> {
}
