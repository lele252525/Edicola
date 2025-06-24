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
import com.costa.Edicola.repository.EdicolaReposBigl;
import com.costa.Edicola.repository.EdicolaRepositoryGiorn;
import com.costa.Edicola.repository.EdicolaRepositoryMens;
import com.costa.Edicola.repository.EdicolaRepositorySett;

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
		edilRepoGiorn.save(giornaliero);
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
		edilRepoSett.save(settimanale);
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
