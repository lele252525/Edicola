package com.costa.Edicola.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costa.Edicola.DTO.BigliettoDTO;
import com.costa.Edicola.DTO.DTOmapper;
import com.costa.Edicola.eccezioni.BigliettoException;
import com.costa.Edicola.model.Biglietto;
import com.costa.Edicola.model.Giornaliero;
import com.costa.Edicola.model.Mensile;
import com.costa.Edicola.model.Settimanale;
import com.costa.Edicola.repository.EdicolaRepository;

@Service
public class EdicolaServiceImpl implements EdicolaService{
	
	@Autowired
	EdicolaRepository edilRepo;
	
	@Override
	public void createGiornaliero(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoException("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Giornaliero giornaliero = DTOmapper.DtoToGiornaliero(bigliettoDTO);
		giornaliero.setDataEmissione(LocalDateTime.now());
		edilRepo.save(giornaliero);
	}

	@Override
	public void createSettimanale(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoException("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Settimanale settimanale = DTOmapper.DtoToSettimanale(bigliettoDTO);
		settimanale.setDataEmissione(LocalDateTime.now());
		edilRepo.save(settimanale);
	}

	@Override
	public void createMensile(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getId() != null) {
			Optional<Biglietto> controllo = edilRepo.findById(bigliettoDTO.getId());
			if (controllo.isPresent()) {
				throw new BigliettoException("Il biglietto con il seguente numero " + bigliettoDTO.getNumero() + " è già esistente");
			}
		}
		Mensile mensile = DTOmapper.DtoToMensile(bigliettoDTO);
		mensile.setDataEmissione(LocalDateTime.now());
		edilRepo.save(mensile);
	}
	
	@Override
	public BigliettoDTO readGiornaliero(BigliettoDTO bigliettoDTO) {
		Optional<Giornaliero> giornaliero = edilRepo.findByIdGiornaliero(bigliettoDTO.getId());
		if(giornaliero.isEmpty()) {
			System.out.println("Il biglietto non esiste...");
		}
		BigliettoDTO dtoBiglietto = DTOmapper.giornalieroToDto(giornaliero.get());
		return dtoBiglietto;
	}

	@Override
	public BigliettoDTO readSettimanale(BigliettoDTO bigliettoDTO) {
		Optional<Settimanale> settimanale = edilRepo.findByIdSettimanale(bigliettoDTO.getId());
		if(settimanale.isEmpty()) {
			System.out.println("Il biglietto non esiste...");
		}
		BigliettoDTO dtoBiglietto = DTOmapper.settimanaleToDto(settimanale.get());
		return dtoBiglietto;
	}

	@Override
	public BigliettoDTO readMensile(BigliettoDTO bigliettoDTO) {
		Optional<Mensile> mensile = edilRepo.findByIdMensile(bigliettoDTO.getId());
		if(mensile.isEmpty()) {
			System.out.println("Il biglietto non esiste...");
		}
		BigliettoDTO dtoBiglietto = DTOmapper.mensileToDto(mensile.get());
		return dtoBiglietto;
	}
	
	@Override
	public BigliettoDTO controlloGiorno(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getValidità() > 31 || bigliettoDTO.getValidità() < 0) {
			throw new BigliettoException("Il giorno: " + bigliettoDTO.getValidità() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

	@Override
	public BigliettoDTO controlloSettimana(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getValidità() > 4 || bigliettoDTO.getValidità() < 0) {
			throw new BigliettoException("La settimana: " + bigliettoDTO.getValidità() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

	@Override
	public BigliettoDTO controlloMese(BigliettoDTO bigliettoDTO) {
		if(bigliettoDTO.getValidità() > 12 || bigliettoDTO.getValidità() < 0) {
			throw new BigliettoException("Il mese: " + bigliettoDTO.getValidità() + " non rientra nella cardinalità del calendario.");
		}
		return bigliettoDTO;
	}

}
