package com.piggyfarm.grpc.slaughterhouse;

import com.domain.Part;
import com.domain.Pig;
import com.domain.PigPartType;
import com.domain.Tray;
import com.piggyfarm.grpc.service.RegisterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuttingStation implements Runnable {

	@Autowired
	private RegisterServiceClient registerServiceClient;

	@Autowired
	private PackingStation packingStation;
	private final Queue<Pig> pigs;
	private final HashMap<PigPartType, Tray> trays;

	public CuttingStation() {
		pigs = new ArrayDeque<>();
		trays = new HashMap<>();

		for (PigPartType part:PigPartType.values()) {
			trays.put(part, new Tray(part));
		}

		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			if (!pigs.isEmpty()) {
				Pig pig = pigs.remove();
				List<Part> parts = cutPig(pig);
				parts.forEach(this::addPartToTray);
			}
		}
	}

	public void addPig(Pig pig) {
		System.out.println(pig);
		pigs.add(pig);
	}

	private List<Part> cutPig(Pig pig) {
		// store some values
		int pigId = pig.getId();
		double pigWeight = pig.getWeight();

		// calculate the weight of each part
		double headWeight = pigWeight * 0.10;
		double ribsWeight = pigWeight * 0.20; // 2 ribs
		double legWeight = pigWeight * 0.025; // 4 legs
		double bottomWeight = pigWeight * 0.50;

		// create the parts
		Part head = new Part(headWeight, pigId, PigPartType.HEAD);

		Part ribs1 = new Part(ribsWeight, pigId, PigPartType.RIBS);
		Part ribs2 = new Part(ribsWeight, pigId, PigPartType.RIBS);

		Part leg1 = new Part(legWeight, pigId, PigPartType.LEG);
		Part leg2 = new Part(legWeight, pigId, PigPartType.LEG);
		Part leg3 = new Part(legWeight, pigId, PigPartType.LEG);
		Part leg4 = new Part(legWeight, pigId, PigPartType.LEG);

		Part bottom = new Part(bottomWeight, pigId, PigPartType.BOTTOM);

		System.out.println("Cutting pig: " + pigId);
		sleep(5000);

		return Arrays.asList(head, ribs1, ribs2, leg1, leg2, leg3, leg4, bottom);
	}

	private void addPartToTray(Part part) {
		try {
			Tray tray = trays.get(part.getPartType());
			tray.addPart(part);
		} catch (RuntimeException e) {
			Tray oldTray = replaceTray(part.getPartType());
			sendTray(oldTray);
		}

		System.out.println("Adding part: to tray of type: " + part.getPartType());
		sleep(1000);
	}

	private void sendTray(Tray tray) {
		Tray trayFromDB = registerServiceClient.registerTray(tray);

		packingStation.recieveTray(trayFromDB);
		System.out.println("Sending tray: " + trayFromDB.getId() + ", to next station");
		sleep(1000);
	}

	// returns old tray
	private Tray replaceTray(PigPartType pigPart) {
		Tray tray = trays.remove(pigPart);
		trays.put(pigPart, new Tray(pigPart));
		return tray;
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
