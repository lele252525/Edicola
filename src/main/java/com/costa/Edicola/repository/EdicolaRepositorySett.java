package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Settimanale;

import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepositorySett extends JpaRepository<Settimanale, Long> {
	
	public Optional<Settimanale> findById(Long id);
	
	@Transactional
	public void deleteById (Long id);
}
