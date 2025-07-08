package com.costa.Edicola.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus (value = HttpStatus.BAD_REQUEST)
public class BigliettoExceptionAlExist extends RuntimeException{

	public BigliettoExceptionAlExist(String message) {super(message);}
	
}
