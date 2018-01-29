package com.service;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.entity.Product;

import java.util.UUID;



public class CustomerService {



    private CustomerDao dao;

    private ProductService productService;

    public void register(Customer customer){

        customer.setToken(generateToken());
        dao.save(customer);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    public Customer addCustomer(Customer customer) {
        try{
            return dao.save(customer);
        }catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public Customer changeEmail(Customer customer, String newEmail) throws RuntimeException {
        dao.updateEmail(customer , newEmail);
        return customer;
    }
    public void assignProduct(Customer customer, Product product){
        productService.addProductService(product, customer);
    }
    public void updateProduct(Customer customer, Product product){
        productService.updateProductService(product,customer);
    }
    public void deleteProduct(Customer customer){
        productService.deleteProductService(customer);
    }

}
