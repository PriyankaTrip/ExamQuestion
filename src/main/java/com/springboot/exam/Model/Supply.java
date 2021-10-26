package com.springboot.exam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Supply {
    String productId;
    double quantity;
}
