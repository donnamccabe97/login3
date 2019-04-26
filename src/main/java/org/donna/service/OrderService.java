package org.donna.service;

import org.donna.dao.OrderDao;
import org.donna.model.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    
    @RequestMapping(value = "/order", method = RequestMethod.GET, params = "Accept=application/json")
    public List<Orders> getAllOrders(){
        return orderDao.getAllOrders();
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Orders saveOrder(@RequestBody Orders orders){
        orderDao.saveOrder(orders);
        return orders;
    }
    
}

