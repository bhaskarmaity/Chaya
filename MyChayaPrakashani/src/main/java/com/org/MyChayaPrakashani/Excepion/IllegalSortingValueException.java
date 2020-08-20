package com.org.MyChayaPrakashani.Excepion;

public class IllegalSortingValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalSortingValueException()	{
		super("Illegal Sorting Value Exception");
	}
	
	public IllegalSortingValueException(String msg)	{
		super(msg);
	}
}
