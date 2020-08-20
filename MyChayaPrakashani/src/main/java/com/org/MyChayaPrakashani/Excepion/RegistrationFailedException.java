package com.org.MyChayaPrakashani.Excepion;

public class RegistrationFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegistrationFailedException(String message)
	{
		super(message);
	}

}
