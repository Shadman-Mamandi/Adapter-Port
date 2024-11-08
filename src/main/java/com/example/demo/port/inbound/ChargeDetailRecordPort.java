package com.example.demo.port.inbound;



import com.example.demo.domain.ChargeDetailRecord;

import java.util.List;



public interface ChargeDetailRecordPort {

    ChargeDetailRecord create(ChargeDetailRecord chargeDetailRecord);

    ChargeDetailRecord getById(Long chargeDetailRecordId);

    List<ChargeDetailRecord> getListOfChargeDetailForVehicle(String vehicleId);

}
