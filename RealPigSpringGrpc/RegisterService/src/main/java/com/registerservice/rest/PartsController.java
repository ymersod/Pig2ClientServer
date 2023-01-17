package com.registerservice.rest;

import com.domain.Tray;
import com.persistence.RegisterDataAccess;
import com.domain.dtos.RegisterTrayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parts")
public class PartsController {

	@Autowired
	private RegisterDataAccess registerDataAccess;

	@PostMapping
	public Tray registerTray(@RequestBody RegisterTrayDto tray) {
		return registerDataAccess.registerTray(tray);
	}
}
