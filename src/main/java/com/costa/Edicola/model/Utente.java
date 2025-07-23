package com.costa.Edicola.model;

import java.time.LocalDateTime;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = EdicolaCostanti.ID_UTENTE_END_POINT)
	private Long id;
	
	@NotNull
	@Column(name = EdicolaCostanti.NOME_END_POINT)
	private String nome;
	@NotNull
	@Column(name = EdicolaCostanti.COGNOME_END_POINT)
	private String cognome;
	@NotNull
	@Column(name = EdicolaCostanti.ETA_END_POINT)
	private int eta;
	@NotNull
	@Column(name = EdicolaCostanti.SESSO_END_POINT)
	private boolean sesso;
	@Column(name = EdicolaCostanti.DATA_ISCRIZIONE_END_POINT)
	private LocalDateTime dataIscrizione;
	
}
