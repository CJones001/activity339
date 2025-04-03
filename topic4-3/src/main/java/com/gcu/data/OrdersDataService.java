package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.util.DatabaseException;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>
{
	private static final Logger logger = LoggerFactory.getLogger(OrdersDataService.class);
	
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
    
	/**
     * Non-Default constructor for constructor injection. 
     */
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource)
	{
		logger.info("Entering OrdersDataService.OrdersDataService()");
        	logger.info("In the OrdersDataService.OrdersDataService()");
		this.ordersRepository = ordersRepository;
        	this.dataSource = dataSource;
	        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        	logger.info("Exiting OrdersDataService.OrdersDataService()");
	}
	
    /**
     * CRUD: finder to return a single entity
     */
	public OrderEntity findById(int id)
	{
		logger.info("Entering OrdersDataService.findById()");
        	logger.info("In the OrdersDataService.findById()");
        	logger.info("Exiting OrdersDataService.findById()");
		return null;
	}

    /**
     * CRUD: finder to return all entities
     */
    public List<OrderEntity> findAll() 
    {
	    	logger.info("Entering OrdersDataService.findAll()");
        	logger.info("In the OrdersDataService.findAll()");
		List<OrderEntity> orders = new ArrayList<OrderEntity>();

		try
		{
			// Get all all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		} 
		catch (Exception e)
		{
			// Discussion: best practices and why printing stack track here is bad
			//e.printStackTrace();
			logger.error("Error in OrdersDataService.findAll()");
			throw new DatabaseException(e, "The Database crashed");
		}

	    	// Return the List
        	logger.info("Exiting OrdersDataService.findAll()");
	    	return orders;
    }
    
	/**
	 * CRUD: create an entity
	 */
	public boolean create(OrderEntity order)
	{
		logger.info("Entering OrdersDataService.create()");
	        logger.info("In the OrdersDataService.create()");
		// Example of "overriding" the CrudRepository save() because it simply is never called
		//  You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql, 
										order.getOrderNo(), 
										order.getProductName(), 
										order.getPrice(), 
										order.getQuantity());
		} 
		catch (Exception e)
		{
			logger.error("Error in OrdersDataService.create()");
			e.printStackTrace();
			throw new DatabaseException();
		}
	        logger.info("Exiting OrdersDataService.create()");
		return true;
	}
	
	/**
	 * CRUD: update an entity
	 */
	public boolean update(OrderEntity order)
	{
		logger.info("Entering OrdersDataService.update()");
	        logger.info("In the OrdersDataService.update()");
	        logger.info("Exiting OrdersDataService.update()");
		return true;
	}
	
	/**
	 * CRUD: delete an entity
	 */
	public boolean delete(OrderEntity order)
	{
		logger.info("Entering OrdersDataService.delete()");
	        logger.info("In the OrdersDataService.delete()");
	        logger.info("Exiting OrdersDataService.delete()");
		return false;
	}
}
