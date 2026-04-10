package ru.cedetog.courierdeliveryapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ru.cedetog.courierdeliveryapi.model.CourierResponse;
import ru.cedetog.courierdeliveryapi.service.DemoDeliveryService;

@RestController
@RequestMapping("/api/couriers")
public class CourierController {

	private final DemoDeliveryService demoDeliveryService;

	public CourierController(DemoDeliveryService demoDeliveryService) {
		this.demoDeliveryService = demoDeliveryService;
	}

	@GetMapping
	public List<CourierResponse> getCouriers() {
		return demoDeliveryService.getCouriers();
	}

	@GetMapping("/{id}")
	public CourierResponse getCourierById(@PathVariable Long id) {
		return demoDeliveryService.findCourierById(id)
			.orElseThrow(() -> new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"Courier with id %d was not found".formatted(id)
			));
	}

}
