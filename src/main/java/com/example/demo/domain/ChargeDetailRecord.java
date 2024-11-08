package com.example.demo.domain;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;


@Getter
@Setter
@Builder
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChargeDetailRecord {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String sessionIdentification;
  private String vehicleIdentification;
  private OffsetDateTime startTime;
  private OffsetDateTime endTime;
  private Double totalCost;

}
