package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface
{
	@Override
	public void init()
	{
		System.out.println("In the AnotherOrdersBusinessService.init()");
	}
	
	@Override
	public void destroy()
	{
		System.out.println("In the AnotherOrdersBusinessService.destroy()");
	}

	@Override
	public void test()
	{
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders()
	{
		// Create some Orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "0000000001", "Another Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Another Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "0000000003", "Another Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "0000000004", "Another Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "0000000005", "Another Product 5", 5.00f, 5));
		
		// Return the list of Orders
		return orders;
	}
}
