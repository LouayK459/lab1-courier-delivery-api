package ru.cedetog.courierdeliveryapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.cedetog.courierdeliveryapi.model.CourierResponse;
import ru.cedetog.courierdeliveryapi.model.DeliveryOrderResponse;

@Service
public class DemoDeliveryService {

	private final List<CourierResponse> couriers = List.of(
		new CourierResponse(1L, "Ivan Petrov", "ON_DELIVERY", 2, "Bicycle"),
		new CourierResponse(2L, "Anna Smirnova", "AVAILABLE", 0, "Scooter"),
		new CourierResponse(3L, "Maksim Sokolov", "SHIFT_ENDED", 0, "Car")
	);

	private final List<DeliveryOrderResponse> orders = List.of(
		new DeliveryOrderResponse(
			101L,
			"Olga Ivanova",
			"Lenina 10",
			"ON_THE_WAY",
			"Ivan Petrov",
			"10:00-12:00"
		),
		new DeliveryOrderResponse(
			102L,
			"Pavel Smirnov",
			"Gagarina 25",
			"ASSIGNED",
			"Ivan Petrov",
			"12:00-14:00"
		),
		new DeliveryOrderResponse(
			103L,
			"Roman Kozlov",
			"Sovetskaya 7",
			"DELIVERED",
			"Anna Smirnova",
			"Delivered at 09:35"
		)
	);

	public List<CourierResponse> getCouriers() {
		return couriers;
	}

	public Optional<CourierResponse> findCourierById(Long id) {
		return couriers.stream()
			.filter(courier -> courier.id().equals(id))
			.findFirst();
	}

	public List<DeliveryOrderResponse> getOrders() {
		return orders;
	}

	public List<DeliveryOrderResponse> getActiveOrders() {
		return orders.stream()
			.filter(order -> !"DELIVERED".equals(order.status()))
			.toList();
	}

}
