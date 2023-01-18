package com.registerservice.rest;

import com.domain.Pig;
import com.persistence.RegisterDataAccess;
import com.domain.dtos.RegisterPigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class PigsController {

	@Autowired
	private RegisterDataAccess registerDataAccess;

	@PostMapping("/pigs")
	public Pig registerPig(@RequestBody RegisterPigDto pig) {
		return registerDataAccess.registerPig(pig);
	}



	//Kunne godt være disse metoder skulle være i andet interface end registerDataAcces eller ændre nuværende interface til noget lignende data management.  ¯\_(ツ)_/¯.
	@GetMapping("/pigs/arrival")
	public List<Pig> getPigs(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date)
	{
		return registerDataAccess.getFromDate(date);
	}

	@GetMapping("/pigs/farm")
	public List<Pig> getPigs(@RequestParam String origin)
	{
		return registerDataAccess.getFromOrigin(origin);
	}
}
