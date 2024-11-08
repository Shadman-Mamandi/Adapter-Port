package com.test.chargeDetailRecord;


import com.example.demo.DemoApplication;
import com.example.demo.domain.ChargeDetailRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ChargeDetailRecordIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private ChargeDetailRecord chargeDetailRecord;
    @LocalServerPort
    private int port;

    @BeforeEach
    void init(){
        chargeDetailRecord = ChargeDetailRecord.builder().id(1L).sessionIdentification("2545l").vehicleIdentification("1111")
                .startTime(OffsetDateTime.now().minusDays(1))
                .endTime(OffsetDateTime.now()).totalCost(120.12).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void createChargeDetailRecord() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        Obj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Obj.registerModule(new JavaTimeModule());
        String jsonStr = Obj.writeValueAsString(chargeDetailRecord);

        mockMvc
                .perform(
                        post(createUrl("/chargeDetail"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStr)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void getChargeDetailRecordById() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        Obj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Obj.registerModule(new JavaTimeModule());
        String jsonStr = Obj.writeValueAsString(chargeDetailRecord);
        mockMvc
                .perform(
                        post(createUrl("/chargeDetail"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStr)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


        String body = mockMvc
                .perform(
                        get(createUrl("/chargeDetail/chargeRecord/"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("id", String.valueOf(1L))
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        System.out.println(body);

        Assertions.assertNotNull(body);
        assert body.contains("2545l");

    }

    @Test
    void getAllChargeDetailRecordByVehicleId() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        Obj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Obj.registerModule(new JavaTimeModule());
        String jsonStr = Obj.writeValueAsString(chargeDetailRecord);
        mockMvc
                .perform(
                        post(createUrl("/chargeDetail"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStr)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


        var body = mockMvc
                .perform(
                        get(createUrl("/chargeDetail/chargeRecords/{vehicleId}"),"1111")
                                .contentType(MediaType.APPLICATION_JSON)
                                 .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        System.out.println(body);

        Assertions.assertNotNull(body);
        assert body.contains("2545l");

    }
    public String createUrl(String uri) { return "http://localhost:" + port + uri;}
}



