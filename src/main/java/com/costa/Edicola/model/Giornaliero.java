package com.costa.Edicola.model;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = EdicolaCostanti.BIGLIETTI_END_POINT)
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Giornaliero extends Biglietto {
	
	@Column(name = EdicolaCostanti.ID_GIORNALIERO_DATA_END_POINT)
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = EdicolaCostanti.TIPO_END_POINT)
	private String tipo = "Giornaliero";
	
	@Column(name = EdicolaCostanti.SCADENZA_END_POINT)
	private int scadenza;
	
}