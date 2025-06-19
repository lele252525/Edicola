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
	@NotNull(message = "Inserire '1' per Giornaliero; '2' per Settimanale; '3' per Mensile")
	private String tipo;
	@NotNull(message = "La dichiarazione della scadenza è obbligatoria")
	private int validità;
	
}
