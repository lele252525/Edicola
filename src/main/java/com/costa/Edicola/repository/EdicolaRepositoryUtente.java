package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Utente;

import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepositoryUtente extends JpaRepository<Utente, Long> {
	
	public Optional<Utente> findById(Long id);
	
	@Transactional
	public void deleteById (Long id);
}
