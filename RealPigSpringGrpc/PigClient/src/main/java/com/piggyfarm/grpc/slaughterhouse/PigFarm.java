package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PigFarm implements Runnable {

    @Autowired
    private ArrivalStation arrivalStation;

    public PigFarm()
    {
        run();
    }

    @Override
    public void run() {
        double maxWeight = 30.0;
        while(true)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Pig pig = new Pig(Math.random()* maxWeight+ 90.0);
            arrivalStation.registerPig(pig);
        }
    }

}
