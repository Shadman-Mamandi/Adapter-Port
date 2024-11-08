package com.example.demo.dto;

import lombok.*;

import java.time.OffsetDateTime;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChargeDetailRecordDTO {
    private String sessionIdentification;
    private String vehicleIdentification;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private Double totalCost;
}
