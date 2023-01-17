package com.persistence;

import com.domain.Pig;
import com.domain.Product;
import com.domain.Tray;
import com.domain.dtos.RegisterPigDto;
import com.domain.dtos.RegisterProductDto;
import com.domain.dtos.RegisterTrayDto;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDataAccess {
		Product registerProduct(RegisterProductDto product);
		Pig registerPig(RegisterPigDto pig);
		Tray registerTray(RegisterTrayDto tray);
}
