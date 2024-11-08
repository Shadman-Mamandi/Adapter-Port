package com.example.demo.service;


import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.port.inbound.ChargeDetailRecordPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class has both validation service and main logic service inside and is an
 * implementation of inbound port. it supports the Hexagonal architecture
 */

@Service
@RequiredArgsConstructor
public class ChargeDetailRecordAdapter implements ChargeDetailRecordPort {

    private final ChargeDetailRecordValidationService chargeDetailRecordValidationService;

    private final ChargeDetailRecordService accountService;

    @Override
    public ChargeDetailRecord create(ChargeDetailRecord chargeDetailRecord) {

        chargeDetailRecordValidationService.validateFieldForCreation(chargeDetailRecord);

        chargeDetailRecordValidationService.validateRulesForCreation(chargeDetailRecord);

        return accountService.create(chargeDetailRecord);
    }

    @Override
    public ChargeDetailRecord getById(Long id) {
        return accountService.getById(id).get();
    }

    @Override
    public List<ChargeDetailRecord> getListOfChargeDetailForVehicle(String vehicleId) {

        List<ChargeDetailRecord> allChargeDetailForVehicle = accountService.getAllChargeDetailForVehicle(vehicleId);
        return allChargeDetailForVehicle;
    }


}
