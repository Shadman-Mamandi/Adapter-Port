package com.example.demo.validation;

import com.example.demo.domain.ChargeDetailRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.Optional;


@RequiredArgsConstructor

public class CreationTotalCostMustBeGreaterZero implements ValidationRule<ChargeDetailRecord> {
    @Override
    public Optional<FieldError> validate(ChargeDetailRecord chargeDetailRecord, Long id) {
        if (chargeDetailRecord.getTotalCost() <= 0) {
            return Optional.of(
                    new FieldError("ChargeDetailRecord", "Total Cost",
                            "The Total cost must be greater the 0")
            );
        }
        return Optional.empty();
    }
}
