package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Biglietto;
import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepository extends JpaRepository<Biglietto, Long> {
	
	public Optional<Biglietto> findById(Long id);
	
	@Transactional
	public void deleteById (Long id);
	
}
