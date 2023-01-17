package com.domain.dtos;

import com.domain.PigPartType;

import java.util.List;

public class RegisterTrayDto {
	private String trayId;
	private double weight;

	private PigPartType partType;
	private List<RegisterPartDto> parts;

	public RegisterTrayDto() {

	}

	public RegisterTrayDto(String trayId, PigPartType partType, double weight, List<RegisterPartDto> parts) {
		this.trayId = trayId;
		this.partType = partType;
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

	public PigPartType getPartType() {
		return partType;
	}
}
