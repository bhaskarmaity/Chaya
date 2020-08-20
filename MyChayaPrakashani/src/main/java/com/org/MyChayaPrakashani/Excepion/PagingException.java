package com.org.MyChayaPrakashani.Excepion;

public class PagingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PagingException(){
		super("Something went to wrong in context of paging");
	}
	
	public PagingException(String msg){
		super(msg);
	}
}
