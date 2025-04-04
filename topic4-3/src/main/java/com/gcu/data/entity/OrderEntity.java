package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity
{
	@Id
	Long id;
	
	@Column("ORDER_NO")
	String orderNo;
	
	@Column("PRODUCT_NAME")
	String productName;
	
	@Column("PRICE")
	float price;
	
	@Column("QUANTITY")
	int quantity;
	
	public OrderEntity()
	{
		
	}
	public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) 
	{
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}
	
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	
	public float getPrice() 
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
}
