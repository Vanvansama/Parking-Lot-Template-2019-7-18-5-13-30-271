package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingOrders;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingOrderController.class)
class ParkingOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingOrderService parkingOrderService;

    @Test
    void should_return_order_when_parking_car_given_car() throws Exception {
        ParkingOrders parkingOrders = new ParkingOrders("stefan","YD123567");
        when(parkingOrderService.parking(anyString())).thenReturn(parkingOrders);

        ResultActions resultActions = mockMvc.perform(post("/parking/YD123567"));
        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("stefan")));
    }

    @Test
    void should_return_fetch_car_when_fetch_car_given_order() throws Exception {
        ParkingOrders parkingOrders = new ParkingOrders("stefan","YD123567");
        when(parkingOrderService.fetch(anyString())).thenReturn(parkingOrders);

        ResultActions resultActions = mockMvc.perform(get("/fetch/1234"));

        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("stefan")));
    }


}