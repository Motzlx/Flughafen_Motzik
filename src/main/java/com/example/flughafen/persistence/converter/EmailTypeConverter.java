package com.example.flughafen.persistence.converter;

import com.example.flughafen.model.EmailType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)

public class EmailTypeConverter extends AbstractEnumToStringConverter<EmailType> {

    protected EmailTypeConverter() {

        super((o) -> switch (o) {
            case BUSINESS -> "B";
            case PRIVATE -> "P";
        }, (v) -> switch (v) {
            case "B" -> EmailType.BUSINESS;
            case "P" -> EmailType.PRIVATE;
            //    default -> null;
            default -> throw new IllegalArgumentException("Data Quality Problem in DB: %s is not a vlaid orientation value!".formatted(v));
        });
    }
}