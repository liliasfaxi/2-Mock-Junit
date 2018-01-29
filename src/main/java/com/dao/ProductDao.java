package com.dao;

import com.entity.Customer;
import com.entity.Product;

public class ProductDao {

    public void addProduct(Product product, Customer customer){
        customer.setProduct(product);
        System.out.println("Product added to Customer");
    }
    public void updateProduct(Product newProduct, Customer customer){
        customer.setProduct(newProduct);
        System.out.println("Product updated to Customer");
    }
    public void deleteProduct(Customer customer){
        customer.setProduct(null);
        System.out.println("Product deleted");
    }

}
