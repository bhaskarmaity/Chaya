package com.org.MyChayaPrakashani.Excepion;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2814385304933472747L;

	public ResourceNotFoundException(String message)	{
		super(message);
	}
	public ResourceNotFoundException()	{
		super("Resource not Found");
	}
}