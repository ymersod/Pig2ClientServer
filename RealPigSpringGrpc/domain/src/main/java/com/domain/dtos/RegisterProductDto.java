package com.domain.dtos;

import com.domain.Part;

import java.util.List;

public class RegisterProductDto {
	private int id;
	private double weight;
	private List<Part> parts;

	public RegisterProductDto(int id, double weight, List<Part> parts) {
		this.id = id;
		this.weight = weight;
		this.parts = parts;
	}

	public RegisterProductDto() {
	}

	public int getId() {
		return id;
	}

	public double getWeight() {
		return weight;
	}

	public List<Part> getParts() {
		return parts;
	}
}
