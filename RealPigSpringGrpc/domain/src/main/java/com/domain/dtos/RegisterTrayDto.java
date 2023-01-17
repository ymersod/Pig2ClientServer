package com.domain.dtos;

import java.util.List;

public class RegisterTrayDto {
	private String trayId;
	private double weight;
	private List<RegisterPartDto> parts;

	public RegisterTrayDto() {

	}

	public RegisterTrayDto(String trayId, double weight, List<RegisterPartDto> parts) {
		this.trayId = trayId;
		this.weight = weight;
		this.parts = parts;
	}

	public String getTrayId() {
		return trayId;
	}

	public double getWeight() {
		return weight;
	}

	public List<RegisterPartDto> getParts() {
		return parts;
	}
}
