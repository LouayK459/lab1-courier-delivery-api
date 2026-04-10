package ru.cedetog.courierdeliveryapi.model;

public record DeliveryOrderResponse(
	Long id,
	String recipientName,
	String address,
	String status,
	String courierName,
	String deliveryWindow
) {
}
