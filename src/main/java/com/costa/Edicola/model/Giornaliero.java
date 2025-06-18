package com.costa.Edicola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "biglietti")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Giornaliero extends Biglietto {
	
	@Column(name = "tipo")
	private String tipo = "Giornaliero";
	
	@Column(name = "scadenza")
	private int giornoValidità;
	
}