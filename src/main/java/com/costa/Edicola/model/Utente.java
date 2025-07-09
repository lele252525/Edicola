package com.costa.Edicola.model;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = EdicolaCostanti.UTENTE_END_POINT)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
	
	private Long id;
	
	private String nome;
	
	private String cognome;
	
}
