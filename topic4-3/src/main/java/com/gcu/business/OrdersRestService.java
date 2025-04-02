package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderModel;
import com.gcu.model.OrderList;

@RestController
@RequestMapping("/service")
public class OrdersRestService
{
	private static final Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);
	
	@Autowired
	OrdersBusinessServiceInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		logger.info("Entering OrdersRestService.getOrdersAsJson()");
        	logger.info("Hello from the OrdersRestService.getOrdersAsJson()");
       		logger.info("Exiting OrdersRestService.getOrdersAsJson()");
        	return service.getOrders();
	}

	@GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		Logger.info("Entering OrdersRestService.getOrdersAsXml()");
		OrderList list = new OrderList();
		try{
			list.setOrders(service.getOrders());
		}catch(Exception e)
			{
				logger.error("Exception in OrdersRestService.getOrdersAsXml()", e);
			}
		logger.info("Exiting OrdersRestService.getOrdersAsXml()");
		return list;
	}
}
