package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.OrderEntity;

public class OrderRowMapper implements RowMapper<OrderEntity>
{ 
	private static final Logger logger = LoggerFactory.getLogger(OrderRowMapper.class);

	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNumber) throws SQLException 
	{
		logger.info("Entering OrderRowMapper.mapRow()");
	        logger.info("In the OrderRowMapper.mapRow()");
	        logger.info("Exiting OrderRowMapper.mapRow()");
		return new OrderEntity(rs.getLong("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY"));    
	}
 }

