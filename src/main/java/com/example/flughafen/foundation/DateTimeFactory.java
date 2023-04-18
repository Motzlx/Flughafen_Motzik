package com.example.flughafen.foundation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


//factory for getting times and dates
@Component

public class DateTimeFactory {


  // local time and date
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
  // local date
    public LocalDate today() {
        return LocalDate.now();
    }
  // local time
    public LocalTime currentTime() {
        return LocalTime.now();
    }
}
