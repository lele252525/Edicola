package com.costa.Edicola.eccezioni;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UtenteExceptionAlExist extends RuntimeException{
	
	public UtenteExceptionAlExist(String message) {super(message);}
}
