package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;


@Configuration
public class SpringConfig
{
	private static final Logger logger = LoggerFactory.getLogger(SpringConfig.class);
	
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
//	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
//	@RequestScope
//	@SessionScope
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		logger.info("Entering SpringConfig.getOrdersBusiness()");
        	logger.info("In the SpringConfig.getOrdersBusiness()");
        	logger.info("Exiting SpringConfig.getOrdersBusiness()");
		return new OrdersBusinessService();
	}
}

//s$hQS8XX7shg$uL8
