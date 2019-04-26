package org.donna.service;

import org.donna.dao.CustomerDao;
import org.donna.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping(value = "/allCustomer", method = RequestMethod.GET, params = "Accept=application/json")
    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
    
}