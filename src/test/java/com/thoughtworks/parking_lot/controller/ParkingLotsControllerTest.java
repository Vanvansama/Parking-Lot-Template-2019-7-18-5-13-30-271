package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLots;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
public class ParkingLotsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    void should_return_parking_lot_when_save_given_parking_lot() throws Exception {
        ParkingLots parkingLots = new ParkingLots("stefan",50,20);
        when(parkingLotService.save(any())).thenReturn(parkingLots);

        ResultActions resultActions = mockMvc.perform(post("/parking-lot"));
        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("stefan")));
    }

    @Test
    void should_return_parking_lot_when_delete_given_parking_lot() throws Exception {
        ParkingLots parkingLots = new ParkingLots("stefan",50,20);
        when(parkingLotService.findById(anyInt())).thenReturn(parkingLots);

        ResultActions resultActions = mockMvc.perform(delete("/parking-lot/123456"));

        verify(parkingLotService).delete(anyInt());
    }

    @Test
    void should_return_page_when_findByPage_given_page_and_page_size() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/parking-lot?page=1&pageSize=2"));
        verify(parkingLotService).findByPage(anyInt(),anyInt());
    }

    @Test
    void should_return_parking_lot_when_update_given_parking_lot() throws Exception {
        ParkingLots parkingLot = new ParkingLots(123,"stefan",20,10);
        when(parkingLotService.update(anyInt(),any())).thenReturn(parkingLot);

        ResultActions resultActions = mockMvc.perform(post("/parking-lot/123")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\"id\":\"123\",\n" +
                        "\"name\":\"ste\",\n" +
                        "}"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(parkingLot.getId())));
    }

}
