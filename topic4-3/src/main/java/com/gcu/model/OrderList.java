package com.gcu.model;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
public class OrderList
{
	private static final Logger logger = LoggerFactory.getLogger(OrderList.class);
	
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	 
	@XmlElement(name="order")
	public List<OrderModel> getOrders()
    {
	logger.info("Entering OrderList.getOrders()");
        logger.info("In the OrderList.getOrders()");
        logger.info("Exiting OrderList.getOrders()");
        return this.orders;
    }
 
   public void setOrders(List<OrderModel> orders)
    {
	logger.info("Entering OrderList.setOrders()");
        logger.info("In the OrderList.setOrders()");
        logger.info("Exiting OrderList.setOrders()");
        this.orders = orders;
    }
}
