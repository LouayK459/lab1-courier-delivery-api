package ru.cedetog.courierdeliveryapi.model;

import java.util.List;

public record ApiInfoResponse(
	String project,
	String description,
	String version,
	List<String> endpoints
) {
}
