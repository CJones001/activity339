package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private OrdersBusinessServiceInterface service;

	@Autowired
	private SecurityBusinessService security;

	@GetMapping("/")
	public String display(Model model)
	{
		logger.info("Entering LoginController.display()");

		try{
			// Display Login Form View
			model.addAttribute("title", "Login Form");
			model.addAttribute("loginModel", new LoginModel());
		}catch(Exception e){
			logger.error("Error in LoginController.display()");
		}

		logger.info("Exiting LoginController.display()");
		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		logger.info("Entering LoginController.doLogin()");
		logger.info("Hello from LoginController.doLogin()");
	        // Check for validation errors
	        if (bindingResult.hasErrors()) 
	        {
	        	model.addAttribute("title", "Login Form");
			logger.error("Binding Result has errors, Exiting LoginController.doLogin()");
	            	return "login";
	        }
	        
	        // Make a call to the Security Business Service
	        security.authenticate(loginModel.getUsername(), loginModel.getPassword());
	        
	        // Make a call to the Orders Business Service
	        service.test();
	        
		// Get some Orders
		List<OrderModel> orders = service.getOrders();

		// Display the Orders View
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);

		logger.info("Exiting LoginController.doLogin()");
		return "orders";
	}
}


