package com.sf.frs.main.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DataNotFound  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataNotFound (String message) {
		super(message);
	}

}
 