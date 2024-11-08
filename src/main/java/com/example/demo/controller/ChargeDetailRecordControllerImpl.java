package com.example.demo.controller;

import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.dto.ChargeDetailRecordDTO;
import com.example.demo.mapping.MappingService;
import com.example.demo.port.inbound.ChargeDetailRecordPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChargeDetailRecordControllerImpl implements ChargeDetailRecordController {

    private final ChargeDetailRecordPort chargeDetailRecordPort;
    private final MappingService mappingService;


    @Override
    public ChargeDetailRecordDTO createChargeDetailRecord(ChargeDetailRecord chargeDetailRecord,
                                                          HttpServletRequest request,
                                                          HttpServletResponse response) {

        var createdChargeDetailRecord = chargeDetailRecordPort.create(chargeDetailRecord);
        ChargeDetailRecordDTO chargeDetailRecordDTO = mappingService.mapChargeDetailRecordToChargeDetailRecordDTO(createdChargeDetailRecord);

        response.setStatus(HttpServletResponse.SC_CREATED);

        return chargeDetailRecordDTO;
    }


    @Override
    public ChargeDetailRecordDTO getChargeDetailRecord(Long id, HttpServletResponse response) {
        ChargeDetailRecord chargeDetailRecord = chargeDetailRecordPort.getById(id);
        ChargeDetailRecordDTO chargeDetailRecordDTO = mappingService.mapChargeDetailRecordToChargeDetailRecordDTO(chargeDetailRecord);
        response.setStatus(HttpServletResponse.SC_OK);

        return chargeDetailRecordDTO;

    }


    @Override
    public List<ChargeDetailRecordDTO> getAllChargeDetailRecordsForVehicle(String vehicleId, HttpServletResponse response) {

        List<ChargeDetailRecord> chargeDetailRecord = chargeDetailRecordPort.getListOfChargeDetailForVehicle(vehicleId);
        List<ChargeDetailRecordDTO> chargeDetailRecordDTOS = mappingService.mapChargeDetailRecordsToChargeDetailRecordDTOs(chargeDetailRecord);
        response.setStatus(HttpServletResponse.SC_OK);

        return chargeDetailRecordDTOS;
    }

}
