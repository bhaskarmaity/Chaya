package com.org.MyChayaPrakashani.Excepion;

public class DuplicateEntryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateEntryException(String message)	{
		super(message);
	}
	public DuplicateEntryException(){
		super("Already Exists Exception");
	}
}
