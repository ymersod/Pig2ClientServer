package com.registerservice.rest;

import com.domain.Pig;
import com.persistence.RegisterDataAccess;
import com.domain.dtos.RegisterPigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PigsController {

	@Autowired
	private RegisterDataAccess registerDataAccess;

	@PostMapping("/pigs")
	public Pig registerPig(@RequestBody RegisterPigDto pig) {
		System.out.println("ayo");
		return registerDataAccess.registerPig(pig);
	}
}
