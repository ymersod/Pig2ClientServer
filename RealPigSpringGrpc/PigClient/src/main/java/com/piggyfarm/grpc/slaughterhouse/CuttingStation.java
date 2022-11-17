package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Part;
import com.piggyfarm.grpc.model.Pig;
import com.piggyfarm.grpc.model.PigPart;
import com.piggyfarm.grpc.model.Tray;

import java.util.*;

@Service
public class CuttingStation implements Runnable {
	private final List<Pig> pigs;
	private final HashMap<PigPart, Tray> trays;

	public CuttingStation() {
		pigs = new ArrayList<>();
		trays = new HashMap<>();
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
		Part head = new Part(headWeight, pigId, PigPart.HEAD);

		Part ribs1 = new Part(ribsWeight, pigId, PigPart.RIBS);
		Part ribs2 = new Part(ribsWeight, pigId, PigPart.RIBS);

		Part leg1 = new Part(legWeight, pigId, PigPart.LEG);
		Part leg2 = new Part(legWeight, pigId, PigPart.LEG);
		Part leg3 = new Part(legWeight, pigId, PigPart.LEG);
		Part leg4 = new Part(legWeight, pigId, PigPart.LEG);

		Part bottom = new Part(bottomWeight, pigId, PigPart.BOTTOM);

		System.out.println("Cutting pig " + pigId);
		sleep(5000);

		return Arrays.asList(head, ribs1, ribs2, leg1, leg2, leg3, leg4, bottom);
	}

	private void addPartToTray(Part part) {
		System.out.println("Adding part: " + part.getId() + ", to tray of type: " + part.getPigPart());
		sleep(1000);

		try {
			Tray tray = trays.get(part.getPigPart());
			tray.addPart(part);
		} catch (RuntimeException e) {
			Tray oldTray = replaceTray(part.getPigPart());
			sendTray(oldTray);
		}
	}

	private void sendTray(Tray tray) {
		// send to next station
		System.out.println("Sending tray " + tray.getId() + " to next station");
		sleep(1000);
	}

	// returns old tray
	private Tray replaceTray(PigPart pigPart) {
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
