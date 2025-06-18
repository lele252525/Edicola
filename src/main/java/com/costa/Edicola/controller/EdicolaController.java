package com.costa.Edicola.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import costanti.EdicolaCostanti;

@RestController
@RequestMapping(path = EdicolaCostanti.INGRESSO_END_POINT)
@Validated
public class EdicolaController {
	
	
	
}
