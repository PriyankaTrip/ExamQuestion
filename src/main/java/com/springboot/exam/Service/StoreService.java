package com.springboot.exam.Service;

import com.springboot.exam.Model.Availability;
import com.springboot.exam.Model.Capacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StoreService {

    private static List<Capacity> capacityList = new ArrayList<>();
    private static List<Availability> availabilityList = new ArrayList<>();

    public void getAvailabilityList(){
        availabilityList.add(new Availability("Store001", "Prod1", "2021-02-19", 0));
        availabilityList.add(new Availability("Store001", "Prod2", "2021-02-20", 3.0));
        availabilityList.add(new Availability("Store001", "Prod2", "2021-02-21",0));
    }
    public void getCapacityList()  {
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-19", 0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-20", 2.0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-21", 2.0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-22", 0));
    }

    @Async
    public CompletableFuture<Availability> getAvailability(String storeNo) {
        Optional<Availability> first = availabilityList.stream().filter(i -> i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(first.get());
    }

    @Async
    public CompletableFuture<Capacity> getCapacity(String storeNo) {
        Optional<Capacity> first = capacityList.stream().filter(i -> i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(first.get());
    }

    public String getStatus(String reqDate){
        double availability = 0;
        availability = availabilityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getAvailQty()).sum();

        double capacity = 0;
        capacity = capacityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getNoOfOrdersAccepted()).sum();

        if(availability == 0 && capacity ==0)
            return "No Content";
        else if(capacity ==0)            //availability>0 && capacity==0
            return "No Capacity";
        else if(availability==0)        //availability==0 && capacity>0
            return "No Availability";
        else                           //availability>0 && capacity>0
            return "Available";
    }
}


