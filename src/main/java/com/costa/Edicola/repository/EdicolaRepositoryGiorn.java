package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Giornaliero;

import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepositoryGiorn extends JpaRepository<Giornaliero, Long> {
	
	public Optional<Giornaliero> findById(Long id);
	
	@Transactional
	public void deleteById (Long id);
}
