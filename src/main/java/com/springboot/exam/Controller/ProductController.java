package com.springboot.exam.Controller;

import com.springboot.exam.Model.Product;
import com.springboot.exam.Model.ProductList;
import com.springboot.exam.Model.SupplyOutput;
import com.springboot.exam.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/sortProducts")
    public List<Product> getSortedProducts(@RequestBody ProductList productList) {

        List<Product> sortedList = productService.getsortProducts(productList.getProductList());
        return  sortedList;
    }


}
