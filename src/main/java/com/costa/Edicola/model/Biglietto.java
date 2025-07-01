package com.costa.Edicola.model;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.costa.Edicola.costanti.EdicolaCostanti;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class Biglietto {
	
	@Id
	private Long id;
	
	@Column(name = EdicolaCostanti.NUMERO_DATA_END_POINT)
	private Integer numero;
	@Column(name = EdicolaCostanti.DATA_EMISSIONE_END_POINT)
	private LocalDateTime dataEmissione;
	
}
