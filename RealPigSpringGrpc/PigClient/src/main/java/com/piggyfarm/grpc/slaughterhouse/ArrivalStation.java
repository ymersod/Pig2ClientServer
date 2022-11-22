package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.service.PigService;
import com.piggyfarm.grpc.model.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalStation {
    @Autowired
    private PigService pigService;

    @Autowired
    private CuttingStation cuttingStation;

    public void registerPig(Pig pig) {
        Pig registeredPig = pigService.registerPig(pig);
        sendToCuttingStation(registeredPig);
    }

    public void sendToCuttingStation(Pig registeredPig)
    {
        cuttingStation.addPig(registeredPig);
    }
}
