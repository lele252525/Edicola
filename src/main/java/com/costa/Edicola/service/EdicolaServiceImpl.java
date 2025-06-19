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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMensile(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readGiornaliero(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSettimanale(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMensile(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGiornaliero(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSettimanale(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMensile(BigliettoDTO bigliettoDTO) {
		// TODO Auto-generated method stub
		
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
