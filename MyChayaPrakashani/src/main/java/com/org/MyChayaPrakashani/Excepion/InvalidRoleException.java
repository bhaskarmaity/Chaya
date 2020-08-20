package com.org.MyChayaPrakashani.Excepion;

public class InvalidRoleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidRoleException(String message)	{
		super(message);
	}
	public InvalidRoleException(){
		super("Not Match Exception");
	}
}
