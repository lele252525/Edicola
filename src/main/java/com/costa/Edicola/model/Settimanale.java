package com.costa.Edicola.model;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Settimanale extends Biglietto {
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = EdicolaCostanti.ID_DATA_END_POINT)
	private Long id;
	
	@Column(name = EdicolaCostanti.TIPO_END_POINT)
	private String tipo = "Settimanale";
	
	@Column(name = EdicolaCostanti.SCADENZA_END_POINT)
	private int settimanaValidità;
	
}