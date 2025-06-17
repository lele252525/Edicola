package com.costa.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Biglietto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "numero")
	private int numero;
	@Column(name = "data_emissione")
	private String dataEmissione;
	
}
