package com.gcu.util;

/**
 * Custom Database Exception
 * 
 * @author markreha
 *
 */
public class DatabaseException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * 
	 */
	public DatabaseException()
	{
		super();
	}
	
	/**
	 * Non-default constructor
	 * 
	 * @param err Wrapped exception
	 * @param errorMessage Custom exception message
	 */
	public DatabaseException(Throwable err, String errorMessage)
	{
		super(errorMessage, err);
	}
}
