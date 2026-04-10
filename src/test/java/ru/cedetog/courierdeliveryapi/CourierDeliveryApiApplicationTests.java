package ru.cedetog.courierdeliveryapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CourierDeliveryApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnApiInfo() throws Exception {
		mockMvc.perform(get("/api"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.project").value("courier-delivery-api"))
			.andExpect(jsonPath("$.endpoints[0]").value("/api"));
	}

	@Test
	void shouldReturnCouriers() throws Exception {
		mockMvc.perform(get("/api/couriers"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name").value("Ivan Petrov"))
			.andExpect(jsonPath("$[1].status").value("AVAILABLE"));
	}

	@Test
	void shouldReturnActiveOrders() throws Exception {
		mockMvc.perform(get("/api/orders/active"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].status").value("ON_THE_WAY"))
			.andExpect(jsonPath("$[1].status").value("ASSIGNED"));
	}

	@Test
	void shouldReturnNotFoundForMissingCourier() throws Exception {
		mockMvc.perform(get("/api/couriers/99"))
			.andExpect(status().isNotFound());
	}

}
