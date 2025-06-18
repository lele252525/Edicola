package com.costa.Edicola.service;

import com.costa.Edicola.DTO.BigliettoDTO;

public interface EdicolaService {
	
	public BigliettoDTO controlloGiorno(BigliettoDTO bigliettoDTO);
	public BigliettoDTO controlloSettimana(BigliettoDTO bigliettoDTO);
	public BigliettoDTO controlloMese(BigliettoDTO bigliettoDTO);
	
}
