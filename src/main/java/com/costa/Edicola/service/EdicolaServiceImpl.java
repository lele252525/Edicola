package com.costa.Edicola.service;

import org.springframework.stereotype.Service;

import com.costa.Edicola.DTO.BigliettoDTO;
import com.costa.Edicola.eccezioni.BigliettoException;

@Service
public class EdicolaServiceImpl implements EdicolaService{
	
	
	
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
