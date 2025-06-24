package com.costa.Edicola.DTO;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BigliettoDTO {
	
	@Column(name = EdicolaCostanti.ID_DATA_END_POINT)
	private Long id;
	
	@NotNull(message = "Il numero è obbligatorio")
	@Min(1)
	private Integer numero;
	
	private String dataEmissione;
	
	@NotNull(message = "Inserire tipologia: '1' Giornaliero, '2' Settimanale, '3' Mensile")
	private int tipoNum;
	@NotNull(message = "La dichiarazione della scadenza è obbligatoria")
	private int validità;
	
	private String tipo;
	
}
