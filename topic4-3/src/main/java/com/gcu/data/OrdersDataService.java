package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.util.DatabaseException;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>
{
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
		this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
    /**
     * CRUD: finder to return a single entity
     */
	public OrderEntity findById(int id)
	{
		return null;
	}

    /**
     * CRUD: finder to return all entities
     */
    public List<OrderEntity> findAll() 
    {
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
//			e.printStackTrace();
			throw new DatabaseException(e, "The Database crashed");
		}

    	// Return the List
    	return orders;
    }
    
	/**
	 * CRUD: create an entity
	 */
	public boolean create(OrderEntity order)
	{
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
			e.printStackTrace();
			throw new DatabaseException();
		}
		return true;
	}
	
	/**
	 * CRUD: update an entity
	 */
	public boolean update(OrderEntity order)
	{
		return true;
	}
	
	/**
	 * CRUD: delete an entity
	 */
	public boolean delete(OrderEntity order)
	{
		return false;
	}
}
