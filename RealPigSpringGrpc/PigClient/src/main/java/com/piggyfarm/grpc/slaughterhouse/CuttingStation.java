package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Part;
import com.piggyfarm.grpc.model.Pig;
import com.piggyfarm.grpc.model.PigPart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class CuttingStation implements Runnable {
	private List<Pig> pigs;

	public CuttingStation() {
		this.pigs = new ArrayList<>();
	}

	@Override
	public void run() {
		while (true) {
			if (!pigs.isEmpty()) {
				Pig pig = pigs.remove(0);
				System.out.println("Cutting pig " + pig.getId());

				sleep(1000);
			}
		}
	}

	public void addPig(Pig pig) {
		this.pigs.add(pig);
	}

	private HashMap<PigPart, Part> cutPig(Pig pig) {
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

		// store the parts in a list
		List<Part> parts = Arrays.asList(
				head,
				ribs1,
				ribs2,
				leg1,
				leg2,
				leg3,
				leg4,
				bottom
		);

		System.out.println("Cutting pig " + pigId);
		sleep(5000);
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
