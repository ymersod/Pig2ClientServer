package com.piggyfarm.grpc.slaughterhouse;

import com.domain.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PigFarm implements Runnable {

    @Autowired
    private ArrivalStation arrivalStation;

    public PigFarm()
    {
        new Thread(this).start();
    }

    @Override
    public void run() {
        double weightRange = 19.0;
        double minWeight = 80.0;

        while(true)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Pig pig = new Pig(Math.floor(Math.random() * weightRange + minWeight));
            arrivalStation.registerPig(pig);
        }
    }

}
