package com.example.flughafen.persistence;

import com.example.flughafen.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

// save countries
public interface CountryRepository extends JpaRepository<Country,Long> {

}
