package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
	private static final Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);
	
	@Autowired
	OrdersDataService service;
	
	@Override
	public void init()
	{
		logger.info("Entering OrdersBusinessService.init()");
        	logger.info("In the OrdersBusinessService.init()");
        	logger.info("Exiting OrdersBusinessService.init()");
		System.out.println("In the OrdersBusinessService.init()");
	}
	
	@Override
	public void destroy()
	{
		logger.info("Entering OrdersBusinessService.destroy()");
       		logger.info("In the OrdersBusinessService.destroy()");
        	logger.info("Exiting OrdersBusinessService.destroy()");
		System.out.println("In the OrdersBusinessService.destroy()");
	}

	@Override
	public void test()
	{
		logger.info("Entering OrdersBusinessService.test()");
        	logger.info("Hello from the OrdersBusinessService");
        	logger.info("Exiting OrdersBusinessService.test()");
		System.out.println("Hello from the OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders()
	{
		logger.info("Entering OrdersBusinessService.getOrders()");
	    	// Get all all the Entity Orders
	    	List<OrderEntity> ordersEntity = service.findAll();
	    	
	    	// Iterate over the Entity Model Orders and create a list of Application Model Orders
	    	List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
	    	for(OrderEntity entity : ordersEntity)
	    	{    		
	    		ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
	    	}

		logger.info("Exiting OrdersBusinessService.getOrders()");
	    	// Return list of Application Model Orders
	    	return ordersDomain;
	}
}
