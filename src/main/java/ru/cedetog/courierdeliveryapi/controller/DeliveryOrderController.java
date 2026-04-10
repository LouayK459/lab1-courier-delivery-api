package ru.cedetog.courierdeliveryapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.cedetog.courierdeliveryapi.model.DeliveryOrderResponse;
import ru.cedetog.courierdeliveryapi.service.DemoDeliveryService;

@RestController
@RequestMapping("/api/orders")
public class DeliveryOrderController {

	private final DemoDeliveryService demoDeliveryService;

	public DeliveryOrderController(DemoDeliveryService demoDeliveryService) {
		this.demoDeliveryService = demoDeliveryService;
	}

	@GetMapping
	public List<DeliveryOrderResponse> getOrders() {
		return demoDeliveryService.getOrders();
	}

	@GetMapping("/active")
	public List<DeliveryOrderResponse> getActiveOrders() {
		return demoDeliveryService.getActiveOrders();
	}

}
