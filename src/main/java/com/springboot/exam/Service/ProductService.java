package com.springboot.exam.Service;

import com.springboot.exam.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public List<Product> getsortProducts(List<Product> productList){

        List<Product> sortedProducts = productList.stream()
                .sorted(Comparator.comparing(Product::getProductId).
                        thenComparing(Product::getLaunchDate).reversed()).collect(Collectors.toList());
        return sortedProducts;
    }

}
