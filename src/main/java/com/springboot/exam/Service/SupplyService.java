package com.springboot.exam.Service;

import com.springboot.exam.Model.Demand;
import com.springboot.exam.Model.Supply;
import com.springboot.exam.Model.SupplyInput;
import com.springboot.exam.Model.SupplyOutput;
import org.springframework.stereotype.Service;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyService {

    private static List<Supply> supplyList = new ArrayList<>();
    private static List<Demand> demandList = new ArrayList<>();

    public void setSupplyList(){
        supplyList.add(new Supply("Product1",10.0));
        supplyList.add(new Supply("Product2",5.0));
    }

    public void setDemandList(){
        demandList.add(new Demand("Product1",2.0));
        demandList.add(new Demand("Product2",5.0));
    }

    public double getAvailability(String productId) {
        double demand=demandList.stream().filter(i->i.getProductId().equals(productId)).mapToDouble(i-> i.getQuantity()).sum();
        double supply=supplyList.stream().filter(i->i.getProductId().equals(productId)).mapToDouble(i->i.getQuantity()).sum();
        return(supply-demand);
    }

    }

