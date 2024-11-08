package com.example.demo.service;


import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.port.outbound.ChargeDetailRecordStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeDetailRecordService {

    private final ChargeDetailRecordStorage chargeDetailRecordStorage;

    public ChargeDetailRecordService(ChargeDetailRecordStorage chargeDetailRecordStorage) {
        this.chargeDetailRecordStorage = chargeDetailRecordStorage;
    }

    public ChargeDetailRecord create(ChargeDetailRecord chargeDetailRecord) {
        return chargeDetailRecordStorage.save(chargeDetailRecord);
    }

    public Optional<ChargeDetailRecord> getById(Long id) {
        return chargeDetailRecordStorage.findById(id);
    }

    public List<ChargeDetailRecord> getAllChargeDetailForVehicle(String vehicleId) {
        return chargeDetailRecordStorage.findAllByVehicleIdentificationOrderByStartTimeAsc(vehicleId);

    }

}
