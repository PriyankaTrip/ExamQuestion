package com.springboot.exam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreOutput {
    private StoreInput storeInput;
    private String status;
}
