package com.costa.Edicola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.costa.Edicola.DTO.BigliettoDTO;
import com.costa.Edicola.DTO.ResponseDTO;
import com.costa.Edicola.DTO.UtenteDTO;
import com.costa.Edicola.costanti.EdicolaCostanti;
import com.costa.Edicola.repository.EdicolaReposBigl;
import com.costa.Edicola.repository.EdicolaRepositoryUtente;
import com.costa.Edicola.service.EdicolaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = EdicolaCostanti.INGRESSO_END_POINT)
@Validated
public class EdicolaController {
	
	@Autowired
	EdicolaReposBigl edilRepo;
	@Autowired
	EdicolaRepositoryUtente edilUser;
	@Autowired
	EdicolaService edilService;
	
	@PostMapping(EdicolaCostanti.NUOVO_BIGL_END_POINT)
	public ResponseEntity<ResponseDTO> creaBiglietto (@Valid @RequestBody BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getTipoNum() == 1) {
			edilService.controlloGiorno(bigliettoDTO);
			edilService.createGiornaliero(bigliettoDTO);
		}else if(bigliettoDTO.getTipoNum() == 2) {
			edilService.controlloSettimana(bigliettoDTO);
			edilService.createSettimanale(bigliettoDTO);
		} else if(bigliettoDTO.getTipoNum() == 3) {
			edilService.controlloMese(bigliettoDTO);
			edilService.createMensile(bigliettoDTO);
		} else {
			System.out.println("Inserire correttamente la tipologia del biglietto");
		}
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDTO(EdicolaCostanti.STATUS_201, EdicolaCostanti.STATUS_201_MESSAGE));
	}
	
	@GetMapping(EdicolaCostanti.LEGGI_BIGL_END_POINT)
	public ResponseEntity<BigliettoDTO> leggiBiglietto (@RequestParam Long id) {
		BigliettoDTO bigliettoDTO = edilService.readBiglietto(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bigliettoDTO);
	}
	
	@DeleteMapping(EdicolaCostanti.CANC_BIGL_END_POINT)
	public ResponseEntity<ResponseDTO> cancellaBiglietto (@RequestParam Long id) {
		edilRepo.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseDTO(EdicolaCostanti.STATUS_200, EdicolaCostanti.STATUS_200_MESSAGE));
	}
	
	@PostMapping(EdicolaCostanti.NEW_USER_END_POINT)
	public ResponseEntity<ResponseDTO> creaUtente (@Valid @RequestBody UtenteDTO utenteDTO) {
		edilService.createUser(utenteDTO);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseDTO(EdicolaCostanti.STATUS_202, EdicolaCostanti.STATUS_202_MESSAGE));	
	}
	
	@GetMapping(EdicolaCostanti.READ_USER_END_POINT)
	public ResponseEntity<UtenteDTO> leggiUtente (@RequestParam Long id) {
		UtenteDTO utenteDTO = edilService.readUser(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(utenteDTO);
	}
	
	@DeleteMapping(EdicolaCostanti.DEL_USER_END_POINT)
	public ResponseEntity<ResponseDTO> cancellaUtente (@RequestParam Long id) {
		edilUser.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseDTO(EdicolaCostanti.STATUS_200, EdicolaCostanti.STATUS_200_MESSAGE));
	}
	
}
