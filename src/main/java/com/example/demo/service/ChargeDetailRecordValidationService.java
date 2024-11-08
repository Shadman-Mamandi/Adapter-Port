package com.example.demo.service;


import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.port.outbound.ChargeDetailRecordStorage;
import com.example.demo.validation.Creation;
import com.example.demo.validation.CreationStartAndEndTimeValidator;
import com.example.demo.validation.CreationStartTimeBiggerLastRecordEndTimeValidator;
import com.example.demo.validation.CreationTotalCostMustBeGreaterZero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * The class is a validation service which run all the rules and conditions on Fields
 * to be called before the main logics, therefore if any of the conditions are failed,
 * an exception will return and the endpoints will be faster and each of the conditions
 * are separated classes
 */

@Service
@RequiredArgsConstructor
public class ChargeDetailRecordValidationService implements ValidationService<ChargeDetailRecord> {


    private final ChargeDetailRecordStorage accountDataStorage;

    void validateFieldForCreation(ChargeDetailRecord chargeDetailRecord) {
        this.evaluateFieldErrors(chargeDetailRecord, Creation.class);
    }

    void validateRulesForCreation(ChargeDetailRecord chargeDetailRecord) {

        ArrayList creationConditions = new ArrayList<>();
        creationConditions.add(new CreationStartAndEndTimeValidator());
        creationConditions.add(new CreationStartTimeBiggerLastRecordEndTimeValidator(accountDataStorage));
        creationConditions.add(new CreationTotalCostMustBeGreaterZero());


        this.evaluateRuleErrors(creationConditions,
                validationRule -> validationRule.validate(chargeDetailRecord, chargeDetailRecord.getId()));
    }

}
