package com.costa.Edicola.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings ("serial")
@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class BigliettoExceptionNotExist extends RuntimeException {
	
	public BigliettoExceptionNotExist (String message) {super(message);}
	
}
