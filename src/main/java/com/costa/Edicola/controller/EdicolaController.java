package com.costa.Edicola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.costa.Edicola.DTO.BigliettoDTO;
import com.costa.Edicola.DTO.ResponseDTO;
import com.costa.Edicola.costanti.EdicolaCostanti;
import com.costa.Edicola.repository.EdicolaRepository;
import com.costa.Edicola.service.EdicolaService;


@RestController
@RequestMapping(path = EdicolaCostanti.INGRESSO_END_POINT)
@Validated
public class EdicolaController {
	
	@Autowired
	EdicolaRepository ediRepo;
	@Autowired
	EdicolaService ediService;
	
	@PostMapping(EdicolaCostanti.NUOVO_BIGL_END_POINT)
	public ResponseEntity<ResponseDTO> creaBiglietto (BigliettoDTO bigliettoDTO) {
		
		return null;
		
	}
	
}
