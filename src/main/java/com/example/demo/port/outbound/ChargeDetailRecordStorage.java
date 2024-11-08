package com.example.demo.port.outbound;

import com.example.demo.domain.ChargeDetailRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface ChargeDetailRecordStorage extends JpaRepository<ChargeDetailRecord, Long> {

    List<ChargeDetailRecord> findAllByVehicleIdentificationOrderByStartTimeAsc(String vehicleId);


}
