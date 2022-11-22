package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Part;
import com.piggyfarm.grpc.model.Pig;
import com.piggyfarm.grpc.model.PigPartType;
import com.piggyfarm.grpc.model.Tray;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuttingStation implements Runnable {
	private final List<Pig> pigs;
	private final HashMap<PigPartType, Tray> trays;

	public CuttingStation() {
		pigs = new ArrayList<>();
		trays = new HashMap<>();

		run();
	}

	@Override
	public void run() {
		while (true) {
			if (!pigs.isEmpty()) {
				Pig pig = pigs.remove(0);
				List<Part> parts = cutPig(pig);
				parts.forEach(this::addPartToTray);
			}
		}
	}

	public void addPig(Pig pig) {
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

		System.out.println("Adding part: " + part.getId() + ", to tray of type: " + part.getPartType());
		sleep(1000);
	}

	private void sendTray(Tray tray) {
		// send tray to database
		// Tray trayFromDB = db.getTray;

		// send to next station
		System.out.println("Sending tray: " + tray.getId() + ", to next station");
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
