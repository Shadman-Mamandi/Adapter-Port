package com.example.demo.controller;


import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.dto.ChargeDetailRecordDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * An interface for rest apis by configuration of swagger
 */

@Api(value = "Charge Detail Record API")
@RequestMapping(value = {"/chargeDetail"})
public interface ChargeDetailRecordController {

    @PostMapping
    ChargeDetailRecordDTO createChargeDetailRecord(
            @ApiParam(name = "chargeDetailRecord",
                    value = "the chargeDetailRecord object that should be created",
                    required = true)
            @Validated
            @RequestBody
                    ChargeDetailRecord chargeDetailRecord,
            HttpServletRequest request,
            HttpServletResponse response);


    @GetMapping("/chargeRecord/")
    ChargeDetailRecordDTO getChargeDetailRecord(
            @ApiParam(name = "chargeDetailRecord",
                    value = "the chargeDetailRecord object by id is returned",
                    required = true)
            @RequestParam("id")
                    Long id,
            HttpServletResponse response);


    @GetMapping("/chargeRecords/{vehicleId}")
    List<ChargeDetailRecordDTO> getAllChargeDetailRecordsForVehicle(
            @ApiParam(name = "chargeDetailRecords",
                    value = "all chargeDetailRecord objects are returned",
                    required = true)
            @PathVariable("vehicleId")
                    String vehicleId,
            HttpServletResponse response);

}
