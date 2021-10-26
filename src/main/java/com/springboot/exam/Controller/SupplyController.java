package com.springboot.exam.Controller;

import com.springboot.exam.Model.StoreOutput;
import com.springboot.exam.Model.SupplyInput;
import com.springboot.exam.Model.SupplyOutput;
import com.springboot.exam.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyController {

    @Autowired
    public SupplyService supplyService;

    @PostMapping("/getAvailability")
    public ResponseEntity<SupplyOutput> getAvailability(@RequestBody SupplyInput demandInput)
    {
        supplyService.setSupplyList();
        supplyService.setDemandList();
        double availability = supplyService.getAvailability(demandInput.getProductId());
        if(availability!=0)
        {
            SupplyOutput demandResponse=new SupplyOutput(demandInput.getProductId(),availability);
            return new ResponseEntity<SupplyOutput>(demandResponse,HttpStatus.OK);
        }
        return new ResponseEntity<SupplyOutput>(HttpStatus.NO_CONTENT);
    }

}

