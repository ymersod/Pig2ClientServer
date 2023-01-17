package com.piggyfarm.grpc.slaughterhouse;

import com.domain.Pig;
import com.piggyfarm.grpc.service.RegisterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalStation {
    @Autowired
    private RegisterServiceClient registerServiceClient;

    @Autowired
    private CuttingStation cuttingStation;

    public void registerPig(Pig pig) {
        Pig registeredPig = registerServiceClient.registerPig(pig);
        sendToCuttingStation(registeredPig);
    }

    public void sendToCuttingStation(Pig registeredPig)
    {
        cuttingStation.addPig(registeredPig);
    }
}
