package com.domain.dtos;

public class RegisterPigDto {
	private double weight;
	private String origin;
	public RegisterPigDto() {

	}

	public RegisterPigDto(double weight, String origin) {
		this.weight = weight;
		this.origin = origin;
	}

	public double getWeight() {
		return weight;
	}

	public String getOrigin() {
		return origin;
	}
}
