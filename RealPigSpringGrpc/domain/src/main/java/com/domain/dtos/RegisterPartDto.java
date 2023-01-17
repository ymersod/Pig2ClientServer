package com.domain.dtos;

import com.domain.PigPartType;

public class RegisterPartDto {
	private double weight;
	private PigPartType partType;
	private int pigId;

	public RegisterPartDto() {

	}

	public RegisterPartDto(double weight, PigPartType partType, int pigId) {
		this.weight = weight;
		this.partType = partType;
		this.pigId = pigId;
	}

	public double getWeight() {
		return weight;
	}

	public PigPartType getPartType() {
		return partType;
	}

	public int getPigId() {
		return pigId;
	}
}
