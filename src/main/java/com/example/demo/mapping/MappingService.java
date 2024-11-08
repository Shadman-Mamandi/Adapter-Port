package com.example.demo.mapping;

import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.dto.ChargeDetailRecordDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is responsible for mapping entities to DTOs
 */

@Service
public class MappingService {

    public ChargeDetailRecordDTO mapChargeDetailRecordToChargeDetailRecordDTO(ChargeDetailRecord chargeDetailRecord){
        ChargeDetailRecordDTO chargeDetailRecordDTO = new ChargeDetailRecordDTO();
        chargeDetailRecordDTO.setSessionIdentification(chargeDetailRecord.getSessionIdentification());
        chargeDetailRecordDTO.setVehicleIdentification(chargeDetailRecord.getVehicleIdentification());
        chargeDetailRecordDTO.setStartTime(chargeDetailRecord.getStartTime());
        chargeDetailRecordDTO.setEndTime(chargeDetailRecord.getEndTime());
        chargeDetailRecordDTO.setTotalCost(chargeDetailRecord.getTotalCost());
        return chargeDetailRecordDTO;
    }

    public List<ChargeDetailRecordDTO> mapChargeDetailRecordsToChargeDetailRecordDTOs(List<ChargeDetailRecord> chargeDetailRecords){
        List<ChargeDetailRecordDTO> chargeDetailRecordDTOList = new  ArrayList<>();

        chargeDetailRecords.forEach((chargeDetailRecord)->{
                    ChargeDetailRecordDTO chargeDetailRecordDTO = new ChargeDetailRecordDTO();
                    chargeDetailRecordDTO.setSessionIdentification(chargeDetailRecord.getSessionIdentification());
                    chargeDetailRecordDTO.setVehicleIdentification(chargeDetailRecord.getVehicleIdentification());
                    chargeDetailRecordDTO.setStartTime(chargeDetailRecord.getStartTime());
                    chargeDetailRecordDTO.setEndTime(chargeDetailRecord.getEndTime());
                    chargeDetailRecordDTO.setTotalCost(chargeDetailRecord.getTotalCost());
                    chargeDetailRecordDTOList.add(chargeDetailRecordDTO);
                });

       return chargeDetailRecordDTOList;
    }
}
