package com.example.demo.validation;


import com.example.demo.domain.ChargeDetailRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.Optional;

@RequiredArgsConstructor
public class CreationStartAndEndTimeValidator implements ValidationRule<ChargeDetailRecord> {


    @Override
    public Optional<FieldError> validate(ChargeDetailRecord chargeDetailRecord, Long id) {
        if (chargeDetailRecord.getEndTime().isBefore(chargeDetailRecord.getStartTime())) {
            return Optional.of(
                    new FieldError("ChargeDetailRecord", "EndTime",
                            "The End time cannot be smaller than Start time")
            );
        }
        return Optional.empty();
    }
}
