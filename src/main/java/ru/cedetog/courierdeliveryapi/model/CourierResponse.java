package ru.cedetog.courierdeliveryapi.model;

public record CourierResponse(
	Long id,
	String name,
	String status,
	int activeOrders,
	String vehicle
) {
}
