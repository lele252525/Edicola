package com.costa.Edicola.DTO;

import com.costa.Edicola.model.Giornaliero;
import com.costa.Edicola.model.Mensile;
import com.costa.Edicola.model.Settimanale;

public class DTOmapper {
	
	//Mapper per Giornaliero e DTO
	public static Giornaliero DtoToGiornaliero(BigliettoDTO bigliettoDTO) {
		Giornaliero giornaliero = new Giornaliero();
		giornaliero.setId(bigliettoDTO.getId());
		giornaliero.setNumero(bigliettoDTO.getNumero());
		giornaliero.setTipo(bigliettoDTO.getTipo());
		giornaliero.setGiornoValidità(bigliettoDTO.getValidità());
		return giornaliero;
	}
	
	public static BigliettoDTO giornalieroToDto(Giornaliero giornaliero) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(giornaliero.getId());
		bigliettoDTO.setNumero(giornaliero.getNumero());
		bigliettoDTO.setTipo(giornaliero.getTipo());
		bigliettoDTO.setValidità(giornaliero.getGiornoValidità());
		return bigliettoDTO;
	}
	
	//Mapper per Settimanale e DTO
	public static Settimanale DtoToSettimanale(BigliettoDTO bigliettoDTO) {
		Settimanale settimanale = new Settimanale();
		settimanale.setId(bigliettoDTO.getId());
		settimanale.setNumero(bigliettoDTO.getNumero());
		settimanale.setTipo(bigliettoDTO.getTipo());
		settimanale.setSettimanaValidità(bigliettoDTO.getValidità());
		return settimanale;
	}
	
	public static BigliettoDTO settimanaleToDto(Settimanale settimanale) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(settimanale.getId());
		bigliettoDTO.setNumero(settimanale.getNumero());
		bigliettoDTO.setTipo(settimanale.getTipo());
		bigliettoDTO.setValidità(settimanale.getSettimanaValidità());
		return bigliettoDTO;
	}
	
	//Mapper per Mensile e DTO
	public static Mensile DtoToMensile(BigliettoDTO bigliettoDTO) {
		Mensile mensile = new Mensile();
		mensile.setId(bigliettoDTO.getId());
		mensile.setNumero(bigliettoDTO.getNumero());
		mensile.setTipo(bigliettoDTO.getTipo());
		mensile.setMeseValidità(bigliettoDTO.getValidità());
		return mensile;
	}
	
	public static BigliettoDTO mensileToDto(Mensile mensile) {
		BigliettoDTO bigliettoDTO = new BigliettoDTO();
		bigliettoDTO.setId(mensile.getId());
		bigliettoDTO.setNumero(mensile.getNumero());
		bigliettoDTO.setTipo(mensile.getTipo());
		bigliettoDTO.setValidità(mensile.getMeseValidità());
		return bigliettoDTO;
	}
	
}
