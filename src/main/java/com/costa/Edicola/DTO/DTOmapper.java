package com.costa.Edicola.DTO;

import com.costa.Edicola.model.Giornaliero;
import com.costa.Edicola.model.Mensile;
import com.costa.Edicola.model.Settimanale;
import com.costa.Edicola.model.Utente;

public class DTOmapper {
	
	//Mapper per Giornaliero e DTO
	public static Giornaliero DtoToGiornaliero(BigliettoDTO bigliettoDTO) {
		Giornaliero giornaliero = new Giornaliero();
		giornaliero.setId(bigliettoDTO.getId());
		giornaliero.setNumero(bigliettoDTO.getNumero());
		giornaliero.getTipo();
		giornaliero.setScadenza(bigliettoDTO.getScadenza());
		return giornaliero;
	}
	
	public static BigliettoDTO giornalieroToDto(Giornaliero giornaliero) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(giornaliero.getId());
		bigliettoDTO.setNumero(giornaliero.getNumero());
		bigliettoDTO.setTipo(giornaliero.getTipo());
		bigliettoDTO.setScadenza(giornaliero.getScadenza());
		return bigliettoDTO;
	}
	
	//Mapper per Settimanale e DTO
	public static Settimanale DtoToSettimanale(BigliettoDTO bigliettoDTO) {
		Settimanale settimanale = new Settimanale();
		settimanale.setId(bigliettoDTO.getId());
		settimanale.setNumero(bigliettoDTO.getNumero());
		settimanale.getTipo();
		settimanale.setScadenza(bigliettoDTO.getScadenza());
		return settimanale;
	}
	
	public static BigliettoDTO settimanaleToDto(Settimanale settimanale) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(settimanale.getId());
		bigliettoDTO.setNumero(settimanale.getNumero());
		bigliettoDTO.setTipo(settimanale.getTipo());
		bigliettoDTO.setScadenza(settimanale.getScadenza());
		return bigliettoDTO;
	}
	
	//Mapper per Mensile e DTO
	public static Mensile DtoToMensile(BigliettoDTO bigliettoDTO) {
		Mensile mensile = new Mensile();
		mensile.setId(bigliettoDTO.getId());
		mensile.setNumero(bigliettoDTO.getNumero());
		mensile.getTipo();
		mensile.setScadenza(bigliettoDTO.getScadenza());
		return mensile;
	}
	
	public static BigliettoDTO mensileToDto(Mensile mensile) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(mensile.getId());
		bigliettoDTO.setNumero(mensile.getNumero());
		bigliettoDTO.setTipo(mensile.getTipo());
		bigliettoDTO.setScadenza(mensile.getScadenza());
		return bigliettoDTO;
	}
	
	public static Utente DtoToUser(UtenteDTO utenteDTO) {
		Utente utente = new Utente();
		utente.setId(utenteDTO.getId());
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setEta(utenteDTO.getEta());
		utente.setSesso(utenteDTO.isSesso());
		return utente;
	}
	
	public static UtenteDTO userToDto(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setId(utente.getId());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setEta(utente.getEta());
		utenteDTO.setSesso(utente.isSesso());
		return utenteDTO;
	}
	
}
