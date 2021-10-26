package com.springboot.exam.Controller;

import com.springboot.exam.Model.Availability;
import com.springboot.exam.Model.Capacity;
import com.springboot.exam.Model.StoreInput;
import com.springboot.exam.Model.StoreOutput;
import com.springboot.exam.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StoreConrtroller {

    @Autowired
    private StoreService storeService;

    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreOutput> getProductAvailability(@RequestBody StoreInput storeInput){
        storeService.getAvailabilityList();
        storeService.getCapacityList();
        CompletableFuture<Availability> availabilityCompletableFuture=storeService.getAvailability(storeInput.getStoreNo());
        CompletableFuture<Capacity> capacityCompletableFuture=storeService.getCapacity(storeInput.getStoreNo());
        CompletableFuture.allOf(availabilityCompletableFuture,capacityCompletableFuture);
        String status = storeService.getStatus(storeInput.getReqDate());
        if(status.equals("No Capacity") || status.equals("No Availability") || status.equals("Available")){
            StoreOutput storeOutput = new StoreOutput(storeInput,status);
            return new ResponseEntity<StoreOutput>(storeOutput, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
