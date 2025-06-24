package com.costa.Edicola.service;

import com.costa.Edicola.DTO.BigliettoDTO;

public interface EdicolaService {
	
	public BigliettoDTO controlloGiorno(BigliettoDTO bigliettoDTO);
	public BigliettoDTO controlloSettimana(BigliettoDTO bigliettoDTO);
	public BigliettoDTO controlloMese(BigliettoDTO bigliettoDTO);
	
	public void createGiornaliero(BigliettoDTO bigliettoDTO);
	public void createSettimanale(BigliettoDTO bigliettoDTO);
	public void createMensile(BigliettoDTO bigliettoDTO);
	
	public BigliettoDTO readBiglietto(Long id);
	
}