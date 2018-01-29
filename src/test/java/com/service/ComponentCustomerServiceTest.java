package com.service;

import com.dao.CustomerDao;
import com.dao.ProductDao;
import com.entity.Customer;
import com.entity.Product;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class ComponentCustomerServiceTest {
    @Mock
    private ProductService productService;
    @InjectMocks
    private CustomerService customerService;
    @Captor
    private ArgumentCaptor<Customer> customerArgument;
    @Captor
    private ArgumentCaptor<Product> productArgumentCaptor;
    public ComponentCustomerServiceTest() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProductTest() throws Exception {
        doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 1 && arguments[0] != null && arguments[1] != null) {

                    Customer customer = (Customer) arguments[1];
                    Product product = (Product) arguments[0];
                    customer.setProduct(product);

                }
                return null;
            }
        }).when(productService).addProductService(any(Product.class), any(Customer.class));
        customerService.assignProduct(new Customer(), new Product());
        verify(productService).addProductService(productArgumentCaptor.capture(), customerArgument.capture());
        assertThat(customerArgument.getValue().getProduct(), is(notNullValue()));
    }
}
