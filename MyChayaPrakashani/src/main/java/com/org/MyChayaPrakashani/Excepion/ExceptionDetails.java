package com.org.MyChayaPrakashani.Excepion;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionDetails {
	private Date timeStamp;
	private String message;
	private String details;
	private String path;
}