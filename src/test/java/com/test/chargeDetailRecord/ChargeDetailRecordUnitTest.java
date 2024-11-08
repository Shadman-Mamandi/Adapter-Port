package com.test.chargeDetailRecord;



import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.port.outbound.ChargeDetailRecordStorage;
import com.example.demo.service.ChargeDetailRecordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargeDetailRecordUnitTest {

    @InjectMocks
    private ChargeDetailRecordService chargeDetailRecordService;
    @Mock
    private  ChargeDetailRecordStorage chargeDetailRecordStorage;

    private ChargeDetailRecord chargeDetailRecord;


    @BeforeEach
    void init(){
        chargeDetailRecord = ChargeDetailRecord.builder().id(1L).sessionIdentification("2545l").vehicleIdentification("1111")
                .startTime(OffsetDateTime.now().minusDays(1))
                .endTime(OffsetDateTime.now()).totalCost(120.12).build();

    }

    @Test
    void createChargeDetailRecord_Created() {

        when(chargeDetailRecordStorage.save(any())).thenReturn(chargeDetailRecord);
        Assertions.assertEquals(chargeDetailRecordService.create(any()),chargeDetailRecord);

    }

    @Test
    void getChargeDetailRecordById_Ok() throws Exception {

        when(chargeDetailRecordStorage.findById(any())).thenReturn(Optional.of(chargeDetailRecord));
        Assertions.assertEquals(chargeDetailRecordService.getById(any()),Optional.of(chargeDetailRecord));

    }

    @Test
    void getAllChargeDetailForVehicle_Ok() throws Exception {

        when(chargeDetailRecordStorage.findAllByVehicleIdentificationOrderByStartTimeAsc(any())).thenReturn(List.of(chargeDetailRecord));
        Assertions.assertEquals(chargeDetailRecordService.getAllChargeDetailForVehicle(any()),List.of(chargeDetailRecord));

    }
}
