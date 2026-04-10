package ru.cedetog.courierdeliveryapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.cedetog.courierdeliveryapi.model.ApiInfoResponse;

@RestController
@RequestMapping("/api")
public class InfoController {

	@GetMapping
	public ApiInfoResponse getApiInfo() {
		return new ApiInfoResponse(
			"courier-delivery-api",
			"Simple demo REST API for courier delivery management",
			"0.0.1-SNAPSHOT",
			List.of(
				"/api",
				"/api/couriers",
				"/api/couriers/{id}",
				"/api/orders",
				"/api/orders/active"
			)
		);
	}

}
