package com.costa.Edicola.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BigliettoDTO {
	
	@Column(name = "id_biglietti")
	private Long id;
	
	@NotNull(message = "Il numero è obbligatorio")
	@Min(1)
	private int numero;
	
	private String dataEmissione;
	
	@NotNull(message = "Inserire tipologia: '1' Giornaliero, '2' Settimanale, '3' Mensile")
	private int tipoNum;
	@NotNull(message = "La dichiarazione della scadenza è obbligatoria")
	private int validità;
	
	private String tipo;
	
}
