package com.springboot.exam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Demand {
    String productId;
    double quantity;
}
