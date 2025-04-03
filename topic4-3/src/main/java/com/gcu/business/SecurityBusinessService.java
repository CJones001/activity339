package com.gcu.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService
{
	private static final Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);

	public boolean authenticate(String username, String password)
	{
		logger.info("Entering SecurityBusinessService.authenticate()");
		System.out.println(String.format("Hello from the SecurityBusinessService with a username of %s and a password of %s", username, password));
		logger.info("Exiting SecurityBusinessService.authenticate()");
		return true;
	}
}

