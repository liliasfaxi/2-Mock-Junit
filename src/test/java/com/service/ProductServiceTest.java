package com.service;

import com.dao.CustomerDao;
import com.entity.Customer;
import org.junit.Test;
import org.mockito.*;

public class ProductServiceTest {
    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private ProductService service;

    public ProductServiceTest() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addProduct() throws Exception {

    }
}
