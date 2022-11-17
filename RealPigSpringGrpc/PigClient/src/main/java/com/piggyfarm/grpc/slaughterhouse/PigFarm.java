package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PigFarm implements Runnable {

    @Autowired
    private ArrivalStation arrivalStation;

    @Override
    public void run() {
        double maxWeight = 50.0;
        while(true)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Pig pig = new Pig(Math.random()* maxWeight);
            arrivalStation.registerPig(pig);
        }
    }

}
