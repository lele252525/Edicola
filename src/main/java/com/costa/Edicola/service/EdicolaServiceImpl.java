package com.costa.Edicola.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costa.Edicola.DTO.BigliettoDTO;
import com.costa.Edicola.DTO.DTOmapper;
import com.costa.Edicola.DTO.UtenteDTO;
import com.costa.Edicola.eccezioni.BigliettoExceptionAlExist;
import com.costa.Edicola.eccezioni.UtenteExceptionAlExist;
import com.costa.Edicola.model.Biglietto;
import com.costa.Edicola.model.Giornaliero;
import com.costa.Edicola.model.Mensile;
import com.costa.Edicola.model.Settimanale;
import com.costa.Edicola.model.Utente;
import com.costa.Edicola.repository.EdicolaReposBigl;
import com.costa.Edicola.repository.EdicolaRepositoryGiorn;
import com.costa.Edicola.repository.EdicolaRepositoryMens;
import com.costa.Edicola.repository.EdicolaRepositorySett;
import com.costa.Edicola.repository.EdicolaRepositoryUtente;

@Service
public class EdicolaServiceImpl implements EdicolaService{
	
	@Autowired
	EdicolaReposBigl edilRepo;
	@Autowired
	EdicolaRepositoryGiorn edilRepoGiorn;
	@Autowired
	EdicolaRepositorySett edilRepoSett;
	@Autowired
	EdicolaRepositoryMens edilRepoMens;
	@Autowired
	EdicolaRepositoryUtente edilRepoUser;
	
	@Override
	public void createGiornaliero(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoExceptionAlExist("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Giornaliero giornaliero = DTOmapper.DtoToGiornaliero(bigliettoDTO);
		giornaliero.setDataEmissione(LocalDateTime.now());
		edilRepoGiorn.save(giornaliero);
	}
	
	@Override
	public void createSettimanale(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoExceptionAlExist("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Settimanale settimanale = DTOmapper.DtoToSettimanale(bigliettoDTO);
		settimanale.setDataEmissione(LocalDateTime.now());
		edilRepoSett.save(settimanale);
	}
	
	@Override
	public void createMensile(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoExceptionAlExist("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Mensile mensile = DTOmapper.DtoToMensile(bigliettoDTO);
		mensile.setDataEmissione(LocalDateTime.now());
		edilRepoMens.save(mensile);
	}
	
	@Override
	public BigliettoDTO readBiglietto(Long id) {
		BigliettoDTO dtoBiglietto = new BigliettoDTO();
		Optional<Giornaliero> giornaliero = edilRepoGiorn.findById(id);
		Optional<Settimanale> settimanale = edilRepoSett.findById(id);
		Optional<Mensile> mensile = edilRepoMens.findById(id);
		if (giornaliero.isPresent()) {
			dtoBiglietto = DTOmapper.giornalieroToDto(giornaliero.get());
		} else if (settimanale.isPresent()) {
			dtoBiglietto = DTOmapper.settimanaleToDto(settimanale.get());
		} else if (mensile.isPresent()) {
			dtoBiglietto = DTOmapper.mensileToDto(mensile.get());
		} else if(giornaliero.isEmpty() && settimanale.isEmpty() && mensile.isEmpty()) {
			System.out.println("Il biglietto non esiste...");
		}
		return dtoBiglietto;
	}
	
	@Override
	public void createUser(UtenteDTO utenteDTO) {
		if(utenteDTO.getId() != null) {
			Optional<Utente> controllo = edilRepoUser.findById(utenteDTO.getId());
			if(controllo.isPresent()) {
				throw new UtenteExceptionAlExist("L'Utente è già esistente");
			}
		}
		Utente utente = DTOmapper.DtoToUser(utenteDTO);
		utente.setDataIscrizione(LocalDateTime.now());
		edilRepoUser.save(utente);
	}

	@Override
	public UtenteDTO readUser(Long id) {
		UtenteDTO dtoUtente = new UtenteDTO();
		Optional<Utente> utente = edilRepoUser.findById(id);
		if(utente.isPresent()) {
			dtoUtente = DTOmapper.userToDto(utente.get());
		} else if (utente.isEmpty()) {
			System.out.println("L'Utente è inesistente");
		}
		return dtoUtente;
	}
	
	@Override
	public BigliettoDTO controlloGiorno(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getScadenza() > 31 || bigliettoDTO.getScadenza() < 0) {
			throw new BigliettoExceptionAlExist("Il giorno: " + bigliettoDTO.getScadenza() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

	@Override
	public BigliettoDTO controlloSettimana(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getScadenza() > 4 || bigliettoDTO.getScadenza() < 0) {
			throw new BigliettoExceptionAlExist("La settimana: " + bigliettoDTO.getScadenza() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

	@Override
	public BigliettoDTO controlloMese(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getScadenza() > 12 || bigliettoDTO.getScadenza() < 0) {
			throw new BigliettoExceptionAlExist("Il mese: " + bigliettoDTO.getScadenza() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

}
