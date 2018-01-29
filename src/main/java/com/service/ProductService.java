package com.service;

import com.dao.ProductDao;
import com.entity.Customer;
import com.entity.Product;

public class ProductService {
    private ProductDao productDao;

    public void addProductService(Product product, Customer customer){
        productDao.addProduct(product,customer);
    }
    public void updateProductService(Product product, Customer customer){
        productDao.updateProduct(product,customer);
    }

    public void deleteProductService( Customer customer){
        productDao.deleteProduct( customer);
    }
}
