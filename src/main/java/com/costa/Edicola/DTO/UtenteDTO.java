package com.costa.Edicola.DTO;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UtenteDTO {
	
	@NotNull
	@Column(name = EdicolaCostanti.ID_UTENTE_END_POINT)
	private Long id;
	
	@NotNull(message = "Il nome è obbligatorio")
	private String nome;
	@NotNull(message = "Il cognome è obbligatorio")
	private String cognome;
	@NotNull(message = "L'età è obbligatoria")
	private int eta;
	@NotNull(message = "Specificare il sesso")
	private boolean sesso;
	
}
