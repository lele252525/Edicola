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
	@NotNull(message = "La dichiarazione della data di emissione è obbligatoria")
	private String dataEmissione;
	@NotNull(message = "La dichiarazione della tipologia è obbligatoria")
	private String tipo;
	@NotNull(message = "La dichiarazione della scadenza è obbligatoria")
	private int validità;
	
}
