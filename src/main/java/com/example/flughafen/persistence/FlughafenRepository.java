package com.example.flughafen.persistence;

import com.example.flughafen.model.Flughafen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlughafenRepository extends JpaRepository<Flughafen,Long> {


}
