package com.springboot.exam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Capacity {
    private String storeNo;
    private String productId;
    private String date;
    private double noOfOrdersAccepted;

}
