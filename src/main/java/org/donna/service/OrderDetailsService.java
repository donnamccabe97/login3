package org.donna.service;

import org.donna.dao.OrderDetailsDao;
import org.donna.model.OrderDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;
    
    @RequestMapping(value = "/getAllOrderDetails", method = RequestMethod.GET, params = "Accept=application/json")
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsDao.getAllOrderDetails();
    }
    
    
    @RequestMapping(value = "/getOdDetailsByOID/{oid}", method = RequestMethod.GET, params = "Accept=application/json")
    public List<OrderDetails> getOdDetailsByOID(@PathVariable("oid") String oid){
        return orderDetailsDao.getAllOrderDetailsByOrderID(Integer.parseInt(oid));
    }
    
    
    
    @RequestMapping(value = "/orderdetail", method = RequestMethod.POST)
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
        orderDetailsDao.saveOrderDetails(orderDetails);
        return orderDetails;
    }
    
}
