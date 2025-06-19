package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Biglietto;
import com.costa.Edicola.model.Giornaliero;
import com.costa.Edicola.model.Mensile;
import com.costa.Edicola.model.Settimanale;

import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepository extends JpaRepository<Biglietto, Long> {
	
	public Optional<Giornaliero> findByNumeroGiornaliero(int numero);
	public Optional<Settimanale> findByMuneroSettimanale(int numero);
	public Optional<Mensile> findByNumeroMensile(int numero);
	
	@Transactional
	public void deleteById (Long id);
	
}
