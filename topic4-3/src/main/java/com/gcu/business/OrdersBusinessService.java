package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
	@Autowired
	OrdersDataService service;
	
	@Override
	public void init()
	{
		System.out.println("In the OrdersBusinessService.init()");
	}
	
	@Override
	public void destroy()
	{
		System.out.println("In the OrdersBusinessService.destroy()");
	}

	@Override
	public void test()
	{
		System.out.println("Hello from the OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders()
	{
    	// Get all all the Entity Orders
    	List<OrderEntity> ordersEntity = service.findAll();
    	
    	// Iterate over the Entity Model Orders and create a list of Application Model Orders
    	List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
    	for(OrderEntity entity : ordersEntity)
    	{    		
    		ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
    	}
    	
    	// Return list of Application Model Orders
    	return ordersDomain;
	}
}
