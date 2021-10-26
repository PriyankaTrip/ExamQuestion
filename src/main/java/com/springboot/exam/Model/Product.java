package com.springboot.exam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    String productId;
    String productName;
    String unitOfMeasure;
    String launchDate;
}
